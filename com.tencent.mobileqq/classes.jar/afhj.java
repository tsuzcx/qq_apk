import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class afhj
  extends bhhe
{
  public afhj(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambhhf);
    }
    super.onCancel(parambhhf);
  }
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + parambhhf);
    }
    if (parambhhf.b()) {}
    do
    {
      return;
      if (parambhhf.a() == -1)
      {
        parambhhf = new Message();
        parambhhf.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambhhf);
        return;
      }
      parambhhf = this.a.jdField_a_of_type_Gc.a(this.a.e);
    } while (parambhhf == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambhhf;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + parambhhf);
    }
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhj
 * JD-Core Version:    0.7.0.1
 */