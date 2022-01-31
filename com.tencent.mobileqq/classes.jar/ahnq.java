import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahnq
  implements Runnable
{
  public ahnq(DCShortVideo paramDCShortVideo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    ahnw localahnw = new ahnw();
    localahnw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localahnw.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localahnw.b = this.b;
    localahnw.c = this.c;
    localahnw.d = this.d;
    localahnw.e = this.e;
    localahnw.f = this.f;
    localahnw.g = this.g;
    localahnw.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    ahnz localahnz = new ahnz("actStreamingVideoPlay", localahnw.a("actStreamingVideoPlay"));
    DataReport.a().a(localahnz);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localahnw.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnq
 * JD-Core Version:    0.7.0.1
 */