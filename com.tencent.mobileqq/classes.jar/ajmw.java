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
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class ajmw
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static int a;
  private volatile View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhtd jdField_a_of_type_Bhtd;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int jdField_b_of_type_Int;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = aepi.a(50.0F, BaseApplicationImpl.getApplication().getResources());
  }
  
  public ajmw(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramViewGroup.findViewById(2131375404));
    i();
    b();
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
    if (!bhtk.a()) {}
    label147:
    label160:
    label165:
    for (;;)
    {
      return false;
      Object localObject1 = (RecentBaseData)paramObject;
      if (((RecentBaseData)localObject1).a()) {}
      for (int i = ((RecentBaseData)localObject1).b();; i = 0)
      {
        if (i == 0) {
          break label165;
        }
        Object localObject2;
        if ((paramObject instanceof RecentUserBaseData))
        {
          localObject1 = (RecentUserBaseData)paramObject;
          localObject2 = ((RecentUserBaseData)localObject1).mUser;
          if (localObject2 != null)
          {
            String str = ((RecentUser)localObject2).uin;
            localObject2 = ((RecentUser)localObject2).msg;
            if ((localObject2 instanceof ajmn))
            {
              i = 1;
              boolean bool = BaseApplicationImpl.getContext().getResources().getString(2131699996).equals(((RecentUserBaseData)localObject1).mContentDesc);
              if ((i == 0) && (!bool)) {
                break label147;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          if ((i == 0) && (!a(paramObject))) {
            break label160;
          }
          return true;
          if ((localObject2 instanceof ajlx))
          {
            ((ajlx)localObject2).a();
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
          paramObject = ((auga)localAppRuntime.getManager(37)).a(paramObject.mUser.uin, 100);
          if ((paramObject != null) && (paramObject.size() > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void h()
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
  
  private void i()
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
    CareNotificationBar.1 local1 = new CareNotificationBar.1(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      return;
    }
    this.jdField_a_of_type_Bhtd.post(local1);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
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
      for (int i = 1381653; paramView.getTag(2131374185) == null; i = 11580351)
      {
        paramView.setTag(2131374185, paramView.getBackground());
        paramView.post(new CareNotificationBar.2(this, paramView, i, j));
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
  
  public boolean a(ajit paramajit)
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
      int m = paramajit.getCount();
      k = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.g + 1;
      if (k >= m) {
        break label135;
      }
      localObject = paramajit.getItem(k);
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
      str = ((RecentUserBaseData)paramObject).a();
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label109;
      }
      localObject = ((QQAppInterface)localObject).c();
    }
    label109:
    for (bool1 = akey.a((String)localObject + str);; bool1 = false)
    {
      boolean bool3 = BaseApplicationImpl.getContext().getResources().getString(2131717874).equals(((RecentUserBaseData)paramObject).mMsgExtroInfo);
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
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.s) {
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
    if (k < ((ajit)localObject1).getCount())
    {
      Object localObject2 = ((ajit)localObject1).getItem(k);
      if (!(localObject2 instanceof RecentBaseData)) {
        break label462;
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
        if ((i == 0) && (j > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 100;
          if (k != this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f) {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversation.g = -1;
          }
          if (this.jdField_b_of_type_Int != i)
          {
            this.jdField_b_of_type_Int = i;
            if ((i <= 0) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
              break label386;
            }
            azqs.b(null, "dc00898", "", "", "0X800A493", "0X800A493", 0, 0, "", "", "", "");
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
            if (QLog.isColorLevel()) {
              QLog.d("CareNotificationBar", 2, "refresh: invoked. exposed~");
            }
          }
          label264:
          if (this.c != j)
          {
            this.c = j;
            if (j != 0) {
              break label401;
            }
            this.d = 0;
          }
        }
        label386:
        label401:
        label460:
        for (;;)
        {
          QLog.e("CareNotificationBar", 1, new Object[] { "refresh: care=", Integer.valueOf(i), " keyword=", Integer.valueOf(j) });
          localObject1 = new CareNotificationBar.3(this);
          this.jdField_a_of_type_Bhtd.post((Runnable)localObject1);
          return;
          if ((i > 0) && (j == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 17;
            break;
          }
          if ((i <= 0) || (this.jdField_b_of_type_Int != 0)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.f = 17;
          break;
          if (i != 0) {
            break label264;
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          break label264;
          if (i > 0) {}
          for (k = 1;; k = 2)
          {
            if (k == this.d) {
              break label460;
            }
            this.d = k;
            azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A8F9", k, 1, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        label462:
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
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375407));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375406));
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
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131717875, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    for (int i = 2130839351;; i = 2130847007)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(i);
      return;
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131699990, new Object[] { Integer.valueOf(this.c) });
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "onConversationResume: invoked. ");
    }
    if (!bhtk.a()) {
      a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375403);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375407);
    if (bool)
    {
      localLinearLayout.setBackgroundResource(2130849017);
      localTextView.setTextColor(Color.parseColor("#ee7f31"));
      return;
    }
    localLinearLayout.setBackgroundResource(2130850079);
  }
  
  public void f()
  {
    b();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (localLayoutParams.topMargin != jdField_a_of_type_Int)
      {
        localLayoutParams.topMargin = jdField_a_of_type_Int;
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8) {
          this.jdField_a_of_type_AndroidViewView.requestLayout();
        }
      }
    }
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
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.y();
    } while (this.c <= 0);
    azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A8FA", this.d, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmw
 * JD-Core Version:    0.7.0.1
 */