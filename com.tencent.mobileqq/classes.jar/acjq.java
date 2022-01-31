import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class acjq
  implements ajtw
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private acjq(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (acju)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    ayqo localayqo;
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    label84:
    boolean bool1;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((acju)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localObject1 = null;
      localayqo = null;
      localObject2 = null;
      localObject3 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop())) {
        break label260;
      }
      i = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
        break label265;
      }
      j = 1;
      if (!awnu.b()) {
        break label275;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
        break label501;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label270;
      }
      i = 1;
      label139:
      localObject1 = ayqn.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      if ((localObject1 == null) || ((i == 0) && (!bool1))) {
        break label494;
      }
      paramTroopMemberInfo = ((ayqo)localObject1).a;
      i = ((ayqo)localObject1).b;
      label178:
      if (this.jdField_a_of_type_Boolean) {
        i = ayqn.a().jdField_a_of_type_Int;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramTroopMemberInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, true, paramTroopMemberInfo, false, i, this.jdField_a_of_type_Int);
        BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setTag(Integer.valueOf(2131298590));
      }
      return;
      label260:
      i = 0;
      break;
      label265:
      j = 0;
      break label84;
      label270:
      i = 0;
      break label139;
      label275:
      if (i != 0)
      {
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin)))
        {
          bool1 = true;
          label322:
          localayqo = ayqn.a().a(bool2, bool1);
          if (localayqo == null) {
            break label486;
          }
          paramTroopMemberInfo = localayqo.a;
          i = localayqo.b;
        }
      }
      for (;;)
      {
        break;
        bool1 = false;
        break label322;
        if (j != 0)
        {
          localObject1 = ayqn.a().a(paramTroopMemberInfo.level, false, false, false);
          if ((localObject1 == null) || (!azgh.a(paramTroopMemberInfo))) {
            break label478;
          }
          paramTroopMemberInfo = ((ayqo)localObject1).a;
          i = ((ayqo)localObject1).b;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean) {
            i = ayqn.a().jdField_a_of_type_Int;
          }
          break;
          localObject1 = ayqn.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
          if (localObject1 != null)
          {
            paramTroopMemberInfo = ((ayqo)localObject1).a;
            i = ((ayqo)localObject1).b;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Boolean)
            {
              i = ayqn.a().jdField_a_of_type_Int;
              break;
            }
            break;
            i = 0;
            paramTroopMemberInfo = localObject2;
          }
          label478:
          i = 0;
          paramTroopMemberInfo = localayqo;
        }
        label486:
        i = 0;
        paramTroopMemberInfo = (TroopMemberInfo)localObject1;
      }
      label494:
      i = 0;
      paramTroopMemberInfo = null;
      break label178;
      label501:
      i = 0;
      paramTroopMemberInfo = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acjq
 * JD-Core Version:    0.7.0.1
 */