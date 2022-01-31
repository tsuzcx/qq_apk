import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload;
import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload.DownloadListener;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.qphone.base.util.QLog;

public class aaiu
  implements Runnable
{
  public aaiu(ARWorldCupBaseResDownload paramARWorldCupBaseResDownload) {}
  
  public void run()
  {
    QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes. download timeout.");
    if ((ARWorldCupBaseResDownload.a(this.a)[0] >= 0) && (ARWorldCupBaseResDownload.a(this.a)[0] <= 99)) {
      WorldCupMgr.a(ARWorldCupBaseResDownload.a(this.a)).b(this.a.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr$DownloadListener);
    }
    if ((ARWorldCupBaseResDownload.a(this.a)[1] >= 0) && (ARWorldCupBaseResDownload.a(this.a)[1] <= 99)) {
      GestureMgr.a().a(false, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener);
    }
    ARWorldCupBaseResDownload.a(this.a, false);
    if (ARWorldCupBaseResDownload.a(this.a) != null) {
      ARWorldCupBaseResDownload.a(this.a).a(1, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaiu
 * JD-Core Version:    0.7.0.1
 */