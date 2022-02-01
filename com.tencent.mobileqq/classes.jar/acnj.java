import android.app.Activity;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackData;", "", "rewardedVideoAdPlugin", "Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;", "compId", "", "activity", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "event", "webView", "Lcom/tencent/mobileqq/mini/webview/JsRuntime;", "callbackId", "", "isMiniGame", "", "(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;Ljava/lang/String;Lmqq/util/WeakReference;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;IZ)V", "getActivity", "()Lmqq/util/WeakReference;", "getCallbackId", "()I", "getCompId", "()Ljava/lang/String;", "getEvent", "()Z", "getRewardedVideoAdPlugin", "()Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;", "getWebView", "()Lcom/tencent/mobileqq/mini/webview/JsRuntime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createKey", "equals", "other", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class acnj
{
  public static final acnk a;
  private static int jdField_b_of_type_Int;
  private final int jdField_a_of_type_Int;
  @NotNull
  private final RewardedVideoAdPlugin jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin;
  @NotNull
  private final JsRuntime jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Acnk = new acnk(null);
  }
  
  public acnj(@NotNull RewardedVideoAdPlugin paramRewardedVideoAdPlugin, @NotNull String paramString1, @NotNull WeakReference<Activity> paramWeakReference, @NotNull String paramString2, @NotNull JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin = paramRewardedVideoAdPlugin;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime = paramJsRuntime;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final JsRuntime a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime;
  }
  
  @NotNull
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("REWARDED_PLUGIN_ACTION_MOTIVE_BROWSING_END#").append(this.jdField_a_of_type_JavaLangString).append('#').append(this.jdField_b_of_type_JavaLangString).append('#').append(this.jdField_a_of_type_Int).append('#').append(this.jdField_a_of_type_Boolean).append('#');
    int i = jdField_b_of_type_Int;
    jdField_b_of_type_Int = i + 1;
    return i;
  }
  
  @NotNull
  public final WeakReference<Activity> a()
  {
    return this.jdField_a_of_type_MqqUtilWeakReference;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof acnj))
      {
        paramObject = (acnj)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin, paramObject.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_MqqUtilWeakReference, paramObject.jdField_a_of_type_MqqUtilWeakReference)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime, paramObject.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_a_of_type_Boolean != paramObject.jdField_a_of_type_Boolean)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "RewardedBrowsingCallbackData(rewardedVideoAdPlugin=" + this.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin + ", compId=" + this.jdField_a_of_type_JavaLangString + ", activity=" + this.jdField_a_of_type_MqqUtilWeakReference + ", event=" + this.jdField_b_of_type_JavaLangString + ", webView=" + this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime + ", callbackId=" + this.jdField_a_of_type_Int + ", isMiniGame=" + this.jdField_a_of_type_Boolean + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnj
 * JD-Core Version:    0.7.0.1
 */