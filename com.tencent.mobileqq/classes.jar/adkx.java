import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class adkx
  implements bfoq
{
  public adkx(ApolloItemBuilder paramApolloItemBuilder, adle paramadle, ApolloActionData paramApolloActionData, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.cancel();
      return;
      if ((1 == this.jdField_a_of_type_Adle.f) || (this.jdField_a_of_type_Adle.f == 2))
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          QLog.e("ApolloItemBuilder", 1, "mContext is not activity");
          return;
        }
        ApolloUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
      }
      else
      {
        if (3 == this.jdField_a_of_type_Adle.f)
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url)) {
            paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            break;
            paramView.putExtra("url", ajmu.T + "&id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
          }
        }
        if (4 != this.jdField_a_of_type_Adle.f) {
          aaod.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Adle.a.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkx
 * JD-Core Version:    0.7.0.1
 */