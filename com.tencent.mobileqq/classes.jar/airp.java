import com.tencent.TMG.sdk.AVVideoCtrl.RemoteVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class airp
  extends AVVideoCtrl.RemoteVideoPreviewCallback
{
  airp(airn paramairn) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = ajac.a(airm.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ajcf)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.2.1(this, paramVideoFrame, (ApolloSurfaceView)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airp
 * JD-Core Version:    0.7.0.1
 */