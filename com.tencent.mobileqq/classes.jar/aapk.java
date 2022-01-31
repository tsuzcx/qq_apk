import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.qphone.base.util.QLog;

public class aapk
  implements GestureMgr.GestureStatusListener
{
  public aapk(ARWorldCupBaseResDownload paramARWorldCupBaseResDownload) {}
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 99))
    {
      QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes1. download... progress = " + paramInt);
      ARWorldCupBaseResDownload.a(this.a, 1, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean1)
    {
      QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes1. download successfully. bEnableGesture = " + paramBoolean2);
      GestureMgr.a().a(false, this);
      ARWorldCupBaseResDownload.a(this.a, 1, 100);
      return;
    }
    QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes1. download failed. error code = " + paramInt);
    GestureMgr.a().a(false, this);
    ARWorldCupBaseResDownload.a(this.a, 1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapk
 * JD-Core Version:    0.7.0.1
 */