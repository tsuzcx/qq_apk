import android.content.res.ColorStateList;
import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;

public class aezb
  implements ancx
{
  public int a;
  public aezf a;
  public ColorStateList a;
  public BaseChatItemLayout a;
  public ChatMessage a;
  public CharSequence a;
  public String a;
  public boolean a;
  public ColorStateList b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  private aezb(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.getManager(52);
    localObject1 = (aezf)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    boolean bool1;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((aezf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, paramTroopMemberInfo.memberuin)))
    {
      ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      localObject1 = new bczs(ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, true), 13).a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_type");
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_level");
      String str1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("bigClub_type");
      String str2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("bigClub_level");
      String str3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_card_id");
      String str4 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_ext_card_id");
      i = VipUtils.a((String)localObject2, 0);
      j = VipUtils.a((String)localObject3, 0);
      k = VipUtils.a(str1, 0);
      m = VipUtils.a(str2, 0);
      n = VipUtils.a(str3, 0);
      i1 = VipUtils.a(str4, 0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      if ((localObject1 == null) && (!this.jdField_a_of_type_Boolean)) {
        break label397;
      }
      bool1 = true;
      localObject3 = this.jdField_a_of_type_AndroidContentResColorStateList;
      if (((!this.jdField_a_of_type_Boolean) || (!nmy.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (!apsz.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())) {
        break label403;
      }
    }
    label397:
    label403:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((BaseChatItemLayout)localObject2).a(bool1, (CharSequence)localObject1, (ColorStateList)localObject3, bool2, this.jdField_b_of_type_Boolean, this.d, this.c, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_JavaLangString, i, j, k, m, n, i1, paramTroopMemberInfo.mIsHideBigClub);
      if (this.jdField_a_of_type_Int == 1) {
        BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, ((CharSequence)localObject1).toString(), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_Aezf);
      }
      bgdk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.e, (Spannable)localObject1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezb
 * JD-Core Version:    0.7.0.1
 */