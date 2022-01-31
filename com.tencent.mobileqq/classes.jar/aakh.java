import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;

public class aakh
  implements ArkViewImplement.LoadCallback
{
  public aakh(ArkAdapterItemForTextMsg paramArkAdapterItemForTextMsg, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFinish(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.a.setVisibility(0);
      ArkAdapterItemForTextMsg.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter, this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder);
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder, this.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakh
 * JD-Core Version:    0.7.0.1
 */