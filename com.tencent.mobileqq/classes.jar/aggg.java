import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class aggg
  implements aojm
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private aggg(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt = bftp.a().jdField_a_of_type_Int;
    }
    return paramInt;
  }
  
  private String a(TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    String str = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
      if (!paramBoolean2)
      {
        str = paramString;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag) {}
      }
      else
      {
        str = paramString;
        if (!paramBoolean1)
        {
          paramBoolean1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
            break label96;
          }
          str = "";
          if (!paramBoolean1) {
            break label102;
          }
          str = anzj.a(2131719014);
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
    return anzj.a(2131719011);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, paramBoolean, paramString, false, paramInt, this.jdField_a_of_type_Int);
      BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setTag(Integer.valueOf(2131364461));
      }
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool3 = false;
    Object localObject1 = (aggl)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    bftq localbftq1;
    bftq localbftq2;
    Object localObject2;
    boolean bool1;
    label87:
    boolean bool4;
    boolean bool2;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((aggl)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localbftq1 = null;
      localbftq2 = null;
      localObject2 = null;
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop())) {
        break label227;
      }
      i = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
        break label232;
      }
      bool1 = true;
      bool4 = bdgb.b();
      if (!bool4) {
        break label242;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
        break label444;
      }
      bool2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label237;
      }
      i = 1;
      label146:
      localbftq1 = bftp.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      if ((localbftq1 == null) || ((i == 0) && (!bool2))) {
        break label453;
      }
      localObject1 = localbftq1.a;
    }
    label435:
    label444:
    label453:
    for (int i = localbftq1.b;; i = 0)
    {
      i = a(i);
      for (;;)
      {
        paramTroopMemberInfo = a(paramTroopMemberInfo, (String)localObject1, bool1, bool4);
        if (bgnm.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))
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
            boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
            for (bool2 = true;; bool2 = false)
            {
              localbftq2 = bftp.a().a(bool5, bool2);
              if (localbftq2 == null) {
                break label444;
              }
              localObject1 = localbftq2.a;
              i = localbftq2.b;
              break;
            }
          }
          if (bool1)
          {
            localbftq1 = bftp.a().a(paramTroopMemberInfo.level, false, false, false);
            if ((localbftq1 == null) || (!bgpk.a(paramTroopMemberInfo))) {
              break label435;
            }
            localObject1 = localbftq1.a;
            i = localbftq1.b;
          }
        }
        for (;;)
        {
          i = a(i);
          break;
          localbftq1 = bftp.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
          if (localbftq1 != null)
          {
            localObject1 = localbftq1.a;
            i = localbftq1.b;
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
          localObject1 = localbftq2;
        }
        i = 0;
        localObject1 = localbftq1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggg
 * JD-Core Version:    0.7.0.1
 */