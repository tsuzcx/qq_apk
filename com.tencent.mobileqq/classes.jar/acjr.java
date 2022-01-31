import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class acjr
  implements View.OnClickListener
{
  public acjr(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.a.b);
    List localList = (List)this.a.jdField_a_of_type_Acla.a.get(TroopMemberListActivity.a(this.a));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((acky)localList.get(i)).a);
      i += 1;
    }
    localIntent.putExtra("members_uin", localArrayList);
    PublicFragmentActivity.a(paramView.getContext(), localIntent, TroopMemberHistoryFragment.class);
    paramView = ((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.app.getCurrentAccountUin());
    bbbb.a("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bbbb.a(paramView) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acjr
 * JD-Core Version:    0.7.0.1
 */