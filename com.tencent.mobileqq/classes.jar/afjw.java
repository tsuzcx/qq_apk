import android.content.Context;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.ReportCallback;
import com.tencent.mobileqq.widget.QQToast;

class afjw
  implements NearbyMomentManager.ReportCallback
{
  afjw(afjv paramafjv, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localObject = new NowVideoReporter().h("data_card").i("feed_inform_suc").d("2").a(this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)).b(this.jdField_a_of_type_JavaLangString).c(String.valueOf(this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)));
      if (this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_Boolean)
      {
        str = "1";
        ((NowVideoReporter)localObject).e(str).b(this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_Afjv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_AndroidContentContext;
      if (!paramBoolean) {
        break label157;
      }
      i = 2;
      label131:
      if (!paramBoolean) {
        break label162;
      }
    }
    label157:
    label162:
    for (String str = "举报成功";; str = "举报失败")
    {
      QQToast.a((Context)localObject, i, str, 0).a();
      return;
      str = "2";
      break;
      i = 1;
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afjw
 * JD-Core Version:    0.7.0.1
 */