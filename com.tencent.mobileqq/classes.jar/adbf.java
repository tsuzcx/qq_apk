import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.qphone.base.util.QLog;

abstract class adbf
  extends SosoInterface.OnLocationListener
{
  long jdField_a_of_type_Long;
  adaa jdField_a_of_type_Adaa;
  boolean jdField_a_of_type_Boolean;
  long b;
  
  public adbf(adaa paramadaa, int paramInt, long paramLong)
  {
    super(paramInt, true, true, paramLong, true, false, "Doraemon");
    this.jdField_a_of_type_Adaa = paramadaa;
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
    addh.a(this.jdField_a_of_type_Adaa, paramInt1, "error " + paramInt1);
    Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    SosoInterface.removeOnLocationListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbf
 * JD-Core Version:    0.7.0.1
 */