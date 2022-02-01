import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aklc
  extends ntf
{
  aklc(aklb paramaklb, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "checkOpenidDiff, onResult, errorCode=", Integer.valueOf(paramInt) });
    }
    if ((this.jdField_a_of_type_Aklb.a.isFinishing()) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L)) {}
    while (paramInt != 16) {
      return;
    }
    akkz.b(this.jdField_a_of_type_Aklb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklc
 * JD-Core Version:    0.7.0.1
 */