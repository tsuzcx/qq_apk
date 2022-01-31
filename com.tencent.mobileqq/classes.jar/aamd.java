import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.Map;
import mqq.os.MqqHandler;

public class aamd
  extends ajii
  implements afqf, ajnk, Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private afdg jdField_a_of_type_Afdg;
  private afeh jdField_a_of_type_Afeh;
  private ajvu jdField_a_of_type_Ajvu = new aamf(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atdh jdField_a_of_type_Atdh = new aame(this);
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    Object localObject = (ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    if (QLog.isColorLevel()) {
      QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", fromResume = " + paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i;
    if (paramInt == 0)
    {
      localObject = ((ajnf)localObject).a();
      if ((localObject != null) && (((atcu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if (paramBoolean) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
        }
        localStringBuilder.append(a().getString(2131628967)).append(" 有更新");
        i = 1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
      beih.a(this.jdField_b_of_type_AndroidWidgetTextView, i, paramInt, 0);
      if ((paramInt <= 0) || (this.jdField_a_of_type_Afeh == null)) {
        break;
      }
      this.jdField_a_of_type_Afeh.g();
      return;
      if (ajvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        int j = 1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("NewFriendVerification.manager", 2, "contacts updateUnreadCount");
          i = j;
        }
      }
      else
      {
        localStringBuilder.append(a().getString(2131654169));
        do
        {
          i = 0;
          break;
        } while (paramInt <= 0);
        if (paramBoolean) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
        }
        i = 3;
        localStringBuilder.append(a().getString(2131628967)).append(" ");
        if (paramInt > 99) {
          localStringBuilder.append("多于99条未读");
        } else {
          localStringBuilder.append(paramInt).append("条未读");
        }
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)bacc.a(a(), 5.0F));
    this.jdField_a_of_type_Afeh.b();
    this.jdField_a_of_type_Afeh.a(this.jdField_a_of_type_Int);
    q();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298986));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299083));
    l();
    o();
  }
  
  private void o()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299070);
    this.jdField_a_of_type_Afdg = new afdg(a(), 2, localView);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131305065);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312089));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    u();
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131299082));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131309690));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302816));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131624088));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).a(21).e(10).a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311626));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310674));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848801);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131101257));
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atdh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvu);
    ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atdh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvu);
    ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(this);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void u()
  {
    int k = 0;
    boolean bool = awnu.b();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299070);
    int j;
    if (localView != null)
    {
      i = aciy.a(12.0F, a());
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (!bool) {
          break label181;
        }
        j = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      Object localObject = localView.findViewById(2131310475);
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (bool) {
          i = 0;
        }
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label186;
      }
      i = 2130844067;
      label122:
      localObject = localView.findViewById(2131299703);
      ((View)localObject).setBackgroundResource(i);
      if (!bool) {
        break label193;
      }
      j = 0;
      label145:
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131299704);
      localView.setBackgroundResource(i);
      if (!bool) {
        break label199;
      }
    }
    label181:
    label186:
    label193:
    label199:
    for (int i = k;; i = 8)
    {
      localView.setVisibility(i);
      return;
      j = i;
      break;
      i = 2130844066;
      break label122;
      j = 8;
      break label145;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131493276, null);
    this.jdField_a_of_type_Afeh = new afeh(a());
    this.jdField_a_of_type_Afeh.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected String a()
  {
    return a().getString(2131628426);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        z();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 1000000) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("BindMsgConstant", 2, "bind phone suc requestCode: " + paramInt1 + ", src: " + 12);
      return;
    } while (paramInt1 != 99999);
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void aj_() {}
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      r();
      this.jdField_a_of_type_Afeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      l();
      ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
    } while (this.jdField_a_of_type_Afdg == null);
    this.jdField_a_of_type_Afdg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  protected void d()
  {
    super.d();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Afeh == null) {
      return;
    }
    this.jdField_a_of_type_Afeh.h();
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    this.jdField_a_of_type_Afeh.a(paramBoolean);
    a(((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d(), true);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      String str = a(2131628426);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      a().setTitle(a(2131628426));
    }
    if (this.jdField_a_of_type_Afdg != null) {
      this.jdField_a_of_type_Afdg.a();
    }
    t();
    ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Afeh.j();
    }
  }
  
  protected void e()
  {
    s();
    if (this.jdField_a_of_type_Afeh != null) {
      this.jdField_a_of_type_Afeh.e();
    }
  }
  
  protected void f()
  {
    super.f();
    n();
    r();
    ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
  }
  
  public void h()
  {
    ApngImage.pauseByTag(3);
    super.h();
    this.jdField_a_of_type_Afeh.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        d(true);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9529, 300L);
      return true;
    } while (this.jdField_a_of_type_Afeh == null);
    this.jdField_a_of_type_Afeh.l();
    return true;
  }
  
  public void i_(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void j()
  {
    super.j();
    if (this.jdField_a_of_type_Afdg != null) {
      this.jdField_a_of_type_Afdg.b();
    }
    this.jdField_a_of_type_Afeh.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    s();
  }
  
  public void k()
  {
    l();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      u();
      aidv.a.clear();
      return;
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848801);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131101257));
    }
  }
  
  void l()
  {
    int i = 2130838504;
    if (this.jdField_a_of_type_Afeh != null) {
      this.jdField_a_of_type_Afeh.i();
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "setThemeDiyBgContacts mBgImageView == null");
      }
    }
    View localView;
    do
    {
      return;
      ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidWidgetImageView, 3, 2130838504, "-contacts-");
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310933);
    } while (localView == null);
    if (ThemeUtil.isDefaultTheme()) {
      i = 2130839104;
    }
    localView.setBackgroundResource(i);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302816: 
      paramView = new Intent(a(), AddContactsActivity.class);
      paramView.putExtra("entrence_data_report", 1);
      paramView.putExtra("EntranceId", 3);
      a(paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf(101200));
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F18", "0X8007F18", 1, 0, "", "", "", "");
    NewFriendActivity.a(a(), null, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aamd
 * JD-Core Version:    0.7.0.1
 */