import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahsh
  implements Runnable
{
  public ahsh(DCShortVideo paramDCShortVideo, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    ahsp localahsp = new ahsp();
    localahsp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localahsp.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ahsr localahsr = new ahsr("RealShortVideo.Record", localahsp.a("RealShortVideo.Record"));
    DataReport.a().a(localahsr);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localahsp.jdField_a_of_type_Int + ",hasMultiSegments=" + localahsp.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahsh
 * JD-Core Version:    0.7.0.1
 */