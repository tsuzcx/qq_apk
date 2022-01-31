import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class acfc
  extends bbwt
{
  public acfc(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambbwu);
    }
    super.onCancel(parambbwu);
  }
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + parambbwu);
    }
    if (parambbwu.b()) {}
    do
    {
      return;
      if (parambbwu.a() == -1)
      {
        parambbwu = new Message();
        parambbwu.what = 17;
        TextPreviewSettingActivity.a(this.a).sendMessage(parambbwu);
        return;
      }
      parambbwu = TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a));
    } while (parambbwu == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambbwu;
    TextPreviewSettingActivity.a(this.a).sendMessage(localMessage);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + parambbwu);
    }
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfc
 * JD-Core Version:    0.7.0.1
 */