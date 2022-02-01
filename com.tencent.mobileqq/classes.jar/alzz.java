import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class alzz
  implements ISPlayerVideoView.IVideoViewCallBack
{
  alzz(alzy paramalzy) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceChanged]");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceCreated]");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onSurfaceDestroy]");
    alzy.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzz
 * JD-Core Version:    0.7.0.1
 */