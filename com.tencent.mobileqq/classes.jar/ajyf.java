import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class ajyf
{
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigHandler", 2, "onReceivePreExec|" + paramString1 + "|" + paramString2 + "|" + paramString3);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyf
 * JD-Core Version:    0.7.0.1
 */