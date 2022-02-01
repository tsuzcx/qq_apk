import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.widget.EllipseTextView;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ahcp
{
  static long jdField_a_of_type_Long;
  public static final String a;
  public static Map<String, MessageForQQWalletMsg> a;
  protected int a;
  ajxv jdField_a_of_type_Ajxv;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahcr(this);
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ahcs(this);
  final String jdField_b_of_type_JavaLangString = "pay";
  protected int c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ahct(this);
  final String jdField_c_of_type_JavaLangString = "red";
  protected int d;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new ahcu(this);
  private String jdField_d_of_type_JavaLangString;
  protected int e;
  private View.OnClickListener e;
  protected int f;
  private View.OnClickListener f;
  protected int g;
  private View.OnClickListener g;
  protected int h;
  private View.OnClickListener h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  
  static
  {
    jdField_a_of_type_JavaLangString = ahcp.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public ahcp(Context paramContext)
  {
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new ahcv(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new ahcw(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new ahcx(this);
    this.jdField_h_of_type_AndroidViewView$OnClickListener = new ahcy(this);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(15.0F * f1 + 0.5F));
    this.jdField_b_of_type_Int = ((int)(10.0F * f1 + 0.5F));
    this.jdField_g_of_type_Int = ((int)(8.0F * f1 + 0.5F));
    this.jdField_f_of_type_Int = ((int)(23.0F * f1 + 0.5F));
    this.jdField_h_of_type_Int = ((int)(40.0F * f1 + 0.5F));
    this.i = ((int)(90.0F * f1 + 0.5F));
    this.j = ((int)(17.0F * f1 + 0.5F));
    this.jdField_c_of_type_Int = ((int)(138.0F * f1 + 0.5F));
    this.jdField_d_of_type_Int = ((int)(115.0F * f1 + 0.5F));
    this.jdField_e_of_type_Int = ((int)(11.0F * f1 + 0.5F));
    this.k = ((int)(160.0F * f1 + 0.5F));
    this.l = ((int)(f1 * 240.0F + 0.5F));
  }
  
  private static int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.curType == 0) {
      return 1;
    }
    if (paramSessionInfo.curType == 3000) {
      return 2;
    }
    if (paramSessionInfo.curType == 1)
    {
      paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(60);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramSessionInfo.curFriendUin))) {
        return 6;
      }
      return 3;
    }
    if (paramSessionInfo.curType == 1000) {
      return 4;
    }
    if (paramSessionInfo.curType == 1004) {
      return 5;
    }
    if ((paramSessionInfo.curType == 1001) || (paramSessionInfo.curType == 10002) || (paramSessionInfo.curType == 10004)) {
      return 7;
    }
    return 0;
  }
  
  private Map<String, String> a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 12) && (this.jdField_d_of_type_JavaLangString != null))
    {
      localHashMap.put("pskey_type", "27");
      localHashMap.put("pskey", this.jdField_d_of_type_JavaLangString);
      localHashMap.put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "");
      localHashMap.put("recv_nickname", ContactUtils.getGrayBarShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      localHashMap.put("recv_group_type", a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo) + "");
      localHashMap.put("recv_group_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
    return localHashMap;
  }
  
  private boolean a(Context paramContext, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, String paramString1, String paramString2, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if (paramQQWalletBaseMsgElem != null) {}
    for (Object localObject1 = paramQQWalletBaseMsgElem.nativeAndroid; (paramContext == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (paramMessageForQQWalletMsg == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null); localObject1 = null) {
      return false;
    }
    localObject1 = ((String)localObject1).split("\\?");
    CharSequence localCharSequence = localObject1[0];
    if (TextUtils.isEmpty(localCharSequence)) {
      return false;
    }
    if (localObject1.length > 1) {
      localObject1 = paramMessageForQQWalletMsg.parseUrlParams(localObject1[1]);
    }
    while (localCharSequence.equals("pay"))
    {
      paramQQWalletBaseMsgElem = (String)((HashMap)localObject1).get("payData");
      paramString1 = (String)((HashMap)localObject1).get("reqCode");
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramQQWalletBaseMsgElem)))
      {
        return false;
        localObject1 = new HashMap();
      }
      else
      {
        paramString2 = new Bundle();
        paramString2.putString("json", paramQQWalletBaseMsgElem);
        paramString2.putString("callbackSn", "0");
        paramQQWalletBaseMsgElem = new Intent(paramContext, PayBridgeActivity.class);
        paramQQWalletBaseMsgElem.putExtras(paramString2);
        paramQQWalletBaseMsgElem.putExtra("pay_requestcode", Integer.valueOf(paramString1).intValue());
      }
    }
    label898:
    for (;;)
    {
      try
      {
        if (!(paramContext instanceof Activity)) {
          paramQQWalletBaseMsgElem.addFlags(268435456);
        }
        paramContext.startActivity(paramQQWalletBaseMsgElem);
        return true;
      }
      catch (Exception paramContext)
      {
        String str;
        Object localObject2;
        int m;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to startActivity : " + localCharSequence, paramContext);
        return false;
      }
      if (localCharSequence.equals("red"))
      {
        str = (String)((HashMap)localObject1).get("id");
        if (TextUtils.isEmpty(str)) {
          return false;
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (paramQQWalletBaseMsgElem != null)
        {
          localObject1 = localObject2;
          if (paramQQWalletBaseMsgElem.themeId > 1)
          {
            localObject1 = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(paramQQWalletBaseMsgElem.themeId);
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((akdf)localObject1).jdField_b_of_type_JavaLangString;
          }
        }
        localObject2 = akgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, paramMessageForQQWalletMsg.istroop);
        m = ((Bundle)localObject2).getInt("groupType");
        localObject2 = ((Bundle)localObject2).getString("name");
        paramQQWalletBaseMsgElem = akgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForQQWalletMsg, paramQQWalletBaseMsgElem, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, paramSessionInfo, m, (String)localObject2, str, paramString1, paramString2, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", (String)localObject1);
        paramString2 = (amuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
        if ((paramString2 == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid <= 0)) {}
      }
      try
      {
        paramString1 = paramQQWalletBaseMsgElem.getJSONObject("extra_data");
        paramString2 = paramString2.a(String.valueOf(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid), paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName);
        if (QLog.isColorLevel()) {
          QLog.d("vipBgImage", 2, paramString2);
        }
        paramString1.put("vipBgImage", paramString2);
      }
      catch (Exception paramString1)
      {
        continue;
      }
      paramString1 = new Bundle();
      paramString1.putString("json", paramQQWalletBaseMsgElem.toString());
      paramString1.putString("callbackSn", "0");
      if (localObject1 != null) {
        paramString1.putString("cftImageUrl", (String)localObject1);
      }
      paramQQWalletBaseMsgElem = str;
      if (str != null)
      {
        paramQQWalletBaseMsgElem = str;
        if (str.length() > 4) {
          paramQQWalletBaseMsgElem = "****" + str.substring(4);
        }
      }
      paramString1.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "graphb", "open", "groupType=" + m + "&msgType=" + paramMessageForQQWalletMsg.messageType + "&redId=" + paramQQWalletBaseMsgElem, 0, null));
      paramQQWalletBaseMsgElem = new Intent(paramContext, PayBridgeActivity.class);
      paramQQWalletBaseMsgElem.putExtras(paramString1);
      paramQQWalletBaseMsgElem.putExtra("pay_requestcode", 5);
      continue;
      localObject1 = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + paramQQWalletBaseMsgElem.themeId + "_bg";
      continue;
      try
      {
        paramQQWalletBaseMsgElem = agly.class.getClassLoader();
        if (paramQQWalletBaseMsgElem == null) {
          return false;
        }
        paramQQWalletBaseMsgElem = paramQQWalletBaseMsgElem.loadClass(localCharSequence);
      }
      catch (Exception paramQQWalletBaseMsgElem)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramQQWalletBaseMsgElem.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to find Class : " + localCharSequence, paramQQWalletBaseMsgElem);
        paramQQWalletBaseMsgElem = null;
        continue;
        paramQQWalletBaseMsgElem = new Intent(paramContext, paramQQWalletBaseMsgElem);
        paramString1 = ((HashMap)localObject1).entrySet().iterator();
        if (!paramString1.hasNext()) {
          break label898;
        }
      }
      if (paramQQWalletBaseMsgElem == null) {
        return false;
      }
      paramString2 = (Map.Entry)paramString1.next();
      paramQQWalletBaseMsgElem.putExtra((String)paramString2.getKey(), (String)paramString2.getValue());
    }
  }
  
  public RelativeLayout a(ahcz paramahcz, Context paramContext)
  {
    if ((paramahcz == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout = b(paramahcz, paramContext);
    TextView localTextView = a(paramContext);
    localRelativeLayout.addView(localTextView);
    paramahcz.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    paramContext = a(paramContext);
    localRelativeLayout.addView(paramContext);
    paramahcz.f = paramContext;
    return localRelativeLayout;
  }
  
  public RelativeLayout a(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131374668);
    localLayoutParams.addRule(1, 2131374668);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.jdField_f_of_type_Int);
    localLayoutParams.topMargin = this.jdField_g_of_type_Int;
    localLayoutParams.bottomMargin = this.jdField_a_of_type_Int;
    localLayoutParams.addRule(3, 2131374668);
    localLayoutParams.addRule(5, 2131374668);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setMaxWidth(this.k);
    paramContext.setTextColor(-8947849);
    paramContext.setBackgroundResource(2130847135);
    paramContext.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setSingleLine();
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131374669);
    return paramContext;
  }
  
  public void a(ajxv paramajxv)
  {
    this.jdField_a_of_type_Ajxv = paramajxv;
  }
  
  public void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    paramRelativeLayout.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
    paramRelativeLayout.setContentDescription(paramString);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRelativeLayout == null) {}
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
      paramBaseChatPie = (MessageForQQWalletMsg)paramRelativeLayout.getTag();
    } while (paramBaseChatPie == null);
    bkvx.a(paramQQAppInterface, "tenpay.com", new ahcq(this));
    jdField_a_of_type_JavaUtilMap.put(paramBaseChatPie.mQQWalletRedPacketMsg.redPacketId, paramBaseChatPie);
    QLog.i(jdField_a_of_type_JavaLangString, 2, "CFT-debug redType = " + paramInt1);
    int m = paramInt1;
    if (paramInt1 == 4)
    {
      m = paramInt1;
      if (paramInt2 > 0) {
        m = 0;
      }
    }
    paramRelativeLayout.setTag(2131378178, Integer.valueOf(m));
    if (m == 1)
    {
      paramRelativeLayout.setContentDescription(amtj.a(2131710288) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710284));
      paramRelativeLayout.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      return true;
      if (m == 2)
      {
        paramRelativeLayout.setContentDescription(amtj.a(2131710279) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710295));
        paramRelativeLayout.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 8)
      {
        paramRelativeLayout.setContentDescription("K歌红包:" + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710291));
        paramRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 9)
      {
        paramRelativeLayout.setContentDescription(amtj.a(2131710273) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710289));
        paramRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 10)
      {
        paramRelativeLayout.setContentDescription(amtj.a(2131710274) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710278));
        paramRelativeLayout.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 11)
      {
        paramRelativeLayout.setContentDescription(amtj.a(2131710292) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710281));
        paramRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 14)
      {
        paramRelativeLayout.setContentDescription(amtj.a(2131710297) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + amtj.a(2131710298));
        paramRelativeLayout.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        paramRelativeLayout.setContentDescription(paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + paramString);
        paramRelativeLayout.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  public RelativeLayout b(ahcz paramahcz, Context paramContext)
  {
    if ((paramahcz == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    localRelativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localRelativeLayout1.setId(2131374650);
    paramahcz.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout1;
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.k, this.l);
    localRelativeLayout2.setId(2131374668);
    localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RoundImageView(paramContext);
    localRelativeLayout2.addView((View)localObject1);
    ((RoundImageView)localObject1).getLayoutParams().width = this.k;
    ((RoundImageView)localObject1).getLayoutParams().height = this.l;
    paramahcz.c = localRelativeLayout2;
    localObject1 = new RelativeLayout(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.k, this.l);
    ((RelativeLayout)localObject1).setBackgroundResource(2130847202);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setVisibility(8);
    paramahcz.d = ((RelativeLayout)localObject1);
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setId(2131374761);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.topMargin = this.jdField_h_of_type_Int;
    localLayoutParams1.addRule(10);
    localLayoutParams1.addRule(14);
    ((LinearLayout)localObject2).setLayoutParams(localLayoutParams1);
    ((LinearLayout)localObject2).setVisibility(8);
    paramahcz.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject2);
    RelativeLayout localRelativeLayout3 = new RelativeLayout(paramContext);
    localRelativeLayout3.setId(2131374674);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(10);
    localLayoutParams2.addRule(14);
    localLayoutParams2.topMargin = this.i;
    localLayoutParams2.leftMargin = this.j;
    localLayoutParams2.rightMargin = this.j;
    localRelativeLayout3.setLayoutParams(localLayoutParams2);
    Object localObject3 = new EllipseTextView(paramContext);
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13);
    ((TextView)localObject3).setTextSize(18.0F);
    ((TextView)localObject3).setTextColor(Color.parseColor("#FBD49D"));
    ((TextView)localObject3).setLineSpacing(0.0F, 1.1F);
    ((TextView)localObject3).setId(2131374661);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((TextView)localObject3).setGravity(17);
    localRelativeLayout3.addView((View)localObject3);
    paramahcz.e = localRelativeLayout3;
    paramahcz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
    localObject4 = new ImageView(paramContext);
    ((ImageView)localObject4).setId(2131374670);
    ((ImageView)localObject4).setVisibility(8);
    ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    localLayoutParams3.setMargins(this.jdField_e_of_type_Int, 0, this.jdField_e_of_type_Int, 0);
    localLayoutParams3.addRule(12);
    paramahcz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
    RelativeLayout localRelativeLayout4 = new RelativeLayout(paramContext);
    localRelativeLayout4.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
    paramahcz.g = localRelativeLayout4;
    localObject3 = new AnimationView(paramContext);
    ((AnimationView)localObject3).setPlayer(new ahda((AnimationView)localObject3));
    ((AnimationView)localObject3).setId(2131374660);
    ((AnimationView)localObject3).setVisibility(8);
    ((AnimationView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(this.k, this.l);
    localLayoutParams5.addRule(14);
    localLayoutParams5.addRule(12);
    paramahcz.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)localObject3);
    localRelativeLayout2.addView((View)localObject4, localLayoutParams3);
    localRelativeLayout2.addView((View)localObject3, localLayoutParams5);
    localRelativeLayout2.addView(localRelativeLayout4, localLayoutParams4);
    localRelativeLayout2.addView(localRelativeLayout3, localLayoutParams2);
    localRelativeLayout2.addView((View)localObject2, localLayoutParams1);
    localRelativeLayout1.addView(localRelativeLayout2);
    localRelativeLayout1.addView((View)localObject1);
    paramContext = new AnimationView(paramContext);
    paramContext.setPlayer(new ahda((AnimationView)localObject3));
    paramContext.setId(2131374679);
    paramContext.setVisibility(8);
    paramahcz.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView = paramContext;
    return localRelativeLayout1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcp
 * JD-Core Version:    0.7.0.1
 */