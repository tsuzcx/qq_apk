import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class alfw
  extends alhb
{
  private StringBuilder a;
  
  public alfw(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
      return "";
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  public boolean a(agpd paramagpd, String paramString, float paramFloat1, int paramInt, float paramFloat2)
  {
    if ((paramagpd == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return false;
        paramagpd = algo.a(paramagpd, 28, 28, paramFloat2);
        localObject1 = a(paramagpd);
        algo.a(paramagpd);
      } while (localObject1 == null);
      Object localObject2 = a((float[][][][])localObject1);
      paramagpd = new HashSet();
      Object localObject1 = new LinkedList();
      paramFloat2 = Math.min(0.01F, paramFloat1);
      if (localObject2 != null)
      {
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((localObject2.length > paramInt) && (localObject2[paramInt] > paramFloat2))
          {
            ((List)localObject1).add(new alfy((String)this.jdField_a_of_type_JavaUtilList.get(paramInt), localObject2[paramInt]));
            if ((localObject2[paramInt] > paramFloat1) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
              paramagpd.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
            }
          }
          paramInt += 1;
        }
      }
      Collections.sort((List)localObject1, new alfx(this));
      localObject2 = new StringBuilder();
      paramInt = 0;
      while ((paramInt < 20) && (paramInt < ((List)localObject1).size()))
      {
        alfy localalfy = (alfy)((List)localObject1).get(paramInt);
        ((StringBuilder)localObject2).append(localalfy.jdField_a_of_type_JavaLangString + ":" + localalfy.jdField_a_of_type_Float + "\n");
        paramInt += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder = ((StringBuilder)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier.DefaultClassifier", 2, "recog result:" + ((StringBuilder)localObject2).toString());
      }
      if (paramagpd.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier.DefaultClassifier", 2, "recognition succ:" + paramString);
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DrawClassifier.DefaultClassifier", 2, "recognition failed:" + paramString);
    return false;
  }
  
  public float[][][][] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return (float[][][][])null;
    }
    float[][][][] arrayOfFloat = (float[][][][])Array.newInstance(Float.TYPE, new int[] { 1, 28, 28, 1 });
    int[] arrayOfInt1 = new int[784];
    float[] arrayOfFloat1 = new float[arrayOfInt1.length];
    int[] arrayOfInt2 = new int[784];
    paramBitmap.getPixels(arrayOfInt2, 0, paramBitmap.getWidth(), 0, 0, 28, 28);
    int i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfInt1[i] = 255;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt2.length)
    {
      arrayOfInt2[i] &= 0xFF;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfFloat1[i] = (1.0F - arrayOfInt1[i] / 255.0F);
      i += 1;
    }
    int m = arrayOfFloat1.length;
    i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfFloat1[i] != 0.0F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j < 40) {
      return (float[][][][])null;
    }
    i = 0;
    while (i < arrayOfFloat[0].length)
    {
      j = 0;
      while (j < arrayOfFloat[0][i].length)
      {
        arrayOfFloat[0][i][j][0] = arrayOfFloat1[(i * 28 + j)];
        j += 1;
      }
      i += 1;
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfw
 * JD-Core Version:    0.7.0.1
 */