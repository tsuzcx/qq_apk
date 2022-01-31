import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.app.MobileQQ;

public class acab
  extends RecyclerView.Adapter<acac>
{
  abzz jdField_a_of_type_Abzz;
  
  public acab(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public acac a(ViewGroup paramViewGroup, int paramInt)
  {
    return new acac(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559576, paramViewGroup, false), this.jdField_a_of_type_Abzz);
  }
  
  public void a(abzz paramabzz)
  {
    this.jdField_a_of_type_Abzz = paramabzz;
  }
  
  public void a(acac paramacac, int paramInt)
  {
    paramacac.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt))
    {
      paramacac.a.setSelected(true);
      return;
    }
    paramacac.a.setSelected(false);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acab
 * JD-Core Version:    0.7.0.1
 */