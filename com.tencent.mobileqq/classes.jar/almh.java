import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class almh
  implements ActionSheet.OnButtonClickListener
{
  public almh(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.c == 1) {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.f(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity).dismiss();
      return;
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e();
        } else {
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.g(this.jdField_a_of_type_JavaLangString);
        }
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.g(this.jdField_a_of_type_JavaLangString);
        continue;
        if (paramInt == 0) {
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.f(this.jdField_a_of_type_JavaLangString);
        } else if (paramInt == 1) {
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.g(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     almh
 * JD-Core Version:    0.7.0.1
 */