import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.facedetect.FaceDetector;

public class aibg
  implements Runnable
{
  public aibg(QQFilterRenderManager paramQQFilterRenderManager, aibh paramaibh) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a.doFaceDetect(this.jdField_a_of_type_Aibh.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Aibh.jdField_a_of_type_Int, this.jdField_a_of_type_Aibh.b);
    }
    long l2 = SystemClock.elapsedRealtimeNanos();
    long l3 = (l2 - l1) / 1000L;
    if (SLog.a()) {
      SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doFaceDetect=" + (l2 - l1) / 1000L + "us]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aibg
 * JD-Core Version:    0.7.0.1
 */