import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianProfileCardActivity;

public class akwv
  implements Runnable
{
  public akwv(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(this.jdField_a_of_type_JavaLangString);
    String str1 = "";
    Object localObject1 = str1;
    if (localObject2 != null)
    {
      localObject1 = str1;
      if (((Friends)localObject2).remark != null)
      {
        str1 = ((Friends)localObject2).remark;
        localObject1 = str1;
        if (((Friends)localObject2).remark.equals(((Friends)localObject2).name))
        {
          localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler;
          localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app.getCurrentAccountUin();
          String str2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString;
          long l = ProfileActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a, false);
          ((CardHandler)localObject1).a((String)localObject2, str2, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
          localObject1 = str1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.i = ((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akwv
 * JD-Core Version:    0.7.0.1
 */