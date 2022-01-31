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

public class acgw
  extends ajsy
{
  public acgw(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(balb parambalb)
  {
    if ((parambalb == null) || (!parambalb.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambalb.jdField_a_of_type_Int);
    }
    akih localakih;
    acgy localacgy;
    if (parambalb.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambalb.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambalb = parambalb.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambalb.hasNext())
        {
          localakih = (akih)parambalb.next();
          localacgy = new acgy();
          localacgy.jdField_a_of_type_JavaLangString = localakih.jdField_a_of_type_JavaLangString;
          localacgy.jdField_a_of_type_Long = localakih.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localacgy);
        }
      }
      this.a.jdField_a_of_type_Acgz.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambalb.jdField_a_of_type_Int == 1)
      {
        parambalb = parambalb.jdField_a_of_type_Balf;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambalb.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambalb.jdField_a_of_type_Int == 5)
      {
        if (!parambalb.jdField_a_of_type_Balc.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambalb.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambalb = parambalb.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambalb.hasNext())
            {
              localakih = (akih)parambalb.next();
              localacgy = new acgy();
              localacgy.jdField_a_of_type_JavaLangString = localakih.jdField_a_of_type_JavaLangString;
              localacgy.jdField_a_of_type_Long = localakih.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localacgy);
            }
          }
          this.a.jdField_a_of_type_Acgz.notifyDataSetChanged();
        }
      }
      else if (parambalb.jdField_a_of_type_Int == 4)
      {
        parambalb = parambalb.jdField_a_of_type_Bald;
        if (!parambalb.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambalb.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     acgw
 * JD-Core Version:    0.7.0.1
 */