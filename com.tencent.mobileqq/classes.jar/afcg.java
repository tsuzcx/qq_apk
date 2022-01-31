import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class afcg
  implements bepk
{
  private int jdField_a_of_type_Int;
  public Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new afch(this);
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private bepk jdField_a_of_type_Bepk = new afcj(this);
  public BaseChatPie a;
  public SessionInfo a;
  public QQAppInterface a;
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private boolean jdField_a_of_type_Boolean;
  public ViewGroup b;
  
  public afcg(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerCallbacks(this.jdField_a_of_type_Bepk);
    m();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private SystemBarCompact a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localFragment != null) {
        return ((ChatFragment)localFragment).a;
      }
    }
    return null;
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) && (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getParent() != null);
  }
  
  private boolean d()
  {
    boolean bool = true;
    if ((ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) || (azmk.b())) {
      bool = false;
    }
    return bool;
  }
  
  private void m()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null) {
      localNavBarAIO.addOnLayoutChangeListener(new afci(this, localNavBarAIO));
    }
  }
  
  private void n()
  {
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "addImmersiveTitleBar, isVisible: " + bool);
    }
    if (!bool)
    {
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 == null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = new ImmersiveTitleBar2(this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, localLayoutParams);
      ((TopGestureLayout)this.jdField_a_of_type_AndroidViewViewGroup).setPadding2(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewViewGroup.setFitsSystemWindows(false);
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.leftMargin += this.jdField_a_of_type_AndroidGraphicsRect.left;
      localLayoutParams.rightMargin += this.jdField_a_of_type_AndroidGraphicsRect.right;
      localLayoutParams.topMargin += this.jdField_a_of_type_AndroidGraphicsRect.top;
      localLayoutParams.bottomMargin += this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      this.b.setFitsSystemWindows(true);
      p();
    }
  }
  
  private void o()
  {
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "removeImmersiveTitleBar, isVisible: " + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      this.jdField_a_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (this.jdField_a_of_type_AndroidGraphicsRect != null)
      {
        localLayoutParams.leftMargin -= this.jdField_a_of_type_AndroidGraphicsRect.left;
        localLayoutParams.rightMargin -= this.jdField_a_of_type_AndroidGraphicsRect.right;
        localLayoutParams.topMargin -= this.jdField_a_of_type_AndroidGraphicsRect.top;
        localLayoutParams.bottomMargin -= this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      }
      this.b.setFitsSystemWindows(false);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label230;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (d()) {
        ImmersiveUtils.a(false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      }
      return;
      label230:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_Int, false);
    }
  }
  
  private void p()
  {
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "updateImmersiveTitleBar, isVisible: " + bool);
    }
    if (bool)
    {
      SystemBarCompact localSystemBarCompact = a();
      if (localSystemBarCompact != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localSystemBarCompact.mStatusBarDarwable;
        this.jdField_a_of_type_Int = localSystemBarCompact.mStatusBarColor;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(0, false);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label113;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (d()) {
        ImmersiveUtils.a(true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      }
      return;
      label113:
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(this.jdField_a_of_type_Int);
    }
  }
  
  protected abstract View a();
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidViewView = a();
      if (this.jdField_a_of_type_AndroidViewView == null) {}
      this.jdField_a_of_type_Boolean = true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.d("BaseChatDrawer", 1, "BaseChatDrawer createDrawerView oom", localOutOfMemoryError);
      }
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_AndroidViewView, 1);
      b();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a();
    }
    return false;
  }
  
  protected abstract void b();
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(1, paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a())) {
      p();
    }
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerEnabled(paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      l();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerCallbacks(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = null;
    }
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    o();
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, String.format("onDestroy, mHadInflated: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcg
 * JD-Core Version:    0.7.0.1
 */