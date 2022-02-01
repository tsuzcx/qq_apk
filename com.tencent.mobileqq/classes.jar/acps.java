import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity.StartRecommendPageTask;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class acps
  extends andd
{
  public acps(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void onGetAddTroopWebInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a, 2, 2131717689, 1).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      AddFriendVerifyActivity.a(this.a, false);
      this.a.finish();
    }
    for (;;)
    {
      AddFriendVerifyActivity.b(this.a, 1004);
      return;
      paramString = new AddFriendVerifyActivity.StartRecommendPageTask(this.a, paramString);
      this.a.jdField_a_of_type_AndroidOsHandler.post(paramString);
    }
  }
  
  protected void onGetExtShowTroopStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramBoolean)
    {
      int i = this.a.getIntent().getExtras().getShort("group_option", (short)2);
      if (i == 4) {
        if (paramTroopInfo != null)
        {
          paramString = AIOUtils.setOpenAIOIntent(new Intent(this.a, SplashActivity.class), null);
          paramString.putExtra("uin", paramTroopInfo.troopuin);
          paramString.putExtra("uintype", 1);
          paramString.putExtra("uinname", paramTroopInfo.getTroopName());
          this.a.startActivity(paramString);
        }
      }
      while ((TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.a.app.getAccount())) || (i != 1)) {
        return;
      }
      if (paramTroopInfo != null)
      {
        paramString = this.a.app.getProxyManager();
        RecentUser localRecentUser = (RecentUser)paramString.a().findRecentUserByUin(paramTroopInfo.troopuin, 1);
        localRecentUser.displayName = paramTroopInfo.troopname;
        localRecentUser.msgData = null;
        localRecentUser.msg = null;
        localRecentUser.msgType = 0;
        long l = NetConnInfoCenter.getServerTime();
        if (localRecentUser.lastmsgtime < l) {
          localRecentUser.lastmsgtime = l;
        }
        paramString.a().saveRecentUser(localRecentUser);
        this.a.setResult(-1);
      }
      this.a.finish();
      return;
    }
    this.a.setResult(-1);
    if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    this.a.finish();
  }
  
  public void onJoinTroopSecurityTips(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "onJoinTroopSecurityTips troopUin:" + paramString + ",tId = " + paramInt + ",time = " + paramLong);
    }
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.jdField_a_of_type_JavaLangString)) || (paramBoolean)) {
      return;
    }
    beqg.a(this.a.app, paramInt, paramLong, this.a.getActivity());
  }
  
  protected void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (!bftf.a(String.valueOf(paramLong), this.a.jdField_a_of_type_JavaLangString)) {}
    label262:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label262;
          }
          long l = paramTroopInfo.dwGroupClassExt;
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", dwGroupClassExt = " + l + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
          }
          if ((l != 10009L) && (l != 10010L) && (l != 10011L) && (l != 10012L) && (!paramTroopInfo.isHomeworkTroop())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret: 不需要显示城市、星座、性别这一交友信息~");
        return;
        paramTroopInfo = AddFriendVerifyActivity.b(this.a);
      } while (TextUtils.isEmpty(paramTroopInfo));
      paramTroopInfo = this.a.getString(2131697011, new Object[] { this.a.app.getCurrentNickname() }) + paramTroopInfo;
      this.a.d(paramTroopInfo);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
  }
  
  protected void onSetTroopShowExternalStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131695675), 0).b(this.a.getTitleBarHeight());
      AddFriendVerifyActivity.b(this.a);
    }
    paramString = this.a;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.c = paramBoolean;
      return;
    }
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.a.jdField_a_of_type_Bhht.dismiss();
      TroopUtils.handleJoinTroopFailed(this.a, paramInt2);
      AddFriendVerifyActivity.b(this.a, 1002);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {}
    switch (paramInt2)
    {
    case -1: 
    default: 
      AddFriendVerifyActivity.b(this.a, 1002);
      this.a.jdField_a_of_type_Bhht.dismiss();
      QQToast.a(this.a, 1, 2131717688, 1).b(this.a.getTitleBarHeight());
    case -2: 
      do
      {
        return;
        this.a.jdField_a_of_type_Bhht.dismiss();
        AddFriendVerifyActivity.b(this.a, 1004);
      } while ((this.a.getIntent() == null) || (this.a.getIntent().getExtras() == null));
      if (this.a.getIntent().getExtras().getShort("group_option", (short)2) == 4)
      {
        if (AddFriendVerifyActivity.c(this.a) != null) {
          AddFriendVerifyActivity.c(this.a).setVisibility(0);
        }
        AddFriendVerifyActivity.b(this.a, 1002);
        return;
      }
      ((anca)this.a.app.getBusinessHandler(20)).b(Long.parseLong(this.a.jdField_a_of_type_JavaLangString), Long.parseLong(this.a.app.getAccount()));
      AddFriendVerifyActivity.a(this.a, true);
      return;
    case 0: 
    case 1: 
      this.a.jdField_a_of_type_Bhht.dismiss();
      Object localObject = this.a.getIntent().getStringExtra("param_return_addr");
      AddFriendVerifyActivity.b(this.a, 1003);
      if (localObject != null) {
        QQToast.a(this.a, 2, 2131717689, 1).b(this.a.getTitleBarHeight());
      }
      for (;;)
      {
        try
        {
          paramString = Class.forName((String)localObject);
          localObject = new Intent();
          ((Intent)localObject).setComponent(new ComponentName("com.tencent.mobileqq", paramString.getName()));
          ((Intent)localObject).setFlags(67108864);
          this.a.startActivity((Intent)localObject);
          if (TextUtils.isEmpty(this.a.d)) {
            break;
          }
          paramString = new ArrayList(1);
          paramString.add("admin.qun.qq.com");
          autn.a("closeJoinWebView", null, paramString, null);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.a.setResult(-1);
          this.a.finish();
          continue;
        }
        if (this.a.getIntent().getBooleanExtra("from_newer_guide", false))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
        }
        else if (this.a.getIntent().getBooleanExtra("from_babyq", false))
        {
          this.a.app.getMessageFacade().sendSpecialMessage("babyq_add_troop");
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
        }
        else
        {
          paramInt1 = this.a.getIntent().getExtras().getShort("group_option", (short)2);
          paramString = (anca)this.a.app.getBusinessHandler(20);
          if ((paramInt1 == 1) || (paramInt1 == 4)) {
            paramString.b(this.a.jdField_a_of_type_JavaLangString, false);
          } else {
            paramString.b(Long.parseLong(this.a.jdField_a_of_type_JavaLangString), Long.parseLong(this.a.app.getAccount()));
          }
        }
      }
    }
    AddFriendVerifyActivity.b(this.a, 1002);
    this.a.jdField_a_of_type_Bhht.dismiss();
    QQToast.a(this.a, 1, 2131719201, 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acps
 * JD-Core Version:    0.7.0.1
 */