import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

public class aeza
  implements ancx
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private aeza(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt = beda.a().jdField_a_of_type_Int;
    }
    return paramInt;
  }
  
  private String a(TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    String str = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
      if (!paramBoolean2)
      {
        str = paramString;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupRankUserFlag) {}
      }
      else
      {
        str = paramString;
        if (!paramBoolean1)
        {
          paramBoolean1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
            break label96;
          }
          str = "";
          if (!paramBoolean1) {
            break label102;
          }
          str = amtj.a(2131719288);
        }
      }
    }
    label96:
    label102:
    while (i == 0)
    {
      return str;
      i = 0;
      break;
    }
    return amtj.a(2131719285);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, paramBoolean, paramString, false, paramInt, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setTag(Integer.valueOf(2131364479));
      }
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool3 = false;
    Object localObject1 = (aezf)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    bedb localbedb1;
    bedb localbedb2;
    Object localObject2;
    boolean bool1;
    label87:
    boolean bool4;
    boolean bool2;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((aezf)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localbedb1 = null;
      localbedb2 = null;
      localObject2 = null;
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop())) {
        break label227;
      }
      i = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop())) {
        break label232;
      }
      bool1 = true;
      bool4 = bbyp.b();
      if (!bool4) {
        break label242;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
        break label451;
      }
      bool2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label237;
      }
      i = 1;
      label146:
      localbedb1 = beda.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      if ((localbedb1 == null) || ((i == 0) && (!bool2))) {
        break label460;
      }
      localObject1 = localbedb1.a;
    }
    label442:
    label451:
    label460:
    for (int i = localbedb1.b;; i = 0)
    {
      i = a(i);
      for (;;)
      {
        paramTroopMemberInfo = a(paramTroopMemberInfo, (String)localObject1, bool1, bool4);
        if (bewy.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))
        {
          bool1 = bool3;
          label219:
          a(paramTroopMemberInfo, i, bool1);
          return;
          label227:
          i = 0;
          break;
          label232:
          bool1 = false;
          break label87;
          label237:
          i = 0;
          break label146;
          label242:
          if (i != 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
              break label451;
            }
            boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
            for (bool2 = true;; bool2 = false)
            {
              localbedb2 = beda.a().a(bool5, bool2);
              if (localbedb2 == null) {
                break label451;
              }
              localObject1 = localbedb2.a;
              i = localbedb2.b;
              break;
            }
          }
          if (bool1)
          {
            localbedb1 = beda.a().a(paramTroopMemberInfo.level, false, false, false);
            if ((localbedb1 == null) || (!beyy.a(paramTroopMemberInfo))) {
              break label442;
            }
            localObject1 = localbedb1.a;
            i = localbedb1.b;
          }
        }
        for (;;)
        {
          i = a(i);
          break;
          localbedb1 = beda.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          if (localbedb1 != null)
          {
            localObject1 = localbedb1.a;
            i = localbedb1.b;
          }
          for (;;)
          {
            i = a(i);
            break;
            bool1 = true;
            break label219;
            i = 0;
            localObject1 = localObject2;
          }
          i = 0;
          localObject1 = localbedb2;
        }
        i = 0;
        localObject1 = localbedb1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeza
 * JD-Core Version:    0.7.0.1
 */