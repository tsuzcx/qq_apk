import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajuy
  extends amab
{
  public ajuy(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
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
    localObject2 = (bckx)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(203);
    bfua localbfua = (bfua)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(165);
    Object localObject3 = (aloz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
            if ((((bckx)localObject2).b(((TroopMemberInfo)localObject3).memberuin)) || (localbfua.f(((TroopMemberInfo)localObject3).memberuin)))
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
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b((ArrayList)localObject1);
    FriendTeamListInnerFrame.a(this.a).a((ArrayList)localObject1);
    FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuy
 * JD-Core Version:    0.7.0.1
 */