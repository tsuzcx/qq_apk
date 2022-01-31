import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbIPCModule.1;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.ReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ahgg
  extends QIPCModule
{
  public static ahgg a;
  
  public ahgg()
  {
    super("SpringHbIPCModule");
  }
  
  public static ahgg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahgg();
      }
      return a;
    }
    finally {}
  }
  
  private static EIPCResult a(AppRuntime paramAppRuntime)
  {
    try
    {
      if ((paramAppRuntime instanceof QQAppInterface)) {}
      for (boolean bool = ((QQAppInterface)paramAppRuntime).c();; bool = false)
      {
        paramAppRuntime = new Bundle();
        paramAppRuntime.putBoolean("isVideoChatting", bool);
        return EIPCResult.createSuccessResult(paramAppRuntime);
        QLog.e("springHb_SpringHbIPCModule", 1, "doGetIsVideoChatting appRuntime is not QQAppInterface");
      }
      return EIPCResult.createSuccessResult(paramAppRuntime);
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime = new Bundle();
      paramAppRuntime.putBoolean("isVideoChatting", false);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = null;
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("SpringHbIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localObject2;
    if (localAppRuntime != null)
    {
      if ((localAppRuntime instanceof QQAppInterface)) {
        break label78;
      }
      localObject1 = localObject2;
    }
    label78:
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!"ReportData".equals(paramString)) {
            break;
          }
          paramString = (SpringHbReportManager.ReportInfo)paramBundle.getSerializable("key1");
          paramBundle = (SpringHbReportManager)((QQAppInterface)localAppRuntime).getManager(344);
          localObject1 = localObject2;
        } while (paramBundle == null);
        paramBundle.a(paramString);
        return null;
        if ("GetDomain".equals(paramString))
        {
          paramString = ((ahfs)localAppRuntime.getManager(343)).a();
          paramBundle = new EIPCResult();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("res_domain", paramString);
          paramBundle.data = ((Bundle)localObject1);
          return paramBundle;
        }
        if ("GetEmergencyInfo".equals(paramString))
        {
          paramBundle = (ahfs)localAppRuntime.getManager(343);
          localObject1 = new EIPCResult();
          localBundle = new Bundle();
          if ((paramBundle == null) || (paramBundle.a() == null))
          {
            paramString = null;
            if ((paramBundle != null) && (paramBundle.a() != null)) {
              break label292;
            }
          }
          for (paramBundle = null;; paramBundle = paramBundle.a().emergencyUrl)
          {
            localBundle.putString("key1", paramString);
            localBundle.putString("key2", paramBundle);
            ((EIPCResult)localObject1).data = localBundle;
            callbackResult(paramInt, (EIPCResult)localObject1);
            return null;
            paramString = paramBundle.a().activityPrefix;
            break;
          }
        }
        if ("GetHtmlOffline".equals(paramString))
        {
          paramString = (ahfs)localAppRuntime.getManager(343);
          paramBundle = new EIPCResult();
          localObject1 = new Bundle();
          if (paramString.a() == null) {}
          for (paramString = "";; paramString = paramString.a().bids)
          {
            ((Bundle)localObject1).putString("bids", paramString);
            paramBundle.data = ((Bundle)localObject1);
            return paramBundle;
          }
        }
        if ("GetcfgInfo".equals(paramString))
        {
          paramString = (ahfs)localAppRuntime.getManager(343);
          paramBundle = new EIPCResult();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("task_id", paramString.a());
          ((Bundle)localObject1).putInt("cfg_version", paramString.b());
          paramBundle.data = ((Bundle)localObject1);
          return paramBundle;
        }
        if ("removeEntryLoadingAnimationView".equals(paramString))
        {
          QLog.i("SpringHbIPCModule", 1, "webview ACTION_REMOVE_ENTRY_LOADING_ANIMATION_VIEW");
          ThreadManager.getUIHandler().postDelayed(new SpringHbIPCModule.1(this), 1000L);
          return EIPCResult.createSuccessResult(new Bundle());
        }
        if ("GetActivityPref".equals(paramString))
        {
          paramString = (ahfs)localAppRuntime.getManager(343);
          paramBundle = new EIPCResult();
          localObject1 = new Bundle();
          if (paramString.a() == null) {}
          for (paramString = localBundle;; paramString = paramString.a().activityPrefix)
          {
            ((Bundle)localObject1).putString("activity_pref", paramString);
            paramBundle.data = ((Bundle)localObject1);
            return paramBundle;
          }
        }
        if (!"GetServerTime".equals(paramString)) {
          break;
        }
        paramBundle = (ahfz)localAppRuntime.getManager(342);
        paramString = new EIPCResult();
        localObject1 = paramString;
      } while (paramBundle == null);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("server_time", paramBundle.b());
      paramString.data = ((Bundle)localObject1);
      return paramString;
      localObject1 = localObject2;
    } while (!"getIsVideoChatting".equals(paramString));
    label292:
    return a(localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgg
 * JD-Core Version:    0.7.0.1
 */