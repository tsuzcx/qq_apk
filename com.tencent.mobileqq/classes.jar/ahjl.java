import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ahjl
  extends bhyn
{
  ahjl(ahji paramahji, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambhyo);
    }
  }
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambhyo);
    }
    if (parambhyo.b()) {}
    do
    {
      return;
      parambhyo.a().getInt("type");
    } while (parambhyo.a() == -1);
    parambhyo = new Message();
    parambhyo.what = ahji.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambhyo);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambhyo);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjl
 * JD-Core Version:    0.7.0.1
 */