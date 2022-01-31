import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class adgx
  implements adif
{
  private akat jdField_a_of_type_Akat = new adhe(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public adgx(BaseChatPie paramBaseChatPie)
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
    for (boolean bool = banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());; bool = false)
    {
      bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfpc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694428));
      localbfpc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694426), 3);
      localbfpc.c(2131690596);
      localbfpc.a(new adgy(this, bool, localbfpc));
      if (!localbfpc.isShowing())
      {
        localbfpc.show();
        a("0X800A7F4", bool);
      }
      return;
    }
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!banb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramMessageForTroopFile = ajya.a(2131715273);
      bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new adhd(this)).show();
      return;
    }
    if (bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      azqv localazqv = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
      bajy localbajy = bajy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazqv.b);
      localbajy.a(localbajy.a(localazqv.e, localazqv.g, localazqv.c, localazqv.h), (int)paramMessageForTroopFile.shmsgseq, axau.a(paramMessageForTroopFile.msgUid));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = new bcqf(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694432));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.show();
      paramMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131697484, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    if (banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((axrc)localObject2).a(new String[] { str, localObject1 }).a();
        if (bbkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label234;
        }
        e(paramChatMessage);
        localObject1 = new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label227;
        }
      }
      label227:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((axrc)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        bbkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (banb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
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
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005) && (!banb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694408);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694409);
      }
      bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new adgz(this, paramChatMessage)).show();
      return;
    }
    d(paramChatMessage);
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = banb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L < 120000L) && (!bool)) || (bool) || (paramChatMessage.msgtype == -2005) || (banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = new bcqf(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131694432));
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
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694427)).setPositiveButton(17039370, new adha(this)).show();
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfpc.a(ajya.a(2131700976));
    localbfpc.b(ajya.a(2131700969));
    localbfpc.a(ajya.a(2131700966), 3);
    localbfpc.d(ajya.a(2131700977));
    localbfpc.a(new adhb(this, paramChatMessage, localbfpc));
    localbfpc.show();
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfpc.a(ajya.a(2131715284));
      localbfpc.b(ajya.a(2131715278));
      localbfpc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694426), 3);
      localbfpc.c(2131690596);
      localbfpc.a(new adhc(this, paramChatMessage, localbfpc));
      if (!localbfpc.isShowing()) {
        localbfpc.show();
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
    }
    c(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgx
 * JD-Core Version:    0.7.0.1
 */