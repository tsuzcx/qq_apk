import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

public class aflm
  extends RecyclerView.Adapter<afln>
{
  aflk jdField_a_of_type_Aflk;
  
  public aflm(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public afln a(ViewGroup paramViewGroup, int paramInt)
  {
    return new afln(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559770, paramViewGroup, false), this.jdField_a_of_type_Aflk);
  }
  
  public void a(aflk paramaflk)
  {
    this.jdField_a_of_type_Aflk = paramaflk;
  }
  
  public void a(afln paramafln, int paramInt)
  {
    paramafln.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt)) {
      paramafln.a.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramafln, paramInt, getItemId(paramInt));
      return;
      paramafln.a.setSelected(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflm
 * JD-Core Version:    0.7.0.1
 */