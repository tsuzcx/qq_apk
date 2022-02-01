import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class alfl
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static int a;
  private final akyf jdField_a_of_type_Akyf;
  private volatile View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkgm jdField_a_of_type_Bkgm;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private final FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int jdField_b_of_type_Int;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = afur.a(57.0F, BaseApplicationImpl.getApplication().getResources());
  }
  
  public alfl(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramViewGroup.findViewById(2131376132));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramViewGroup.findViewById(2131376119));
    j();
    b();
    this.jdField_a_of_type_Akyf = new alfm(this);
    akyg.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a).a(this.jdField_a_of_type_Akyf);
  }
  
  private int a(Object paramObject)
  {
    if (b(paramObject)) {
      return 17;
    }
    if (c(paramObject)) {
      return 100;
    }
    return -1;
  }
  
  private boolean b(Object paramObject)
  {
    if (!bkgt.a()) {}
    label150:
    label163:
    label168:
    for (;;)
    {
      return false;
      Object localObject1 = (RecentBaseData)paramObject;
      if (((RecentBaseData)localObject1).isUnreadMsgNumInTabNum()) {}
      for (int i = ((RecentBaseData)localObject1).getUnreadNum();; i = 0)
      {
        if (i == 0) {
          break label168;
        }
        Object localObject2;
        if ((paramObject instanceof RecentUserBaseData))
        {
          localObject1 = (RecentUserBaseData)paramObject;
          localObject2 = (RecentUser)((RecentUserBaseData)localObject1).mUser;
          if (localObject2 != null)
          {
            String str = ((RecentUser)localObject2).uin;
            localObject2 = ((RecentUser)localObject2).msg;
            if ((localObject2 instanceof alff))
            {
              i = 1;
              boolean bool = BaseApplicationImpl.getContext().getResources().getString(2131698419).equals(((RecentUserBaseData)localObject1).mContentDesc);
              if ((i == 0) && (!bool)) {
                break label150;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          if ((i == 0) && (!a(paramObject))) {
            break label163;
          }
          return true;
          if ((localObject2 instanceof aleq))
          {
            ((aleq)localObject2).a();
            i = 0;
            break;
            i = 0;
            continue;
          }
          i = 0;
          break;
          i = 0;
        }
        break;
      }
    }
  }
  
  private boolean c(Object paramObject)
  {
    if ((paramObject instanceof RecentUserBaseData))
    {
      paramObject = (RecentUserBaseData)paramObject;
      if (paramObject.mUser.getType() == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface))
        {
          paramObject = ((bfiv)localAppRuntime.getManager(363)).a(paramObject.mUser.uin, 100);
          if ((paramObject != null) && (paramObject.size() > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void i()
  {
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "show: invoked. ");
    }
    g();
    if ((bool) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "hide: invoked. ");
    }
    CareNotificationBar.2 local2 = new CareNotificationBar.2(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local2.run();
      return;
    }
    this.jdField_a_of_type_Bkgm.post(local2);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Bkgm.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j;
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
        j = 872415231;
      }
      for (int i = 1381653; paramView.getTag(2131374904) == null; i = 11580351)
      {
        paramView.setTag(2131374904, paramView.getBackground());
        paramView.post(new CareNotificationBar.3(this, paramView, i, j));
        return;
        j = 335743002;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CareNotificationBar", 4, new Object[] { "setMiniAppVisible: invoked. ", " visible: ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean a(albc paramalbc)
  {
    boolean bool2 = false;
    int j = 0;
    boolean bool1 = bool2;
    label14:
    int k;
    label31:
    Object localObject;
    if (j < 2)
    {
      int m = paramalbc.getCount();
      k = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.g + 1;
      if (k >= m) {
        break label135;
      }
      localObject = paramalbc.getItem(k);
      if ((localObject instanceof RecentBaseData)) {}
    }
    label135:
    label183:
    label186:
    for (;;)
    {
      k += 1;
      break label31;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f == 17)
      {
        if (a(localObject) != 17) {
          break label183;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label186;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.g = k;
        bool1 = true;
        return bool1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f == 100) && (a(localObject) == 100))
        {
          i = 1;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.g = -1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f == 17)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 100;
            break label14;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 17;
          j += 1;
          break;
        }
        i = 0;
      }
    }
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String str;
    Object localObject;
    if ((paramObject instanceof RecentUserBaseData))
    {
      str = ((RecentUserBaseData)paramObject).getRecentUserUin();
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label109;
      }
      localObject = ((QQAppInterface)localObject).c();
    }
    label109:
    for (bool1 = alxx.a((String)localObject + str);; bool1 = false)
    {
      boolean bool3 = BaseApplicationImpl.getContext().getResources().getString(2131716036).equals(((RecentUserBaseData)paramObject).mMsgExtroInfo);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.r) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("CareNotificationBar", 1, "refresh: miniApp is visible.");
      a();
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    if (k < ((albc)localObject1).getCount())
    {
      Object localObject2 = ((albc)localObject1).getItem(k);
      if (!(localObject2 instanceof RecentBaseData)) {
        break label500;
      }
      m = a(localObject2);
      if (m == 17)
      {
        m = j;
        j = i + 1;
        i = m;
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      i = m;
      break;
      if (m == 100)
      {
        m = j + 1;
        j = i;
        i = m;
        continue;
        k = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f;
        if ((i == 0) && (j > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 100;
        }
        for (;;)
        {
          if (k != this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f) {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversation.g = -1;
          }
          if ((bkgt.a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f != 17)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CareNotificationBar", 2, "refresh: invoked. careBar setting disabled");
          }
          a();
          return;
          if ((i > 0) && (j == 0)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 17;
          } else if ((i > 0) && (this.jdField_b_of_type_Int == 0)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 17;
          }
        }
        if (this.jdField_b_of_type_Int != i)
        {
          this.jdField_b_of_type_Int = i;
          if ((i <= 0) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
            break label424;
          }
          bcst.b(null, "dc00898", "", "", "0X800A493", "0X800A493", 0, 0, "", "", "", "");
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
          if (QLog.isColorLevel()) {
            QLog.d("CareNotificationBar", 2, "refresh: invoked. exposed~");
          }
        }
        if (this.c != j)
        {
          this.c = j;
          if (j != 0) {
            break label439;
          }
          this.d = 0;
        }
        label424:
        label439:
        label498:
        for (;;)
        {
          QLog.e("CareNotificationBar", 1, new Object[] { "refresh: care=", Integer.valueOf(i), " keyword=", Integer.valueOf(j) });
          localObject1 = new CareNotificationBar.4(this);
          this.jdField_a_of_type_Bkgm.post((Runnable)localObject1);
          return;
          if (i != 0) {
            break;
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          break;
          if (i > 0) {}
          for (k = 1;; k = 2)
          {
            if (k == this.d) {
              break label498;
            }
            this.d = k;
            bcst.b(null, "dc00898", "", "", "qq_vip", "0X800A8F9", k, 1, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        label500:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376135));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376134));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      e();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f == 17) {
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131716037, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    for (int i = 2130839530;; i = 2130847464)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(i);
      return;
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131698412, new Object[] { Integer.valueOf(this.c) });
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "onConversationResume: invoked. ");
    }
    if (!bkgt.a()) {
      a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376131);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376135);
    if (bool)
    {
      localLinearLayout.setBackgroundResource(2130849554);
      localTextView.setTextColor(Color.parseColor("#ee7f31"));
      return;
    }
    localLinearLayout.setBackgroundResource(2130850671);
  }
  
  public void f()
  {
    b();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      float f1 = BaseApplication.context.getResources().getDimension(2131298369);
      float f2 = jdField_a_of_type_Int;
      j = (int)(f1 * i + f2);
      if (QLog.isColorLevel()) {
        QLog.d("CareNotificationBar", 2, new Object[] { "updateTopMargin: invoked. ", " bannerViewsCount: ", Integer.valueOf(i) });
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (localLayoutParams.topMargin != j)
      {
        localLayoutParams.topMargin = j;
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8) {
          this.jdField_a_of_type_AndroidViewView.requestLayout();
        }
      }
    }
  }
  
  public void h()
  {
    akyg.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a).b(this.jdField_a_of_type_Akyf);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.w();
      if (this.c > 0) {
        bcst.b(null, "dc00898", "", "", "qq_vip", "0X800A8FA", this.d, 1, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfl
 * JD-Core Version:    0.7.0.1
 */