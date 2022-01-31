import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureMonitorManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.FaceDetector;

public class ahon
  implements Runnable
{
  public ahon(FilterProcessRender paramFilterProcessRender, ahoo paramahoo) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    GestureMonitorManager.a().c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a.doFaceDetect(this.jdField_a_of_type_Ahoo.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Ahoo.jdField_a_of_type_Int, this.jdField_a_of_type_Ahoo.b);
    GestureMonitorManager.a().d();
    long l2 = SystemClock.elapsedRealtimeNanos();
    PtvFilterTimeStatistics.a((l2 - l1) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[doFaceDetect=" + (l2 - l1) / 1000L + "us]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahon
 * JD-Core Version:    0.7.0.1
 */