import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class agwx
  implements bapx
{
  private Handler a;
  
  agwx(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + parambaqw);
    }
    if (parambaqw.jdField_a_of_type_Int == 3) {
      return;
    }
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(agwq.a(parambaqw.jdField_a_of_type_Baqv.c)))
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
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwx
 * JD-Core Version:    0.7.0.1
 */