import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ahlv
  implements Runnable
{
  public ahlv(CapturePtvTemplateManager paramCapturePtvTemplateManager) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = PtvFilterSoLoad.b();
    boolean bool2 = NetworkUtil.d(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "dealyPreDownload isSupport: " + bool1 + " isNetWorkSupport: " + bool2);
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.a.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlv
 * JD-Core Version:    0.7.0.1
 */