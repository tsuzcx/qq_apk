import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class albl
{
  public static final float[] a;
  public static final short[] a;
  public static final float[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -0.5F, 0.5F, 0.0F, 0.0F, 1.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 1.0F, 0.0F, 0.5F, 0.5F, 0.0F, 1.0F, 1.0F };
    b = new float[] { -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 1.0F, 0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.0F, 1.0F, 0.0F };
    jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 2, 3, 0 };
  }
  
  public static int a(albk paramalbk)
  {
    if ((paramalbk == null) || (paramalbk.a == null)) {}
    for (;;)
    {
      return 0;
      try
      {
        int i = ((ArVideoResourceInfo)paramalbk.a.a.get(0)).jdField_b_of_type_Int;
        if (i >= 0) {}
        for (;;)
        {
          return i;
          i = 0;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Throwable paramalbk) {}
    }
    paramalbk.printStackTrace();
    return 0;
  }
  
  public static aldz a(String paramString)
  {
    aldz localaldz = new aldz();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 1) {
          localaldz.jdField_a_of_type_Int = Integer.valueOf(paramString[0]).intValue();
        }
        if (paramString.length >= 2) {
          localaldz.jdField_b_of_type_Int = Integer.valueOf(paramString[1]).intValue();
        }
      }
    }
    return localaldz;
  }
  
  public static aldz a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString);
    if ((paramString.jdField_a_of_type_Int == 0) || (paramString.jdField_b_of_type_Int == 0)) {
      return paramString;
    }
    int i = paramString.jdField_a_of_type_Int;
    int j = paramString.jdField_b_of_type_Int;
    if (paramInt2 * 1.0F / j > paramInt1 * 1.0F / i)
    {
      paramInt1 = j * 1 * paramInt1 / i;
      paramString.jdField_a_of_type_Float = 2.0F;
    }
    for (paramString.jdField_b_of_type_Float = (paramInt1 * 2.0F / paramInt2);; paramString.jdField_b_of_type_Float = 2.0F)
    {
      paramString.c = 0.0F;
      paramString.d = 0.0F;
      paramString.e = 0.0F;
      return paramString;
      paramString.jdField_a_of_type_Float = (i * 1 * paramInt2 / j * 2.0F / paramInt1);
    }
  }
  
  public static aldz a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    aldz localaldz = a(paramString);
    if ((localaldz.jdField_a_of_type_Int == 0) || (localaldz.jdField_b_of_type_Int == 0))
    {
      localaldz.jdField_a_of_type_Int = paramInt1;
      localaldz.jdField_b_of_type_Int = paramInt2;
    }
    float f7 = paramInt1 * 1.0F / Math.max(1, paramInt2);
    float f8 = localaldz.jdField_a_of_type_Int;
    float f9 = localaldz.jdField_b_of_type_Int;
    float f2 = 1.0F;
    float f1 = 1.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 1.0F * f8 / f9;
    float f5;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 3) {
          f2 = Float.valueOf(paramString[2]).floatValue();
        }
        if (paramString.length >= 4) {
          f1 = Float.valueOf(paramString[3]).floatValue();
        }
        if (paramString.length >= 5) {
          f3 = Float.valueOf(paramString[4]).floatValue();
        }
        if (paramString.length >= 6) {
          f4 = -Float.valueOf(paramString[5]).floatValue();
        }
        f5 = f4;
        paramInt2 = 1;
        f4 = f3;
        f3 = f5;
      }
    }
    for (;;)
    {
      paramInt1 = 1;
      f5 = f1;
      float f6 = f2;
      if (paramInt2 != 0)
      {
        if ((f2 <= 0.05F) || (f1 <= 0.05F)) {
          break label385;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f6 = f2;
          f5 = f1;
        }
      }
      else
      {
        if (!paramBoolean) {
          break label500;
        }
        localaldz.jdField_a_of_type_Float = (10.0F * f7);
        localaldz.jdField_b_of_type_Float = 10.0F;
        localaldz.c = 0.0F;
        localaldz.d = 0.0F;
        localaldz.e = -5.0F;
        if (paramInt2 != 0)
        {
          if (paramInt1 == 0) {
            break label459;
          }
          localaldz.jdField_a_of_type_Float *= f6;
          localaldz.jdField_b_of_type_Float = (localaldz.jdField_a_of_type_Float * (f9 / f8));
          f1 = localaldz.jdField_a_of_type_Float / 2.0F;
          label320:
          localaldz.c = (f4 * f7 / f1);
          localaldz.d = (f3 / f1);
        }
      }
      label385:
      label459:
      label500:
      do
      {
        QLog.i("ARVideoUtil", 1, "parseVideoLayout layout = " + localaldz);
        return localaldz;
        paramInt1 = 0;
        f5 = f1;
        f6 = f2;
        break;
        if (f2 > 0.05F)
        {
          paramInt1 = 1;
          f5 = f1;
          f6 = f2;
          break;
        }
        if (f1 > 0.05F)
        {
          paramInt1 = 0;
          f5 = f1;
          f6 = f2;
          break;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f6 = 1.0F;
          f5 = f1;
          break;
        }
        paramInt1 = 0;
        f5 = 1.0F;
        f6 = f2;
        break;
        localaldz.jdField_b_of_type_Float *= f5;
        localaldz.jdField_a_of_type_Float = (localaldz.jdField_b_of_type_Float * (f8 / f9));
        f1 = localaldz.jdField_b_of_type_Float / 2.0F;
        break label320;
        localaldz.jdField_a_of_type_Float = 2.0F;
        localaldz.jdField_b_of_type_Float = 2.0F;
        localaldz.c = 0.0F;
        localaldz.d = 0.0F;
        localaldz.e = 0.0F;
      } while (paramInt2 == 0);
      if (paramInt1 != 0)
      {
        localaldz.jdField_a_of_type_Float *= f6;
        localaldz.jdField_b_of_type_Float = (localaldz.jdField_a_of_type_Float * f7 * (f9 / f8));
      }
      for (f1 = localaldz.jdField_a_of_type_Float / 2.0F;; f1 = localaldz.jdField_b_of_type_Float / 2.0F)
      {
        localaldz.c = (f4 / f1);
        localaldz.d = (f3 / f1);
        break;
        localaldz.jdField_b_of_type_Float *= f5;
        localaldz.jdField_a_of_type_Float = (localaldz.jdField_b_of_type_Float / f7 * (f8 / f9));
      }
      f4 = 0.0F;
      f2 = 1.0F;
      f3 = 0.0F;
      paramInt2 = 0;
    }
  }
  
  public static Pair<Integer, alkh> a(albk paramalbk)
  {
    int k = 0;
    alkh localalkh = alkg.a(0);
    if (paramalbk.a.d == 2) {}
    for (;;)
    {
      int j;
      try
      {
        j = Integer.parseInt(((ArVideoResourceInfo)paramalbk.a.a.get(0)).jdField_a_of_type_JavaLangString);
        if (j < 0)
        {
          i = k;
          return new Pair(Integer.valueOf(i), localalkh);
        }
      }
      catch (Throwable paramalbk)
      {
        j = 0;
        continue;
        if (j != 0)
        {
          i = k;
          if (j != 1) {
            continue;
          }
        }
        i = j;
        continue;
      }
      if (paramalbk.a.d != 3)
      {
        i = k;
        if (paramalbk.a.d != 4) {}
      }
      else if ((paramalbk.a.d == 4) && ("circle".equalsIgnoreCase(((ArVideoResourceInfo)paramalbk.a.a.get(0)).jdField_a_of_type_JavaLangString)))
      {
        i = 1;
      }
      else
      {
        try
        {
          paramalbk = ((ArVideoResourceInfo)paramalbk.a.a.get(0)).jdField_a_of_type_JavaLangString.split("\\|");
          if ((paramalbk == null) || (paramalbk.length < 5)) {
            break;
          }
          i = Integer.parseInt(paramalbk[0]);
          j = Integer.parseInt(paramalbk[1]);
          int m = Integer.parseInt(paramalbk[2]);
          int n = Integer.parseInt(paramalbk[3]);
          int i1 = Integer.parseInt(paramalbk[4]);
          if ((i > 255) || (j > 255) || (m > 255) || (n > 255) || (i < 0) || (j < 0) || (m < 0) || (n < 0) || (i1 < 0) || (i1 > 100)) {
            break label601;
          }
          localalkh.a(i / 255.0F, j / 255.0F, m / 255.0F);
          localalkh.jdField_a_of_type_Int = 1;
          localalkh.d = (n / 255.0F);
          localalkh.e = (i1 / 100.0F);
          if ((paramalbk != null) && (paramalbk.length >= 6) && (Integer.parseInt(paramalbk[5]) == 1)) {
            localalkh.jdField_a_of_type_Int = 2;
          }
          if ((paramalbk != null) && (paramalbk.length >= 8))
          {
            i = Integer.parseInt(paramalbk[6]);
            paramalbk = paramalbk[7];
            if ((i == 2) && (!TextUtils.isEmpty(paramalbk)))
            {
              paramalbk = paramalbk.split(";");
              if ((paramalbk == null) || (paramalbk.length != 3)) {
                break label606;
              }
              localalkh.f = Float.valueOf(paramalbk[0]).floatValue();
              localalkh.g = Float.valueOf(paramalbk[1]).floatValue();
              localalkh.h = Float.valueOf(paramalbk[2]).floatValue();
              localalkh.jdField_a_of_type_Int = 3;
              break label606;
            }
            if ((i == 3) && (!TextUtils.isEmpty(paramalbk)))
            {
              paramalbk = paramalbk.split(";");
              if ((paramalbk == null) || (paramalbk.length != 3)) {
                break label611;
              }
              localalkh.f = Float.valueOf(paramalbk[0]).floatValue();
              localalkh.g = Float.valueOf(paramalbk[1]).floatValue();
              localalkh.h = Float.valueOf(paramalbk[2]).floatValue();
              localalkh.jdField_a_of_type_Int = 4;
              break label611;
            }
            if ((i == 4) && (!TextUtils.isEmpty(paramalbk)))
            {
              localalkh.jdField_a_of_type_JavaLangString = aljz.a(paramalbk, "uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n");
              localalkh.jdField_a_of_type_Int = 5;
            }
          }
          i = 2;
        }
        catch (Throwable paramalbk)
        {
          i = k;
        }
        if (QLog.isColorLevel())
        {
          paramalbk.printStackTrace();
          i = k;
        }
      }
    }
    int i = 0;
    break label603;
    label601:
    i = 0;
    for (;;)
    {
      label603:
      break;
      label606:
      i = 2;
      continue;
      label611:
      i = 2;
    }
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QLog.d("ARVideoUtil", 1, paramString + ": glError " + i);
    }
  }
  
  public static boolean a()
  {
    String str = Build.MODEL.toLowerCase();
    return (Build.MANUFACTURER.toLowerCase().contains("meizu")) && (str.contains("m040"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     albl
 * JD-Core Version:    0.7.0.1
 */