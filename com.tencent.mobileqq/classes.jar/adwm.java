import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class adwm
  extends bdvu
{
  public adwm(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambdvv);
    }
    super.onCancel(parambdvv);
  }
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + parambdvv);
    }
    if (parambdvv.b()) {}
    do
    {
      return;
      if (parambdvv.a() == -1)
      {
        parambdvv = new Message();
        parambdvv.what = 17;
        TextPreviewSettingActivity.a(this.a).sendMessage(parambdvv);
        return;
      }
      parambdvv = TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a));
    } while (parambdvv == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambdvv;
    TextPreviewSettingActivity.a(this.a).sendMessage(localMessage);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + parambdvv);
    }
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwm
 * JD-Core Version:    0.7.0.1
 */