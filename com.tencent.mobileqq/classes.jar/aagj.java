import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aagj
  implements View.OnClickListener
{
  aagj(aagb paramaagb, bfie parambfie) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopTipsPopWindow", 2, "mTroopNotifyAdImage onClick--------");
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_Aagb.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Bfie.b);
    this.jdField_a_of_type_Aagb.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    bdla.b(this.jdField_a_of_type_Aagb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "clk_ad", 0, 0, this.jdField_a_of_type_Aagb.b, String.valueOf(this.jdField_a_of_type_Aagb.jdField_a_of_type_Bfid.a), "8020205751015455", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagj
 * JD-Core Version:    0.7.0.1
 */