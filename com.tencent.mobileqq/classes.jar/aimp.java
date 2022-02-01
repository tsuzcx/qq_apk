import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aimp
  implements View.OnClickListener
{
  public aimp(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof aikn))
    {
      localObject = (aikn)paramView.getTag();
      if (localObject != null) {
        break label30;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label30:
      localObject = TroopInfoActivity.a(((aikn)localObject).b, 4);
      ((Bundle)localObject).putInt("t_s_f", 1002);
      TroopUtils.openTroopInfoActivity(this.a.getActivity(), (Bundle)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimp
 * JD-Core Version:    0.7.0.1
 */