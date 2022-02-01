import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class agqv
  extends bgod
{
  agqv(agqs paramagqs, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambgoe);
    }
  }
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambgoe);
    }
    if (parambgoe.b()) {}
    do
    {
      return;
      parambgoe.a().getInt("type");
    } while (parambgoe.a() == -1);
    parambgoe = new Message();
    parambgoe.what = agqs.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambgoe);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambgoe);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqv
 * JD-Core Version:    0.7.0.1
 */