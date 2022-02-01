import android.content.res.ColorStateList;
import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;

public class afqn
  implements aofo
{
  public int a;
  public afqr a;
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
  
  private afqn(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.getManager(QQManagerFactory.TROOP_MANAGER);
    localObject1 = (afqr)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    boolean bool1;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((afqr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, paramTroopMemberInfo.memberuin)))
    {
      ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      localObject1 = new begq(ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, true), 13).a();
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
        break label404;
      }
      bool1 = true;
      localObject3 = this.jdField_a_of_type_AndroidContentResColorStateList;
      if (((!this.jdField_a_of_type_Boolean) || (!nty.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (!aqwc.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())) {
        break label410;
      }
    }
    label404:
    label410:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((BaseChatItemLayout)localObject2).a(bool1, (CharSequence)localObject1, (ColorStateList)localObject3, bool2, this.jdField_b_of_type_Boolean, this.d, this.c, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_JavaLangString, i, j, k, m, n, i1, paramTroopMemberInfo.mIsHideBigClub);
      if (this.jdField_a_of_type_Int == 1) {
        BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, ((CharSequence)localObject1).toString(), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_Afqr);
      }
      bhmb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.e, (Spannable)localObject1, paramTroopMemberInfo.troopColorNickId, false);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqn
 * JD-Core Version:    0.7.0.1
 */