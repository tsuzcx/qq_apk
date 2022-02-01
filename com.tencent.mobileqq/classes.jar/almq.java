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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class almq
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static int a;
  private final aldf jdField_a_of_type_Aldf;
  private volatile View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkys jdField_a_of_type_Bkys;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private final FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int jdField_b_of_type_Int;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = AIOUtils.dp2px(57.0F, BaseApplicationImpl.getApplication().getResources());
  }
  
  public almq(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramViewGroup.findViewById(2131376285));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramViewGroup.findViewById(2131376272));
    k();
    b();
    this.jdField_a_of_type_Aldf = new almr(this);
    aldg.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a).a(this.jdField_a_of_type_Aldf);
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
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f;
    if ((paramInt1 == 0) && (paramInt2 > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 100;
    }
    for (;;)
    {
      if (i != this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g = -1;
      }
      return;
      if ((paramInt1 > 0) && (paramInt2 == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 17;
      } else if ((paramInt1 > 0) && (this.jdField_b_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 17;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Int != paramInt1)
    {
      this.jdField_b_of_type_Int = paramInt1;
      if ((paramInt1 <= 0) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        break label98;
      }
      bdla.b(null, "dc00898", "", "", "0X800A493", "0X800A493", 0, 0, "", "", "", "");
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
      if (QLog.isColorLevel()) {
        QLog.d("CareNotificationBar", 2, "refresh: invoked. exposed~");
      }
    }
    if (this.c != paramInt2)
    {
      this.c = paramInt2;
      if (paramInt2 != 0) {
        break label113;
      }
      this.d = 0;
    }
    for (;;)
    {
      return;
      label98:
      if (paramInt1 != 0) {
        break;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      break;
      label113:
      if (paramInt1 > 0) {}
      for (paramInt1 = 1; paramInt1 != this.d; paramInt1 = 2)
      {
        this.d = paramInt1;
        bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A8F9", paramInt1, 1, 0, "", "", "", "");
        return;
      }
    }
  }
  
  private boolean b(Object paramObject)
  {
    if (!bkyy.a()) {}
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
            if ((localObject2 instanceof alln))
            {
              i = 1;
              boolean bool = BaseApplicationImpl.getContext().getResources().getString(2131699084).equals(((RecentUserBaseData)localObject1).mContentDesc);
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
          if ((localObject2 instanceof alky))
          {
            ((alky)localObject2).a();
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
  
  private boolean c()
  {
    if ((!bkyy.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CareNotificationBar", 2, new Object[] { "needHideWhenCurrentTypeSpCared: invoked. careBar setting disabled", " hide: ", Boolean.valueOf(bool) });
      }
      return bool;
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
          paramObject = ((bfzk)localAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(paramObject.mUser.uin, 100);
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
    CareNotificationBar.4 local4 = new CareNotificationBar.4(this);
    this.jdField_a_of_type_Bkys.post(local4);
  }
  
  private void k()
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
    this.jdField_a_of_type_Bkys.post(local2);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
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
      for (int i = 1381653; paramView.getTag(2131375047) == null; i = 11580351)
      {
        paramView.setTag(2131375047, paramView.getBackground());
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
  
  public boolean a(algc paramalgc)
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
      int m = paramalgc.getCount();
      k = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g + 1;
      if (k >= m) {
        break label135;
      }
      localObject = paramalgc.getItem(k);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17)
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
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g = k;
        bool1 = true;
        return bool1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 100) && (a(localObject) == 100))
        {
          i = 1;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g = -1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 100;
            break label14;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 17;
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
      localObject = ((QQAppInterface)localObject).getCurrentUin();
    }
    label109:
    for (bool1 = amci.a((String)localObject + str);; bool1 = false)
    {
      boolean bool3 = BaseApplicationImpl.getContext().getResources().getString(2131716740).equals(((RecentUserBaseData)paramObject).mMsgExtroInfo);
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
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.r) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("CareNotificationBar", 1, "refresh: miniApp is visible.");
      a();
      return;
    }
    algc localalgc = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < localalgc.getCount())
    {
      Object localObject = localalgc.getItem(j);
      int m = k;
      int n = i;
      int i1;
      if ((localObject instanceof RecentBaseData))
      {
        i1 = a(localObject);
        if (i1 != 17) {
          break label117;
        }
        n = i + 1;
        m = k;
      }
      for (;;)
      {
        j += 1;
        k = m;
        i = n;
        break;
        label117:
        m = k;
        n = i;
        if (i1 == 100)
        {
          m = k + 1;
          n = i;
        }
      }
    }
    a(i, k);
    if (c())
    {
      a();
      return;
    }
    b(i, k);
    QLog.e("CareNotificationBar", 1, new Object[] { "refresh: care=", Integer.valueOf(i), " keyword=", Integer.valueOf(k) });
    j();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376288));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376287));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      e();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17) {
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131716741, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    for (int i = 2130839595;; i = 2130847478)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(i);
      return;
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131699044, new Object[] { Integer.valueOf(this.c) });
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "onConversationResume: invoked. ");
    }
    if (!bkyy.a()) {
      a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376284);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376288);
    if (bool)
    {
      localLinearLayout.setBackgroundResource(2130849565);
      localTextView.setTextColor(Color.parseColor("#ee7f31"));
      return;
    }
    localLinearLayout.setBackgroundResource(2130850743);
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
      float f1 = BaseApplication.context.getResources().getDimension(2131298451);
      float f2 = jdField_a_of_type_Int;
      j = (int)(f1 * i + f2);
      if (QLog.isColorLevel()) {
        QLog.d("CareNotificationBar", 2, new Object[] { "updateTopMargin: invoked. ", " bannerViewsCount: ", Integer.valueOf(i), " margin=", Integer.valueOf(j) });
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
    aldg.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a).b(this.jdField_a_of_type_Aldf);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.x();
      if (this.c > 0) {
        bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A8FA", this.d, 1, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almq
 * JD-Core Version:    0.7.0.1
 */