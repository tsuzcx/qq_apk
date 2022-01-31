import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.qphone.base.util.QLog;

public class abmr
  implements ArkViewImplement.LoadCallback
{
  public abmr(ArkBabyqCardInfo paramArkBabyqCardInfo, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkBabyqCardInfo", 2, "attachArkView onLoadFinish ArkBabyqCardInfo state=" + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder, this.jdField_a_of_type_ComTencentMobileqqDataArkBabyqCardInfo);
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
 * Qualified Name:     abmr
 * JD-Core Version:    0.7.0.1
 */