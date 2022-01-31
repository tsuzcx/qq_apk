import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aijf
  extends QIPCModule
  implements Handler.Callback
{
  private static aijf jdField_a_of_type_Aijf;
  private long jdField_a_of_type_Long;
  private aijg jdField_a_of_type_Aijg;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private aijg b;
  private aijg c;
  
  private aijf()
  {
    super("MiniMsgIPCServer");
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("mini_msg", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public static aijf a()
  {
    if (jdField_a_of_type_Aijf == null) {}
    try
    {
      if (jdField_a_of_type_Aijf == null) {
        jdField_a_of_type_Aijf = new aijf();
      }
      return jdField_a_of_type_Aijf;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      ((aijd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(147)).a(Integer.valueOf(paramInt));
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long > l) && (this.jdField_a_of_type_Long - l < 5000L)) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      aijg localaijg = this.jdField_a_of_type_Aijg;
      if ((localObject == null) || (localaijg == null)) {
        break;
      }
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      for (;;)
      {
        localObject = ((QQAppInterface)localObject).a();
        if (localObject != null) {}
        for (int i = ((QQMessageFacade)localObject).c();; i = 0)
        {
          paramBundle.putInt("param_cmd", 0);
          paramBundle.putInt("param_proc_badge_count", i);
          localObject = new EIPCResult();
          ((EIPCResult)localObject).data = paramBundle;
          callbackResult(paramInt, (EIPCResult)localObject);
          paramBundle.putInt("param_proc_badge_count", i);
          QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_sync_unreadcount", paramBundle, null);
          if (this.c != null) {
            QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "action_sync_unreadcount", paramBundle, null);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MiniMsgIPCServer", 2, "doNotifyUnreadState unread = " + i);
          return;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "actionMiniReportEvent", paramBundle, null);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aijg != null)
    {
      String str1 = paramBundle.getString("param_proc_name");
      String str2 = paramBundle.getString("param_proc_modulename");
      paramBundle.getString("param_proc_businame");
      if ((this.jdField_a_of_type_Aijg.a().equals(str1)) && (this.jdField_a_of_type_Aijg.b().equals(str2))) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void c(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("param_proc_name");
    String str2 = paramBundle.getString("param_proc_modulename");
    int i = paramBundle.getInt("param_proc_businame");
    this.jdField_a_of_type_Aijg = new aijg(str1, str2);
    this.b = new aijg(str1, "aio_client_module");
    if (("mini_app_client_module".equals(str2)) || ("mini_sdk_client_module".equals(str2))) {
      this.c = new aijg(str1, str2);
    }
    this.jdField_a_of_type_Aijg.a = i;
    this.jdField_a_of_type_Boolean = true;
    boolean bool = paramBundle.getBoolean("param_proc_first_start", false);
    if (QLog.isColorLevel())
    {
      QLog.d("MiniMsgIPCServer", 2, str1 + "doOnProcForeGround isFirst = " + bool);
      QLog.d("MiniMsgIPCServer", 2, "moduleName:" + str2);
    }
    if (bool) {
      a();
    }
  }
  
  private void d(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("param_proc_uin");
    int j = paramBundle.getInt("param_proc_uin_type");
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramBundle = null)
    {
      aijg localaijg = this.b;
      if ((paramBundle == null) || (localaijg == null)) {
        break;
      }
      paramBundle = paramBundle.a();
      if (paramBundle != null) {}
      for (int i = paramBundle.a(j, str);; i = 0)
      {
        paramBundle = new Bundle();
        paramBundle.putString("param_proc_uin", str);
        paramBundle.putInt("param_proc_uin_type", j);
        paramBundle.putInt("param_proc_single_con_badge_count", i);
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_IPCServer", 2, "doNotifySingleConUnreadState uin = " + str + "; unread = " + i);
        }
        QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_sync_single_con_unread_count", paramBundle, null);
        if (this.c == null) {
          break;
        }
        QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "action_sync_single_con_unread_count", paramBundle, null);
        return;
      }
    }
  }
  
  private void e()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "action_sync_unreadcount", null, null);
    }
  }
  
  private void f()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "actionMiniDirectShareSucCallback", null, null);
    }
  }
  
  private void g()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "actionMiniShareSucCallback", null, null);
    }
  }
  
  private void h()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "actionMiniShareFailCallback", null, null);
    }
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long > l) && (this.jdField_a_of_type_Long - l < 5000L)) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      aijg localaijg = this.jdField_a_of_type_Aijg;
      if ((localObject == null) || (localaijg == null)) {
        break;
      }
      localObject = ((QQAppInterface)localObject).a();
      if (localObject != null) {}
      for (int i = ((QQMessageFacade)localObject).c();; i = 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("param_proc_badge_count", i);
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_IPCServer", 2, "doNotifyUnreadState unread = " + i);
        }
        QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_sync_unreadcount", (Bundle)localObject, null);
        if (this.c == null) {
          break;
        }
        QIPCServerHelper.getInstance().callClient(aijg.a(this.c), aijg.b(this.c), "action_sync_unreadcount", (Bundle)localObject, null);
        return;
      }
    }
  }
  
  private void j()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      aijg localaijg = this.jdField_a_of_type_Aijg;
      if ((localObject != null) && (localaijg != null))
      {
        localObject = new Bundle();
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_IPCServer", 2, "doNotifyGoToConversation  ");
        }
        QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_mini_msgtab_notify_to_conversation", (Bundle)localObject, null);
      }
      return;
    }
  }
  
  private void k()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      aijg localaijg = this.jdField_a_of_type_Aijg;
      QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).a();
      if (localQQMessageFacade != null) {}
      for (int i = localQQMessageFacade.c();; i = 0)
      {
        if ((localObject != null) && (localaijg != null))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("param_proc_badge_count", i);
          if (QLog.isColorLevel()) {
            QLog.d("MiniMsgIPCServer", 2, "doNotifyUnreadState unread = " + i);
          }
          QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_msg_tab_back_refresh", (Bundle)localObject, null);
        }
        return;
      }
    }
  }
  
  private void l()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      aijg localaijg = this.jdField_a_of_type_Aijg;
      QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).a();
      if (localQQMessageFacade != null) {}
      for (int i = localQQMessageFacade.c();; i = 0)
      {
        if ((localObject != null) && (localaijg != null))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("param_proc_badge_count", i);
          if (QLog.isColorLevel()) {
            QLog.d("mini_msg_IPCServer", 2, "notifyGetUnread unread = " + i);
          }
          QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_get_unread", (Bundle)localObject, null);
        }
        return;
      }
    }
  }
  
  public aijg a()
  {
    return this.jdField_a_of_type_Aijg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  void a(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_uin", paramString);
    localBundle.putInt("param_proc_uin_type", paramInt);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void c()
  {
    j();
  }
  
  public void d()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      aijg localaijg = this.jdField_a_of_type_Aijg;
      if ((localObject != null) && (localaijg != null))
      {
        localObject = new Bundle();
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgIPCServer", 2, "notifyFromMiniAIOToAIO ");
        }
        QIPCServerHelper.getInstance().callClient(aijg.a(localaijg), aijg.b(localaijg), "action_mini_aio_to_aio", (Bundle)localObject, null);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      c((Bundle)paramMessage.obj);
      continue;
      b((Bundle)paramMessage.obj);
      continue;
      if (MiniMsgTabServerInitStep.jdField_a_of_type_Boolean)
      {
        i();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MiniMsgIPCServer", 2, "isAfterActionB = " + MiniMsgTabServerInitStep.jdField_a_of_type_Boolean);
        continue;
        d(paramMessage.getData());
        continue;
        if (MiniMsgTabServerInitStep.jdField_a_of_type_Boolean)
        {
          a(paramMessage.arg1, (Bundle)paramMessage.obj);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MiniMsgIPCServer", 2, "isAfterActionB = " + MiniMsgTabServerInitStep.jdField_a_of_type_Boolean);
          continue;
          k();
          continue;
          g();
          continue;
          h();
          continue;
          l();
          continue;
          j();
          continue;
          a((Bundle)paramMessage.obj);
          continue;
          f();
          continue;
          e();
        }
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramBundle != null)) {
      QLog.d("MiniMsgIPCServer", 2, new Object[] { "MiniMsgIPCServer : " + paramString + ", " + paramBundle.toString(), ", " + paramInt });
    }
    Message localMessage = Message.obtain();
    localMessage.obj = paramBundle;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equalsIgnoreCase("cmd_proc_foregound")) {
        break label125;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return null;
      label125:
      if (paramString.equalsIgnoreCase("cmd_proc_backgound"))
      {
        localMessage.what = 2;
      }
      else if (paramString.equalsIgnoreCase("cmd_refresh_mini_badge"))
      {
        localMessage.what = 4;
        localMessage.arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_msg_tab_back_refresh"))
      {
        localMessage.what = 8;
        localMessage.arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_suc"))
      {
        localMessage.what = 6;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_fail"))
      {
        localMessage.what = 7;
      }
      else if (paramString.equalsIgnoreCase("cmd_get_unread"))
      {
        localMessage.what = 8;
        localMessage.arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_clear_business"))
      {
        if (paramBundle != null) {
          a(paramBundle.getInt("PARAM_CMD_BUSIID"));
        }
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_report_event"))
      {
        localMessage.what = 10;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_direct_share_suc"))
      {
        localMessage.what = 12;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_direct_share_fail"))
      {
        localMessage.what = 13;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijf
 * JD-Core Version:    0.7.0.1
 */