import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class aewt
  implements NearbyMomentManager.DeleteFeedCallback
{
  aewt(aews paramaews) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i;
    if (!paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, "删除失败", 0).a();
      if (!(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo instanceof ShortVideoMomentFeedInfo)) {
        break label187;
      }
      paramString = (ShortVideoMomentFeedInfo)this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo;
      if (paramString.b % 1000L <= 500L) {
        break label168;
      }
      i = (int)paramString.b / 1000 + 1;
      label69:
      localNowVideoReporter = new NowVideoReporter().h("video_public").i("de_republic").a(String.valueOf(i)).d("5").c("1");
      if (!paramBoolean) {
        break label181;
      }
    }
    label168:
    label181:
    for (paramString = "1";; paramString = "")
    {
      localNowVideoReporter.e(paramString).b(NearbyMomentFailedAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter));
      return;
      NearbyMomentFailedAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter).remove(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter.notifyDataSetChanged();
      break;
      i = (int)paramString.b / 1000;
      break label69;
    }
    label187:
    NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("video_public").i("de_republic").d("5").c("2");
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "")
    {
      localNowVideoReporter.e(paramString).b(NearbyMomentFailedAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewt
 * JD-Core Version:    0.7.0.1
 */