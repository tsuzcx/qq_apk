import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class aiwc
{
  public static int a(Paint paramPaint)
  {
    return (int)(1.0F + paramPaint.measureText(ajyc.a(2131700293)));
  }
  
  public static void a(int paramInt1, int paramInt2, aiwe paramaiwe, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null, paramInt1, paramInt2, paramaiwe, paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public static void a(aiwe paramaiwe, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramaiwe != null) {
      a(paramaiwe.a(), paramaiwe.b(), paramaiwe, paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, aiwe paramaiwe, Context paramContext, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramaiwe == null) || (paramContext == null) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (paramString3.length() > 12) {
      paramString3 = paramString3.substring(0, 11) + "...";
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 0) {
        i = paramaiwe.a();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramaiwe.b();
      }
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      aiwd localaiwd1 = new aiwd(paramaiwe.a(), bbct.a(), i, paramInt1, paramString2, paramString3);
      float f1 = i;
      localaiwd1.a = f1;
      localaiwd1.e = f1;
      localaiwd1.jdField_b_of_type_Float = 0.0F;
      localaiwd1.f = 0.0F;
      localaiwd1.c = (-i / 4000.0F);
      localaiwd1.jdField_d_of_type_Float = 0.0F;
      localaiwd1.jdField_h_of_type_Float = 1.0F;
      localaiwd1.g = (17.0F * paramContext.getResources().getDisplayMetrics().scaledDensity);
      localaiwd1.jdField_b_of_type_Boolean = true;
      localaiwd1.jdField_b_of_type_JavaLangString = paramString1;
      Random localRandom = new Random();
      paramInt2 = 0;
      while (paramInt2 < 5)
      {
        aiwd localaiwd2 = new aiwd(paramaiwe.a(), bbct.a(), i, paramInt1, paramString2, paramString3);
        localaiwd2.c = (-i / (3000.0F - paramInt2 * 500));
        localaiwd2.jdField_d_of_type_Float = 0.0F;
        int j = localRandom.nextInt(3);
        localaiwd2.jdField_d_of_type_Int = ((int)(new float[] { 0.6F, 0.8F, 1.0F }[j] * 255.0F));
        localaiwd2.g = (new int[] { 14, 14, 12, 12, 12 }[paramInt2] * paramContext.getResources().getDisplayMetrics().scaledDensity);
        localaiwd2.jdField_h_of_type_Float = aivz.a(localaiwd1, localaiwd2);
        f1 = i * localRandom.nextFloat() + i / 2;
        localaiwd2.a = f1;
        localaiwd2.e = f1;
        f1 = paramInt1;
        float f2 = aivz.a(localaiwd2.g);
        float f3 = localaiwd2.jdField_h_of_type_Int * 2;
        f1 = (paramInt1 - (f1 * 0.28F + f2 + f3)) * localRandom.nextFloat();
        localaiwd2.jdField_b_of_type_Float = f1;
        localaiwd2.f = f1;
        localaiwd2.jdField_b_of_type_Boolean = true;
        localaiwd2.jdField_b_of_type_JavaLangString = paramString1;
        localArrayList.add(localaiwd2);
        paramInt2 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBarrageUtil", 2, "bulkApolloBarrages use:" + (System.currentTimeMillis() - l));
      }
      localArrayList.add(localaiwd1);
      paramaiwe.a(localArrayList, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwc
 * JD-Core Version:    0.7.0.1
 */