import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.statistics.ReportController;

public class aget
  implements Runnable
{
  public aget(VoteHelper paramVoteHelper, long paramLong, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 2;
    boolean bool = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a.getManager(50)).b(Long.toString(this.jdField_a_of_type_Long));
    int i;
    if (this.jdField_a_of_type_Int == 2) {
      if (bool)
      {
        i = 5;
        if (PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a) <= 0) {
          break label134;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label129;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a, "CliOper", "", "", "P_prof", "Prof_good", i, 1, j, "0", "1", this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a.getCurrentAccountUin(), Long.toString(this.jdField_a_of_type_Long));
      return;
      i = 6;
      break;
      if (bool)
      {
        i = 7;
        break;
      }
      i = 8;
      break;
      label129:
      j = 3;
      continue;
      label134:
      if (this.jdField_a_of_type_Boolean) {
        j = 0;
      } else {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aget
 * JD-Core Version:    0.7.0.1
 */