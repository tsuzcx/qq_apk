import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

public class abqn
  implements abqx
{
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    zon localzon = zon.a();
    localzon.a();
    localzon.i(new abqo(this, paramabqc, paramString, paramVarArgs, localzon));
    if (paramabqc != null) {}
    for (paramString = paramabqc.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramabqc != null) {
        paramVarArgs = paramabqc.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqn
 * JD-Core Version:    0.7.0.1
 */