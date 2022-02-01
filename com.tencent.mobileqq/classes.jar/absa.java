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

public final class absa
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
    Object localObject = null;
    long l2 = -2147483648L;
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
      label54:
      label71:
      long l1;
      if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.a != null))
      {
        paramContext = paramGdtInterstitialParams.a.a;
        paramGdtInterstitialParams = AdReporterForAnalysis.createEventForAd(localBaseApplication, paramInt, paramContext);
        if (paramGdtInterstitialStatus == null) {
          break label308;
        }
        paramInt = paramGdtInterstitialStatus.jdField_a_of_type_Int;
        paramGdtInterstitialParams.activityStatus = paramInt;
        paramContext = localObject;
        if (paramGdtInterstitialStatus != null) {
          paramContext = paramGdtInterstitialStatus.jdField_a_of_type_JavaLangString;
        }
        paramGdtInterstitialParams.androidFromProcessName = paramContext;
        if (paramGdtInterstitialStatus == null) {
          break label314;
        }
        l1 = paramGdtInterstitialStatus.a();
        label103:
        paramGdtInterstitialParams.duration = l1;
        if (paramGdtInterstitialStatus == null) {
          break label322;
        }
        l1 = paramGdtInterstitialStatus.b();
        label119:
        paramGdtInterstitialParams.duration2 = l1;
        paramGdtInterstitialParams.orientation = i;
        if (paramGdtInterstitialStatus == null) {
          break label330;
        }
        paramInt = paramGdtInterstitialStatus.jdField_b_of_type_Int;
        label140:
        paramGdtInterstitialParams.reason = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_a_of_type_Boolean)) {
          break label336;
        }
        paramInt = 1;
        label158:
        paramGdtInterstitialParams.status1 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_b_of_type_Boolean)) {
          break label341;
        }
        paramInt = 1;
        label176:
        paramGdtInterstitialParams.status2 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_c_of_type_Boolean)) {
          break label346;
        }
        paramInt = 1;
        label194:
        paramGdtInterstitialParams.status3 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_e_of_type_Boolean)) {
          break label351;
        }
        paramInt = 1;
        label212:
        paramGdtInterstitialParams.status4 = paramInt;
        if ((paramGdtInterstitialStatus == null) || (!paramGdtInterstitialStatus.jdField_f_of_type_Boolean)) {
          break label356;
        }
      }
      label308:
      label314:
      label322:
      label330:
      label336:
      label341:
      label346:
      label351:
      label356:
      for (paramInt = k;; paramInt = 0)
      {
        paramGdtInterstitialParams.status5 = paramInt;
        l1 = l2;
        if (paramGdtInterstitialStatus != null) {
          l1 = paramGdtInterstitialStatus.jdField_a_of_type_Long;
        }
        paramGdtInterstitialParams.videoPositionMillis = l1;
        paramInt = j;
        if (paramGdtInterstitialStatus != null) {
          paramInt = paramGdtInterstitialStatus.jdField_f_of_type_Int;
        }
        paramGdtInterstitialParams.videoStatus = paramInt;
        return paramGdtInterstitialParams;
        if (paramGdtInterstitialParams.jdField_b_of_type_Int == 0)
        {
          i = 1;
          break;
        }
        if (paramGdtInterstitialParams.jdField_b_of_type_Int != 8) {
          break label361;
        }
        i = 2;
        break;
        paramContext = null;
        break label54;
        paramInt = -2147483648;
        break label71;
        l1 = -2147483648L;
        break label103;
        l1 = -2147483648L;
        break label119;
        paramInt = -2147483648;
        break label140;
        paramInt = 0;
        break label158;
        paramInt = 0;
        break label176;
        paramInt = 0;
        break label194;
        paramInt = 0;
        break label212;
      }
      label361:
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
  
  public static void a(Context paramContext, absc paramabsc, int paramInt, long paramLong)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramabsc = a(paramContext, 1059, new GdtAd(paramabsc.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramabsc.jdField_a_of_type_Int, paramabsc.jdField_b_of_type_Int, null);
    if (paramInt == 0)
    {
      paramabsc.internalErrorCode = 0;
      paramabsc.errorCode1 = paramInt;
      if (paramLong == -2147483648L) {
        break label124;
      }
    }
    label124:
    for (paramLong = System.currentTimeMillis() - paramLong;; paramLong = -2147483648L)
    {
      paramabsc.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramabsc, 102));
      return;
      if (paramInt == 1)
      {
        paramabsc.internalErrorCode = 2;
        break;
      }
      if (paramInt == 2)
      {
        paramabsc.internalErrorCode = 4;
        break;
      }
      paramabsc.internalErrorCode = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, absc paramabsc, String paramString)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramabsc = a(paramContext, 1056, new GdtAd(paramabsc.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramabsc.jdField_a_of_type_Int, paramabsc.jdField_b_of_type_Int, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramabsc, 102));
  }
  
  public static void a(Context paramContext, absc paramabsc, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramabsc = a(paramContext, 1060, new GdtAd(paramabsc.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramabsc.jdField_a_of_type_Int, paramabsc.jdField_b_of_type_Int, paramString);
    paramabsc.httpErrorCode = paramInt;
    if (paramabsc.httpErrorCode == 200) {
      paramabsc.internalErrorCode = 0;
    }
    for (;;)
    {
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramabsc, 102));
      return;
      if (paramabsc.httpErrorCode == -1) {
        paramabsc.internalErrorCode = 3;
      } else {
        paramabsc.internalErrorCode = 5;
      }
    }
  }
  
  public static void a(Context paramContext, absc paramabsc, String paramString, int paramInt, long paramLong)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramabsc = a(paramContext, 1057, new GdtAd(paramabsc.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramabsc.jdField_a_of_type_Int, paramabsc.jdField_b_of_type_Int, paramString);
    paramabsc.httpErrorCode = paramInt;
    if (paramabsc.httpErrorCode == 200) {
      paramabsc.internalErrorCode = 0;
    }
    for (;;)
    {
      paramabsc.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramabsc, 102));
      return;
      if (paramabsc.httpErrorCode == -1) {
        paramabsc.internalErrorCode = 3;
      } else {
        paramabsc.internalErrorCode = 5;
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
    paramGdtInterstitialParams = a(paramContext, 1088, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1086, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.errorCode3 = paramInt;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt1, int paramInt2)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1085, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramInt1;
    paramGdtInterstitialParams.errorCode3 = paramInt2;
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
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1091, paramGdtInterstitialParams, null);
    paramGdtInterstitialParams.internalErrorCode = paramInt;
    paramGdtInterstitialParams.androidFromProcessName = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1089, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1093, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramGdtInterstitialStatus.jdField_c_of_type_Int;
    paramGdtInterstitialParams.errorCode1 = paramGdtInterstitialStatus.d;
    paramGdtInterstitialParams.errorCode2 = paramGdtInterstitialStatus.jdField_e_of_type_Int;
    paramGdtInterstitialParams.errorCode3 = paramInt;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt1, int paramInt2)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1087, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramInt1;
    paramGdtInterstitialParams.errorCode1 = paramInt2;
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
    paramGdtInterstitialParams = a(paramContext, 1090, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void c(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1096, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramGdtInterstitialStatus.jdField_c_of_type_Int;
    paramGdtInterstitialParams.errorCode1 = paramGdtInterstitialStatus.d;
    paramGdtInterstitialParams.errorCode2 = paramGdtInterstitialStatus.jdField_e_of_type_Int;
    paramGdtInterstitialParams.errorCode3 = paramInt;
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
  
  public static void e(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1094, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void f(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtInterstitialParams = a(paramContext, 1095, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absa
 * JD-Core Version:    0.7.0.1
 */