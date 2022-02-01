import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.qphone.base.util.QLog;

public class afwp
  implements anwz
{
  public BaseChatItemLayout a;
  public TroopInfo a;
  public String a;
  
  private afwp(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {}
    int j;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin));
      j = paramTroopMemberInfo.newRealLevel;
      i = j;
      if (j == 0) {
        i = bfnl.b(paramTroopMemberInfo.realLevel);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "TmiCallBackForTroopMemberNewLevel: realLevel = " + paramTroopMemberInfo.realLevel + ",newRealLevel = " + paramTroopMemberInfo.newRealLevel);
      }
      paramTroopMemberInfo = bfnl.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramTroopMemberInfo.memberuin, i, paramTroopMemberInfo.level, paramTroopMemberInfo.mUniqueTitle);
    } while (paramTroopMemberInfo == null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.jdField_a_of_type_Int == 1) && (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.jdField_a_of_type_JavaLangString))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = njo.e;
        j = beui.a().jdField_a_of_type_Int;
        paramTroopMemberInfo.a = new int[] { j, j };
        paramTroopMemberInfo.b = new int[] { j, j };
        paramTroopMemberInfo.d = i;
        paramTroopMemberInfo.c = i;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setTroopMemberNewLevel(paramTroopMemberInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setTag(Integer.valueOf(2131364418));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwp
 * JD-Core Version:    0.7.0.1
 */