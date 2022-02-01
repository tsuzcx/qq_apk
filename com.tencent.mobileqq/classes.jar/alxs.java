import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alxs
  extends aofu
{
  public alxs(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
    Object localObject2 = new StringBuilder().append("onUpdateTroopGetMemberList, troopUin[").append(paramString).append("], ftroopUin[").append((String)localObject1).append("], troopMemberInfoList[");
    if (paramList != null) {}
    for (paramInt1 = paramList.size();; paramInt1 = -1)
    {
      QLog.w("FriendTeamListInnerFrameNew", 1, paramInt1 + "]");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(paramString))) {
        break;
      }
      return;
    }
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject1 = new ArrayList();
    localObject2 = (bgls)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    bjxa localbjxa = (bjxa)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.QIDIAN_MANAGER);
    Object localObject3 = (anvk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject3 = (TroopMemberInfo)paramList.next();
        if (localObject3 != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, memberuin[" + ((TroopMemberInfo)localObject3).memberuin + "]");
          }
          if (!TextUtils.equals(((TroopMemberInfo)localObject3).memberuin, paramString)) {
            if ((((bgls)localObject2).b(((TroopMemberInfo)localObject3).memberuin)) || (localbjxa.f(((TroopMemberInfo)localObject3).memberuin)))
            {
              if (QLog.isDevelopLevel()) {
                QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, isRobotUin");
              }
            }
            else {
              ((ArrayList)localObject1).add(localObject3);
            }
          }
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.setGroupMembers((ArrayList)localObject1);
    FriendTeamListInnerFrame.a(this.a).a((ArrayList)localObject1);
    FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxs
 * JD-Core Version:    0.7.0.1
 */