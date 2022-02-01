import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ajum
  implements View.OnClickListener
{
  public ajum(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.a.c);
    List localList = (List)this.a.jdField_a_of_type_Ajvt.a.get(ChatHistoryTroopMemberFragment.a(this.a));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((ajvr)localList.get(i)).a);
      i += 1;
    }
    ((Intent)localObject).putExtra("members_uin", localArrayList);
    PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject, TroopMemberHistoryFragment.class);
    localObject = ((TroopManager)this.a.getActivity().app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.b.getCurrentAccountUin());
    bhbu.a("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a((TroopMemberInfo)localObject) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajum
 * JD-Core Version:    0.7.0.1
 */