import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class agcg
  implements View.OnClickListener
{
  public agcg(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData;
    int i = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uinType;
    if (!TextUtils.isEmpty(paramView))
    {
      paramView = bdib.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, paramView);
      if (paramView != null)
      {
        paramView.a("webview");
        paramView.a("uin_type", i + "");
        paramView.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcg
 * JD-Core Version:    0.7.0.1
 */