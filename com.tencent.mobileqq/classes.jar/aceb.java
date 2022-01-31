import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.util.Pair;

public class aceb
  implements DialogInterface.OnClickListener
{
  public aceb(SubAccountUgActivity paramSubAccountUgActivity, ayao paramayao, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Ayao.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!ayao.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.setTitle("");
      ayan.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aceb
 * JD-Core Version:    0.7.0.1
 */