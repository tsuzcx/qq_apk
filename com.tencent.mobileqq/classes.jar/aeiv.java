import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aeiv
  implements Runnable
{
  public aeiv(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void run()
  {
    List localList = LebaGridShowManager.a().a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba_with_feeds", 2, "loadLebaFromDB :" + localList.size());
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.post(new aeiw(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeiv
 * JD-Core Version:    0.7.0.1
 */