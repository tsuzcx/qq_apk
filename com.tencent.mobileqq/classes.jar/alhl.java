import com.tencent.qphone.base.util.QLog;

public class alhl
  extends alhu
{
  public long a;
  public alhn a;
  public alho a;
  
  public alhl()
  {
    this.jdField_a_of_type_Alho = new alho();
    this.jdField_a_of_type_Alhn = new alhn();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Alho.a();
    this.jdField_a_of_type_Alhn.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Alho + ", circleResult = " + this.jdField_a_of_type_Alhn + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alhl
 * JD-Core Version:    0.7.0.1
 */