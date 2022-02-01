import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahim
  implements View.OnClickListener
{
  public ahim(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData;
    int i = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uinType;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bhey.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, (String)localObject);
      if (localObject != null)
      {
        ((bheh)localObject).b("webview");
        ((bheh)localObject).a("uin_type", i + "");
        ((bheh)localObject).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahim
 * JD-Core Version:    0.7.0.1
 */