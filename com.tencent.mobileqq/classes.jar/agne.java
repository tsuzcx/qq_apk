import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class agne
  implements agma
{
  private long jdField_a_of_type_Long;
  public View a;
  private bfkg jdField_a_of_type_Bfkg;
  private bfku jdField_a_of_type_Bfku;
  private bfmc jdField_a_of_type_Bfmc;
  private bhwq jdField_a_of_type_Bhwq = new agnh(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public AppShortcutBarScrollView a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public agne(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
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
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo is null");
        return 0L;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo.curFriendUin is null");
      return 0L;
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty is Exception");
    return 0L;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie is null");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie.app is null");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c == null)
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558580, null));
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.addOnLayoutChangeListener(new agnf(this));
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372142);
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
    this.jdField_a_of_type_Bfku = new bfkw(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
    this.jdField_a_of_type_Bfmc = new bflv(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
    this.jdField_a_of_type_Bfkg = new bfkj(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new agng(this));
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "initData.");
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131368652);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
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
  
  public void a(int paramInt, ArrayList<bfkl> paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "onUpdatePanel from: " + paramInt + "bShowManageBtn" + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) && (this.jdField_a_of_type_Bfku != null) && (this.jdField_a_of_type_Bfmc != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      if (paramInt == 0) {
        if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_Bfku.a()))
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
            if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_Bfmc.a())) {
              this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            } else {
              this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
          }
        } while (this.jdField_a_of_type_Bfmc == null);
        this.jdField_a_of_type_Bfmc.a(paramArrayList, paramBoolean);
        return;
      } while (this.jdField_a_of_type_Bfku == null);
      this.jdField_a_of_type_Bfku.a(paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Bfkg == null)) {
      return;
    }
    this.jdField_a_of_type_Bfkg.b(paramView.getTag());
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131371391);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376977);
  }
  
  public void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (paramRelativeLayout != null)
      {
        i = j;
        if ((TextView)paramRelativeLayout.findViewById(2131371391) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131371391);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376977);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = false;
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
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieResume");
    }
    if (this.b) {
      this.b = false;
    }
    if (this.jdField_a_of_type_Bfku != null) {
      this.jdField_a_of_type_Bfku.c();
    }
    if (this.jdField_a_of_type_Bfmc != null) {
      this.jdField_a_of_type_Bfmc.c();
    }
    if (this.jdField_a_of_type_Bfkg != null) {
      this.jdField_a_of_type_Bfkg.c();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bfku != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bfmc != null)
      {
        bool1 = bool2;
        if (!this.c) {
          if (!this.jdField_a_of_type_Bfku.a())
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_Bfmc.a()) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieCreate");
    }
    a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_Bhwq);
    }
    if (this.jdField_a_of_type_Bfku != null) {
      this.jdField_a_of_type_Bfku.b();
    }
    if (this.jdField_a_of_type_Bfmc != null) {
      this.jdField_a_of_type_Bfmc.b();
    }
    if (this.jdField_a_of_type_Bfkg != null) {
      this.jdField_a_of_type_Bfkg.b();
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "onChatPieDestroy. null check return. ");
      }
      return;
    }
    if (this.jdField_a_of_type_Bfku != null)
    {
      this.jdField_a_of_type_Bfku.a();
      this.jdField_a_of_type_Bfku = null;
    }
    if (this.jdField_a_of_type_Bfmc != null)
    {
      this.jdField_a_of_type_Bfmc.a();
      this.jdField_a_of_type_Bfmc = null;
    }
    if (this.jdField_a_of_type_Bfkg != null)
    {
      this.jdField_a_of_type_Bfkg.a();
      this.jdField_a_of_type_Bfkg = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "onChatPieDestroy. ");
    }
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_Bhwq);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.c = false;
    this.b = false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setAppShortcutBarVisible");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(0);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout");
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.isShown()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with scroll_panel_app_shorts");
      }
      localLayoutParams.addRule(6, 2131376977);
      boolean bool = njo.a().a(this.jdField_a_of_type_JavaLangString);
      if ((ThemeUtil.isSimpleDayTheme(false)) || (bool))
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
        if (localDrawable != null)
        {
          localDrawable = localDrawable.getConstantState().newDrawable();
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundDrawable(localDrawable);
        }
        localLayoutParams.addRule(6, 2131368652);
        return;
      }
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundColor(-16777216);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundResource(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with inputBar");
    }
    localLayoutParams.addRule(6, 2131368652);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.c)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar mIsInputJump" + this.c);
      }
    }
    do
    {
      do
      {
        return;
      } while (!b());
      agnt localagnt = (agnt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if ((localagnt == null) || (!localagnt.b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "resumeAppShorcutBar");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Amje != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Amje.b(2131376977);
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestLayout();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "hideAppShortcutBar");
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams()).addRule(6, 2131368652);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.isShown();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(8);
    if (bool) {
      a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestLayout();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (paramView == null) || (this.jdField_a_of_type_Bfkg == null)) {
      return;
    }
    this.jdField_a_of_type_Bfkg.a(paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agne
 * JD-Core Version:    0.7.0.1
 */