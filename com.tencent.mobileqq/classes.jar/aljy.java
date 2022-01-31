import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class aljy
  extends alkd
{
  public int a;
  
  public aljy(int paramInt, String paramString)
  {
    super(paramInt);
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("mFragmentShader can not be empty!");
    }
    this.b = paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("    float bgR = max(min(u_screenColor.r, 1.0), 0.0);\n    float bgG = max(min(u_screenColor.g, 1.0), 0.0);\n    float bgB = max(min(u_screenColor.b, 1.0), 0.0);\n    float R = max(min(gl_FragColor.r, 1.0), 0.0);\n    float G = max(min(gl_FragColor.g, 1.0), 0.0);\n    float B = max(min(gl_FragColor.b, 1.0), 0.0);\n    float x = position.x;\n    float y = position.y;\n    float alpha = 1.0;\n");
    try
    {
      localObject1 = new ArrayList();
      float f5 = 0.0F;
      f1 = 0.0F;
      f2 = 1.0F;
      f3 = f2;
      f4 = f5;
      if (TextUtils.isEmpty(paramString1)) {
        break label417;
      }
      localObject2 = paramString1.split(";");
      f3 = f2;
      f4 = f5;
      if (localObject2 == null) {
        break label417;
      }
      localObject4 = new String[15];
      localObject4[0] = "R";
      localObject4[1] = "G";
      localObject4[2] = "B";
      localObject4[3] = "R2";
      localObject4[4] = "G2";
      localObject4[5] = "B2";
      localObject4[6] = "RG";
      localObject4[7] = "RB";
      localObject4[8] = "GB";
      localObject4[9] = "RGB";
      localObject4[10] = "R_2";
      localObject4[11] = "G_2";
      localObject4[12] = "B_2";
      localObject4[13] = "dCbCr";
      localObject4[14] = "b";
      localObject3 = new HashMap(localObject4.length);
      i = 0;
      while (i < localObject4.length)
      {
        ((HashMap)localObject3).put(localObject4[i], Integer.valueOf(i));
        i += 1;
      }
      j = localObject2.length;
      i = 0;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Object localObject1;
        float f3;
        float f4;
        Object localObject2;
        Object localObject4;
        Object localObject3;
        int i;
        int j;
        Object localObject5;
        label417:
        label494:
        QLog.e("CustomizeKey", 1, paramString1.getMessage());
        localStringBuilder.append("    alpha = max(min(alpha, 1.0), 0.0);\n    if(alpha > 0.01 && alpha < 1.0){\n        R = R - (1.0-alpha)*bgR;\n        G = G - (1.0-alpha)*bgG;\n        B = B - (1.0-alpha)*bgB;\n    }\n    alpha = smoothclip(u_clipBlack, u_clipWhite, alpha);\n    if(alpha <= 0.01){\n        R = G = B = 0.0;\n    }\n    gl_FragColor.a = alpha;\n    gl_FragColor.r = max(min(R, 1.0), 0.0);\n    gl_FragColor.g = max(min(G, 1.0), 0.0);\n    gl_FragColor.b = max(min(B, 1.0), 0.0);\n");
        paramString1 = new StringBuilder();
        paramString1.append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n");
        paramString1.append("uniform float u_currentTime;\nfloat u_clipBlack = 0.0;\nfloat u_clipWhite = 1.0;\nfloat smoothclip(float low, float high, float x){\n    if (x <= low){\n        return 0.0;\n    }\n    if(x >= high){\n        return 1.0;\n    }\n    return (x-low)/(high-low);\n}\n");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.append(paramString2);
          paramString1.append("void main() {\n    vec2 position = vTextureCoord;\n");
          if (TextUtils.isEmpty(paramString3)) {
            break label1237;
          }
          paramString1.append(paramString3);
          paramString1.append("    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n        gl_FragColor.r = max(0.0, min(gl_FragColor.r, 1.0));\n        gl_FragColor.g = max(0.0, min(gl_FragColor.g, 1.0));\n        gl_FragColor.b = max(0.0, min(gl_FragColor.b, 1.0));\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n");
          paramString1.append(localStringBuilder.toString());
          if (TextUtils.isEmpty(paramString4)) {
            break label1247;
          }
          paramString1.append(paramString4);
        }
        for (;;)
        {
          paramString1.append(alkh.d);
          return paramString1.toString();
          if (((Float)((Pair)localObject5).second).floatValue() >= 0.0F)
          {
            ((StringBuilder)localObject3).append("+").append(((Pair)localObject5).second);
            j = i;
            break label494;
          }
          ((StringBuilder)localObject3).append(((Pair)localObject5).second);
          j = i;
          break label494;
          if ("G2".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float G2=G*G;\n");
            i = j;
            break;
          }
          if ("B2".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float B2=B*B;\n");
            i = j;
            break;
          }
          if ("RG".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float RG=R*G;\n");
            i = j;
            break;
          }
          if ("RB".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float RB=R*B;\n");
            i = j;
            break;
          }
          if ("GB".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float GB=G*B;\n");
            i = j;
            break;
          }
          if ("RGB".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float RGB=R*G*B;\n");
            i = j;
            break;
          }
          if ("R_2".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float R_2=sqrt(R);\n");
            i = j;
            break;
          }
          if ("G_2".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float G_2=sqrt(G);\n");
            i = j;
            break;
          }
          if ("B_2".equals(((Pair)localObject5).first))
          {
            ((StringBuilder)localObject2).append("float B_2=sqrt(B);\n");
            i = j;
            break;
          }
          i = j;
          if (!"dCbCr".equals(((Pair)localObject5).first)) {
            break;
          }
          ((StringBuilder)localObject2).append("float dCbCr=distance(vec2(-0.168736*R-0.331264*G+0.5*B, 0.5*R-0.418688*B-0.081312*B), vec2(-0.168736*bgR-0.331264*bgG+0.5*bgB, 0.5*bgR-0.418688*bgB-0.081312*bgB));\n");
          i = j;
          break;
          ((StringBuilder)localObject3).append(";\n");
          ((StringBuilder)localObject2).append((CharSequence)localObject3);
          if (f4 > 0.0D) {
            ((StringBuilder)localObject2).append("u_clipBlack = ").append(f4).append(";\n");
          }
          if (f3 < 1.0D) {
            ((StringBuilder)localObject2).append("u_clipWhite = ").append(f3).append(";\n");
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject4 = (Pair)((Iterator)localObject1).next();
              ((StringBuilder)localObject3).append((String)((Pair)localObject4).first).append(":").append(((Pair)localObject4).second).append(";");
            }
            ((StringBuilder)localObject3).append("\n          old string = \n").append(paramString1);
            ((StringBuilder)localObject3).append("\n          mainKeyingMiddle = \n").append(((StringBuilder)localObject2).toString());
            QLog.i("CustomizeKey", 2, "buildMachineLearningFragmentShader params: \n" + ((StringBuilder)localObject3).toString());
          }
          localStringBuilder.append((CharSequence)localObject2);
          break label565;
          paramString1.append("//用户自己定义变量及方法相关片段\n");
          break label608;
          paramString1.append("    //用户定义片段，用于在获取颜色值前处理, 如纹理坐标改变\n");
          break label628;
          paramString1.append(alkh.c);
        }
        i += 1;
        float f2 = f3;
        float f1 = f4;
      }
    }
    f3 = f2;
    f4 = f1;
    if (i < j)
    {
      localObject4 = localObject2[i];
      f3 = f2;
      f4 = f1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject5 = ((String)localObject4).split(":");
        f3 = f2;
        f4 = f1;
        if (localObject5 != null)
        {
          f3 = f2;
          f4 = f1;
          if (localObject5.length == 2)
          {
            localObject4 = localObject5[0];
            localObject5 = Float.valueOf(localObject5[1]);
            if (((HashMap)localObject3).get(localObject4) != null)
            {
              ((ArrayList)localObject1).add(new Pair(localObject4, localObject5));
              f3 = f2;
              f4 = f1;
            }
            else if ("u_clipBlack".equals(localObject4))
            {
              f4 = ((Float)localObject5).floatValue();
              f3 = f2;
            }
            else
            {
              f3 = f2;
              f4 = f1;
              if ("u_clipWhite".equals(localObject4))
              {
                f3 = ((Float)localObject5).floatValue();
                f4 = f1;
              }
            }
          }
        }
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("alpha = ");
      i = 1;
      localObject4 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label1012;
        }
        localObject5 = (Pair)((Iterator)localObject4).next();
        if (i == 0) {
          break;
        }
        ((StringBuilder)localObject3).append(((Pair)localObject5).second);
        j = 0;
        if (!"b".equals(((Pair)localObject5).first)) {
          ((StringBuilder)localObject3).append("*").append((String)((Pair)localObject5).first);
        }
        if (!"R2".equals(((Pair)localObject5).first)) {
          break label728;
        }
        ((StringBuilder)localObject2).append("float R2=R*R;\n");
        i = j;
      }
    }
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(alkh.a(this.o));
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "u_currentTime");
  }
  
  protected void a(alkg paramalkg)
  {
    if (paramalkg == null) {}
    while (this.a == -1) {
      return;
    }
    GLES20.glUniform1f(this.a, paramalkg.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljy
 * JD-Core Version:    0.7.0.1
 */