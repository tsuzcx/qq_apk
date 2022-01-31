import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class acaq
  implements View.OnClickListener
{
  public acaq(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity))
    {
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b < Face2FaceAddFriendActivity.jdField_a_of_type_Long) && (l > this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b))
      {
        if (QLog.isColorLevel()) {
          QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "click too offen,please try again later ");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b = l;
      Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.d();
      paramView = Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).obtainMessage();
      paramView.what = 2;
      paramView.arg1 = 2;
      paramView.obj = this.jdField_a_of_type_JavaLangString;
      Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendMessage(paramView);
      ReportController.b(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 2, 0, "", "", "", "");
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getResources().getString(2131437903);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, 0, paramView, 0).b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acaq
 * JD-Core Version:    0.7.0.1
 */