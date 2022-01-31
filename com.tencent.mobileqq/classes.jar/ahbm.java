import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class ahbm
  implements baug
{
  private Handler a;
  
  ahbm(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + parambavf);
    }
    if (parambavf.jdField_a_of_type_Int == 3) {
      return;
    }
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(ahbf.a(parambavf.jdField_a_of_type_Bave.c)))
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
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbm
 * JD-Core Version:    0.7.0.1
 */