import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.qwallet.PayInterceptHelper;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class abte
  implements Runnable
{
  public abte(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime();
    Object localObject1 = null;
    Object localObject3 = null;
    HashMap localHashMap = new HashMap(8);
    int m = SharedPreUtils.P(localQQAppInterface.getApp(), ConfigServlet.a);
    int i;
    int j;
    label127:
    Object localObject4;
    JSONObject localJSONObject;
    label332:
    Object localObject2;
    label439:
    Object localObject5;
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config != null) && (i != m))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, String.format("qwallet config update %s -> %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
        }
        if (i == m) {
          break label2065;
        }
        j = i;
        if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content_list is empty ,version: " + i);
          }
          return;
        }
        int n = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size();
        int k = 0;
        for (localObject1 = localObject3;; localObject1 = localObject4)
        {
          localObject3 = localObject1;
          if (k >= n) {
            break label1883;
          }
          localObject4 = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(k);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content: " + (String)localObject4 + ",version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break;
          }
          localObject4 = localObject1;
          k += 1;
        }
        localObject3 = localObject1;
        do
        {
          try
          {
            localJSONObject = new JSONObject((String)localObject4);
            localObject3 = localObject1;
            Iterator localIterator = localJSONObject.keys();
            for (;;)
            {
              localObject4 = localObject1;
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = localObject1;
              localObject4 = (String)localIterator.next();
              localObject3 = localObject1;
              if (!"hb_face".equals(localObject4)) {
                break label439;
              }
              localObject3 = localObject1;
              localObject4 = localJSONObject.optJSONObject((String)localObject4);
              localObject3 = localObject1;
              HbThemeConfigManager.a().a(localQQAppInterface, (JSONObject)localObject4);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException1)
          {
            localObject4 = localObject3;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException1);
          localObject4 = localObject3;
          break;
          localObject3 = localException1;
          if ("hb_normal".equals(localObject4))
          {
            localObject3 = localException1;
            localObject4 = localJSONObject.optJSONObject((String)localObject4);
            if (i <= j) {
              break label2062;
            }
            localObject2 = localObject4;
            break label2076;
          }
          localObject3 = localObject2;
          if (!"F2FRedpack".equals(localObject4)) {
            break label718;
          }
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
        } while (localObject4 == null);
        localObject3 = localObject2;
        localObject5 = ConfigServlet.a;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackEntry", 0) != 1) {
          break label2079;
        }
        bool = true;
        label538:
        localObject3 = localObject2;
        QWalletSetting.a((String)localObject5, "F2FRedpackEntry", bool);
        localObject3 = localObject2;
        localObject5 = ConfigServlet.a;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackQRCheck", 1) != 1) {
          break label2085;
        }
        bool = true;
        label579:
        localObject3 = localObject2;
        QWalletSetting.a((String)localObject5, "F2FRedpackQRCheck", bool);
        localObject3 = localObject2;
        localObject5 = ConfigServlet.a;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackGIF", 1) != 1) {
          break label2091;
        }
      }
    }
    label2062:
    label2065:
    label2076:
    label2079:
    label2085:
    label2091:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        localObject3 = localObject2;
        QWalletSetting.a((String)localObject5, "F2FRedpackGIF", bool);
        localObject3 = localObject2;
        long l1 = QWalletTools.b(((JSONObject)localObject4).optString("EntryColorBeginTime"));
        localObject3 = localObject2;
        long l2 = QWalletTools.b(((JSONObject)localObject4).optString("EntryColorEndTime"));
        if ((l1 < 0L) || (l2 < 0L)) {
          break label332;
        }
        localObject3 = localObject2;
        QWalletSetting.a(ConfigServlet.a, "F2FRedpack_EntryColorBeginTime", l1 / 1000L);
        localObject3 = localObject2;
        QWalletSetting.a(ConfigServlet.a, "F2FRedpack_EntryColorEndTime", l2 / 1000L);
        break label332;
        label718:
        localObject3 = localObject2;
        int i1;
        if ("preload_config".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label332;
          }
          localObject3 = localObject2;
          i1 = ((JSONObject)localObject4).optInt("deal_delay_interval", 0);
          localObject3 = localObject2;
          int i2 = ((JSONObject)localObject4).optInt("need_wait_size", 0);
          localObject3 = localObject2;
          ((PreloadManager)localQQAppInterface.getManager(150)).a(i1, i2);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "deal_delay_interval", i1);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "need_wait_size", i2);
          break label332;
        }
        localObject3 = localObject2;
        if ("skin_map".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONArray((String)localObject4);
          localObject3 = localObject2;
          QWalletSkinHandler.a(ConfigServlet.a, (JSONArray)localObject4);
          break label332;
        }
        localObject3 = localObject2;
        if ("skin_entry_error_tips".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.getString((String)localObject4);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "skin_entry_error_tips", (String)localObject4);
          break label332;
        }
        localObject3 = localObject2;
        if ("InterceptAppOpenConfig".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONArray((String)localObject4);
          localObject3 = localObject2;
          PayInterceptHelper.a().a((JSONArray)localObject4, ConfigServlet.a);
          break label332;
        }
        localObject3 = localObject2;
        if ("gold_msg_money".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label332;
          }
          localObject3 = localObject2;
          localObject5 = ((JSONObject)localObject4).optJSONArray("money_array");
          if (localObject5 != null)
          {
            localObject3 = localObject2;
            if (((JSONArray)localObject5).length() > 0)
            {
              localObject3 = localObject2;
              QWalletSetting.a(ConfigServlet.a, "money_array", ((JSONArray)localObject5).toString());
            }
          }
          localObject3 = localObject2;
          l1 = ((JSONObject)localObject4).optLong("money_max");
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "money_max", l1);
          break label332;
        }
        localObject3 = localObject2;
        if ("gold_msg_aio_animation".equals(localObject4))
        {
          localObject3 = localObject2;
          i1 = localJSONObject.optInt((String)localObject4, 1);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "GoldMsgAnim", i1);
          break label332;
        }
        localObject3 = localObject2;
        if ("gold_msg_record_pre".equals(localObject4))
        {
          localObject3 = localObject2;
          QWalletSetting.a("", "GoldMsgRecordPre", localJSONObject.optString((String)localObject4, ""));
          break label332;
        }
        localObject3 = localObject2;
        if ("strangerchat_ext".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optString((String)localObject4, "");
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label332;
          }
          localObject3 = localObject2;
          QWalletSetting.a("", "strangerchat_ext", Base64.encodeToString(((String)localObject4).getBytes(), 0));
          break label332;
        }
        localObject3 = localObject2;
        if ("gold_msg_group_record".equals(localObject4))
        {
          localObject3 = localObject2;
          QWalletSetting.a("", "GoldMsgGroupRecordPre", localJSONObject.optString((String)localObject4, ""));
          break label332;
        }
        localObject3 = localObject2;
        if ("gold_msg_troop_unitprice_max".equals(localObject4))
        {
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "goldmsg_troop_unitprice_max", localJSONObject.optLong((String)localObject4));
          break label332;
        }
        localObject3 = localObject2;
        if ("gold_msg_detail".equals(localObject4))
        {
          localObject3 = localObject2;
          QWalletSetting.a("", "GoldMsgRecordDetail", localJSONObject.optString((String)localObject4, ""));
          break label332;
        }
        localObject3 = localObject2;
        if ("RedpackPopWnd".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label332;
          }
          localObject3 = localObject2;
          i1 = ((JSONObject)localObject4).optInt("PopWndID");
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_id", ((JSONObject)localObject4).optInt("PopWndID"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_group_type_" + i1, ((JSONObject)localObject4).optString("GroupType"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_url_" + i1, ((JSONObject)localObject4).optString("URL"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_state_" + i1, ((JSONObject)localObject4).optString("RedpackState"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_freq_" + i1, ((JSONObject)localObject4).optInt("PopWndFreq"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_total_" + i1, ((JSONObject)localObject4).optInt("PopWndTotalCount"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_network_" + i1, ((JSONObject)localObject4).optString("PopWndNetworkType"));
          localObject3 = localObject2;
          l1 = QWalletTools.b(((JSONObject)localObject4).optString("PopWndBeginTime"));
          localObject3 = localObject2;
          l2 = QWalletTools.b(((JSONObject)localObject4).optString("PopWndEndTime"));
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_begin_time_" + i1, l1 / 1000L);
          localObject3 = localObject2;
          QWalletSetting.a(ConfigServlet.a, "redpack_popwnd_end_time_" + i1, l2 / 1000L);
          break label332;
        }
        localObject3 = localObject2;
        if ("image_urls".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        if ("hb_theme".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        if ("hb_theme_group".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        localHashMap.put(localObject4, localJSONObject.opt((String)localObject4));
        break label332;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG remote version: " + i + " | localVersion: " + m);
          localObject3 = localObject2;
        }
        try
        {
          label1883:
          if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config == null) || (i == m)) {
            break;
          }
          SharedPreUtils.r(localQQAppInterface.getApp(), ConfigServlet.a, i);
          localObject2 = new JSONObject();
          if (localObject3 != null) {
            ((JSONObject)localObject2).put("hb_normal", localObject3);
          }
          if (localHashMap.isEmpty()) {
            break label2024;
          }
          localObject3 = localHashMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            ((JSONObject)localObject2).put((String)((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue());
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException2) {}
      }
      QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException2);
      return;
      localHashMap.clear();
      label2024:
      localObject3 = HbThemeConfigManager.a();
      if (localException2.length() > 0) {}
      for (String str = localException2.toString();; str = "")
      {
        ((HbThemeConfigManager)localObject3).a(localQQAppInterface, str);
        return;
      }
      break label2076;
      j = m;
      break label127;
      i = 0;
      break;
      break label332;
      bool = false;
      break label538;
      bool = false;
      break label579;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abte
 * JD-Core Version:    0.7.0.1
 */