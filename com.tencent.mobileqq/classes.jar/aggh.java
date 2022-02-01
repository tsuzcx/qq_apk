import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aggh
  implements agin
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private anyz jdField_a_of_type_Anyz = new aggo(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public aggh(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {}
    for (boolean bool = TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());; bool = false)
    {
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbkzi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694157));
      localbkzi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694155), 3);
      localbkzi.c(2131690697);
      localbkzi.a(new aggi(this, bool, localbkzi));
      if (!localbkzi.isShowing())
      {
        localbkzi.show();
        a("0X800A7F4", bool);
      }
      return;
    }
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!TroopUtils.isSupportRevokeMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramMessageForTroopFile = anvx.a(2131714626);
      bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new aggn(this)).show();
      return;
    }
    if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
      bgjh localbgjh = bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfjs.b);
      localbgjh.a(localbgjh.a(localbfjs.e, localbfjs.g, localbfjs.c, localbfjs.h), (int)paramMessageForTroopFile.shmsgseq, bcsc.a(paramMessageForTroopFile.msgUid));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog = new bisl(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694161));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog.show();
      paramMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696954, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      bdla.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPtt))
    {
      paramList = (MessageForPtt)paramList.get(0);
      paramChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      if ((paramChatMessage == paramList) || (((paramChatMessage instanceof MessageForPtt)) && (paramChatMessage.frienduin != null) && (paramChatMessage.frienduin.equals(paramList.frienduin)) && (paramChatMessage.uniseq == paramList.uniseq))) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramChatMessage instanceof MessageForShortVideo))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.refresh(131072);
              ahgl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView);
              return;
            }
            if (!(paramChatMessage instanceof MessageForStructing)) {
              break;
            }
            paramList = ((MessageForStructing)paramList.get(0)).structingMsg;
          } while ((paramList == null) || (!(paramList instanceof StructMsgForAudioShare)) || (!QQPlayerService.a((StructMsgForAudioShare)paramList)));
          QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
          return;
          if (!(paramChatMessage instanceof MessageForApollo)) {
            break;
          }
          paramList = (MessageForApollo)paramList.get(0);
        } while (paramList == null);
        ancb.a(paramList.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "withdraw_msg");
      } while (paramList.mApolloMessage == null);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "withdraw_success", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(paramList.mApolloMessage.id) });
      return;
      paramList = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramList + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
    } while (TextUtils.isEmpty(paramList));
    try
    {
      long l = Long.parseLong(paramList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      QLog.e("AIORevokeMsgHelper", 1, paramList.toString());
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ChatMessage> paramList)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().sendEmptyMessage(267387139);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        axio.a().a(paramList);
        admh.a(paramList);
        admh.b(paramList);
        ahrf.a((MessageRecord)paramList.get(0));
        ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().stopRevokedRichMediaMsgTransfer(localChatMessage);
        a(paramList, localChatMessage);
      }
      agjm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramList, new ChatMessage[] { this.jdField_a_of_type_ComTencentMobileqqDataChatMessage });
      if ((paramBoolean2) && (paramBoolean3)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().sendEmptyMessage(267387140);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().post(new AIORevokeMsgHelper.8(this, paramInt));
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    if (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((bdlf)localObject2).a(new String[] { str, localObject1 }).a();
        if (bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label234;
        }
        e(paramChatMessage);
        localObject1 = new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label227;
        }
      }
      label227:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((bdlf)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        return;
        localObject1 = "2";
        break;
      }
      label234:
      e(paramChatMessage);
      return;
    }
    b(paramChatMessage);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyz);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (TroopUtils.isTroopOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      a();
      return;
    }
    f(paramChatMessage);
  }
  
  public int[] a()
  {
    return new int[] { 4, 14 };
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject == null) {}
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005) && (!TroopUtils.isTroopOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694140);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694141);
      }
      bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new aggj(this, paramChatMessage)).show();
      return;
    }
    d(paramChatMessage);
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = TroopUtils.isTroopOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L < 120000L) && (!bool)) || (bool) || (paramChatMessage.msgtype == -2005) || (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog = new bisl(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694161));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mProgressDialog.show();
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(true);
      localQQMessageFacade.revokeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      int i = 20000;
      if (paramChatMessage.msgtype == -2005) {
        i = 30000;
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().sendMessageDelayed(paramChatMessage, i);
      return;
    }
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694156)).setPositiveButton(17039370, new aggk(this)).show();
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkzi.a(anvx.a(2131700474));
    localbkzi.b(anvx.a(2131700467));
    localbkzi.a(anvx.a(2131700464), 3);
    localbkzi.d(anvx.a(2131700475));
    localbkzi.a(new aggl(this, paramChatMessage, localbkzi));
    localbkzi.show();
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbkzi.a(anvx.a(2131714637));
      localbkzi.b(anvx.a(2131714631));
      localbkzi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694155), 3);
      localbkzi.c(2131690697);
      localbkzi.a(new aggm(this, paramChatMessage, localbkzi));
      if (!localbkzi.isShowing()) {
        localbkzi.show();
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      return;
    }
    c(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggh
 * JD-Core Version:    0.7.0.1
 */