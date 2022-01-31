import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aecq
  extends bbwf
{
  aecq(aecn paramaecn, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambbwg);
    }
  }
  
  public void onDone(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambbwg);
    }
    if (parambbwg.b()) {}
    do
    {
      return;
      parambbwg.a().getInt("type");
    } while (parambbwg.a() == -1);
    parambbwg = new Message();
    parambbwg.what = aecn.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambbwg);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambbwg);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecq
 * JD-Core Version:    0.7.0.1
 */