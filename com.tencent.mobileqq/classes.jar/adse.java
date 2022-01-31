import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFee;

public class adse
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  protected final int c = 2131311956;
  protected final int d = 2131311952;
  protected final int e = 2131311955;
  protected final int f = 2131311954;
  protected final int g = 2131311951;
  protected final int h = 2131311953;
  protected int i;
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
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  protected int x;
  
  public adse(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adsf(this);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.j = ((int)(42.0F * f1 + 0.5F));
    this.k = ((int)(21.0F * f1 + 0.5F));
    this.l = ((int)(15.0F * f1 + 0.5F));
    this.m = ((int)(10.0F * f1 + 0.5F));
    this.n = ((int)(9.0F * f1 + 0.5F));
    this.o = ((int)(6.0F * f1 + 0.5F));
    this.p = ((int)(4.0F * f1 + 0.5F));
    this.q = ((int)(1.0F * f1 + 0.5F));
    this.i = (this.m * 23);
    this.r = ((int)(157.0F * f1 + 0.5F));
    this.s = ((int)(65.0F * f1 + 0.5F));
    this.t = ((int)(7.0F * f1 + 0.5F));
    this.u = ((int)(152.0F * f1 + 0.5F));
    this.v = ((int)(5.0F * f1 + 0.5F));
    this.w = ((int)(61.0F * f1 + 0.5F));
    this.x = ((int)(f1 * 19.0F + 0.5F));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new adsg(this, null);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramacju = (adsg)paramacju;
    paramBaseChatItemLayout = (MessageForTroopFee)paramChatMessage;
    if ((paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramacju.jdField_a_of_type_Long == paramChatMessage.uniseq)) {
      return paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    QQWalletTransferBubbleView localQQWalletTransferBubbleView;
    float f1;
    label210:
    int i1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
      paramacju.b = paramChatMessage.frienduin;
      paramacju.jdField_a_of_type_Long = paramChatMessage.uniseq;
      paramView = (TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311955);
      TextView localTextView1 = (TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311954);
      ImageView localImageView = (ImageView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311952);
      TextView localTextView2 = (TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311953);
      localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311956);
      if (paramBaseChatItemLayout.title != null)
      {
        paramView.setTextSize(24.0F);
        TextPaint localTextPaint = paramView.getPaint();
        if (localTextPaint != null)
        {
          f1 = localTextPaint.measureText(paramBaseChatItemLayout.title);
          if (this.i <= BaseChatItemLayout.d) {
            break label378;
          }
          if (f1 > BaseChatItemLayout.d - this.m * 9) {
            paramView.setTextSize(14.0F);
          }
        }
      }
      paramView.setText(paramBaseChatItemLayout.title);
      paramView.setTextColor(-1);
      localTextView1.setText(paramBaseChatItemLayout.summary);
      localTextView1.setTextColor(-1);
      localTextView2.setText(paramBaseChatItemLayout.source);
      localImageView.setImageResource(2130846144);
      i1 = Color.parseColor(paramBaseChatItemLayout.backgroundColor);
      if (paramChatMessage.isSend()) {
        break label401;
      }
    }
    label401:
    for (boolean bool = true;; bool = false)
    {
      localQQWalletTransferBubbleView.setBubbleBackground(2130846142, i1, bool);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramBaseChatItemLayout.title + paramBaseChatItemLayout.summary + paramBaseChatItemLayout.source);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacmv);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacmv);
      return paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
      break;
      label378:
      if (f1 <= this.m * 14) {
        break label210;
      }
      paramView.setTextSize(14.0F);
      break label210;
    }
  }
  
  protected RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.i, this.l * 5));
    ((QQWalletTransferBubbleView)localObject1).setId(2131311956);
    Object localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(this.j, this.j);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(2131311952);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131311952);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(2131311955);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.q;
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(13.0F);
    ((TextView)localObject3).setId(2131311954);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.i, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131311956);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130846143);
    ((RelativeLayout)localObject1).setId(2131311951);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131311953);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFee)paramChatMessage;
    return paramChatMessage.title + paramChatMessage.summary + paramChatMessage.source;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131299417: 
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = aciy.a(paramView);
    a(paramView, localbakh);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbakh);
    super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adse
 * JD-Core Version:    0.7.0.1
 */