import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agwp
  implements agvc, Handler.Callback, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aiwk jdField_a_of_type_Aiwk;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  aogi jdField_a_of_type_Aogi = new agwr(this);
  private bekg jdField_a_of_type_Bekg = new agwq(this);
  bemd jdField_a_of_type_Bemd;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TogetherUIData jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
  private long jdField_b_of_type_Long;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public agwp(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
    }
  }
  
  private aiwk a()
  {
    if (this.jdField_a_of_type_Aiwk == null)
    {
      this.jdField_a_of_type_Aiwk = new aiwk(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Aiwk);
      }
    }
    return this.jdField_a_of_type_Aiwk;
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      aiwf localaiwf = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
      if ((localaiwf == null) || (localaiwf == this.jdField_a_of_type_Aiwk)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Aiwk, new Object[0]);
    this.jdField_a_of_type_Aiwk.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bF();
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijm));
    ((aijm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bz();
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) {
      return "";
    }
    boolean bool = a();
    return this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getSubTitleText(bool, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bekg);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogi);
    bejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Bekg);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      bejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      bejx localbejx = (bejx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
      if (localbejx != null) {
        localbejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt);
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
    }
  }
  
  public void a(int paramInt, aiwf paramaiwf)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip=" + paramaiwf + " type=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Aiwk == null) || (this.jdField_a_of_type_Aiwk == paramaiwf)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if ((bekk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession())) && (!awen.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int)) && (!e())) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide expand=" + bool);
      }
      if (bool) {
        g();
      }
      i();
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
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int == 2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool4)
      {
        localObject1 = "clk_expand";
        label142:
        bdll.b((QQAppInterface)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
        label169:
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        bool1 = bool3;
        if (!bool4) {
          bool1 = true;
        }
        bekk.a(paramString, (bekj)localObject1, bool1);
        i();
        return;
        if (awen.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int)) {
          break label422;
        }
      }
    }
    label422:
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
      if (((bekj)localObject1).k != 2) {
        break;
      }
      ((bekj)localObject1).k = 1;
      bool2 = bool1;
      break;
      localObject1 = "clk_fold";
      break label142;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d == 2)
      {
        localObject2 = bejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bool4) {}
        for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
        {
          ((bejx)localObject2).a("video_tab", (String)localObject1, 2, paramString);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d != 4) {
        break label169;
      }
      localObject2 = bejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool4) {}
      for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
      {
        ((bejx)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
        break;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Aiwk == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a() != this.jdField_a_of_type_Aiwk) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 9, 10, 13 };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onResume()");
    }
  }
  
  public void b(int paramInt, aiwf paramaiwf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsShow tip=" + paramaiwf + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Aiwk == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    aiwf localaiwf;
    do
    {
      return false;
      localaiwf = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    } while ((localaiwf == null) || (localaiwf != this.jdField_a_of_type_Aiwk));
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "currTip is togetherTip");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onPause()");
    }
    aiwh localaiwh = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (localaiwh != null) {
      localaiwh.a(1003, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) && (QLog.isColorLevel())) {
        QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper isTogetherTime mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().g == 3) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().g == 0)) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onStop()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b() == 1) {
      i = 1;
    }
    for (;;)
    {
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)bejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(2, i, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      if ((localWatchTogetherSession == null) || (localWatchTogetherSession.g != 1) || (localWatchTogetherSession.h == 2) || (localWatchTogetherSession.k != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onStop() hideTogetherTip");
      }
      localWatchTogetherSession.k = 2;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b() == 0) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
  
  public boolean d()
  {
    return (c()) && (awen.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bekg);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogi);
    bejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Bekg);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
      b();
    }
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.reset();
    }
    if (this.jdField_a_of_type_Bemd != null)
    {
      this.jdField_a_of_type_Bemd.a();
      this.jdField_a_of_type_Bemd = null;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      bool1 = true;
    }
    bekj localbekj;
    do
    {
      do
      {
        return bool1;
        localbekj = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "isHideTogetherTip = " + localbekj.k);
        }
        bool1 = bool2;
      } while (!(localbekj instanceof WatchTogetherSession));
      bool1 = bool2;
    } while (localbekj.k != 2);
    return true;
  }
  
  public void f()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_Bemd == null) {
      this.jdField_a_of_type_Bemd = new bemd(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364389);
    this.jdField_a_of_type_Bemd.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localView);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Bemd != null) && (this.jdField_a_of_type_Bemd.a());
  }
  
  public void g()
  {
    Object localObject = (arjm)aran.a().a(553);
    if ((localObject != null) && (((arjm)localObject).a) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        break label137;
      }
    }
    for (int i = 2130850421;; i = 2130850422)
    {
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166987);
          localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850422, i);
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
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131369051));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131376418));
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject2 = (arjm)aran.a().a(553);
    if ((localObject2 != null) && (((arjm)localObject2).a) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (localObject1 != null) && (!((TroopManager)localObject1).h(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      int i;
      if (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        i = 2130850421;
      }
      for (;;)
      {
        ((NavBarAIO)localObject1).setRight2Icon(i);
        localObject1 = (bbav)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        localObject2 = ((bbav)localObject1).a(4, String.valueOf(130500));
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((bbav)localObject1).b((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
        }
        try
        {
          for (;;)
          {
            if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
            {
              i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166987);
              localObject1 = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130850422, i);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            }
            if (AppSetting.c) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131698479));
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aU();
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + bguq.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
            return;
            i = 2130850422;
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
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131379131) || (paramView.getId() == 2131379128)) {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131696546, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131692838, 0).a();
      }
      else
      {
        bejx localbejx = (bejx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
        if (localbejx != null)
        {
          bekj localbekj = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
          Object localObject1;
          if ((localbekj instanceof WatchTogetherSession))
          {
            localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            if (localObject1 != null)
            {
              localObject1 = bekk.a(true, ((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), ((TroopInfo)localObject1).isAdmin(), ((TroopInfo)localObject1).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
              switch (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().i)
              {
              default: 
                if (localbejx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1)) {
                  if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
                  }
                }
                break;
              }
              for (;;)
              {
                localbejx.a("video_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                break;
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131692838, 0).a();
                continue;
                localbejx.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                localbejx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1, 2, 1, (Bundle)localObject1);
                continue;
                localbejx.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                bekk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().j, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().h, null, (Bundle)localObject1, 1);
              }
            }
          }
          else if ((localbekj instanceof SingTogetherSession))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
            }
            localObject1 = null;
            int i = -1;
            int j = -1;
            Object localObject2 = new Bundle();
            String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            boolean bool = localbejx.a(4, -1, localbekj.jdField_e_of_type_JavaLangString);
            if (localbekj.jdField_e_of_type_Int == 1)
            {
              j = 1;
              localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(localbekj.jdField_e_of_type_JavaLangString);
              if (localObject1 != null)
              {
                localObject2 = bekk.a(bool, ((TroopInfo)localObject1).isTroopOwner(str), ((TroopInfo)localObject1).isAdmin(), ((TroopInfo)localObject1).troopowneruin, localbekj.jdField_e_of_type_JavaLangString, 1);
                localbejx.a("sing_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                i = 1;
                localObject1 = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
              }
            }
            else
            {
              for (;;)
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label782;
                }
                if (!bool) {
                  break label784;
                }
                localbejx.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localbekj.jdField_e_of_type_JavaLangString, i, 4, j, (Bundle)localObject2);
                break;
                if (localbekj.jdField_e_of_type_Int == 2)
                {
                  localObject2 = bekk.a(bool, 4);
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localbekj.jdField_e_of_type_JavaLangString, "", "", "");
                  j = 4;
                  i = 2;
                  localObject1 = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                }
              }
              label782:
              continue;
              label784:
              localbejx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localbekj.jdField_e_of_type_JavaLangString, i, 4, j, (Bundle)localObject2);
              continue;
              if (paramView.getId() == 2131369051)
              {
                f();
                localObject1 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
                localObject2 = ((bbav)localObject1).a(10, String.valueOf(130500));
                if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
                  ((bbav)localObject1).a((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
                }
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + bguq.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwp
 * JD-Core Version:    0.7.0.1
 */