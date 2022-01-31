import android.os.Message;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import mqq.os.MqqHandler;

public class acfs
  implements PraiseManager.OnPraiseLoadListener
{
  public acfs(NewVoteAnimHelper paramNewVoteAnimHelper, int paramInt) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.hasMessages(0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.removeMessages(0);
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.obtainMessage(0, this.jdField_a_of_type_Int, 0).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfs
 * JD-Core Version:    0.7.0.1
 */