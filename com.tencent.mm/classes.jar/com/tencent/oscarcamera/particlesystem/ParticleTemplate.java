package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.json.JSONObject;

public class ParticleTemplate
{
  public static final String ATTR_COLOR_A;
  public static final String ATTR_COLOR_B;
  public static final String ATTR_COLOR_G;
  public static final String ATTR_COLOR_R;
  public static final String ATTR_EMIT_RATE;
  public static final String ATTR_HEIGHT;
  public static final String ATTR_LIFE;
  public static final String ATTR_MAX_COUNT;
  public static final String ATTR_POS_X;
  public static final String ATTR_POS_Y;
  public static final String ATTR_POS_Z;
  public static final String ATTR_WIDTH;
  private static final String TAG;
  String mColorA;
  String mColorB;
  String mColorG;
  String mColorR;
  double mEmitRate;
  String mHeight;
  String mLife;
  int mMaxCount;
  String mPosX;
  String mPosY;
  String mPosZ;
  public Sprite mSprite;
  private ParticleSystemEx mSystem;
  String mWidth;
  
  static
  {
    AppMethodBeat.i(81560);
    TAG = ParticleTemplate.class.getSimpleName();
    ATTR_MAX_COUNT = String.format("%s", new Object[] { "particleCountMax" });
    ATTR_EMIT_RATE = String.format("%s", new Object[] { "emissionRate" });
    ATTR_WIDTH = String.format("%s", new Object[] { "width" });
    ATTR_HEIGHT = String.format("%s", new Object[] { "height" });
    ATTR_LIFE = String.format("%s", new Object[] { "life" });
    ATTR_COLOR_R = String.format("%s", new Object[] { "colorR" });
    ATTR_COLOR_G = String.format("%s", new Object[] { "colorG" });
    ATTR_COLOR_B = String.format("%s", new Object[] { "colorB" });
    ATTR_COLOR_A = String.format("%s", new Object[] { "colorA" });
    ATTR_POS_X = String.format("%s", new Object[] { "positionX" });
    ATTR_POS_Y = String.format("%s", new Object[] { "positionY" });
    ATTR_POS_Z = String.format("%s", new Object[] { "positionZ" });
    AppMethodBeat.o(81560);
  }
  
  public ParticleTemplate(ParticleSystemEx paramParticleSystemEx)
  {
    AppMethodBeat.i(81554);
    this.mWidth = "0";
    this.mHeight = "0";
    this.mLife = "0";
    this.mColorR = "0";
    this.mColorG = "0";
    this.mColorB = "0";
    this.mColorA = "0";
    this.mPosX = "0";
    this.mPosY = "0";
    this.mPosZ = "0";
    this.mSystem = paramParticleSystemEx;
    this.mSprite = new Sprite();
    AppMethodBeat.o(81554);
  }
  
  private double doubleValue(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(81559);
    paramJSONObject = paramJSONObject.opt(paramString);
    if ((paramJSONObject != null) && ((paramJSONObject instanceof Number)))
    {
      double d = ((Number)paramJSONObject).doubleValue();
      AppMethodBeat.o(81559);
      return d;
    }
    AppMethodBeat.o(81559);
    return 0.0D;
  }
  
  static ParticleTemplate fromJson(ParticleSystemEx paramParticleSystemEx, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(81555);
    paramParticleSystemEx = new ParticleTemplate(paramParticleSystemEx);
    String str;
    Object localObject;
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = paramJSONObject.get(str);
          if (((localObject instanceof Number)) || ((localObject instanceof String)))
          {
            initAttr(paramParticleSystemEx, str, localObject);
            continue;
            AppMethodBeat.o(81555);
          }
        }
      }
    }
    catch (Exception paramParticleSystemEx)
    {
      paramParticleSystemEx = null;
    }
    for (;;)
    {
      return paramParticleSystemEx;
      if (((localObject instanceof JSONObject)) && (TextUtils.equals(str, "sprite")))
      {
        paramParticleSystemEx.initSprite((JSONObject)localObject, paramString);
        break;
      }
      if ((!(localObject instanceof JSONObject)) || (!TextUtils.equals(str, "audio"))) {
        break;
      }
      paramParticleSystemEx.mSprite.audioPath = ((JSONObject)localObject).getString("path");
      break;
    }
  }
  
  private static void initAttr(ParticleTemplate paramParticleTemplate, String paramString, Object paramObject)
  {
    AppMethodBeat.i(81556);
    String str = null;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    }
    while (str == null)
    {
      AppMethodBeat.o(81556);
      return;
      if ((paramObject instanceof Number)) {
        str = paramObject.toString();
      }
    }
    if (TextUtils.equals(ATTR_MAX_COUNT, paramString))
    {
      if ((paramObject instanceof Number)) {}
      for (int i = ((Number)paramObject).intValue();; i = 0)
      {
        paramParticleTemplate.mMaxCount = i;
        if (paramParticleTemplate.mMaxCount >= 0) {
          break;
        }
        paramParticleTemplate.mMaxCount = 0;
        AppMethodBeat.o(81556);
        return;
      }
    }
    if (TextUtils.equals(ATTR_EMIT_RATE, paramString))
    {
      if ((paramObject instanceof Number)) {}
      for (double d = ((Number)paramObject).doubleValue();; d = 0.0D)
      {
        paramParticleTemplate.mEmitRate = d;
        if (paramParticleTemplate.mEmitRate >= 0.0D) {
          break;
        }
        paramParticleTemplate.mEmitRate = 0.0D;
        AppMethodBeat.o(81556);
        return;
      }
    }
    if (TextUtils.equals(ATTR_WIDTH, paramString))
    {
      paramParticleTemplate.mWidth = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_HEIGHT, paramString))
    {
      paramParticleTemplate.mHeight = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_LIFE, paramString))
    {
      paramParticleTemplate.mLife = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_COLOR_R, paramString))
    {
      paramParticleTemplate.mColorR = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_COLOR_G, paramString))
    {
      paramParticleTemplate.mColorG = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_COLOR_B, paramString))
    {
      paramParticleTemplate.mColorB = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_COLOR_A, paramString))
    {
      paramParticleTemplate.mColorA = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_POS_X, paramString))
    {
      paramParticleTemplate.mPosX = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_POS_Y, paramString))
    {
      paramParticleTemplate.mPosY = str;
      AppMethodBeat.o(81556);
      return;
    }
    if (TextUtils.equals(ATTR_POS_Z, paramString)) {
      paramParticleTemplate.mPosZ = str;
    }
    AppMethodBeat.o(81556);
  }
  
  private void initSprite(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    InputStream localInputStream = null;
    AppMethodBeat.i(81558);
    this.mSprite.path = paramJSONObject.optString("path");
    String str = paramString + File.separator + this.mSprite.path;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    if (str.startsWith("/")) {
      BitmapFactory.decodeFile(str, localOptions);
    }
    for (;;)
    {
      if ((localOptions.outWidth == 0) || (localOptions.outHeight == 0))
      {
        paramJSONObject = new RuntimeException("tex outWith or outHeight is 0");
        AppMethodBeat.o(81558);
        throw paramJSONObject;
        AssetManager localAssetManager = this.mSystem.mContext.getAssets();
        paramString = localInputStream;
        try
        {
          localInputStream = localAssetManager.open(str);
          paramString = localInputStream;
          localObject = localInputStream;
          BitmapFactory.decodeStream(localInputStream, null, localOptions);
          if (localInputStream != null) {
            try
            {
              localInputStream.close();
            }
            catch (IOException paramString) {}
          }
        }
        catch (IOException localIOException)
        {
          if (paramString != null) {
            try
            {
              paramString.close();
            }
            catch (IOException paramString) {}
          }
        }
        finally
        {
          if (localIOException == null) {}
        }
      }
    }
    try
    {
      localIOException.close();
      label203:
      AppMethodBeat.o(81558);
      throw paramJSONObject;
      this.mSprite.frameCount = ((int)doubleValue(paramJSONObject, "frameCount"));
      this.mSprite.width = ((int)doubleValue(paramJSONObject, "width"));
      this.mSprite.height = ((int)doubleValue(paramJSONObject, "height"));
      this.mSprite.blendMode = ((int)doubleValue(paramJSONObject, "blendMode"));
      this.mSprite.animated = ((int)doubleValue(paramJSONObject, "animated"));
      this.mSprite.looped = ((int)doubleValue(paramJSONObject, "looped"));
      this.mSprite.frameDuration = doubleValue(paramJSONObject, "frameDuration");
      preCalTexCoords(this.mSprite, localOptions.outWidth, localOptions.outHeight, this.mSprite.width, this.mSprite.height);
      AppMethodBeat.o(81558);
      return;
    }
    catch (IOException paramString)
    {
      break label203;
    }
  }
  
  private void preCalTexCoords(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(81557);
    int i = paramInt2 / paramInt4;
    int j = paramInt1 / paramInt3;
    float f1 = paramInt3 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt2;
    paramSprite.texCoords = new float[i * j * 12];
    paramInt3 = 0;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        PointF localPointF = new PointF(paramInt2 * f1, paramInt1 * f2);
        Object localObject1 = new PointF(localPointF.x, localPointF.y + f2);
        Object localObject2 = new PointF(localPointF.x + f1, localPointF.y);
        Object localObject3 = new PointF(((PointF)localObject2).x, localPointF.y + f2);
        float[] arrayOfFloat = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        arrayOfFloat[paramInt3] = ((PointF)localObject2).x;
        arrayOfFloat = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        arrayOfFloat[paramInt4] = ((PointF)localObject2).y;
        arrayOfFloat = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        arrayOfFloat[paramInt3] = ((PointF)localObject3).x;
        arrayOfFloat = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        arrayOfFloat[paramInt4] = ((PointF)localObject3).y;
        localObject3 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject3[paramInt3] = ((PointF)localObject1).x;
        localObject3 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject3[paramInt4] = ((PointF)localObject1).y;
        localObject3 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject3[paramInt3] = ((PointF)localObject2).x;
        localObject3 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject3[paramInt4] = ((PointF)localObject2).y;
        localObject2 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject2[paramInt3] = ((PointF)localObject1).x;
        localObject2 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject2[paramInt4] = ((PointF)localObject1).y;
        localObject1 = paramSprite.texCoords;
        paramInt4 = paramInt3 + 1;
        localObject1[paramInt3] = localPointF.x;
        localObject1 = paramSprite.texCoords;
        paramInt3 = paramInt4 + 1;
        localObject1[paramInt4] = localPointF.y;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(81557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleTemplate
 * JD-Core Version:    0.7.0.1
 */