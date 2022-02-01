import android.content.Context;
import android.net.Uri;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public final class acid
{
  private static gdt_analysis_event a(Context paramContext, int paramInt1, GdtAd paramGdtAd, int paramInt2, int paramInt3, String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    paramGdtAd = AdReporterForAnalysis.createEventForAd(paramContext, paramInt1, paramGdtAd);
    if (paramInt2 == 0)
    {
      paramGdtAd.statisticsType = 101;
      paramGdtAd.businessId = String.valueOf(paramInt3);
      if (paramString == null) {
        break label79;
      }
    }
    label79:
    for (paramContext = paramString.getHost();; paramContext = null)
    {
      paramGdtAd.hostName = paramContext;
      return paramGdtAd;
      if (paramInt2 == 1)
      {
        paramGdtAd.statisticsType = 102;
        break;
      }
      if (paramInt2 != 2) {
        break;
      }
      paramGdtAd.statisticsType = 105;
      break;
    }
  }
  
  private static gdt_analysis_event a(Context paramContext, int paramInt, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    int j = -2147483648;
    int k = 1;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i;
    if (paramGdtInterstitialParams != null) {
      if (paramGdtInterstitialParams.jdField_b_of_type_Int == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      label46:
      label63:
      long l;
      if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.a != null))
      {
        paramContext = paramGdtInterstitialParams.a.a;
        paramContext = AdReporterForAnalysis.createEventForAd(localBaseApplication, paramInt, paramContext);
        if (paramGdtInterstitialStatus == null) {
          break label247;
        }
        paramInt = paramGdtInterstitialStatus.jdField_a_of_type_Int;
        paramContext.activityStatus = paramInt;
        if (paramGdtInterstitialStatus == null) {
          break label253;
        }
        l = paramGdtInterstitialStatus.a();
        label78:
        paramContext.duration = l;
        paramContext.orientation = i;
        if (paramGdtInterstitialStatus == null) {
          break label261;
        }
        paramInt = paramGdtInterstitialStatus.jdField_b_of_type_Int;
        label99:
        paramContext.reason = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_a_of_type_Boolean)) {
          break label267;
        }
        paramInt = 1;
        label117:
        paramContext.status1 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_b_of_type_Boolean)) {
          break label272;
        }
        paramInt = 1;
        label135:
        paramContext.status2 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_c_of_type_Boolean)) {
          break label277;
        }
        paramInt = 1;
        label153:
        paramContext.status3 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_e_of_type_Boolean)) {
          break label282;
        }
        paramInt = 1;
        label171:
        paramContext.status4 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_f_of_type_Boolean)) {
          break label287;
        }
      }
      label261:
      label267:
      label272:
      label277:
      label282:
      label287:
      for (paramInt = k;; paramInt = 0)
      {
        paramContext.status5 = paramInt;
        paramInt = j;
        if (paramGdtInterstitialStatus != null) {
          paramInt = paramGdtInterstitialStatus.jdField_f_of_type_Int;
        }
        paramContext.videoStatus = paramInt;
        return paramContext;
        if (paramGdtInterstitialParams.jdField_b_of_type_Int == 0)
        {
          i = 1;
          break;
        }
        if (paramGdtInterstitialParams.jdField_b_of_type_Int != 8) {
          break label292;
        }
        i = 2;
        break;
        paramContext = null;
        break label46;
        label247:
        paramInt = -2147483648;
        break label63;
        label253:
        l = -2147483648L;
        break label78;
        paramInt = -2147483648;
        break label99;
        paramInt = 0;
        break label117;
        paramInt = 0;
        break label135;
        paramInt = 0;
        break label153;
        paramInt = 0;
        break label171;
      }
      label292:
      i = -2147483648;
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext = BaseApplicationImpl.getContext();
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1081, localgdt_analysis_event);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    long l = -2147483648L;
    paramContext = BaseApplicationImpl.getContext();
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1082, localgdt_analysis_event);
    if (paramLong != -2147483648L) {
      l = System.currentTimeMillis() - paramLong;
    }
    localgdt_analysis_event.duration = l;
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, acif paramacif, String paramString)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramacif = a(paramContext, 1056, new GdtAd(paramacif.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramacif.jdField_a_of_type_Int, paramacif.jdField_b_of_type_Int, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramacif, 102));
  }
  
  public static void a(Context paramContext, acif paramacif, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramacif = a(paramContext, 1060, new GdtAd(paramacif.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramacif.jdField_a_of_type_Int, paramacif.jdField_b_of_type_Int, paramString);
    paramacif.httpErrorCode = paramInt;
    if (paramacif.httpErrorCode == 200) {
      paramacif.internalErrorCode = 0;
    }
    for (;;)
    {
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramacif, 102));
      return;
      if (paramacif.httpErrorCode == -1) {
        paramacif.internalErrorCode = 3;
      } else {
        paramacif.internalErrorCode = 5;
      }
    }
  }
  
  public static void a(Context paramContext, acif paramacif, String paramString, int paramInt, long paramLong)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramacif = a(paramContext, 1057, new GdtAd(paramacif.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramacif.jdField_a_of_type_Int, paramacif.jdField_b_of_type_Int, paramString);
    paramacif.httpErrorCode = paramInt;
    if (paramacif.httpErrorCode == 200) {
      paramacif.internalErrorCode = 0;
    }
    for (;;)
    {
      paramacif.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramacif, 102));
      return;
      if (paramacif.httpErrorCode == -1) {
        paramacif.internalErrorCode = 3;
      } else {
        paramacif.internalErrorCode = 5;
      }
    }
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtAd = a(paramContext, 1058, paramGdtAd, paramInt1, paramInt2, null);
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = 4)
    {
      paramGdtAd.internalErrorCode = paramInt1;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtAd, 102));
      return;
    }
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1084, paramGdtInterstitialParams, null);
    paramGdtInterstitialParams.internalErrorCode = paramInt;
    paramGdtInterstitialParams.androidFromProcessName = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1086, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1085, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramInt;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt1, int paramInt2)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1087, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramInt1;
    paramGdtInterstitialParams.errorCode1 = paramInt2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString1, String paramString2)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1071, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.api = paramString1;
    paramGdtInterstitialParams.hostName = paramString2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1088, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString1, String paramString2)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1072, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.api = paramString1;
    paramGdtInterstitialParams.hostName = paramString2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void c(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1089, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void d(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1092, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramGdtInterstitialStatus.jdField_c_of_type_Int;
    paramGdtInterstitialParams.errorCode1 = paramGdtInterstitialStatus.d;
    paramGdtInterstitialParams.errorCode2 = paramGdtInterstitialStatus.jdField_e_of_type_Int;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acid
 * JD-Core Version:    0.7.0.1
 */