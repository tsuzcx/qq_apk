import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

class ajgn
  implements View.OnClickListener
{
  ajgn(ajgb paramajgb, axlx paramaxlx, axmd paramaxmd, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Axlx.b("200001");
    if ((this.jdField_a_of_type_Axmd.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Axmd.d)))
    {
      paramView = this.jdField_a_of_type_Axmd.c;
      if (paramView == null)
      {
        paramView = "";
        switch (this.jdField_a_of_type_Axmd.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajgb.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Axmd.jdField_a_of_type_JavaLangString, 3);
      ajgb.a(this.jdField_a_of_type_Ajgb).removeMessages(9);
      ajgb.a(this.jdField_a_of_type_Ajgb).sendEmptyMessage(9);
      return;
      paramView = paramView.replace(" ", "_");
      break;
      VipUtils.a(ajgb.a(this.jdField_a_of_type_Ajgb), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ajgb.a(this.jdField_a_of_type_Ajgb), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      VipUtils.a(ajgb.a(this.jdField_a_of_type_Ajgb), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ajgb.a(this.jdField_a_of_type_Ajgb), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
      continue;
      paramView = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Axmd.d);
      ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgn
 * JD-Core Version:    0.7.0.1
 */