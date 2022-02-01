import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahll
  extends BaseBubbleBuilder
{
  public static String a;
  public static int c = 0;
  private ahlo jdField_a_of_type_Ahlo = new ahlm(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahln(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public ahll(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    int j = 0;
    View localView = paramView.findViewById(2131369170);
    paramView = paramView.findViewById(2131381248);
    if (paramBoolean)
    {
      i = 8;
      localView.setVisibility(i);
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = j;; i = 8)
    {
      paramView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (c == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        Object localObject;
        if (c == 1)
        {
          localObject = "";
          if (TroopManager.c.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new bdlf(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
          new bdlf(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc").a(new String[] { paramString2, "", "" + TroopUtils.convSfToReportParam(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 2)
        {
          localObject = "";
          if (TroopManager.d.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new bdlf(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new bdlf(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc").a(new String[] { paramString2, "", "" + TroopUtils.convSfToReportParam(paramQQAppInterface, paramString2), paramArrayList }).a();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcome subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        c = 0;
      }
      paramArrayList = "";
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (c == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        if (c == 1)
        {
          Object localObject = "";
          if (TroopManager.c.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new bdlf(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc").a(new String[] { paramString2, "", "" + TroopUtils.convSfToReportParam(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new bdlf(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc").a(new String[] { paramString2, "", "" + TroopUtils.convSfToReportParam(paramQQAppInterface, paramString2), paramArrayList }).a();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcomeForMixMsg subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        c = 0;
      }
      paramArrayList = "";
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  public afqr a()
  {
    return new ahlp();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    ahlp localahlp = (ahlp)paramafqr;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558899, paramBaseChatItemLayout, false);
      localahlp.a = ((TextView)paramafqr.findViewById(2131363771));
      localahlp.b = ((TextView)paramafqr.findViewById(2131363793));
      localahlp.c = paramafqr.findViewById(2131365626);
      localahlp.d = paramafqr.findViewById(2131363944);
      paramView = paramafqr.findViewById(2131369170);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.e - AIOUtils.dp2px(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramafqr.setOnLongClickListener(paramaftk);
      paramafqr.setOnTouchListener(paramaftk);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131298119);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131298120);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = AIOUtils.dp2px(20.0F, localContext.getResources());
      int m = AIOUtils.dp2px(20.0F, localContext.getResources());
      localahlp.a.setPadding(j, k, i, m);
      paramView = (MessageForTroopPobing)paramChatMessage;
      localahlp.a.setText(paramView.mBrief);
      if (!bool)
      {
        localahlp.c.setVisibility(0);
        localahlp.d.setVisibility(0);
        localahlp.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramBaseChatItemLayout = (TroopPobingItemView)paramafqr.findViewById(2131381248);
        paramBaseChatItemLayout.a(paramafqr, this.jdField_a_of_type_Ahlo);
        a(paramafqr, false);
        if ((paramView.mTemplateId != 2000) && (!bdfk.b()) && (bhrt.a()))
        {
          ((TextView)paramBaseChatItemLayout.findViewById(2131372976)).setText(paramView.mBrief);
          paramBaseChatItemLayout.a(paramView.mTemplateId, paramChatMessage.isSend());
        }
        return paramafqr;
        localahlp.c.setVisibility(8);
        localahlp.d.setVisibility(8);
      }
      j = i;
      i = k;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        paramafqr.a.setBackgroundResource(2130850016);
        return;
      }
      paramafqr.a.setBackgroundResource(2130849840);
      return;
    }
    paramafqr.a.setBackgroundResource(0);
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = AIOUtils.getMessage(paramView);
    a(paramView, localbhjq);
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    b(paramView, localbhjq);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahll
 * JD-Core Version:    0.7.0.1
 */