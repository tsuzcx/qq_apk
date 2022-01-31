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
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class adji
  implements adif, Handler.Callback, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aeyy jdField_a_of_type_Aeyy;
  akfk jdField_a_of_type_Akfk = new adjk(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aynl jdField_a_of_type_Aynl = new adjj(this);
  ayny jdField_a_of_type_Ayny;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TogetherUIData jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
  private long jdField_b_of_type_Long;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public adji(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
    }
  }
  
  private aeyy a()
  {
    if (this.jdField_a_of_type_Aeyy == null)
    {
      this.jdField_a_of_type_Aeyy = new aeyy(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Aeyy);
      }
    }
    return this.jdField_a_of_type_Aeyy;
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
      aeyt localaeyt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
      if ((localaeyt == null) || (localaeyt == this.jdField_a_of_type_Aeyy)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Aeyy, new Object[0]);
    this.jdField_a_of_type_Aeyy.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom));
    ((aeom)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bz();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aynl);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfk);
    aync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Aynl);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      aync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      aync localaync = (aync)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
      if (localaync != null) {
        localaync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt);
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
  
  public void a(int paramInt, aeyt paramaeyt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip=" + paramaeyt + " type=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Aeyy == null) || (this.jdField_a_of_type_Aeyy == paramaeyt)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if ((aynp.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession())) && (!arkp.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int)) && (!e())) {}
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
        axqy.b((QQAppInterface)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
        label169:
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        bool1 = bool3;
        if (!bool4) {
          bool1 = true;
        }
        aynp.a(paramString, (ayno)localObject1, bool1);
        i();
        return;
        if (arkp.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int)) {
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
      if (((ayno)localObject1).k != 2) {
        break;
      }
      ((ayno)localObject1).k = 1;
      bool2 = bool1;
      break;
      localObject1 = "clk_fold";
      break label142;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d == 2)
      {
        localObject2 = aync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bool4) {}
        for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
        {
          ((aync)localObject2).a("video_tab", (String)localObject1, 2, paramString);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d != 4) {
        break label169;
      }
      localObject2 = aync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool4) {}
      for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
      {
        ((aync)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
        break;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Aeyy == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a() != this.jdField_a_of_type_Aeyy) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 8, 9, 11 };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onResume()");
    }
  }
  
  public void b(int paramInt, aeyt paramaeyt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsShow tip=" + paramaeyt + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Aeyy == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    aeyt localaeyt;
    do
    {
      return false;
      localaeyt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    } while ((localaeyt == null) || (localaeyt != this.jdField_a_of_type_Aeyy));
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
    aeyv localaeyv = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (localaeyv != null) {
      localaeyv.a(1003, new Object[0]);
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
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)aync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(2, i, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
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
    return (c()) && (arkp.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aynl);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfk);
    aync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Aynl);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
      b();
    }
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.reset();
    }
    if (this.jdField_a_of_type_Ayny != null)
    {
      this.jdField_a_of_type_Ayny.a();
      this.jdField_a_of_type_Ayny = null;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      bool1 = true;
    }
    ayno localayno;
    do
    {
      do
      {
        return bool1;
        localayno = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "isHideTogetherTip = " + localayno.k);
        }
        bool1 = bool2;
      } while (!(localayno instanceof WatchTogetherSession));
      bool1 = bool2;
    } while (localayno.k != 2);
    return true;
  }
  
  public void f()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_Ayny == null) {
      this.jdField_a_of_type_Ayny = new ayny(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364075);
    this.jdField_a_of_type_Ayny.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localView);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Ayny != null) && (this.jdField_a_of_type_Ayny.a());
  }
  
  public void g()
  {
    Object localObject = (amwi)ampl.a().a(553);
    if ((localObject != null) && (((amwi)localObject).a) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      if (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        break label137;
      }
    }
    for (int i = 2130849316;; i = 2130849317)
    {
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166851);
          localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130849317, i);
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
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131368436));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131375030));
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Object localObject = (amwi)ampl.a().a(553);
    if ((localObject != null) && (((amwi)localObject).a) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      int i;
      if (myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        i = 2130849316;
      }
      for (;;)
      {
        ((NavBarAIO)localObject).setRight2Icon(i);
        localObject = (avps)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)localObject).a(4, String.valueOf(130500));
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((avps)localObject).b(localAppInfo, "");
        }
        try
        {
          for (;;)
          {
            if (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
            {
              i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166851);
              localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130849317, i);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
            }
            if (AppSetting.d) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131699586));
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aW();
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + banb.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
            return;
            i = 2130849317;
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
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131377531) || (paramView.getId() == 2131377528)) {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
        }
      }
    }
    label745:
    while (paramView.getId() != 2131368436)
    {
      aync localaync;
      ayno localayno;
      int i;
      int j;
      for (;;)
      {
        return;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        if (!bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131697484, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null))
        {
          bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693235, 0).a();
          return;
        }
        localaync = (aync)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
        if (localaync != null)
        {
          localayno = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
          if ((localayno instanceof WatchTogetherSession))
          {
            paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            if (paramView != null)
            {
              paramView = aynp.a(true, paramView.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramView.isAdmin(), paramView.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
              switch (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().i)
              {
              default: 
                if (localaync.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1)) {
                  if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
                  }
                }
                break;
              }
              for (;;)
              {
                localaync.a("video_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                return;
                bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693235, 0).a();
                continue;
                localaync.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                localaync.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1, 2, 1, paramView);
                continue;
                localaync.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                aynp.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().j, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().h, null, paramView, 1);
              }
            }
          }
          else if ((localayno instanceof SingTogetherSession))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
            }
            paramView = null;
            i = -1;
            j = -1;
            localObject = new Bundle();
            String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            boolean bool = localaync.a(4, -1, localayno.jdField_e_of_type_JavaLangString);
            if (localayno.jdField_e_of_type_Int == 1)
            {
              j = 1;
              paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(localayno.jdField_e_of_type_JavaLangString);
              if (paramView != null)
              {
                localObject = aynp.a(bool, paramView.isTroopOwner(str), paramView.isAdmin(), paramView.troopowneruin, localayno.jdField_e_of_type_JavaLangString, 1);
                localaync.a("sing_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                i = 1;
                paramView = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
              }
            }
            else
            {
              while (!TextUtils.isEmpty(paramView))
              {
                if (!bool) {
                  break label745;
                }
                localaync.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localayno.jdField_e_of_type_JavaLangString, i, 4, j, (Bundle)localObject);
                return;
                if (localayno.jdField_e_of_type_Int == 2)
                {
                  localObject = aynp.a(bool, 4);
                  axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localayno.jdField_e_of_type_JavaLangString, "", "", "");
                  j = 4;
                  i = 2;
                  paramView = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                }
              }
            }
          }
        }
      }
      localaync.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localayno.jdField_e_of_type_JavaLangString, i, 4, j, (Bundle)localObject);
      return;
    }
    f();
    paramView = (avps)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
    Object localObject = paramView.a(10, String.valueOf(130500));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1)) {
      paramView.a((BusinessInfoCheckUpdate.AppInfo)localObject, "");
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + banb.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adji
 * JD-Core Version:    0.7.0.1
 */