import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter;
import com.tencent.mobileqq.leba.header.LebaGridUtils;
import com.tencent.mobileqq.leba.header.LebaPluginInfoObserver;
import com.tencent.mobileqq.leba.view.LebaGridMenuView;
import com.tencent.mobileqq.leba.view.LebaTopBarView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aeil
  extends LebaPluginInfoObserver
{
  public aeil(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba_with_feeds", 2, "onLebaGridRedTouchUpdated" + paramBoolean1);
    }
    if (paramBoolean1)
    {
      paramInt = LebaGridUtils.a(paramInt, this.a.jdField_a_of_type_JavaUtilList);
      if ((LebaWithFeeds.a(this.a) == null) || (LebaWithFeeds.a(this.a).getVisibility() != 0)) {
        break label98;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(paramInt, paramBoolean2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba_with_feeds", 2, "set indicator to red");
      }
    }
    label98:
    while (!paramBoolean2) {
      return;
    }
    LebaWithFeeds.a(this.a, paramInt);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.leba_with_feeds", 4, "LebaPluginInfoObserver listener notify = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340002);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (LebaWithFeeds.a(this.a) != null) {
        LebaWithFeeds.a(this.a).a(((Integer)paramObject).intValue());
      }
      if (LebaWithFeeds.a(this.a) != null) {
        LebaWithFeeds.a(this.a).b(((Integer)paramObject).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeil
 * JD-Core Version:    0.7.0.1
 */