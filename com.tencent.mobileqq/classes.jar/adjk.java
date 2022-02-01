import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adjk
  implements View.OnClickListener
{
  public adjk(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365376)
    {
      adjx localadjx = this.a.jdField_a_of_type_Adjv.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (localadjx != null))
      {
        bjnw localbjnw = (bjnw)bjon.a(this.a, null);
        localbjnw.a(2131693014, 3);
        localbjnw.c(2131690620);
        localbjnw.a(new adjl(this, localadjx, localbjnw));
        localbjnw.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjk
 * JD-Core Version:    0.7.0.1
 */