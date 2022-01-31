import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahnp
  implements Runnable
{
  public ahnp(DCShortVideo paramDCShortVideo, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    ahnx localahnx = new ahnx();
    localahnx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localahnx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ahnz localahnz = new ahnz("RealShortVideo.Record", localahnx.a("RealShortVideo.Record"));
    DataReport.a().a(localahnz);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localahnx.jdField_a_of_type_Int + ",hasMultiSegments=" + localahnx.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnp
 * JD-Core Version:    0.7.0.1
 */