import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbFullScreenVideoFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.js.SpringFestivalRedpacketJsPlugin.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ahhu
  extends VasWebviewJsPlugin
{
  private ahhy jdField_a_of_type_Ahhy;
  private alxg jdField_a_of_type_Alxg;
  private alxk jdField_a_of_type_Alxk;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayMap<String, ArrayList<String>> jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public ahhu()
  {
    this.mPluginNameSpace = "cj";
  }
  
  private void a()
  {
    this.jdField_a_of_type_Alxk = new ahhv(this);
    this.jdField_a_of_type_Alxg.a(this.jdField_a_of_type_Alxk);
  }
  
  private void a(String paramString, @Nullable Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get("getAvatarAndNickname") == null) || (((ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get("getAvatarAndNickname")).isEmpty()))
    {
      QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "uploadHeadToH5: invoked.  mUserHeaderCallbackFuncName: " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get("getAvatarAndNickname"));
      return;
    }
    ThreadManagerV2.excute(new SpringFestivalRedpacketJsPlugin.3(this, paramBitmap, paramString), 64, null, true);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "doCallback method: " + paramString1 + " json: " + paramString2);
    }
    Object localObject = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString1);
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b((String)((Iterator)localObject).next(), paramString2);
        if ((!paramString1.equals("openVideoPlayer")) || ((!bbjw.a(paramString2)) && (paramString2.contains("jump play")))) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  private boolean a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("servertime", NetConnInfoCenter.getServerTimeMillis());
      a("getServerTime", localJSONObject.toString());
      return true;
    }
    catch (Exception localException)
    {
      QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "handleJsRequest: invoked.  e: " + localException);
    }
    return true;
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (paramBitmap != this.jdField_a_of_type_Alxg.a);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.optString("uin");
      String str2 = paramString.optString("url");
      if ((bbjw.a(str1)) || (bbjw.a(str2)))
      {
        paramString = new JSONObject();
        paramString.put("retcode", 4);
        paramString.put("retmsg", "param error");
        a("openVideoPlayer", paramString.toString());
        return true;
      }
      c();
      SpringHbFullScreenVideoFragment.a(str1, str2, paramString.optInt("show_skip"), paramString.optInt("fade_in_out"), paramString.optString("bg_color"), paramString.optString("bg_img_url"));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "handleJsRequest: invoked.  e: " + paramString);
    }
    return true;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "[init]");
    }
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
        if (QLog.isColorLevel()) {
          QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "is QQAppInterface: " + (this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
        }
        this.jdField_a_of_type_AndroidContentContext = localActivity.getApplicationContext();
      }
    }
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Alxg.a();
    a();
    this.jdField_a_of_type_Ahhy = new ahhy(this, null);
    try
    {
      QIPCClientHelper.getInstance().callServer("SpringHbIPCModule", "GetEmergencyInfo", null, new ahhw(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringFestivalRedpacketJsPlugin", 2, "[init] getEmergencyInfo Throwable:" + localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private boolean b(String paramString)
  {
    Object localObject;
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("data");
      if (paramString != null)
      {
        localObject = paramString.optString("event");
        i = paramString.optInt("action");
        j = paramString.optInt("result");
        JSONObject localJSONObject = paramString.optJSONObject("params");
        paramString = null;
        if (localJSONObject != null)
        {
          paramString = new HashMap();
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            paramString.put(str, localJSONObject.optString(str));
          }
        }
      }
      else
      {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("springHb_SpringFestivalRedpacketJsPlugin", 1, "handleReportData  Exception" + paramString.getMessage());
    }
    ahih.a((String)localObject, i, j, paramString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i = -1;
      break label221;
      localObject = new JSONObject();
      ((JSONObject)localObject).put("retcode", i);
      ((JSONObject)localObject).put("retmsg", paramString);
      a("reportData", ((JSONObject)localObject).toString());
      return true;
    }
    label221:
    label235:
    for (;;)
    {
      paramString = "";
      break;
      for (;;)
      {
        if (i != 0) {
          break label235;
        }
        paramString = "success";
        break;
        i = 0;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("open_video_callback");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ahhy, localIntentFilter);
  }
  
  private void c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "parseCallback thread name: " + Thread.currentThread().getName());
    }
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.toLowerCase().indexOf("callback") < 0)) {
      return;
    }
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    try
    {
      localArrayList1.add(new JSONObject(paramString2).optString("callback"));
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString1, localArrayList1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean c(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramString = "";
      try
      {
        String str = akug.b();
        paramString = str;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
      localJSONObject.put("code", paramString);
      a("getCode", localJSONObject.toString());
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("springHb_SpringFestivalRedpacketJsPlugin", 1, "[handleGetCode]  Throwable" + paramString.getMessage());
    }
    return true;
  }
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Ahhy != null) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ahhy);
        this.jdField_b_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("uin");
        if (bbjw.a(paramString))
        {
          QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "handleJsRequest: invoked.  jsonUins: " + paramString);
          paramString = new JSONObject();
          paramString.put("avatar", "");
          paramString.put("nickname", "");
          a("getAvatarAndNickname", paramString.toString());
          return true;
        }
        if (((JSONObject)localObject).optInt("cache_only", 1) == 1)
        {
          bool1 = true;
          this.jdField_a_of_type_Boolean = bool1;
          bool1 = bool2;
          if (!this.jdField_a_of_type_Boolean) {
            bool1 = true;
          }
          localObject = this.jdField_a_of_type_Alxg.a(paramString, bool1);
          if (!a((Bitmap)localObject)) {
            break;
          }
          a(paramString, (Bitmap)localObject);
          return true;
        }
      }
      catch (Exception paramString)
      {
        QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "handleJsRequest: invoked.  e: " + paramString);
        return true;
      }
      boolean bool1 = false;
    }
    if (this.jdField_a_of_type_Boolean) {
      a(paramString, null);
    }
    return true;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int k;
    boolean bool;
    int i;
    if ((paramLong == 8589934595L) || (paramLong == 8589934612L))
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "[handleEvent] url=" + paramString + ",type=" + paramLong + ",info=" + paramMap + ",mActivityPrefix=" + this.jdField_a_of_type_JavaLangString + ",mEmerUrl=" + this.jdField_b_of_type_JavaLangString);
        }
        k = ((Integer)paramMap.get("errorCode")).intValue();
        if (paramLong != 8589934612L) {
          break label527;
        }
        localObject = (WebResourceRequest)paramMap.get("requestData");
        str1 = ((WebResourceRequest)localObject).getUrl().toString();
        bool = ((WebResourceRequest)localObject).isForMainFrame();
        if (!QLog.isColorLevel()) {
          break label533;
        }
        QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "[handleEvent] isMainFrame=" + bool + ",curUrl=" + str1);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str1;
        int j;
        label367:
        localThrowable.printStackTrace();
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "[handleEvent] curUrl=" + str1 + ",errCode=" + k);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(str1)) && (str1.startsWith(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, str1)))
      {
        j = 0;
        i = j;
        if (bbev.d(this.jdField_a_of_type_AndroidContentContext))
        {
          localObject = new HashMap();
          str1 = ahiy.c(str1);
          if (TextUtils.isEmpty(str1)) {
            break label544;
          }
          ((Map)localObject).put("ext1", str1);
          if (paramLong != 8589934595L) {
            break label457;
          }
          str1 = "1";
          ((Map)localObject).put("ext2", str1);
          ((Map)localObject).put("ext3", k + "");
          ahih.a(ahib.e, 1, 1, (Map)localObject, true);
          break label544;
        }
      }
    }
    for (;;)
    {
      label426:
      if (i != 0)
      {
        this.mRuntime.a().stopLoading();
        this.mRuntime.a().loadUrl(this.jdField_b_of_type_JavaLangString);
        return true;
        label457:
        str1 = "2";
        break label367;
      }
      label527:
      label533:
      label544:
      do
      {
        i = 0;
        break label426;
        do
        {
          i = j;
          if (paramLong != 8589934595L) {
            break label426;
          }
          if (k != -8)
          {
            i = 1;
            break label426;
          }
          i = 0;
          break label426;
          return super.handleEvent(paramString, paramLong, paramMap);
          String str2 = paramString;
          break;
          if (bool) {
            break;
          }
          str2 = null;
          break;
        } while (paramLong != 8589934612L);
      } while (k < 400);
      i = 1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramString2.equals("cj"))
    {
      if (paramVarArgs.length > 0) {
        c(paramString3, paramVarArgs[0]);
      }
      if (paramString3.equals("getAvatarAndNickname")) {
        return d(paramVarArgs[0]);
      }
      if (paramString3.equals("getServerTime")) {
        return a();
      }
      if (paramString3.equals("openVideoPlayer")) {
        return a(paramVarArgs[0]);
      }
      if (paramString3.equals("reportData")) {
        return b(paramVarArgs[0]);
      }
      if (paramString3.equals("getCode")) {
        return c(paramVarArgs[0]);
      }
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "[onDestroy]");
    }
    super.onDestroy();
    this.jdField_a_of_type_Alxg.b(this.jdField_a_of_type_Alxk);
    this.jdField_a_of_type_Alxg.b();
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = null;
    }
    d();
    ahhz.a();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringFestivalRedpacketJsPlugin", 2, "[onWebViewCreated]");
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhu
 * JD-Core Version:    0.7.0.1
 */