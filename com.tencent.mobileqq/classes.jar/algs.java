import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.weather.webpage.WeatherPreloadHelperKt.preloadWebProcessAsync.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"MAX_PRELOAD_TIME", "", "PRELOAD_FROM_CONVERSATION", "PRELOAD_FROM_FORGROUND", "PRELOAD_FROM_TEST", "PRELOAD_RESULT_ERROR_CANNOT_GET_APP", "PRELOAD_RESULT_ERROR_HAS_NO_UNREAD", "PRELOAD_RESULT_ERROR_HAS_WEB_PROCESS", "PRELOAD_RESULT_ERROR_LOW_PERF_DEVICE", "PRELOAD_RESULT_ERROR_NOT_NEW", "PRELOAD_RESULT_ERROR_NOT_OPEN_THREE_DAY", "PRELOAD_RESULT_ERROR_OTHER_WHEN_START_PROCESS", "PRELOAD_RESULT_ERROR_PARAM_WPM", "PRELOAD_RESULT_ERROR_PRELOAD_CLOSE", "PRELOAD_RESULT_ERROR_TODAY_PRELOAD_TO_MUCH", "PRELOAD_RESULT_NEVER", "PRELOAD_RESULT_SUCCESS", "PRELOAD_TIME_ZERO", "SP_PRELOAD_DATA_INDEX", "SP_PRELOAD_INFO_INDEX", "SP_PRELOAD_INFO_LIST_SIZE", "SP_PRELOAD_INFO_SPLIT", "", "START_WEB_PROCESS_DEFAULT_FROM", "STEP_ARK_LOAD", "STEP_CLICK", "STEP_GET_MESSAGE", "STEP_ON_CREATE", "STEP_TAG", "STEP_WEB_LOAD_END", "STEP_WEB_LOAD_START", "TAG", "THREE_DAY", "checkNeedPreload", "context", "Landroid/content/Context;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getTodayLastPreloadResult", "getTodayPreloadTimes", "hasUnreadArkMsg", "", "isToady", "dateString", "logInfo", "", "msg", "preloadWebProcess", "preloadWebProcessAsync", "from", "recordStep", "step", "ext", "saveAndReportPreloadResult", "preloadResult", "saveTodayPreloadTimes", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class algs
{
  private static final int a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (!algu.a.a()) {
      return -3001;
    }
    if (!a(paramQQAppInterface)) {
      return -3004;
    }
    if (DeviceInfoUtil.isLowPerfDevice())
    {
      algh.a().a(paramQQAppInterface, "new_folder_noprestart_lowsystem");
      return -3003;
    }
    paramContext = (Long)bfyz.b(paramContext, paramQQAppInterface.getCurrentAccountUin(), "key_last_open_weather_page", Long.valueOf(0L));
    long l = System.currentTimeMillis();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "lastOpenTime");
    if (l - paramContext.longValue() > 259200000)
    {
      b("lastOpenTime unable lastOpenTime ：" + paramContext);
      return -3002;
    }
    if (b(paramQQAppInterface) >= 3) {
      return -3005;
    }
    return 0;
  }
  
  public static final int a(@Nullable QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -5000;
    }
    paramQQAppInterface = (String)bfyz.b((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_last_preload_web_result", "");
    b("getTodayLastPreloadResult ：" + paramQQAppInterface);
    if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
      return -1000;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "preloadString");
    Object localObject = StringsKt.split$default((CharSequence)paramQQAppInterface, new String[] { "|" }, false, 0, 6, null);
    if ((((List)localObject).size() != 2) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(0))) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(1)))) {
      return -1000;
    }
    if (!a((String)((List)localObject).get(0))) {
      return -1000;
    }
    paramQQAppInterface = (Integer)null;
    try
    {
      localObject = Integer.valueOf((String)((List)localObject).get(1));
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("WeatherPreloadHelper", 1, "getTodayLastPreloadResult", localThrowable);
      }
    }
    if (paramQQAppInterface == null) {
      return -1000;
    }
    return paramQQAppInterface.intValue();
  }
  
  public static final void a(int paramInt)
  {
    b("preloadWebProcessAsync from = " + paramInt);
    ThreadManager.excute((Runnable)WeatherPreloadHelperKt.preloadWebProcessAsync.1.a, 128, null, false);
  }
  
  public static final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ext");
    QLog.i("WeatherStep", 1, "step = " + paramInt + ' ' + paramString);
  }
  
  private static final boolean a(QQAppInterface paramQQAppInterface)
  {
    int j = paramQQAppInterface.getConversationFacade().a("2658655094", 1008);
    if (j > 0)
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().getAIOList("2658655094", 1008);
      int i = paramQQAppInterface.size() - 1;
      j = Math.max(0, paramQQAppInterface.size() - j);
      if (i >= j) {
        for (;;)
        {
          if (alhb.a((MessageRecord)paramQQAppInterface.get(i))) {
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
  
  private static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    Object localObject = (Calendar)null;
    Calendar localCalendar = (Calendar)null;
    label146:
    for (;;)
    {
      try
      {
        Date localDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse(paramString);
        paramString = Calendar.getInstance();
        localObject = localCalendar;
        QLog.i("WeatherPreloadHelper", 1, "isToady", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Intrinsics.checkExpressionValueIsNotNull(paramString, "calendarLast");
          localObject = localCalendar;
          paramString.setTime(localDate);
          localObject = localCalendar;
          localCalendar = Calendar.getInstance();
          localObject = localCalendar;
          Intrinsics.checkExpressionValueIsNotNull(localCalendar, "calendarNow");
          localObject = localCalendar;
          localCalendar.setTime(new Date());
          localObject = localCalendar;
          if ((paramString == null) || (localObject == null) || (paramString.get(0) != ((Calendar)localObject).get(0)) || (paramString.get(1) != ((Calendar)localObject).get(1)) || (paramString.get(6) != ((Calendar)localObject).get(6))) {
            break;
          }
          return true;
        }
        catch (Throwable localThrowable2)
        {
          break label146;
        }
        localThrowable1 = localThrowable1;
        paramString = (String)localObject;
        localObject = localCalendar;
      }
    }
    return false;
  }
  
  private static final int b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (String)bfyz.b((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_last_preload_web_process", "");
    b("getTodayPreInfoTimes ：" + paramQQAppInterface);
    if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {}
    do
    {
      Object localObject;
      do
      {
        return 0;
        Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "preloadString");
        localObject = StringsKt.split$default((CharSequence)paramQQAppInterface, new String[] { "|" }, false, 0, 6, null);
      } while ((((List)localObject).size() != 2) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(0))) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(1))) || (!a((String)((List)localObject).get(0))));
      paramQQAppInterface = (Integer)null;
      try
      {
        localObject = Integer.valueOf((String)((List)localObject).get(1));
        paramQQAppInterface = (QQAppInterface)localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.i("WeatherPreloadHelper", 1, "getPreInfoTimes", localThrowable);
        }
      }
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.intValue();
  }
  
  private static final void b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl == null)
    {
      b("preloadWebProcess context error");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface)))
    {
      b("preloadWebProcess app error");
      return;
    }
    Manager localManager = ((AppRuntime)localObject).getManager(13);
    if ((localManager == null) || (!(localManager instanceof WebProcessManager)))
    {
      b("preloadWebProcess wpm error");
      b((QQAppInterface)localObject, -2000);
      return;
    }
    int i = a((Context)localBaseApplicationImpl, (QQAppInterface)localObject);
    if (i != 0)
    {
      b("preloadWebProcess no need result " + i);
      b((QQAppInterface)localObject, i);
      return;
    }
    b("preloadWebProcess");
    boolean bool = WebProcessManager.c();
    ((WebProcessManager)localManager).a(-1, (bgso)new algt((AppRuntime)localObject, bool));
  }
  
  private static final void b(QQAppInterface paramQQAppInterface)
  {
    int i = b(paramQQAppInterface);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    bfyz.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), true, "key_last_preload_web_process", localSimpleDateFormat.format(new Date()) + '|' + (i + 1));
  }
  
  private static final void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    bfyz.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), true, "key_last_preload_web_result", localSimpleDateFormat.format(new Date()) + '|' + paramInt);
    if ((paramInt == -2000) || (paramInt == -3005) || (paramInt == -4001)) {
      algh.a().a(paramQQAppInterface, "new_folder_prestart_fail_others", Integer.valueOf(paramInt));
    }
  }
  
  private static final void b(String paramString)
  {
    QLog.i("WeatherPreloadHelper", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algs
 * JD-Core Version:    0.7.0.1
 */