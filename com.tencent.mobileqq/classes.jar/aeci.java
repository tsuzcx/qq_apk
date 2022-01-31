import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.rookery.translate.AITranslator;
import com.rookery.translate.type.Language;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.RotateableView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aeci
  extends aebz
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  lbn jdField_a_of_type_Lbn;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public aeci(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.b.setDuration(150L);
    this.b.setFillAfter(true);
  }
  
  private int a(double paramDouble)
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * paramDouble);
  }
  
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramInt == 0) {
      str = "0";
    }
    for (;;)
    {
      if (h != 0) {
        axrl.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        axrl.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        axrl.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
      }
      h = 0;
      i = 0;
      g = 0;
      return 0;
      if (paramInt == 1) {
        str = "1";
      } else if (paramInt == 3000) {
        str = "2";
      } else {
        str = "";
      }
    }
  }
  
  private void a(aecm paramaecm)
  {
    paramaecm.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramaecm.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramaecm.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramaecm.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramaecm.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(aecm paramaecm, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramaecm == null) {
      return;
    }
    if (paramaecm.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramaecm.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramaecm.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramaecm.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramaecm.d != null)
    {
      paramaecm.d.clearAnimation();
      paramaecm.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramaecm.d.setAlpha(1.0F);
      }
    }
    Object localObject = lbs.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!lbo.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long))
    {
      b(paramaecm);
      this.jdField_a_of_type_Lbn = null;
      if (paramaecm.e == 100000)
      {
        lbk locallbk = lbo.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallbk != null) {
          this.jdField_a_of_type_Lbn = locallbk.a(str, paramaecm.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Lbn == null) || (!this.jdField_a_of_type_Lbn.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramaecm.jdField_a_of_type_Ambh = amch.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bbjn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramaecm.e == 100000) && (paramMessageForText.msgtype == -1000))
      {
        paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
        if (!paramMessageForText.isSend()) {
          break label496;
        }
      }
    }
    label463:
    label496:
    for (int j = 1;; j = 0)
    {
      paramBaseChatItemLayout.setHearIconPosition(j);
      paramBaseChatItemLayout.a.setText(2131720386);
      bbjn.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramaecm.jdField_b_of_type_Long;
      axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramaecm.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131720386);
        return;
        a(paramaecm);
        break;
        paramaecm.jdField_a_of_type_Ambh = amch.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, aecm paramaecm)
  {
    paramaecm.jdField_c_of_type_AndroidViewView = paramaecm.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377663);
    paramaecm.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramaecm.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377662));
    paramaecm.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130846112);
  }
  
  private void b(aecm paramaecm)
  {
    paramaecm.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramaecm.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramaecm.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramaecm.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramaecm.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(aecm paramaecm, MessageForText paramMessageForText)
  {
    paramaecm.e = ((int)paramMessageForText.vipBubbleID);
    paramaecm.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramaecm.f = paramMessageForText.istroop;
    paramaecm.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramaecm.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(aecm paramaecm, MessageForText paramMessageForText)
  {
    int j = 0;
    paramaecm.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramaecm.e == 100000)
    {
      paramaecm.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = lbs.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Lbn = null;
      lbk locallbk = lbo.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallbk != null) {
        this.jdField_a_of_type_Lbn = locallbk.a(paramMessageForText.msg, paramaecm.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Lbn != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Lbn.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramaecm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lbn.a();
            localObject1 = new ayki(paramaecm.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramaecm.e == 100000)
    {
      localObject2 = paramaecm.jdField_b_of_type_JavaLangString;
      if (paramaecm.g == 0) {
        paramaecm.d.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Lbn == null) || (paramaecm.g != 1)) {
        return;
      }
      paramMessageForText = paramaecm.d.getText();
      int m = paramaecm.d.getMeasuredWidth();
      int k = paramaecm.d.getMeasuredHeight();
      paramaecm.d.setText((CharSequence)localObject1);
      paramaecm.d.measure(0, 0);
      if (paramaecm.d.getMeasuredWidth() < BaseChatItemLayout.d) {
        j = paramaecm.d.getMeasuredWidth() - m;
      }
      m = paramaecm.d.getMeasuredHeight();
      paramaecm.d.setText(paramMessageForText);
      paramMessageForText = new lbt(paramaecm.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new aeck(this, paramaecm, (CharSequence)localObject1));
      paramaecm.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramaecm.d.setText((CharSequence)localObject1);
  }
  
  public acun a()
  {
    return new aecm(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    paramViewGroup = (aecm)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (aecm)paramacun;
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561469, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramacun;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramacun.findViewById(2131364113));
      paramBaseChatItemLayout.d.setMaxWidth(BaseChatItemLayout.d);
      paramBaseChatItemLayout.d.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
    }
    paramBaseChatItemLayout.d.setPadding(k, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    paramBaseChatItemLayout.d.setOnTouchListener(paramacxn);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramacxn);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new aecj(this);
    }
    return paramacun;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(aecm paramaecm, MessageForText paramMessageForText)
  {
    if (paramaecm == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramaecm.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramaecm.jdField_a_of_type_Boolean)
        {
          paramaecm.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramaecm.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramaecm.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramaecm.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramaecm.g);
          }
          if (paramaecm.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = lbs.a(localContext);
          paramMessageForText = null;
          lbk locallbk = lbo.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (locallbk != null) {
            paramMessageForText = locallbk.a(paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramaecm.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!lbo.a(localContext).b(str, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long)))
          {
            i += 1;
            lbo.a(localContext).b(str, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          lbo.a(localContext).a(str, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long, paramMessageForText.a());
          paramaecm.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131717254);
    return;
    label340:
    h += 1;
    paramaecm.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramaecm, paramaecm.jdField_b_of_type_JavaLangString, Language.fromString(str), new aecl(this, paramaecm, localContext, str)).booleanValue())
    {
      b(paramaecm);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131717254);
        return;
      }
      a(2131717256);
      return;
    }
    a(paramaecm);
    lbo.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long, Boolean.valueOf(true));
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    String str = paramChatMessage.msg;
    lbk locallbk;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = lbs.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      locallbk = lbo.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallbk == null) {
        break label142;
      }
    }
    label142:
    for (paramString = locallbk.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bgpd.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364110) || (paramView.getId() == 2131364113))
    {
      MessageForText localMessageForText = (MessageForText)actn.a(paramView);
      a((aecm)actn.a(paramView), localMessageForText);
      actn.n = true;
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeci
 * JD-Core Version:    0.7.0.1
 */