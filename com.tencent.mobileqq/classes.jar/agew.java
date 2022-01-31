import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.qphone.base.util.QLog;

public class agew
  implements Runnable
{
  public agew(VoteHelper paramVoteHelper, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "updateCardProfileFromDb uin:" + this.jdField_a_of_type_Long);
    }
    CardProfile localCardProfile2 = VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, 2);
    CardProfile localCardProfile1 = localCardProfile2;
    if (localCardProfile2 == null) {
      localCardProfile1 = VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, 3);
    }
    if (localCardProfile1 != null)
    {
      localCardProfile1.updateTime(System.currentTimeMillis() / 1000L);
      this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, localCardProfile1).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agew
 * JD-Core Version:    0.7.0.1
 */