import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class abxo
  extends JobSegment<auef, auef>
{
  abxo(abxj paramabxj, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, auef paramauef)
  {
    if (paramauef.b())
    {
      notifyResult(paramauef);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    auek.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new abxp(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxo
 * JD-Core Version:    0.7.0.1
 */