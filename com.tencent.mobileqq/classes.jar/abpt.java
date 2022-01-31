import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.app.MobileQQ;

public class abpt
  extends RecyclerView.Adapter<abpu>
{
  abpr jdField_a_of_type_Abpr;
  
  public abpt(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public abpu a(ViewGroup paramViewGroup, int paramInt)
  {
    return new abpu(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131494006, paramViewGroup, false), this.jdField_a_of_type_Abpr);
  }
  
  public void a(abpr paramabpr)
  {
    this.jdField_a_of_type_Abpr = paramabpr;
  }
  
  public void a(abpu paramabpu, int paramInt)
  {
    paramabpu.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt))
    {
      paramabpu.a.setSelected(true);
      return;
    }
    paramabpu.a.setSelected(false);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpt
 * JD-Core Version:    0.7.0.1
 */