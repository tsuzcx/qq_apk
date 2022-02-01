import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import java.util.List;

public class aeyl
  implements bliz
{
  public aeyl(MainFragment paramMainFragment, List paramList, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.e();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    try
    {
      MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue(), (aeys)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second);
      this.jdField_a_of_type_Blir.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyl
 * JD-Core Version:    0.7.0.1
 */