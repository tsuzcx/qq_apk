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

public class afcl
  extends anrc
{
  public afcl(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bgki parambgki)
  {
    if ((parambgki == null) || (!parambgki.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambgki.jdField_a_of_type_Int);
    }
    aofq localaofq;
    afcn localafcn;
    if (parambgki.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambgki.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambgki = parambgki.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambgki.hasNext())
        {
          localaofq = (aofq)parambgki.next();
          localafcn = new afcn();
          localafcn.jdField_a_of_type_JavaLangString = localaofq.jdField_a_of_type_JavaLangString;
          localafcn.jdField_a_of_type_Long = localaofq.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localafcn);
        }
      }
      this.a.jdField_a_of_type_Afco.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambgki.jdField_a_of_type_Int == 1)
      {
        parambgki = parambgki.jdField_a_of_type_Bgkm;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambgki.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambgki.jdField_a_of_type_Int == 5)
      {
        if (!parambgki.jdField_a_of_type_Bgkj.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambgki.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambgki = parambgki.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambgki.hasNext())
            {
              localaofq = (aofq)parambgki.next();
              localafcn = new afcn();
              localafcn.jdField_a_of_type_JavaLangString = localaofq.jdField_a_of_type_JavaLangString;
              localafcn.jdField_a_of_type_Long = localaofq.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localafcn);
            }
          }
          this.a.jdField_a_of_type_Afco.notifyDataSetChanged();
        }
      }
      else if (parambgki.jdField_a_of_type_Int == 4)
      {
        parambgki = parambgki.jdField_a_of_type_Bgkk;
        if (!parambgki.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambgki.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     afcl
 * JD-Core Version:    0.7.0.1
 */