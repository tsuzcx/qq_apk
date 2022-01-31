import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;

public class aewu
  implements DialogInterface.OnClickListener
{
  public aewu(NearbyMomentFailedAdapter paramNearbyMomentFailedAdapter, PublishableMomentInfo paramPublishableMomentInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo instanceof ShortVideoMomentFeedInfo))
    {
      paramDialogInterface = (ShortVideoMomentFeedInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo;
      if (paramDialogInterface.b % 1000L > 500L) {}
      for (paramInt = (int)paramDialogInterface.b / 1000 + 1;; paramInt = (int)paramDialogInterface.b / 1000)
      {
        new NowVideoReporter().h("video_public").i("de_republic").a(String.valueOf(paramInt)).d("5").c("1").e("2").b(NearbyMomentFailedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter));
        return;
      }
    }
    new NowVideoReporter().h("video_public").i("de_republic").d("5").c("2").e("2").b(NearbyMomentFailedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewu
 * JD-Core Version:    0.7.0.1
 */