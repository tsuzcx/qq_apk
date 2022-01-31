import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aeco
  extends bbwt
{
  aeco(aecl paramaecl, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + parambbwu);
    }
  }
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + parambbwu);
    }
    if (parambbwu.b()) {}
    do
    {
      return;
      parambbwu.a().getInt("type");
    } while (parambbwu.a() == -1);
    parambbwu = new Message();
    parambbwu.what = aecl.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(parambbwu);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + parambbwu);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeco
 * JD-Core Version:    0.7.0.1
 */