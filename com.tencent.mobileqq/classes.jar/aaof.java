import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface.1.1;
import com.tencent.mobileqq.app.ThreadManager;

public class aaof
  extends aaog
{
  aaof(aaoe paramaaoe) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    aanp.a("GdtC2SReporter", "onCheckC2SReport: " + paramInt + "， request ADID: " + paramString2);
    aaoc.a(BaseApplicationImpl.getApplication(), this.a, paramInt, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_Long = -2147483648L;
    if (aaoe.a(this.a).equals(paramString2))
    {
      azmj.a(null, "dc00898", "", "", "0X8009EBD", "0X8009EBD", this.a.jdField_a_of_type_Int, paramInt, "", "", aaoe.a(this.a), "");
      if ((paramInt != 1) && (paramInt != 2)) {
        ThreadManager.executeOnNetWorkThread(new GdtC2SReportInterface.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaof
 * JD-Core Version:    0.7.0.1
 */