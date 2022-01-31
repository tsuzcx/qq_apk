import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.2;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afbt
  implements afal
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public afbt(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
  }
  
  private void a(String paramString)
  {
    Object localObject = (alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localObject != null)
    {
      localObject = ((alzf)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).g(paramString);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new TroopAddFriendTipsHelper.1(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin")), 2, null, true);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    case 6: 
      a();
      return;
    }
    a(null);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!str1.equalsIgnoreCase(paramMessageRecord.frienduin)) {}
    for (;;)
    {
      return;
      TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
      String str2;
      if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -1012) && (localTroopBatchAddFriendMgr.b("newMember"))) {
        str2 = paramMessageRecord.getExtInfoFromExtStr("troop_new_member_uin");
      }
      try
      {
        QLog.d("TroopAddFriendTipsHelper", 1, "checkTipsTriggerInAio update newMemberUin = " + asms.a(str2) + " troop:" + str1);
        if ((localTroopBatchAddFriendMgr.a(str1)) && (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))) {
          ThreadManager.getSubThreadHandler().postDelayed(new TroopAddFriendTipsHelper.2(this, str2, str1), 1000L);
        }
        if ((paramMessageRecord != null) && (!paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.mMessageInfo != null) && (!nav.a(paramMessageRecord)) && ((paramMessageRecord.mMessageInfo.a.a()) || (paramMessageRecord.mMessageInfo.l.a())) && (localTroopBatchAddFriendMgr.b("atMeOrReplyMe")) && (localTroopBatchAddFriendMgr.e(paramMessageRecord.senderuin))) {
          localTroopBatchAddFriendMgr.a(str1, paramMessageRecord.senderuin, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
        if ((paramMessageRecord == null) || (!paramMessageRecord.isSendFromLocal())) {
          continue;
        }
        if (paramMessageRecord.atInfoList != null)
        {
          i = 1;
          if (((i | paramMessageRecord instanceof MessageForReplyText) == 0) || (!localTroopBatchAddFriendMgr.b("atMeOrReplyMe"))) {
            continue;
          }
          localTroopBatchAddFriendMgr.a(paramMessageRecord, str1);
          return;
        }
      }
      catch (XorCipherException localXorCipherException)
      {
        for (;;)
        {
          localXorCipherException.printStackTrace();
          continue;
          int i = 0;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ThreadManager.postImmediately(new TroopAddFriendTipsHelper.3(this, paramBoolean, paramString), null, true);
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbt
 * JD-Core Version:    0.7.0.1
 */