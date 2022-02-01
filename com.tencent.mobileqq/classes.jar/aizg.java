import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class aizg
  implements beuq
{
  private Handler a;
  
  aizg(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + parambevm);
    }
    if (parambevm.jdField_a_of_type_Int == 3) {
      return;
    }
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(aiyz.a(parambevm.jdField_a_of_type_Bevl.c)))
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
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizg
 * JD-Core Version:    0.7.0.1
 */