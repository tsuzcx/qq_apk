import com.tencent.qphone.base.util.QLog;

public class abwh
{
  public double a;
  public long a;
  public abwl a;
  public String a;
  
  public abwh()
  {
    this.jdField_a_of_type_Double = -1.0D;
  }
  
  public void a(abwg paramabwg)
  {
    this.jdField_a_of_type_Double = Math.max(this.jdField_a_of_type_Double, paramabwg.jdField_a_of_type_Double);
    this.jdField_a_of_type_Long = Math.max(this.jdField_a_of_type_Long, paramabwg.b);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Long > 0L)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Long < 9223372036854775807L)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Double >= 0.0D) {
          bool1 = true;
        }
      }
    }
    if ((!bool1) && (QLog.isColorLevel())) {
      QLog.i("reportToDenta", 2, "failed" + this.jdField_a_of_type_Long + " " + this.jdField_a_of_type_Double);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwh
 * JD-Core Version:    0.7.0.1
 */