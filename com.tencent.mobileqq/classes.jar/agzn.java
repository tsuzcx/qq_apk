import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class agzn
  implements Runnable
{
  public agzn(DCShortVideo paramDCShortVideo, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    agzv localagzv = new agzv();
    localagzv.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localagzv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    agzx localagzx = new agzx("RealShortVideo.Record", localagzv.a("RealShortVideo.Record"));
    DataReport.a().a(localagzx);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localagzv.jdField_a_of_type_Int + ",hasMultiSegments=" + localagzv.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzn
 * JD-Core Version:    0.7.0.1
 */