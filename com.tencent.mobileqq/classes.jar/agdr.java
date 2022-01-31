import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class agdr
  extends bead
{
  agdr(agdo paramagdo, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambeae);
    }
  }
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambeae);
    }
    if (parambeae.b()) {}
    do
    {
      return;
      parambeae.a().getInt("type");
    } while (parambeae.a() == -1);
    parambeae = new Message();
    parambeae.what = agdo.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambeae);
  }
  
  public boolean onStart(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambeae);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdr
 * JD-Core Version:    0.7.0.1
 */