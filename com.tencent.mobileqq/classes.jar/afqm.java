import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

public class afqm
  implements aofo
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private afqm(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt = bfkd.a().jdField_a_of_type_Int;
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
          str = anvx.a(2131719711);
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
    return anvx.a(2131719708);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setTag(Integer.valueOf(2131364561));
      }
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    Object localObject1 = (afqr)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    bfke localbfke1;
    bfke localbfke2;
    Object localObject2;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((afqr)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      localbfke1 = null;
      localbfke2 = null;
      localObject2 = null;
      localObject1 = null;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop();
      bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop();
      bool4 = bdfk.b();
      if (!bool4) {
        break label210;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label205;
      }
      i = 1;
      localbfke1 = bfkd.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      if ((localbfke1 == null) || ((i == 0) && (!bool1))) {
        break label419;
      }
      localObject1 = localbfke1.a;
    }
    label401:
    label410:
    label419:
    for (int i = localbfke1.b;; i = 0)
    {
      i = a(i);
      for (;;)
      {
        paramTroopMemberInfo = a(paramTroopMemberInfo, (String)localObject1, bool3, bool4);
        if (bgek.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))
        {
          bool1 = bool2;
          label197:
          a(paramTroopMemberInfo, i, bool1);
          return;
          label205:
          i = 0;
          break;
          label210:
          if (bool1)
          {
            boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
            for (bool1 = true;; bool1 = false)
            {
              localbfke2 = bfkd.a().a(bool5, bool1);
              if (localbfke2 == null) {
                break label410;
              }
              localObject1 = localbfke2.a;
              i = localbfke2.b;
              break;
            }
          }
          if (bool3)
          {
            localbfke1 = bfkd.a().a(paramTroopMemberInfo.level, false, false, false);
            if ((localbfke1 == null) || (!bghd.a(paramTroopMemberInfo))) {
              break label401;
            }
            localObject1 = localbfke1.a;
            i = localbfke1.b;
          }
        }
        for (;;)
        {
          i = a(i);
          break;
          localbfke1 = bfkd.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          if (localbfke1 != null)
          {
            localObject1 = localbfke1.a;
            i = localbfke1.b;
          }
          for (;;)
          {
            i = a(i);
            break;
            bool1 = true;
            break label197;
            i = 0;
            localObject1 = localObject2;
          }
          i = 0;
          localObject1 = localbfke2;
        }
        i = 0;
        localObject1 = localbfke1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqm
 * JD-Core Version:    0.7.0.1
 */