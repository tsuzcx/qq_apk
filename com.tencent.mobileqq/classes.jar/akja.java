import com.tencent.TMG.sdk.AVVideoCtrl.RemoteVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class akja
  extends AVVideoCtrl.RemoteVideoPreviewCallback
{
  akja(akiy paramakiy) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = akro.a(akix.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((aktr)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.2.1(this, paramVideoFrame, (ApolloSurfaceView)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akja
 * JD-Core Version:    0.7.0.1
 */