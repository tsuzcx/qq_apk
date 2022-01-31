import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder;
import com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.MomentViewHolder;

public class afju
  implements DialogInterface.OnClickListener
{
  public afju(BaseMomentItemBuilder paramBaseMomentItemBuilder, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)) {
      new NowVideoReporter().h("video_public").i("del_failfeed").d("2").c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder) + "").a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)).e("2").b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afju
 * JD-Core Version:    0.7.0.1
 */