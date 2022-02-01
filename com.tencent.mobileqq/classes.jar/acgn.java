import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

public class acgn
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    aady localaady = aady.a();
    localaady.a();
    localaady.i(new acgo(this, paramacfw, paramString, paramVarArgs, localaady));
    if (paramacfw != null) {}
    for (paramString = paramacfw.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramacfw != null) {
        paramVarArgs = paramacfw.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgn
 * JD-Core Version:    0.7.0.1
 */