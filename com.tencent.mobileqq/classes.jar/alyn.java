import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class alyn
  extends anmu
{
  public alyn(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    paramArrayOfObject = (String[])paramArrayOfObject[1];
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onSetSpecialCareSwitch_global isSucess= " + paramBoolean + ",type=" + i + ",uinSize=" + paramArrayOfObject.length);
    }
    if ((SpecailCareListActivity.a(this.a) != null) && (paramArrayOfObject != null)) {}
    for (boolean bool = Arrays.equals(SpecailCareListActivity.a(this.a), paramArrayOfObject);; bool = false)
    {
      if (bool) {
        if (paramArrayOfObject.length >= 1)
        {
          this.a.h();
          if (paramBoolean) {
            if (this.a.c != null)
            {
              this.a.d();
              QQToast.a(BaseApplication.getContext(), 2, 2131689560, 0).b(this.a.getTitleBarHeight());
              this.a.a();
              this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
            }
          }
        }
      }
      while (!paramBoolean)
      {
        do
        {
          for (;;)
          {
            return;
            QQToast.a(BaseApplication.getContext(), 2, 2131698330, 0).b(this.a.getTitleBarHeight());
          }
          if (this.a.c != null)
          {
            QQToast.a(BaseApplication.getContext(), 1, 2131698314, 0).b(this.a.getTitleBarHeight());
            return;
          }
          QQToast.a(BaseApplication.getContext(), 1, 2131698329, 0).b(this.a.getTitleBarHeight());
          return;
        } while (!paramBoolean);
        this.a.a();
        this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
        return;
      }
      this.a.a();
      this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
      return;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateDelFriend isSucess= " + paramBoolean + ", uin=" + (Long)paramObject);
    }
    if (paramBoolean)
    {
      this.a.a();
      this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateFriendList isSuccess=" + paramBoolean1 + ", isComplete=" + paramBoolean2 + " mIsPullRefresh=" + this.a.jdField_a_of_type_Boolean);
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      this.a.a();
      this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label135;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2001, 1000L);
      this.a.jdField_a_of_type_Boolean = false;
    }
    label135:
    while (paramBoolean1) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2001, 1000L);
    this.a.jdField_a_of_type_Boolean = false;
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSignature isSucess= " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.a.d != 0) {
        this.a.b = true;
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSignature isSucess= " + paramBoolean);
    }
    if (this.a.d != 0)
    {
      this.a.b = true;
      return;
    }
    this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.a.a();
      this.a.jdField_a_of_type_Alyt.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyn
 * JD-Core Version:    0.7.0.1
 */