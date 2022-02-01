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

public class aeld
  extends amop
{
  public aeld(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(bfcc parambfcc)
  {
    if ((parambfcc == null) || (!parambfcc.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + parambfcc.jdField_a_of_type_Int);
    }
    ancz localancz;
    aelf localaelf;
    if (parambfcc.jdField_a_of_type_Int == 3)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      if (parambfcc.jdField_a_of_type_JavaUtilArrayList != null)
      {
        parambfcc = parambfcc.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambfcc.hasNext())
        {
          localancz = (ancz)parambfcc.next();
          localaelf = new aelf();
          localaelf.jdField_a_of_type_JavaLangString = localancz.jdField_a_of_type_JavaLangString;
          localaelf.jdField_a_of_type_Long = localancz.jdField_a_of_type_Long;
          this.a.jdField_a_of_type_JavaUtilList.add(localaelf);
        }
      }
      this.a.jdField_a_of_type_Aelg.notifyDataSetChanged();
    }
    while (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (parambfcc.jdField_a_of_type_Int == 1)
      {
        parambfcc = parambfcc.jdField_a_of_type_Bfcg;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (parambfcc.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
          break;
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
      }
      if (parambfcc.jdField_a_of_type_Int == 5)
      {
        if (!parambfcc.jdField_a_of_type_Bfcd.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (parambfcc.jdField_a_of_type_JavaUtilArrayList != null)
          {
            parambfcc = parambfcc.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (parambfcc.hasNext())
            {
              localancz = (ancz)parambfcc.next();
              localaelf = new aelf();
              localaelf.jdField_a_of_type_JavaLangString = localancz.jdField_a_of_type_JavaLangString;
              localaelf.jdField_a_of_type_Long = localancz.jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localaelf);
            }
          }
          this.a.jdField_a_of_type_Aelg.notifyDataSetChanged();
        }
      }
      else if (parambfcc.jdField_a_of_type_Int == 4)
      {
        parambfcc = parambfcc.jdField_a_of_type_Bfce;
        if (!parambfcc.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (parambfcc.jdField_a_of_type_Long != 0L) {
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
 * Qualified Name:     aeld
 * JD-Core Version:    0.7.0.1
 */