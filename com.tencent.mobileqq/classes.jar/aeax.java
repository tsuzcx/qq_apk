import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import mqq.app.QQPermissionCallback;

public class aeax
  implements QQPermissionCallback
{
  public aeax(FriendProfileImageActivity paramFriendProfileImageActivity, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FriendProfileImageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeax
 * JD-Core Version:    0.7.0.1
 */