import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class akxv
  implements albh
{
  public static int a;
  private long jdField_a_of_type_Long;
  private akxw jdField_a_of_type_Akxw;
  private albf jdField_a_of_type_Albf;
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = 8;
  }
  
  public akxv(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Albf = new albf();
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    long l;
    if (this.jdField_a_of_type_Long != 0L)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 1000L) {}
    }
    label35:
    label195:
    label197:
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Long = l;
        if (paramFloat2 > jdField_a_of_type_Int) {}
        for (int i = 1;; i = 2)
        {
          if (this.jdField_b_of_type_Int == i) {
            break label195;
          }
          QLog.i("ARPhonePoseDetectManager", 1, "detectPhonePose. data = " + paramFloat1 + "," + paramFloat2 + "," + paramFloat3 + "," + paramLong + ", mPhonePose = " + this.jdField_b_of_type_Int + ", phonePose = " + i);
          if ((i == 2) && (this.jdField_b_of_type_Boolean)) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_b_of_type_Int = i;
          if (this.jdField_a_of_type_Akxw == null) {
            break;
          }
          if (this.jdField_b_of_type_Int != 1) {
            break label197;
          }
          this.jdField_a_of_type_Akxw.a(true);
          return;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          break label35;
        }
      }
    } while (this.jdField_b_of_type_Int != 2);
    this.jdField_a_of_type_Akxw.a(false);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Albf.a(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Albf.b();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    b(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(akxw paramakxw)
  {
    this.jdField_a_of_type_Akxw = paramakxw;
  }
  
  public void a(float[] paramArrayOfFloat) {}
  
  public void b()
  {
    this.jdField_a_of_type_Albf.c();
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxv
 * JD-Core Version:    0.7.0.1
 */