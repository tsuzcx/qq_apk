import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

public class agda
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public agda(ProfileHeaderView paramProfileHeaderView, View paramView1, View paramView2, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getWidth() - AIOUtils.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getResources());
    int j = this.b.getWidth();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateJueban widthLike = " + i + ", widthJueban = " + j);
    }
    if ((i != 0) && (j != 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin -= (j - i) / 2;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = new DataTag(34, null);
    this.b.setTag(localObject);
    this.b.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(ProfileHeaderView.f, ProfileHeaderView.b);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agda
 * JD-Core Version:    0.7.0.1
 */