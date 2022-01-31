import com.tencent.qphone.base.util.QLog;

public class aksz
  extends akti
{
  public long a;
  public aktb a;
  public aktc a;
  
  public aksz()
  {
    this.jdField_a_of_type_Aktc = new aktc();
    this.jdField_a_of_type_Aktb = new aktb();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Aktc.a();
    this.jdField_a_of_type_Aktb.a();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_Aktc + ", circleResult = " + this.jdField_a_of_type_Aktb + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aksz
 * JD-Core Version:    0.7.0.1
 */