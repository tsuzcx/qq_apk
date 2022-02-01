import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeaq
  implements View.OnClickListener
{
  public aeaq(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365469)
    {
      aebd localaebd = this.a.jdField_a_of_type_Aebb.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (localaebd != null))
      {
        bkzi localbkzi = (bkzi)bkzz.a(this.a, null);
        localbkzi.a(2131693150, 3);
        localbkzi.c(2131690697);
        localbkzi.a(new aear(this, localaebd, localbkzi));
        localbkzi.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaq
 * JD-Core Version:    0.7.0.1
 */