import android.text.TextUtils;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class acsl
  implements Runnable
{
  public acsl(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, NearFieldTroopHandler paramNearFieldTroopHandler) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b == 1) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.d)) {}
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.d).longValue();
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopHandler.a(l, 1);
          if (!bool)
          {
            Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
            this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f = 2;
            return;
          }
        }
        catch (Exception localException) {}
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopHandler.a(0L, 1))
      {
        Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f = 2;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.getCurrentAccountUin(), false));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.e = 2;
    Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsl
 * JD-Core Version:    0.7.0.1
 */