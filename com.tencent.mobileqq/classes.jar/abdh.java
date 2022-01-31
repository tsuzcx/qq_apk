import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import java.util.List;

public class abdh
  implements begw
{
  public abdh(MainFragment paramMainFragment, List paramList, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.e();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    try
    {
      MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue(), (abdm)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second);
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdh
 * JD-Core Version:    0.7.0.1
 */