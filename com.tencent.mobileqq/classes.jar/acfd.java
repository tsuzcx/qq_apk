import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class acfd
  extends bbwf
{
  public acfd(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambbwg);
    }
    super.onCancel(parambbwg);
  }
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + parambbwg);
    }
    if (parambbwg.b()) {}
    do
    {
      return;
      if (parambbwg.a() == -1)
      {
        parambbwg = new Message();
        parambbwg.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambbwg);
        return;
      }
      parambbwg = this.a.jdField_a_of_type_Ho.a(this.a.e);
    } while (parambbwg == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambbwg;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + parambbwg);
    }
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfd
 * JD-Core Version:    0.7.0.1
 */