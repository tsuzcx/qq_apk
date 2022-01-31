import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class adqe
  implements TVK_SDKMgr.InstallListener
{
  public adqe(HotPicPageView paramHotPicPageView, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ThreadManager.getUIHandler().post(new adqh(this));
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManagerHotPicPageView", 2, "tencent sdk onInstalledFail");
    }
  }
  
  public void onInstalledSuccessed()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    new Thread(new adqf(this)).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqe
 * JD-Core Version:    0.7.0.1
 */