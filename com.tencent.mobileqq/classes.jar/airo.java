import com.tencent.TMG.sdk.AVVideoCtrl.LocalVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class airo
  extends AVVideoCtrl.LocalVideoPreviewCallback
{
  airo(airn paramairn) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = ajac.a(airm.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ajcf)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.1.1(this, (ApolloSurfaceView)localObject, paramVideoFrame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airo
 * JD-Core Version:    0.7.0.1
 */