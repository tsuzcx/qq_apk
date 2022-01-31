import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.util.ArrayList;
import java.util.Iterator;

public class aaur
  implements aawc
{
  public aaur(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void a(String[] arg1)
  {
    ArrayList localArrayList = new ArrayList();
    if (??? != null)
    {
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(???[i]);
        i += 1;
      }
    }
    synchronized (ArkLocalAppMgr.b(this.a))
    {
      localObject3 = ArkLocalAppMgr.b(this.a).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (!localArrayList.contains(str)) {
          localArrayList.add(str);
        }
      }
    }
    ArkLocalAppMgr.b(this.a).clear();
    if (localObject1.isEmpty())
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, checkAppList is empty.", new Object[0]));
      return;
    }
    ??? = new ArrayList();
    Object localObject2 = localObject1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if ((ArkLocalAppMgr.a(this.a, (String)localObject3)) || (ArkLocalAppMgr.a())) {
        ???.add(localObject3);
      }
    }
    if (???.isEmpty())
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, no app need update.", new Object[0]));
      return;
    }
    localObject2 = new StringBuffer();
    Object localObject3 = ???.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ((StringBuffer)localObject2).append((String)((Iterator)localObject3).next());
      ((StringBuffer)localObject2).append(';');
    }
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, start to update, last-time=%d, app-count=%d, app-name-list=%s.", new Object[] { Long.valueOf(ArkLocalAppMgr.a(this.a)), Integer.valueOf(???.size()), ((StringBuffer)localObject2).toString() }));
    localObject2 = new aawe(null);
    ((aawe)localObject2).a = ???;
    ArkLocalAppMgr.a(this.a, (aawe)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaur
 * JD-Core Version:    0.7.0.1
 */