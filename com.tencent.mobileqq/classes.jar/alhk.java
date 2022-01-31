import com.tencent.qphone.base.util.QLog;

public class alhk
  extends alht
{
  public long a;
  public alhm a;
  public alhn a;
  
  public alhk()
  {
    this.jdField_a_of_type_Alhn = new alhn();
    this.jdField_a_of_type_Alhm = new alhm();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Alhn.a();
    this.jdField_a_of_type_Alhm.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Alhn + ", circleResult = " + this.jdField_a_of_type_Alhm + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alhk
 * JD-Core Version:    0.7.0.1
 */