import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class achi
  extends ache
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    if (paramacfw != null) {}
    for (paramString = paramacfw.a(); (paramacfw == null) || (paramString == null); paramString = null)
    {
      QLog.i("WebGdtMvWebReportServerAntiHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    QLog.i("WebGdtMvWebReportServerAntiHandler", 1, "args=" + Arrays.toString(paramVarArgs));
    paramacfw = paramVarArgs[0];
    a(paramacfw);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achi
 * JD-Core Version:    0.7.0.1
 */