import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeqm
  implements View.OnClickListener
{
  public aeqm(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365346)
    {
      aeqz localaeqz = this.a.jdField_a_of_type_Aeqx.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (localaeqz != null))
      {
        blir localblir = (blir)blji.a(this.a, null);
        localblir.a(2131692959, 3);
        localblir.c(2131690580);
        localblir.a(new aeqn(this, localaeqz, localblir));
        localblir.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqm
 * JD-Core Version:    0.7.0.1
 */