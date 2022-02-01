import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ahuh
  extends biht
{
  ahuh(ahue paramahue, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambihu);
    }
  }
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambihu);
    }
    if (parambihu.b()) {}
    do
    {
      return;
      parambihu.a().getInt("type");
    } while (parambihu.a() == -1);
    parambihu = new Message();
    parambihu.what = ahue.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambihu);
  }
  
  public boolean onStart(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambihu);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuh
 * JD-Core Version:    0.7.0.1
 */