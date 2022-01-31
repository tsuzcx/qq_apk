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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class aead
{
  static long jdField_a_of_type_Long;
  public static final String a;
  public static Map<String, MessageForQQWalletMsg> a;
  protected int a;
  agmg jdField_a_of_type_Agmg;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeaf(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aeag(this);
  final String jdField_b_of_type_JavaLangString = "pay";
  protected int c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aeah(this);
  final String jdField_c_of_type_JavaLangString = "red";
  protected int d;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new aeai(this);
  private String jdField_d_of_type_JavaLangString;
  protected int e;
  private View.OnClickListener e;
  protected int f;
  private View.OnClickListener f;
  protected int g;
  private View.OnClickListener g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  
  static
  {
    jdField_a_of_type_JavaLangString = aead.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public aead(Context paramContext)
  {
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new aeaj(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new aeak(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new aeal(this);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(15.0F * f1 + 0.5F));
    this.jdField_b_of_type_Int = ((int)(10.0F * f1 + 0.5F));
    this.jdField_g_of_type_Int = ((int)(8.0F * f1 + 0.5F));
    this.jdField_f_of_type_Int = ((int)(23.0F * f1 + 0.5F));
    this.h = ((int)(40.0F * f1 + 0.5F));
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
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
      return 2;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(60);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        return 6;
      }
      return 3;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
      return 4;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1004) {
      return 5;
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002) || (paramSessionInfo.jdField_a_of_type_Int == 10004)) {
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
      localHashMap.put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "");
      localHashMap.put("recv_nickname", babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      localHashMap.put("recv_group_type", a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo) + "");
      localHashMap.put("recv_group_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    return localHashMap;
  }
  
  private boolean a(Context paramContext, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, String paramString1, String paramString2, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if (paramQQWalletTransferMsgElem != null) {}
    for (Object localObject1 = paramQQWalletTransferMsgElem.nativeAndroid; (paramContext == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (paramMessageForQQWalletMsg == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null); localObject1 = null) {
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
      paramQQWalletTransferMsgElem = (String)((HashMap)localObject1).get("payData");
      paramString1 = (String)((HashMap)localObject1).get("reqCode");
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramQQWalletTransferMsgElem)))
      {
        return false;
        localObject1 = new HashMap();
      }
      else
      {
        paramString2 = new Bundle();
        paramString2.putString("json", paramQQWalletTransferMsgElem);
        paramString2.putString("callbackSn", "0");
        paramQQWalletTransferMsgElem = new Intent(paramContext, PayBridgeActivity.class);
        paramQQWalletTransferMsgElem.putExtras(paramString2);
        paramQQWalletTransferMsgElem.putExtra("pay_requestcode", Integer.valueOf(paramString1).intValue());
      }
    }
    label898:
    for (;;)
    {
      try
      {
        if (!(paramContext instanceof Activity)) {
          paramQQWalletTransferMsgElem.addFlags(268435456);
        }
        paramContext.startActivity(paramQQWalletTransferMsgElem);
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
        if (paramQQWalletTransferMsgElem != null)
        {
          localObject1 = localObject2;
          if (paramQQWalletTransferMsgElem.themeId > 1)
          {
            localObject1 = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(paramQQWalletTransferMsgElem.themeId);
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((agqy)localObject1).jdField_b_of_type_JavaLangString;
          }
        }
        localObject2 = agwi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, paramMessageForQQWalletMsg.istroop);
        m = ((Bundle)localObject2).getInt("groupType");
        localObject2 = ((Bundle)localObject2).getString("name");
        paramQQWalletTransferMsgElem = agwi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForQQWalletMsg, paramQQWalletTransferMsgElem, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, paramSessionInfo, m, (String)localObject2, str, paramString1, paramString2, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", (String)localObject1);
        paramString2 = (ajkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
        if ((paramString2 == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid <= 0)) {}
      }
      try
      {
        paramString1 = paramQQWalletTransferMsgElem.getJSONObject("extra_data");
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
      paramString1.putString("json", paramQQWalletTransferMsgElem.toString());
      paramString1.putString("callbackSn", "0");
      if (localObject1 != null) {
        paramString1.putString("cftImageUrl", (String)localObject1);
      }
      paramQQWalletTransferMsgElem = str;
      if (str != null)
      {
        paramQQWalletTransferMsgElem = str;
        if (str.length() > 4) {
          paramQQWalletTransferMsgElem = "****" + str.substring(4);
        }
      }
      paramString1.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "graphb", "open", "groupType=" + m + "&msgType=" + paramMessageForQQWalletMsg.messageType + "&redId=" + paramQQWalletTransferMsgElem, 0, null));
      paramQQWalletTransferMsgElem = new Intent(paramContext, PayBridgeActivity.class);
      paramQQWalletTransferMsgElem.putExtras(paramString1);
      paramQQWalletTransferMsgElem.putExtra("pay_requestcode", 5);
      continue;
      localObject1 = "http://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + paramQQWalletTransferMsgElem.themeId + "_bg";
      continue;
      try
      {
        paramQQWalletTransferMsgElem = admw.class.getClassLoader();
        if (paramQQWalletTransferMsgElem == null) {
          return false;
        }
        paramQQWalletTransferMsgElem = paramQQWalletTransferMsgElem.loadClass(localCharSequence);
      }
      catch (Exception paramQQWalletTransferMsgElem)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramQQWalletTransferMsgElem.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to find Class : " + localCharSequence, paramQQWalletTransferMsgElem);
        paramQQWalletTransferMsgElem = null;
        continue;
        paramQQWalletTransferMsgElem = new Intent(paramContext, paramQQWalletTransferMsgElem);
        paramString1 = ((HashMap)localObject1).entrySet().iterator();
        if (!paramString1.hasNext()) {
          break label898;
        }
      }
      if (paramQQWalletTransferMsgElem == null) {
        return false;
      }
      paramString2 = (Map.Entry)paramString1.next();
      paramQQWalletTransferMsgElem.putExtra((String)paramString2.getKey(), (String)paramString2.getValue());
    }
  }
  
  public RelativeLayout a(aeam paramaeam, Context paramContext)
  {
    if ((paramaeam == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout = b(paramaeam, paramContext);
    TextView localTextView = a(paramContext);
    localRelativeLayout.addView(localTextView);
    paramaeam.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    paramContext = a(paramContext);
    localRelativeLayout.addView(paramContext);
    paramaeam.f = paramContext;
    return localRelativeLayout;
  }
  
  public RelativeLayout a(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131307820);
    localLayoutParams.addRule(1, 2131307820);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.jdField_f_of_type_Int);
    localLayoutParams.topMargin = this.jdField_g_of_type_Int;
    localLayoutParams.bottomMargin = this.jdField_a_of_type_Int;
    localLayoutParams.addRule(3, 2131307820);
    localLayoutParams.addRule(5, 2131307820);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setMaxWidth(this.k);
    paramContext.setTextColor(-8947849);
    paramContext.setBackgroundResource(2130846122);
    paramContext.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setSingleLine();
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131307821);
    return paramContext;
  }
  
  public void a(agmg paramagmg)
  {
    this.jdField_a_of_type_Agmg = paramagmg;
  }
  
  public void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    paramRelativeLayout.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
      paramBaseChatPie = (MessageForQQWalletMsg)paramRelativeLayout.getTag();
    } while (paramBaseChatPie == null);
    bfod.a(paramQQAppInterface, "tenpay.com", new aeae(this));
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
    paramRelativeLayout.setTag(2131311046, Integer.valueOf(m));
    if (m == 1)
    {
      paramRelativeLayout.setContentDescription(ajjy.a(2131645388) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645384));
      paramRelativeLayout.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      return true;
      if (m == 2)
      {
        paramRelativeLayout.setContentDescription(ajjy.a(2131645379) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645395));
        paramRelativeLayout.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 8)
      {
        paramRelativeLayout.setContentDescription("K歌红包:" + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645391));
        paramRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 9)
      {
        paramRelativeLayout.setContentDescription(ajjy.a(2131645373) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645389));
        paramRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 10)
      {
        paramRelativeLayout.setContentDescription(ajjy.a(2131645374) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645378));
        paramRelativeLayout.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
      }
      else if (m == 11)
      {
        paramRelativeLayout.setContentDescription(ajjy.a(2131645392) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645381));
        paramRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        paramRelativeLayout.setContentDescription(paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + paramString);
        paramRelativeLayout.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  public RelativeLayout b(aeam paramaeam, Context paramContext)
  {
    if ((paramaeam == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    localRelativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localRelativeLayout1.setId(2131307805);
    paramaeam.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout1;
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.k, this.l);
    localRelativeLayout2.setId(2131307820);
    localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RoundImageView(paramContext);
    localRelativeLayout2.addView((View)localObject1);
    ((RoundImageView)localObject1).getLayoutParams().width = this.k;
    ((RoundImageView)localObject1).getLayoutParams().height = this.l;
    paramaeam.c = localRelativeLayout2;
    localObject1 = new RelativeLayout(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.k, this.l);
    ((RelativeLayout)localObject1).setBackgroundResource(2130846186);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setVisibility(8);
    paramaeam.d = ((RelativeLayout)localObject1);
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setId(2131307908);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.topMargin = this.h;
    localLayoutParams1.addRule(10);
    localLayoutParams1.addRule(14);
    ((LinearLayout)localObject2).setLayoutParams(localLayoutParams1);
    ((LinearLayout)localObject2).setVisibility(8);
    paramaeam.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject2);
    RelativeLayout localRelativeLayout3 = new RelativeLayout(paramContext);
    localRelativeLayout3.setId(2131307825);
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
    ((TextView)localObject3).setId(2131307815);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((TextView)localObject3).setGravity(17);
    localRelativeLayout3.addView((View)localObject3);
    paramaeam.e = localRelativeLayout3;
    paramaeam.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
    localObject4 = new ImageView(paramContext);
    ((ImageView)localObject4).setId(2131307822);
    ((ImageView)localObject4).setVisibility(8);
    ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    localLayoutParams3.setMargins(this.jdField_e_of_type_Int, 0, this.jdField_e_of_type_Int, 0);
    localLayoutParams3.addRule(12);
    paramaeam.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
    RelativeLayout localRelativeLayout4 = new RelativeLayout(paramContext);
    localRelativeLayout4.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
    paramaeam.g = localRelativeLayout4;
    localObject3 = new AnimationView(paramContext);
    ((AnimationView)localObject3).setPlayer(new aean((AnimationView)localObject3));
    ((AnimationView)localObject3).setId(2131307814);
    ((AnimationView)localObject3).setVisibility(8);
    ((AnimationView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(this.k, this.l);
    localLayoutParams5.addRule(14);
    localLayoutParams5.addRule(12);
    paramaeam.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)localObject3);
    localRelativeLayout2.addView((View)localObject4, localLayoutParams3);
    localRelativeLayout2.addView((View)localObject3, localLayoutParams5);
    localRelativeLayout2.addView(localRelativeLayout4, localLayoutParams4);
    localRelativeLayout2.addView(localRelativeLayout3, localLayoutParams2);
    localRelativeLayout2.addView((View)localObject2, localLayoutParams1);
    localRelativeLayout1.addView(localRelativeLayout2);
    localRelativeLayout1.addView((View)localObject1);
    paramContext = new AnimationView(paramContext);
    paramContext.setPlayer(new aean((AnimationView)localObject3));
    paramContext.setId(2131307830);
    paramContext.setVisibility(8);
    paramaeam.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView = paramContext;
    return localRelativeLayout1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aead
 * JD-Core Version:    0.7.0.1
 */