import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.home.MainFragment;
import java.util.List;

public class ajzm
  implements bkzq
{
  public ajzm(MainFragment paramMainFragment, List paramList, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.f();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    try
    {
      MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue(), (ajzs)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second);
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzm
 * JD-Core Version:    0.7.0.1
 */