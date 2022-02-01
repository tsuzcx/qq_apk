import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class aejf
  extends bgod
{
  public aejf(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambgoe);
    }
    super.onCancel(parambgoe);
  }
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + parambgoe);
    }
    if (parambgoe.b()) {}
    do
    {
      return;
      if (parambgoe.a() == -1)
      {
        parambgoe = new Message();
        parambgoe.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambgoe);
        return;
      }
      parambgoe = this.a.jdField_a_of_type_Gb.a(this.a.e);
    } while (parambgoe == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambgoe;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + parambgoe);
    }
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejf
 * JD-Core Version:    0.7.0.1
 */