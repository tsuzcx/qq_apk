import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class acuf
  implements akif
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private acuf(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (acuj)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    Object localObject4;
    Object localObject2;
    azrg localazrg;
    Object localObject3;
    int i;
    int j;
    label87:
    boolean bool2;
    boolean bool1;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((acuj)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localObject4 = null;
      localObject2 = null;
      localazrg = null;
      localObject3 = null;
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop())) {
        break label367;
      }
      i = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
        break label372;
      }
      j = 1;
      bool2 = axmv.b();
      if (!bool2) {
        break label382;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
        break label631;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label377;
      }
      i = 1;
      label146:
      localObject2 = azrf.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      if ((localObject2 == null) || ((i == 0) && (!bool1))) {
        break label626;
      }
      localObject1 = ((azrg)localObject2).a;
      i = ((azrg)localObject2).b;
      label186:
      if (this.jdField_a_of_type_Boolean) {
        i = azrf.a().jdField_a_of_type_Int;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        if (!bool2)
        {
          localObject2 = localObject1;
          if (1 == this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag) {}
        }
        else
        {
          localObject2 = localObject1;
          if (j == 0)
          {
            bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
              break label577;
            }
            j = 1;
            label281:
            localObject2 = "";
            if (!bool1) {
              break label582;
            }
            localObject2 = ajya.a(2131720571);
          }
        }
      }
      label297:
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, true, (String)localObject2, false, i, this.jdField_a_of_type_Int);
        BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setTag(Integer.valueOf(2131364147));
      }
      return;
      label367:
      i = 0;
      break;
      label372:
      j = 0;
      break label87;
      label377:
      i = 0;
      break label146;
      label382:
      if (i != 0)
      {
        boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin)))
        {
          bool1 = true;
          localazrg = azrf.a().a(bool3, bool1);
          if (localazrg == null) {
            break label617;
          }
          localObject1 = localazrg.a;
          i = localazrg.b;
        }
      }
      for (;;)
      {
        label429:
        break;
        bool1 = false;
        break label429;
        if (j != 0)
        {
          localObject2 = azrf.a().a(paramTroopMemberInfo.level, false, false, false);
          if ((localObject2 == null) || (!bahy.a(paramTroopMemberInfo))) {
            break label608;
          }
          localObject1 = ((azrg)localObject2).a;
          i = ((azrg)localObject2).b;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean) {
            i = azrf.a().jdField_a_of_type_Int;
          }
          break;
          localObject2 = azrf.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
          if (localObject2 != null)
          {
            localObject1 = ((azrg)localObject2).a;
            i = ((azrg)localObject2).b;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Boolean)
            {
              i = azrf.a().jdField_a_of_type_Int;
              break;
              label577:
              j = 0;
              break label281;
              label582:
              if (j == 0) {
                break label297;
              }
              localObject2 = ajya.a(2131720568);
              break label297;
            }
            break;
            i = 0;
            localObject1 = localObject3;
          }
          label608:
          i = 0;
          localObject1 = localazrg;
        }
        label617:
        i = 0;
        localObject1 = localObject2;
      }
      label626:
      i = 0;
      break label186;
      label631:
      i = 0;
      localObject1 = localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acuf
 * JD-Core Version:    0.7.0.1
 */