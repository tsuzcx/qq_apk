import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aipl
  extends nac
{
  aipl(aipk paramaipk, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "checkOpenidDiff, onResult, errorCode=", Integer.valueOf(paramInt) });
    }
    if ((this.jdField_a_of_type_Aipk.a.isFinishing()) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L)) {}
    while (paramInt != 16) {
      return;
    }
    aipi.b(this.jdField_a_of_type_Aipk.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipl
 * JD-Core Version:    0.7.0.1
 */