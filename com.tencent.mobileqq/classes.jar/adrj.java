import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.app.MobileQQ;

public class adrj
  extends RecyclerView.Adapter<adrk>
{
  adrh jdField_a_of_type_Adrh;
  
  public adrj(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public adrk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new adrk(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559628, paramViewGroup, false), this.jdField_a_of_type_Adrh);
  }
  
  public void a(adrh paramadrh)
  {
    this.jdField_a_of_type_Adrh = paramadrh;
  }
  
  public void a(adrk paramadrk, int paramInt)
  {
    paramadrk.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt))
    {
      paramadrk.a.setSelected(true);
      return;
    }
    paramadrk.a.setSelected(false);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrj
 * JD-Core Version:    0.7.0.1
 */