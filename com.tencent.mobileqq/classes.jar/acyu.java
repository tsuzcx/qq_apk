import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class acyu
  extends VasQuickUpdateManager.CallBacker
{
  public acyu(FriendProfileCardActivity paramFriendProfileCardActivity, awra paramawra, Card paramCard) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b != null)
      {
        if (this.jdField_a_of_type_Awra.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_Awra = this.jdField_a_of_type_Awra;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.obtainMessage(5, 0, 18, this.jdField_a_of_type_ComTencentMobileqqDataCard).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "send msg of UI_MSG_UPDATE_CARD");
        }
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyu
 * JD-Core Version:    0.7.0.1
 */