import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aepx
  implements ViewPager.OnPageChangeListener
{
  public aepx(NearbyActivity paramNearbyActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      axei.a("onPageSelected", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.a.jdField_h_of_type_Int), Integer.valueOf(paramInt) });
    }
    Object localObject = this.a;
    int i = ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabIndex;
    ((NearbyActivity)localObject).b = i;
    NearbyBaseFragment.b = i;
    if ((this.a.jdField_h_of_type_Long == 0L) && (this.a.b == 2))
    {
      this.a.jdField_h_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        axei.a("WebSpeedTrace", "mClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.jdField_h_of_type_Long) });
      }
    }
    if ((this.a.jdField_a_of_type_Long == 0L) && (this.a.b == 1))
    {
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        axei.a("WebSpeedTrace", "mNowClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.jdField_a_of_type_Long) });
      }
    }
    if (this.a.jdField_h_of_type_Int != paramInt) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    }
    if (this.a.jdField_h_of_type_Int != -1)
    {
      i = this.a.jdField_h_of_type_Int;
      if (this.a.jdField_h_of_type_Int != this.a.c) {
        break label497;
      }
      i = 9;
    }
    for (;;)
    {
      if (TextUtils.equals(anni.a(2131705876), ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabName)) {
        i = 11;
      }
      int j = ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).reportId;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          axei.a("report_switch_tab", new Object[] { ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabName, Integer.valueOf(j) });
        }
        i = j;
      }
      axei.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "switch_tab", i);
      localObject = this.a.a(paramInt);
      if (((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabType == 7)
      {
        ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).showRedRot = false;
        NearbyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.a.jdField_h_of_type_Int));
      }
      if (localObject != null)
      {
        ((NearbyBaseFragment)localObject).a(((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).showRedRot);
        ((NearbyBaseFragment)localObject).aP_();
      }
      return;
      label497:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepx
 * JD-Core Version:    0.7.0.1
 */