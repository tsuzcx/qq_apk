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

public class adyg
  extends alkl
{
  public adyg(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bcjo parambcjo)
  {
    if ((parambcjo == null) || (!parambcjo.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambcjo.jdField_a_of_type_Int);
    }
    alzx localalzx;
    adyi localadyi;
    if (parambcjo.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambcjo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambcjo = parambcjo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambcjo.hasNext())
        {
          localalzx = (alzx)parambcjo.next();
          localadyi = new adyi();
          localadyi.jdField_a_of_type_JavaLangString = localalzx.jdField_a_of_type_JavaLangString;
          localadyi.jdField_a_of_type_Long = localalzx.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localadyi);
        }
      }
      this.a.jdField_a_of_type_Adyj.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambcjo.jdField_a_of_type_Int == 1)
      {
        parambcjo = parambcjo.jdField_a_of_type_Bcjs;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambcjo.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambcjo.jdField_a_of_type_Int == 5)
      {
        if (!parambcjo.jdField_a_of_type_Bcjp.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambcjo.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambcjo = parambcjo.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambcjo.hasNext())
            {
              localalzx = (alzx)parambcjo.next();
              localadyi = new adyi();
              localadyi.jdField_a_of_type_JavaLangString = localalzx.jdField_a_of_type_JavaLangString;
              localadyi.jdField_a_of_type_Long = localalzx.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localadyi);
            }
          }
          this.a.jdField_a_of_type_Adyj.notifyDataSetChanged();
        }
      }
      else if (parambcjo.jdField_a_of_type_Int == 4)
      {
        parambcjo = parambcjo.jdField_a_of_type_Bcjq;
        if (!parambcjo.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambcjo.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     adyg
 * JD-Core Version:    0.7.0.1
 */