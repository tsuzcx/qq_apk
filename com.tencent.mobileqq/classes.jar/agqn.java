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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.RotateableView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class agqn
  extends agqd
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  lah jdField_a_of_type_Lah;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public agqn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(agqr paramagqr)
  {
    if (paramagqr.jdField_d_of_type_AndroidViewView != null) {
      paramagqr.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    if (paramagqr.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView != null) {
      paramagqr.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    }
    if (paramagqr.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramagqr.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramagqr.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramagqr.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(agqr paramagqr, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramagqr == null) {
      return;
    }
    if (paramagqr.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramagqr.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramagqr.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramagqr.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramagqr.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      paramagqr.jdField_d_of_type_AndroidWidgetTextView.clearAnimation();
      paramagqr.jdField_d_of_type_AndroidWidgetTextView.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramagqr.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    Object localObject = lam.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!lai.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long))
    {
      b(paramagqr);
      this.jdField_a_of_type_Lah = null;
      if (paramagqr.e == 100000)
      {
        lae locallae = lai.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallae != null) {
          this.jdField_a_of_type_Lah = locallae.a(str, paramagqr.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Lah == null) || (!this.jdField_a_of_type_Lah.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramagqr.jdField_a_of_type_Apee = apfe.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bfyz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramagqr.e == 100000) && (paramMessageForText.msgtype == -1000))
      {
        paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a, null);
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
      paramBaseChatItemLayout.a.setText(2131719054);
      bfyz.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramagqr.jdField_b_of_type_Long;
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramagqr.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131719054);
        return;
        a(paramagqr);
        break;
        paramagqr.jdField_a_of_type_Apee = apfe.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, agqr paramagqr)
  {
    paramagqr.jdField_d_of_type_AndroidViewView = paramagqr.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379046);
    paramagqr.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramagqr.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379045));
    paramagqr.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130846936);
  }
  
  private void b(agqr paramagqr)
  {
    if (paramagqr.jdField_d_of_type_AndroidViewView != null) {
      paramagqr.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramagqr.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView != null) {
      paramagqr.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    }
    if (paramagqr.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramagqr.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramagqr.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramagqr.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
    }
  }
  
  private void b(agqr paramagqr, MessageForText paramMessageForText)
  {
    paramagqr.e = ((int)paramMessageForText.vipBubbleID);
    paramagqr.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramagqr.f = paramMessageForText.istroop;
    paramagqr.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramagqr.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(agqr paramagqr, MessageForText paramMessageForText)
  {
    int j = 0;
    paramagqr.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramagqr.e == 100000)
    {
      paramagqr.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = lam.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Lah = null;
      lae locallae = lai.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallae != null) {
        this.jdField_a_of_type_Lah = locallae.a(paramMessageForText.msg, paramagqr.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Lah != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Lah.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramagqr.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lah.a();
            localObject1 = new QQText(paramagqr.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramagqr.e == 100000)
    {
      localObject2 = paramagqr.jdField_b_of_type_JavaLangString;
      if (paramagqr.g == 0) {
        paramagqr.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Lah == null) || (paramagqr.g != 1)) {
        return;
      }
      paramMessageForText = paramagqr.jdField_d_of_type_AndroidWidgetTextView.getText();
      int m = paramagqr.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int k = paramagqr.jdField_d_of_type_AndroidWidgetTextView.getMeasuredHeight();
      paramagqr.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramagqr.jdField_d_of_type_AndroidWidgetTextView.measure(0, 0);
      if (paramagqr.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() < BaseChatItemLayout.e) {
        j = paramagqr.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() - m;
      }
      m = paramagqr.jdField_d_of_type_AndroidWidgetTextView.getMeasuredHeight();
      paramagqr.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForText);
      paramMessageForText = new lan(paramagqr.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new agqp(this, paramagqr, (CharSequence)localObject1));
      paramagqr.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramagqr.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
  }
  
  public aezf a()
  {
    return new agqr(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    paramViewGroup = (agqr)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (agqr)paramaezf;
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561830, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramaezf;
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView = ((AnimationTextView)paramaezf.findViewById(2131364444));
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(BaseChatItemLayout.e);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramafce);
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramafce);
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).onDoubleClick = new agqo(this);
    }
    return paramaezf;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(agqr paramagqr, MessageForText paramMessageForText)
  {
    if (paramagqr == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramagqr.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramagqr.jdField_a_of_type_Boolean)
        {
          paramagqr.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramagqr.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramagqr.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramagqr.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramagqr.g);
          }
          if (paramagqr.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = lam.a(localContext);
          paramMessageForText = null;
          lae locallae = lai.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (locallae != null) {
            paramMessageForText = locallae.a(paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramagqr.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!lai.a(localContext).b(str, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long)))
          {
            i += 1;
            lai.a(localContext).b(str, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          lai.a(localContext).a(str, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long, paramMessageForText.a());
          paramagqr.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131716217);
    return;
    label340:
    h += 1;
    paramagqr.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramagqr, paramagqr.jdField_b_of_type_JavaLangString, Language.fromString(str), new agqq(this, paramagqr, localContext, str)).booleanValue())
    {
      b(paramagqr);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131716217);
        return;
      }
      a(2131716219);
      return;
    }
    a(paramagqr);
    lai.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long, Boolean.valueOf(true));
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    String str = paramChatMessage.msg;
    lae locallae;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = lam.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      locallae = lai.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallae == null) {
        break label142;
      }
    }
    label142:
    for (paramString = locallae.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bkov.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364441) || (paramView.getId() == 2131364444))
    {
      MessageForText localMessageForText = (MessageForText)AIOUtils.getMessage(paramView);
      a((agqr)AIOUtils.getHolder(paramView), localMessageForText);
      AIOUtils.isUserOperatedInAIO = true;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqn
 * JD-Core Version:    0.7.0.1
 */