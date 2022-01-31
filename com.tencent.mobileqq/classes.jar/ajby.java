import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

class ajby
  implements View.OnClickListener
{
  ajby(ajbm paramajbm, axho paramaxho, axhu paramaxhu, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Axho.b("200001");
    if ((this.jdField_a_of_type_Axhu.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Axhu.d)))
    {
      paramView = this.jdField_a_of_type_Axhu.c;
      if (paramView == null)
      {
        paramView = "";
        switch (this.jdField_a_of_type_Axhu.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajbm.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Axhu.jdField_a_of_type_JavaLangString, 3);
      ajbm.a(this.jdField_a_of_type_Ajbm).removeMessages(9);
      ajbm.a(this.jdField_a_of_type_Ajbm).sendEmptyMessage(9);
      return;
      paramView = paramView.replace(" ", "_");
      break;
      VipUtils.a(ajbm.a(this.jdField_a_of_type_Ajbm), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ajbm.a(this.jdField_a_of_type_Ajbm), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      VipUtils.a(ajbm.a(this.jdField_a_of_type_Ajbm), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ajbm.a(this.jdField_a_of_type_Ajbm), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
      continue;
      paramView = new Intent(ajbm.a(this.jdField_a_of_type_Ajbm), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Axhu.d);
      ajbm.a(this.jdField_a_of_type_Ajbm).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajby
 * JD-Core Version:    0.7.0.1
 */