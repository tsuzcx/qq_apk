import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class adxv
  extends BaseBubbleBuilder
{
  public static final String a;
  private static int t;
  private static int u;
  private static int v;
  protected ahbe a;
  private View.OnClickListener a;
  protected HashMap<String, SparseArray<WeakReference<adxy>>> a;
  protected float b;
  final String b;
  protected final int c;
  long jdField_c_of_type_Long;
  final String jdField_c_of_type_JavaLangString = "pfa";
  protected final int d;
  protected String d;
  protected final int e = 2131373639;
  protected final int f = 2131373646;
  protected final int g = 2131373638;
  protected final int h = 2131373637;
  protected final int i = 2131373641;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  
  static
  {
    jdField_a_of_type_JavaLangString = adxv.class.getSimpleName();
  }
  
  public adxv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 2131373622;
    this.jdField_d_of_type_Int = 2131373651;
    this.jdField_b_of_type_JavaLangString = "pay";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adxw(this);
    this.jdField_a_of_type_Ahbe = new adxx(this);
    this.jdField_d_of_type_JavaLangString = paramContext.getString(2131717336);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.k = ((int)(42.0F * this.jdField_b_of_type_Float + 0.5F));
    this.l = ((int)(21.0F * this.jdField_b_of_type_Float + 0.5F));
    this.m = ((int)(15.0F * this.jdField_b_of_type_Float + 0.5F));
    this.n = ((int)(10.0F * this.jdField_b_of_type_Float + 0.5F));
    this.o = ((int)(9.0F * this.jdField_b_of_type_Float + 0.5F));
    this.p = ((int)(6.5F * this.jdField_b_of_type_Float + 0.5F));
    this.q = ((int)(4.0F * this.jdField_b_of_type_Float + 0.5F));
    this.r = ((int)(this.jdField_b_of_type_Float * 1.0F + 0.5F));
    this.j = (this.n * 23);
    this.s = ((int)(7.0F * this.jdField_b_of_type_Float + 0.5F));
    t = this.r * 2;
    u = this.r * 2;
    v = this.s;
  }
  
  private RelativeLayout a(adxy paramadxy, Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.j, this.m * 5));
    localQQWalletTransferBubbleView.setId(2131373622);
    ImageView localImageView = new ImageView(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.k, this.k);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setId(2131373651);
    localQQWalletTransferBubbleView.addView(localImageView);
    Object localObject2 = new LinearLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131373651);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject1).setTextSize(24.0F);
    ((TextView)localObject1).setId(2131373639);
    ((LinearLayout)localObject2).addView((View)localObject1);
    TextView localTextView = new TextView(paramContext);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.r;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localTextView.setSingleLine();
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextSize(13.0F);
    localTextView.setId(2131373646);
    ((LinearLayout)localObject2).addView(localTextView);
    localQQWalletTransferBubbleView.addView((View)localObject2);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localObject2 = new QQWalletTransferBubbleView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.j, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131373622);
    ((QQWalletTransferBubbleView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((QQWalletTransferBubbleView)localObject2).setBackgroundResource(2130846330);
    ((QQWalletTransferBubbleView)localObject2).setId(2131373638);
    paramContext = new TextView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.m;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.m;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131373637);
    ((QQWalletTransferBubbleView)localObject2).addView(paramContext);
    localRelativeLayout.addView((View)localObject2);
    paramadxy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    paramadxy.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    paramadxy.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    paramadxy.c = paramContext;
    paramadxy.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView = ((QQWalletTransferBubbleView)localObject2);
    paramadxy.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView = localQQWalletTransferBubbleView;
    return localRelativeLayout;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.n;
    localLayoutParams.bottomMargin = this.p;
    localLayoutParams.leftMargin = (this.k + this.q);
    localLayoutParams.rightMargin = (this.k + this.q);
    localLayoutParams.addRule(3, 2131364109);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130843962);
    paramContext.setPadding(this.o, this.q, this.o, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.q, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131373641);
    return paramContext;
  }
  
  private void a(adxy paramadxy, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, boolean paramBoolean, acxj paramacxj)
  {
    if (paramMessageForQQWalletMsg.messageType == 16) {}
    for (int i1 = 1;; i1 = 0)
    {
      a(paramadxy.jdField_a_of_type_AndroidWidgetTextView, paramQQWalletTransferMsgElem.title);
      paramadxy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramQQWalletTransferMsgElem.titleColor);
      paramadxy.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQWalletTransferMsgElem.subTitle);
      paramadxy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramQQWalletTransferMsgElem.subtitleColor);
      paramadxy.c.setText(paramQQWalletTransferMsgElem.content);
      if (i1 != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a(paramQQWalletTransferMsgElem.icon));
        if (!TextUtils.isEmpty(paramQQWalletTransferMsgElem.iconUrl)) {
          localObject = aywm.a(paramQQWalletTransferMsgElem.iconUrl, (int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, this.k), (int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, this.k), null, null);
        }
        paramadxy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().waitAppRuntime(null), false, null))
      {
        paramadxy.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleNightBackground(2130846329, Color.parseColor("#FF19BAFF"), paramBoolean);
        paramadxy.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130846330, Color.parseColor("#A4A5A8"), paramBoolean);
        paramadxy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2B2B2"));
        paramadxy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2B2B2"));
        paramadxy.c.setTextColor(Color.parseColor("#5D616B"));
      }
      for (;;)
      {
        paramadxy.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramQQWalletTransferMsgElem.title + paramQQWalletTransferMsgElem.subTitle + this.jdField_d_of_type_JavaLangString);
        paramadxy.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramadxy.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacxj);
        paramadxy.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacxj);
        if (i1 != 0) {
          a(paramadxy, paramMessageForQQWalletMsg, paramQQWalletTransferMsgElem);
        }
        return;
        if (axmv.b())
        {
          paramadxy.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130846329, Color.parseColor("#FF19BAFF"), paramBoolean);
          paramadxy.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130846330, Color.parseColor("#FFECEDF2"), paramBoolean);
          paramadxy.c.setTextColor(Color.parseColor("#FF878B99"));
        }
        else
        {
          paramadxy.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130846329, paramQQWalletTransferMsgElem.background, paramBoolean);
          if (paramQQWalletTransferMsgElem.contentBgColor != 0) {
            paramadxy.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130846330, paramQQWalletTransferMsgElem.contentBgColor, paramBoolean);
          }
          if (paramQQWalletTransferMsgElem.contentColor != 0) {
            paramadxy.c.setTextColor(paramQQWalletTransferMsgElem.contentColor);
          }
        }
      }
    }
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (paramString == null)) {
      return;
    }
    paramTextView.setTextSize(24.0F);
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1;
    if (localTextPaint != null)
    {
      f1 = localTextPaint.measureText(paramString);
      if (this.j <= BaseChatItemLayout.jdField_d_of_type_Int) {
        break label73;
      }
      if (f1 > BaseChatItemLayout.jdField_d_of_type_Int - this.n * 9) {
        paramTextView.setTextSize(14.0F);
      }
    }
    for (;;)
    {
      paramTextView.setText(paramString);
      return;
      label73:
      if (f1 > this.n * 14) {
        paramTextView.setTextSize(14.0F);
      }
    }
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    paramString2 = paramString1.split("\\?");
    paramString3 = paramString2[0];
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    if (paramString2.length > 1) {
      paramString2 = paramMessageForQQWalletMsg.parseUrlParams(paramString2[1]);
    }
    while (paramString3.equals("pay"))
    {
      paramString1 = (String)paramString2.get("payData");
      paramString2 = (String)paramString2.get("reqCode");
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
      {
        return false;
        paramString2 = new HashMap();
      }
      else
      {
        paramMessageForQQWalletMsg = new Bundle();
        paramMessageForQQWalletMsg.putString("json", paramString1);
        paramMessageForQQWalletMsg.putString("callbackSn", "0");
        paramString1 = new Intent(paramContext, PayBridgeActivity.class);
        paramString1.putExtras(paramMessageForQQWalletMsg);
        paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
      }
    }
    label595:
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to startActivity : " + paramString3, paramContext);
        return false;
      }
      if (paramString3.equals("pfa"))
      {
        paramSessionInfo = (String)paramString2.get("data");
        paramMessageForQQWalletMsg = (String)paramString2.get("tokenid");
        if ((TextUtils.isEmpty(paramMessageForQQWalletMsg)) || (TextUtils.isEmpty(paramSessionInfo))) {
          return false;
        }
        paramString2 = new JSONObject();
        try
        {
          paramString2.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramString2.put("viewTag", "payByFriendConfirm");
          paramString2.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#paymsg");
          paramString2.put("comeForm", 2);
          paramSessionInfo = new JSONObject();
          paramSessionInfo.put("pfa_req", paramString1);
          paramSessionInfo.put("token_id", paramMessageForQQWalletMsg);
          paramString2.put("extra_data", paramSessionInfo);
          paramMessageForQQWalletMsg = new Bundle();
          paramMessageForQQWalletMsg.putString("json", paramString2.toString());
          paramMessageForQQWalletMsg.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramMessageForQQWalletMsg);
          paramString1.putExtra("pay_requestcode", 5);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          continue;
        }
      }
      else
      {
        try
        {
          paramString1 = adxv.class.getClassLoader();
          if (paramString1 == null) {
            return false;
          }
          paramString1 = paramString1.loadClass(paramString3);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletTransMsgItemBuilder failed to find Class : " + paramString3, paramString1);
          paramString1 = null;
          continue;
          paramString1 = new Intent(paramContext, paramString1);
          paramString2 = paramString2.entrySet().iterator();
          if (!paramString2.hasNext()) {
            break label595;
          }
        }
        if (paramString1 == null) {
          return false;
        }
        paramMessageForQQWalletMsg = (Map.Entry)paramString2.next();
        paramString1.putExtra((String)paramMessageForQQWalletMsg.getKey(), (String)paramMessageForQQWalletMsg.getValue());
      }
    }
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2130846328;
    case 1: 
      return 2130846331;
    case 3: 
      return 2130846332;
    case 4: 
      return 2130846316;
    case 5: 
      return 2130846315;
    }
    return 2130846314;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new adxy(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    adxy localadxy = (adxy)paramacuj;
    paramacuj = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      paramacuj = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((paramacuj == null) || (paramacuj.mQQWalletTransferMsg == null)) {
      return null;
    }
    if ((localadxy.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localadxy.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localadxy.jdField_a_of_type_Long != paramChatMessage.uniseq)))
    {
      localadxy.jdField_a_of_type_AndroidWidgetRelativeLayout = a(localadxy, this.jdField_a_of_type_AndroidContentContext);
      paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
    }
    localadxy.jdField_a_of_type_Long = paramChatMessage.uniseq;
    paramView = paramacuj.mQQWalletTransferMsg.elem;
    if (paramView == null) {
      return localadxy.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    boolean bool;
    if (!paramChatMessage.isSend())
    {
      bool = true;
      a(localadxy, paramacuj, paramView, bool, paramacxj);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + paramacuj.mQQWalletTransferMsg.templateId, "", "", "");
      paramChatMessage = (TextView)paramBaseChatItemLayout.findViewById(2131373641);
      if (paramChatMessage != null)
      {
        if ((paramView == null) || (TextUtils.isEmpty(paramView.blackStripe))) {
          break label346;
        }
        paramChatMessage.setText(paramView.blackStripe);
        paramChatMessage.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramacuj.messageType == 16)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ahbe);
        if (!TextUtils.isEmpty(paramacuj.mQQWalletTransferMsg.listId))
        {
          paramView = (SparseArray)this.jdField_a_of_type_JavaUtilHashMap.get(paramacuj.mQQWalletTransferMsg.listId);
          paramChatMessage = paramView;
          if (paramView == null)
          {
            paramChatMessage = new SparseArray();
            this.jdField_a_of_type_JavaUtilHashMap.put(paramacuj.mQQWalletTransferMsg.listId, paramChatMessage);
          }
          paramChatMessage.put((int)paramacuj.uniseq, new WeakReference(localadxy));
        }
      }
      return localadxy.jdField_a_of_type_AndroidWidgetRelativeLayout;
      bool = false;
      break;
      label346:
      paramChatMessage.setVisibility(8);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    Object localObject = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((localObject == null) || (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null)) {
      return paramChatMessage.msg;
    }
    localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (bbfh.a(paramChatMessage.issend))
      {
        localStringBuilder.append("发出");
        if ((((QQWalletTransferMsgElem)localObject).content == null) || (!((QQWalletTransferMsgElem)localObject).content.contains("QQ转账"))) {
          break label125;
        }
        localStringBuilder.append("QQ转账").append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("发来");
        break;
        label125:
        localStringBuilder.append("QQ转账").append(((QQWalletTransferMsgElem)localObject).title).append(((QQWalletTransferMsgElem)localObject).content).append("按钮");
      }
    }
    return paramChatMessage.msg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ahbe);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(adxy paramadxy, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletTransferMsgElem paramQQWalletTransferMsgElem)
  {
    int i2;
    boolean bool;
    if (paramMessageForQQWalletMsg.messageType == 16)
    {
      String str = paramQQWalletTransferMsgElem.title;
      i2 = -12727643;
      if ((paramMessageForQQWalletMsg.isSend()) || (paramQQWalletTransferMsgElem.isInAAPayer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))) {
        break label132;
      }
      paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717329);
      i1 = 2130846307;
      a(paramadxy.jdField_a_of_type_AndroidWidgetTextView, paramQQWalletTransferMsgElem);
      if ((i1 != 0) && (paramadxy.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        paramQQWalletTransferMsgElem = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i1);
        paramadxy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramQQWalletTransferMsgElem);
      }
      if (paramadxy.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView != null)
      {
        paramadxy = paramadxy.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView;
        if (paramMessageForQQWalletMsg.isSend()) {
          break label337;
        }
        bool = true;
        label120:
        paramadxy.setBubbleBackground(2130846329, i2, bool);
      }
    }
    return;
    label132:
    paramQQWalletTransferMsgElem = ahbc.a(1, paramMessageForQQWalletMsg.mQQWalletTransferMsg.listId, paramMessageForQQWalletMsg);
    if (paramQQWalletTransferMsgElem != null) {}
    for (int i1 = paramQQWalletTransferMsgElem.a("state", -1);; i1 = -1)
    {
      if (i1 == -1)
      {
        paramQQWalletTransferMsgElem = paramMessageForQQWalletMsg.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramQQWalletTransferMsgElem)) {}
      }
      for (;;)
      {
        try
        {
          int i3 = Integer.valueOf(paramQQWalletTransferMsgElem).intValue();
          i1 = i3;
          if (i1 != 1) {
            break label236;
          }
          paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717335);
          i1 = 2130846308;
          i2 = -7676215;
        }
        catch (Exception paramQQWalletTransferMsgElem)
        {
          if (QLog.isColorLevel()) {
            paramQQWalletTransferMsgElem.printStackTrace();
          }
        }
      }
      label236:
      if (i1 == 2)
      {
        paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717330);
        i1 = 2130846305;
        i2 = -7676215;
        break;
      }
      if (i1 == 3)
      {
        paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717332);
        i1 = 2130846305;
        i2 = -7676215;
        break;
      }
      if (paramMessageForQQWalletMsg.isSend())
      {
        paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717333);
        i1 = 2130846306;
        break;
      }
      paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717331);
      i1 = 2130846306;
      break;
      label337:
      bool = false;
      break label120;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(u, v, t, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(t, v, u, paramView.getResources().getDimensionPixelSize(2131296289));
      return;
    }
    paramView.setPadding(t, v, u, 0);
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    a(paramView, localbbmf);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbbmf);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxv
 * JD-Core Version:    0.7.0.1
 */