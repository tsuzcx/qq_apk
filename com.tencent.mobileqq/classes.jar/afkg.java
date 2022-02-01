import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie.30.1;
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

public class afkg
  extends afil
{
  public afkg(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
  }
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.tag, 2, "onGetSystemMsgFin.success");
      }
      List localList = this.a.app.getMessageFacade().getMsgList(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
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
        break label100;
      }
    }
    label100:
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
    } while ((this.a.sessionInfo.curFriendUin == null) || (!this.a.sessionInfo.curFriendUin.equalsIgnoreCase("" + l)));
    this.a.k();
  }
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
    if (paramList.isEmpty()) {}
    for (paramList = null;; paramList = (MessageRecord)paramList.get(0))
    {
      if ((paramList != null) && (this.a.root.a() == 35)) {
        this.a.instantUpdate(true, true);
      }
      return;
    }
  }
  
  protected void onUpdateMsgDelFriend(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.curType)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.mActivity.getString(2131689995));
      this.a.b.sendMessage(paramString);
    }
    for (;;)
    {
      this.a.finish();
      return;
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.mActivity.getString(2131689989));
      this.a.b.sendMessage(paramString);
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.curType))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.a.app.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.tag, 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.a.app.getMessageFacade().removeMsgByMessageRecord(paramString1, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.app.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler == null) || (!(paramSendMessageHandler instanceof MessageForStructing))) {
        break label337;
      }
      if ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction)) {
        awcm.a().a(this.a.app, paramString1, paramInt1, paramLong2, false);
      }
    }
    label337:
    while ((paramSendMessageHandler == null) || (paramSendMessageHandler.msgtype != -2058) || ((paramSendMessageHandler.extraflag != 32768) && (paramSendMessageHandler.sendFailCode != 41)))
    {
      TroopChatPie.a(this.a, paramInt1, paramInt2, paramString2);
      this.a.refresh(196608);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.a.tag, 2, "onUpdateSendMsgError, sticker msg is failed!");
    }
    this.a.app.getMessageFacade().removeMsgByMessageRecord(paramSendMessageHandler, false);
    paramString1 = abwz.a(paramString1, paramInt1);
    boolean bool;
    if (EmojiStickerManager.a().b.containsKey(paramString1))
    {
      paramLong1 = ((Long)EmojiStickerManager.a().b.get(paramString1)).longValue();
      if (System.currentTimeMillis() - paramLong1 <= 300000L) {
        break label548;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.tag, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (!bool) {
        break;
      }
      EmojiStickerManager.a().b.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      ThreadManager.getUIHandler().post(new TroopChatPie.30.1(this, paramSendMessageHandler));
      break;
      bool = true;
      continue;
      label548:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkg
 * JD-Core Version:    0.7.0.1
 */