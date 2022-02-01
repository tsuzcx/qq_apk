import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class adbo
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  protected adaa a;
  final adad jdField_a_of_type_Adad;
  final adbk jdField_a_of_type_Adbk;
  protected List<bjcg> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + adbo.class.getSimpleName();
  }
  
  public adbo(adad paramadad, adbk paramadbk)
  {
    this.jdField_a_of_type_Adad = paramadad;
    this.jdField_a_of_type_Adbk = paramadbk;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("app_id", this.jdField_a_of_type_Adad.jdField_a_of_type_JavaLangString);
    localLinkedHashMap.put("uin", paramAppRuntime.getAccount());
    localLinkedHashMap.put("sdkp", "a");
    localLinkedHashMap.put("response_type", "token");
    awxt localawxt = this.jdField_a_of_type_Adad.a();
    if (localawxt == null)
    {
      paramAppRuntime = "";
      localLinkedHashMap.put("app_name", paramAppRuntime);
      localLinkedHashMap.put("kSSOLoginTypeKey", "1");
      localLinkedHashMap.put("scope", "get_user_info,get_simple_userinfo,add_share,get_info,server_side");
      if (localawxt != null) {
        break label265;
      }
    }
    label265:
    for (paramAppRuntime = "";; paramAppRuntime = localawxt.i)
    {
      localLinkedHashMap.put("bundleid", paramAppRuntime);
      localLinkedHashMap.put("skey", paramString1);
      localLinkedHashMap.put("state", paramString3);
      localLinkedHashMap.put("redirect_uri", paramString2);
      paramString2 = localLinkedHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (Map.Entry)paramString2.next();
        paramString1 = (String)paramString3.getValue();
        paramAppRuntime = paramString1;
        if (paramString1 == null) {
          paramAppRuntime = "";
        }
        localStringBuilder.append((String)paramString3.getKey() + "=" + URLEncoder.encode(paramAppRuntime) + "&");
      }
      paramAppRuntime = localawxt.jdField_b_of_type_JavaLangString;
      break;
    }
    int i = localStringBuilder.length();
    if (i > 0) {
      localStringBuilder.delete(i - 1, i);
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doAuthorize");
    }
    long l = Long.parseLong(this.jdField_a_of_type_Adad.jdField_a_of_type_JavaLangString);
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(l);
    localAuthorizeRequest.need_pay.set(1);
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bjcg)((Iterator)localObject1).next();
      if (((bjcg)localObject2).jdField_a_of_type_Int > 0) {
        localAuthorizeRequest.openapi.add(Integer.valueOf(((bjcg)localObject2).jdField_b_of_type_Int));
      }
    }
    localAuthorizeRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    localAuthorizeRequest.qqv.set(bizw.a().d());
    localAuthorizeRequest.pf.set("openmobile_android");
    localAuthorizeRequest.sdkp.set(addh.a(this.jdField_a_of_type_Adad.jdField_a_of_type_Int));
    localAuthorizeRequest.sdkv.set("1.5.9");
    localAuthorizeRequest.response_type.set("token");
    if ((this.jdField_a_of_type_Adad instanceof adak))
    {
      localObject1 = ((adak)this.jdField_a_of_type_Adad).a();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localAuthorizeRequest.appUniqueIdentifier.set((String)localObject1);
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = ((TicketManager)((AppRuntime)localObject1).getManager(2)).getSkey((String)localObject2);
    if (localObject3 != null) {
      localAuthorizeRequest.skey.set((String)localObject3);
    }
    if ((this.jdField_a_of_type_Adad instanceof adcd))
    {
      adcd localadcd = (adcd)this.jdField_a_of_type_Adad;
      if (localadcd.b)
      {
        localObject3 = a((AppRuntime)localObject1, (String)localObject3, localadcd.e, localadcd.d);
        localAuthorizeRequest.passData.set((String)localObject3);
      }
    }
    localObject3 = new NewIntent(BaseApplicationImpl.getApplication(), bjhv.class);
    ((NewIntent)localObject3).setWithouLogin(true);
    ((NewIntent)localObject3).putExtra("uin", (String)localObject2);
    ((NewIntent)localObject3).putExtra("data", localAuthorizeRequest.toByteArray());
    ((NewIntent)localObject3).putExtra("cmd", "ConnAuthSvr.sdk_auth_api");
    ((NewIntent)localObject3).setObserver(new adbt(this, (String)localObject2));
    ((AppRuntime)localObject1).startServlet((NewIntent)localObject3);
  }
  
  private void a(String paramString)
  {
    String str = null;
    awxt localawxt = this.jdField_a_of_type_Adad.a();
    Object localObject;
    if (localawxt == null)
    {
      localObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label144;
      }
      localObject = BaseApplicationImpl.getApplication().getString(2131694474);
    }
    label144:
    for (;;)
    {
      if (TextUtils.isEmpty(paramString))
      {
        a();
        return;
        localObject = localawxt.jdField_b_of_type_JavaLangString;
        break;
      }
      adad localadad = this.jdField_a_of_type_Adad;
      if (localawxt == null) {}
      for (;;)
      {
        localadad.a((String)localObject, str, BaseApplicationImpl.getApplication().getString(2131694473, new Object[] { localObject }), paramString, BaseApplicationImpl.getApplication().getString(2131720094), new adbq(this), BaseApplicationImpl.getApplication().getString(2131720104), new adbr(this), new adbs(this));
        return;
        str = localawxt.c;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "-->queryAuthority");
    }
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_Adad.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2;
        Object localObject2;
        Object localObject1;
        String str3;
        PBStringField localPBStringField;
        continue;
        String str1 = "all";
      }
    }
    localGetAuthApiListRequest.client_id.set(l1);
    localGetAuthApiListRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    str2 = bizw.a().d();
    localObject2 = localGetAuthApiListRequest.qqv;
    localObject1 = str2;
    if (str2 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localGetAuthApiListRequest.pf.set("openmobile_android");
    if (((this.jdField_a_of_type_Adad instanceof adcd)) && (((adcd)this.jdField_a_of_type_Adad).b))
    {
      localObject1 = "all" + ",server_side";
      localGetAuthApiListRequest.scope.set((String)localObject1);
      localGetAuthApiListRequest.sdkp.set(addh.a(this.jdField_a_of_type_Adad.jdField_a_of_type_Int));
      localGetAuthApiListRequest.sdkv.set("1.5.9");
      localGetAuthApiListRequest.need_pay.set(1);
      if ((this.jdField_a_of_type_Adad instanceof adak))
      {
        localObject1 = ((adak)this.jdField_a_of_type_Adad).a();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject1);
        }
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      str3 = ((AppRuntime)localObject2).getAccount();
      str2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey(str3);
      localPBStringField = localGetAuthApiListRequest.skey;
      localObject1 = str2;
      if (str2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), bjhv.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("uin", str3);
      ((NewIntent)localObject1).putExtra("data", localGetAuthApiListRequest.toByteArray());
      ((NewIntent)localObject1).putExtra("cmd", "ConnAuthSvr.get_auth_api_list");
      ((NewIntent)localObject1).setObserver(new adbp(this, str3, paramBoolean));
      ((AppRuntime)localObject2).startServlet((NewIntent)localObject1);
      return;
    }
  }
  
  private boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramGetAuthApiListResponse = paramGetAuthApiListResponse.authorized_form_list.get().iterator();
    while (paramGetAuthApiListResponse.hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)paramGetAuthApiListResponse.next();
      if (localAuthItem.is_new.get() != 0)
      {
        bjcg localbjcg = new bjcg();
        localbjcg.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
        localbjcg.jdField_a_of_type_Int = localAuthItem.default_flag.get();
        localbjcg.jdField_b_of_type_Int = localAuthItem.id.get();
        if (localAuthItem.is_new.get() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          localbjcg.jdField_a_of_type_Boolean = bool;
          localbjcg.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
          this.jdField_a_of_type_JavaUtilList.add(localbjcg);
          break;
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "openBrowserForRedirect: invoked.  url: " + paramString);
    }
    Object localObject = this.jdField_a_of_type_Adad.a();
    if ((localObject != null) && ((this.jdField_a_of_type_Adad instanceof adcd)) && ((localObject instanceof biex)))
    {
      localObject = ((biex)localObject).a();
      if (localObject != null) {
        ((WebViewFragment)localObject).webView.loadUrl(paramString);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, adaa paramadaa, boolean paramBoolean)
  {
    this.jdField_a_of_type_Adaa = paramadaa;
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbo
 * JD-Core Version:    0.7.0.1
 */