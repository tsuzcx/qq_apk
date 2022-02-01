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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class ahkp
  extends ahkf
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  laj jdField_a_of_type_Laj;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public ahkp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        bctj.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        bctj.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        bctj.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(ahkt paramahkt)
  {
    paramahkt.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramahkt.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramahkt.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramahkt.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramahkt.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(ahkt paramahkt, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramahkt == null) {
      return;
    }
    if (paramahkt.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramahkt.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramahkt.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramahkt.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramahkt.d != null)
    {
      paramahkt.d.clearAnimation();
      paramahkt.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramahkt.d.setAlpha(1.0F);
      }
    }
    Object localObject = lao.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!lak.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramahkt.jdField_c_of_type_JavaLangString, paramahkt.jdField_b_of_type_Long))
    {
      b(paramahkt);
      this.jdField_a_of_type_Laj = null;
      if (paramahkt.e == 100000)
      {
        lag locallag = lak.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallag != null) {
          this.jdField_a_of_type_Laj = locallag.a(str, paramahkt.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Laj == null) || (!this.jdField_a_of_type_Laj.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramahkt.jdField_a_of_type_Apwt = apxt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bgsg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramahkt.e == 100000) && (paramMessageForText.msgtype == -1000))
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
      paramBaseChatItemLayout.a.setText(2131718669);
      bgsg.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramahkt.jdField_b_of_type_Long;
      bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramahkt.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131718669);
        return;
        a(paramahkt);
        break;
        paramahkt.jdField_a_of_type_Apwt = apxt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, ahkt paramahkt)
  {
    paramahkt.jdField_c_of_type_AndroidViewView = paramahkt.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379112);
    paramahkt.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramahkt.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379111));
    paramahkt.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130847011);
  }
  
  private void b(ahkt paramahkt)
  {
    paramahkt.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramahkt.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramahkt.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramahkt.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramahkt.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(ahkt paramahkt, MessageForText paramMessageForText)
  {
    paramahkt.e = ((int)paramMessageForText.vipBubbleID);
    paramahkt.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramahkt.f = paramMessageForText.istroop;
    paramahkt.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramahkt.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(ahkt paramahkt, MessageForText paramMessageForText)
  {
    int j = 0;
    paramahkt.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramahkt.e == 100000)
    {
      paramahkt.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = lao.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Laj = null;
      lag locallag = lak.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallag != null) {
        this.jdField_a_of_type_Laj = locallag.a(paramMessageForText.msg, paramahkt.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Laj != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Laj.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramahkt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Laj.a();
            localObject1 = new bdnt(paramahkt.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramahkt.e == 100000)
    {
      localObject2 = paramahkt.jdField_b_of_type_JavaLangString;
      if (paramahkt.g == 0) {
        paramahkt.d.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Laj == null) || (paramahkt.g != 1)) {
        return;
      }
      paramMessageForText = paramahkt.d.getText();
      int m = paramahkt.d.getMeasuredWidth();
      int k = paramahkt.d.getMeasuredHeight();
      paramahkt.d.setText((CharSequence)localObject1);
      paramahkt.d.measure(0, 0);
      if (paramahkt.d.getMeasuredWidth() < BaseChatItemLayout.e) {
        j = paramahkt.d.getMeasuredWidth() - m;
      }
      m = paramahkt.d.getMeasuredHeight();
      paramahkt.d.setText(paramMessageForText);
      paramMessageForText = new lap(paramahkt.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new ahkr(this, paramahkt, (CharSequence)localObject1));
      paramahkt.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramahkt.d.setText((CharSequence)localObject1);
  }
  
  public afwr a()
  {
    return new ahkt(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    paramViewGroup = (ahkt)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (ahkt)paramafwr;
    paramafwr = paramView;
    if (paramView == null)
    {
      paramafwr = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561913, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramafwr;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramafwr.findViewById(2131364382));
      paramBaseChatItemLayout.d.setMaxWidth(BaseChatItemLayout.e);
      paramBaseChatItemLayout.d.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.d.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramBaseChatItemLayout.d.setOnTouchListener(paramafzq);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramafzq);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new ahkq(this);
    }
    return paramafwr;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(ahkt paramahkt, MessageForText paramMessageForText)
  {
    if (paramahkt == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramahkt.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramahkt.jdField_a_of_type_Boolean)
        {
          paramahkt.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramahkt.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramahkt.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramahkt.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramahkt.g);
          }
          if (paramahkt.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = lao.a(localContext);
          paramMessageForText = null;
          lag locallag = lak.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (locallag != null) {
            paramMessageForText = locallag.a(paramahkt.jdField_c_of_type_JavaLangString, paramahkt.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramahkt.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!lak.a(localContext).b(str, paramahkt.jdField_c_of_type_JavaLangString, paramahkt.jdField_b_of_type_Long)))
          {
            i += 1;
            lak.a(localContext).b(str, paramahkt.jdField_c_of_type_JavaLangString, paramahkt.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          lak.a(localContext).a(str, paramahkt.jdField_c_of_type_JavaLangString, paramahkt.jdField_b_of_type_Long, paramMessageForText.a());
          paramahkt.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131715874);
    return;
    label340:
    h += 1;
    paramahkt.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramahkt, paramahkt.jdField_b_of_type_JavaLangString, Language.fromString(str), new ahks(this, paramahkt, localContext, str)).booleanValue())
    {
      b(paramahkt);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131715874);
        return;
      }
      a(2131715876);
      return;
    }
    a(paramahkt);
    lak.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramahkt.jdField_c_of_type_JavaLangString, paramahkt.jdField_b_of_type_Long, Boolean.valueOf(true));
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
    lag locallag;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = lao.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      locallag = lak.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallag == null) {
        break label142;
      }
    }
    label142:
    for (paramString = locallag.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bljl.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364379) || (paramView.getId() == 2131364382))
    {
      MessageForText localMessageForText = (MessageForText)afur.a(paramView);
      a((ahkt)afur.a(paramView), localMessageForText);
      afur.n = true;
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
 * Qualified Name:     ahkp
 * JD-Core Version:    0.7.0.1
 */