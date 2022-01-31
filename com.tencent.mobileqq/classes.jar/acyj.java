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

public class acyj
  implements acxg, Handler.Callback, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aeoe jdField_a_of_type_Aeoe;
  ajrb jdField_a_of_type_Ajrb = new acyl(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private axnc jdField_a_of_type_Axnc = new acyk(this);
  axnp jdField_a_of_type_Axnp;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TogetherUIData jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
  ImageView b;
  
  public acyj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
    }
  }
  
  private aeoe a()
  {
    if (this.jdField_a_of_type_Aeoe == null)
    {
      this.jdField_a_of_type_Aeoe = new aeoe(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Aeoe);
      }
    }
    return this.jdField_a_of_type_Aeoe;
  }
  
  private boolean e()
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
      aenz localaenz = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
      if ((localaenz == null) || (localaenz == this.jdField_a_of_type_Aeoe)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Aeoe, new Object[0]);
    this.jdField_a_of_type_Aeoe.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb)) {
        ((aejb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bD();
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aedo));
    ((aedo)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bx();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axnc);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajrb);
    axmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Axnc);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb)) {
      axmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      axmt localaxmt = (axmt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
      if (localaxmt != null) {
        localaxmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt);
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
  
  public void a(int paramInt, aenz paramaenz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip=" + paramaenz + " type=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Aeoe == null) || (this.jdField_a_of_type_Aeoe == paramaenz)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    boolean bool = axng.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession());
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide expand=" + bool);
    }
    if (bool) {
      e();
    }
    i();
  }
  
  public void a(String paramString)
  {
    boolean bool2 = false;
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {}
    boolean bool3;
    boolean bool1;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null));
      bool3 = a();
      if (!bool3) {
        break;
      }
      bool1 = b();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onSubTitleClicked isPanelShow= " + bool3 + " handle=" + bool1);
      }
    } while (!bool1);
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().jdField_e_of_type_Int == 2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool3)
      {
        localObject1 = "clk_expand";
        label138:
        awqx.b((QQAppInterface)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
      }
    }
    do
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      axng.a(paramString, (axnf)localObject1, bool1);
      i();
      return;
      bool1 = e();
      break;
      localObject1 = "clk_fold";
      break label138;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d == 2)
      {
        localObject2 = axmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bool3) {}
        for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
        {
          ((axmt)localObject2).a("video_tab", (String)localObject1, 2, paramString);
          break;
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().d != 4);
    Object localObject2 = axmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!bool3) {}
    for (Object localObject1 = "clk_expand";; localObject1 = "clk_fold")
    {
      ((axmt)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
      break;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Aeoe == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a() != this.jdField_a_of_type_Aeoe) {
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
  
  public void b(int paramInt, aenz paramaenz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsShow tip=" + paramaenz + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Aeoe == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    aenz localaenz;
    do
    {
      return false;
      localaenz = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    } while ((localaenz == null) || (localaenz != this.jdField_a_of_type_Aeoe));
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
    aeob localaeob = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (localaeob != null) {
      localaeob.a(1003, new Object[0]);
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
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Axnp != null) && (this.jdField_a_of_type_Axnp.a());
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axnc);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrb);
    axmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Axnc);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
      b();
    }
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.reset();
    }
    if (this.jdField_a_of_type_Axnp != null)
    {
      this.jdField_a_of_type_Axnp.a();
      this.jdField_a_of_type_Axnp = null;
    }
  }
  
  public void f()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_Axnp == null) {
      this.jdField_a_of_type_Axnp = new axnp(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131298518);
    this.jdField_a_of_type_Axnp.a((aejb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localView);
  }
  
  public void g()
  {
    Object localObject;
    if ((((amgf)alzw.a().a(553)).a) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      if (!mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        break label131;
      }
    }
    for (int i = 2130849072;; i = 2130849073)
    {
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131101257);
          localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130849073, i);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        label131:
        QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131302811));
    }
    if (this.b == null) {
      this.b = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131309284));
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.b == null)) {
      return;
    }
    if ((((amgf)alzw.a().a(553)).a) && (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      int i;
      if (mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        i = 2130849072;
      }
      for (;;)
      {
        ((NavBarAIO)localObject).setRight2Icon(i);
        localObject = (auqh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject).a(4, String.valueOf(130500));
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
        {
          this.b.setVisibility(0);
          ((auqh)localObject).b(localAppInfo, "");
        }
        try
        {
          for (;;)
          {
            if (!mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
            {
              i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131101257);
              localObject = ThemeUtil.drawableTint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130849073, i);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
            }
            if (AppSetting.c) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131633793));
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aU();
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + azlj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
            return;
            i = 2130849073;
            break;
            this.b.setVisibility(8);
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
    this.b.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131311717) || (paramView.getId() == 2131311714)) {
      if (!badq.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131631771, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
    }
    label685:
    while (paramView.getId() != 2131302811)
    {
      axmt localaxmt;
      axnf localaxnf;
      int i;
      int j;
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null))
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131627594, 0).a();
          return;
        }
        localaxmt = (axmt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
        if (localaxmt != null)
        {
          localaxnf = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
          if ((localaxnf instanceof WatchTogetherSession))
          {
            paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            if (paramView != null)
            {
              paramView = axng.a(true, paramView.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramView.isAdmin(), paramView.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
              switch (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().i)
              {
              default: 
                if (localaxmt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1)) {
                  if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
                  }
                }
                break;
              }
              for (;;)
              {
                localaxmt.a("video_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                return;
                bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131627594, 0).a();
                continue;
                localaxmt.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                localaxmt.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1, 2, 1, paramView);
                continue;
                localaxmt.a("video_tab", "clk_join_suc", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                axng.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().j, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().h, null, paramView, 1);
              }
            }
          }
          else if ((localaxnf instanceof SingTogetherSession))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
            }
            paramView = null;
            i = -1;
            j = -1;
            localObject = new Bundle();
            String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            boolean bool = localaxmt.a(4, -1, localaxnf.jdField_e_of_type_JavaLangString);
            if (localaxnf.jdField_e_of_type_Int == 1)
            {
              j = 1;
              paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(localaxnf.jdField_e_of_type_JavaLangString);
              if (paramView != null)
              {
                localObject = axng.a(bool, paramView.isTroopOwner(str), paramView.isAdmin(), paramView.troopowneruin, localaxnf.jdField_e_of_type_JavaLangString, 1);
                localaxmt.a("sing_tab", "clk_join", 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                i = 1;
                paramView = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
              }
            }
            else
            {
              while (!TextUtils.isEmpty(paramView))
              {
                if (!bool) {
                  break label685;
                }
                localaxmt.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localaxnf.jdField_e_of_type_JavaLangString, i, 4, j, (Bundle)localObject);
                return;
                if (localaxnf.jdField_e_of_type_Int == 2)
                {
                  localObject = axng.a(bool, 4);
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localaxnf.jdField_e_of_type_JavaLangString, "", "", "");
                  j = 4;
                  i = 2;
                  paramView = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                }
              }
            }
          }
        }
      }
      localaxmt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localaxnf.jdField_e_of_type_JavaLangString, i, 4, j, (Bundle)localObject);
      return;
    }
    f();
    paramView = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(36);
    Object localObject = paramView.a(10, String.valueOf(130500));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1)) {
      paramView.a((BusinessInfoCheckUpdate.AppInfo)localObject, "");
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + azlj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyj
 * JD-Core Version:    0.7.0.1
 */