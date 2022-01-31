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

public class agdj
  extends agda
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
  
  public agdj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
        azri.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
      }
      if (i != 0) {
        azri.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
      }
      if (g != 0) {
        azri.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
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
  
  private void a(agdn paramagdn)
  {
    paramagdn.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramagdn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramagdn.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramagdn.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramagdn.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(agdn paramagdn, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramagdn == null) {
      return;
    }
    if (paramagdn.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramagdn.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramagdn.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramagdn.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramagdn.d != null)
    {
      paramagdn.d.clearAnimation();
      paramagdn.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramagdn.d.setAlpha(1.0F);
      }
    }
    Object localObject = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long))
    {
      b(paramagdn);
      this.jdField_a_of_type_Ldm = null;
      if (paramagdn.e == 100000)
      {
        ldj localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localldj != null) {
          this.jdField_a_of_type_Ldm = localldj.a(str, paramagdn.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_Ldm == null) || (!this.jdField_a_of_type_Ldm.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        paramagdn.jdField_a_of_type_Anwo = anxo.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
      label243:
      this.f = bdne.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramagdn.e == 100000) && (paramMessageForText.msgtype == -1000))
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
      paramBaseChatItemLayout.a.setText(2131720945);
      bdne.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramagdn.jdField_b_of_type_Long;
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramagdn.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131720945);
        return;
        a(paramagdn);
        break;
        paramagdn.jdField_a_of_type_Anwo = anxo.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break label243;
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, agdn paramagdn)
  {
    paramagdn.jdField_c_of_type_AndroidViewView = paramagdn.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378258);
    paramagdn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramagdn.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378257));
    paramagdn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130846570);
  }
  
  private void b(agdn paramagdn)
  {
    paramagdn.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramagdn.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramagdn.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramagdn.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramagdn.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(agdn paramagdn, MessageForText paramMessageForText)
  {
    paramagdn.e = ((int)paramMessageForText.vipBubbleID);
    paramagdn.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramagdn.f = paramMessageForText.istroop;
    paramagdn.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramagdn.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(agdn paramagdn, MessageForText paramMessageForText)
  {
    int j = 0;
    paramagdn.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramagdn.e == 100000)
    {
      paramagdn.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_Ldm = null;
      ldj localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localldj != null) {
        this.jdField_a_of_type_Ldm = localldj.a(paramMessageForText.msg, paramagdn.jdField_b_of_type_Long, (String)localObject1);
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
            paramagdn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Ldm.a();
            localObject1 = new bamp(paramagdn.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramagdn.e == 100000)
    {
      localObject2 = paramagdn.jdField_b_of_type_JavaLangString;
      if (paramagdn.g == 0) {
        paramagdn.d.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_Ldm == null) || (paramagdn.g != 1)) {
        return;
      }
      paramMessageForText = paramagdn.d.getText();
      int m = paramagdn.d.getMeasuredWidth();
      int k = paramagdn.d.getMeasuredHeight();
      paramagdn.d.setText((CharSequence)localObject1);
      paramagdn.d.measure(0, 0);
      if (paramagdn.d.getMeasuredWidth() < BaseChatItemLayout.d) {
        j = paramagdn.d.getMeasuredWidth() - m;
      }
      m = paramagdn.d.getMeasuredHeight();
      paramagdn.d.setText(paramMessageForText);
      paramMessageForText = new lds(paramagdn.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new agdl(this, paramagdn, (CharSequence)localObject1));
      paramagdn.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramagdn.d.setText((CharSequence)localObject1);
  }
  
  public aeqi a()
  {
    return new agdn(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    paramViewGroup = (agdn)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (agdn)paramaeqi;
    paramaeqi = paramView;
    if (paramView == null)
    {
      paramaeqi = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131561676, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramaeqi;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramaeqi.findViewById(2131364176));
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
    paramBaseChatItemLayout.d.setOnTouchListener(paramaetk);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramaetk);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new agdk(this);
    }
    return paramaeqi;
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  @TargetApi(16)
  protected void a(agdn paramagdn, MessageForText paramMessageForText)
  {
    if (paramagdn == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramagdn.e == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramagdn.jdField_a_of_type_Boolean)
        {
          paramagdn.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramagdn.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramagdn.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramagdn.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramagdn.g);
          }
          if (paramagdn.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = ldr.a(localContext);
          paramMessageForText = null;
          ldj localldj = ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (localldj != null) {
            paramMessageForText = localldj.a(paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramagdn.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!ldn.a(localContext).b(str, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long)))
          {
            i += 1;
            ldn.a(localContext).b(str, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          ldn.a(localContext).a(str, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long, paramMessageForText.a());
          paramagdn.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131717649);
    return;
    label340:
    h += 1;
    paramagdn.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramagdn, paramagdn.jdField_b_of_type_JavaLangString, Language.fromString(str), new agdm(this, paramagdn, localContext, str)).booleanValue())
    {
      b(paramagdn);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131717649);
        return;
      }
      a(2131717651);
      return;
    }
    a(paramagdn);
    ldn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long, Boolean.valueOf(true));
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
        biva.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364173) || (paramView.getId() == 2131364176))
    {
      MessageForText localMessageForText = (MessageForText)aepi.a(paramView);
      a((agdn)aepi.a(paramView), localMessageForText);
      aepi.n = true;
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdj
 * JD-Core Version:    0.7.0.1
 */