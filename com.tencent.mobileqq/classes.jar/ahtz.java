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

public class ahtz
  extends ahtp
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  laq jdField_a_of_type_Laq;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public ahtz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        bdmc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        bdmc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        bdmc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(ahud paramahud)
  {
    paramahud.jdField_d_of_type_AndroidViewView.setVisibility(0);
    paramahud.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramahud.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramahud.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramahud.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(ahud paramahud, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramahud == null) {
      return;
    }
    if (paramahud.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramahud.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramahud.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramahud.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramahud.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      paramahud.jdField_d_of_type_AndroidWidgetTextView.clearAnimation();
      paramahud.jdField_d_of_type_AndroidWidgetTextView.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramahud.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    Object localObject = lav.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long))
    {
      b(paramahud);
      this.jdField_a_of_type_Laq = null;
      if (paramahud.e == 100000)
      {
        lan locallan = lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallan != null) {
          this.jdField_a_of_type_Laq = locallan.a(str, paramahud.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Laq == null) || (!this.jdField_a_of_type_Laq.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramahud.jdField_a_of_type_Aqkt = aqlt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bhsi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramahud.e == 100000) && (paramMessageForText.msgtype == -1000))
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
      paramBaseChatItemLayout.a.setText(2131718805);
      bhsi.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramahud.jdField_b_of_type_Long;
      bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramahud.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131718805);
        return;
        a(paramahud);
        break;
        paramahud.jdField_a_of_type_Aqkt = aqlt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, ahud paramahud)
  {
    paramahud.jdField_d_of_type_AndroidViewView = paramahud.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379276);
    paramahud.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramahud.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379275));
    paramahud.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130847028);
  }
  
  private void b(ahud paramahud)
  {
    paramahud.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramahud.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramahud.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramahud.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramahud.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(ahud paramahud, MessageForText paramMessageForText)
  {
    paramahud.e = ((int)paramMessageForText.vipBubbleID);
    paramahud.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramahud.f = paramMessageForText.istroop;
    paramahud.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramahud.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(ahud paramahud, MessageForText paramMessageForText)
  {
    int j = 0;
    paramahud.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramahud.e == 100000)
    {
      paramahud.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = lav.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Laq = null;
      lan locallan = lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallan != null) {
        this.jdField_a_of_type_Laq = locallan.a(paramMessageForText.msg, paramahud.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Laq != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Laq.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramahud.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Laq.a();
            localObject1 = new begp(paramahud.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramahud.e == 100000)
    {
      localObject2 = paramahud.jdField_b_of_type_JavaLangString;
      if (paramahud.g == 0) {
        paramahud.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Laq == null) || (paramahud.g != 1)) {
        return;
      }
      paramMessageForText = paramahud.jdField_d_of_type_AndroidWidgetTextView.getText();
      int m = paramahud.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int k = paramahud.jdField_d_of_type_AndroidWidgetTextView.getMeasuredHeight();
      paramahud.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramahud.jdField_d_of_type_AndroidWidgetTextView.measure(0, 0);
      if (paramahud.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() < BaseChatItemLayout.e) {
        j = paramahud.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() - m;
      }
      m = paramahud.jdField_d_of_type_AndroidWidgetTextView.getMeasuredHeight();
      paramahud.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForText);
      paramMessageForText = new law(paramahud.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new ahub(this, paramahud, (CharSequence)localObject1));
      paramahud.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramahud.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
  }
  
  public aggl a()
  {
    return new ahud(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramViewGroup = (ahud)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (ahud)paramaggl;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561953, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramaggl;
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView = ((AnimationTextView)paramaggl.findViewById(2131364426));
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(BaseChatItemLayout.e);
      paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramagjk);
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramagjk);
    paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.jdField_d_of_type_AndroidWidgetTextView).onDoubleClick = new ahua(this);
    }
    return paramaggl;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(ahud paramahud, MessageForText paramMessageForText)
  {
    if (paramahud == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramahud.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramahud.jdField_a_of_type_Boolean)
        {
          paramahud.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramahud.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramahud.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramahud.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramahud.g);
          }
          if (paramahud.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = lav.a(localContext);
          paramMessageForText = null;
          lan locallan = lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (locallan != null) {
            paramMessageForText = locallan.a(paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramahud.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!lar.a(localContext).b(str, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long)))
          {
            i += 1;
            lar.a(localContext).b(str, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          lar.a(localContext).a(str, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long, paramMessageForText.a());
          paramahud.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131715983);
    return;
    label340:
    h += 1;
    paramahud.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramahud, paramahud.jdField_b_of_type_JavaLangString, Language.fromString(str), new ahuc(this, paramahud, localContext, str)).booleanValue())
    {
      b(paramahud);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131715983);
        return;
      }
      a(2131715985);
      return;
    }
    a(paramahud);
    lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long, Boolean.valueOf(true));
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
    lan locallan;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = lav.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      locallan = lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallan == null) {
        break label142;
      }
    }
    label142:
    for (paramString = locallan.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bmko.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
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
    if ((paramView.getId() == 2131364423) || (paramView.getId() == 2131364426))
    {
      MessageForText localMessageForText = (MessageForText)agej.a(paramView);
      a((ahud)agej.a(paramView), localMessageForText);
      agej.n = true;
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
 * Qualified Name:     ahtz
 * JD-Core Version:    0.7.0.1
 */