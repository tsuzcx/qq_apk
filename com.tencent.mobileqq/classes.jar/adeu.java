import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class adeu
  extends JobSegment<awlp, awlp>
{
  adeu(adep paramadep, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, awlp paramawlp)
  {
    if (paramawlp.b())
    {
      notifyResult(paramawlp);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    awlu.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new adev(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adeu
 * JD-Core Version:    0.7.0.1
 */