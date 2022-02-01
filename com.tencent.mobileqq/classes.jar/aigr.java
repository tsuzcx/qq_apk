import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.30.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
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

public class aigr
  extends ahxs
{
  public aigr(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689970));
      this.a.b.sendMessage(paramString);
    }
    for (;;)
    {
      this.a.I();
      return;
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689964));
      this.a.b.sendMessage(paramString);
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler == null) || (!(paramSendMessageHandler instanceof MessageForStructing))) {
        break label398;
      }
      if ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction)) {
        awwm.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    label388:
    label398:
    while ((paramSendMessageHandler == null) || (paramSendMessageHandler.msgtype != -2058) || ((paramSendMessageHandler.extraflag != 32768) && (paramSendMessageHandler.sendFailCode != 41)))
    {
      if (paramInt1 == 1) {}
      switch (paramInt2)
      {
      default: 
        this.a.f(196608);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError, sticker msg is failed!");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendMessageHandler, false);
    paramString1 = acwh.a(paramString1, paramInt1);
    boolean bool;
    if (EmojiStickerManager.a().b.containsKey(paramString1))
    {
      paramLong1 = ((Long)EmojiStickerManager.a().b.get(paramString1)).longValue();
      if (System.currentTimeMillis() - paramLong1 <= 300000L) {
        break label896;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (!bool) {
        break;
      }
      EmojiStickerManager.a().b.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      ThreadManager.getUIHandler().post(new TroopChatPie.30.1(this, paramSendMessageHandler));
      break;
      bool = true;
      continue;
      paramString1 = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689970));
      this.a.b.sendMessage(paramString1);
      break label388;
      paramString1 = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689964));
      this.a.b.sendMessage(paramString1);
      break label388;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131695360);
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString1);
      this.a.b.sendMessage(paramString1);
      break label388;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131695352);
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString1);
      this.a.b.sendMessage(paramString1);
      break label388;
      paramString1 = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if ((paramString1 != null) && (paramString1.h(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b)))
      {
        paramString1.j(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        break label388;
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label388;
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString2);
      this.a.b.sendMessage(paramString1);
      break label388;
      label896:
      bool = false;
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    super.a(paramList);
    if (paramList.isEmpty()) {}
    for (paramList = null;; paramList = (MessageRecord)paramList.get(0))
    {
      if ((paramList != null) && (TroopChatPie.c(this.a).a() == 35)) {
        this.a.b(true, true);
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin.success");
      }
      List localList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.N, 0);
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
        break label101;
      }
    }
    label101:
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
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase("" + l)));
    this.a.bx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigr
 * JD-Core Version:    0.7.0.1
 */