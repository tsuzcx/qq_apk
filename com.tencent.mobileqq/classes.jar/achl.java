import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class achl
  implements acgx
{
  private WeakReference<acfw> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static int a(int paramInt)
  {
    int i = 1;
    if (1 == paramInt) {
      i = 0;
    }
    while (2 != paramInt) {
      return i;
    }
    return 8;
  }
  
  public static GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt)
  {
    Object localObject2 = null;
    GdtAd localGdtAd = new GdtAd(paramAdInfo);
    if ((localGdtAd != null) && (localGdtAd.info != null))
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
      localGdtMotiveVideoPageData.vSize = localGdtAd.getCreativeSize();
      localGdtMotiveVideoPageData.screenOrientation = paramInt;
      localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
      acho.d("GdtOpenMvPageHandler", "VideoUrl " + localGdtMotiveVideoPageData.url);
      Object localObject1;
      if (localGdtAd.getImageData() == null)
      {
        localObject1 = "";
        localGdtMotiveVideoPageData.previewImgUrl = ((String)localObject1);
        localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
        localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
        localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
        localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
        localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
        localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
        localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
        localGdtMotiveVideoPageData.endcardUrl = localGdtAd.getEndcardUrl();
        localGdtMotiveVideoPageData.endcardLoadTime = localGdtAd.getEndcardLoadTime();
        localGdtMotiveVideoPageData.bottomCardUrl = localGdtAd.getBottomCardUrl();
        localGdtMotiveVideoPageData.bottomCardLoadTime = localGdtAd.getBottomCardLoadTime();
        localObject1 = localObject2;
        if (paramAdInfo != null) {
          localObject1 = achn.a(paramAdInfo);
        }
        if (localObject1 != null) {
          break label299;
        }
      }
      label299:
      for (paramAdInfo = "";; paramAdInfo = localObject1.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramAdInfo;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        return localGdtMotiveVideoPageData;
        localObject1 = localGdtAd.getImageData().a;
        break;
      }
    }
    QLog.e("GdtOpenMvPageHandler", 1, "createMVPageData error " + paramAdInfo + " portrait " + paramInt);
    return null;
  }
  
  public long a(long paramLong, String paramString1, String paramString2)
  {
    return ((paramLong >>> 32 ^ paramLong) * 31L + paramString1.hashCode()) * 31L + paramString2.hashCode();
  }
  
  public void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    String str;
    JSONObject localJSONObject;
    if (paramGdtMotiveVideoPageData != null)
    {
      str = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(a(paramGdtMotiveVideoPageData.adId, paramGdtMotiveVideoPageData.url, paramGdtMotiveVideoPageData.adsContent)));
      if (str != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramGdtMotiveVideoPageData);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramGdtMotiveVideoPageData = (acfw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramGdtMotiveVideoPageData != null)
          {
            QLog.w("GdtOpenMvPageHandler", 1, "callResultFunc2Web elapsedtime " + paramString1 + " totaltime " + paramString2 + " isEnd " + paramString3);
            localJSONObject = new JSONObject();
          }
        }
      }
    }
    try
    {
      localJSONObject.put("elapsedTime", paramString1);
      localJSONObject.put("totalTime", paramString2);
      localJSONObject.put("isEnd", paramString3);
      paramGdtMotiveVideoPageData.callJs(str, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject2 = null;
    int m = 0;
    i = 0;
    if (paramacfw != null) {}
    for (Activity localActivity = paramacfw.a(); (paramacfw == null) || (localActivity == null); localActivity = null)
    {
      acho.d("GdtOpenMvPageHandler", "GdtOpenMvPageHandler error");
      return true;
    }
    String str2 = "";
    for (;;)
    {
      try
      {
        acho.a("GdtOpenMvPageHandler", "args = " + paramVarArgs[0]);
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        int j = ((JSONObject)localObject1).optInt("orientation");
        k = m;
        GdtMotiveVideoPageData localGdtMotiveVideoPageData;
        QLog.e("GdtOpenMvPageHandler", 1, "GdtOpenMvPageHandler e2", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          paramVarArgs = ((JSONObject)localObject1).optString("adInfo");
          k = m;
          i = ((JSONObject)localObject1).optInt("rewardTime", 0);
          k = i;
          paramVarArgs = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramVarArgs)));
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            int k;
            String str1;
            paramVarArgs = null;
            i = k;
          }
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).optString("rewardText");
          localGdtMotiveVideoPageData = a(paramVarArgs, a(j));
          if (localGdtMotiveVideoPageData != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(a(localGdtMotiveVideoPageData.adId, localGdtMotiveVideoPageData.url, localGdtMotiveVideoPageData.adsContent)), paramString);
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacfw);
            str2 = localActivity.getIntent().getStringExtra("big_brother_ref_source_key");
            paramString = str2;
            if (TextUtils.isEmpty(str2)) {
              paramString = localActivity.getIntent().getStringExtra("big_brother_source_key");
            }
            localGdtMotiveVideoPageData.refId = paramString;
            if (i > 0) {
              localGdtMotiveVideoPageData.setVideoCountDown(i);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localGdtMotiveVideoPageData.setRewardText((String)localObject1);
            }
            GdtMotiveVideoFragment.b(paramacfw.a(), GdtMotiveVideoFragment.class, localGdtMotiveVideoPageData);
          }
          if (paramacfw == null) {
            break label377;
          }
          paramString = paramacfw.a();
          localObject1 = localObject2;
          if (paramacfw != null) {
            localObject1 = paramacfw.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "openMotiveVideoAd", (String)localObject1, new GdtAd(paramVarArgs));
          return true;
        }
        catch (Throwable localThrowable3)
        {
          break label359;
        }
        localThrowable1 = localThrowable1;
        j = 0;
        paramVarArgs = null;
      }
      label359:
      str1 = str2;
      continue;
      label377:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achl
 * JD-Core Version:    0.7.0.1
 */