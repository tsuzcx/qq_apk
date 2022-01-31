import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class agzo
  implements Runnable
{
  public agzo(DCShortVideo paramDCShortVideo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    agzu localagzu = new agzu();
    localagzu.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localagzu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localagzu.b = this.b;
    localagzu.c = this.c;
    localagzu.d = this.d;
    localagzu.e = this.e;
    localagzu.f = this.f;
    localagzu.g = this.g;
    localagzu.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    agzx localagzx = new agzx("actStreamingVideoPlay", localagzu.a("actStreamingVideoPlay"));
    DataReport.a().a(localagzx);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localagzu.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzo
 * JD-Core Version:    0.7.0.1
 */