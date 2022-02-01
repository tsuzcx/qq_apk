import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class afrl
  implements afrc
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  public avwv a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public afrl(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void a(List<ChatMessage> paramList)
  {
    awcm.a().b(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "multiForwardSperate|checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    awcm.a().jdField_a_of_type_JavaUtilArrayList.clear();
    awcm.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    awcm.a().b.clear();
    awcm.a().b.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    a(awcm.a().b, awcm.a().jdField_a_of_type_JavaUtilArrayList, 1);
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
    {
    default: 
      paramList = "0X80078B8";
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      paramList = "0X80078B8";
      continue;
      paramList = "0X80078B9";
      continue;
      paramList = "0X80078BA";
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localbjnw.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131693999));
    localbjnw.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694000));
    localbjnw.c(2131690620);
    localbjnw.a(new afrm(this, paramList, localbjnw));
    localbjnw.show();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avwv == null) {
      this.jdField_a_of_type_Avwv = new avwv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler());
    }
    this.jdField_a_of_type_Avwv.b();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Avwv == null);
    this.jdField_a_of_type_Avwv.c();
    this.jdField_a_of_type_Avwv = null;
  }
  
  public void a(aezn paramaezn, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692035, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
    }
    do
    {
      return;
      paramaezn = awcm.a().a();
      paramaezn = awct.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramaezn);
    } while ((paramaezn == null) || (paramaezn.size() == 0));
    if (paramBoolean)
    {
      a(paramaezn, 2);
      return;
    }
    b(paramaezn);
  }
  
  public void a(List<ChatMessage> paramList, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692035, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
    }
    do
    {
      return;
      awcm.a().b(paramList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showProgressDialog(2131697900);
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    String str;
    while (paramList.hasNext())
    {
      localObject2 = (ChatMessage)paramList.next();
      if ((localObject2 instanceof MessageForWriteTogether))
      {
        str = awct.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
        localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject2, str, false);
        if (((ChatMessage)localObject2).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          ((anaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13)).a((MessageRecord)localObject2);
        }
        ((ChatMessage)localObject2).setStatus(1000);
        ((ChatMessage)localObject2).msgData = ((ChatMessage)localObject2).msg.getBytes();
        ((ArrayList)localObject1).add(localObject2);
      }
      else
      {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramList = new ArrayList();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = abwz.c((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    awcm.a().jdField_a_of_type_JavaUtilArrayList.clear();
    awcm.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    awcm.a().jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
    {
      ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramList, false, null);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
      {
      default: 
        paramList = "0X80078BB";
      }
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1004)) {
        break;
      }
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getFriendNickByBatch(paramList);
      break;
      paramList = "0X80078BB";
      continue;
      paramList = "0X80078BC";
      continue;
      paramList = "0X80078BD";
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramInt == 4) {
      if (this.jdField_a_of_type_Avwv != null) {
        this.jdField_a_of_type_Avwv.b(paramMap, paramArrayList);
      }
    }
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
    } while (this.jdField_a_of_type_Avwv == null);
    this.jdField_a_of_type_Avwv.a(paramMap, paramArrayList);
    return;
    Object localObject1 = " ";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0)
    {
      localObject1 = ContactUtils.getFriendName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      label75:
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt == 1) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = acvv.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
      if (localObject1 == null) {
        break;
      }
      if (paramInt != 2) {
        break label191;
      }
      awcm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, (AbsStructMsg)localObject1, 0L, false, paramInt);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000)) {
        break label75;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
      break label75;
    }
    label191:
    ((AbsShareMsg)localObject1).mMsg_A_ActionData = null;
    paramMap = new Intent();
    paramMap.putExtra("forward_type", -3);
    paramMap.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    paramMap.putExtra("is_need_show_sources", false);
    paramMap.putExtra("forward_msg_from_together", paramInt);
    paramMap.putExtra("forward_source_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
    localObject1 = new boolean[paramArrayList.size()];
    Object localObject2 = new int[paramArrayList.size()];
    String[] arrayOfString1 = new String[paramArrayList.size()];
    String[] arrayOfString2 = new String[paramArrayList.size()];
    int j = 0;
    int i = 0;
    if (j < paramArrayList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(j);
      if ((paramInt == 1) && ((localChatMessage instanceof MessageForWriteTogether)))
      {
        localObject1[j] = 1;
        localObject2[j] = ((MessageForWriteTogether)localChatMessage).baseRev;
        arrayOfString1[j] = ((MessageForWriteTogether)localChatMessage).padId;
        arrayOfString2[j] = ((MessageForWriteTogether)localChatMessage).token;
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        localObject1[j] = 0;
        localObject2[j] = 0;
        arrayOfString1[j] = "";
        arrayOfString2[j] = "";
      }
    }
    paramMap.putExtra("forward_is_write_together", (boolean[])localObject1);
    paramMap.putExtra("forward_write_together_base_rev", (int[])localObject2);
    paramMap.putExtra("forward_write_together_pad_id", arrayOfString1);
    paramMap.putExtra("forward_write_together_token", arrayOfString2);
    paramMap.putExtra("forward_write_together_number", i);
    atky.a(this.jdField_a_of_type_AndroidAppActivity, paramMap, 21);
  }
  
  public int[] a()
  {
    return new int[] { 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrl
 * JD-Core Version:    0.7.0.1
 */