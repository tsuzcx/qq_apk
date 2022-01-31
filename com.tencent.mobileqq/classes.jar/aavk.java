import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ARMapShuaMsgView;
import com.tencent.mobileqq.armap.ConversationARMap;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.ConversationActiveListViewListener;
import com.tencent.widget.HongBaoListView;

public class aavk
  implements ARMapHongBaoListView.ConversationActiveListViewListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public aavk(ConversationARMap paramConversationARMap) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onActivePendantClick" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.n();
      ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap, true);
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.f);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == this.jdField_a_of_type_Int) {
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "onOverScroll scrollY=0, mResume:" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_c_of_type_Boolean + "  mTitleIsVisible:" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.j);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.j) {
        break label329;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      label84:
      if (paramInt1 != 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_c_of_type_Boolean) {
          a(false);
        }
      }
      else
      {
        label103:
        this.jdField_a_of_type_Int = paramInt2;
        paramInt1 = -paramInt2;
        if (paramInt1 <= 0) {
          break label410;
        }
        if ((2 == this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int) || (3 == this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int))
        {
          paramInt2 = this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e - this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.f;
          if (paramInt2 == 0) {
            break label444;
          }
          float f2 = 1.0F * (paramInt2 - paramInt1) / paramInt2;
          f1 = f2;
          if (f2 >= 0.0F) {}
        }
      }
      label410:
      label444:
      for (float f1 = 0.0F;; f1 = 1.0F)
      {
        ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).setWealthGodOffset(f1);
        if (ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap)) {
          ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).a(true);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.a();
          this.jdField_a_of_type_Boolean = false;
          this.b = ((ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(189)).e();
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Boolean) || (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.d - 10) || (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_AndroidOsHandler.hasMessages(2004))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_AndroidOsHandler.removeMessages(2004);
        this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 0L);
        return;
        label329:
        if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning())) {
          break label449;
        }
        View localView = this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentMobileqqActivityConversation.b();
        if ((localView == null) || (((RelativeLayout.LayoutParams)localView.getLayoutParams()).topMargin == 0)) {
          break label449;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ConversationARMap", 2, "onOverScroll showTitle catch a display exception");
        }
        paramInt1 = 1;
        break label84;
        a(true);
        break label103;
        if ((2 != this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int) && (3 != this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int)) {
          break;
        }
        ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).setWealthGodOffset(1.0F);
        return;
      }
      label449:
      paramInt1 = 0;
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onTouchDown mState:" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int == 3)) && (-paramHongBaoListView.getScrollY() >= 0))
    {
      if ((ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap) != null) && (ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).a())) {
        ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).b();
      }
      ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap, true);
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_JavaLangRunnable);
    int i = -paramHongBaoListView.getScrollY();
    if ((paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int == 3)))
    {
      if (i >= 0)
      {
        if ((ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap) != null) && (ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).a())) {
          ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).b();
        }
        ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap, true);
      }
      if ((i > this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.i))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.n();
        this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.i = false;
      }
      if (i > this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_c_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConversationARMap", 2, "onTouchMoving mTitleIsVisible:" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.j);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.j) {
          b(false);
        }
        ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b(paramBoolean);
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    int j = 0;
    int k = -paramHongBaoListView.getScrollY();
    int i;
    if (k > 0) {
      if ((k < this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b) || ((!this.b) && (k <= this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_c_of_type_Int)))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.c(0);
        a(false);
        i = 1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "onTouchRelease, mState:" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_Int + "  runCase:" + i);
      }
      return;
      i = j;
      if (k >= this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b)
      {
        i = j;
        if (k <= this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_c_of_type_Int)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(0, null, this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView);
            ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).a();
            ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap).a(false);
            ConversationARMap.a(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap, false);
            this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.c(-this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b);
            a(false);
            i = 2;
          }
          catch (Exception paramHongBaoListView)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ConversationARMap", 2, "pullmsgArMap", paramHongBaoListView);
              }
            }
          }
          i = 3;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavk
 * JD-Core Version:    0.7.0.1
 */