import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

public class aevm
  extends RecyclerView.Adapter<aevn>
{
  aevk jdField_a_of_type_Aevk;
  
  public aevm(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public aevn a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aevn(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559808, paramViewGroup, false), this.jdField_a_of_type_Aevk);
  }
  
  public void a(aevk paramaevk)
  {
    this.jdField_a_of_type_Aevk = paramaevk;
  }
  
  public void a(aevn paramaevn, int paramInt)
  {
    paramaevn.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt)) {
      paramaevn.a.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaevn, paramInt, getItemId(paramInt));
      return;
      paramaevn.a.setSelected(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevm
 * JD-Core Version:    0.7.0.1
 */