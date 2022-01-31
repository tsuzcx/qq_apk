import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahsi
  implements Runnable
{
  public ahsi(DCShortVideo paramDCShortVideo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    ahso localahso = new ahso();
    localahso.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localahso.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localahso.b = this.b;
    localahso.c = this.c;
    localahso.d = this.d;
    localahso.e = this.e;
    localahso.f = this.f;
    localahso.g = this.g;
    localahso.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    ahsr localahsr = new ahsr("actStreamingVideoPlay", localahso.a("actStreamingVideoPlay"));
    DataReport.a().a(localahsr);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localahso.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahsi
 * JD-Core Version:    0.7.0.1
 */