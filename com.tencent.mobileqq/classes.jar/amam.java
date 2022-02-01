import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.hasFollowWeather.1;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1;
import com.tencent.mobileqq.activity.weather.webpage.WebViewFragmentWithArk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"AD_CODE_KEY", "", "BASE_URL", "DAY", "", "FOLLOW_TYPE_NO", "FOLLOW_TYPE_UNKNOW", "FOLLOW_TYPE_YES", "SCENE_KEY", "TAG", "WEATHER_ARK_DEFAULT_HEIGHT", "WEATHER_ARK_MIN_VERSION", "WEATHER_ARK_NAME", "WEATHER_ARK_VIEW", "WEATHER_SCHEME_HEAD", "WEATHER_WEB_PREFIX", "buildShareWaterFallArk", "Lcom/tencent/mobileqq/activity/weather/webpage/WaterfallArk;", "messageArk", "shareUrl", "checkShareUrlIsError", "", "clearUnRead", "", "accountUin", "getAdCodeFromArkAppMessage", "ark", "getLastUnreadWaterfallArk", "Lcom/tencent/mobileqq/data/MessageRecord;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getShareWeatherWebUrl", "height", "getWaterFallArkFromChatMessage", "message", "getWeatherWebUrl", "adCode", "hasFollowWeather", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isFollow", "hasUnreadArkMsg", "isNewWeatherPushMsg", "mr", "isSameDayWithLastPreload", "isWeatherArkPageUrl", "url", "openWeatherByScheme", "context", "Landroid/content/Context;", "scheme", "preloadWebProcess", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "startNewWeatherWebPageActivity", "isFromShare", "startNewWeatherWebPageActivityByFollowState", "from", "startWeatherWebPageActivity", "transformUrlToScheme", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class amam
{
  @Nullable
  public static final alzy a(@Nullable alzy paramalzy, @Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == null");
      return paramalzy;
    }
    Object localObject = bkgj.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "URLUtil.getArgumentsFromURL(shareUrl)");
    String str1 = (String)((Map)localObject).get("adcode");
    if (str1 != null)
    {
      localObject = (String)((Map)localObject).get("scene");
      if (localObject == null) {
        break label167;
      }
    }
    String str2;
    for (;;)
    {
      str2 = "{\"qq_weather\": {\"adcode\": " + str1 + ",\"scene\": " + (String)localObject + "}}";
      QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == " + paramString + " adcode = " + str1 + " scene = " + (String)localObject);
      if (paramalzy != null) {
        break label173;
      }
      return new alzy("com.tencent.weather_v2", str2, "1.0.0.1", "qq_weather");
      str1 = "";
      break;
      label167:
      localObject = "1";
    }
    label173:
    paramalzy.a(str2);
    return paramalzy;
  }
  
  private static final alzy a(MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord instanceof QQMessageFacade.Message)) {
        paramMessageRecord = ((QQMessageFacade.Message)paramMessageRecord).lastMsg;
      }
      while (((paramMessageRecord instanceof MessageForArkApp)) && (((MessageForArkApp)paramMessageRecord).ark_app_message != null) && (!TextUtils.isEmpty((CharSequence)((MessageForArkApp)paramMessageRecord).ark_app_message.metaList)))
      {
        Object localObject = new JSONObject(((MessageForArkApp)paramMessageRecord).ark_app_message.metaList).optJSONObject("weather").optJSONObject("waterfall_ark");
        paramMessageRecord = ((JSONObject)localObject).optString("app");
        String str1 = ((JSONObject)localObject).optString("meta");
        String str2 = ((JSONObject)localObject).optString("view");
        localObject = ((JSONObject)localObject).optString("ver");
        Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "app");
        Intrinsics.checkExpressionValueIsNotNull(str1, "meta");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ver");
        Intrinsics.checkExpressionValueIsNotNull(str2, "view");
        paramMessageRecord = new alzy(paramMessageRecord, str1, (String)localObject, str2);
        return paramMessageRecord;
      }
      return null;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("WeatherWebPageHelper", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  private static final MessageRecord a(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramQQAppInterface == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramQQAppInterface.a().a("2658655094", 1008);
    int i = localList.size() - 1;
    label30:
    if (i >= 0)
    {
      paramQQAppInterface = (ChatMessage)localList.get(i);
      if ((paramQQAppInterface instanceof QQMessageFacade.Message)) {}
      for (paramQQAppInterface = ((QQMessageFacade.Message)paramQQAppInterface).lastMsg;; paramQQAppInterface = (MessageRecord)paramQQAppInterface)
      {
        localObject = paramQQAppInterface;
        if ((paramQQAppInterface instanceof MessageForArkApp)) {
          break;
        }
        i -= 1;
        break label30;
      }
    }
    return null;
  }
  
  private static final String a(alzy paramalzy)
  {
    try
    {
      paramalzy = new JSONObject(paramalzy.b()).optJSONObject("qq_weather").optString("adcode", "");
      Intrinsics.checkExpressionValueIsNotNull(paramalzy, "weather.optString(\"adcode\", \"\")");
      return paramalzy;
    }
    catch (Throwable paramalzy)
    {
      QLog.d("WeatherWebPageHelper", 1, paramalzy, new Object[0]);
    }
    return "";
  }
  
  @Nullable
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("mqqapi://forward/url?src_type=web&version=1&url_prefix=");
      Charset localCharset = Charset.forName("UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(charsetName)");
      paramString = paramString.getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      paramString = bgku.encode(paramString, 0);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Base64Util.encode(url.to…8\")), Base64Util.DEFAULT)");
      paramString = new String(paramString, Charsets.UTF_8);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("WeatherWebPageHelper", 1, "transFormUrlToScheme", paramString);
    }
    return null;
  }
  
  @NotNull
  public static final String a(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("https://weather.mp.qq.com/pages/aio?_wv=1090533159&_wwv=196612&not_short=1").append("&height=").append(paramInt);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {}
    for (paramString = "&adcode=" + paramString;; paramString = "")
    {
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebPageHelper", 2, "getWeatherWebUrl -> url: " + paramString);
      }
      return paramString;
    }
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    a(paramQQAppInterface, (Function1)new WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1(paramContext, paramQQAppInterface, paramInt, paramString));
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "scheme");
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "preloadWebProcess");
    }
    if (!amad.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebPageHelper", 2, "WeatherPreloadWebPageConfigProcessor unable");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (amaj.a.a()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("WeatherWebPageHelper", 2, "WeatherWebPageConfigProcessor unable");
              return;
              localObject1 = (Context)paramBaseActivity;
              localObject2 = paramBaseActivity.app;
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity.app");
              localObject1 = (Long)bgsg.b((Context)localObject1, ((QQAppInterface)localObject2).getCurrentAccountUin(), "key_last_open_weather_page", Long.valueOf(0L));
              long l = System.currentTimeMillis();
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "lastOpenTime");
              if (l - ((Long)localObject1).longValue() <= 259200000) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("WeatherWebPageHelper", 2, "lastOpenTime unable lastOpenTime ：" + localObject1);
            return;
            localObject1 = paramBaseActivity.app;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.app");
            if (!b((QQAppInterface)localObject1)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("WeatherWebPageHelper", 2, "isSameDayWithLastPreload unable");
          return;
          if (!bgln.g()) {
            break;
          }
          alzs.a().a(paramBaseActivity.app, "new_folder_noprestart_lowsystem");
        } while (!QLog.isColorLevel());
        QLog.d("WeatherWebPageHelper", 2, "DeviceInfoUtil unable");
        return;
        localObject1 = paramBaseActivity.app;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.app");
        if (a((QQAppInterface)localObject1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("WeatherWebPageHelper", 2, "hasUnreadArkMsg unable");
      return;
      localObject1 = paramBaseActivity.app.getManager(13);
    } while (!(localObject1 instanceof WebProcessManager));
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "do preload Web Process");
    }
    ((WebProcessManager)localObject1).a(-1, (bhlk)new aman(paramBaseActivity));
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    Object localObject2 = (Context)BaseApplicationImpl.context;
    paramBaseActivity = paramBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "activity.app");
    bgsg.a((Context)localObject2, paramBaseActivity.getCurrentAccountUin(), true, "key_last_preload_web_process", ((SimpleDateFormat)localObject1).format(new Date()));
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    paramQQAppInterface = paramQQAppInterface.getManager(56);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.PublicAccountDataManager");
    }
    paramQQAppInterface = (anrs)paramQQAppInterface;
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = paramQQAppInterface.b("2658655094");
    if ((AccountDetail)localObjectRef.element == null)
    {
      ThreadManager.excute((Runnable)new WeatherWebPageHelperKt.hasFollowWeather.1(localObjectRef, paramQQAppInterface, paramFunction1), 32, null, true);
      return;
    }
    if (((AccountDetail)localObjectRef.element).followType == 1)
    {
      paramFunction1.invoke(Integer.valueOf(1));
      return;
    }
    paramFunction1.invoke(Integer.valueOf(2));
  }
  
  private static final void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
      if ((paramString instanceof QQAppInterface))
      {
        bcsa.a(1, 0, 1008, ((QQAppInterface)paramString).a().a("2658655094", 1008));
        ((QQAppInterface)paramString).a().a("2658655094", 1008, true, true);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("WeatherWebPageHelper", 1, paramString, new Object[0]);
    }
  }
  
  public static final boolean a(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    return a(paramContext, paramQQAppInterface, false, "");
  }
  
  public static final boolean a(@NotNull Context paramContext, @Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!amaj.a.a()) {}
    MessageRecord localMessageRecord;
    Object localObject1;
    do
    {
      do
      {
        return false;
      } while ((paramBoolean) && (b(paramString)));
      localMessageRecord = a(paramQQAppInterface);
      localObject2 = a(localMessageRecord);
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = a((alzy)localObject2, paramString);
      }
    } while (localObject1 == null);
    boolean bool = WebProcessManager.c();
    Object localObject2 = new Intent(paramContext, QQBrowserActivity.class);
    String str = a((alzy)localObject1);
    if (paramBoolean)
    {
      paramString = b(paramString, 0, 2, null);
      ((Intent)localObject2).putExtra("url", paramString);
      ((Intent)localObject2).putExtra("isTransparentTitle", true);
      ((Intent)localObject2).putExtra("fragment_class", WebViewFragmentWithArk.class.getCanonicalName());
      ((Intent)localObject2).putExtra("appName", ((alzy)localObject1).a());
      ((Intent)localObject2).putExtra("appView", ((alzy)localObject1).d());
      ((Intent)localObject2).putExtra("appVersion", ((alzy)localObject1).c());
      ((Intent)localObject2).putExtra("appMeta", ((alzy)localObject1).b());
      ((Intent)localObject2).putExtra("adCode", str);
      ((Intent)localObject2).putExtra("startClickTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("webProcessExist", bool);
      ((Intent)localObject2).putExtra("is_from_share", paramBoolean);
      ((Intent)localObject2).putExtra("is_from_share", paramBoolean);
      ((Intent)localObject2).putExtra("is_to_ark", true);
      paramContext.startActivity((Intent)localObject2);
      if (localMessageRecord != null) {
        a(localMessageRecord.selfuin);
      }
      if (paramQQAppInterface != null) {
        bgsg.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), true, "key_last_open_weather_page", Long.valueOf(System.currentTimeMillis()));
      }
      if (!bool) {
        break label361;
      }
    }
    label361:
    for (paramContext = "new_folder_prestart_open";; paramContext = "new_folder_noprestart_open")
    {
      alzs.a().a(paramQQAppInterface, paramContext);
      if (localMessageRecord != null)
      {
        long l1 = NetConnInfoCenter.getServerTime();
        long l2 = localMessageRecord.time;
        alzs.a().a(paramQQAppInterface, "new_folder_push_open_timegap", Long.valueOf(l1 - l2));
      }
      return true;
      paramString = a(str, 0, 2, null);
      break;
    }
  }
  
  private static final boolean a(QQAppInterface paramQQAppInterface)
  {
    int j = paramQQAppInterface.a().a("2658655094", 1008);
    if (j > 0)
    {
      paramQQAppInterface = paramQQAppInterface.a().a("2658655094", 1008);
      int i = paramQQAppInterface.size() - 1;
      j = Math.max(0, paramQQAppInterface.size() - j);
      if (i >= j) {
        for (;;)
        {
          if (a((MessageRecord)paramQQAppInterface.get(i))) {
            return true;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    return false;
  }
  
  public static final boolean a(@Nullable MessageRecord paramMessageRecord)
  {
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord != null) {
      return (!TextUtils.isEmpty((CharSequence)paramMessageRecord.a())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.d())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.c())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.b()));
    }
    return false;
  }
  
  public static final boolean a(@Nullable String paramString)
  {
    return (paramString != null) && (StringsKt.startsWith$default(paramString, "https://weather.mp.qq.com/pages/aio", false, 2, null) == true);
  }
  
  @NotNull
  public static final String b(@Nullable String paramString, int paramInt)
  {
    paramString = paramString + "&height=" + paramInt;
    QLog.i("WeatherWebPageHelper", 1, "buildShareWeatherWebUrl " + paramString);
    return paramString;
  }
  
  public static final void b(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    if (!a(paramContext, paramQQAppInterface, true, paramString))
    {
      paramQQAppInterface = new Intent();
      paramString = new Bundle();
      paramQQAppInterface.setComponent(new ComponentName(paramContext, ChatActivity.class));
      paramString.putString("uin", "2658655094");
      paramString.putInt("uintype", 1008);
      paramString.putString("uinname", "QQ天气");
      paramQQAppInterface.putExtras(paramString);
      paramQQAppInterface.setFlags(67108864);
      paramQQAppInterface.putExtra("isforceRequestDetail", false);
      paramQQAppInterface.putExtra("jump_from", paramInt);
      paramContext.startActivity(paramQQAppInterface);
    }
  }
  
  private static final boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (String)bgsg.b((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_last_preload_web_process", "");
    if (!TextUtils.isEmpty((CharSequence)paramQQAppInterface))
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse(paramQQAppInterface);
      paramQQAppInterface = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "calendarLast");
      paramQQAppInterface.setTime((Date)localObject);
      localObject = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "calendarNow");
      ((Calendar)localObject).setTime(new Date());
      if ((paramQQAppInterface.get(0) == ((Calendar)localObject).get(0)) && (paramQQAppInterface.get(1) == ((Calendar)localObject).get(1)) && (paramQQAppInterface.get(6) == ((Calendar)localObject).get(6))) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean b(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false shareUrl == null");
      return true;
    }
    Object localObject = bkgj.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "URLUtil.getArgumentsFromURL(shareUrl)");
    String str = (String)((Map)localObject).get("adcode");
    localObject = (String)((Map)localObject).get("scene");
    if ((TextUtils.isEmpty((CharSequence)str)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false  shareUrl == " + paramString + ' ');
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amam
 * JD-Core Version:    0.7.0.1
 */