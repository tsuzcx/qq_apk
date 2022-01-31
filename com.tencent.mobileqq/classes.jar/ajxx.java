import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class ajxx
{
  private static ajxx jdField_a_of_type_Ajxx;
  public int a;
  long jdField_a_of_type_Long = 720000L;
  public String a;
  boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.94F, 0.6F, 0.0F };
  int[] jdField_a_of_type_ArrayOfInt = { 47185920, 68157440, 89128960, 120586240 };
  public int b;
  int[] b;
  public int c = 0;
  private int d = 1;
  private int e = -1;
  private int f = 1;
  
  private ajxx()
  {
    this.jdField_b_of_type_ArrayOfInt = new int[] { 3840000, 1920000, 960000, 720000, 600000 };
    this.jdField_a_of_type_Int = 12;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = "";
    Object localObject1 = DeviceProfileManager.a();
    Object localObject2 = ((DeviceProfileManager)localObject1).a("qq_process_gm");
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "config = " + (String)localObject2);
    }
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("0"))) {}
    int i;
    label359:
    do
    {
      do
      {
        return;
        localObject2 = ((String)localObject2).split("__");
        if (localObject2.length > 1) {
          localObject1 = localObject2[(localObject1.jdField_a_of_type_Int % localObject2.length)];
        }
        for (;;)
        {
          localObject1 = ((String)localObject1).split(";");
          if (localObject1.length < 4) {
            break;
          }
          try
          {
            localObject2 = localObject1[0].split("\\|");
            i = 0;
            for (;;)
            {
              if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
                break label359;
              }
              j = Integer.parseInt(localObject2[i]);
              if ((j <= 20) || (j >= 200)) {
                break;
              }
              this.jdField_a_of_type_ArrayOfInt[i] = (j * 1024 * 1024);
              i += 1;
            }
            localObject1 = localObject2[0];
            continue;
            throw new IllegalArgumentException("Illegal memory size " + j);
          }
          catch (Throwable localThrowable1) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("GuardManager", 2, "Exception: ", localThrowable1);
      return;
      localObject2 = localThrowable1[1].split("\\|");
      i = 0;
      while (i < this.jdField_b_of_type_ArrayOfInt.length)
      {
        j = Integer.parseInt(localObject2[i]);
        if ((j > 5) && (j < 100))
        {
          this.jdField_b_of_type_ArrayOfInt[i] = (j * 60 * 1000);
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("Illegal timeout value " + j);
        }
      }
      localObject2 = localThrowable1[2].split("\\|");
      float f1;
      if (this.jdField_a_of_type_ArrayOfFloat.length < localObject2.length)
      {
        i = this.jdField_a_of_type_ArrayOfFloat.length;
        break label930;
        for (;;)
        {
          if (j >= i) {
            break label553;
          }
          f1 = Float.parseFloat(localObject2[j]);
          if ((f1 < 0.0F) || (f1 > 15.0F)) {
            break;
          }
          this.jdField_a_of_type_ArrayOfFloat[j] = f1;
          j += 1;
        }
      }
      i = localObject2.length;
      break label930;
      throw new IllegalArgumentException("Illegal fraction value " + f1);
      i = Integer.parseInt(localThrowable1[3].split("\\|")[0]);
      if ((i <= 1) || (i >= 120)) {
        break;
      }
      this.jdField_a_of_type_Long = (i * 60 * 1000);
    } while (localThrowable1.length <= 4);
    label479:
    localObject2 = localThrowable1[4].split("\\|");
    label553:
    int j = Integer.parseInt(localObject2[0]);
    if (j < 1) {
      i = 1;
    }
    for (;;)
    {
      for (;;)
      {
        if (24 % i == 0) {
          this.jdField_a_of_type_Int = i;
        }
        j = Integer.parseInt(localObject2[1]);
        if (j < 0) {
          i = 0;
        }
        for (;;)
        {
          for (;;)
          {
            this.jdField_b_of_type_Int = i;
            if (localThrowable1.length > 6)
            {
              this.c = Integer.parseInt(localThrowable1[5]);
              this.jdField_a_of_type_JavaLangString = localThrowable1[6];
            }
            if (localThrowable1.length > 7)
            {
              i = Integer.parseInt(localThrowable1[7]);
              if ((i >= 1) && (i < 10)) {
                com.tencent.mobileqq.app.GuardManager.c = i;
              }
            }
            if (localThrowable1.length > 8)
            {
              localObject2 = localThrowable1[8].split("\\|");
              if (localObject2.length > 0) {
                com.tencent.mobileqq.app.GuardManager.d = Integer.parseInt(localObject2[0]);
              }
              if (localObject2.length > 1) {
                com.tencent.mobileqq.app.GuardManager.e = Integer.parseInt(localObject2[1]);
              }
            }
            if (localThrowable1.length <= 9) {
              break label883;
            }
            i = Integer.parseInt(localThrowable1[9]);
            if (i != 1) {
              break;
            }
            try
            {
              String str1 = System.getProperty("ro.miui.ui.version.name");
              if ((TextUtils.isEmpty(str1)) || (str1.length() != 2) || (Integer.parseInt(str1.substring(1)) < 7)) {
                break;
              }
              this.jdField_a_of_type_Boolean = true;
              return;
            }
            catch (Throwable localThrowable2)
            {
              return;
            }
          }
          throw new IllegalArgumentException("Illegal wake interval " + i);
          i = j;
          if (j > this.jdField_a_of_type_Int) {
            i = this.jdField_a_of_type_Int;
          }
        }
        try
        {
          label883:
          String str2 = System.getProperty("ro.miui.ui.version.name");
          if ((TextUtils.isEmpty(str2)) || (str2.length() != 2) || (Integer.parseInt(str2.substring(1)) < 7)) {
            break;
          }
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        catch (Throwable localThrowable3)
        {
          return;
        }
      }
      label930:
      j = 0;
      break label479;
      i = j;
      if (j > 24) {
        i = 24;
      }
    }
  }
  
  public static ajxx a()
  {
    if (jdField_a_of_type_Ajxx == null) {}
    try
    {
      if (jdField_a_of_type_Ajxx == null) {
        jdField_a_of_type_Ajxx = new ajxx();
      }
      return jdField_a_of_type_Ajxx;
    }
    finally {}
  }
  
  public int a(long paramLong)
  {
    int j = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, (int)paramLong);
    int i = j;
    if (j < 0) {
      i = -1 - j;
    }
    j = i - this.d;
    if (j > 2) {
      i = 2;
    }
    do
    {
      return i;
      i = j;
    } while (j >= 0);
    return 0;
  }
  
  public int a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt2 != this.e)
    {
      paramInt1 = 0;
      float f2;
      for (float f1 = 0.0F; paramInt1 < 3; f1 += f2)
      {
        int i = 0;
        f2 = 0.0F;
        while (i < 15)
        {
          f2 += (float)paramArrayOfLong[paramInt1][i];
          i += 1;
        }
        f2 = this.jdField_a_of_type_ArrayOfFloat[paramInt1] * f2 * 5.0F / 15.0F;
        paramInt1 += 1;
      }
      paramInt1 = (int)(3.0F - f1);
      if (paramInt1 < 0) {
        paramInt1 = j;
      }
    }
    for (;;)
    {
      this.e = paramInt2;
      this.f = paramInt1;
      return paramInt1;
      if (paramInt1 > 2)
      {
        paramInt1 = 2;
        continue;
        return this.f;
      }
    }
  }
  
  public long a(long[][] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    return this.jdField_b_of_type_ArrayOfInt[(a(paramLong) + a(paramArrayOfLong, paramInt1, paramInt2))];
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajxx
 * JD-Core Version:    0.7.0.1
 */