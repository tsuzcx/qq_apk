import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper.2;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class agmo
  implements agma, agmn
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  Map<Integer, Intent> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  agmo(aglu paramaglu, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    paramaglu.a(this);
  }
  
  private PhotoListPanel a()
  {
    PhotoListPanel localPhotoListPanel = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().b(4);
    }
    return localPhotoListPanel;
  }
  
  private void e()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel == null) {}
    XPanelContainer localXPanelContainer;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
      localXPanelContainer = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    } while ((localXPanelContainer == null) || (localXPanelContainer.a() != 4));
    localPhotoListPanel.a();
    localPhotoListPanel.postDelayed(new PhotoListHelper.2(this, localPhotoListPanel), 2000L);
    localPhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  private void f()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.l();
    }
  }
  
  public Intent a(int paramInt)
  {
    return (Intent)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.requestPermissions(new agmp(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        b();
        return;
        i = 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.hashCode());
      return;
    case 9: 
      f();
      return;
    case 5: 
      e();
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.hashCode());
    d();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null) {
      if (paramInt2 == -1) {
        switch (paramInt1)
        {
        }
      }
    }
    for (;;)
    {
      localPhotoListPanel.setLastRequestCode(paramInt1);
      return;
      localPhotoListPanel.a(paramInt1, paramIntent);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    int j = 0;
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramIntent);
    if (QLog.isColorLevel())
    {
      if (paramIntent != null) {
        break label54;
      }
      QLog.d("PhotoListHelper", 2, "setSelectedPhotoData null, code=" + paramInt);
    }
    label54:
    while (!paramIntent.hasExtra("PhotoConst.SELECTED_PATHS")) {
      return;
    }
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
    StringBuilder localStringBuilder = new StringBuilder().append("setSelectedPhotoData checked size=");
    if (localObject == null)
    {
      i = 0;
      localObject = localStringBuilder.append(i).append(",checkedIndex size=");
      if (paramIntent != null) {
        break label153;
      }
    }
    label153:
    for (int i = j;; i = paramIntent.size())
    {
      QLog.d("PhotoListHelper", 2, i + ", code=" + paramInt);
      return;
      i = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public boolean a()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null)
    {
      localPhotoListPanel.e();
      return true;
    }
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 3, 13, 9, 5 };
  }
  
  public void b()
  {
    int i = 0;
    aglj localaglj = (aglj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(24);
    int j = localaglj.a();
    if (localaglj.a())
    {
      if (j >= 20)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694292, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298998));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1034)) {
        i = 1;
      }
      if ((i != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.o()))
      {
        localaglj.a(true);
        return;
      }
      agaa.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), j);
      d();
      return;
    }
    if (j > 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694267, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298998));
      return;
    }
    if (a())
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
    agaa.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, new Intent(), null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListHelper", 2, "removeSelectedPhotoData code=" + paramInt);
    }
  }
  
  public void c()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null)
    {
      localPhotoListPanel.a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
    }
  }
  
  public void d()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmo
 * JD-Core Version:    0.7.0.1
 */