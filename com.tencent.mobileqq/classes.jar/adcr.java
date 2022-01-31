import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.RangeButtonView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class adcr
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, bfve
{
  public static final int[] a;
  public static long b;
  public int a;
  public long a;
  private adct jdField_a_of_type_Adct;
  public Activity a;
  public PopupWindow a;
  public bbjq a;
  public WebViewFragment a;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  public String a;
  public final ArrayList<String> a;
  wxr jdField_a_of_type_Wxr = null;
  public xmq a;
  public boolean a;
  private int b;
  public String b;
  public ArrayList<nnr> b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  boolean d;
  private String e;
  public boolean e;
  private String f;
  public boolean f;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 95, 100, 107, 115, 127 };
    jdField_b_of_type_Long = -1L;
  }
  
  public adcr(Activity paramActivity, WebView paramWebView)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 4L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    a();
  }
  
  private void c()
  {
    if (a(this.jdField_a_of_type_Xmq.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      a(System.currentTimeMillis());
      int j = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int i = j;
      if (j < 0) {
        i = 190;
      }
      str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
    } while (this.jdField_a_of_type_ComTencentSmttSdkWebView == null);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:" + str + ";");
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Xmq == null) {
      return "";
    }
    return this.jdField_a_of_type_Xmq.a();
  }
  
  public wxr a()
  {
    if (this.jdField_a_of_type_Wxr == null)
    {
      this.jdField_a_of_type_Wxr = wxr.a();
      this.jdField_a_of_type_Wxr.a();
    }
    return this.jdField_a_of_type_Wxr;
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("url");
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("key_params_qq");
      if (this.jdField_e_of_type_JavaLangString == null) {
        this.jdField_e_of_type_JavaLangString = "";
      }
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = a();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_e_of_type_JavaLangString;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    if ((!"article.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost()))) {
      return;
    }
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1001", "");
      return;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return;
    case 1: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, (String)localObject3, (String)localObject2, "1011", "");
      return;
    case 2: 
    case 3: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1002", "");
      return;
    case 9: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1003", "");
      return;
    case 10: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1004", "");
      return;
    case 5: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1005", "");
      return;
    case 4: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1006", "");
      return;
    case 6: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1007", "");
      return;
    case 11: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1008", "");
      return;
    case 8: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
      return;
    case 7: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1010", "");
      return;
    case 12: 
      axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1012", "");
      return;
    }
    axqy.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1013", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    a().a(this.jdField_a_of_type_Int);
  }
  
  @TargetApi(12)
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    String str6 = "";
    String str5;
    String str4;
    String str3;
    String str2;
    String str1;
    int j;
    int i;
    if (paramBundle != null)
    {
      str5 = paramBundle.getString("qq", "");
      str4 = paramBundle.getString("public_uin", "");
      str3 = paramBundle.getString("source_public_uin", "");
      str2 = paramBundle.getString("default_url", "");
      str1 = paramBundle.getString("msg_id", "");
      j = paramBundle.getInt("troop_app_id", 0);
      i = paramBundle.getInt("troop_id", 0);
      str6 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
    }
    for (;;)
    {
      Object localObject3 = this.jdField_e_of_type_JavaLangString;
      Object localObject4 = null;
      Object localObject1 = localObject4;
      String str8;
      Object localObject5;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        str8 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_e_of_type_JavaLangString;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView();
        localObject1 = localObject4;
        localObject3 = str8;
        if (localObject5 != null)
        {
          localObject1 = ((WebView)localObject5).getOriginalUrl();
          localObject3 = str8;
        }
      }
      localObject4 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = paramString;
        if (((String)localObject1).equals(paramString)) {}
      }
      try
      {
        localObject4 = Uri.parse((String)localObject1);
        localObject5 = ((Uri)localObject4).getHost();
        str8 = null;
        if (((Uri)localObject4).isHierarchical()) {
          str8 = ((Uri)localObject4).getQueryParameter("_pflag");
        }
        localObject4 = paramString;
        if (!TextUtils.isEmpty(str8)) {
          if (!"post.mp.qq.com".equalsIgnoreCase((String)localObject5))
          {
            localObject4 = paramString;
            if (!"url.cn".equalsIgnoreCase((String)localObject5)) {}
          }
          else
          {
            int k = Integer.parseInt(str8);
            localObject4 = paramString;
            if ((k >> 3 & 0x1) == 1) {
              localObject4 = localObject1;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label823:
          label1361:
          label1378:
          String str7 = paramString;
          label1289:
          label1618:
          label2145:
          continue;
          long l1 = 0L;
          continue;
          label3082:
          l1 = 0L;
          continue;
          label3088:
          l1 = 0L;
          continue;
          label3094:
          Object localObject2 = localObject3;
          continue;
          label3101:
          localObject2 = localObject3;
        }
      }
      if (paramInt == 1)
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText((CharSequence)localObject4);
        wij.a(2, 2131691309);
        if ((this.h) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p))) {
          this.jdField_a_of_type_Xmq.e();
        }
      }
      for (;;)
      {
        a(paramInt);
        return;
        if (paramInt == 11)
        {
          paramString = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher((CharSequence)localObject4);
          i = 0;
          if (paramString.matches()) {
            i = 1;
          }
          paramBundle = null;
          try
          {
            paramString = URLEncoder.encode((String)localObject4, "UTF-8");
            if (i != 0)
            {
              localObject3 = String.valueOf(NetConnInfoCenter.getServerTime());
              localObject1 = bdik.b(paramString + 200 + (String)localObject3 + "jubao@article@123");
              paramBundle = (Bundle)localObject1;
              if (localObject1 != null)
              {
                paramBundle = (Bundle)localObject1;
                if (!((String)localObject1).isEmpty()) {
                  paramBundle = ((String)localObject1).toLowerCase();
                }
              }
              paramString = "https://post.mp.qq.com/jubao/index?qq=" + str5 + "&mp_uin=" + str4 + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject3 + "&sign=" + paramBundle + "&article_url=" + paramString + "&_wv=3";
              paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_more_button", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
              axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            for (;;)
            {
              paramString = paramBundle;
              if (QLog.isColorLevel())
              {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
                paramString = paramBundle;
                continue;
                paramString = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str5 + "&_wv=7";
              }
            }
          }
        }
        else
        {
          if (paramInt == 2)
          {
            boolean bool2 = false;
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) {}
            boolean bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl()))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
              {
                bool1 = bool2;
                if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                    break label823;
                  }
                  bool1 = bool2;
                  if (((String)localObject4).equals(this.jdField_f_of_type_JavaLangString)) {
                    bool1 = true;
                  }
                }
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_Xmq.g = bool1;
              a((String)localObject4, (String)localObject3, (String)localObject1);
              break;
              bool1 = bool2;
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                bool1 = bool2;
                if (((String)localObject1).equals(this.jdField_f_of_type_JavaLangString)) {
                  bool1 = true;
                }
              }
            }
          }
          if (paramInt == 4)
          {
            paramString = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject4));
            paramString.putExtra("normal", true);
            try
            {
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              axqy.b(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, nau.b(str2, new String[0]), null, null, null);
              axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
            }
            catch (ActivityNotFoundException paramString)
            {
              for (;;)
              {
                wij.a(1, 2131695573);
              }
            }
          }
          else if (paramInt != 5)
          {
            if (paramInt == 3)
            {
              jdField_b_of_type_Long = System.currentTimeMillis();
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label3101;
              }
              sgg.a(1002, (String)localObject1, this.jdField_b_of_type_Int);
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
                this.jdField_a_of_type_Xmq.a((String)localObject4, 2, false);
              }
              for (;;)
              {
                bdes.a().a("", "", "", "1000", "102", "0", false);
                axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
                break;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.r)) {
                  this.jdField_a_of_type_Xmq.h();
                } else {
                  this.jdField_a_of_type_Xmq.a();
                }
              }
            }
            if (paramInt == 6)
            {
              if (this.jdField_a_of_type_Xmq.a((String)localObject4)) {
                this.jdField_a_of_type_Xmq.a((String)localObject4, 9, false);
              }
              if ((str3 != null) && (!"".equals(str3))) {
                nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
              }
            }
            else if ((paramInt == 9) || (paramInt == 10))
            {
              i = -1;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label3094;
              }
              if (paramInt == 9)
              {
                sgg.a(1003, (String)localObject1, this.jdField_b_of_type_Int);
                if (WXShareHelper.a().a()) {
                  break label1361;
                }
                i = 2131720917;
              }
              for (;;)
              {
                if (i == -1) {
                  break label1378;
                }
                wij.a(0, i);
                if (paramInt != 9) {
                  break label1618;
                }
                bdes.a().a("", "", "", "1000", "103", "0", false);
                break;
                sgg.a(1004, (String)localObject1, this.jdField_b_of_type_Int);
                break label1289;
                if (!WXShareHelper.a().b()) {
                  i = 2131720918;
                }
              }
              if (paramInt == 9)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
                  this.jdField_a_of_type_Xmq.a((String)localObject4, 3, true);
                }
                for (;;)
                {
                  axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
                  if ((str3 == null) || ("".equals(str3))) {
                    break;
                  }
                  nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
                  break;
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.s)) {
                    this.jdField_a_of_type_Xmq.i();
                  } else {
                    this.jdField_a_of_type_Xmq.a((String)localObject4, 3, true);
                  }
                }
              }
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
                this.jdField_a_of_type_Xmq.a((String)localObject4, 4, true);
              }
              for (;;)
              {
                axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
                break;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.t)) {
                  this.jdField_a_of_type_Xmq.j();
                } else {
                  this.jdField_a_of_type_Xmq.a((String)localObject4, 4, true);
                }
              }
              if (paramInt == 10) {
                bdes.a().a("", "", "", "1000", "104", "0", false);
              }
            }
            else if (paramInt == 13)
            {
              this.jdField_a_of_type_Xmq.a((String)localObject4, 5, true);
            }
            else if (paramInt == 15)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) {
                throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
              }
              if (!bbfj.d(BaseApplicationImpl.getContext()))
              {
                bcql.a(BaseApplicationImpl.getContext(), 2, 2131720408, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
                return;
              }
              a().a(j, new adcs(this));
              axqy.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + i, "" + j, "", "");
            }
            else if (paramInt == 16)
            {
              paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
              paramString.putExtra("url", str6);
              paramString.putExtra("hide_operation_bar", true);
              paramString.putExtra("hide_more_button", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              axqy.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + i, "" + j, "", "");
            }
            else if (paramInt == 17)
            {
              paramString = "";
              if (paramBundle != null) {
                paramString = paramBundle.getString("troop_app_share_url", "");
              }
              paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_operation_bar", true);
              paramBundle.putExtra("hide_more_button", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
              axqy.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + i, "" + j, "", "");
            }
            else if (paramInt == 7)
            {
              b();
            }
            else if ((paramInt == 19) || (paramInt == 20))
            {
              if (paramInt == 19) {}
              for (i = 6;; i = 7)
              {
                if (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
                  break label2145;
                }
                this.jdField_a_of_type_Xmq.a((String)localObject4, i, false);
                break;
              }
              this.jdField_a_of_type_Xmq.a((String)localObject4, i, true);
            }
            else
            {
              if (paramInt == 12)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
                  this.jdField_a_of_type_Xmq.a((String)localObject4, 8, false);
                }
                for (;;)
                {
                  paramBundle = this.jdField_e_of_type_JavaLangString;
                  if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
                    paramBundle = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
                  }
                  paramString = "";
                  localObject1 = Uri.parse(paramBundle);
                  try
                  {
                    localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                    paramString = (String)localObject1;
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      localException1.printStackTrace();
                    }
                  }
                  localObject1 = paramString;
                  if (paramString == null) {
                    localObject1 = "";
                  }
                  nol.a(null, "", "0X800787A", "0X800787A", 0, 0, (String)localObject1, paramBundle, "", "");
                  sgg.a(1005, paramBundle, this.jdField_b_of_type_Int);
                  break;
                  this.jdField_a_of_type_Xmq.a((String)localObject4, 8, false);
                }
              }
              if (paramInt == 34)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
                  this.jdField_a_of_type_Xmq.d();
                } else if (QLog.isColorLevel()) {
                  QLog.d("diandian", 2, "dian dian is here");
                }
              }
              else if (paramInt == 35)
              {
                long l2 = 0L;
                paramBundle = null;
                l1 = l2;
                paramString = paramBundle;
                if (this.jdField_b_of_type_JavaUtilArrayList != null)
                {
                  localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                  do
                  {
                    l1 = l2;
                    paramString = paramBundle;
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    paramString = (nnr)((Iterator)localObject2).next();
                  } while (paramString.jdField_a_of_type_Int != 3);
                }
                try
                {
                  paramString = new JSONObject(paramString.jdField_b_of_type_JavaLangString);
                  l1 = paramString.getLong("uin");
                  paramString = paramString.optString("name");
                  paramString = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, l1 + "", null, 3001, 3999, paramString, null, null, null, null);
                  this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                  nol.a(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                  return;
                }
              }
              else if (paramInt == 30)
              {
                if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (!this.jdField_e_of_type_Boolean)) {
                  break label3088;
                }
                paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                do
                {
                  if (!paramString.hasNext()) {
                    break;
                  }
                  paramBundle = (nnr)paramString.next();
                } while (paramBundle.jdField_a_of_type_Int != 1);
                try
                {
                  l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
                  paramString = new Intent();
                  paramBundle = new Bundle();
                  paramString.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class));
                  paramBundle.putString("uin", String.valueOf(l1));
                  paramBundle.putInt("uintype", 1008);
                  paramString.putExtras(paramBundle);
                  paramString.putExtra("is_come_from_readinjoy", true);
                  paramString.setFlags(67108864);
                  this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                  nol.a(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                  return;
                }
              }
              else
              {
                if ((paramInt == 37) && (this.jdField_f_of_type_Boolean))
                {
                  if (this.jdField_b_of_type_JavaUtilArrayList == null) {
                    break label3082;
                  }
                  paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                  do
                  {
                    if (!paramString.hasNext()) {
                      break;
                    }
                    paramBundle = (nnr)paramString.next();
                  } while (paramBundle.jdField_a_of_type_Int != 1);
                  try
                  {
                    l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
                    paramString = actj.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
                    paramString.putExtra("uin", l1 + "");
                    paramString.putExtra("uintype", 0);
                    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                    nol.a(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                    return;
                  }
                  catch (JSONException paramString)
                  {
                    paramString.printStackTrace();
                    return;
                  }
                }
                if (paramInt == 31)
                {
                  if (this.jdField_b_of_type_JavaUtilArrayList == null) {
                    break;
                  }
                  paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                  do
                  {
                    if (!paramString.hasNext()) {
                      break;
                    }
                    paramBundle = (nnr)paramString.next();
                  } while (paramBundle.jdField_a_of_type_Int != 2);
                  try
                  {
                    l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("puin");
                    paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
                    paramString.putExtra("uin", l1 + "");
                    paramString.putExtra("from_js", true);
                    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                    nol.a(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                  }
                  catch (JSONException paramString)
                  {
                    paramString.printStackTrace();
                    return;
                  }
                }
                else if (paramInt == 38)
                {
                  this.jdField_a_of_type_Xmq.f();
                }
              }
            }
          }
        }
      }
      i = 0;
      j = 0;
      str1 = "";
      str2 = "";
      str3 = "";
      str4 = "";
      str5 = "";
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Adct = new adct();
      paramString = Uri.parse(paramString);
      if (!paramString.isHierarchical()) {
        continue;
      }
      String str = paramString.getQueryParameter("_wv");
      if (str != null) {}
      try
      {
        this.jdField_a_of_type_Adct.jdField_a_of_type_Long = Long.parseLong(str, 10);
        str = paramString.getQueryParameter("_fv");
        if (str == null) {}
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          this.jdField_a_of_type_Adct.jdField_b_of_type_Long = Long.parseLong(str, 10);
          str = paramString.getQueryParameter("_wwv");
          if (str == null) {}
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            for (;;)
            {
              this.jdField_a_of_type_Adct.c = Long.parseLong(str, 10);
              paramString = paramString.getQueryParameter("_cwv");
              if (paramString == null) {
                break;
              }
              try
              {
                this.jdField_a_of_type_Adct.d = Long.parseLong(paramString, 10);
                return;
              }
              catch (NumberFormatException paramString)
              {
                QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _cwv param(" + str + ") error:" + paramString.getMessage());
                return;
              }
              localNumberFormatException1 = localNumberFormatException1;
              QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _wv param(" + str + ") error:" + localNumberFormatException1.getMessage());
            }
            localNumberFormatException2 = localNumberFormatException2;
            QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _fv param(" + str + ") error:" + localNumberFormatException2.getMessage());
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            for (;;)
            {
              QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _wwv param(" + str + ") error:" + localNumberFormatException3.getMessage());
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      sgg.a(1001, paramString3, this.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.p)) {
        this.jdField_a_of_type_Xmq.a(paramString1, 1, false);
      }
      for (;;)
      {
        bdes.a().a("", "", "", "1000", "101", "0", false);
        axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.q)) {
          this.jdField_a_of_type_Xmq.g();
        } else {
          this.jdField_a_of_type_Xmq.a(paramString1, 1, false);
        }
      }
      paramString3 = paramString2;
    }
  }
  
  public void a(xmq paramxmq)
  {
    if (paramxmq == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()));
      String str = this.jdField_e_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_e_of_type_JavaLangString;
      }
      sgg.a(str);
      this.jdField_a_of_type_Xmq = paramxmq;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_Adct.jdField_a_of_type_Long;
      a();
      c();
      if (this.jdField_a_of_type_Bbjq == null) {
        this.jdField_a_of_type_Bbjq = new bbjq(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_Bbjq.a(BaseApplicationImpl.getApplication().getString(2131719508));
      this.jdField_a_of_type_Bbjq.a(a());
      this.jdField_a_of_type_Bbjq.a(this);
      this.jdField_a_of_type_Bbjq.a(this);
      try
      {
        this.jdField_a_of_type_Bbjq.a();
        return;
      }
      catch (Exception paramxmq) {}
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramxmq);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_Xmq.a();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.b()))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xmq.c()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(nau.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public List<bbjs>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696696);
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130838754;
        ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject2).c = 2;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696709);
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130838755;
        ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject2).c = 3;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (bhvy.a()) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:kandian")) && (localObject1 != null))
      {
        localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
        if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
        {
          localObject2 = new bbjs();
          ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696710);
          ((bbjs)localObject2).jdField_b_of_type_Int = 2130838753;
          ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
          ((bbjs)localObject2).c = 13;
          ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList.add(localObject2);
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696716);
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130838758;
        ((bbjs)localObject2).c = 9;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696699);
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130838752;
        ((bbjs)localObject2).c = 10;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((this.g) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696713);
        ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130838757;
        ((bbjs)localObject2).c = 12;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696692);
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130842131;
        ((bbjs)localObject2).c = 5;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696693);
        ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130842127;
        ((bbjs)localObject2).c = 4;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
        bduf.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList);
      }
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
      {
        localObject2 = new bbjs();
        ((bbjs)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696707);
        ((bbjs)localObject2).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject2).jdField_b_of_type_Int = 2130843596;
        ((bbjs)localObject2).c = 20;
        ((bbjs)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      localObject2 = new ArrayList();
      Iterator localIterator;
      Object localObject3;
      bbjs localbbjs;
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (nnr)localIterator.next();
          localbbjs = new bbjs();
          switch (((nnr)localObject3).jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nnr)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695546);; localbbjs.jdField_a_of_type_JavaLangString = ((nnr)localObject3).jdField_a_of_type_JavaLangString)
            {
              localbbjs.jdField_b_of_type_Int = 2130842133;
              localbbjs.jdField_b_of_type_Boolean = true;
              localbbjs.c = 30;
              localbbjs.jdField_b_of_type_JavaLangString = "";
              ((ArrayList)localObject2).add(localbbjs);
              break;
            }
          case 2: 
            localObject3 = new bbjs();
            ((bbjs)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695607);
            ((bbjs)localObject3).jdField_b_of_type_Int = 2130842125;
            ((bbjs)localObject3).jdField_b_of_type_Boolean = true;
            ((bbjs)localObject3).c = 31;
            ((bbjs)localObject3).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject2).add(localObject3);
          }
        }
      }
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (nnr)localIterator.next();
          localbbjs = new bbjs();
          switch (((nnr)localObject3).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((nnr)localObject3).jdField_a_of_type_JavaLangString)) {}
            for (localbbjs.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131695546);; localbbjs.jdField_a_of_type_JavaLangString = ((nnr)localObject3).jdField_a_of_type_JavaLangString)
            {
              localbbjs.jdField_b_of_type_Int = 2130842133;
              localbbjs.jdField_b_of_type_Boolean = true;
              localbbjs.c = 37;
              localbbjs.jdField_b_of_type_JavaLangString = "";
              ((ArrayList)localObject2).add(localbbjs);
              break;
            }
          case 3: 
            localObject3 = new bbjs();
            ((bbjs)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696697);
            ((bbjs)localObject3).jdField_b_of_type_Int = 2130842134;
            ((bbjs)localObject3).jdField_b_of_type_Boolean = true;
            ((bbjs)localObject3).c = 35;
            ((bbjs)localObject3).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject2).add(localObject3);
          }
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
      {
        localObject1 = new bbjs();
        ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696682);
        ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject1).jdField_b_of_type_Int = 2130843388;
        ((bbjs)localObject1).c = 6;
        ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        localObject1 = new bbjs();
        ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696691);
        ((bbjs)localObject1).jdField_b_of_type_Int = 2130842129;
        ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject1).c = 7;
        ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
      {
        localObject1 = new bbjs();
        ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696688);
        ((bbjs)localObject1).jdField_b_of_type_Int = 2130838750;
        ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject1).c = 1;
        ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!sfk.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean))
      {
        localObject1 = new bbjs();
        ((bbjs)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131696694);
        ((bbjs)localObject1).jdField_b_of_type_Int = 2130842117;
        ((bbjs)localObject1).jdField_b_of_type_Boolean = true;
        ((bbjs)localObject1).c = 11;
        ((bbjs)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      return (List[])new ArrayList[] { localArrayList, localObject2 };
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131559045, null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -1, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131366557);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bfvi(ajya.a(2131702419), TypedValue.applyDimension(1, 15.0F, ajwc.a)));
    localArrayList.add(new bfvi(ajya.a(2131702423), TypedValue.applyDimension(1, 16.0F, ajwc.a)));
    localArrayList.add(new bfvi("", TypedValue.applyDimension(1, 17.0F, ajwc.a)));
    localArrayList.add(new bfvi("", TypedValue.applyDimension(1, 17.0F, ajwc.a)));
    localArrayList.add(new bfvi(ajya.a(2131702422), TypedValue.applyDimension(1, 18.0F, ajwc.a)));
    ((RangeButtonView)localObject).setTitleData(localArrayList);
    ((RangeButtonView)localObject).setOnChangerListener(this);
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    localArrayList = new ArrayList();
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691110));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691111));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691112));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691113));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131691114));
    ((RangeButtonView)localObject).setContentDescList(localArrayList);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentSmttSdkWebView, 83, 0, 0);
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    paramInt = jdField_a_of_type_ArrayOfInt[paramInt];
    this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings().setTextZoom(paramInt);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (((this.jdField_a_of_type_Long & 0x20000) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.D();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString.contains("sheet"))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a.h();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SwiftBrowserShareMenuHandler", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Bbjq.b();
    paramInt = ((bbjv)paramAdapterView).a.c;
    paramAdapterView = a();
    paramView = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      paramView.putString("qq", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_f_of_type_JavaLangString);
      paramView.putString("public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_JavaLangString);
      paramView.putString("source_public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.l);
      paramView.putString("default_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_JavaLangString);
      paramView.putString("msg_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.k);
      paramView.putString("troop_app_info_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.q);
      paramView.putString("troop_app_share_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.p);
      paramView.putInt("troop_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_Int);
      paramView.putInt("troop_app_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.i);
      paramView.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_h_of_type_Int);
    }
    a(paramInt, paramAdapterView, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcr
 * JD-Core Version:    0.7.0.1
 */