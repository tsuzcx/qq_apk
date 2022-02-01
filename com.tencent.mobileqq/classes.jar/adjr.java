import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import mqq.app.QQPermissionCallback;

public class adjr
  implements QQPermissionCallback
{
  public adjr(FriendProfileImageActivity paramFriendProfileImageActivity, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FriendProfileImageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjr
 * JD-Core Version:    0.7.0.1
 */