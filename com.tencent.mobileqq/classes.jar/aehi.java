import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aehi
  implements View.OnClickListener
{
  public aehi(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365302)
    {
      aehv localaehv = this.a.jdField_a_of_type_Aeht.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (localaehv != null))
      {
        bkho localbkho = (bkho)bkif.a(this.a, null);
        localbkho.a(2131692950, 3);
        localbkho.c(2131690582);
        localbkho.a(new aehj(this, localaehv, localbkho));
        localbkho.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehi
 * JD-Core Version:    0.7.0.1
 */