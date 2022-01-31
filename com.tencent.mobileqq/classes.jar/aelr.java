import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import java.util.List;

public class aelr
  implements alzv
{
  public BaseChatItemLayout a;
  public String a;
  
  private aelr(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = ((bcbt)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.getManager(346)).a(paramTroopMemberInfo.honorList);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setHonorList(paramTroopMemberInfo);
        if ((paramTroopMemberInfo == null) || (paramTroopMemberInfo.size() <= 0)) {
          break label108;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
      }
    }
    return;
    label108:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelr
 * JD-Core Version:    0.7.0.1
 */