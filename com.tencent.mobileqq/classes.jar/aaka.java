import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class aaka
  implements bfph
{
  public aaka(AssociatedAccountActivity paramAssociatedAccountActivity, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Bfpc.cancel();
    paramView = (ayax)this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.a.iterator();
    while (localIterator.hasNext()) {
      paramView.c(((SubAccountInfo)localIterator.next()).subuin);
    }
    AssociatedAccountActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.getString(2131690809));
    AssociatedAccountActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaka
 * JD-Core Version:    0.7.0.1
 */