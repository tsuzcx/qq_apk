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

public class afsk
  extends anua
{
  public afsk(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bgso parambgso)
  {
    if ((parambgso == null) || (!parambgso.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambgso.jdField_a_of_type_Int);
    }
    aojo localaojo;
    afsm localafsm;
    if (parambgso.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambgso.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambgso = parambgso.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambgso.hasNext())
        {
          localaojo = (aojo)parambgso.next();
          localafsm = new afsm();
          localafsm.jdField_a_of_type_JavaLangString = localaojo.jdField_a_of_type_JavaLangString;
          localafsm.jdField_a_of_type_Long = localaojo.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localafsm);
        }
      }
      this.a.jdField_a_of_type_Afsn.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambgso.jdField_a_of_type_Int == 1)
      {
        parambgso = parambgso.jdField_a_of_type_Bgss;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambgso.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambgso.jdField_a_of_type_Int == 5)
      {
        if (!parambgso.jdField_a_of_type_Bgsp.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambgso.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambgso = parambgso.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambgso.hasNext())
            {
              localaojo = (aojo)parambgso.next();
              localafsm = new afsm();
              localafsm.jdField_a_of_type_JavaLangString = localaojo.jdField_a_of_type_JavaLangString;
              localafsm.jdField_a_of_type_Long = localaojo.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localafsm);
            }
          }
          this.a.jdField_a_of_type_Afsn.notifyDataSetChanged();
        }
      }
      else if (parambgso.jdField_a_of_type_Int == 4)
      {
        parambgso = parambgso.jdField_a_of_type_Bgsq;
        if (!parambgso.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambgso.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     afsk
 * JD-Core Version:    0.7.0.1
 */