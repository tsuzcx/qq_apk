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

public class acwe
  implements acxg
{
  private ajmm jdField_a_of_type_Ajmm = new acwl(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public acwe(BaseChatPie paramBaseChatPie)
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
    for (boolean bool = azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());; bool = false)
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131628767));
      localbegr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131628765), 3);
      localbegr.c(2131625035);
      localbegr.a(new acwf(this, bool, localbegr));
      if (!localbegr.isShowing())
      {
        localbegr.show();
        a("0X800A7F4", bool);
      }
      return;
    }
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (!azlj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramMessageForTroopFile = ajjy.a(2131649472);
      babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(paramMessageForTroopFile).setPositiveButton(17039370, new acwk(this)).show();
      return;
    }
    if (badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
      azih localazih = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayqd.b);
      localazih.a(localazih.a(localayqd.e, localayqd.g, localayqd.c, localayqd.h), (int)paramMessageForTroopFile.shmsgseq, awbk.a(paramMessageForTroopFile.msgUid));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = new bbms(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131628771));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.show();
      paramMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendMessageDelayed(paramMessageForTroopFile, 30000);
      return;
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131631771, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    if (azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject2 = new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("clk_recallMsg");
      String str = paramChatMessage.frienduin;
      Object localObject1;
      if (azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = "1";
        ((awrb)localObject2).a(new String[] { str, localObject1 }).a();
        if (baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label234;
        }
        e(paramChatMessage);
        localObject1 = new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_guide");
        localObject2 = paramChatMessage.frienduin;
        if (!azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label227;
        }
      }
      label227:
      for (paramChatMessage = "1";; paramChatMessage = "2")
      {
        ((awrb)localObject1).a(new String[] { localObject2, paramChatMessage }).a();
        baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (azlj.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramChatMessage.msgtype != -2005) && (!(paramChatMessage instanceof MessageForTroopFile)))
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
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005) && (!azlj.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131628754);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131628755);
      }
      babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new acwg(this, paramChatMessage)).show();
      return;
    }
    d(paramChatMessage);
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = azlj.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramChatMessage.time * 1000L < 120000L) && (!bool)) || (bool) || (paramChatMessage.msgtype == -2005) || (azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = new bbms(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.a(this.jdField_a_of_type_AndroidContentContext.getString(2131628771));
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
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131628766)).setPositiveButton(17039370, new acwh(this)).show();
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbegr.a(ajjy.a(2131635181));
    localbegr.b(ajjy.a(2131635174));
    localbegr.a(ajjy.a(2131635171), 3);
    localbegr.d(ajjy.a(2131635182));
    localbegr.a(new acwi(this, paramChatMessage, localbegr));
    localbegr.show();
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.a(ajjy.a(2131649483));
      localbegr.b(ajjy.a(2131649477));
      localbegr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131628765), 3);
      localbegr.c(2131625035);
      localbegr.a(new acwj(this, paramChatMessage, localbegr));
      if (!localbegr.isShowing()) {
        localbegr.show();
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "remove_file", "tips_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
    }
    c(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwe
 * JD-Core Version:    0.7.0.1
 */