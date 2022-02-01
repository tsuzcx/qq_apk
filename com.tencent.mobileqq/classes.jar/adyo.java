import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.1.1;
import com.tencent.mobileqq.activity.Conversation.1.2;
import com.tencent.mobileqq.activity.Conversation.1.3;
import com.tencent.mobileqq.activity.Conversation.1.4;
import com.tencent.mobileqq.activity.Conversation.1.5;
import com.tencent.mobileqq.activity.Conversation.1.6;
import com.tencent.mobileqq.activity.Conversation.1.7;
import com.tencent.mobileqq.activity.Conversation.1.8;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class adyo
  implements Handler.Callback
{
  public adyo(Conversation paramConversation) {}
  
  private void a()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.1.3(this));
  }
  
  private void a(Message paramMessage)
  {
    try
    {
      amhd localamhd = (amhd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (ampj.a(null)) {
        localamhd.k = true;
      }
      if ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o) || (ampj.a(null)))
      {
        if (localamhd != null) {
          localamhd.j = true;
        }
        return;
      }
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.s();
      }
      ampj.a(this.a.b, (String)paramMessage.obj);
      this.a.d = true;
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    if (paramTextView1 != null)
    {
      Conversation.a(this.a).setTag(2131366055, new WeakReference(paramTextView1));
      paramTextView1.setText(Conversation.a(this.a).getText());
    }
    if (paramTextView2 != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTag(2131366055, new WeakReference(paramTextView2));
      int i = afur.a(10.0F, this.a.a());
      afur.a(paramTextView2, i, i, i, i);
      paramTextView2.setText(this.a.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramTextView1 = this.a.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      if (paramTextView1.length == 4)
      {
        paramTextView2.setCompoundDrawablePadding(this.a.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding());
        paramTextView2.setCompoundDrawables(paramTextView1[0], paramTextView1[1], paramTextView1[2], paramTextView1[3]);
      }
      paramTextView2.setOnTouchListener(new muf());
      paramTextView2.setOnClickListener(new adyp(this));
      paramTextView2.setOnLongClickListener(new adyq(this));
    }
  }
  
  private boolean a(Message paramMessage)
  {
    int j = 0;
    int i = 2;
    Object localObject;
    Message localMessage;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1010: 
      j(paramMessage);
      return true;
    case 1062: 
      i(paramMessage);
      return true;
    case 1063: 
      j();
      return true;
    case 1064: 
      h(paramMessage);
      return true;
    case 1023: 
      i();
      return true;
    case 1076: 
      Conversation.g(this.a);
      return true;
    case 1027: 
      aqbt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.jdField_a_of_type_Akyh, paramMessage);
      return true;
    case 11340003: 
      g(paramMessage);
      return true;
    case 1134018: 
      f(paramMessage);
      return true;
    case 1134019: 
      e(paramMessage);
      return true;
    case 1134057: 
      g();
      return true;
    case 1134058: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "UpgradeTIMWrapper MSG_TIM_UPGRADE_BAR_HIDE");
      }
      localObject = UpgradeTIMWrapper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((UpgradeTIMWrapper)localObject).a();
      UpgradeTIMWrapper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UpgradeTIMWrapper)localObject);
      this.a.jdField_a_of_type_Akyh.a(27, 0);
      this.a.jdField_a_of_type_Akyh.a(27, paramMessage);
      return true;
    case 11340004: 
      this.a.jdField_a_of_type_Akyh.a(13, 0);
      this.a.jdField_a_of_type_Akyh.a(13, paramMessage);
      return true;
    case 1134010: 
      this.a.jdField_a_of_type_Akyh.a(38, 2);
      this.a.jdField_a_of_type_Akyh.a(38, paramMessage);
      return true;
    case 1134065: 
      if (paramMessage != null)
      {
        this.a.jdField_a_of_type_Akyh.a(11, paramMessage.arg1);
        this.a.jdField_a_of_type_Akyh.a(11, paramMessage);
        return true;
      }
      break;
    case 1134011: 
      this.a.jdField_a_of_type_Akyh.a(38, 0);
      this.a.jdField_a_of_type_Akyh.a(38, paramMessage);
      return true;
    case 1134059: 
      this.a.jdField_a_of_type_Akyh.a(36, 2);
      this.a.jdField_a_of_type_Akyh.a(36, paramMessage);
      return true;
    case 1134060: 
      this.a.jdField_a_of_type_Akyh.a(36, 0);
      this.a.jdField_a_of_type_Akyh.a(36, paramMessage);
      return true;
    case 1134027: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134028)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134028);
      }
      this.a.jdField_a_of_type_Akyh.a(30, 2);
      this.a.jdField_a_of_type_Akyh.a(30, paramMessage);
      return true;
    case 1134028: 
      this.a.jdField_a_of_type_Akyh.a(30, 0);
      this.a.jdField_a_of_type_Akyh.a(30, paramMessage);
      return true;
    case 1134043: 
      this.a.jdField_a_of_type_Akyh.a(34, 2);
      this.a.jdField_a_of_type_Akyh.a(34, paramMessage);
      return true;
    case 1134044: 
      this.a.jdField_a_of_type_Akyh.a(34, 0);
      this.a.jdField_a_of_type_Akyh.a(34, paramMessage);
      return true;
    case 1134051: 
      if (paramMessage.arg1 != 1) {
        this.a.jdField_a_of_type_Akyh.a(35, 2);
      }
      this.a.jdField_a_of_type_Akyh.a(35, paramMessage);
      if (QLog.isColorLevel())
      {
        QLog.d("cmgame_process.", 2, " MSG_APOLLO_GAME_SHOW");
        return true;
      }
      break;
    case 1134052: 
      this.a.jdField_a_of_type_Akyh.a(35, 0);
      this.a.jdField_a_of_type_Akyh.a(35, paramMessage);
      if (QLog.isColorLevel())
      {
        QLog.d("cmgame_process.", 2, " MSG_APOLLO_GAME_HIDE");
        return true;
      }
      break;
    case 1134069: 
      this.a.jdField_a_of_type_Akyh.a(3, 2);
      this.a.jdField_a_of_type_Akyh.a(3, paramMessage);
      return true;
    case 1134070: 
      this.a.jdField_a_of_type_Akyh.a(3, 0);
      this.a.jdField_a_of_type_Akyh.a(3, paramMessage);
      return true;
    case 1134039: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134040)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134040);
      }
      this.a.jdField_a_of_type_Akyh.a(31, 2);
      this.a.jdField_a_of_type_Akyh.a(31, paramMessage);
      return true;
    case 1134040: 
      this.a.jdField_a_of_type_Akyh.a(31, 0);
      this.a.jdField_a_of_type_Akyh.a(31, paramMessage);
      return true;
    case 1134041: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134042)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134042);
      }
      this.a.jdField_a_of_type_Akyh.a(32, 2);
      this.a.jdField_a_of_type_Akyh.a(32, paramMessage);
      return true;
    case 1134042: 
      this.a.jdField_a_of_type_Akyh.a(32, 0);
      this.a.jdField_a_of_type_Akyh.a(32, paramMessage);
      return true;
    case 1134049: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134050)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134050);
      }
      this.a.jdField_a_of_type_Akyh.a(paramMessage);
      return true;
    case 1134050: 
      this.a.jdField_a_of_type_Akyh.a(33, 0);
      this.a.jdField_a_of_type_Akyh.a(33, paramMessage);
      return true;
    case 1134021: 
      this.a.jdField_a_of_type_Akyh.a(8, 2);
      this.a.jdField_a_of_type_Akyh.a(8, paramMessage);
      return true;
    case 1134022: 
      this.a.jdField_a_of_type_Akyh.a(8, 0);
      this.a.jdField_a_of_type_Akyh.a(8, paramMessage);
      return true;
    case 1134066: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134066)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134066);
      }
      this.a.jdField_a_of_type_Akyh.a(43, 2);
      this.a.jdField_a_of_type_Akyh.a(43, paramMessage);
      return true;
    case 1134067: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134067)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134067);
      }
      this.a.jdField_a_of_type_Akyh.a(43, 0);
      this.a.jdField_a_of_type_Akyh.a(43, paramMessage);
      return true;
    case 1134024: 
      i = paramMessage.arg1;
      this.a.jdField_a_of_type_Akyh.a(9, i);
      this.a.jdField_a_of_type_Akyh.a(9, paramMessage);
      return true;
    case 1032: 
      this.a.jdField_a_of_type_Akyh.a(23, 2);
      this.a.jdField_a_of_type_Akyh.a(23, paramMessage);
      return true;
    case 1033: 
      this.a.jdField_a_of_type_Akyh.a(23, 0);
      this.a.jdField_a_of_type_Akyh.a(23, paramMessage);
      return true;
    case 1040: 
      this.a.jdField_a_of_type_Akyh.a(7, 2);
      this.a.jdField_a_of_type_Akyh.a(7, paramMessage);
      return true;
    case 1041: 
      this.a.jdField_a_of_type_Akyh.a(7, 0);
      this.a.jdField_a_of_type_Akyh.a(7, paramMessage);
      return true;
    case 1134025: 
      localObject = this.a.jdField_a_of_type_Akyh;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != 0) {}
      for (;;)
      {
        ((akyh)localObject).a(40, i);
        this.a.jdField_a_of_type_Akyh.a(40, paramMessage);
        return true;
        i = 0;
      }
    case 1134026: 
      localObject = this.a.jdField_a_of_type_Akyh;
      if (atmc.a().a()) {}
      for (;;)
      {
        ((akyh)localObject).a(41, i);
        this.a.jdField_a_of_type_Akyh.a(41, paramMessage);
        return true;
        i = 0;
      }
    case 1035: 
      this.a.v();
      return true;
    case 1038: 
      this.a.jdField_a_of_type_Akyh.a(25, 2);
      this.a.jdField_a_of_type_Akyh.a(25, paramMessage);
      return true;
    case 1039: 
      this.a.jdField_a_of_type_Akyh.a(25, 0);
      this.a.jdField_a_of_type_Akyh.a(25, paramMessage);
      return true;
    case 1049: 
      this.a.jdField_a_of_type_Akyh.a(26, 2);
      this.a.jdField_a_of_type_Akyh.a(26, paramMessage);
      return true;
    case 1050: 
      this.a.jdField_a_of_type_Akyh.a(26, 0);
      this.a.jdField_a_of_type_Akyh.a(26, paramMessage);
      return true;
    case 1042: 
      this.a.jdField_a_of_type_Akyh.a(6, paramMessage.arg1);
      this.a.jdField_a_of_type_Akyh.a(6, paramMessage);
      return true;
    case 1052: 
      localObject = this.a.jdField_a_of_type_Akyh;
      if (paramMessage.obj == null) {}
      for (i = j;; i = 2)
      {
        ((akyh)localObject).a(4, i);
        this.a.jdField_a_of_type_Akyh.a(4, paramMessage);
        return true;
      }
    case 1134200: 
      localObject = this.a.jdField_a_of_type_Akyh.a();
      if (localObject != null)
      {
        localMessage = ((MqqHandler)localObject).obtainMessage(200);
        localMessage.obj = paramMessage.obj;
        ((MqqHandler)localObject).sendMessage(localMessage);
        return true;
      }
      break;
    case 1134201: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "MSG_HIDE_GENERAL_BANNER with: " + paramMessage);
      }
      localObject = this.a.jdField_a_of_type_Akyh.a();
      if (localObject != null)
      {
        localMessage = ((MqqHandler)localObject).obtainMessage(201);
        localMessage.obj = paramMessage.obj;
        ((MqqHandler)localObject).sendMessage(localMessage);
        return true;
      }
      break;
    case 1069: 
      if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1069);
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1068);
        return true;
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1068)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1068);
      }
      this.a.jdField_a_of_type_Akyh.d(false);
      if (this.a.jdField_a_of_type_Akyh.a() != null)
      {
        this.a.jdField_a_of_type_Akyh.a(-1, null);
        return true;
      }
      break;
    case 1068: 
      if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1069);
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1068);
        return true;
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1069)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1069);
      }
      this.a.jdField_a_of_type_Akyh.d(true);
      if (this.a.jdField_a_of_type_Akyh.a() != null)
      {
        this.a.jdField_a_of_type_Akyh.a(-1, null);
        return true;
      }
      break;
    case 1134063: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "handler msg MSG_WIFISECURITY_BAR, msg.obj: " + paramMessage.obj);
      }
      this.a.jdField_a_of_type_Akyh.a(2, 2);
      this.a.jdField_a_of_type_Akyh.a(2, paramMessage);
      return true;
    case 1074: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_HIDE_BANNER_AUTO_STATUS");
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1074)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1074);
      }
      this.a.jdField_a_of_type_Akyh.a(28, 0);
      this.a.jdField_a_of_type_Akyh.a(28, null);
      return true;
    case 1075: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_SHOW_BANNER_AUTO_STATUS");
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1074)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1074);
      }
      this.a.jdField_a_of_type_Akyh.a(28, 2);
      this.a.jdField_a_of_type_Akyh.a(28, paramMessage);
      return true;
    }
    return true;
  }
  
  private void b()
  {
    this.a.g = false;
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).springBackOverScrollHeaderView();
    }
    if (this.a.c > 0L) {
      bgso.a("Conversation_PullToRefresh_finish", SystemClock.uptimeMillis() - this.a.c);
    }
    this.a.c = 0L;
  }
  
  private void b(Message paramMessage)
  {
    long l = Math.abs(System.currentTimeMillis() - this.a.e);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "MSG_REFRESH_UI, [" + paramMessage.arg1 + "," + l + "]");
    }
    if (l < 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "distance < 0[" + l + "," + this.a.e + "]");
      }
      l = this.a.jdField_a_of_type_Long + 1L;
    }
    for (;;)
    {
      List localList = (List)paramMessage.obj;
      if ((paramMessage.arg2 != 1) && (l < this.a.jdField_a_of_type_Long))
      {
        this.a.jdField_a_of_type_JavaUtilList = localList;
        paramMessage = Message.obtain();
        paramMessage.what = 10000;
        paramMessage.obj = this.a.jdField_a_of_type_JavaUtilList;
        paramMessage.arg1 = 0;
        paramMessage.arg2 = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, this.a.jdField_a_of_type_Long - l + 50L);
      }
      for (;;)
      {
        return;
        int i;
        if (paramMessage.arg2 == 1) {
          if (localList == this.a.jdField_a_of_type_JavaUtilList) {
            i = 1;
          }
        }
        while (i != 0)
        {
          Conversation.a(this.a, 0, this.a.jdField_a_of_type_JavaUtilList);
          this.a.e = System.currentTimeMillis();
          return;
          i = 0;
          continue;
          this.a.jdField_a_of_type_JavaUtilList = localList;
          i = 1;
        }
      }
    }
  }
  
  private void c()
  {
    if (this.a.jdField_a_of_type_Albc != null) {
      this.a.jdField_a_of_type_Albc.a();
    }
  }
  
  private void c(Message paramMessage)
  {
    int i = 1;
    if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    if (paramMessage.arg1 == 1) {}
    while (i != 0)
    {
      paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramMessage.red_type.set(0);
      this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramMessage);
      return;
      i = 0;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(new BusinessInfoCheckUpdate.AppInfo());
  }
  
  private void d()
  {
    ImageView localImageView = this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a;
    boolean bool = ((MedalWallMng)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a(this.a.a(), localImageView, 1, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "MSG_CHECK_MEDAL_GUIDE ret: %s", new Object[] { Boolean.valueOf(bool) }));
    }
  }
  
  private void d(Message paramMessage)
  {
    if (((paramMessage.obj instanceof String[])) && (!this.a.h))
    {
      Object localObject = (String[])paramMessage.obj;
      if (localObject.length == 3)
      {
        paramMessage = localObject[0];
        String str = localObject[1];
        localObject = localObject[2];
        new aeao(this.a, paramMessage, str, (String)localObject).a();
      }
    }
  }
  
  private void e()
  {
    yqp.b("Q.recent", "handle MSG_INIT_MSGTAG_STORY");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      wfg localwfg = (wfg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    }
    ThreadManager.post(new Conversation.1.4(this), 8, null, true);
  }
  
  /* Error */
  private void e(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   4: invokestatic 504	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   7: ifnull +22 -> 29
    //   10: aload_0
    //   11: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   14: invokestatic 504	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   17: invokevirtual 509	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   20: aload_0
    //   21: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   24: aconst_null
    //   25: invokestatic 512	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   28: pop
    //   29: aload_0
    //   30: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   33: getfield 198	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Akyh	Lakyh;
    //   36: bipush 15
    //   38: iconst_0
    //   39: invokevirtual 238	akyh:a	(II)V
    //   42: aload_0
    //   43: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   46: getfield 198	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Akyh	Lakyh;
    //   49: bipush 15
    //   51: aload_1
    //   52: invokevirtual 241	akyh:a	(ILandroid/os/Message;)V
    //   55: return
    //   56: astore_2
    //   57: aload_0
    //   58: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   61: aconst_null
    //   62: invokestatic 512	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   65: pop
    //   66: goto -37 -> 29
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 12	adyo:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   74: aconst_null
    //   75: invokestatic 512	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   78: pop
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	adyo
    //   0	81	1	paramMessage	Message
    //   56	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	20	56	java/lang/Exception
    //   10	20	69	finally
  }
  
  private void f()
  {
    if (aqpv.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_SCROLL_TOP_AND_REFRESH");
      }
      Conversation.a(this.a, true);
      Conversation.a(this.a, SystemClock.elapsedRealtime());
      Conversation.a(this.a).setSelection(0);
      Conversation.h(this.a);
    }
  }
  
  private void f(Message paramMessage)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = bgdt.a().a();
    if (localUpgradeDetailWrapper.a == null) {}
    do
    {
      return;
      SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      long l1 = localSharedPreferences.getLong("YELLOW_BAR_LAST_SHOW", 0L);
      long l2 = new Date().getTime();
      if (l2 - l1 > localUpgradeDetailWrapper.a.dialog.b * 24 * 60 * 60 * 1000)
      {
        this.a.jdField_a_of_type_Akyh.a(15, 2);
        this.a.jdField_a_of_type_Akyh.a(13, 0);
        this.a.jdField_a_of_type_Akyh.a(15, paramMessage);
        localSharedPreferences.edit().putLong("YELLOW_BAR_LAST_SHOW", l2).commit();
      }
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof UpgradeActivity)));
    paramMessage = (UpgradeActivity)paramMessage.obj;
    bgdt.a().a(paramMessage);
  }
  
  private void g()
  {
    ThreadManager.post(new Conversation.1.5(this), 8, null, true);
  }
  
  private void g(Message paramMessage)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = bgdt.a().a();
    if (localUpgradeDetailWrapper.a == null) {}
    SharedPreferences localSharedPreferences;
    long l1;
    long l2;
    do
    {
      return;
      localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      l1 = localSharedPreferences.getLong("YELLOW_BAR_LAST_SHOW", 0L);
      l2 = new Date().getTime();
    } while (l2 - l1 <= localUpgradeDetailWrapper.a.dialog.b * 24 * 60 * 60 * 1000);
    this.a.jdField_a_of_type_Akyh.a(13, 2);
    this.a.jdField_a_of_type_Akyh.a(13, paramMessage);
    localSharedPreferences.edit().putLong("YELLOW_BAR_LAST_SHOW", l2);
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.1.6(this));
  }
  
  private void h(Message paramMessage)
  {
    paramMessage = paramMessage.obj;
    if ((paramMessage != null) && ((paramMessage instanceof String))) {
      ThreadManagerV2.executeOnSubThread(new Conversation.1.8(this, (String)paramMessage));
    }
  }
  
  private void i()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.1.7(this));
  }
  
  private void i(Message paramMessage)
  {
    Object localObject1 = paramMessage.obj;
    if (localObject1 == null) {
      if (this.a.jdField_a_of_type_Akyh.b())
      {
        this.a.jdField_a_of_type_Akyh.a(21, 2);
        this.a.jdField_a_of_type_Akyh.a(21, paramMessage);
      }
    }
    Object localObject2;
    TextView localTextView;
    do
    {
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_Akyh.a(21, 0);
          this.a.jdField_a_of_type_Akyh.a(21, null);
          return;
        } while (!(localObject1 instanceof View[]));
        localObject2 = (View[])localObject1;
      } while (localObject2.length != 4);
      paramMessage = localObject2[0];
      localObject1 = (TextView)localObject2[1];
      localTextView = (TextView)localObject2[2];
      localObject2 = localObject2[3];
    } while ((paramMessage == null) || (paramMessage.getParent() != null));
    Object localObject3 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373768);
    if (localObject3 != null) {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject3);
    }
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a).hasOpenDesktop())) {
      paramMessage.setVisibility(8);
    }
    localObject3 = new aeau(this.a);
    ((aeau)localObject3).a(paramMessage);
    ((aeau)localObject3).a(false);
    this.a.jdField_a_of_type_Aeau = ((aeau)localObject3);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramMessage);
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener(new adyr(this));
    }
    a((TextView)localObject1, localTextView);
  }
  
  private void j()
  {
    if (this.a.jdField_a_of_type_Aeau != null)
    {
      this.a.jdField_a_of_type_Aeau.b();
      this.a.jdField_a_of_type_Aeau = null;
    }
    if (this.a.jdField_a_of_type_Akyh != null) {
      this.a.jdField_a_of_type_Akyh.f();
    }
    View localView = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373768);
    if (localView != null)
    {
      localView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
    }
  }
  
  private void j(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Akyh.c())
    {
      this.a.jdField_a_of_type_Akyh.a(22, 2);
      this.a.jdField_a_of_type_Akyh.a(22, paramMessage);
      Conversation.d(this.a);
      return;
    }
    this.a.jdField_a_of_type_Akyh.a(22, 0);
    this.a.jdField_a_of_type_Akyh.a(22, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (paramMessage.what == 11340004) {
      this.a.jdField_a_of_type_Akyh.a(13, 0);
    }
    if ((paramMessage.what != 1134022) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {}
    while (a(paramMessage)) {
      return true;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return bool;
      Conversation.a(this.a);
      bool = true;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent list, from_handle");
      }
      this.a.a(0L);
      bool = true;
      continue;
      this.a.a(paramMessage, true);
      bool = true;
      continue;
      Conversation.a(this.a, paramMessage);
      bool = true;
      continue;
      Conversation.b(this.a, paramMessage);
      bool = true;
      continue;
      h();
      bool = true;
      continue;
      ThreadManager.getSubThreadHandler().post(new Conversation.1.1(this));
      bool = true;
      continue;
      a(paramMessage);
      bool = true;
      continue;
      bool = true;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING");
      }
      this.a.a(paramMessage, false);
      bool = true;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE");
      }
      this.a.a(paramMessage, true);
      bool = true;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_OPEN");
      }
      this.a.a(paramMessage, true);
      bool = true;
      continue;
      this.a.a(null, true);
      bool = true;
      continue;
      this.a.a(0L);
      bool = true;
      continue;
      b();
      bool = true;
      continue;
      Conversation.b(this.a);
      bool = true;
      continue;
      b(paramMessage);
      bool = true;
      continue;
      paramMessage = (List)paramMessage.obj;
      Conversation.a(this.a, 1, paramMessage);
      bool = true;
      continue;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
        bool = true;
        continue;
        Conversation.c(this.a);
        bool = true;
        continue;
        c();
        bool = true;
        continue;
        c(paramMessage);
        bool = true;
        continue;
        Conversation.d(this.a);
        bool = true;
        continue;
        ((antz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).b();
        bool = true;
        continue;
        d();
        bool = true;
        continue;
        e();
        bool = true;
        continue;
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1070);
        ((baif)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b();
        bool = true;
        continue;
        if (this.a.f)
        {
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134062, bcsq.a * 1000);
          bool = true;
          continue;
          a();
          bool = true;
          continue;
          d(paramMessage);
          bool = true;
          continue;
          Conversation.a(this.a, 1);
          bool = true;
          continue;
          go.a((TextView)this.a.a(2131379467));
          bool = true;
          continue;
          this.a.a(2131379467).setVisibility(8);
          bool = true;
          continue;
          ThreadManager.executeOnSubThread(new Conversation.1.2(this));
          bool = true;
          continue;
          Conversation.e(this.a);
          bool = true;
          continue;
          f();
          bool = true;
          continue;
          Conversation.f(this.a);
          bool = true;
          continue;
          amam.a(this.a.a());
          bool = true;
          continue;
        }
      }
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyo
 * JD-Core Version:    0.7.0.1
 */