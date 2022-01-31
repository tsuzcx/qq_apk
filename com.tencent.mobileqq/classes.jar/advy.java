import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.app.MobileQQ;

public class advy
  extends RecyclerView.Adapter<advz>
{
  advw jdField_a_of_type_Advw;
  
  public advy(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public advz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new advz(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559627, paramViewGroup, false), this.jdField_a_of_type_Advw);
  }
  
  public void a(advw paramadvw)
  {
    this.jdField_a_of_type_Advw = paramadvw;
  }
  
  public void a(advz paramadvz, int paramInt)
  {
    paramadvz.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt))
    {
      paramadvz.a.setSelected(true);
      return;
    }
    paramadvz.a.setSelected(false);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advy
 * JD-Core Version:    0.7.0.1
 */