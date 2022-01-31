import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import mqq.app.QQPermissionCallback;

public class acxc
  implements QQPermissionCallback
{
  public acxc(FriendProfileImageActivity paramFriendProfileImageActivity, String paramString1, String paramString2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FriendProfileImageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxc
 * JD-Core Version:    0.7.0.1
 */