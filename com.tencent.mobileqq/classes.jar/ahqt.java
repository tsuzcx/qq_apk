import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;

public class ahqt
  implements View.OnClickListener
{
  public ahqt(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ahpn))
    {
      paramView = (ahpn)paramView.getTag();
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    paramView = TroopInfoActivity.a(paramView.b, 4);
    paramView.putInt("t_s_f", 1002);
    bcpx.a(this.a.getActivity(), paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqt
 * JD-Core Version:    0.7.0.1
 */