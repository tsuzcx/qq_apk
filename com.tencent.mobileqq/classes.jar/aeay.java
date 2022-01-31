import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class aeay
  extends bead
{
  public aeay(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambeae);
    }
    super.onCancel(parambeae);
  }
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + parambeae);
    }
    if (parambeae.b()) {}
    do
    {
      return;
      if (parambeae.a() == -1)
      {
        parambeae = new Message();
        parambeae.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambeae);
        return;
      }
      parambeae = this.a.jdField_a_of_type_Fx.a(this.a.e);
    } while (parambeae == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambeae;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + parambeae);
    }
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeay
 * JD-Core Version:    0.7.0.1
 */