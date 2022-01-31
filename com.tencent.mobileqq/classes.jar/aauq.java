import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.util.ArrayList;

class aauq
  extends ArkAppCGI.ArkAppCGICallback
{
  aauq(aaup paramaaup) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList1, ArrayList arg3, Object paramObject)
  {
    if ((!paramBoolean) || (paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("_updatePredownloadAppList, fail.", new Object[0]));
    }
    synchronized (ArkLocalAppMgr.b(this.a.a))
    {
      ArkLocalAppMgr.b(this.a.a).clear();
      if (paramArrayList1 != null) {
        ArkLocalAppMgr.b(this.a.a).addAll(paramArrayList1);
      }
      return;
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("_updatePredownloadAppList, success, app-count=%d", new Object[] { Integer.valueOf(paramArrayList1.size()) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aauq
 * JD-Core Version:    0.7.0.1
 */