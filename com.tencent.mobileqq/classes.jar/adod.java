import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

abstract class adod
  extends apcq
{
  long jdField_a_of_type_Long;
  admy jdField_a_of_type_Admy;
  boolean jdField_a_of_type_Boolean;
  long b;
  
  public adod(admy paramadmy, int paramInt, long paramLong)
  {
    super(paramInt, true, true, paramLong, true, false, "Doraemon");
    this.jdField_a_of_type_Admy = paramadmy;
    this.b = 10000L;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.sensor.location", 2, "onConsecutiveFailure: errCode=" + paramInt1 + ", failCount=" + paramInt2);
    }
    if ((paramInt2 * 2000 < this.b) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    adqf.a(this.jdField_a_of_type_Admy, paramInt1, "error " + paramInt1);
    Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    SosoInterface.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adod
 * JD-Core Version:    0.7.0.1
 */