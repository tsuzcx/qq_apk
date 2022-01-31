package com.tencent.ttpic.particle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class ParticleEmitter
{
  private static final String TAG;
  public boolean active;
  public float angle;
  public float angleVariance;
  private float audioColorDelta;
  public int blendFuncDestination;
  public int blendFuncSource;
  public float duration;
  public float elapsedTime;
  public float emissionRate;
  public float emitCounter;
  public int emitterType;
  public Vector4 finishColor;
  public Vector4 finishColorVariance;
  public float finishParticleSize;
  public float finishParticleSizeVariance;
  public Vector2 gravity;
  public int maxParticles;
  public float maxRadius;
  public float maxRadiusVariance;
  public float minRadius;
  public float minRadiusVariance;
  public boolean opacityModifyRGB;
  public float[] particleColors;
  public int particleCount;
  private int particleIndex;
  public int[] particleIndices;
  public float particleLifespan;
  public float particleLifespanVariance;
  public float[] particleTextureCoordinates;
  public float[] particleVertices;
  private Particle[] particles;
  private ParticleQuad[] quads;
  public float radialAccelVariance;
  public float radialAcceleration;
  public float radiusSpeed;
  private float rotateParticle = 0.0F;
  public float rotatePerSecond;
  public float rotatePerSecondVariance;
  public float rotationEnd;
  public float rotationEndVariance;
  public float rotationStart;
  public float rotationStartVariance;
  private float scaleParticle = 1.0F;
  public Vector2 sourcePosition;
  public Vector2 sourcePositionVariance;
  public float speed;
  public float speedVariance;
  public Vector4 startColor;
  public Vector4 startColorVariance;
  public float startParticleSize;
  public float startParticleSizeVariance;
  public long startTime;
  public float tangentialAccelVariance;
  public float tangentialAcceleration;
  public int texture;
  
  static
  {
    AppMethodBeat.i(83618);
    TAG = ParticleEmitter.class.getSimpleName();
    AppMethodBeat.o(83618);
  }
  
  private boolean addParticle()
  {
    AppMethodBeat.i(83611);
    if (this.particleCount == this.maxParticles)
    {
      AppMethodBeat.o(83611);
      return false;
    }
    initParticle(this.particles[this.particleCount]);
    this.particleCount += 1;
    AppMethodBeat.o(83611);
    return true;
  }
  
  public static Bitmap base64ToBitmap(String paramString)
  {
    AppMethodBeat.i(83616);
    try
    {
      paramString = Base64.decode(paramString, 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      AppMethodBeat.o(83616);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      AppMethodBeat.o(83616);
    }
    return null;
  }
  
  private void initParticle(Particle paramParticle)
  {
    AppMethodBeat.i(83614);
    paramParticle.position.x = (this.sourcePosition.x + this.sourcePositionVariance.x * ParticleUtil.randomMinus1to1());
    paramParticle.position.y = (this.sourcePosition.y + this.sourcePositionVariance.y * ParticleUtil.randomMinus1to1());
    paramParticle.startPos.x = this.sourcePosition.x;
    paramParticle.startPos.y = this.sourcePosition.y;
    float f1 = (float)Math.toRadians(this.angle + this.angleVariance * ParticleUtil.randomMinus1to1() + this.rotateParticle);
    paramParticle.direction = ParticleUtil.vectorMultiplyScalar(new Vector2((float)Math.cos(f1), (float)Math.sin(f1)), this.speed + this.speedVariance * ParticleUtil.randomMinus1to1());
    paramParticle.timeToLive = Math.max(0.0F, this.particleLifespan + this.particleLifespanVariance * ParticleUtil.randomMinus1to1());
    f1 = this.maxRadius + this.maxRadiusVariance * ParticleUtil.randomMinus1to1();
    float f2 = this.minRadius;
    float f3 = this.minRadiusVariance;
    float f4 = ParticleUtil.randomMinus1to1();
    paramParticle.radius = f1;
    paramParticle.radiusDelta = ((f2 + f3 * f4 - f1) / paramParticle.timeToLive);
    paramParticle.angle = ((float)Math.toRadians(this.angle + this.angleVariance * ParticleUtil.randomMinus1to1() + this.rotateParticle));
    paramParticle.degreesPerSecond = ((float)Math.toRadians(this.rotatePerSecond + this.rotatePerSecondVariance * ParticleUtil.randomMinus1to1()));
    paramParticle.radialAcceleration = (this.radialAcceleration + this.radialAccelVariance * ParticleUtil.randomMinus1to1());
    paramParticle.tangentialAcceleration = (this.tangentialAcceleration + this.tangentialAccelVariance * ParticleUtil.randomMinus1to1());
    f1 = this.startParticleSize + this.startParticleSizeVariance * ParticleUtil.randomMinus1to1();
    paramParticle.particleSizeDelta = ((this.finishParticleSize + this.finishParticleSizeVariance * ParticleUtil.randomMinus1to1() - f1) / paramParticle.timeToLive);
    paramParticle.particleSize = Math.max(0.0F, f1);
    Vector4 localVector41 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    localVector41.r = (this.startColor.r + this.startColorVariance.r * ParticleUtil.randomMinus1to1());
    localVector41.g = (this.startColor.g + this.startColorVariance.g * ParticleUtil.randomMinus1to1());
    localVector41.b = (this.startColor.b + this.startColorVariance.b * ParticleUtil.randomMinus1to1());
    localVector41.a = (this.startColor.a + this.startColorVariance.a * ParticleUtil.randomMinus1to1());
    Vector4 localVector42 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    localVector42.r = (this.finishColor.r + this.finishColorVariance.r * ParticleUtil.randomMinus1to1());
    localVector42.g = (this.finishColor.g + this.finishColorVariance.g * ParticleUtil.randomMinus1to1());
    localVector42.b = (this.finishColor.b + this.finishColorVariance.b * ParticleUtil.randomMinus1to1());
    localVector42.a = (this.finishColor.a + this.finishColorVariance.a * ParticleUtil.randomMinus1to1());
    paramParticle.color = localVector41;
    paramParticle.deltaColor.r = ((localVector42.r - localVector41.r) / paramParticle.timeToLive);
    paramParticle.deltaColor.g = ((localVector42.g - localVector41.g) / paramParticle.timeToLive);
    paramParticle.deltaColor.b = ((localVector42.b - localVector41.b) / paramParticle.timeToLive);
    paramParticle.deltaColor.a = ((localVector42.a - localVector41.a) / paramParticle.timeToLive);
    f1 = this.rotationStart + this.rotationStartVariance * ParticleUtil.randomMinus1to1();
    f2 = this.rotationEnd;
    f3 = this.rotationEndVariance;
    f4 = ParticleUtil.randomMinus1to1();
    paramParticle.rotation = f1;
    paramParticle.rotationDelta = ((f2 + f3 * f4 - f1) / paramParticle.timeToLive);
    AppMethodBeat.o(83614);
  }
  
  private void setParticleConfig(String paramString, ParticleConfig paramParticleConfig)
  {
    String str = null;
    AppMethodBeat.i(83612);
    ParticleConfig.ParticleEmitterConfigBean localParticleEmitterConfigBean = paramParticleConfig.getParticleEmitterConfig();
    int i;
    label71:
    label108:
    float f;
    if (localParticleEmitterConfigBean.emitterType != null)
    {
      i = localParticleEmitterConfigBean.emitterType.getValue();
      this.emitterType = i;
      if (localParticleEmitterConfigBean.sourcePosition == null) {
        break label1108;
      }
      paramParticleConfig = new Vector2(localParticleEmitterConfigBean.sourcePosition.x, localParticleEmitterConfigBean.sourcePosition.y);
      this.sourcePosition = paramParticleConfig;
      if (localParticleEmitterConfigBean.sourcePositionVariance == null) {
        break label1113;
      }
      paramParticleConfig = new Vector2(localParticleEmitterConfigBean.sourcePositionVariance.x, localParticleEmitterConfigBean.sourcePositionVariance.y);
      this.sourcePositionVariance = paramParticleConfig;
      if (localParticleEmitterConfigBean.speed == null) {
        break label1118;
      }
      f = localParticleEmitterConfigBean.speed.getValue();
      label130:
      this.speed = f;
      if (localParticleEmitterConfigBean.speedVariance == null) {
        break label1123;
      }
      f = localParticleEmitterConfigBean.speedVariance.getValue();
      label152:
      this.speedVariance = f;
      if (localParticleEmitterConfigBean.particleLifeSpan == null) {
        break label1128;
      }
      f = localParticleEmitterConfigBean.particleLifeSpan.getValue();
      label174:
      this.particleLifespan = f;
      if (localParticleEmitterConfigBean.particleLifespanVariance == null) {
        break label1133;
      }
      f = localParticleEmitterConfigBean.particleLifespanVariance.getValue();
      label196:
      this.particleLifespanVariance = f;
      if (localParticleEmitterConfigBean.angle == null) {
        break label1138;
      }
      f = localParticleEmitterConfigBean.angle.getValue();
      label218:
      this.angle = f;
      if (localParticleEmitterConfigBean.angleVariance == null) {
        break label1143;
      }
      f = localParticleEmitterConfigBean.angleVariance.getValue();
      label240:
      this.angleVariance = f;
      if (localParticleEmitterConfigBean.gravity == null) {
        break label1148;
      }
      paramParticleConfig = new Vector2(localParticleEmitterConfigBean.gravity.x, localParticleEmitterConfigBean.gravity.y);
      label277:
      this.gravity = paramParticleConfig;
      if (localParticleEmitterConfigBean.radialAcceleration == null) {
        break label1153;
      }
      f = localParticleEmitterConfigBean.radialAcceleration.getValue();
      label299:
      this.radialAcceleration = f;
      if (localParticleEmitterConfigBean.tangentialAcceleration == null) {
        break label1158;
      }
      f = localParticleEmitterConfigBean.tangentialAcceleration.getValue();
      label321:
      this.tangentialAcceleration = f;
      if (localParticleEmitterConfigBean.tangentialAccelVariance == null) {
        break label1163;
      }
      f = localParticleEmitterConfigBean.tangentialAccelVariance.getValue();
      label343:
      this.tangentialAccelVariance = f;
      if (localParticleEmitterConfigBean.startColor == null) {
        break label1168;
      }
      paramParticleConfig = new Vector4(localParticleEmitterConfigBean.startColor.red, localParticleEmitterConfigBean.startColor.green, localParticleEmitterConfigBean.startColor.blue, localParticleEmitterConfigBean.startColor.alpha);
      label396:
      this.startColor = paramParticleConfig;
      if (localParticleEmitterConfigBean.startColorVariance == null) {
        break label1173;
      }
      paramParticleConfig = new Vector4(localParticleEmitterConfigBean.startColorVariance.red, localParticleEmitterConfigBean.startColorVariance.green, localParticleEmitterConfigBean.startColorVariance.blue, localParticleEmitterConfigBean.startColorVariance.alpha);
      label449:
      this.startColorVariance = paramParticleConfig;
      if (localParticleEmitterConfigBean.finishColor == null) {
        break label1178;
      }
      paramParticleConfig = new Vector4(localParticleEmitterConfigBean.finishColor.red, localParticleEmitterConfigBean.finishColor.green, localParticleEmitterConfigBean.finishColor.blue, localParticleEmitterConfigBean.finishColor.alpha);
      label502:
      this.finishColor = paramParticleConfig;
      if (localParticleEmitterConfigBean.finishColorVariance == null) {
        break label1183;
      }
      paramParticleConfig = new Vector4(localParticleEmitterConfigBean.finishColorVariance.red, localParticleEmitterConfigBean.finishColorVariance.green, localParticleEmitterConfigBean.finishColorVariance.blue, localParticleEmitterConfigBean.finishColorVariance.alpha);
      label555:
      this.finishColorVariance = paramParticleConfig;
      if (localParticleEmitterConfigBean.maxParticles == null) {
        break label1188;
      }
      i = localParticleEmitterConfigBean.maxParticles.getValue();
      label578:
      this.maxParticles = i;
      if (localParticleEmitterConfigBean.startParticleSize == null) {
        break label1194;
      }
      f = localParticleEmitterConfigBean.startParticleSize.getValue();
      label601:
      this.startParticleSize = f;
      if (localParticleEmitterConfigBean.startParticleSizeVariance == null) {
        break label1199;
      }
      f = localParticleEmitterConfigBean.startParticleSizeVariance.getValue();
      label623:
      this.startParticleSizeVariance = f;
      if (localParticleEmitterConfigBean.finishParticleSize == null) {
        break label1204;
      }
      f = localParticleEmitterConfigBean.finishParticleSize.getValue();
      label645:
      this.finishParticleSize = f;
      if (localParticleEmitterConfigBean.finishParticleSizeVariance == null) {
        break label1209;
      }
      f = localParticleEmitterConfigBean.finishParticleSizeVariance.getValue();
      label667:
      this.finishParticleSizeVariance = f;
      if (localParticleEmitterConfigBean.duration == null) {
        break label1214;
      }
      f = localParticleEmitterConfigBean.duration.getValue();
      label689:
      this.duration = f;
      if (localParticleEmitterConfigBean.blendFuncSource == null) {
        break label1219;
      }
      i = localParticleEmitterConfigBean.blendFuncSource.getValue();
      label712:
      this.blendFuncSource = i;
      if (localParticleEmitterConfigBean.blendFuncDestination == null) {
        break label1225;
      }
      i = localParticleEmitterConfigBean.blendFuncDestination.getValue();
      label736:
      this.blendFuncDestination = i;
      if (localParticleEmitterConfigBean.maxRadius == null) {
        break label1231;
      }
      f = localParticleEmitterConfigBean.maxRadius.getValue();
      label759:
      this.maxRadius = f;
      if (localParticleEmitterConfigBean.maxRadiusVariance == null) {
        break label1236;
      }
      f = localParticleEmitterConfigBean.maxRadiusVariance.getValue();
      label781:
      this.maxRadiusVariance = f;
      if (localParticleEmitterConfigBean.minRadius == null) {
        break label1241;
      }
      f = localParticleEmitterConfigBean.minRadius.getValue();
      label803:
      this.minRadius = f;
      if (localParticleEmitterConfigBean.minRadiusVariance == null) {
        break label1246;
      }
      f = localParticleEmitterConfigBean.minRadiusVariance.getValue();
      label825:
      this.minRadiusVariance = f;
      if (localParticleEmitterConfigBean.rotatePerSecond == null) {
        break label1251;
      }
      f = localParticleEmitterConfigBean.rotatePerSecond.getValue();
      label847:
      this.rotatePerSecond = f;
      if (localParticleEmitterConfigBean.rotatePerSecondVariance == null) {
        break label1256;
      }
      f = localParticleEmitterConfigBean.rotatePerSecondVariance.getValue();
      label869:
      this.rotatePerSecondVariance = f;
      if (localParticleEmitterConfigBean.rotationStart == null) {
        break label1261;
      }
      f = localParticleEmitterConfigBean.rotationStart.getValue();
      label891:
      this.rotationStart = f;
      if (localParticleEmitterConfigBean.rotationStartVariance == null) {
        break label1266;
      }
      f = localParticleEmitterConfigBean.rotationStartVariance.getValue();
      label913:
      this.rotationStartVariance = f;
      if (localParticleEmitterConfigBean.rotationEnd == null) {
        break label1271;
      }
      f = localParticleEmitterConfigBean.rotationEnd.getValue();
      label935:
      this.rotationEnd = f;
      if (localParticleEmitterConfigBean.rotationEndVariance == null) {
        break label1276;
      }
      f = localParticleEmitterConfigBean.rotationEndVariance.getValue();
      label957:
      this.rotationEndVariance = f;
      this.emissionRate = (this.maxParticles / this.particleLifespan);
      this.emitCounter = 0.0F;
      if (localParticleEmitterConfigBean.texture == null) {
        break label1281;
      }
      paramParticleConfig = localParticleEmitterConfigBean.texture.name;
      label998:
      if (localParticleEmitterConfigBean.texture != null) {
        str = localParticleEmitterConfigBean.texture.data;
      }
      if (TextUtils.isEmpty(paramParticleConfig)) {
        break label1286;
      }
    }
    label1153:
    label1286:
    for (paramString = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), paramString + File.separator + paramParticleConfig, 1);; paramString = base64ToBitmap(str))
    {
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        paramParticleConfig = new int[1];
        GLES20.glGenTextures(1, paramParticleConfig, 0);
        this.texture = paramParticleConfig[0];
        GlUtil.loadTexture(this.texture, paramString);
        paramString.recycle();
      }
      AppMethodBeat.o(83612);
      return;
      i = 0;
      break;
      label1108:
      paramParticleConfig = null;
      break label71;
      label1113:
      paramParticleConfig = null;
      break label108;
      label1118:
      f = 0.0F;
      break label130;
      label1123:
      f = 0.0F;
      break label152;
      label1128:
      f = 0.0F;
      break label174;
      label1133:
      f = 0.0F;
      break label196;
      label1138:
      f = 0.0F;
      break label218;
      label1143:
      f = 0.0F;
      break label240;
      label1148:
      paramParticleConfig = null;
      break label277;
      f = 0.0F;
      break label299;
      label1158:
      f = 0.0F;
      break label321;
      label1163:
      f = 0.0F;
      break label343;
      label1168:
      paramParticleConfig = null;
      break label396;
      label1173:
      paramParticleConfig = null;
      break label449;
      label1178:
      paramParticleConfig = null;
      break label502;
      label1183:
      paramParticleConfig = null;
      break label555;
      label1188:
      i = 0;
      break label578;
      label1194:
      f = 0.0F;
      break label601;
      label1199:
      f = 0.0F;
      break label623;
      label1204:
      f = 0.0F;
      break label645;
      label1209:
      f = 0.0F;
      break label667;
      label1214:
      f = 0.0F;
      break label689;
      label1219:
      i = 0;
      break label712;
      label1225:
      i = 0;
      break label736;
      label1231:
      f = 0.0F;
      break label759;
      label1236:
      f = 0.0F;
      break label781;
      label1241:
      f = 0.0F;
      break label803;
      label1246:
      f = 0.0F;
      break label825;
      label1251:
      f = 0.0F;
      break label847;
      label1256:
      f = 0.0F;
      break label869;
      label1261:
      f = 0.0F;
      break label891;
      label1266:
      f = 0.0F;
      break label913;
      label1271:
      f = 0.0F;
      break label935;
      label1276:
      f = 0.0F;
      break label957;
      paramParticleConfig = null;
      break label998;
    }
  }
  
  private void setupArrays()
  {
    AppMethodBeat.i(83613);
    this.particles = new Particle[this.maxParticles];
    int i = 0;
    while (i < this.particles.length)
    {
      this.particles[i] = new Particle();
      i += 1;
    }
    this.quads = new ParticleQuad[this.maxParticles];
    i = 0;
    while (i < this.quads.length)
    {
      this.quads[i] = new ParticleQuad();
      i += 1;
    }
    this.particleIndices = new int[this.maxParticles * 6];
    this.particleVertices = new float[this.maxParticles * 18];
    this.particleTextureCoordinates = new float[this.maxParticles * 12];
    this.particleColors = new float[this.maxParticles * 24];
    i = 0;
    while (i < this.maxParticles)
    {
      this.quads[i].bl.texture.x = 0.0F;
      this.quads[i].bl.texture.y = 0.0F;
      this.quads[i].br.texture.x = 1.0F;
      this.quads[i].br.texture.y = 0.0F;
      this.quads[i].tl.texture.x = 0.0F;
      this.quads[i].tl.texture.y = 1.0F;
      this.quads[i].tr.texture.x = 1.0F;
      this.quads[i].tr.texture.y = 1.0F;
      i += 1;
    }
    i = 0;
    while (i < this.maxParticles)
    {
      this.particleIndices[(i * 6 + 0)] = (i * 4 + 0);
      this.particleIndices[(i * 6 + 1)] = (i * 4 + 1);
      this.particleIndices[(i * 6 + 2)] = (i * 4 + 2);
      this.particleIndices[(i * 6 + 5)] = (i * 4 + 2);
      this.particleIndices[(i * 6 + 4)] = (i * 4 + 3);
      this.particleIndices[(i * 6 + 3)] = (i * 4 + 1);
      i += 1;
    }
    this.active = true;
    this.particleCount = 0;
    this.elapsedTime = 0.0F;
    AppMethodBeat.o(83613);
  }
  
  private void stopParticleEmitter()
  {
    this.active = false;
    this.elapsedTime = 0.0F;
    this.emitCounter = 0.0F;
  }
  
  public int activeParticleCount()
  {
    return this.particleCount;
  }
  
  public void clear()
  {
    AppMethodBeat.i(83617);
    GLES20.glDeleteTextures(1, new int[] { this.texture }, 0);
    AppMethodBeat.o(83617);
  }
  
  public void initEmitter(String paramString, ParticleConfig paramParticleConfig)
  {
    AppMethodBeat.i(83609);
    setParticleConfig(paramString, paramParticleConfig);
    setupArrays();
    AppMethodBeat.o(83609);
  }
  
  public void reset()
  {
    this.active = true;
    this.elapsedTime = 0.0F;
    int i = 0;
    while (i < this.particleCount)
    {
      this.particles[i].timeToLive = 0.0F;
      i += 1;
    }
    this.emitCounter = 0.0F;
    this.emissionRate = (this.maxParticles / this.particleLifespan);
  }
  
  public void setExtraRotate(float paramFloat)
  {
    this.rotateParticle = paramFloat;
  }
  
  public void setExtraScale(float paramFloat)
  {
    this.scaleParticle = paramFloat;
  }
  
  public void setSourcePosition(Vector2 paramVector2)
  {
    this.sourcePosition.x = paramVector2.x;
    this.sourcePosition.y = paramVector2.y;
  }
  
  public boolean totalFinished()
  {
    return (!this.active) && (this.particleCount == 0);
  }
  
  public void updateWithCurrentTime(long paramLong, boolean paramBoolean)
  {
    long l = 0L;
    AppMethodBeat.i(83610);
    if (this.startTime > 0L) {
      l = paramLong - this.startTime;
    }
    this.startTime = paramLong;
    updateWithDelta((float)l * 1.0F / 1000.0F, paramBoolean);
    AppMethodBeat.o(83610);
  }
  
  public void updateWithDelta(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(83615);
    float f1;
    if ((paramBoolean) && (this.active) && (this.emissionRate > 0.0F))
    {
      f1 = 1.0F / this.emissionRate;
      if (this.particleCount < this.maxParticles) {
        this.emitCounter += paramFloat;
      }
      if ((this.particleCount == 0) && (this.particleLifespanVariance < 0.01D) && (this.emitCounter >= this.maxParticles * f1)) {}
      for (this.emitCounter = (this.maxParticles * f1 * ParticleUtil.random0to1()); (this.particleCount < this.maxParticles) && (this.emitCounter > f1); this.emitCounter -= f1) {
        addParticle();
      }
      this.elapsedTime += paramFloat;
      if ((this.duration != -1.0F) && (this.duration < this.elapsedTime)) {
        stopParticleEmitter();
      }
    }
    this.particleIndex = 0;
    LogUtils.e(TAG, "updateWithDelta() - particleCount = " + this.particleCount);
    while (this.particleIndex < this.particleCount)
    {
      Particle localParticle = this.particles[this.particleIndex];
      localParticle.timeToLive -= paramFloat;
      int i = this.particleIndex * 18;
      if (localParticle.timeToLive > 0.0F)
      {
        Object localObject;
        if (this.emitterType == ParticleEmitter.kParticleTypes.kParticleTypeRadial.value)
        {
          localParticle.angle += localParticle.degreesPerSecond * paramFloat;
          localParticle.radius += localParticle.radiusDelta * paramFloat;
          localObject = new Vector2();
          ((Vector2)localObject).x = ((float)(this.sourcePosition.x - Math.cos(localParticle.angle) * localParticle.radius));
          ((Vector2)localObject).y = ((float)(this.sourcePosition.y - Math.sin(localParticle.angle) * localParticle.radius));
          localParticle.position = ((Vector2)localObject);
          if (this.audioColorDelta <= 0.0F) {
            break label1836;
          }
          localParticle.color.r = (this.startColor.r + localParticle.deltaColor.r * this.audioColorDelta);
          localParticle.color.g = (this.startColor.g + localParticle.deltaColor.g * this.audioColorDelta);
          localParticle.color.b = (this.startColor.b + localParticle.deltaColor.b * this.audioColorDelta);
          localParticle.color.a = (this.startColor.a + localParticle.deltaColor.a * this.audioColorDelta);
          label514:
          localParticle.particleSize += localParticle.particleSizeDelta * paramFloat;
          localParticle.particleSize = Math.max(0.0F, localParticle.particleSize);
          localParticle.rotation += localParticle.rotationDelta * paramFloat;
          f1 = localParticle.particleSize * 0.5F * this.scaleParticle;
          if (localParticle.rotation == 0.0F) {
            break label1951;
          }
          float f2 = -f1;
          float f3 = -f1;
          float f4 = localParticle.position.x;
          float f5 = localParticle.position.y;
          float f7 = (float)Math.toRadians(localParticle.rotation);
          float f6 = (float)Math.cos(f7);
          f7 = (float)Math.sin(f7);
          this.quads[this.particleIndex].bl.vertex.x = (f2 * f6 - f3 * f7 + f4);
          this.quads[this.particleIndex].bl.vertex.y = (f2 * f7 + f3 * f6 + f5);
          this.quads[this.particleIndex].bl.color = localParticle.color;
          this.quads[this.particleIndex].br.vertex.x = (f1 * f6 - f3 * f7 + f4);
          this.quads[this.particleIndex].br.vertex.y = (f3 * f6 + f1 * f7 + f5);
          this.quads[this.particleIndex].br.color = localParticle.color;
          this.quads[this.particleIndex].tl.vertex.x = (f4 + (f2 * f6 - f1 * f7));
          this.quads[this.particleIndex].tl.vertex.y = (f1 * f6 + f2 * f7 + f5);
          this.quads[this.particleIndex].tl.color = localParticle.color;
          this.quads[this.particleIndex].tr.vertex.x = (f1 * f6 - f1 * f7 + f4);
          this.quads[this.particleIndex].tr.vertex.y = (f1 * f7 + f1 * f6 + f5);
          this.quads[this.particleIndex].tr.color = localParticle.color;
          this.particleVertices[i] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(i + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(i + 2)] = 0.0F;
          this.particleVertices[(i + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 5)] = 0.0F;
          this.particleVertices[(i + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 8)] = 0.0F;
          this.particleVertices[(i + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 11)] = 0.0F;
          this.particleVertices[(i + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 14)] = 0.0F;
          this.particleVertices[(i + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(i + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(i + 17)] = 0.0F;
        }
        for (;;)
        {
          i = this.particleIndex * 12;
          this.particleTextureCoordinates[i] = 0.0F;
          this.particleTextureCoordinates[(i + 1)] = 0.0F;
          this.particleTextureCoordinates[(i + 2)] = 1.0F;
          this.particleTextureCoordinates[(i + 3)] = 0.0F;
          this.particleTextureCoordinates[(i + 4)] = 0.0F;
          this.particleTextureCoordinates[(i + 5)] = 1.0F;
          this.particleTextureCoordinates[(i + 6)] = this.particleTextureCoordinates[(i + 2)];
          this.particleTextureCoordinates[(i + 7)] = this.particleTextureCoordinates[(i + 3)];
          this.particleTextureCoordinates[(i + 8)] = this.particleTextureCoordinates[(i + 4)];
          this.particleTextureCoordinates[(i + 9)] = this.particleTextureCoordinates[(i + 5)];
          this.particleTextureCoordinates[(i + 10)] = 1.0F;
          this.particleTextureCoordinates[(i + 11)] = 1.0F;
          i = 0;
          while (i < 6)
          {
            int j = this.particleIndex * 24 + i * 4;
            this.particleColors[j] = localParticle.color.r;
            this.particleColors[(j + 1)] = localParticle.color.g;
            this.particleColors[(j + 2)] = localParticle.color.b;
            this.particleColors[(j + 3)] = localParticle.color.a;
            i += 1;
          }
          localObject = new Vector2(0.0F, 0.0F);
          Vector2 localVector21 = ParticleUtil.vectorSubtract(localParticle.startPos, new Vector2(0.0F, 0.0F));
          localParticle.position = ParticleUtil.vectorSubtract(localParticle.position, localVector21);
          if ((localParticle.position.x != 0.0F) || (localParticle.position.y != 0.0F)) {
            localObject = ParticleUtil.vectorNormalize(localParticle.position);
          }
          Vector2 localVector22 = ParticleUtil.vectorMultiplyScalar((Vector2)localObject, localParticle.radialAcceleration);
          f1 = ((Vector2)localObject).x;
          ((Vector2)localObject).x = (-((Vector2)localObject).y);
          ((Vector2)localObject).y = f1;
          localObject = ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorAdd(ParticleUtil.vectorAdd(localVector22, ParticleUtil.vectorMultiplyScalar((Vector2)localObject, localParticle.tangentialAcceleration)), this.gravity), paramFloat);
          localParticle.direction = ParticleUtil.vectorAdd(localParticle.direction, (Vector2)localObject);
          localObject = ParticleUtil.vectorMultiplyScalar(localParticle.direction, paramFloat);
          localParticle.position = ParticleUtil.vectorAdd(localParticle.position, (Vector2)localObject);
          localParticle.position = ParticleUtil.vectorAdd(localParticle.position, localVector21);
          break;
          label1836:
          localObject = localParticle.color;
          ((Vector4)localObject).r += localParticle.deltaColor.r * paramFloat;
          localObject = localParticle.color;
          ((Vector4)localObject).g += localParticle.deltaColor.g * paramFloat;
          localObject = localParticle.color;
          ((Vector4)localObject).b += localParticle.deltaColor.b * paramFloat;
          localObject = localParticle.color;
          ((Vector4)localObject).a += localParticle.deltaColor.a * paramFloat;
          break label514;
          label1951:
          this.quads[this.particleIndex].bl.vertex.x = (localParticle.position.x - f1);
          this.quads[this.particleIndex].bl.vertex.y = (localParticle.position.y - f1);
          this.quads[this.particleIndex].bl.color = localParticle.color;
          this.quads[this.particleIndex].br.vertex.x = (localParticle.position.x + f1);
          this.quads[this.particleIndex].br.vertex.y = (localParticle.position.y - f1);
          this.quads[this.particleIndex].br.color = localParticle.color;
          this.quads[this.particleIndex].tl.vertex.x = (localParticle.position.x - f1);
          this.quads[this.particleIndex].tl.vertex.y = (localParticle.position.y + f1);
          this.quads[this.particleIndex].tl.color = localParticle.color;
          this.quads[this.particleIndex].tr.vertex.x = (localParticle.position.x + f1);
          this.quads[this.particleIndex].tr.vertex.y = (f1 + localParticle.position.y);
          this.quads[this.particleIndex].tr.color = localParticle.color;
          this.particleVertices[i] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(i + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(i + 2)] = 0.0F;
          this.particleVertices[(i + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 5)] = 0.0F;
          this.particleVertices[(i + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 8)] = 0.0F;
          this.particleVertices[(i + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 11)] = 0.0F;
          this.particleVertices[(i + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 14)] = 0.0F;
          this.particleVertices[(i + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(i + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(i + 17)] = 0.0F;
        }
        this.particleIndex += 1;
      }
      else
      {
        if (this.particleIndex != this.particleCount - 1) {
          this.particles[this.particleIndex].copy(this.particles[(this.particleCount - 1)]);
        }
        this.particleCount -= 1;
      }
    }
    AppMethodBeat.o(83615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter
 * JD-Core Version:    0.7.0.1
 */