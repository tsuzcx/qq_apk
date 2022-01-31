import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

public class aenj
  extends amgd
{
  public aenj(ActivateFriendView paramActivateFriendView) {}
  
  public void b()
  {
    if ((ActivateFriendView.a(this.a) == null) || (ActivateFriendView.b(this.a) == null)) {}
    do
    {
      return;
      ActivateFriendView.a(this.a, 0);
      int i = 0;
      if (i < ActivateFriendView.a(this.a).size())
      {
        if (this.a.a.c(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin, 2))
        {
          ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setChecked(false);
          ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setBirthday(this.a.getResources().getString(2131689585));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.a.a.b(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin, 2))
          {
            ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setChecked(false);
            ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setBirthday(this.a.getResources().getString(2131689588));
          }
          else
          {
            ActivateFriendView.b(this.a);
            ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setChecked(true);
          }
        }
      }
    } while (ActivateFriendView.a(this.a) == null);
    ActivateFriendView.a(this.a).a(ActivateFriendView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenj
 * JD-Core Version:    0.7.0.1
 */