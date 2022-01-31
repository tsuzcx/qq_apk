import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acha
  extends ajta
{
  public acha(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bakn parambakn)
  {
    if ((parambakn == null) || (!parambakn.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambakn.jdField_a_of_type_Int);
    }
    akii localakii;
    achc localachc;
    if (parambakn.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambakn.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambakn = parambakn.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambakn.hasNext())
        {
          localakii = (akii)parambakn.next();
          localachc = new achc();
          localachc.jdField_a_of_type_JavaLangString = localakii.jdField_a_of_type_JavaLangString;
          localachc.jdField_a_of_type_Long = localakii.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localachc);
        }
      }
      this.a.jdField_a_of_type_Achd.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambakn.jdField_a_of_type_Int == 1)
      {
        parambakn = parambakn.jdField_a_of_type_Bakr;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambakn.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambakn.jdField_a_of_type_Int == 5)
      {
        if (!parambakn.jdField_a_of_type_Bako.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambakn.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambakn = parambakn.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambakn.hasNext())
            {
              localakii = (akii)parambakn.next();
              localachc = new achc();
              localachc.jdField_a_of_type_JavaLangString = localakii.jdField_a_of_type_JavaLangString;
              localachc.jdField_a_of_type_Long = localakii.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localachc);
            }
          }
          this.a.jdField_a_of_type_Achd.notifyDataSetChanged();
        }
      }
      else if (parambakn.jdField_a_of_type_Int == 4)
      {
        parambakn = parambakn.jdField_a_of_type_Bakp;
        if (!parambakn.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambakn.jdField_a_of_type_Long != 0L) {
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
          }
          for (;;)
          {
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
            break;
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
          }
        }
      }
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acha
 * JD-Core Version:    0.7.0.1
 */