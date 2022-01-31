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

public class afyu
  extends afyl
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  ldm jdField_a_of_type_Ldm;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public afyu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        azmz.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        azmz.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        azmz.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(afyy paramafyy)
  {
    paramafyy.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramafyy.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramafyy.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramafyy.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramafyy.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(afyy paramafyy, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramafyy == null) {
      return;
    }
    if (paramafyy.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramafyy.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramafyy.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramafyy.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramafyy.d != null)
    {
      paramafyy.d.clearAnimation();
      paramafyy.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramafyy.d.setAlpha(1.0F);
      }
    }
    Object localObject = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramafyy.jdField_c_of_type_JavaLangString, paramafyy.jdField_b_of_type_Long))
    {
      b(paramafyy);
      this.jdField_a_of_type_Ldm = null;
      if (paramafyy.e == 100000)
      {
        ldj localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localldj != null) {
          this.jdField_a_of_type_Ldm = localldj.a(str, paramafyy.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Ldm == null) || (!this.jdField_a_of_type_Ldm.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramafyy.jdField_a_of_type_Ansf = antf.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bdiv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramafyy.e == 100000) && (paramMessageForText.msgtype == -1000))
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
      paramBaseChatItemLayout.a.setText(2131720933);
      bdiv.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramafyy.jdField_b_of_type_Long;
      azmz.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramafyy.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131720933);
        return;
        a(paramafyy);
        break;
        paramafyy.jdField_a_of_type_Ansf = antf.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, afyy paramafyy)
  {
    paramafyy.jdField_c_of_type_AndroidViewView = paramafyy.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378204);
    paramafyy.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramafyy.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378203));
    paramafyy.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130846497);
  }
  
  private void b(afyy paramafyy)
  {
    paramafyy.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramafyy.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramafyy.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramafyy.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramafyy.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(afyy paramafyy, MessageForText paramMessageForText)
  {
    paramafyy.e = ((int)paramMessageForText.vipBubbleID);
    paramafyy.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramafyy.f = paramMessageForText.istroop;
    paramafyy.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramafyy.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(afyy paramafyy, MessageForText paramMessageForText)
  {
    int j = 0;
    paramafyy.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramafyy.e == 100000)
    {
      paramafyy.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Ldm = null;
      ldj localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localldj != null) {
        this.jdField_a_of_type_Ldm = localldj.a(paramMessageForText.msg, paramafyy.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Ldm != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ldm.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramafyy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Ldm.a();
            localObject1 = new baig(paramafyy.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramafyy.e == 100000)
    {
      localObject2 = paramafyy.jdField_b_of_type_JavaLangString;
      if (paramafyy.g == 0) {
        paramafyy.d.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Ldm == null) || (paramafyy.g != 1)) {
        return;
      }
      paramMessageForText = paramafyy.d.getText();
      int m = paramafyy.d.getMeasuredWidth();
      int k = paramafyy.d.getMeasuredHeight();
      paramafyy.d.setText((CharSequence)localObject1);
      paramafyy.d.measure(0, 0);
      if (paramafyy.d.getMeasuredWidth() < BaseChatItemLayout.d) {
        j = paramafyy.d.getMeasuredWidth() - m;
      }
      m = paramafyy.d.getMeasuredHeight();
      paramafyy.d.setText(paramMessageForText);
      paramMessageForText = new lds(paramafyy.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new afyw(this, paramafyy, (CharSequence)localObject1));
      paramafyy.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramafyy.d.setText((CharSequence)localObject1);
  }
  
  public aelt a()
  {
    return new afyy(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramViewGroup = (afyy)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (afyy)paramaelt;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561658, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramaelt;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramaelt.findViewById(2131364174));
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
    paramBaseChatItemLayout.d.setOnTouchListener(paramaeov);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramaeov);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new afyv(this);
    }
    return paramaelt;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(afyy paramafyy, MessageForText paramMessageForText)
  {
    if (paramafyy == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramafyy.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramafyy.jdField_a_of_type_Boolean)
        {
          paramafyy.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramafyy.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramafyy.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramafyy.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramafyy.g);
          }
          if (paramafyy.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = ldr.a(localContext);
          paramMessageForText = null;
          ldj localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (localldj != null) {
            paramMessageForText = localldj.a(paramafyy.jdField_c_of_type_JavaLangString, paramafyy.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramafyy.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!ldn.a(localContext).b(str, paramafyy.jdField_c_of_type_JavaLangString, paramafyy.jdField_b_of_type_Long)))
          {
            i += 1;
            ldn.a(localContext).b(str, paramafyy.jdField_c_of_type_JavaLangString, paramafyy.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          ldn.a(localContext).a(str, paramafyy.jdField_c_of_type_JavaLangString, paramafyy.jdField_b_of_type_Long, paramMessageForText.a());
          paramafyy.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131717637);
    return;
    label340:
    h += 1;
    paramafyy.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramafyy, paramafyy.jdField_b_of_type_JavaLangString, Language.fromString(str), new afyx(this, paramafyy, localContext, str)).booleanValue())
    {
      b(paramafyy);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131717637);
        return;
      }
      a(2131717639);
      return;
    }
    a(paramafyy);
    ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramafyy.jdField_c_of_type_JavaLangString, paramafyy.jdField_b_of_type_Long, Boolean.valueOf(true));
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
    ldj localldj;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localldj == null) {
        break label142;
      }
    }
    label142:
    for (paramString = localldj.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        biqt.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364171) || (paramView.getId() == 2131364174))
    {
      MessageForText localMessageForText = (MessageForText)aekt.a(paramView);
      a((afyy)aekt.a(paramView), localMessageForText);
      aekt.n = true;
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyu
 * JD-Core Version:    0.7.0.1
 */