import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class aeji
  extends bgod
{
  public aeji(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambgoe);
    }
    super.onCancel(parambgoe);
  }
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + parambgoe);
    }
    if (parambgoe.b()) {}
    do
    {
      return;
      if (parambgoe.a() == -1)
      {
        parambgoe = new Message();
        parambgoe.what = 17;
        TextPreviewSettingActivity.a(this.a).sendMessage(parambgoe);
        return;
      }
      parambgoe = TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a));
    } while (parambgoe == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambgoe;
    TextPreviewSettingActivity.a(this.a).sendMessage(localMessage);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + parambgoe);
    }
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeji
 * JD-Core Version:    0.7.0.1
 */