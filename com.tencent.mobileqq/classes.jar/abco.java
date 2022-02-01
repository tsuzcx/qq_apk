import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class abco
  implements BusinessObserver
{
  abco(abcm paramabcm, long paramLong, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2;
    for (;;)
    {
      long l1;
      try
      {
        paramInt = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        Object localObject1 = paramBundle.getString("extra_callbackid");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject2 = new JSONObject();
        long l2 = -1L;
        if (!paramBoolean) {
          break label1321;
        }
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        if (arrayOfByte == null) {
          break label1272;
        }
        localObject3 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom(arrayOfByte);
        l1 = l2;
        if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.has())
        {
          paramBundle = paramBundle.getString("extra_cmd");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, cmd=" + paramBundle);
          }
          l1 = l2;
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.delayms.has())
            {
              l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject3).comm.delayms.get()).longValue();
              if (l1 != 0L) {
                break label1197;
              }
              this.jdField_a_of_type_Abcm.e.put(paramBundle, Integer.valueOf(2147483647));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, delay=" + l1 + ", cmd:" + paramBundle);
              }
            }
            if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.packagesize.has())
            {
              l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject3).comm.packagesize.get()).longValue();
              this.jdField_a_of_type_Abcm.b.put(paramBundle, Long.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, pkgSize=" + l1);
              }
            }
            l1 = l2;
            if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.proctime.has())
            {
              l2 = ((WebSSOAgent.UniSsoServerRsp)localObject3).comm.proctime.get();
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, svrCostTime=" + l2);
                l1 = l2;
              }
            }
          }
        }
        ((JSONObject)localObject2).put("ssoRet", 0);
        if (!((WebSSOAgent.UniSsoServerRsp)localObject3).ret.has()) {
          break label1246;
        }
        l2 = ((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label1233;
        }
        if (l2 == 0L) {
          break label1218;
        }
        abcm.a(this.jdField_a_of_type_Abcm, this.jdField_a_of_type_JavaLangString, l2, paramInt);
        ((JSONObject)localObject2).put("businessRet", l2);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, biz ret code=" + l2);
        }
        if (!((WebSSOAgent.UniSsoServerRsp)localObject3).errmsg.has()) {
          break label1258;
        }
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject3).errmsg.get();
        ((JSONObject)localObject2).put("msg", paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, errmsg=" + paramBundle);
        }
        l2 = l1;
        if (((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.has())
        {
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get();
          ((JSONObject)localObject2).put("data", paramBundle);
          l2 = l1;
          if (QLog.isColorLevel())
          {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, rspData=" + paramBundle);
            l2 = l1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, callback Json string=" + ((JSONObject)localObject2).toString());
        }
        avqx.d = System.currentTimeMillis();
        l1 = avqx.d - avqx.jdField_a_of_type_Long;
        long l3 = avqx.b - avqx.jdField_a_of_type_Long;
        long l4 = avqx.c - avqx.b;
        long l5 = avqx.d - avqx.c;
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, total=" + l1 + ",pre=" + l3 + ",msf=" + l4 + ",after=" + l5);
        }
        paramBundle = new JSONObject();
        paramBundle.put("packTime", l3);
        paramBundle.put("SSONetworkTime", l4);
        paramBundle.put("unpackTime", l5);
        paramBundle.put("serverProcessTime", l2);
        ((JSONObject)localObject2).put("speedPoint", paramBundle);
        this.jdField_a_of_type_Abcm.callJs((String)localObject1, new String[] { ((JSONObject)localObject2).toString() });
        try
        {
          long l6 = ((JSONObject)localObject2).optLong("ssoRet", 0L);
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_FailCode", String.valueOf(l6));
          ((HashMap)localObject2).put("totalTime", l1 + "");
          ((HashMap)localObject2).put("packTime", l3 + "");
          ((HashMap)localObject2).put("SSONetworkTime", l4 + "");
          ((HashMap)localObject2).put("unpackTime", l5 + "");
          ((HashMap)localObject2).put("serverProcessTime", l2 + "");
          ((HashMap)localObject2).put("cmd", this.jdField_a_of_type_JavaLangString);
          localObject3 = this.jdField_a_of_type_Abcm.mRuntime.a().getCurrentAccountUin();
          localObject1 = "ssoWebView";
          paramBundle = (Bundle)localObject1;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramBundle = (Bundle)localObject1;
            if (this.jdField_a_of_type_JavaLangString.startsWith("apollo")) {
              paramBundle = "apolloSSOWebView";
            }
          }
          localObject1 = bctj.a(this.jdField_a_of_type_Abcm.mRuntime.a());
          if (0L != l6) {
            break;
          }
          paramBoolean = true;
          label1110:
          ((bctj)localObject1).a((String)localObject3, paramBundle, paramBoolean, l1, 0L, (HashMap)localObject2, "", false);
          return;
        }
        catch (Throwable paramBundle)
        {
          if (!QLog.isColorLevel()) {
            break label1510;
          }
        }
        QLog.e("SSOWebviewPlugin", 2, "report ssoWebView:  " + paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break label1510;
        }
      }
      QLog.e("SSOWebviewPlugin", 2, "uniAgent, onReceive, Exception: " + paramBundle);
      return;
      label1197:
      this.jdField_a_of_type_Abcm.e.put(paramBundle, Integer.valueOf((int)l1));
      continue;
      label1218:
      abcm.a(this.jdField_a_of_type_Abcm, this.jdField_a_of_type_JavaLangString, paramInt);
      continue;
      label1233:
      QLog.e("SSOWebviewPlugin_apollo_store_stability_", 1, "uniAgent, reportSSOReqRespWatch, cmd is empty");
      continue;
      label1246:
      ((JSONObject)localObject2).put("businessRet", 0);
      continue;
      label1258:
      ((JSONObject)localObject2).put("msg", "SSO发送成功");
      continue;
      label1272:
      if (QLog.isColorLevel()) {
        QLog.w("SSOWebviewPlugin", 2, "uniAgent, onReceive, ret success but no data");
      }
      ((JSONObject)localObject2).put("ssoRet", 255);
      ((JSONObject)localObject2).put("businessRet", 0);
      ((JSONObject)localObject2).put("msg", "SSO返回数据包为空");
      continue;
      label1321:
      Object localObject3 = paramBundle.getString("extra_cmd");
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        abcm.b(this.jdField_a_of_type_Abcm, (String)localObject3, paramInt);
      }
      paramInt = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel()) {
        QLog.d("SSOWebviewPlugin", 2, "uniAgent, msfResultCode=" + paramInt);
      }
      if (paramInt != 1001) {
        break label1511;
      }
      ((JSONObject)localObject2).put("ssoRet", 201);
      ((JSONObject)localObject2).put("businessRet", 0);
      ((JSONObject)localObject2).put("msg", anni.a(2131713031));
    }
    for (;;)
    {
      label1431:
      ((JSONObject)localObject2).put("ssoRet", 202);
      ((JSONObject)localObject2).put("businessRet", 0);
      ((JSONObject)localObject2).put("msg", anni.a(2131713037));
      break;
      label1510:
      label1511:
      do
      {
        ((JSONObject)localObject2).put("ssoRet", 255);
        ((JSONObject)localObject2).put("businessRet", 0);
        ((JSONObject)localObject2).put("msg", anni.a(2131713036));
        break;
        paramBoolean = false;
        break label1110;
        return;
        if (paramInt == 1002) {
          break label1431;
        }
      } while (paramInt != 1013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abco
 * JD-Core Version:    0.7.0.1
 */