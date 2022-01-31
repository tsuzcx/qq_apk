import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class aimt
  implements ActionSheet.OnButtonClickListener
{
  public aimt(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, SparseArray paramSparseArray, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      paramInt = -1;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      paramInt = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).intValue();
      break;
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment, 2);
      continue;
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment, 1);
      continue;
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimt
 * JD-Core Version:    0.7.0.1
 */