import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;

public class aarb
  implements Runnable
{
  public aarb(WorldCupMgr paramWorldCupMgr, SplashPopupWin paramSplashPopupWin) {}
  
  public void run()
  {
    QLog.w(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a, 1, "onDestroy, 开始清除闪屏");
    this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarb
 * JD-Core Version:    0.7.0.1
 */