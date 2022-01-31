import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public final class abfs
  implements Runnable
{
  public abfs(String paramString1, String paramString2) {}
  
  public void run()
  {
    QLog.i("JSDebuggerSoLoader", 2, "setJSDebuggerLibPathForArk: " + this.a + "," + this.b);
    ArkAppCenter.a(true);
    ArkDebugger.SetJSLibraryPath(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfs
 * JD-Core Version:    0.7.0.1
 */