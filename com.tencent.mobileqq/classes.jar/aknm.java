import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class aknm
{
  public static int a(Paint paramPaint)
  {
    return (int)(1.0F + paramPaint.measureText(alpo.a(2131700673)));
  }
  
  public static void a(int paramInt1, int paramInt2, akno paramakno, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null, paramInt1, paramInt2, paramakno, paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public static void a(akno paramakno, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramakno != null) {
      a(paramakno.a(), paramakno.b(), paramakno, paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, akno paramakno, Context paramContext, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramakno == null) || (paramContext == null) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (paramString3.length() > 12) {
      paramString3 = paramString3.substring(0, 11) + "...";
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 0) {
        i = paramakno.a();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramakno.b();
      }
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      aknn localaknn1 = new aknn(paramakno.a(), bdcb.a(), i, paramInt1, paramString2, paramString3);
      float f1 = i;
      localaknn1.a = f1;
      localaknn1.e = f1;
      localaknn1.jdField_b_of_type_Float = 0.0F;
      localaknn1.f = 0.0F;
      localaknn1.c = (-i / 4000.0F);
      localaknn1.jdField_d_of_type_Float = 0.0F;
      localaknn1.jdField_h_of_type_Float = 1.0F;
      localaknn1.g = (17.0F * paramContext.getResources().getDisplayMetrics().scaledDensity);
      localaknn1.jdField_b_of_type_Boolean = true;
      localaknn1.jdField_b_of_type_JavaLangString = paramString1;
      Random localRandom = new Random();
      paramInt2 = 0;
      while (paramInt2 < 5)
      {
        aknn localaknn2 = new aknn(paramakno.a(), bdcb.a(), i, paramInt1, paramString2, paramString3);
        localaknn2.c = (-i / (3000.0F - paramInt2 * 500));
        localaknn2.jdField_d_of_type_Float = 0.0F;
        int j = localRandom.nextInt(3);
        localaknn2.jdField_d_of_type_Int = ((int)(new float[] { 0.6F, 0.8F, 1.0F }[j] * 255.0F));
        localaknn2.g = (new int[] { 14, 14, 12, 12, 12 }[paramInt2] * paramContext.getResources().getDisplayMetrics().scaledDensity);
        localaknn2.jdField_h_of_type_Float = aknj.a(localaknn1, localaknn2);
        f1 = i * localRandom.nextFloat() + i / 2;
        localaknn2.a = f1;
        localaknn2.e = f1;
        f1 = paramInt1;
        float f2 = aknj.a(localaknn2.g);
        float f3 = localaknn2.jdField_h_of_type_Int * 2;
        f1 = (paramInt1 - (f1 * 0.28F + f2 + f3)) * localRandom.nextFloat();
        localaknn2.jdField_b_of_type_Float = f1;
        localaknn2.f = f1;
        localaknn2.jdField_b_of_type_Boolean = true;
        localaknn2.jdField_b_of_type_JavaLangString = paramString1;
        localArrayList.add(localaknn2);
        paramInt2 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBarrageUtil", 2, "bulkApolloBarrages use:" + (System.currentTimeMillis() - l));
      }
      localArrayList.add(localaknn1);
      paramakno.a(localArrayList, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknm
 * JD-Core Version:    0.7.0.1
 */