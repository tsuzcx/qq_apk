import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class adns
  extends JobSegment<axeh, axeh>
{
  adns(adnn paramadnn, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, axeh paramaxeh)
  {
    if (paramaxeh.b())
    {
      notifyResult(paramaxeh);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    axem.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new adnt(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adns
 * JD-Core Version:    0.7.0.1
 */