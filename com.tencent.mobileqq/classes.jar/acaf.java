import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.app.MobileQQ;

public class acaf
  extends RecyclerView.Adapter<acag>
{
  acad jdField_a_of_type_Acad;
  
  public acaf(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public acag a(ViewGroup paramViewGroup, int paramInt)
  {
    return new acag(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559576, paramViewGroup, false), this.jdField_a_of_type_Acad);
  }
  
  public void a(acad paramacad)
  {
    this.jdField_a_of_type_Acad = paramacad;
  }
  
  public void a(acag paramacag, int paramInt)
  {
    paramacag.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt))
    {
      paramacag.a.setSelected(true);
      return;
    }
    paramacag.a.setSelected(false);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acaf
 * JD-Core Version:    0.7.0.1
 */