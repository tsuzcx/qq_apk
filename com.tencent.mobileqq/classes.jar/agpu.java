import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;

public class agpu
  implements View.OnClickListener
{
  public agpu(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment, MessageForPic paramMessageForPic) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment.isAdded()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment.getActivity(), ReceiptMessageDetailFragment.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, ReceiptMessageDetailFragment.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageDetailFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agpu
 * JD-Core Version:    0.7.0.1
 */