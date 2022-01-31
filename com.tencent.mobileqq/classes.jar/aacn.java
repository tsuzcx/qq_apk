import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

abstract class aacn
  extends akuo
{
  long jdField_a_of_type_Long;
  aabi jdField_a_of_type_Aabi;
  boolean jdField_a_of_type_Boolean;
  long b;
  
  public aacn(aabi paramaabi, int paramInt, long paramLong)
  {
    super(paramInt, true, true, paramLong, true, false, "Doraemon");
    this.jdField_a_of_type_Aabi = paramaabi;
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
    aaep.a(this.jdField_a_of_type_Aabi, paramInt1, "error " + paramInt1);
    Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    SosoInterface.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacn
 * JD-Core Version:    0.7.0.1
 */