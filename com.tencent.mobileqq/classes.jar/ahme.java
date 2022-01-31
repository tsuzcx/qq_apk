import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;

public class ahme
  implements View.OnClickListener
{
  public ahme(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ahky))
    {
      paramView = (ahky)paramView.getTag();
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    paramView = TroopInfoActivity.a(paramView.b, 4);
    paramView.putInt("t_s_f", 1002);
    bclo.a(this.a.getActivity(), paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahme
 * JD-Core Version:    0.7.0.1
 */