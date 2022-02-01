import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;
import tencent.im.qqwallet.QWalletPubAdReport.QueryRsp;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;
import tencent.im.qqwallet.QWalletPubAdReport.TerminalInfor;

public class ajvj
  implements Manager
{
  private volatile int jdField_a_of_type_Int;
  private volatile long jdField_a_of_type_Long;
  private abkq jdField_a_of_type_Abkq;
  private volatile GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private boolean jdField_a_of_type_Boolean;
  
  public ajvj(QQAppInterface paramQQAppInterface) {}
  
  private static qq_ad_get.QQAdGet a(long paramLong, String paramString, int paramInt)
  {
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.pos_id.set(paramString);
    localPositionInfo.ad_count.set(paramInt);
    paramString = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    paramString.deep_link_version.set(1);
    localPositionInfo.pos_ext.set(paramString);
    paramString = new qq_ad_get.QQAdGet.UserInfo();
    paramString.qq.set(paramLong);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add(localPositionInfo);
    localQQAdGet.user_info.set(paramString);
    return localQQAdGet;
  }
  
  @NotNull
  private QWalletPubAdReport.QueryReq a(String paramString, Context paramContext)
  {
    QWalletPubAdReport.QueryReq localQueryReq = new QWalletPubAdReport.QueryReq();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localQueryReq.uin.set(str);
    localQueryReq.pskey.set(paramString);
    localQueryReq.channel.set(1);
    localQueryReq.terminal_infor.set(a(paramContext));
    return localQueryReq;
  }
  
  @NotNull
  private QWalletPubAdReport.ReportReq a(String paramString, int paramInt, Context paramContext)
  {
    QWalletPubAdReport.ReportReq localReportReq = new QWalletPubAdReport.ReportReq();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localReportReq.uin.set(str);
    localReportReq.pskey.set(paramString);
    localReportReq.channel.set(1);
    localReportReq.ad_reslut.set(paramInt);
    localReportReq.terminal_infor.set(a(paramContext));
    return localReportReq;
  }
  
  @NotNull
  private QWalletPubAdReport.TerminalInfor a(Context paramContext)
  {
    QWalletPubAdReport.TerminalInfor localTerminalInfor = new QWalletPubAdReport.TerminalInfor();
    localTerminalInfor.model.set("android_mqq");
    localTerminalInfor.appid.set(AppSetting.a() + "");
    localTerminalInfor.qq_version.set("8.4.8");
    localTerminalInfor.device_name.set(Build.MODEL);
    localTerminalInfor.client_os.set(Build.VERSION.RELEASE + ",sdk" + Build.VERSION.SDK_INT);
    paramContext = localTerminalInfor.root_flag;
    if (QWalletHelper.isPhoneRooted()) {}
    for (int i = 1;; i = 0)
    {
      paramContext.set(i);
      try
      {
        String str = QWalletHelper.getQWDevId();
        paramContext = str;
        if (TextUtils.isEmpty(str))
        {
          str = QWalletHelper.getMacAddress();
          paramContext = str;
          if (TextUtils.isEmpty(str)) {
            paramContext = Settings.System.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
          }
        }
        localTerminalInfor.device_id.set(paramContext);
        return localTerminalInfor;
      }
      catch (Throwable paramContext)
      {
        QLog.e("QWalletGdtAdManager", 1, paramContext, new Object[0]);
      }
    }
    return localTerminalInfor;
  }
  
  private void a(abkp paramabkp)
  {
    if (QLog.isColorLevel())
    {
      if (paramabkp != null) {
        break label21;
      }
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,loader null");
    }
    label21:
    do
    {
      return;
      if (paramabkp.a() == null)
      {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,getSession null");
        return;
      }
      if (paramabkp.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
      {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,loader.getSession().response null");
        return;
      }
    } while (paramabkp.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get() == 0);
    QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,loader.getSession().response.ret.get " + paramabkp.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get());
  }
  
  private void a(Context paramContext, String paramString, int paramInt, abkq paramabkq)
  {
    abkr localabkr = new abkr();
    localabkr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin(), paramString, paramInt);
    new abkp(localabkr, new WeakReference(paramabkq)).a(new WeakReference(paramContext));
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "doReqAds start");
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.listAdapter != null)) {
      paramBaseChatPie.listAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    QQAppInterface localQQAppInterface = akgd.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "doReqAdsControl start");
    }
    bkvx.a(localQQAppInterface, "tenpay.com", new ajvl(this, paramBaseActivity, localQQAppInterface, NetConnInfoCenter.getServerTimeMillis()));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = akgd.a();
    if (localQQAppInterface == null) {
      return;
    }
    bcef.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForStructing paramMessageForStructing)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {
      try
      {
        localObject = new generalflags.ResvAttr();
        ((generalflags.ResvAttr)localObject).mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if ((((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.has()) && (((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get() != null))
        {
          paramGeneralFlags = ((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get().toStringUtf8().trim();
          if ((paramGeneralFlags.startsWith("{")) && (paramGeneralFlags.endsWith("}")))
          {
            paramGeneralFlags = new JSONObject(paramGeneralFlags).optString("money_extra");
            if ((!TextUtils.isEmpty(paramGeneralFlags)) && (new JSONObject(paramGeneralFlags).optInt("gdt_flg") == 1))
            {
              paramGeneralFlags = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getStructMsgItemLists();
              if ((paramGeneralFlags != null) && (paramGeneralFlags.size() > 0)) {
                localObject = paramGeneralFlags.iterator();
              }
            }
          }
        }
        while (((Iterator)localObject).hasNext()) {
          if (((bcgw)((Iterator)localObject).next() instanceof bckm))
          {
            ((Iterator)localObject).remove();
            continue;
            return;
          }
        }
      }
      catch (Throwable paramGeneralFlags)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletGdtAdManager", 2, "parse wallet ad tail fail:", paramGeneralFlags);
        }
      }
    }
    Object localObject = bchg.a(0);
    ((bcgx)localObject).a(new bcjb());
    ((bcgx)localObject).a = paramMessageForStructing.structingMsg;
    paramGeneralFlags.add(localObject);
    localObject = bchg.a(31);
    ((bcgx)localObject).a = paramMessageForStructing.structingMsg;
    paramGeneralFlags.add(localObject);
    paramMessageForStructing.saveExtInfoToExtStr("wallet_ad_msg", "1");
  }
  
  private void a(QWalletPubAdReport.QueryRsp paramQueryRsp)
  {
    int j = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_wallet_gdt", 4);
    int k = paramQueryRsp.pv_flag.get();
    int m = paramQueryRsp.uv_flag.get();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    long l;
    if (k == 1)
    {
      l = paramQueryRsp.pv_timestamp.get();
      localEditor.putLong("sp_key_pv_timestamp", l).apply();
      localEditor = ((SharedPreferences)localObject).edit();
      if (m != 1) {
        break label253;
      }
    }
    label253:
    for (int i = paramQueryRsp.uv_day_freq.get();; i = 0)
    {
      localEditor.putInt("sp_key_day_freq", i).apply();
      localObject = ((SharedPreferences)localObject).edit();
      i = j;
      if (m == 1) {
        i = paramQueryRsp.uv_week_freq.get();
      }
      ((SharedPreferences.Editor)localObject).putInt("sp_key_week_freq", i).apply();
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "saveUvControl...pv_flag:" + k + ",uv_flag:" + m + ",pv_timestamp:" + paramQueryRsp.pv_timestamp.get() + ",uv_day_freq:" + paramQueryRsp.uv_day_freq.get() + ",uv_week_freq:" + paramQueryRsp.uv_week_freq.get());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private void b(BaseActivity paramBaseActivity, BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = new ajvk(this, NetConnInfoCenter.getServerTimeMillis(), paramBaseChatPie);
    this.jdField_a_of_type_Abkq = paramBaseChatPie;
    a(paramBaseActivity, "6001902438716523", 1, paramBaseChatPie);
  }
  
  private boolean b()
  {
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      a("public.tailplace.show", "", "", "2", "");
    }
  }
  
  public GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  }
  
  public GdtAppReceiver a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(paramContext);
    }
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  public void a()
  {
    Iterator localIterator = bckm.b.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(paramContext);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
    this.jdField_a_of_type_Abkq = null;
    paramContext = bckm.b.iterator();
    while (paramContext.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramContext.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    bckm.b.clear();
    bckm.a = null;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    QQAppInterface localQQAppInterface = akgd.a();
    if (localQQAppInterface == null) {
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "doReqAdsStatistics start,adResult:" + paramInt);
    }
    SharedPreferences localSharedPreferences;
    Object localObject1;
    if (paramInt == 1)
    {
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_wallet_gdt", 4);
      localObject1 = localSharedPreferences.getString("sp_key_show_ad_times", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label226;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new JSONArray();
        }
        ((JSONArray)localObject3).put(l / 1000L);
        localSharedPreferences.edit().putString("sp_key_show_ad_times", ((JSONArray)localObject3).toString()).apply();
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "doReqAdsStatistics recordShowTimeString:" + ((JSONArray)localObject3).toString());
        }
        bkvx.a(localQQAppInterface, "tenpay.com", new ajvn(this, paramInt, paramContext, localQQAppInterface, l));
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QWalletGdtAdManager", 1, localThrowable, new Object[0]);
      }
      label226:
      Object localObject2 = null;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = null;
    this.jdField_a_of_type_Int = 0;
    if (a()) {}
    long l1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (b())
      {
        a(paramBaseActivity);
        b(paramBaseActivity, paramBaseChatPie);
        return;
      }
      l1 = NetConnInfoCenter.getServerTimeMillis();
      localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_wallet_gdt", 4);
      this.jdField_a_of_type_Long = (localSharedPreferences.getLong("sp_key_pv_timestamp", 0L) * 1000L);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...currentTime:" + l1 + ",mPvTimestamp:" + this.jdField_a_of_type_Long + ",mPvFlag:" + this.jdField_a_of_type_Int);
      }
      if (l1 >= this.jdField_a_of_type_Long) {
        break;
      }
      c();
    } while (!QLog.isColorLevel());
    QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...timeLimit,return");
    return;
    int i1 = localSharedPreferences.getInt("sp_key_day_freq", 0);
    int i = localSharedPreferences.getInt("sp_key_week_freq", 0);
    int n;
    if (i1 != 0)
    {
      n = i;
      if (i != 0) {}
    }
    else
    {
      localObject = (ajyg)paramBaseActivity.app.getManager(245);
      i1 = ((ajyg)localObject).a("common", 1, new String[] { "pub_ad_control", "gdt_day_freq" });
      n = ((ajyg)localObject).a("common", 4, new String[] { "pub_ad_control", "gdt_week_freq" });
    }
    int i2 = 0;
    int i5 = 0;
    int i4 = 0;
    int i6 = 0;
    int i7 = 0;
    int i3 = 0;
    Object localObject = localSharedPreferences.getString("sp_key_show_ad_times", "");
    int m = i7;
    i = i5;
    int j;
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      j = i6;
      k = i2;
    }
    for (;;)
    {
      JSONArray localJSONArray;
      try
      {
        localObject = new JSONArray((String)localObject);
        j = i6;
        k = i2;
        m = i7;
        i = i5;
        if (((JSONArray)localObject).length() > 0)
        {
          j = i6;
          k = i2;
          localJSONArray = new JSONArray();
          i2 = 0;
          i = i4;
          m = i3;
          j = m;
          k = i;
          if (i2 >= ((JSONArray)localObject).length()) {
            break label692;
          }
          j = m;
          k = i;
          long l2 = ((JSONArray)localObject).getLong(i2);
          long l3 = l1 - 1000L * l2;
          if (l3 < 604800000L)
          {
            i3 = m + 1;
            m = i;
            if (l3 < 86400000L) {
              m = i + 1;
            }
            j = i3;
            k = m;
            localJSONArray.put(l2);
            i4 = m;
          }
          else
          {
            j = m;
            k = i;
            i3 = m;
            i4 = i;
            if (QLog.isColorLevel())
            {
              j = m;
              k = i;
              QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...this time is over 1 week,just ignore,time:" + l2);
              i3 = m;
              i4 = i;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QWalletGdtAdManager", 1, localThrowable, new Object[0]);
        localSharedPreferences.edit().remove("sp_key_show_ad_times").apply();
        i = k;
        m = j;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...last24HourAdCount:" + i + ",gdt_day_freq:" + i1 + ",last7DayAdCount:" + m + ",gdt_week_freq:" + n);
        }
        if ((i < i1) && (m < n)) {
          break label727;
        }
        c();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...frequency limited,just return");
        return;
        label692:
        j = m;
        k = i;
        localSharedPreferences.edit().putString("sp_key_show_ad_times", localJSONArray.toString()).apply();
      }
      label727:
      a(paramBaseActivity);
      b(paramBaseActivity, paramBaseChatPie);
      return;
      i2 += 1;
      m = i3;
      i = i4;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 1, "reportUrlByHttpGet...reportUrl:" + paramString);
      }
      ThreadManager.executeOnNetWorkThread(new QWalletGdtAdManager.4(this, paramString));
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_Boolean = false;
    if (a()) {
      return;
    }
    int i = paramList.size() - 1;
    label22:
    ChatMessage localChatMessage;
    if (i >= 0)
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if ((this.jdField_a_of_type_Boolean) || (!(localChatMessage instanceof MessageForStructing)) || (!"1".equals(localChatMessage.getExtInfoFromExtStr("wallet_ad_msg")))) {
        break label140;
      }
      localChatMessage.isShowQWalletPubAd = true;
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletGdtAdManager", 2, "list,time:" + bfzl.b(localChatMessage.time * 1000L) + ",isShowQWalletPubAd:" + localChatMessage.isShowQWalletPubAd);
      }
      i -= 1;
      break label22;
      break;
      label140:
      localChatMessage.isShowQWalletPubAd = false;
    }
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = akgd.a();
    if (localQQAppInterface == null) {
      return true;
    }
    if (((ajyg)localQQAppInterface.getManager(245)).a("common", 0, new String[] { "pub_ad_control", "gdt_switch" }) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "isPubAdClosed..." + bool);
      }
      return bool;
    }
  }
  
  public void b()
  {
    Iterator localIterator = bckm.b.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityPause();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvj
 * JD-Core Version:    0.7.0.1
 */