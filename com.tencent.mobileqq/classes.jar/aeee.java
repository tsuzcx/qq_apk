import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

public class aeee
  extends RecyclerView.Adapter<aeef>
{
  aeec jdField_a_of_type_Aeec;
  
  public aeee(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public aeef a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aeef(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559772, paramViewGroup, false), this.jdField_a_of_type_Aeec);
  }
  
  public void a(aeec paramaeec)
  {
    this.jdField_a_of_type_Aeec = paramaeec;
  }
  
  public void a(aeef paramaeef, int paramInt)
  {
    paramaeef.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt)) {
      paramaeef.a.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaeef, paramInt, getItemId(paramInt));
      return;
      paramaeef.a.setSelected(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeee
 * JD-Core Version:    0.7.0.1
 */