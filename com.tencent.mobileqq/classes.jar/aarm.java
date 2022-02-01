import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

public class aarm
  implements ISPlayerVideoView.IVideoViewCallBack
{
  public aarm(TribeVideoPlugin paramTribeVideoPlugin) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarm
 * JD-Core Version:    0.7.0.1
 */