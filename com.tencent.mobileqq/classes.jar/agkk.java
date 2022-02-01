import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

public class agkk
  implements agin, Handler.Callback, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private ailu jdField_a_of_type_Ailu;
  private Handler jdField_a_of_type_AndroidOsHandler;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  aocm jdField_a_of_type_Aocm = new agkm(this);
  private beke jdField_a_of_type_Beke = new agkl(this);
  bemx jdField_a_of_type_Bemx;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TogetherUIData jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public agkk(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
    }
  }
  
  private ailu a()
  {
    if (this.jdField_a_of_type_Ailu == null)
    {
      this.jdField_a_of_type_Ailu = new ailu(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a(this.jdField_a_of_type_Ailu);
      }
    }
    return this.jdField_a_of_type_Ailu;
  }
  
  private void a(bekh parambekh)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "invokeJoinDialog activity or intent is null");
      }
    }
    while (!beki.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), parambekh, this.jdField_a_of_type_Boolean)) {
      return;
    }
    b(((bejv)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(parambekh.jdField_e_of_type_Int));
  }
  
  private void b(String paramString)
  {
    ThreadManagerV2.executeOnSubThread(new TogetherControlHelper.3(this, paramString));
  }
  
  private void c(String paramString)
  {
    bejv localbejv = (bejv)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    localbejv.a("video_tab", "exp_joinframe", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
    h();
    String str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698959), new Object[] { paramString });
    paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698962), new Object[] { paramString });
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131690697);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131694399);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, null, paramString, str2, str3, new agkn(this, localbejv, str1), new agko(this, localbejv));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageMaxLine(1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      ailp localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
      if ((localailp == null) || (localailp == this.jdField_a_of_type_Ailu)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a(this.jdField_a_of_type_Ailu, new Object[0]);
    this.jdField_a_of_type_Ailu.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    return true;
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).v();
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab));
    ((agab)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).b();
  }
  
  private boolean h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return true;
    }
    return false;
  }
  
  private void i()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      }
    }
    bejv localbejv;
    bekh localbekh;
    int i;
    int j;
    Bundle localBundle;
    for (;;)
    {
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131720169, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131692995, 0).a();
        return;
      }
      localbejv = (bejv)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      if (localbejv != null)
      {
        localbekh = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        Object localObject;
        if ((localbekh instanceof WatchTogetherSession))
        {
          localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
          if (localObject != null)
          {
            localObject = beki.a(true, ((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, 0);
            switch (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().j)
            {
            default: 
              if (localbejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin(), 1)) {
                if (QLog.isColorLevel()) {
                  QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
                }
              }
              break;
            }
            for (;;)
            {
              localbejv.a("video_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
              return;
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131692995, 0).a();
              continue;
              localbejv.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
              localbejv.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin(), 1, 2, 1, (Bundle)localObject);
              continue;
              localbejv.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
              beki.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().k, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_JavaLangString, null, (Bundle)localObject, 1);
            }
          }
        }
        else if ((localbekh instanceof SingTogetherSession))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
          }
          localObject = null;
          i = -1;
          j = -1;
          localBundle = new Bundle();
          String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin();
          boolean bool = localbejv.a(4, -1, localbekh.jdField_e_of_type_JavaLangString);
          if (localbekh.f == 1)
          {
            j = 1;
            localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(localbekh.jdField_e_of_type_JavaLangString);
            if (localObject != null)
            {
              localBundle = beki.a(bool, ((TroopInfo)localObject).isTroopOwner(str), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, localbekh.jdField_e_of_type_JavaLangString, 1);
              localbejv.a("sing_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
              i = 1;
              localObject = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
            }
          }
          else
          {
            while (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if (!bool) {
                break label742;
              }
              localbejv.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localbekh.jdField_e_of_type_JavaLangString, i, 4, j, localBundle);
              return;
              if (localbekh.f == 2)
              {
                localBundle = beki.a(bool, 4);
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localbekh.jdField_e_of_type_JavaLangString, "", "", "");
                j = 4;
                i = 2;
                localObject = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
              }
            }
          }
        }
      }
    }
    label742:
    localbejv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localbekh.jdField_e_of_type_JavaLangString, i, 4, j, localBundle);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("open_together_panel", false))) {
      b(3);
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) {
      return "";
    }
    boolean bool = a();
    return this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getSubTitleText(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Beke);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Aocm);
    bejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_Beke);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      bejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      bejv localbejv = (bejv)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      if (localbejv != null) {
        localbejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, paramInt);
      }
      return;
      a();
      continue;
      b();
      continue;
      c();
      continue;
      d();
      continue;
      e();
      continue;
      j();
    }
  }
  
  public void a(int paramInt, ailp paramailp)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip=" + paramailp + " type=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Ailu == null) || (this.jdField_a_of_type_Ailu == paramailp)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if ((beki.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession())) && (!avxi.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f)) && (!e())) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide expand=" + bool);
      }
      if (bool) {
        g();
      }
      h();
      return;
      bool = false;
    }
  }
  
  public void a(String paramString)
  {
    boolean bool3 = false;
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {}
    boolean bool4;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null));
      bool4 = a();
      if (!bool4) {
        break;
      }
      bool2 = b();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onSubTitleClicked isPanelShow= " + bool4 + " handle=" + bool2);
      }
    } while (!bool2);
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f == 2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
      if (!bool4)
      {
        localObject1 = "clk_expand";
        label142:
        bdla.b((QQAppInterface)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
        label173:
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        bool1 = bool3;
        if (!bool4) {
          bool1 = true;
        }
        beki.a(paramString, (bekh)localObject1, bool1);
        h();
        return;
        if (avxi.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f)) {
          break label425;
        }
      }
    }
    label425:
    for (boolean bool1 = g();; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
      bool2 = bool1;
      if (!(localObject1 instanceof WatchTogetherSession)) {
        break;
      }
      bool2 = bool1;
      if (((bekh)localObject1).l != 2) {
        break;
      }
      ((bekh)localObject1).l = 1;
      bool2 = bool1;
      break;
      localObject1 = "clk_fold";
      break label142;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int == 2)
      {
        localObject2 = bejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
        if (!bool4) {}
        for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
        {
          ((bejv)localObject2).a("video_tab", (String)localObject1, 2, paramString);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int != 4) {
        break label173;
      }
      localObject2 = bejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
      if (!bool4) {}
      for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
      {
        ((bejv)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
        break;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() == null) || (this.jdField_a_of_type_Ailu == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a() != this.jdField_a_of_type_Ailu) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 4, 7, 6, 10, 11, 14 };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void b(int paramInt)
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_Bemx == null) {
      this.jdField_a_of_type_Bemx = new bemx(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364488);
    this.jdField_a_of_type_Bemx.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localView, paramInt);
  }
  
  public void b(int paramInt, ailp paramailp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsShow tip=" + paramailp + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Ailu == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    ailp localailp;
    do
    {
      return false;
      localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
    } while ((localailp == null) || (localailp != this.jdField_a_of_type_Ailu));
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "currTip is togetherTip");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onPause()");
    }
    this.jdField_a_of_type_Boolean = false;
    ailr localailr = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager();
    if (localailr != null) {
      localailr.a(1003, new Object[0]);
    }
    h();
  }
  
  public void c(int paramInt)
  {
    b(paramInt);
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a(10, String.valueOf(130500));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
      localbbbq.a(localAppInfo, "");
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)), "");
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) && (QLog.isColorLevel())) {
        QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper isTogetherTime mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_h_of_type_Int == 0)) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onStop()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType() == 1) {
      i = 1;
    }
    for (;;)
    {
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)bejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(2, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin());
      if ((localWatchTogetherSession == null) || (localWatchTogetherSession.jdField_h_of_type_Int != 1) || (localWatchTogetherSession.i == 2) || (localWatchTogetherSession.l != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onStop() hideTogetherTip");
      }
      localWatchTogetherSession.l = 2;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType() == 0) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
  
  public boolean d()
  {
    return (c()) && (avxi.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().f));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Beke);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aocm);
    bejv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).b(this.jdField_a_of_type_Beke);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() != null) {
      b();
    }
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.reset();
    }
    if (this.jdField_a_of_type_Bemx != null)
    {
      this.jdField_a_of_type_Bemx.a();
      this.jdField_a_of_type_Bemx = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      bool1 = true;
    }
    bekh localbekh;
    do
    {
      do
      {
        return bool1;
        localbekh = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "isHideTogetherTip = " + localbekh.l);
        }
        bool1 = bool2;
      } while (!(localbekh instanceof WatchTogetherSession));
      bool1 = bool2;
    } while (localbekh.l != 2);
    return true;
  }
  
  public void f()
  {
    Object localObject = (argm)aqxe.a().a(553);
    if ((localObject != null) && (((argm)localObject).jdField_a_of_type_Boolean) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView;
      if (!nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) {
        break label137;
      }
    }
    for (int i = 2130850448;; i = 2130850449)
    {
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167023);
          localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850449, i);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        label137:
        QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_Bemx != null) && (this.jdField_a_of_type_Bemx.a())) {
      return true;
    }
    return h();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131369240));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131376435));
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = (argm)aqxe.a().a(553);
    if ((localObject2 != null) && (((argm)localObject2).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) && (localObject1 != null) && (!((TroopManager)localObject1).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView;
      int i;
      if (nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) {
        i = 2130850448;
      }
      for (;;)
      {
        ((NavBarAIO)localObject1).setRight2Icon(i);
        localObject1 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
        localObject2 = ((bbbq)localObject1).a(4, String.valueOf(130500));
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((bbbq)localObject1).b((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
        }
        try
        {
          for (;;)
          {
            if (!nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))
            {
              i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167023);
              localObject1 = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850449, i);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            }
            if (AppSetting.c) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131698960));
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.adjustTitleDimension();
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)), "");
            return;
            i = 2130850449;
            break;
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      c((String)paramMessage.obj);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131379194) || (paramView.getId() == 2131379191)) {
      i();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131369240) {
        c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkk
 * JD-Core Version:    0.7.0.1
 */