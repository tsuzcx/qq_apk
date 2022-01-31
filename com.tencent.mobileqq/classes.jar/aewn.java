import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import com.tencent.mobileqq.widget.QQToast;

class aewn
  implements NearbyMomentManager.DeleteFeedCallback
{
  aewn(aewl paramaewl) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_delete_suc").d("2").a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)).b(paramString).c(String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)));
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_Boolean) {}
      for (paramString = "1";; paramString = "2")
      {
        localNowVideoReporter.e(paramString).b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, "删除失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewn
 * JD-Core Version:    0.7.0.1
 */