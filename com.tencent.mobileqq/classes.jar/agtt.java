import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.qphone.base.util.QLog;

public class agtt
  extends BaseBubbleBuilder
{
  private static int c;
  private static int d;
  private static int e;
  private View.OnClickListener a;
  private Context b;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public agtt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agtu(this);
    this.b = paramContext;
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.f = ((int)(1.0F * f1 + 0.5F));
    this.g = ((int)(6.0F * f1 + 0.5F));
    this.h = ((int)(7.0F * f1 + 0.5F));
    this.j = ((int)(15.0F * f1 + 0.5F));
    this.l = ((int)(21.0F * f1 + 0.5F));
    this.k = ((int)(42.0F * f1 + 0.5F));
    this.i = ((int)(f1 * 230.0F + 0.5F));
    c = this.f * 2;
    d = this.f * 2;
    jdField_e_of_type_Int = this.h;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.i, this.j * 5));
    localQQWalletTransferBubbleView.setId(2131380885);
    Object localObject1 = new ImageView(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.k, this.k);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131380881);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131380881);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.g;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setId(2131380884);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.f;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setId(2131380883);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.i, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131380885);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130847157);
    localQQWalletTransferBubbleView.setId(2131380880);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131380882);
    localQQWalletTransferBubbleView.addView(paramContext);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    return localRelativeLayout;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return new agtv(this, null);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    boolean bool2 = true;
    paramView = (agtv)paramaezf;
    if (paramView.a == null) {
      paramView.a = a(this.b);
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {}
    for (paramaezf = (MessageForVIPDonate)paramChatMessage;; paramaezf = null)
    {
      if (paramaezf == null)
      {
        QLog.e("VIPDonateMsgItemBuilder", 1, "vipdonate msg empty");
        return null;
      }
      paramaezf.parse();
      paramaezf = paramaezf.donateMsg;
      if (paramaezf == null)
      {
        QLog.e("VIPDonateMsgItemBuilder", 1, "donateMsg empty");
        return null;
      }
      paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131380884);
      paramBaseChatItemLayout.setText(paramaezf.title);
      paramBaseChatItemLayout.setTextColor(-1);
      paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131380883);
      paramBaseChatItemLayout.setText(paramaezf.subTitle);
      paramBaseChatItemLayout.setTextColor(-1);
      ((TextView)paramView.a.findViewById(2131380882)).setText(paramaezf.footer);
      ((ImageView)paramView.a.findViewById(2131380881)).setImageResource(2130850737);
      paramBaseChatItemLayout = (QQWalletTransferBubbleView)paramView.a.findViewById(2131380880);
      QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramView.a.findViewById(2131380885);
      int m = Color.rgb(255, 170, 57);
      if (!paramChatMessage.isSend())
      {
        bool1 = true;
        localQQWalletTransferBubbleView.setBubbleBackground(2130847156, m, bool1);
        m = Color.rgb(255, 255, 255);
        if (paramChatMessage.isSend()) {
          break label346;
        }
      }
      label346:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramBaseChatItemLayout.setBubbleBackground(2130847157, m, bool1);
        if (jdField_e_of_type_Boolean) {
          paramView.a.setContentDescription(paramaezf.subTitle + paramaezf.title);
        }
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.a.setOnLongClickListener(paramafce);
        paramView.a.setOnTouchListener(paramafce);
        return paramView.a;
        bool1 = false;
        break;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365382: 
      acvv.b(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(d, jdField_e_of_type_Int, c, 0);
      return;
    }
    paramView.setPadding(c, jdField_e_of_type_Int, d, 0);
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    paramView = AIOUtils.getMessage(paramView);
    a(paramView, localbgaz);
    acvv.a(localbgaz, this.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    b(paramView, localbgaz);
    super.c(localbgaz, this.b);
    super.e(localbgaz, this.b);
    return localbgaz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtt
 * JD-Core Version:    0.7.0.1
 */