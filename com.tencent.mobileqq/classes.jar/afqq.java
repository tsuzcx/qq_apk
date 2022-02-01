import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class afqq
  extends biht
{
  public afqq(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambihu);
    }
    super.onCancel(parambihu);
  }
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + parambihu);
    }
    if (parambihu.b()) {}
    do
    {
      return;
      if (parambihu.a() == -1)
      {
        parambihu = new Message();
        parambihu.what = 17;
        TextPreviewSettingActivity.a(this.a).sendMessage(parambihu);
        return;
      }
      parambihu = TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a));
    } while (parambihu == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambihu;
    TextPreviewSettingActivity.a(this.a).sendMessage(localMessage);
  }
  
  public boolean onStart(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + parambihu);
    }
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqq
 * JD-Core Version:    0.7.0.1
 */