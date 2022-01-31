import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class absz
  extends JobSegment<atzw, atzw>
{
  absz(absu paramabsu, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, atzw paramatzw)
  {
    if (paramatzw.b())
    {
      notifyResult(paramatzw);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    auab.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new abta(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absz
 * JD-Core Version:    0.7.0.1
 */