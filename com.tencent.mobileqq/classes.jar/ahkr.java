import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

class ahkr
  implements View.OnClickListener
{
  ahkr(ahkf paramahkf, avpq paramavpq, avpu paramavpu, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Avpq.b("200001");
    if ((this.jdField_a_of_type_Avpu.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Avpu.d)))
    {
      paramView = this.jdField_a_of_type_Avpu.c;
      if (paramView == null)
      {
        paramView = "";
        switch (this.jdField_a_of_type_Avpu.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahkf.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Avpu.jdField_a_of_type_JavaLangString, 3);
      ahkf.a(this.jdField_a_of_type_Ahkf).removeMessages(9);
      ahkf.a(this.jdField_a_of_type_Ahkf).sendEmptyMessage(9);
      return;
      paramView = paramView.replace(" ", "_");
      break;
      VipUtils.a(ahkf.a(this.jdField_a_of_type_Ahkf), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ahkf.a(this.jdField_a_of_type_Ahkf), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      VipUtils.a(ahkf.a(this.jdField_a_of_type_Ahkf), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(ahkf.a(this.jdField_a_of_type_Ahkf), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
      continue;
      paramView = new Intent(ahkf.a(this.jdField_a_of_type_Ahkf), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Avpu.d);
      ahkf.a(this.jdField_a_of_type_Ahkf).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkr
 * JD-Core Version:    0.7.0.1
 */