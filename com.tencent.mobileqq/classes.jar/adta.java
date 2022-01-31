import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adta
  extends BaseBubbleBuilder
{
  public static String a;
  public static int c = 0;
  private adtd jdField_a_of_type_Adtd = new adtb(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adtc(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public adta(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    int j = 0;
    View localView = paramView.findViewById(2131302749);
    paramView = paramView.findViewById(2131313438);
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
          new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
          new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc").a(new String[] { paramString2, "", "" + azlj.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 2)
        {
          localObject = "";
          if (TroopManager.d.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc").a(new String[] { paramString2, "", "" + azlj.b(paramQQAppInterface, paramString2), paramArrayList }).a();
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
          new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc").a(new String[] { paramString2, "", "" + azlj.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc").a(new String[] { paramString2, "", "" + azlj.b(paramQQAppInterface, paramString2), paramArrayList }).a();
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
  
  public acju a()
  {
    return new adte();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adte localadte = (adte)paramacju;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493202, paramBaseChatItemLayout, false);
      localadte.a = ((TextView)paramacju.findViewById(2131297865));
      localadte.b = ((TextView)paramacju.findViewById(2131297885));
      localadte.c = paramacju.findViewById(2131299562);
      localadte.d = paramacju.findViewById(2131298026);
      paramView = paramacju.findViewById(2131302749);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.d - aciy.a(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramacju.setOnLongClickListener(paramacmv);
      paramacju.setOnTouchListener(paramacmv);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131166847);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131166848);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = aciy.a(20.0F, localContext.getResources());
      int m = aciy.a(20.0F, localContext.getResources());
      localadte.a.setPadding(j, k, i, m);
      paramView = (MessageForTroopPobing)paramChatMessage;
      localadte.a.setText(paramView.mBrief);
      if (!bool)
      {
        localadte.c.setVisibility(0);
        localadte.d.setVisibility(0);
        localadte.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramBaseChatItemLayout = (TroopPobingItemView)paramacju.findViewById(2131313438);
        paramBaseChatItemLayout.a(paramacju, this.jdField_a_of_type_Adtd);
        a(paramacju, false);
        if ((paramView.mTemplateId != 2000) && (!awnu.b()) && (baqu.a()))
        {
          ((TextView)paramBaseChatItemLayout.findViewById(2131306090)).setText(paramView.mBrief);
          paramBaseChatItemLayout.a(paramView.mTemplateId, paramChatMessage.isSend());
        }
        return paramacju;
        localadte.c.setVisibility(8);
        localadte.d.setVisibility(8);
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
    case 2131299417: 
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        paramacju.a.setBackgroundResource(2130848708);
        return;
      }
      paramacju.a.setBackgroundResource(2130848515);
      return;
    }
    paramacju.a.setBackgroundResource(0);
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = aciy.a(paramView);
    a(paramView, localbakh);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbakh);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adta
 * JD-Core Version:    0.7.0.1
 */