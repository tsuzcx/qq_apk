import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

class ahkp
  implements View.OnClickListener
{
  ahkp(ahkd paramahkd, avps paramavps, avpw paramavpw, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Avps.b("200001");
    if ((this.jdField_a_of_type_Avpw.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Avpw.d)))
    {
      paramView = this.jdField_a_of_type_Avpw.c;
      if (paramView == null)
      {
        paramView = "";
        switch (this.jdField_a_of_type_Avpw.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahkd.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Avpw.jdField_a_of_type_JavaLangString, 3);
      ahkd.a(this.jdField_a_of_type_Ahkd).removeMessages(9);
      ahkd.a(this.jdField_a_of_type_Ahkd).sendEmptyMessage(9);
      return;
      paramView = paramView.replace(" ", "_");
      break;
      VipUtils.a(ahkd.a(this.jdField_a_of_type_Ahkd), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ahkd.a(this.jdField_a_of_type_Ahkd), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      VipUtils.a(ahkd.a(this.jdField_a_of_type_Ahkd), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ahkd.a(this.jdField_a_of_type_Ahkd), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
      continue;
      paramView = new Intent(ahkd.a(this.jdField_a_of_type_Ahkd), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Avpw.d);
      ahkd.a(this.jdField_a_of_type_Ahkd).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkp
 * JD-Core Version:    0.7.0.1
 */