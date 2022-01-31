import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import com.tencent.mobileqq.widget.QQToast;

class afjs
  implements NearbyMomentManager.DeleteFeedCallback
{
  afjs(afjr paramafjr) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, "删除失败", 0).a();
      return;
    }
    new NowVideoReporter().h("video_public").i("del_failfeed").d("2").c(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder) + "").a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)).e("1").b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afjs
 * JD-Core Version:    0.7.0.1
 */