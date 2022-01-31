import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

public class abud
  implements ArkViewImplement.LoadCallback
{
  public abud(MessageForArkApp paramMessageForArkApp, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForArkApp", 2, "attachArkView onLoadFinish MessageForArkApp state=" + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abud
 * JD-Core Version:    0.7.0.1
 */