import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShareQzoneInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_COMM.COMM.Entry;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper.4;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aapa
{
  public static String a;
  private aagc jdField_a_of_type_Aagc;
  private aaou jdField_a_of_type_Aaou;
  public Activity a;
  private aqre jdField_a_of_type_Aqre;
  private bjbs jdField_a_of_type_Bjbs;
  private bjig jdField_a_of_type_Bjig;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  public boolean a;
  private String b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "certified_account=1";
  }
  
  public aapa(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  public aapa(Activity paramActivity, aapf paramaapf)
  {
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowShopConfigEntrance", "0")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
      ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
      localParam.context = paramActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new aapb(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new aapc(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new aapg(this, paramaapf));
      if (this.jdField_a_of_type_Aaou == null) {
        this.jdField_a_of_type_Aaou = new aaou(this.jdField_a_of_type_AndroidAppActivity);
      }
      return;
    }
  }
  
  private Intent a()
  {
    if ((this.jdField_a_of_type_Aagc == null) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get()))) {
      return null;
    }
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.putExtra("isWebCompShare", true);
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", this.jdField_a_of_type_AndroidAppActivity.getString(2131694697));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", this.jdField_a_of_type_Aagc.b());
    localIntent.putExtra("title", this.jdField_a_of_type_Aagc.f());
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131695740, new Object[] { this.jdField_a_of_type_Aagc.f() }));
    localIntent.putExtra("desc", a(this.jdField_a_of_type_Aagc.g()));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
    localIntent.putExtra("pluginName", "public_account");
    localIntent.putExtra("pubUin", this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
    localIntent.putExtra("image_url_remote", this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get());
    localIntent.putExtra("struct_share_key_content_action_DATA", a(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()));
    AbsStructMsg localAbsStructMsg = bdow.a(localIntent.getExtras());
    if (localAbsStructMsg != null)
    {
      localAbsStructMsg.mMsgServiceID = 152;
      localIntent.putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
      localIntent.putExtra("from_card", true);
      return localIntent;
    }
    return null;
  }
  
  public static String a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return "mqqapi://qsubscribe" + "/" + "opendetail" + "?" + "src_type=internal" + "&version=1" + "&uin=" + paramStFeed.poster.id.get() + "&feedId=" + paramStFeed.id.get() + "&type=" + paramStFeed.type.get() + "&width=" + paramStFeed.video.width.get() + "&height=" + paramStFeed.video.height.get() + "&createtime=" + paramStFeed.createTime.get();
  }
  
  private static String a(CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramExtraTypeInfo != null) && (paramExtraTypeInfo.pageType == 7002)) {
      return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&usertype=%s", new Object[] { paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
    }
    return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&userid=%s&usertype=%s", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
  }
  
  public static String a(aagc paramaagc)
  {
    if (paramaagc != null)
    {
      String str = paramaagc.d();
      Object localObject = str;
      if (paramaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
        if (paramaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7002)
        {
          localObject = str;
          if (paramaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7005) {}
        }
        else
        {
          paramaagc = paramaagc.a().poster.desc.get();
          if ((!TextUtils.isEmpty(paramaagc)) && (!paramaagc.equals(anzj.a(2131718461))))
          {
            localObject = paramaagc;
            if (!TextUtils.isEmpty(paramaagc.trim())) {}
          }
          else
          {
            localObject = anzj.a(2131718460);
          }
        }
      }
      return localObject;
    }
    return "";
  }
  
  public static String a(ExtraTypeInfo paramExtraTypeInfo)
  {
    if (paramExtraTypeInfo == null) {
      return "";
    }
    switch (paramExtraTypeInfo.pageType)
    {
    default: 
      return "";
    case 7002: 
      return "person";
    case 7000: 
      return "video";
    case 8001: 
      return "image";
    }
    return "multi_pic";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.length() > 30) {
        break;
      }
      str = paramString;
    } while (paramString.getBytes().length <= 100);
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    paramString = str;
    if (Math.min(str.getBytes().length, 100) == 100)
    {
      int i = str.length() / 2;
      paramString = new StringBuilder(str.substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(str.charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString + "...";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return "mqqapi://qsubscribe" + "/" + "openhomepage" + "?" + "src_type=internal" + "&version=1" + "&uid=" + paramString1 + "&nick=" + paramString2 + "&icon=" + paramString3;
  }
  
  private List<Integer> a(aagc paramaagc)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    int i = paramaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
    if ((i == 7000) || (i == 8001)) {
      localArrayList.add(Integer.valueOf(6));
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aagc == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Aagc.b();
    String str1 = a(this.jdField_a_of_type_Aagc.c());
    String str2 = a(this.jdField_a_of_type_Aagc.d());
    HashMap localHashMap = new HashMap(1);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, anzj.a(2131713442), 0).a();
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131719399;
    }
    for (;;)
    {
      if (i != -1)
      {
        zyx.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131719400;
        }
      }
      else
      {
        f();
        localObject = new SubscribeShareHelper.4(this, localHashMap, str1, str2, (String)localObject, paramInt);
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aagc.e()))
        {
          ((Runnable)localObject).run();
          return;
        }
        a(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bjbs.c(2131693490);
        this.jdField_a_of_type_Bjbs.show();
        ThreadManager.post(new SubscribeShareHelper.5(this, localHashMap, (Runnable)localObject), 8, null, false);
        return;
      }
      i = -1;
    }
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramStFeed != null) && (!bhsr.a(paramStFeed.poster.id.get())) && (!bhsr.a(paramStFeed.id.get())) && (paramExtraTypeInfo != null)) {
      abbe.a(paramStFeed.poster.id.get(), "auth_share", "clk_" + a(paramExtraTypeInfo), paramInt, 0, new String[] { "", "", paramStFeed.id.get() });
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(paramActivity);
    }
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    if ((this.jdField_a_of_type_Aagc != null) && (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (a()) && ((this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7000) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7001) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001))) {
      paramArrayList.add(Integer.valueOf(40));
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Aagc == null) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
      return false;
    }
    return aaek.a(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get());
  }
  
  @NotNull
  private List[] a(aagc paramaagc)
  {
    List localList = a(paramaagc);
    paramaagc = b(paramaagc);
    if ((((String)abac.a().a("is_open_sharing", "1")).equals("1")) && (this.jdField_a_of_type_Aagc != null) && (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (aaek.a(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.status.get()))) {}
    for (int i = 1; i != 0; i = 0) {
      return new List[] { localList, paramaagc };
    }
    return new List[] { paramaagc };
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(List<Integer>[] paramArrayOfList)
  {
    List[] arrayOfList = new List[paramArrayOfList.length];
    int i = 0;
    while (i < paramArrayOfList.length)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer)localIterator.next()).intValue()));
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  private Intent b()
  {
    if ((this.jdField_a_of_type_Aagc == null) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareCardInfo.get()))) {
      return null;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareCardInfo.get());
      Object localObject = localJSONObject.getJSONObject("aio");
      localJSONObject = localJSONObject.getJSONObject("popUp");
      String str1 = ((JSONObject)localObject).getString("app");
      String str2 = ((JSONObject)localObject).getString("ver");
      String str3 = ((JSONObject)localObject).getString("view");
      String str4 = ((JSONObject)localObject).getString("meta");
      localObject = ((JSONObject)localObject).getString("prompt");
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", str1);
      localIntent.putExtra("forward_ark_app_view", str3);
      localIntent.putExtra("forward_ark_app_ver", str2);
      localIntent.putExtra("forward_ark_app_prompt", (String)localObject);
      localIntent.putExtra("forward_ark_app_meta", str4);
      localObject = localJSONObject.getString("app");
      str1 = localJSONObject.getString("ver");
      str2 = localJSONObject.getString("view");
      str3 = localJSONObject.getString("meta");
      localJSONObject.getString("prompt");
      localIntent.putExtras(bhow.a((String)localObject, str2, str1, str3, aqbx.a(), null, null));
      return localIntent;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static String b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return b(paramStFeed.poster.id.get());
  }
  
  public static String b(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/homepage/%s?_proxy=1&_wv=16777217&_wwv=4", new Object[] { paramString });
  }
  
  private List<Integer> b(aagc paramaagc)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((paramaagc != null) && (paramaagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (paramaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      paramaagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.type.get();
      i = paramaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_Aqre != null) && (this.jdField_a_of_type_Aqre.a()))
      {
        if (!this.jdField_a_of_type_Aqre.c()) {
          break label404;
        }
        localArrayList.add(Integer.valueOf(82));
      }
      a(localArrayList);
      if (i != 7002) {
        break label438;
      }
      if (!a()) {
        break label418;
      }
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_mainhp");
      if (b())
      {
        localArrayList.add(Integer.valueOf(155));
        abbe.b(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_shoplist", 0, 0, new String[0]);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList.add(Integer.valueOf(157));
        if ((this.jdField_a_of_type_Aagc != null) && (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
          abbe.a(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_shop", 0, 0, new String[0]);
        }
      }
    }
    for (;;)
    {
      if ((paramaagc.jdField_a_of_type_Boolean) && (!a())) {
        localArrayList.add(Integer.valueOf(11));
      }
      int j = QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntrance", 1);
      if ((i == 7002) && (a()) && (j == 1)) {
        localArrayList.add(Integer.valueOf(152));
      }
      if ((i == 7002) && (paramaagc.b)) {
        localArrayList.add(Integer.valueOf(154));
      }
      if (this.jdField_a_of_type_Aagc.c)
      {
        i = this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
        if ((i == 7001) || (i == 7002) || (i == 7005) || (i == 7000)) {
          localArrayList.add(Integer.valueOf(153));
        }
      }
      return localArrayList;
      label404:
      localArrayList.add(Integer.valueOf(70));
      break;
      label418:
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guesthp");
      continue;
      label438:
      if (a()) {
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_main");
      } else {
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guest");
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Aagc == null) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
      return false;
    }
    return aaek.d(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get());
  }
  
  public static String c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/imagedetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Aagc == null) || (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
      return;
    }
    SubscribeDeleteFeedRequest localSubscribeDeleteFeedRequest = new SubscribeDeleteFeedRequest(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    VSNetworkHelper.a().a(localSubscribeDeleteFeedRequest, new aapd(this));
    try
    {
      abbe.a(this.jdField_a_of_type_Aagc.a(), "auth_share", "delete", 0, 0, new String[] { "", "", ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.get()).nick.get(), this.jdField_a_of_type_Aagc.c() });
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/carousel/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void d()
  {
    String str2;
    String str3;
    String str4;
    String str1;
    if ((this.jdField_a_of_type_Aagc != null) && (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      str2 = this.jdField_a_of_type_Aagc.c();
      this.jdField_a_of_type_Aagc.d();
      str3 = this.jdField_a_of_type_Aagc.e();
      str4 = this.jdField_a_of_type_Aagc.a();
      switch (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      default: 
        str1 = null;
      }
    }
    for (;;)
    {
      String str5 = this.jdField_a_of_type_Aagc.f();
      bmko.a(3, str2, str1, null, null, str3, null, null, false, -1L).c(str4).a("lCategory", 10L).b("sUin", str5).b("sName", str5).c(this.jdField_a_of_type_AndroidAppActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 2, null);
      return;
      str1 = a(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      continue;
      str1 = this.jdField_a_of_type_Aagc.b();
    }
  }
  
  public static String e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/videodetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void e()
  {
    aaej.a(a(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bjig != null) {
      return;
    }
    this.jdField_a_of_type_Bjig = new aape(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bjig);
  }
  
  private void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.jdField_a_of_type_Aagc.c());
    localBundle.putString("desc", a(this.jdField_a_of_type_Aagc));
    localBundle.putString("detail_url", this.jdField_a_of_type_Aagc.b() + "&source=qzone");
    Object localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(this.jdField_a_of_type_Aagc.e());
    localBundle.putStringArrayList("image_url", (ArrayList)localObject1);
    localBundle.putLong("req_share_id", 0L);
    if (this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null)
    {
      Object localObject2 = this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareQzoneInfo.entrys.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new SerializableMap();
        HashMap localHashMap = new HashMap();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          COMM.Entry localEntry = (COMM.Entry)((Iterator)localObject2).next();
          localHashMap.put(localEntry.key.get(), localEntry.value.get());
        }
        ((SerializableMap)localObject1).setMap(localHashMap);
      }
    }
    for (;;)
    {
      localBundle.putSerializable("share_qzone_info", (Serializable)localObject1);
      bmud.a(String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()), this.jdField_a_of_type_AndroidAppActivity, localBundle, null, -1);
      return;
      localObject1 = null;
    }
  }
  
  private void h()
  {
    int i = 21;
    if (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {}
    Intent localIntent;
    switch (this.jdField_a_of_type_Aagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    default: 
      localIntent = null;
      if (localIntent == null) {
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131713445), 0).a();
        }
      }
      break;
    }
    while ((localIntent == null) || (this.jdField_a_of_type_AndroidAppActivity == null))
    {
      return;
      localIntent = b();
      break;
      localIntent = b();
      i = 1;
      break;
      localIntent = a();
      i = 1;
      break;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, i);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    WXShareHelper.a().b(this.jdField_a_of_type_Bjig);
    if (this.jdField_a_of_type_Aaou != null) {
      this.jdField_a_of_type_Aaou.a();
    }
  }
  
  public void a(aagc paramaagc, aqre paramaqre)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null) {
      return;
    }
    aagc localaagc = paramaagc;
    if (paramaagc == null) {
      localaagc = new aagc();
    }
    this.jdField_a_of_type_Aagc = localaagc;
    this.jdField_a_of_type_Aqre = paramaqre;
    if ((this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get())))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131713456), 0).a();
      return;
    }
    paramaagc = a(localaagc);
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(a(paramaagc));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    aaak.a().a(new SharePanelShowStateEvent(true));
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapa
 * JD-Core Version:    0.7.0.1
 */