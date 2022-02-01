import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

public class afci
  extends RecyclerView.Adapter<afcj>
{
  afcg jdField_a_of_type_Afcg;
  
  public afci(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public afcj a(ViewGroup paramViewGroup, int paramInt)
  {
    return new afcj(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559764, paramViewGroup, false), this.jdField_a_of_type_Afcg);
  }
  
  public void a(afcg paramafcg)
  {
    this.jdField_a_of_type_Afcg = paramafcg;
  }
  
  public void a(afcj paramafcj, int paramInt)
  {
    paramafcj.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt)) {
      paramafcj.a.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramafcj, paramInt, getItemId(paramInt));
      return;
      paramafcj.a.setSelected(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afci
 * JD-Core Version:    0.7.0.1
 */