import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aasg
  implements aasd
{
  aasg(aasf paramaasf, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess", false);
    if (bool)
    {
      paramBundle = paramBundle.getString("data");
      this.jdField_a_of_type_Aasf.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_Aasf.TAG, 2, "getTroopBarPublishInfo() in callback isSuccess=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasg
 * JD-Core Version:    0.7.0.1
 */