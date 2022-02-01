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

public class afjg
  extends anif
{
  public afjg(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bfsn parambfsn)
  {
    if ((parambfsn == null) || (!parambfsn.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambfsn.jdField_a_of_type_Int);
    }
    anxb localanxb;
    afji localafji;
    if (parambfsn.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambfsn.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambfsn = parambfsn.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambfsn.hasNext())
        {
          localanxb = (anxb)parambfsn.next();
          localafji = new afji();
          localafji.jdField_a_of_type_JavaLangString = localanxb.jdField_a_of_type_JavaLangString;
          localafji.jdField_a_of_type_Long = localanxb.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localafji);
        }
      }
      this.a.jdField_a_of_type_Afjj.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambfsn.jdField_a_of_type_Int == 1)
      {
        parambfsn = parambfsn.jdField_a_of_type_Bfsr;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambfsn.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambfsn.jdField_a_of_type_Int == 5)
      {
        if (!parambfsn.jdField_a_of_type_Bfso.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambfsn.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambfsn = parambfsn.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambfsn.hasNext())
            {
              localanxb = (anxb)parambfsn.next();
              localafji = new afji();
              localafji.jdField_a_of_type_JavaLangString = localanxb.jdField_a_of_type_JavaLangString;
              localafji.jdField_a_of_type_Long = localanxb.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localafji);
            }
          }
          this.a.jdField_a_of_type_Afjj.notifyDataSetChanged();
        }
      }
      else if (parambfsn.jdField_a_of_type_Int == 4)
      {
        parambfsn = parambfsn.jdField_a_of_type_Bfsp;
        if (!parambfsn.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambfsn.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     afjg
 * JD-Core Version:    0.7.0.1
 */