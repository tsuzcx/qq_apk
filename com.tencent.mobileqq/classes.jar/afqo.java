import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import java.util.List;

public class afqo
  implements aofo
{
  public BaseChatItemLayout a;
  public String a;
  
  private afqo(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = ((bfwu)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a(paramTroopMemberInfo.honorList);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setHonorList(paramTroopMemberInfo, 1);
        if ((paramTroopMemberInfo == null) || (paramTroopMemberInfo.size() <= 0)) {
          break label109;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
      }
    }
    return;
    label109:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqo
 * JD-Core Version:    0.7.0.1
 */