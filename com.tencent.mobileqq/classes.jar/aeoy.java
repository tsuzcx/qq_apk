import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class aeoy
  implements axrt
{
  private Handler a;
  
  aeoy(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + paramaxsq);
    }
    if (paramaxsq.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(aeor.a(paramaxsq.jdField_a_of_type_Axsp.c)))
      {
        this.a.sendEmptyMessage(100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "font download but md5 is not matched");
      }
      this.a.sendEmptyMessage(101);
      return;
    }
    this.a.sendEmptyMessage(101);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeoy
 * JD-Core Version:    0.7.0.1
 */