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

public class abwo
  extends ajey
{
  public abwo(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(azjk paramazjk)
  {
    if ((paramazjk == null) || (!paramazjk.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + paramazjk.jdField_a_of_type_Int);
    }
    ajty localajty;
    abwq localabwq;
    if (paramazjk.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (paramazjk.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramazjk = paramazjk.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramazjk.hasNext())
        {
          localajty = (ajty)paramazjk.next();
          localabwq = new abwq();
          localabwq.jdField_a_of_type_JavaLangString = localajty.jdField_a_of_type_JavaLangString;
          localabwq.jdField_a_of_type_Long = localajty.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localabwq);
        }
      }
      this.a.jdField_a_of_type_Abwr.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (paramazjk.jdField_a_of_type_Int == 1)
      {
        paramazjk = paramazjk.jdField_a_of_type_Azjo;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (paramazjk.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (paramazjk.jdField_a_of_type_Int == 5)
      {
        if (!paramazjk.jdField_a_of_type_Azjl.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (paramazjk.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramazjk = paramazjk.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramazjk.hasNext())
            {
              localajty = (ajty)paramazjk.next();
              localabwq = new abwq();
              localabwq.jdField_a_of_type_JavaLangString = localajty.jdField_a_of_type_JavaLangString;
              localabwq.jdField_a_of_type_Long = localajty.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localabwq);
            }
          }
          this.a.jdField_a_of_type_Abwr.notifyDataSetChanged();
        }
      }
      else if (paramazjk.jdField_a_of_type_Int == 4)
      {
        paramazjk = paramazjk.jdField_a_of_type_Azjm;
        if (!paramazjk.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (paramazjk.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     abwo
 * JD-Core Version:    0.7.0.1
 */