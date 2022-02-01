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

public class ahjd
  extends ahit
{
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  lak jdField_a_of_type_Lak;
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public ahjd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.b.setDuration(150L);
    this.b.setFillAfter(true);
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
  
  private static int a(Context paramContext, double paramDouble)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramDouble);
  }
  
  private void a(ahjf paramahjf)
  {
    if (paramahjf.jdField_c_of_type_AndroidViewView != null) {
      paramahjf.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (paramahjf.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView != null) {
      paramahjf.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    }
    if (paramahjf.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramahjf.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramahjf.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramahjf.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(this.jdField_a_of_type_AndroidContentContext, 1.5D), a(this.jdField_a_of_type_AndroidContentContext, 4.0D));
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(ahjf paramahjf, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramahjf == null) {
      return;
    }
    if (paramahjf.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramahjf.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramahjf.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramahjf.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramahjf.d != null)
    {
      paramahjf.d.clearAnimation();
      paramahjf.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramahjf.d.setAlpha(1.0F);
      }
    }
    Object localObject = lap.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long))
    {
      b(this.jdField_a_of_type_AndroidContentContext, paramahjf);
      this.jdField_a_of_type_Lak = null;
      a(paramahjf, paramMessageForText, str, (String)localObject);
      this.f = bhhr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramahjf.e == 100000) && (paramMessageForText.msgtype == -1000))
      {
        paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a, null);
        if (!paramMessageForText.isSend()) {
          break label388;
        }
      }
    }
    label388:
    for (int j = 1;; j = 0)
    {
      paramBaseChatItemLayout.setHearIconPosition(j);
      paramBaseChatItemLayout.a.setText(2131719459);
      bhhr.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramahjf.jdField_b_of_type_Long;
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramahjf.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131719459);
        return;
        a(paramahjf);
        break;
      }
    }
  }
  
  private void a(ahjf paramahjf, MessageForText paramMessageForText, String paramString1, String paramString2)
  {
    if (paramahjf.e == 100000)
    {
      lah locallah = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallah != null) {
        this.jdField_a_of_type_Lak = locallah.a(paramString1, paramahjf.jdField_b_of_type_Long, paramString2);
      }
      if ((this.jdField_a_of_type_Lak != null) && (this.jdField_a_of_type_Lak.a().booleanValue()) && (!paramMessageForText.isSend())) {
        paramahjf.jdField_a_of_type_Aqhi = aqii.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
    }
    else
    {
      return;
    }
    paramahjf.jdField_a_of_type_Aqhi = aqii.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, ahjf paramahjf)
  {
    paramahjf.jdField_c_of_type_AndroidViewView = paramahjf.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379342);
    paramahjf.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramahjf.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379341));
    paramahjf.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130847033);
  }
  
  private boolean a(ahjf paramahjf, MessageForText paramMessageForText)
  {
    if (paramMessageForText.isSend()) {
      return true;
    }
    if (paramahjf.jdField_a_of_type_Boolean)
    {
      paramahjf.jdField_a_of_type_Boolean = false;
      return true;
    }
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramahjf.jdField_b_of_type_Long)) == null) {}
    for (long l1 = 0L; l2 - l1 < 800L; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramahjf.jdField_b_of_type_Long))).longValue()) {
      return true;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramahjf.jdField_b_of_type_Long), Long.valueOf(l2));
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "on click translate status:" + paramahjf.g);
    }
    return paramahjf.g != 0;
  }
  
  private void b(ahjf paramahjf, MessageForText paramMessageForText)
  {
    paramahjf.e = ((int)paramMessageForText.vipBubbleID);
    paramahjf.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramahjf.f = paramMessageForText.istroop;
    paramahjf.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramahjf.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private static void b(Context paramContext, ahjf paramahjf)
  {
    if (paramahjf.jdField_c_of_type_AndroidViewView != null) {
      paramahjf.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahjf.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView != null) {
      paramahjf.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    }
    if (paramahjf.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramahjf.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramahjf.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramahjf.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(paramContext, 14.0D), a(paramContext, 5.0D));
    }
  }
  
  private void c(ahjf paramahjf, MessageForText paramMessageForText)
  {
    int j = 0;
    paramahjf.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    CharSequence localCharSequence = paramMessageForText.sb;
    Object localObject = localCharSequence;
    if (paramahjf.e == 100000)
    {
      paramahjf.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject = lap.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Lak = null;
      lah locallah = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallah != null) {
        this.jdField_a_of_type_Lak = locallah.a(paramMessageForText.msg, paramahjf.jdField_b_of_type_Long, (String)localObject);
      }
      localObject = localCharSequence;
      if (this.jdField_a_of_type_Lak != null)
      {
        localObject = localCharSequence;
        if (this.jdField_a_of_type_Lak.a().booleanValue())
        {
          localObject = localCharSequence;
          if (!paramMessageForText.isSend())
          {
            paramahjf.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lak.a();
            localObject = new QQText(paramahjf.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramahjf.e == 100000)
    {
      if (paramahjf.g == 0) {
        paramahjf.d.setText((CharSequence)localObject);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Lak == null) || (paramahjf.g != 1)) {
        return;
      }
      paramMessageForText = paramahjf.d.getText();
      int m = paramahjf.d.getMeasuredWidth();
      int k = paramahjf.d.getMeasuredHeight();
      paramahjf.d.setText((CharSequence)localObject);
      paramahjf.d.measure(0, 0);
      if (paramahjf.d.getMeasuredWidth() < BaseChatItemLayout.e) {
        j = paramahjf.d.getMeasuredWidth() - m;
      }
      m = paramahjf.d.getMeasuredHeight();
      paramahjf.d.setText(paramMessageForText);
      paramMessageForText = new laq(paramahjf.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new ahjg((CharSequence)localObject, paramahjf, this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation, this.b));
      paramahjf.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramahjf.d.setText((CharSequence)localObject);
  }
  
  public afqr a()
  {
    return new ahjf(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramViewGroup = (ahjf)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (ahjf)paramafqr;
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561898, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramafqr;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramafqr.findViewById(2131364525));
      paramBaseChatItemLayout.d.setMaxWidth(BaseChatItemLayout.e);
      paramBaseChatItemLayout.d.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.d.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramBaseChatItemLayout.d.setOnTouchListener(paramaftk);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramaftk);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new ahje(this);
    }
    return paramafqr;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(ahjf paramahjf, MessageForText paramMessageForText)
  {
    if (paramahjf == null) {}
    while ((paramahjf.e != 100000) || (paramMessageForText.msgtype != -1000) || (a(paramahjf, paramMessageForText))) {
      return;
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = lap.a(localContext);
    paramMessageForText = null;
    lah locallah = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (locallah != null) {
      paramMessageForText = locallah.a(paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long, str);
    }
    if (paramMessageForText != null)
    {
      if (!paramMessageForText.a().equalsIgnoreCase(paramahjf.jdField_c_of_type_JavaLangString))
      {
        if ((paramMessageForText.a().booleanValue()) && (!lal.a(localContext).b(str, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long)))
        {
          i += 1;
          lal.a(localContext).b(str, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long, Boolean.valueOf(true));
        }
        paramMessageForText.a();
        lal.a(localContext).a(str, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long, paramMessageForText.a());
        paramahjf.g = 1;
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        return;
      }
      a(2131716578);
      return;
    }
    h += 1;
    paramahjf.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramahjf, paramahjf.jdField_b_of_type_JavaLangString, Language.fromString(str), new ahjh(this.jdField_a_of_type_AndroidContentContext, paramahjf, str, this.jdField_a_of_type_AndroidWidgetBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).booleanValue())
    {
      b(this.jdField_a_of_type_AndroidContentContext, paramahjf);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131716578);
        return;
      }
      a(2131716580);
      return;
    }
    a(paramahjf);
    lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long, Boolean.valueOf(true));
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
    lah locallah;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = lap.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      locallah = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallah == null) {
        break label142;
      }
    }
    label142:
    for (paramString = locallah.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        bmad.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
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
    if ((paramView.getId() == 2131364522) || (paramView.getId() == 2131364525))
    {
      MessageForText localMessageForText = (MessageForText)AIOUtils.getMessage(paramView);
      a((ahjf)AIOUtils.getHolder(paramView), localMessageForText);
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
 * Qualified Name:     ahjd
 * JD-Core Version:    0.7.0.1
 */