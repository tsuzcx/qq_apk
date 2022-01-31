import android.util.Pair;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher;
import java.util.Set;
import mqq.os.MqqHandler;

public class abqu
  implements Runnable
{
  public abqu(StrangerHdHeadUrlFetcher paramStrangerHdHeadUrlFetcher, String paramString1, int paramInt, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (localObject1 != null) {}
    for (boolean bool = ((Boolean)((Pair)localObject1).first).booleanValue();; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_Boolean))
      {
        localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_Long = System.currentTimeMillis();
          synchronized (StrangerHdHeadUrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(StrangerHdHeadUrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher), true);
            }
          }
        }
      }
      else
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_JavaUtilSet)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_JavaUtilSet.add(this.b);
          ((FriendListHandler)localObject1).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte)1, (byte)2);
          if (!this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
            this.jdField_a_of_type_ComTencentMobileqqDatingStrangerHdHeadUrlFetcher.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 60000L);
          }
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
      DatingUtil.a("StrangerHdHeadUrlFetcher", new Object[] { "flh is null" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqu
 * JD-Core Version:    0.7.0.1
 */