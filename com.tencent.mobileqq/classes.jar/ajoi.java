import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ajoi
{
  int jdField_a_of_type_Int;
  private ajfo jdField_a_of_type_Ajfo = new ajok(this);
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
  public ajoi(View paramView, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    i();
    a();
    e();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    ajfn localajfn;
    do
    {
      return;
      localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localajfn == null);
    localajfn.a(this.jdField_a_of_type_Ajfo);
  }
  
  private void f()
  {
    if (this.c == null) {
      return;
    }
    if ((this.b == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      this.c.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((j != 0) || (i != 0)) {
        break label393;
      }
      i = ajgr.c();
      if (!ajgr.a(i)) {
        break label331;
      }
      bdla.b(null, "dc00898", "", "", "0X800B52E", "0X800B52E", 0, 0, "", "", null, null);
      String str = String.valueOf(i);
      if (i > 99) {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719678);
      }
      this.c.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131719679) + str + this.jdField_a_of_type_AndroidAppActivity.getString(2131719680));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131719676) + String.valueOf(str) + this.jdField_a_of_type_AndroidAppActivity.getString(2131719680));
      ajgr.a(true);
      i = ajgr.a() + 1;
      ajgr.a(i);
      j = ajgr.b() + 1;
      ajgr.b(j);
      ajgr.b(System.currentTimeMillis());
      blas.a(this.b, 1, 0, 0);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV bShowEntry" + this.jdField_a_of_type_Boolean + "oneWeekCount" + i + "oneDayCount" + j);
      return;
    }
    label331:
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV bShowEntry" + this.jdField_a_of_type_Boolean + " not show undeal tip");
    }
    ajgr.a(false);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    return;
    label393:
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV unReadCount" + j + " not show undeal tip");
    }
    ajgr.a(false);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {}
    do
    {
      int i;
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        i = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_Int != i)
        {
          bdla.b(null, "dc00898", "", "", "0X800B52A", "0X800B52A", 0, 0, "", "", null, null);
          this.jdField_a_of_type_Int = i;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131719676) + String.valueOf(i) + this.jdField_a_of_type_AndroidAppActivity.getString(2131719677));
        if (i <= 0) {
          break;
        }
        blas.a(this.jdField_a_of_type_AndroidWidgetTextView, 4, i, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      } while (!QLog.isColorLevel());
      QLog.d("TroopNotificationEntryController", 2, "updateRedDot bShowEntry" + this.jdField_a_of_type_Boolean + " unReadCount" + i + "  mRedDotTV is VISIBLE");
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationEntryController", 2, "updateRedDot bShowEntry" + this.jdField_a_of_type_Boolean + " mRedDotTV is GONE");
  }
  
  private void h()
  {
    ajfn localajfn = (ajfn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localajfn != null) {
      localajfn.b(this.jdField_a_of_type_Ajfo);
    }
  }
  
  private void i()
  {
    aqxv localaqxv = (aqxv)aqxe.a().a(691);
    if ((localaqxv != null) && (localaqxv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379576));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ajoj(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379577));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379580));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379578));
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "onAccountChanged");
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    e();
    i();
    d();
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "onResume bShowEntry" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B41A", "0X800B41A", 0, 0, "", "", null, null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUI bShowEntry" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    g();
    f();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoi
 * JD-Core Version:    0.7.0.1
 */