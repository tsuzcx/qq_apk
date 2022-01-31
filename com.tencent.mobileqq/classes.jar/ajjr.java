import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajjr
{
  private WeakReference<ajkc> jdField_a_of_type_JavaLangRefWeakReference;
  private final ConcurrentHashMap<String, ajjx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  ajjr(ajkc paramajkc)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajkc);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (!a())
    {
      paramajkc = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (paramajkc != null)
      {
        int i = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "new ApolloSSOConfig updateConfigsFromDb=false, checkUpdateApolloWebViewConfig");
        }
        a(this, paramajkc, i, true);
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static void a(ajjr paramajjr, AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramAppInterface == null) {}
    do
    {
      do
      {
        return;
        SharedPreferences localSharedPreferences = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
        int i = localSharedPreferences.getInt("sp_key_apollo_webView_config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "apollo_client checkUpdateApolloWebViewConfig, oldVersion" + i + ",version:" + paramInt);
        }
        Object localObject = new File(ajjc.a());
        boolean bool1 = paramBoolean;
        if (paramInt > 0)
        {
          bool1 = paramBoolean;
          if (!((File)localObject).exists()) {
            bool1 = true;
          }
        }
        localSharedPreferences.edit().putLong("sp_key_sso_check_time", System.currentTimeMillis()).commit();
        if ((!bool1) && (paramInt <= i)) {
          break;
        }
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ((File)localObject).getParentFile().mkdirs();
        localObject = new bbwu("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_thunder_config/xydata.json", (File)localObject);
        ((bbwu)localObject).p = true;
        ((bbwu)localObject).n = true;
        ((bbwu)localObject).f = "apollo_res";
        ((bbwu)localObject).b = 1;
        ((bbwu)localObject).q = true;
        ((bbwu)localObject).r = true;
        ((bbwu)localObject).a(new ajjt(localSharedPreferences, paramInt, paramajjr));
        paramajjr = (bbww)paramAppInterface.getManager(47);
        paramBoolean = bool2;
        if (paramajjr != null)
        {
          paramajjr = paramajjr.a(3);
          paramBoolean = bool2;
          if (paramajjr != null)
          {
            paramajjr.a((bbwu)localObject, ((bbwu)localObject).a(), null);
            paramBoolean = false;
          }
        }
        if (paramBoolean) {
          ThreadManager.executeOnNetWorkThread(new ApolloSSOConfig.3((bbwu)localObject));
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig async:" + paramBoolean);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig local config is new， not need to download");
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(ajjc.a());
    Object localObject2;
    int i;
    Object localObject4;
    int i1;
    int j;
    label244:
    Object localObject6;
    Object localObject5;
    Object localObject7;
    int i2;
    int k;
    label361:
    Object localObject8;
    String str1;
    String str2;
    if (((File)localObject1).exists())
    {
      try
      {
        localObject2 = ajjc.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!QLog.isColorLevel()) {
            break label1046;
          }
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, ApolloClientUtil.readFileSafety null");
          break label1046;
        }
        localObject1 = new JSONObject((String)localObject2).optJSONObject("data").optJSONArray("thunderConfig");
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, content:" + (String)localObject2);
        }
        if (localObject1 == null) {
          break label935;
        }
        int m = ((JSONArray)localObject1).length();
        i = 0;
        if (i >= m) {
          break label935;
        }
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject3 == null) {
          break label1048;
        }
        n = ((JSONObject)localObject3).optInt("pageId");
        localObject4 = ((JSONObject)localObject3).optString("md5");
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label1048;
        }
        localObject2 = new ajjx();
        ((ajjx)localObject2).jdField_a_of_type_Int = n;
        ((ajjx)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject4);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(n), localObject2);
        localObject4 = ((JSONObject)localObject3).optJSONArray("cmds");
        if (localObject4 == null) {
          break label543;
        }
        i1 = ((JSONArray)localObject4).length();
        j = 0;
        if (j >= i1) {
          break label543;
        }
        localObject6 = ((JSONArray)localObject4).optJSONObject(j);
        if (localObject6 == null) {
          break label1055;
        }
        localObject5 = ((JSONObject)localObject6).optString("name");
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          break label1055;
        }
        localObject7 = ((JSONObject)localObject6).optJSONArray("parameters");
        if (localObject7 == null) {
          break label1055;
        }
        i2 = ((JSONArray)localObject7).length();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, cmdName:" + (String)localObject5 + ",parameterLength:" + i2);
        }
        localObject6 = new ArrayList();
        k = 0;
        if (k < i2)
        {
          localObject8 = ((JSONArray)localObject7).optJSONObject(k);
          if (localObject8 == null) {
            break label1062;
          }
          str1 = ((JSONObject)localObject8).optString("key");
          if (TextUtils.isEmpty(str1)) {
            break label1062;
          }
          str2 = ((JSONObject)localObject8).optString("value");
          int i3 = ((JSONObject)localObject8).optInt("valueType");
          localObject8 = new ajjw(null);
          ((ajjw)localObject8).jdField_a_of_type_JavaLangString = str1;
          ((ajjw)localObject8).jdField_a_of_type_Int = i3;
          ((ajjw)localObject8).b = str2;
          ((List)localObject6).add(localObject8);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        QLog.e("apollo_client_ApolloSSOConfig", 1, localException.getMessage());
        return false;
      }
      localObject7 = new ajjv();
      ((ajjv)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject5);
      ((ajjv)localObject7).jdField_a_of_type_Int = n;
      ((ajjv)localObject7).jdField_a_of_type_JavaUtilList.addAll((Collection)localObject6);
      ((ajjx)localObject2).jdField_a_of_type_JavaUtilList.add(localObject7);
      break label1055;
      label543:
      Object localObject3 = ((JSONObject)localObject3).optJSONArray("cgis");
      if (localObject3 == null) {
        break label1048;
      }
      int n = ((JSONArray)localObject3).length();
      j = 0;
      label567:
      if (j >= n) {
        break label1048;
      }
      localObject5 = ((JSONArray)localObject3).optJSONObject(j);
      if (localObject5 == null) {
        break label1069;
      }
      str1 = ((JSONObject)localObject5).optString("url");
      if (TextUtils.isEmpty(str1)) {
        break label1069;
      }
      str2 = ((JSONObject)localObject5).optString("method");
      if (TextUtils.isEmpty(str2)) {
        break label1069;
      }
      localObject4 = new ajju();
      ((ajju)localObject4).jdField_a_of_type_JavaLangString = str1;
      ((ajju)localObject4).b = str2;
      localObject6 = ((JSONObject)localObject5).optJSONArray("parameters");
      if (localObject6 != null)
      {
        i1 = ((JSONArray)localObject6).length();
        localObject7 = new ArrayList();
        if (!QLog.isColorLevel()) {
          break label1076;
        }
        QLog.d("apollo_client_ApolloSSOConfig", 2, "updateConfigsFromDb cgis url:" + str1 + " method:" + str2 + " parameterLength:" + i1);
        break label1076;
      }
    }
    for (;;)
    {
      if (k < i1)
      {
        localObject8 = ((JSONArray)localObject6).optJSONObject(k);
        if (localObject8 != null)
        {
          str1 = ((JSONObject)localObject8).optString("key");
          if (!TextUtils.isEmpty(str1))
          {
            str2 = ((JSONObject)localObject8).optString("value");
            i2 = ((JSONObject)localObject8).optInt("valueType");
            localObject8 = new ajjw(null);
            ((ajjw)localObject8).jdField_a_of_type_JavaLangString = str1;
            ((ajjw)localObject8).jdField_a_of_type_Int = i2;
            ((ajjw)localObject8).b = str2;
            ((List)localObject7).add(localObject8);
          }
        }
      }
      else
      {
        ((ajju)localObject4).jdField_a_of_type_JavaUtilList.addAll((Collection)localObject7);
        localObject5 = ((JSONObject)localObject5).optJSONObject("headers");
        if (localObject5 != null)
        {
          localObject6 = ((JSONObject)localObject5).keys();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (String)((Iterator)localObject6).next();
            ((ajju)localObject4).jdField_a_of_type_JavaUtilHashMap.put(localObject7, ((JSONObject)localObject5).optString((String)localObject7));
          }
        }
        ((ajjx)localObject2).b.add(localObject4);
        break label1069;
        label935:
        if (QLog.isColorLevel())
        {
          i = BaseApplicationImpl.getContext().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mCurrentConfigVersion:").append(i).append("mThunderConfigs:").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
          QLog.d("apollo_client_ApolloSSOConfig", 2, localStringBuilder.toString());
        }
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "updateConfigsFromDb use:" + (System.currentTimeMillis() - l));
        }
        return false;
        label1046:
        return false;
        label1048:
        i += 1;
        break;
        label1055:
        j += 1;
        break label244;
        label1062:
        k += 1;
        break label361;
        label1069:
        j += 1;
        break label567;
        label1076:
        k = 0;
        continue;
      }
      k += 1;
    }
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (ajjx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public List<ajju> a(String paramString)
  {
    paramString = (ajjx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return null;
  }
  
  public Set<String> a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (ajjx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localObject != null)
      {
        paramString = new HashSet();
        localObject = ((ajjx)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ajjv localajjv = (ajjv)((Iterator)localObject).next();
          if ((localajjv != null) && (!TextUtils.isEmpty(localajjv.jdField_a_of_type_JavaLangString))) {
            paramString.add(localajjv.jdField_a_of_type_JavaLangString);
          }
        }
        return paramString;
      }
    }
    return null;
  }
  
  public JSONObject a(String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramAppInterface == null)) {
      return null;
    }
    paramString2 = (ajjx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
    if (paramString2 != null)
    {
      paramString2 = paramString2.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString2.hasNext())
      {
        ajjv localajjv = (ajjv)paramString2.next();
        if ((localajjv != null) && (paramString3.equals(localajjv.jdField_a_of_type_JavaLangString))) {
          return localajjv.a(paramString1, paramAppInterface);
        }
      }
    }
    return null;
  }
  
  void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    long l;
    do
    {
      return;
      localObject1 = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
      l = ((SharedPreferences)localObject1).getLong("sp_key_sso_check_time", 0L);
    } while (System.currentTimeMillis() - l <= 1800000L);
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject2 = paramAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.e("apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO account is null!");
      return;
    }
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.3.0.4480");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject2));
    int i = ((SharedPreferences)localObject1).getInt("sp_key_apollo_webView_config_version", 0);
    localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("apollo_thunder_json_v670");
    Object localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(205);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
    localObject1 = new NewIntent(paramAppInterface.getApp(), arpd.class);
    ((NewIntent)localObject1).putExtra("extra_cmd", "ClubContentUpdate.Req");
    ((NewIntent)localObject1).putExtra("extra_data", localReqBody.toByteArray());
    ((NewIntent)localObject1).putExtra("extra_callbackid", paramAppInterface.getCurrentAccountUin());
    ((NewIntent)localObject1).setObserver(new ajjs(this, paramAppInterface));
    paramAppInterface.startServlet((NewIntent)localObject1);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO local ver: " + i);
  }
  
  void a(AppInterface paramAppInterface, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramAppInterface == null) || (paramBundle == null)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        Object localObject;
        try
        {
          localObject = new ClubContentUpdateInfoPb.RspBody();
          ((ClubContentUpdateInfoPb.RspBody)localObject).mergeFrom(paramBundle.getByteArray("extra_data"));
          if (((ClubContentUpdateInfoPb.RspBody)localObject).int_result.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("apollo_client_ApolloSSOConfig", 2, "handleReceiveSSO, result=" + ((ClubContentUpdateInfoPb.RspBody)localObject).int_result.get());
            return;
          }
        }
        catch (Exception paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          return;
        }
        paramBundle = ((ArrayList)((ClubContentUpdateInfoPb.RspBody)localObject).rpt_msg_rspappinfo.get()).iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ClubContentUpdateInfoPb.RspAppInfo)paramBundle.next();
          if (localObject != null) {
            switch (((ClubContentUpdateInfoPb.RspAppInfo)localObject).uint_appid.get())
            {
            case 205: 
              if ((((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.has()) && (((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.size() > 0))
              {
                localObject = (ClubContentUpdateInfoPb.RspItemInfo)((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.get().get(0);
                String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
                int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
                String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
                int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
                if (1 == (j & 0x1)) {}
                for (paramBoolean = true;; paramBoolean = false)
                {
                  a(this, paramAppInterface, i, paramBoolean);
                  QLog.i("apollo_client_ApolloSSOConfig", 1, "handleApolloWebViewResponse apollo_client ApolloWebView Config json: " + str1 + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str2);
                  break;
                }
              }
              break;
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (ajjx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          ajjv localajjv = (ajjv)paramString1.next();
          if ((localajjv != null) && (paramString2.equals(localajjv.jdField_a_of_type_JavaLangString))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjr
 * JD-Core Version:    0.7.0.1
 */