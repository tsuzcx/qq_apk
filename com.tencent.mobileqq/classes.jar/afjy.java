import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;

public class afjy
  implements DialogInterface.OnClickListener
{
  public afjy(NearbyMomentFailedAdapter paramNearbyMomentFailedAdapter, PublishableMomentInfo paramPublishableMomentInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((NearbyMomentManager)NearbyMomentFailedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter).getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo.c, new afjz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afjy
 * JD-Core Version:    0.7.0.1
 */