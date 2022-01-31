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

public class agal
  extends BaseBubbleBuilder
{
  public static String a;
  public static int c = 0;
  private agao jdField_a_of_type_Agao = new agam(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agan(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public agal(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    int j = 0;
    View localView = paramView.findViewById(2131368556);
    paramView = paramView.findViewById(2131379978);
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
          new azmo(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
          new azmo(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc").a(new String[] { paramString2, "", "" + bclo.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 2)
        {
          localObject = "";
          if (TroopManager.d.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new azmo(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new azmo(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc").a(new String[] { paramString2, "", "" + bclo.b(paramQQAppInterface, paramString2), paramArrayList }).a();
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
          new azmo(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc").a(new String[] { paramString2, "", "" + bclo.b(paramQQAppInterface, paramString2), localObject }).a();
        }
        if (c == 3)
        {
          if (TroopManager.d.contains(paramArrayList)) {
            new azmo(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc").a(new String[] { paramString2, "", "" + bclo.b(paramQQAppInterface, paramString2), paramArrayList }).a();
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
  
  public aelt a()
  {
    return new agap();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    agap localagap = (agap)paramaelt;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558794, paramBaseChatItemLayout, false);
      localagap.a = ((TextView)paramaelt.findViewById(2131363449));
      localagap.b = ((TextView)paramaelt.findViewById(2131363470));
      localagap.c = paramaelt.findViewById(2131365214);
      localagap.d = paramaelt.findViewById(2131363620);
      paramView = paramaelt.findViewById(2131368556);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.d - aekt.a(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramaelt.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131297958);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131297959);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = aekt.a(20.0F, localContext.getResources());
      int m = aekt.a(20.0F, localContext.getResources());
      localagap.a.setPadding(j, k, i, m);
      paramView = (MessageForTroopPobing)paramChatMessage;
      localagap.a.setText(paramView.mBrief);
      if (!bool)
      {
        localagap.c.setVisibility(0);
        localagap.d.setVisibility(0);
        localagap.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramBaseChatItemLayout = (TroopPobingItemView)paramaelt.findViewById(2131379978);
        paramBaseChatItemLayout.a(paramaelt, this.jdField_a_of_type_Agao);
        a(paramaelt, false);
        if ((paramView.mTemplateId != 2000) && (!azib.b()) && (bdse.a()))
        {
          ((TextView)paramBaseChatItemLayout.findViewById(2131372105)).setText(paramView.mBrief);
          paramBaseChatItemLayout.a(paramView.mTemplateId, paramChatMessage.isSend());
        }
        return paramaelt;
        localagap.c.setVisibility(8);
        localagap.d.setVisibility(8);
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
    case 2131365069: 
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        paramaelt.a.setBackgroundResource(2130849371);
        return;
      }
      paramaelt.a.setBackgroundResource(2130849195);
      return;
    }
    paramaelt.a.setBackgroundResource(0);
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    a(paramView, localbdkz);
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbdkz);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agal
 * JD-Core Version:    0.7.0.1
 */