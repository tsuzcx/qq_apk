import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class adrr
  extends batl
{
  adrr(adro paramadro, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambatm);
    }
  }
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambatm);
    }
    if (parambatm.b()) {}
    do
    {
      return;
      parambatm.a().getInt("type");
    } while (parambatm.a() == -1);
    parambatm = new Message();
    parambatm.what = adro.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambatm);
  }
  
  public boolean onStart(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambatm);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrr
 * JD-Core Version:    0.7.0.1
 */