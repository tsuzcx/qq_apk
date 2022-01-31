import com.tencent.TMG.sdk.AVVideoCtrl.LocalVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class akiz
  extends AVVideoCtrl.LocalVideoPreviewCallback
{
  akiz(akiy paramakiy) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = akro.a(akix.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((aktr)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.1.1(this, (ApolloSurfaceView)localObject, paramVideoFrame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akiz
 * JD-Core Version:    0.7.0.1
 */