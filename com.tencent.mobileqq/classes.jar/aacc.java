import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class aacc
  extends JobSegment<asiw, asiw>
{
  aacc(aabx paramaabx, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, asiw paramasiw)
  {
    if (paramasiw.b())
    {
      notifyResult(paramasiw);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    asjb.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new aacd(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacc
 * JD-Core Version:    0.7.0.1
 */