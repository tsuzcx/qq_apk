import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class afdq
  implements affa
{
  private alwx jdField_a_of_type_Alwx = new afdx(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public afdq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {}
    for (boolean bool = bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());; bool = false)
    {
      bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhuf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694587));
      localbhuf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694585), 3);
      localbhuf.c(2131690648);
      localbhuf.a(new afdr(this, bool, localbhuf));
      if (!localbhuf.isShowing())
      {
        localbhuf.show();
        a("0X800A7F4", bool);
      }
      return;
    }
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!bcpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramMessageForTroopFile = alud.a(2131715657);
      bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new afdw(this)).show();
      return;
    }
    if (bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
      bcmu localbcmu = bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbtn.b);
      localbcmu.a(localbcmu.a(localbbtn.e, localbbtn.g, localbbtn.c, localbbtn.h), (int)paramMessageForTroopFile.shmsgseq, azah.a(paramMessageForTroopFile.msgUid));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = new bety(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694591));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.show();
      paramMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131697661, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
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
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(131072);
              agat.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
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
        alaz.a(paramList.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "withdraw_msg");
      } while (paramList.mApolloMessage == null);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "withdraw_success", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramList.mApolloMessage.id) });
      return;
      paramList = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramList + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
    } while (TextUtils.isEmpty(paramList));
    try
    {
      long l = Long.parseLong(paramList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendEmptyMessage(267387139);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        aupg.a().a(paramList);
        acjm.a(paramList);
        acjm.b(paramList);
        aghu.a((MessageRecord)paramList.get(0));
        ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage);
        a(paramList, localChatMessage);
      }
      if ((paramBoolean2) && (paramBoolean3)) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendEmptyMessage(267387140);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new AIORevokeMsgHelper.8(this, paramInt));
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    if (bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((azqx)localObject2).a(new String[] { str, localObject1 }).a();
        if (bdne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label234;
        }
        e(paramChatMessage);
        localObject1 = new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label227;
        }
      }
      label227:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((azqx)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        bdne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
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
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (bcpx.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      a();
      return;
    }
    f(paramChatMessage);
  }
  
  public int[] a()
  {
    return new int[] { 2, 11 };
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject == null) {}
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005) && (!bcpx.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694567);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694568);
      }
      bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new afds(this, paramChatMessage)).show();
      return;
    }
    d(paramChatMessage);
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = bcpx.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L < 120000L) && (!bool)) || (bool) || (paramChatMessage.msgtype == -2005) || (bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = new bety(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694591));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.show();
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(true);
      localQQMessageFacade.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      int i = 20000;
      if (paramChatMessage.msgtype == -2005) {
        i = 30000;
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendMessageDelayed(paramChatMessage, i);
      return;
    }
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694586)).setPositiveButton(17039370, new afdt(this)).show();
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbhuf.a(alud.a(2131701357));
    localbhuf.b(alud.a(2131701350));
    localbhuf.a(alud.a(2131701347), 3);
    localbhuf.d(alud.a(2131701358));
    localbhuf.a(new afdu(this, paramChatMessage, localbhuf));
    localbhuf.show();
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhuf.a(alud.a(2131715668));
      localbhuf.b(alud.a(2131715662));
      localbhuf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694585), 3);
      localbhuf.c(2131690648);
      localbhuf.a(new afdv(this, paramChatMessage, localbhuf));
      if (!localbhuf.isShowing()) {
        localbhuf.show();
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    c(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdq
 * JD-Core Version:    0.7.0.1
 */