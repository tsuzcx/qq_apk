import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class aica
  implements View.OnClickListener
{
  public aica(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.a.c);
    List localList = (List)this.a.jdField_a_of_type_Aidh.a.get(ChatHistoryTroopMemberFragment.a(this.a));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((aidf)localList.get(i)).a);
      i += 1;
    }
    localIntent.putExtra("members_uin", localArrayList);
    PublicFragmentActivity.a(paramView.getContext(), localIntent, TroopMemberHistoryFragment.class);
    paramView = ((TroopManager)this.a.getActivity().app.getManager(52)).b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.b.getCurrentAccountUin());
    bdes.a("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdes.a(paramView) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aica
 * JD-Core Version:    0.7.0.1
 */