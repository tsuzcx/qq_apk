import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class abur
  extends batl
{
  public abur(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambatm);
    }
    super.onCancel(parambatm);
  }
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + parambatm);
    }
    if (parambatm.b()) {}
    do
    {
      return;
      if (parambatm.a() == -1)
      {
        parambatm = new Message();
        parambatm.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambatm);
        return;
      }
      parambatm = this.a.jdField_a_of_type_Fv.a(this.a.e);
    } while (parambatm == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambatm;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + parambatm);
    }
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abur
 * JD-Core Version:    0.7.0.1
 */