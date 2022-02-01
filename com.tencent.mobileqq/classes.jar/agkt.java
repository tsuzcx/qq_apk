import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class agkt
  implements agin
{
  protected Dialog a;
  protected Handler a;
  protected View a;
  protected aoep a;
  private aofu jdField_a_of_type_Aofu = new agku(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected String a;
  protected String b = "";
  
  public agkt(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new agkv(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getString(2131719576);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "SP_GAME_GUIDE_" + paramQQAppInterface + "_" + paramString;
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, true).commit();
  }
  
  private boolean a()
  {
    try
    {
      Object localObject2 = bgfz.a();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return false;
      }
      Object localObject1 = bhbt.a((String)localObject2 + "aio_game_popup_bg.png");
      localObject2 = bhbt.a((String)localObject2 + "aio_game_popup_close_btn.png");
      if ((localObject1 == null) || (localObject2 == null)) {
        break label159;
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext).inflate(2131559047, null);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379470)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379466);
      ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      ((ImageView)localObject1).setOnClickListener(new agkw(this));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379469).setOnClickListener(new agkx(this));
    }
    catch (Exception localException)
    {
      label153:
      break label153;
    }
    return true;
    label159:
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getBoolean("SP_GAME_GUIDE_" + paramQQAppInterface + "_" + paramString, false);
  }
  
  private boolean a(ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return false;
    }
    String str;
    if (TextUtils.isEmpty(paramArkAppMessage.appId))
    {
      str = "";
      if (!TextUtils.isEmpty(paramArkAppMessage.appName)) {
        break label92;
      }
    }
    label92:
    for (paramArkAppMessage = "";; paramArkAppMessage = paramArkAppMessage.appName)
    {
      if ((!str.equals("1104466820")) && (!paramArkAppMessage.equals("com.tencent.gamecenter.teamshare")) && (!paramArkAppMessage.equals("com.tencent.gamecenter.gameshare_sgame"))) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "isGameLink = true.");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return true;
      str = paramArkAppMessage.appId;
      break;
    }
    label100:
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "SP_GAME_GUIDE_" + paramQQAppInterface + "_" + paramString;
    localSharedPreferences.edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  private void d()
  {
    if (TextUtils.isEmpty(this.b)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasDestory) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().isFinishing()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.b)) || ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())));
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
          break;
        }
        TroopChatPie localTroopChatPie = (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localTroopChatPie.a == null) || (!localTroopChatPie.a.isShowing())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGameGuideHelper", 2, "showGameGuide troop notification window is already showing.");
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131755829);
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) && (!a()));
    this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.show();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.b);
    bhbu.a("Grp_AIO", "AIO_exp", "game_tips_exp", 0, 0, new String[] { this.b });
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aofu);
  }
  
  private void e()
  {
    b();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) && (!TextUtils.isEmpty(this.b))) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.b);
    }
    b();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 14: 
      e();
      return;
    }
    c();
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    MessageRecord localMessageRecord;
    do
    {
      return;
      while (!paramTroopInfo.hasNext())
      {
        int i;
        do
        {
          do
          {
            do
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide");
              }
              if (!"1104466820".equals(String.valueOf(paramTroopInfo.hlGuildAppid))) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
            } while (!QLog.isColorLevel());
            QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide hlGuildAppid = game.");
            return;
            paramTroopInfo = (bgft)aqxe.a().a(695);
          } while (paramTroopInfo == null);
          i = paramTroopInfo.a();
        } while (i <= 0);
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getMessageFacade().getAllMessages(this.b, 1, null, i).iterator();
      }
      localMessageRecord = (MessageRecord)paramTroopInfo.next();
    } while ((localMessageRecord.msgtype != -5008) || (!(localMessageRecord instanceof MessageForArkApp)) || (!a(((MessageForArkApp)localMessageRecord).ark_app_message)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public int[] a()
  {
    return new int[] { 14, 8 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aofu);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide mBaseChatPie = null");
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide sessionInfo = null");
                  return;
                  this.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
                  if (!bdvn.a()) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide studymode = true.");
                return;
                localObject = (bgft)aqxe.a().a(695);
                if ((localObject != null) && (((bgft)localObject).a(this.b))) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide is not graytroop");
              return;
              localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.b);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide troopinfo=null");
            return;
            if (((TroopInfo)localObject).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isOwnerOrAdmin = false.");
          return;
          if (!((TroopInfo)localObject).isHomeworkTroop()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide homeworktroop");
        return;
        if (!((TroopInfo)localObject).isTroopGameCardEnabled()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isTroopGameCardEnabled = true.");
      return;
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.b)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide hasShownGameGuide = true.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide asyncCheckShouldShowGameGuide");
    }
    ThreadManager.getSubThreadHandler().post(new TroopGameGuideHelper.3(this, (TroopInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkt
 * JD-Core Version:    0.7.0.1
 */