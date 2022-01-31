import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.troop.createNewTroop.SubCateListView;
import com.tencent.mobileqq.troop.createNewTroop.SubCateListView.OnToggleSubListListener;

public class ains
  extends AnimatorListenerAdapter
{
  public ains(SubCateListView paramSubCateListView, boolean paramBoolean, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramAnimator = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramAnimator);
      i = UIUtils.b(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView.jdField_a_of_type_AndroidContentContext) - paramAnimator[1];
      if (i >= this.jdField_a_of_type_Int) {}
    }
    for (int i = this.jdField_a_of_type_Int - i;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener != null)
      {
        paramAnimator = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener;
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        paramAnimator.a(bool, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ains
 * JD-Core Version:    0.7.0.1
 */