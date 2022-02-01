import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;

public class afrx
  implements bkhe
{
  public int a;
  public boolean a;
  
  public afrx(VisitorsActivity paramVisitorsActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "mLastTop=" + this.jdField_a_of_type_Int + ",mHeaderVisible=" + this.jdField_a_of_type_Boolean + ",firstVi=" + paramInt1);
    }
    paramAbsListView = paramAbsListView.getChildAt(0);
    boolean bool;
    label246:
    Object localObject;
    CharSequence localCharSequence;
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      paramInt1 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() == 0) {
        paramInt1 = 0 + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getHeight();
      }
      paramInt1 = (int)(paramInt1 + VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity) * 77.0F);
      paramInt2 = paramInt1 - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f;
      paramInt3 = Math.abs(paramAbsListView.getTop());
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() != 8) {
          break label344;
        }
        bool = true;
        QLog.d("VisitorsActivity", 2, String.format("sumH=%d top=%d offset=%d tabBarShow=%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
      }
      if ((paramInt3 <= this.jdField_a_of_type_Int) || (paramInt3 < paramInt1) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() != 8)) {
        break label350;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
      localObject = null;
      localCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.getText();
      if ((paramInt3 <= this.jdField_a_of_type_Int) || (paramInt3 < paramInt2) || (!"".equals(localCharSequence))) {
        break label398;
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.getAnimation()))
      {
        paramAbsListView.reset();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.d) {
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.centerView.startAnimation(paramAbsListView);
        }
      }
      this.jdField_a_of_type_Int = paramInt3;
      return;
      label344:
      bool = false;
      break;
      label350:
      if ((paramInt3 >= this.jdField_a_of_type_Int) || (paramInt3 > paramInt1) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getVisibility() != 0)) {
        break label246;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
      break label246;
      label398:
      paramAbsListView = localObject;
      if (paramInt3 < this.jdField_a_of_type_Int)
      {
        paramAbsListView = localObject;
        if (paramInt3 <= paramInt2)
        {
          paramAbsListView = localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaLangString.equals(localCharSequence)) {
            paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VersionUtils.isOreo())
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrx
 * JD-Core Version:    0.7.0.1
 */