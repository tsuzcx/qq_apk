import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aist
{
  int jdField_a_of_type_Int;
  private aiks jdField_a_of_type_Aiks = new aisv(this);
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
  public aist(View paramView, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
    aikq localaikq;
    do
    {
      return;
      localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localaikq == null);
    localaikq.a(this.jdField_a_of_type_Aiks);
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
      j = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((j != 0) || (i != 0)) {
        break label393;
      }
      i = ailu.c();
      if (!ailu.a(i)) {
        break label331;
      }
      bcef.b(null, "dc00898", "", "", "0X800B52E", "0X800B52E", 0, 0, "", "", null, null);
      String str = String.valueOf(i);
      if (i > 99) {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719257);
      }
      this.c.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131719258) + str + this.jdField_a_of_type_AndroidAppActivity.getString(2131719259));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131719255) + String.valueOf(str) + this.jdField_a_of_type_AndroidAppActivity.getString(2131719259));
      ailu.a(true);
      i = ailu.a() + 1;
      ailu.a(i);
      j = ailu.b() + 1;
      ailu.b(j);
      ailu.b(System.currentTimeMillis());
      bjpg.a(this.b, 1, 0, 0);
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
    ailu.a(false);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    return;
    label393:
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV unReadCount" + j + " not show undeal tip");
    }
    ailu.a(false);
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
        i = bcsz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_Int != i)
        {
          bcef.b(null, "dc00898", "", "", "0X800B52A", "0X800B52A", 0, 0, "", "", null, null);
          this.jdField_a_of_type_Int = i;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131719255) + String.valueOf(i) + this.jdField_a_of_type_AndroidAppActivity.getString(2131719256));
        if (i <= 0) {
          break;
        }
        bjpg.a(this.jdField_a_of_type_AndroidWidgetTextView, 4, i, 0);
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
    aikq localaikq = (aikq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    if (localaikq != null) {
      localaikq.b(this.jdField_a_of_type_Aiks);
    }
  }
  
  private void i()
  {
    apus localapus = (apus)apub.a().a(691);
    if ((localapus != null) && (localapus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379272));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aisu(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379273));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379276));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379274));
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
    bcef.b(null, "dc00898", "", "", "0X800B41A", "0X800B41A", 0, 0, "", "", null, null);
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
 * Qualified Name:     aist
 * JD-Core Version:    0.7.0.1
 */