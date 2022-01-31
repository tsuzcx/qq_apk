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

public class adrj
  extends adra
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  kqz jdField_a_of_type_Kqz;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public adrj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        awrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        awrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        awrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(adrn paramadrn)
  {
    paramadrn.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramadrn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramadrn.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramadrn.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramadrn.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(adrn paramadrn, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramadrn == null) {
      return;
    }
    if (paramadrn.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramadrn.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramadrn.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramadrn.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramadrn.d != null)
    {
      paramadrn.d.clearAnimation();
      paramadrn.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramadrn.d.setAlpha(1.0F);
      }
    }
    Object localObject = kre.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramadrn.jdField_c_of_type_JavaLangString, paramadrn.jdField_b_of_type_Long))
    {
      b(paramadrn);
      this.jdField_a_of_type_Kqz = null;
      if (paramadrn.e == 100000)
      {
        kqw localkqw = kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localkqw != null) {
          this.jdField_a_of_type_Kqz = localkqw.a(str, paramadrn.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Kqz == null) || (!this.jdField_a_of_type_Kqz.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramadrn.jdField_a_of_type_Almt = alnt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = baig.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramadrn.e == 100000) && (paramMessageForText.msgtype == -1000))
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
      paramBaseChatItemLayout.a.setText(2131654490);
      baig.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramadrn.jdField_b_of_type_Long;
      awrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramadrn.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131654490);
        return;
        a(paramadrn);
        break;
        paramadrn.jdField_a_of_type_Almt = alnt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, adrn paramadrn)
  {
    paramadrn.jdField_c_of_type_AndroidViewView = paramadrn.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311847);
    paramadrn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramadrn.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311846));
    paramadrn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130845931);
  }
  
  private void b(adrn paramadrn)
  {
    paramadrn.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramadrn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramadrn.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramadrn.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramadrn.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(adrn paramadrn, MessageForText paramMessageForText)
  {
    paramadrn.e = ((int)paramMessageForText.vipBubbleID);
    paramadrn.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramadrn.f = paramMessageForText.istroop;
    paramadrn.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramadrn.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(adrn paramadrn, MessageForText paramMessageForText)
  {
    int j = 0;
    paramadrn.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramadrn.e == 100000)
    {
      paramadrn.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = kre.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Kqz = null;
      kqw localkqw = kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localkqw != null) {
        this.jdField_a_of_type_Kqz = localkqw.a(paramMessageForText.msg, paramadrn.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Kqz != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Kqz.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramadrn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Kqz.a();
            localObject1 = new axkd(paramadrn.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramadrn.e == 100000)
    {
      localObject2 = paramadrn.jdField_b_of_type_JavaLangString;
      if (paramadrn.g == 0) {
        paramadrn.d.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Kqz == null) || (paramadrn.g != 1)) {
        return;
      }
      paramMessageForText = paramadrn.d.getText();
      int m = paramadrn.d.getMeasuredWidth();
      int k = paramadrn.d.getMeasuredHeight();
      paramadrn.d.setText((CharSequence)localObject1);
      paramadrn.d.measure(0, 0);
      if (paramadrn.d.getMeasuredWidth() < BaseChatItemLayout.d) {
        j = paramadrn.d.getMeasuredWidth() - m;
      }
      m = paramadrn.d.getMeasuredHeight();
      paramadrn.d.setText(paramMessageForText);
      paramMessageForText = new krf(paramadrn.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new adrl(this, paramadrn, (CharSequence)localObject1));
      paramadrn.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramadrn.d.setText((CharSequence)localObject1);
  }
  
  public acju a()
  {
    return new adrn(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramViewGroup = (adrn)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (adrn)paramacju;
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131495878, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramacju;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramacju.findViewById(2131298555));
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
    paramBaseChatItemLayout.d.setOnTouchListener(paramacmv);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramacmv);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).a = new adrk(this);
    }
    return paramacju;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(adrn paramadrn, MessageForText paramMessageForText)
  {
    if (paramadrn == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramadrn.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramadrn.jdField_a_of_type_Boolean)
        {
          paramadrn.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramadrn.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramadrn.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramadrn.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramadrn.g);
          }
          if (paramadrn.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = kre.a(localContext);
          paramMessageForText = null;
          kqw localkqw = kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (localkqw != null) {
            paramMessageForText = localkqw.a(paramadrn.jdField_c_of_type_JavaLangString, paramadrn.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramadrn.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!kra.a(localContext).b(str, paramadrn.jdField_c_of_type_JavaLangString, paramadrn.jdField_b_of_type_Long)))
          {
            i += 1;
            kra.a(localContext).b(str, paramadrn.jdField_c_of_type_JavaLangString, paramadrn.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          kra.a(localContext).a(str, paramadrn.jdField_c_of_type_JavaLangString, paramadrn.jdField_b_of_type_Long, paramMessageForText.a());
          paramadrn.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131651462);
    return;
    label340:
    h += 1;
    paramadrn.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramadrn, paramadrn.jdField_b_of_type_JavaLangString, Language.fromString(str), new adrm(this, paramadrn, localContext, str)).booleanValue())
    {
      b(paramadrn);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131651462);
        return;
      }
      a(2131651464);
      return;
    }
    a(paramadrn);
    kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramadrn.jdField_c_of_type_JavaLangString, paramadrn.jdField_b_of_type_Long, Boolean.valueOf(true));
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
    kqw localkqw;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = kre.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localkqw = kra.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localkqw == null) {
        break label142;
      }
    }
    label142:
    for (paramString = localkqw.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bfhl.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131298552) || (paramView.getId() == 2131298555))
    {
      MessageForText localMessageForText = (MessageForText)aciy.a(paramView);
      a((adrn)aciy.a(paramView), localMessageForText);
      aciy.n = true;
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrj
 * JD-Core Version:    0.7.0.1
 */