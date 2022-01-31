import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class ahfp
  implements myy
{
  ahfp(ahfo paramahfo, String paramString, int paramInt) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "CODE_SUCCESS[" + this.jdField_a_of_type_JavaLangString + ", " + paramInt + ", " + paramString + "]");
    }
    if ((paramInt == 0) && (paramString == null))
    {
      bbkb.h(ahfo.a(this.jdField_a_of_type_Ahfo), ahfo.a(this.jdField_a_of_type_Ahfo).getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int + 1);
      bbkb.b(ahfo.a(this.jdField_a_of_type_Ahfo), ahfo.a(this.jdField_a_of_type_Ahfo).getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, NetConnInfoCenter.getServerTimeMillis());
    }
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "progress[" + paramInt + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfp
 * JD-Core Version:    0.7.0.1
 */