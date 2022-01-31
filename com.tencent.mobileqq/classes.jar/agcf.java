import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class agcf
{
  public SplashActivity a;
  
  public agcf(SplashActivity paramSplashActivity)
  {
    this.a = paramSplashActivity;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.a == null) || (this.a.app == null)) {
      return 0;
    }
    axch localaxch = (axch)this.a.app.getManager(10);
    if (localaxch != null)
    {
      int j = localaxch.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localaxch.a(1));
        i = j;
      }
    }
    return i;
  }
  
  private bhvu a()
  {
    if (!b()) {
      return null;
    }
    if ((this.a == null) || (this.a.app == null)) {
      return null;
    }
    ReadInJoyManager localReadInJoyManager = (ReadInJoyManager)this.a.app.getManager(96);
    if (localReadInJoyManager == null) {
      return null;
    }
    return localReadInJoyManager.a();
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((this.a == null) || (this.a.app == null)) {
      return false;
    }
    axch localaxch = (axch)this.a.app.getManager(10);
    if (localaxch != null)
    {
      if (localaxch.a(2) > 0) {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localaxch.a(2) + " TYPE_ZEBRA_ALBUM:" + localaxch.a(17));
        bool2 = bool1;
      }
    }
    QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + bool2);
    return bool2;
  }
  
  private boolean b()
  {
    if ((this.a == null) || (this.a.app == null)) {
      return false;
    }
    Iterator localIterator = ((avpq)this.a.app.getManager(36)).a().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == 1130L) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  public Runnable a(agcg paramagcg)
  {
    return new LebaTabRedTouch.1(this, paramagcg);
  }
  
  public Map<Long, LebaPluginInfo> a()
  {
    Object localObject2 = Collections.emptyMap();
    Object localObject3 = this.a.app.a().a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject3).isEmpty())
      {
        localObject1 = new HashMap();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LebaPluginInfo)((Iterator)localObject2).next();
          if (localObject3 != null) {
            ((Map)localObject1).put(Long.valueOf(((LebaPluginInfo)localObject3).uiResId), localObject3);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcf
 * JD-Core Version:    0.7.0.1
 */