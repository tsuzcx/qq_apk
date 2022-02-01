import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class afhm
  extends bhhe
{
  public afhm(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambhhf);
    }
    super.onCancel(parambhhf);
  }
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + parambhhf);
    }
    if (parambhhf.b()) {}
    do
    {
      return;
      if (parambhhf.a() == -1)
      {
        parambhhf = new Message();
        parambhhf.what = 17;
        TextPreviewSettingActivity.a(this.a).sendMessage(parambhhf);
        return;
      }
      parambhhf = TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a));
    } while (parambhhf == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambhhf;
    TextPreviewSettingActivity.a(this.a).sendMessage(localMessage);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + parambhhf);
    }
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhm
 * JD-Core Version:    0.7.0.1
 */