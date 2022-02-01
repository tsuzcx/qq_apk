import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ahkx
  extends bhhe
{
  ahkx(ahku paramahku, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambhhf);
    }
  }
  
  public void onDone(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambhhf);
    }
    if (parambhhf.b()) {}
    do
    {
      return;
      parambhhf.a().getInt("type");
    } while (parambhhf.a() == -1);
    parambhhf = new Message();
    parambhhf.what = ahku.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambhhf);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambhhf);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkx
 * JD-Core Version:    0.7.0.1
 */