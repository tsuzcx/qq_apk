package com.tencent.oscarcamera.particlesystem;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class ParticleCloud
{
  private static final String TAG = ParticleCloud.class.getSimpleName();
  private static final HashMap<String, Object> s_params = new HashMap();
  private long[] mAttrExpressions;
  private double[] mAttrValue;
  public HashMap<String, Attribute> mAttrs = new HashMap();
  Particle mCopiedParticles = new Particle();
  long mEmitRate;
  double mLastQuotaTime;
  long mMaxCount;
  public String mName;
  Particle mParticles = new Particle();
  long mQuota;
  double[] mResultArray;
  DoubleBuffer mResultBuffer;
  public Sprite mSprite;
  Attribute[] mVarAttributes;
  private long[] mVarExpressions;
  private int[] param_offsets;
  
  private void advanceParticle(Particle paramParticle, double paramDouble)
  {
    long l;
    int j;
    int i;
    if (this.mSprite.animated == 1)
    {
      l = (int)((paramDouble - paramParticle.birth) / this.mSprite.frameDuration);
      j = (int)(l % this.mSprite.frameCount);
      if (this.mSprite.looped != 1) {
        break label65;
      }
      i = j;
    }
    for (;;)
    {
      paramParticle.currFrame = i;
      return;
      label65:
      if (this.mSprite.looped == 2)
      {
        i = j;
        if ((l / this.mSprite.frameCount & 1L) == 1L) {
          i = this.mSprite.frameCount - 1 - j;
        }
      }
      else
      {
        i = j;
        if (l >= this.mSprite.frameCount) {
          i = this.mSprite.frameCount - 1;
        }
      }
    }
  }
  
  private void computeQuota(double paramDouble)
  {
    if (this.mLastQuotaTime == 0.0D) {
      this.mLastQuotaTime = paramDouble;
    }
    for (;;)
    {
      if (this.mQuota > this.mMaxCount - this.mParticles.total) {
        this.mQuota = (this.mMaxCount - this.mParticles.total);
      }
      return;
      int i = (int)(this.mEmitRate * (paramDouble - this.mLastQuotaTime));
      if (i > 0)
      {
        this.mQuota += i;
        paramDouble = this.mLastQuotaTime;
        this.mLastQuotaTime = (i / this.mEmitRate + paramDouble);
      }
    }
  }
  
  private static Attribute createAttr(String paramString, Object paramObject)
  {
    Attribute localAttribute = new Attribute();
    localAttribute.mName = paramString;
    localAttribute.mValue = new Value(paramObject);
    if (AttributeConst.ATTR_INDEX_MAP.containsKey(paramString)) {}
    for (int i = ((Integer)AttributeConst.ATTR_INDEX_MAP.get(paramString)).intValue();; i = -1)
    {
      localAttribute.mVarIndex = i;
      return localAttribute;
    }
  }
  
  private double doubleValue(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.opt(paramString);
    if ((paramJSONObject != null) && ((paramJSONObject instanceof Number))) {
      return ((Number)paramJSONObject).doubleValue();
    }
    return 0.0D;
  }
  
  private void initParticle(Particle paramParticle, double paramDouble)
  {
    paramParticle.birth = paramDouble;
    paramParticle.tex = this.mSprite.path;
    paramParticle.frameCount = this.mSprite.frameCount;
    paramParticle.musicPlayed = false;
    paramParticle.a[2] = (this.mAttrValue[2]);
    paramParticle.a[0] = this.mAttrValue[0];
    paramParticle.a[1] = this.mAttrValue[1];
    paramParticle.a[7] = this.mAttrValue[7];
    paramParticle.a[8] = this.mAttrValue[8];
    paramParticle.a[9] = this.mAttrValue[9];
    paramParticle.a[3] = this.mAttrValue[3];
    paramParticle.a[4] = this.mAttrValue[4];
    paramParticle.a[5] = this.mAttrValue[5];
    paramParticle.a[6] = this.mAttrValue[6];
    advanceParticle(paramParticle, paramDouble);
  }
  
  private void initSprite(JSONObject paramJSONObject)
  {
    this.mSprite.path = paramJSONObject.optString("path");
    this.mSprite.frameCount = ((int)doubleValue(paramJSONObject, "frameCount"));
    this.mSprite.width = ((int)doubleValue(paramJSONObject, "width"));
    this.mSprite.height = ((int)doubleValue(paramJSONObject, "height"));
    this.mSprite.blendMode = ((int)doubleValue(paramJSONObject, "blendMode"));
    this.mSprite.animated = ((int)doubleValue(paramJSONObject, "animated"));
    this.mSprite.looped = ((int)doubleValue(paramJSONObject, "looped"));
    this.mSprite.frameDuration = doubleValue(paramJSONObject, "frameDuration");
  }
  
  private void optimized()
  {
    int i = 0;
    this.mMaxCount = (((Attribute)this.mAttrs.get("particleCountMax")).value());
    this.mEmitRate = (((Attribute)this.mAttrs.get("emissionRate")).value());
    this.mAttrExpressions = new long[10];
    this.mAttrExpressions[2] = ((Attribute)this.mAttrs.get("life")).expression();
    this.mAttrExpressions[3] = ((Attribute)this.mAttrs.get("colorR")).expression();
    this.mAttrExpressions[4] = ((Attribute)this.mAttrs.get("colorG")).expression();
    this.mAttrExpressions[5] = ((Attribute)this.mAttrs.get("colorB")).expression();
    this.mAttrExpressions[6] = ((Attribute)this.mAttrs.get("colorA")).expression();
    this.mAttrExpressions[7] = ((Attribute)this.mAttrs.get("positionX")).expression();
    this.mAttrExpressions[8] = ((Attribute)this.mAttrs.get("positionY")).expression();
    this.mAttrExpressions[9] = ((Attribute)this.mAttrs.get("positionZ")).expression();
    this.mAttrExpressions[0] = ((Attribute)this.mAttrs.get("width")).expression();
    this.mAttrExpressions[1] = ((Attribute)this.mAttrs.get("height")).expression();
    this.mAttrValue = new double[10];
    this.mAttrValue[2] = ((Attribute)this.mAttrs.get("life")).value();
    this.mAttrValue[3] = ((Attribute)this.mAttrs.get("colorR")).value();
    this.mAttrValue[4] = ((Attribute)this.mAttrs.get("colorG")).value();
    this.mAttrValue[5] = ((Attribute)this.mAttrs.get("colorB")).value();
    this.mAttrValue[6] = ((Attribute)this.mAttrs.get("colorA")).value();
    this.mAttrValue[7] = ((Attribute)this.mAttrs.get("positionX")).value();
    this.mAttrValue[8] = ((Attribute)this.mAttrs.get("positionY")).value();
    this.mAttrValue[9] = ((Attribute)this.mAttrs.get("positionZ")).value();
    this.mAttrValue[0] = ((Attribute)this.mAttrs.get("width")).value();
    this.mAttrValue[1] = ((Attribute)this.mAttrs.get("height")).value();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mAttrs.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Attribute)this.mAttrs.get(localObject);
      if (((Attribute)localObject).expression() != -1L) {
        localArrayList.add(localObject);
      }
    }
    this.mVarExpressions = new long[localArrayList.size()];
    this.mVarAttributes = new Attribute[localArrayList.size()];
    int j = localArrayList.size();
    while (i < j)
    {
      this.mVarExpressions[i] = ((Attribute)localArrayList.get(i)).expression();
      this.mVarAttributes[i] = ((Attribute)localArrayList.get(i));
      i += 1;
    }
    this.param_offsets = new int[(int)((Attribute)this.mAttrs.get("particleCountMax")).value() * 11];
  }
  
  public void createCache()
  {
    this.mResultBuffer = ByteBuffer.allocateDirect((int)(this.mMaxCount * this.mVarExpressions.length * 64L)).order(ByteOrder.nativeOrder()).asDoubleBuffer();
    this.mResultArray = new double[(int)(this.mMaxCount * this.mVarExpressions.length)];
    this.mCopiedParticles = new Particle();
    Particle localParticle = this.mCopiedParticles;
    int i = 0;
    while (i < this.mMaxCount)
    {
      localParticle.next = new Particle();
      localParticle = localParticle.next;
      i += 1;
    }
  }
  
  public void emitImmediately(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    initParticle(null, System.currentTimeMillis() / 1000.0D);
    throw new NullPointerException();
  }
  
  public Pair<Particle, ParticleExpressionBundle> getAdvanceExpression(double paramDouble)
  {
    ParticleExpressionBundle localParticleExpressionBundle = new ParticleExpressionBundle();
    Object localObject1 = this.mParticles.next;
    Object localObject2 = this.mParticles;
    while (localObject1 != null)
    {
      Particle localParticle;
      if ((localObject1.a[2] > 0.0D) && (localObject1.a[2] + ((Particle)localObject1).birth <= paramDouble))
      {
        ((Particle)localObject2).next = ((Particle)localObject1).next;
        localObject1 = ((Particle)localObject1).next;
        localParticle = this.mParticles;
        localParticle.total -= 1;
      }
      else
      {
        advanceParticle((Particle)localObject1, paramDouble);
        localParticle = ((Particle)localObject1).next;
        localObject2 = localObject1;
        localObject1 = localParticle;
      }
    }
    computeQuota(paramDouble);
    if ((this.mParticles.total < this.mMaxCount) && (this.mQuota > 0L))
    {
      long l = Math.min(this.mMaxCount - this.mParticles.total, this.mQuota);
      this.mQuota -= l;
      while (l > 0L)
      {
        initParticle((Particle)localObject1, paramDouble);
        ((Particle)localObject1).next = this.mParticles.next;
        this.mParticles.next = ((Particle)localObject1);
        localObject2 = this.mParticles;
        ((Particle)localObject2).total += 1;
        l -= 1L;
      }
    }
    localObject1 = this.mParticles.next;
    int i = 0;
    int j = this.mParticles.total;
    while (i < j)
    {
      this.param_offsets[i] = ((Particle)localObject1).param_offset;
      localObject1 = ((Particle)localObject1).next;
      i += 1;
    }
    localParticleExpressionBundle.expressions = this.mVarExpressions;
    localParticleExpressionBundle.param_line = this.mParticles.total;
    localParticleExpressionBundle.param_offsets = this.param_offsets;
    return new Pair(this.mParticles, localParticleExpressionBundle);
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleCloud
 * JD-Core Version:    0.7.0.1
 */