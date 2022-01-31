import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class abnp
  implements ViewPager.OnPageChangeListener
{
  public abnp(NearbyActivity paramNearbyActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      atbr.a("onPageSelected", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.a.jdField_h_of_type_Int), Integer.valueOf(paramInt) });
    }
    Object localObject = this.a;
    int i = ((NearbyActivity.TabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabIndex;
    ((NearbyActivity)localObject).b = i;
    NearbyBaseFragment.b = i;
    if ((this.a.jdField_h_of_type_Long == 0L) && (this.a.b == 2))
    {
      this.a.jdField_h_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "mClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.jdField_h_of_type_Long) });
      }
    }
    if ((this.a.jdField_a_of_type_Long == 0L) && (this.a.b == 1))
    {
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "mNowClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.jdField_a_of_type_Long) });
      }
    }
    if (this.a.jdField_h_of_type_Int != paramInt) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    }
    if (this.a.jdField_h_of_type_Int != -1)
    {
      i = this.a.jdField_h_of_type_Int;
      if (this.a.jdField_h_of_type_Int != this.a.c) {
        break label411;
      }
      i = 9;
    }
    for (;;)
    {
      if (TextUtils.equals(ajya.a(2131707101), ((NearbyActivity.TabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabName)) {
        i = 11;
      }
      int j = ((NearbyActivity.TabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).reportId;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          atbr.a("report_switch_tab", new Object[] { ((NearbyActivity.TabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabName, Integer.valueOf(j) });
        }
        i = j;
      }
      atbr.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "switch_tab", i);
      localObject = this.a.a(paramInt);
      if (localObject != null) {
        ((NearbyBaseFragment)localObject).aT_();
      }
      return;
      label411:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnp
 * JD-Core Version:    0.7.0.1
 */