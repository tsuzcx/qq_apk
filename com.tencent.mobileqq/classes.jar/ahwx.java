import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class ahwx
  implements belq
{
  public ahwx(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (badq.d(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(true);
      this.a.jdField_a_of_type_Boolean = true;
      ((aunz)this.a.app.getManager(91)).a();
      return true;
    }
    paramView = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2000, 0, 0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahwx
 * JD-Core Version:    0.7.0.1
 */