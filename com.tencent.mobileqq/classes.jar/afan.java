import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class afan
  extends bhyn
{
  public afan(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + parambhyo);
    }
    super.onCancel(parambhyo);
  }
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + parambhyo);
    }
    if (parambhyo.b()) {}
    do
    {
      return;
      if (parambhyo.a() == -1)
      {
        parambhyo = new Message();
        parambhyo.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambhyo);
        return;
      }
      parambhyo = this.a.jdField_a_of_type_Gb.a(this.a.e);
    } while (parambhyo == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = parambhyo;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + parambhyo);
    }
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afan
 * JD-Core Version:    0.7.0.1
 */