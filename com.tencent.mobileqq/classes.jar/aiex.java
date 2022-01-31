import com.tencent.TMG.sdk.AVVideoCtrl.LocalVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class aiex
  extends AVVideoCtrl.LocalVideoPreviewCallback
{
  aiex(aiew paramaiew) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = aing.a(aiev.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((aipj)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.1.1(this, (ApolloSurfaceView)localObject, paramVideoFrame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiex
 * JD-Core Version:    0.7.0.1
 */