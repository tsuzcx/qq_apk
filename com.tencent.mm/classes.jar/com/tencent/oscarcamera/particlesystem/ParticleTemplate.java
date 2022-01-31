package com.tencent.oscarcamera.particlesystem;

import android.graphics.PointF;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

public class ParticleTemplate
{
  public static final String ATTR_COLOR_A = String.format("%s", new Object[] { "colorA" });
  public static final String ATTR_COLOR_B;
  public static final String ATTR_COLOR_G;
  public static final String ATTR_COLOR_R;
  public static final String ATTR_EMIT_RATE;
  public static final String ATTR_HEIGHT;
  public static final String ATTR_LIFE;
  public static final String ATTR_MAX_COUNT;
  public static final String ATTR_POS_X = String.format("%s", new Object[] { "positionX" });
  public static final String ATTR_POS_Y = String.format("%s", new Object[] { "positionY" });
  public static final String ATTR_POS_Z = String.format("%s", new Object[] { "positionZ" });
  public static final String ATTR_WIDTH;
  private static final String TAG = ParticleTemplate.class.getSimpleName();
  String mColorA = "0";
  String mColorB = "0";
  String mColorG = "0";
  String mColorR = "0";
  double mEmitRate;
  String mHeight = "0";
  String mLife = "0";
  int mMaxCount;
  String mPosX = "0";
  String mPosY = "0";
  String mPosZ = "0";
  public Sprite mSprite = new Sprite();
  String mWidth = "0";
  
  static
  {
    ATTR_MAX_COUNT = String.format("%s", new Object[] { "particleCountMax" });
    ATTR_EMIT_RATE = String.format("%s", new Object[] { "emissionRate" });
    ATTR_WIDTH = String.format("%s", new Object[] { "width" });
    ATTR_HEIGHT = String.format("%s", new Object[] { "height" });
    ATTR_LIFE = String.format("%s", new Object[] { "life" });
    ATTR_COLOR_R = String.format("%s", new Object[] { "colorR" });
    ATTR_COLOR_G = String.format("%s", new Object[] { "colorG" });
    ATTR_COLOR_B = String.format("%s", new Object[] { "colorB" });
  }
  
  private double doubleValue(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.opt(paramString);
    if ((paramJSONObject != null) && ((paramJSONObject instanceof Number))) {
      return ((Number)paramJSONObject).doubleValue();
    }
    return 0.0D;
  }
  
  static ParticleTemplate fromJson(JSONObject paramJSONObject, String paramString)
  {
    ParticleTemplate localParticleTemplate = new ParticleTemplate();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject.get(str);
        if (((localObject instanceof Number)) || ((localObject instanceof String))) {
          initAttr(localParticleTemplate, str, localObject);
        } else if (((localObject instanceof JSONObject)) && (TextUtils.equals(str, "sprite"))) {
          localParticleTemplate.initSprite((JSONObject)localObject, paramString);
        } else if (((localObject instanceof JSONObject)) && (TextUtils.equals(str, "audio"))) {
          localParticleTemplate.mSprite.audioPath = ((JSONObject)localObject).getString("path");
        }
      }
      return localParticleTemplate;
    }
    catch (Exception paramJSONObject) {}
    return null;
  }
  
  private static void initAttr(ParticleTemplate paramParticleTemplate, String paramString, Object paramObject)
  {
    String str = null;
    if ((paramObject instanceof String)) {
      str = (String)paramObject;
    }
    label21:
    do
    {
      break label21;
      while (str == null)
      {
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
          return;
        }
      }
      if (TextUtils.equals(ATTR_WIDTH, paramString))
      {
        paramParticleTemplate.mWidth = str;
        return;
      }
      if (TextUtils.equals(ATTR_HEIGHT, paramString))
      {
        paramParticleTemplate.mHeight = str;
        return;
      }
      if (TextUtils.equals(ATTR_LIFE, paramString))
      {
        paramParticleTemplate.mLife = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_R, paramString))
      {
        paramParticleTemplate.mColorR = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_G, paramString))
      {
        paramParticleTemplate.mColorG = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_B, paramString))
      {
        paramParticleTemplate.mColorB = str;
        return;
      }
      if (TextUtils.equals(ATTR_COLOR_A, paramString))
      {
        paramParticleTemplate.mColorA = str;
        return;
      }
      if (TextUtils.equals(ATTR_POS_X, paramString))
      {
        paramParticleTemplate.mPosX = str;
        return;
      }
      if (TextUtils.equals(ATTR_POS_Y, paramString))
      {
        paramParticleTemplate.mPosY = str;
        return;
      }
    } while (!TextUtils.equals(ATTR_POS_Z, paramString));
    paramParticleTemplate.mPosZ = str;
  }
  
  /* Error */
  private void initSprite(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   4: aload_1
    //   5: ldc 186
    //   7: invokevirtual 209	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: putfield 211	com/tencent/oscarcamera/particlesystem/Sprite:path	Ljava/lang/String;
    //   13: new 213	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   20: aload_2
    //   21: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 223	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   34: getfield 211	com/tencent/oscarcamera/particlesystem/Sprite:path	Ljava/lang/String;
    //   37: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore_3
    //   44: new 226	android/graphics/BitmapFactory$Options
    //   47: dup
    //   48: invokespecial 227	android/graphics/BitmapFactory$Options:<init>	()V
    //   51: astore_2
    //   52: aload_2
    //   53: iconst_1
    //   54: putfield 231	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   57: aload_3
    //   58: ldc 233
    //   60: invokevirtual 237	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   63: ifeq +33 -> 96
    //   66: aload_3
    //   67: aload_2
    //   68: invokestatic 243	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: pop
    //   72: aload_2
    //   73: getfield 246	android/graphics/BitmapFactory$Options:outWidth	I
    //   76: ifeq +10 -> 86
    //   79: aload_2
    //   80: getfield 249	android/graphics/BitmapFactory$Options:outHeight	I
    //   83: ifne +48 -> 131
    //   86: new 251	java/lang/RuntimeException
    //   89: dup
    //   90: ldc 253
    //   92: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   95: athrow
    //   96: new 258	java/lang/NullPointerException
    //   99: dup
    //   100: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   103: athrow
    //   104: astore_3
    //   105: iconst_0
    //   106: ifeq -34 -> 72
    //   109: aconst_null
    //   110: invokevirtual 264	java/io/InputStream:close	()V
    //   113: goto -41 -> 72
    //   116: astore_3
    //   117: goto -45 -> 72
    //   120: astore_1
    //   121: iconst_0
    //   122: ifeq +7 -> 129
    //   125: aconst_null
    //   126: invokevirtual 264	java/io/InputStream:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: aload_0
    //   132: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   135: aload_0
    //   136: aload_1
    //   137: ldc_w 266
    //   140: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   143: d2i
    //   144: putfield 270	com/tencent/oscarcamera/particlesystem/Sprite:frameCount	I
    //   147: aload_0
    //   148: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   151: aload_0
    //   152: aload_1
    //   153: ldc 62
    //   155: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   158: d2i
    //   159: putfield 272	com/tencent/oscarcamera/particlesystem/Sprite:width	I
    //   162: aload_0
    //   163: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   166: aload_0
    //   167: aload_1
    //   168: ldc 66
    //   170: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   173: d2i
    //   174: putfield 274	com/tencent/oscarcamera/particlesystem/Sprite:height	I
    //   177: aload_0
    //   178: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   181: aload_0
    //   182: aload_1
    //   183: ldc_w 276
    //   186: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   189: d2i
    //   190: putfield 278	com/tencent/oscarcamera/particlesystem/Sprite:blendMode	I
    //   193: aload_0
    //   194: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   197: aload_0
    //   198: aload_1
    //   199: ldc_w 280
    //   202: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   205: d2i
    //   206: putfield 282	com/tencent/oscarcamera/particlesystem/Sprite:animated	I
    //   209: aload_0
    //   210: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 284
    //   218: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   221: d2i
    //   222: putfield 286	com/tencent/oscarcamera/particlesystem/Sprite:looped	I
    //   225: aload_0
    //   226: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   229: aload_0
    //   230: aload_1
    //   231: ldc_w 288
    //   234: invokespecial 268	com/tencent/oscarcamera/particlesystem/ParticleTemplate:doubleValue	(Lorg/json/JSONObject;Ljava/lang/String;)D
    //   237: putfield 290	com/tencent/oscarcamera/particlesystem/Sprite:frameDuration	D
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   245: aload_2
    //   246: getfield 246	android/graphics/BitmapFactory$Options:outWidth	I
    //   249: aload_2
    //   250: getfield 249	android/graphics/BitmapFactory$Options:outHeight	I
    //   253: aload_0
    //   254: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   257: getfield 272	com/tencent/oscarcamera/particlesystem/Sprite:width	I
    //   260: aload_0
    //   261: getfield 131	com/tencent/oscarcamera/particlesystem/ParticleTemplate:mSprite	Lcom/tencent/oscarcamera/particlesystem/Sprite;
    //   264: getfield 274	com/tencent/oscarcamera/particlesystem/Sprite:height	I
    //   267: invokespecial 294	com/tencent/oscarcamera/particlesystem/ParticleTemplate:preCalTexCoords	(Lcom/tencent/oscarcamera/particlesystem/Sprite;IIII)V
    //   270: return
    //   271: astore_2
    //   272: goto -143 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ParticleTemplate
    //   0	275	1	paramJSONObject	JSONObject
    //   0	275	2	paramString	String
    //   43	24	3	str	String
    //   104	1	3	localIOException1	java.io.IOException
    //   116	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   96	104	104	java/io/IOException
    //   109	113	116	java/io/IOException
    //   96	104	120	finally
    //   125	129	271	java/io/IOException
  }
  
  private void preCalTexCoords(Sprite paramSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.ParticleTemplate
 * JD-Core Version:    0.7.0.1
 */