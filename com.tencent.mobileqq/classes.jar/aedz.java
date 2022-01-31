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

public class aedz
  extends BaseBubbleBuilder
{
  public static String a;
  public static int c = 0;
  private aeec jdField_a_of_type_Aeec = new aeea(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeeb(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public aedz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    int j = 0;
    View localView = paramView.findViewById(2131368373);
    paramView = paramView.findViewById(2131379272);
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
          new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
          new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc").a(new String[] { paramString2, "", "" + bamn.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 2)
        {
          localObject = "";
          if (TroopManager.d.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc").a(new String[] { paramString2, "", "" + bamn.b(paramQQAppInterface, paramString2), paramArrayList }).a();
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
          new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc").a(new String[] { paramString2, "", "" + bamn.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc").a(new String[] { paramString2, "", "" + bamn.b(paramQQAppInterface, paramString2), paramArrayList }).a();
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
  
  public acun a()
  {
    return new aeed();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    aeed localaeed = (aeed)paramacun;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558758, paramBaseChatItemLayout, false);
      localaeed.a = ((TextView)paramacun.findViewById(2131363411));
      localaeed.b = ((TextView)paramacun.findViewById(2131363431));
      localaeed.c = paramacun.findViewById(2131365130);
      localaeed.d = paramacun.findViewById(2131363576);
      paramView = paramacun.findViewById(2131368373);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.d - actn.a(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramacun.setOnLongClickListener(paramacxn);
      paramacun.setOnTouchListener(paramacxn);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131297937);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131297938);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = actn.a(20.0F, localContext.getResources());
      int m = actn.a(20.0F, localContext.getResources());
      localaeed.a.setPadding(j, k, i, m);
      paramView = (MessageForTroopPobing)paramChatMessage;
      localaeed.a.setText(paramView.mBrief);
      if (!bool)
      {
        localaeed.c.setVisibility(0);
        localaeed.d.setVisibility(0);
        localaeed.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramBaseChatItemLayout = (TroopPobingItemView)paramacun.findViewById(2131379272);
        paramBaseChatItemLayout.a(paramacun, this.jdField_a_of_type_Aeec);
        a(paramacun, false);
        if ((paramView.mTemplateId != 2000) && (!axmt.b()) && (bbst.a()))
        {
          ((TextView)paramBaseChatItemLayout.findViewById(2131371787)).setText(paramView.mBrief);
          paramBaseChatItemLayout.a(paramView.mTemplateId, paramChatMessage.isSend());
        }
        return paramacun;
        localaeed.c.setVisibility(8);
        localaeed.d.setVisibility(8);
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
    case 2131364985: 
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacun, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        paramacun.a.setBackgroundResource(2130848934);
        return;
      }
      paramacun.a.setBackgroundResource(2130848758);
      return;
    }
    paramacun.a.setBackgroundResource(0);
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    paramView = actn.a(paramView);
    a(paramView, localbblr);
    aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbblr);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedz
 * JD-Core Version:    0.7.0.1
 */