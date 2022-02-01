import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afsn
  implements afrc
{
  private long jdField_a_of_type_Long;
  private afsr jdField_a_of_type_Afsr = new afso(this);
  public View a;
  private betp jdField_a_of_type_Betp;
  private beuh jdField_a_of_type_Beuh;
  private bevp jdField_a_of_type_Bevp;
  private bhdq jdField_a_of_type_Bhdq = new afsq(this);
  protected BaseChatPie a;
  public AppShortcutBarScrollView a;
  private String jdField_a_of_type_JavaLangString;
  protected List<afsr> a;
  protected boolean a;
  protected boolean b;
  private boolean c;
  private boolean d;
  
  public afsn(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((afsr)localIterator.next()).a(paramInt);
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "resetBlurViewTopMargin");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mBottomBlurView != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mBottomBlurView.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mBottomBlurView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return 0L;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo is null");
        return 0L;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo.curFriendUin is null");
      return 0L;
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty is Exception");
    return 0L;
  }
  
  protected View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie is null");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie.app is null");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie.mAIORootView is null");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = a();
        this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
        if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mTroopUinStr: " + this.jdField_a_of_type_JavaLangString);
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131558585, null));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) {
            this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372222);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mAppShortcutBarView is null");
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init got OOM, e:" + localOutOfMemoryError.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init got InflateException, e:" + localInflateException.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
          return;
        }
      }
    }
    this.jdField_a_of_type_Beuh = new beuj(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
    this.jdField_a_of_type_Bevp = new bevi(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
    this.jdField_a_of_type_Betp = new bets(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new afsp(this));
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "initData.");
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131368751);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setMove(true);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      c();
      return;
    case 5: 
      b();
      return;
    }
    d();
  }
  
  public void a(int paramInt, ArrayList<betu> paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "onUpdatePanel from: " + paramInt + "bShowManageBtn" + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) && (this.jdField_a_of_type_Beuh != null) && (this.jdField_a_of_type_Bevp != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      if (paramInt == 0) {
        if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_Beuh.a()))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          switch (paramInt)
          {
          }
        }
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            continue;
            if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_Bevp.a())) {
              this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            } else {
              this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
          }
        } while (this.jdField_a_of_type_Bevp == null);
        this.jdField_a_of_type_Bevp.a(paramArrayList, paramBoolean);
        return;
      } while (this.jdField_a_of_type_Beuh == null);
      this.jdField_a_of_type_Beuh.a(paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(afsr paramafsr)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramafsr)) {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "addShortcutBarVisibilityListener. mOnVisibilityChangedListeners already contains listener");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ShortcutBarAIOHelper", 2, "addShortcutBarVisibilityListener.");
      }
      this.jdField_a_of_type_JavaUtilList.add(paramafsr);
      return;
    }
    QLog.e("ShortcutBarAIOHelper", 2, "addShortcutBarVisibilityListener. mOnVisibilityChangedListeners is null");
  }
  
  public void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_Betp == null)) {
      return;
    }
    this.jdField_a_of_type_Betp.b(paramView.getTag());
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (a() == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131371466);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376868);
  }
  
  public void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView == null) || (a() == null)) {}
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (paramRelativeLayout != null)
      {
        i = j;
        if ((TextView)paramRelativeLayout.findViewById(2131371466) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131371466);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376868);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "notifyAIOIceBreakViewShowingStatus isShow = " + paramBoolean);
    }
    this.b = paramBoolean;
    if (paramBoolean)
    {
      h();
      return;
    }
    g();
  }
  
  public boolean a()
  {
    boolean bool = this.c;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "triggerSyncOnce() syncOnce = " + bool);
    }
    return bool;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!b()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (paramMotionEvent == null)) {
      bool = false;
    }
    int i;
    int j;
    do
    {
      return bool;
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getLocationOnScreen(paramMotionEvent);
    } while (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getWidth(), paramMotionEvent[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight()).contains(i, j));
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 13 };
  }
  
  protected int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieResume");
    }
    if (this.d) {
      this.d = false;
    }
    if (this.jdField_a_of_type_Beuh != null) {
      this.jdField_a_of_type_Beuh.c();
    }
    if (this.jdField_a_of_type_Bevp != null) {
      this.jdField_a_of_type_Bevp.c();
    }
    if (this.jdField_a_of_type_Betp != null) {
      this.jdField_a_of_type_Betp.c();
    }
  }
  
  public void b(afsr paramafsr)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramafsr)) {
        if (QLog.isColorLevel()) {
          QLog.i("ShortcutBarAIOHelper", 2, "removeShortcutBarVisibilityListener.");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramafsr);
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ShortcutBarAIOHelper", 2, "removeShortcutBarVisibilityListener.mOnVisibilityChangedListeners doesn't contain listener");
      return;
    }
    QLog.e("ShortcutBarAIOHelper", 2, "removeShortcutBarVisibilityListener.mOnVisibilityChangedListeners is null");
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.b) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      }
    }
    while ((this.jdField_a_of_type_Beuh == null) || (this.jdField_a_of_type_Bevp == null) || (this.jdField_a_of_type_Boolean) || ((!this.jdField_a_of_type_Beuh.a()) && (!this.jdField_a_of_type_Bevp.a()))) {
      return false;
    }
    return true;
  }
  
  protected int c()
  {
    return 0;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieCreate");
    }
    a();
    a(this.jdField_a_of_type_Afsr);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mDrawerFrame.a(this.jdField_a_of_type_Bhdq);
    }
    if (this.jdField_a_of_type_Beuh != null) {
      this.jdField_a_of_type_Beuh.b();
    }
    if (this.jdField_a_of_type_Bevp != null) {
      this.jdField_a_of_type_Bevp.b();
    }
    if (this.jdField_a_of_type_Betp != null) {
      this.jdField_a_of_type_Betp.b();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "onChatPieDestroy. null check return. ");
      }
      return;
    }
    if (this.jdField_a_of_type_Beuh != null)
    {
      this.jdField_a_of_type_Beuh.a();
      this.jdField_a_of_type_Beuh = null;
    }
    if (this.jdField_a_of_type_Bevp != null)
    {
      this.jdField_a_of_type_Bevp.a();
      this.jdField_a_of_type_Bevp = null;
    }
    if (this.jdField_a_of_type_Betp != null)
    {
      this.jdField_a_of_type_Betp.a();
      this.jdField_a_of_type_Betp = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "onChatPieDestroy. ");
    }
    h();
    b(this.jdField_a_of_type_Afsr);
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent() != null) && ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mDrawerFrame.b(this.jdField_a_of_type_Bhdq);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    this.d = false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setAppShortcutBarVisible");
    }
    a().setVisibility(0);
    b(0);
  }
  
  public void f()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout");
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mBottomBlurView.getLayoutParams();
    int i;
    if ((a() != null) && (a().isShown()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with scroll_panel_app_shorts");
      }
      i = ViewUtils.dip2px(39.0F);
      boolean bool = nmy.a().a(this.jdField_a_of_type_JavaLangString);
      if ((ThemeUtil.isSimpleDayTheme(false)) || (bool))
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getBackground();
        if (localDrawable != null)
        {
          localDrawable = localDrawable.getConstantState().newDrawable();
          a().setBackgroundDrawable(localDrawable);
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout marginTop = " + i);
      }
      localLayoutParams.topMargin = (i * -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mBottomBlurView.setLayoutParams(localLayoutParams);
      return;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app))
      {
        a().setBackgroundColor(-16777216);
      }
      else
      {
        a().setBackgroundResource(0);
        continue;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with inputBar");
          i = j;
        }
      }
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (a() == null) || (this.jdField_a_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar mIsInputJump" + this.jdField_a_of_type_Boolean);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.b) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar return for AIOIceBreakViewShowing");
        return;
      } while (!b());
      aftj localaftj = (aftj)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(23);
      if ((localaftj == null) || (!localaftj.b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "resumeAppShorcutBar");
    }
    a().setPadding(a(), c(), b(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloViewController.c(2131376868);
    }
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.requestLayout();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (a() == null)) {}
    while (a().getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "hideAppShortcutBar");
    }
    boolean bool = a().isShown();
    a().setPadding(a(), c(), b(), 0);
    a().setVisibility(8);
    b(8);
    if (bool) {
      b(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.requestLayout();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (paramView == null) || (this.jdField_a_of_type_Betp == null)) {
      return;
    }
    this.jdField_a_of_type_Betp.a(paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsn
 * JD-Core Version:    0.7.0.1
 */