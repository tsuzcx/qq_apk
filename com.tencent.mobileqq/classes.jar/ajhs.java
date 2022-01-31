import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;

public class ajhs
  implements DialogInterface.OnClickListener
{
  public ajhs(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, HomeworkInfo paramHomeworkInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (SubmitHomeWorkFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment) > 0L)
    {
      SubmitHomeWorkFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo);
      return;
    }
    SubmitHomeWorkFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment, 3, null, null, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhs
 * JD-Core Version:    0.7.0.1
 */