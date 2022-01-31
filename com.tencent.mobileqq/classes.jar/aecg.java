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

public class aecg
  extends aebx
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  lbi jdField_a_of_type_Lbi;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public aecg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        axrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        axrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        axrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(aeck paramaeck)
  {
    paramaeck.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramaeck.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramaeck.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramaeck.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramaeck.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(aeck paramaeck, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramaeck == null) {
      return;
    }
    if (paramaeck.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramaeck.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramaeck.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramaeck.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramaeck.d != null)
    {
      paramaeck.d.clearAnimation();
      paramaeck.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramaeck.d.setAlpha(1.0F);
      }
    }
    Object localObject = lbn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long))
    {
      b(paramaeck);
      this.jdField_a_of_type_Lbi = null;
      if (paramaeck.e == 100000)
      {
        lbf locallbf = lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallbf != null) {
          this.jdField_a_of_type_Lbi = locallbf.a(str, paramaeck.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Lbi == null) || (!this.jdField_a_of_type_Lbi.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramaeck.jdField_a_of_type_Ambg = amcg.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bbkb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramaeck.e == 100000) && (paramMessageForText.msgtype == -1000))
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
      paramBaseChatItemLayout.a.setText(2131720397);
      bbkb.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramaeck.jdField_b_of_type_Long;
      axrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramaeck.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131720397);
        return;
        a(paramaeck);
        break;
        paramaeck.jdField_a_of_type_Ambg = amcg.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, aeck paramaeck)
  {
    paramaeck.jdField_c_of_type_AndroidViewView = paramaeck.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377663);
    paramaeck.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramaeck.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377662));
    paramaeck.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130846118);
  }
  
  private void b(aeck paramaeck)
  {
    paramaeck.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramaeck.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramaeck.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramaeck.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramaeck.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(aeck paramaeck, MessageForText paramMessageForText)
  {
    paramaeck.e = ((int)paramMessageForText.vipBubbleID);
    paramaeck.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramaeck.f = paramMessageForText.istroop;
    paramaeck.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramaeck.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(aeck paramaeck, MessageForText paramMessageForText)
  {
    int j = 0;
    paramaeck.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramaeck.e == 100000)
    {
      paramaeck.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = lbn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Lbi = null;
      lbf locallbf = lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallbf != null) {
        this.jdField_a_of_type_Lbi = locallbf.a(paramMessageForText.msg, paramaeck.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Lbi != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Lbi.a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramaeck.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lbi.a();
            localObject1 = new aykk(paramaeck.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramaeck.e == 100000)
    {
      localObject2 = paramaeck.jdField_b_of_type_JavaLangString;
      if (paramaeck.g == 0) {
        paramaeck.d.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Lbi == null) || (paramaeck.g != 1)) {
        return;
      }
      paramMessageForText = paramaeck.d.getText();
      int m = paramaeck.d.getMeasuredWidth();
      int k = paramaeck.d.getMeasuredHeight();
      paramaeck.d.setText((CharSequence)localObject1);
      paramaeck.d.measure(0, 0);
      if (paramaeck.d.getMeasuredWidth() < BaseChatItemLayout.d) {
        j = paramaeck.d.getMeasuredWidth() - m;
      }
      m = paramaeck.d.getMeasuredHeight();
      paramaeck.d.setText(paramMessageForText);
      paramMessageForText = new lbo(paramaeck.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new aeci(this, paramaeck, (CharSequence)localObject1));
      paramaeck.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramaeck.d.setText((CharSequence)localObject1);
  }
  
  public acuj a()
  {
    return new aeck(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramViewGroup = (aeck)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (aeck)paramacuj;
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561468, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramacuj;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramacuj.findViewById(2131364112));
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
    paramBaseChatItemLayout.d.setOnTouchListener(paramacxj);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramacxj);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new aech(this);
    }
    return paramacuj;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(aeck paramaeck, MessageForText paramMessageForText)
  {
    if (paramaeck == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramaeck.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramaeck.jdField_a_of_type_Boolean)
        {
          paramaeck.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramaeck.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramaeck.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramaeck.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramaeck.g);
          }
          if (paramaeck.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = lbn.a(localContext);
          paramMessageForText = null;
          lbf locallbf = lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (locallbf != null) {
            paramMessageForText = locallbf.a(paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramaeck.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!lbj.a(localContext).b(str, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long)))
          {
            i += 1;
            lbj.a(localContext).b(str, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          lbj.a(localContext).a(str, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long, paramMessageForText.a());
          paramaeck.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131717265);
    return;
    label340:
    h += 1;
    paramaeck.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramaeck, paramaeck.jdField_b_of_type_JavaLangString, Language.fromString(str), new aecj(this, paramaeck, localContext, str)).booleanValue())
    {
      b(paramaeck);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131717265);
        return;
      }
      a(2131717267);
      return;
    }
    a(paramaeck);
    lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long, Boolean.valueOf(true));
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
    lbf locallbf;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = lbn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      locallbf = lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallbf == null) {
        break label142;
      }
    }
    label142:
    for (paramString = locallbf.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bgpu.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364109) || (paramView.getId() == 2131364112))
    {
      MessageForText localMessageForText = (MessageForText)actj.a(paramView);
      a((aeck)actj.a(paramView), localMessageForText);
      actj.n = true;
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecg
 * JD-Core Version:    0.7.0.1
 */