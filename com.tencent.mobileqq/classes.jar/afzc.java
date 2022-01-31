import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class afzc
  extends bdvu
{
  afzc(afyz paramafyz, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambdvv);
    }
  }
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambdvv);
    }
    if (parambdvv.b()) {}
    do
    {
      return;
      parambdvv.a().getInt("type");
    } while (parambdvv.a() == -1);
    parambdvv = new Message();
    parambdvv.what = afyz.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambdvv);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambdvv);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzc
 * JD-Core Version:    0.7.0.1
 */