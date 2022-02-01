import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopMsgObserver.1;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class agbw
  extends afzq
{
  private FragmentActivity a;
  protected TroopChatPie a;
  
  public agbw(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramTroopChatPie.mActivity;
  }
  
  private void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseTroopMsgObserver", 2, "onUpdateSendMsgError, sticker msg is failed!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByMessageRecord(paramMessageRecord, false);
    paramString = acnh.a(paramString, paramInt);
    boolean bool;
    if (EmojiStickerManager.a().b.containsKey(paramString))
    {
      long l = ((Long)EmojiStickerManager.a().b.get(paramString)).longValue();
      if (System.currentTimeMillis() - l <= 300000L) {
        break label156;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopMsgObserver", 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (bool)
      {
        EmojiStickerManager.a().b.put(paramString, Long.valueOf(System.currentTimeMillis()));
        ThreadManager.getUIHandler().post(new TroopMsgObserver.1(this, paramMessageRecord));
      }
      return;
      bool = true;
      continue;
      label156:
      bool = false;
    }
  }
  
  private boolean a(String paramString, int paramInt, long paramLong)
  {
    boolean bool = false;
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseTroopMsgObserver", 2, "onUpdateSendMsgError exception uin " + paramString + " type " + paramInt + " uniseq " + paramLong);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramString, paramInt, paramLong);
      if ((paramString != null) && (paramString.msgtype == -2058) && ((paramString.extraflag == 32768) || (paramString.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BaseTroopMsgObserver", 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByMessageRecord(paramString, false);
      }
      bool = true;
    }
    return bool;
  }
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopMsgObserver", 2, "onGetSystemMsgFin.success");
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      Object localObject = null;
      paramList = localObject;
      if (localList != null)
      {
        paramList = localObject;
        if (localList.size() - 1 >= 0) {
          paramList = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((paramList != null) && ((paramList instanceof MessageForSystemMsg))) {
        break label92;
      }
    }
    label92:
    long l;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        } while ((paramList.msg_type.get() != 2) || (paramList.msg.get() == null));
        i = paramList.msg.group_msg_type.get();
      } while ((i != 3) && (i != 15));
      l = paramList.msg.group_code.get();
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equalsIgnoreCase("" + l)));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.l();
  }
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
    if (paramList.isEmpty()) {}
    for (paramList = null;; paramList = (MessageRecord)paramList.get(0))
    {
      if ((paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.root.a() == 35)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.instantUpdate(true, true);
      }
      return;
    }
  }
  
  protected void onUpdateMsgDelFriend(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.obtainMessage(5, 1, 0, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690024));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.sendMessage(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.finish();
      return;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.obtainMessage(5, 1, 0, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690018));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.sendMessage(paramString);
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (a(paramString1, paramInt1, paramLong2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopMsgObserver", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong2);
      if (!(paramSendMessageHandler instanceof MessageForStructing)) {
        break label160;
      }
      if ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction)) {
        axio.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramInt1, paramInt2, paramString2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.refresh(196608);
      return;
      label160:
      if ((paramSendMessageHandler != null) && (paramSendMessageHandler.msgtype == -2058) && ((paramSendMessageHandler.extraflag == 32768) || (paramSendMessageHandler.sendFailCode == 41))) {
        a(paramString1, paramInt1, paramSendMessageHandler);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbw
 * JD-Core Version:    0.7.0.1
 */