import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask.FaceDetectTaskResult;
import com.tencent.mobileqq.shortvideo.facedancegame.IFaceDetectCallBack;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.facedetect.FaceDetector;

public class aifx
  implements Runnable
{
  public aifx(QQFilterRenderManager paramQQFilterRenderManager, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IFaceDetectCallBack paramIFaceDetectCallBack) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a.doFaceDetect(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b);
    }
    long l2 = SystemClock.elapsedRealtimeNanos();
    FaceDanceDetectTask.a("mFaceDetector.doFaceDetect", l1, l2);
    long l3 = (l2 - l1) / 1000L;
    if (SLog.a()) {
      SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doFaceDetect=" + (l2 - l1) / 1000L + "us]");
    }
    FaceDanceDetectTask.FaceDetectTaskResult localFaceDetectTaskResult;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameIFaceDetectCallBack != null)
    {
      localFaceDetectTaskResult = new FaceDanceDetectTask.FaceDetectTaskResult();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a.getFaceCount() <= 0) {
        break label188;
      }
    }
    label188:
    for (boolean bool = true;; bool = false)
    {
      localFaceDetectTaskResult.jdField_a_of_type_Boolean = bool;
      if (localFaceDetectTaskResult.jdField_a_of_type_Boolean)
      {
        localFaceDetectTaskResult.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a.getAllPoints(0);
        localFaceDetectTaskResult.jdField_a_of_type_ArrayOfFloat = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a.getFaceAngles(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameIFaceDetectCallBack.a(localFaceDetectTaskResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifx
 * JD-Core Version:    0.7.0.1
 */