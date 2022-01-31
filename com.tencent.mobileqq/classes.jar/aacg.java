import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class aacg
  extends JobSegment<asiu, asiu>
{
  aacg(aacb paramaacb, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, asiu paramasiu)
  {
    if (paramasiu.b())
    {
      notifyResult(paramasiu);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    asiz.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new aach(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacg
 * JD-Core Version:    0.7.0.1
 */