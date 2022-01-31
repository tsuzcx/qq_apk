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

public class aecv
  extends alpa
{
  public aecv(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bcnx parambcnx)
  {
    if ((parambcnx == null) || (!parambcnx.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambcnx.jdField_a_of_type_Int);
    }
    amem localamem;
    aecx localaecx;
    if (parambcnx.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambcnx.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambcnx = parambcnx.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambcnx.hasNext())
        {
          localamem = (amem)parambcnx.next();
          localaecx = new aecx();
          localaecx.jdField_a_of_type_JavaLangString = localamem.jdField_a_of_type_JavaLangString;
          localaecx.jdField_a_of_type_Long = localamem.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localaecx);
        }
      }
      this.a.jdField_a_of_type_Aecy.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambcnx.jdField_a_of_type_Int == 1)
      {
        parambcnx = parambcnx.jdField_a_of_type_Bcob;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambcnx.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambcnx.jdField_a_of_type_Int == 5)
      {
        if (!parambcnx.jdField_a_of_type_Bcny.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambcnx.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambcnx = parambcnx.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambcnx.hasNext())
            {
              localamem = (amem)parambcnx.next();
              localaecx = new aecx();
              localaecx.jdField_a_of_type_JavaLangString = localamem.jdField_a_of_type_JavaLangString;
              localaecx.jdField_a_of_type_Long = localamem.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localaecx);
            }
          }
          this.a.jdField_a_of_type_Aecy.notifyDataSetChanged();
        }
      }
      else if (parambcnx.jdField_a_of_type_Int == 4)
      {
        parambcnx = parambcnx.jdField_a_of_type_Bcnz;
        if (!parambcnx.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambcnx.jdField_a_of_type_Long != 0L) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecv
 * JD-Core Version:    0.7.0.1
 */