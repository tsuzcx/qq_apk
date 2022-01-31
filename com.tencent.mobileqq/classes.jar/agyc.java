import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

class agyc
  implements View.OnClickListener
{
  agyc(agxq paramagxq, auqh paramauqh, auql paramauql, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Auqh.b("200001");
    if ((this.jdField_a_of_type_Auql.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Auql.d)))
    {
      paramView = this.jdField_a_of_type_Auql.c;
      if (paramView == null)
      {
        paramView = "";
        switch (this.jdField_a_of_type_Auql.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Agxq.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Auql.jdField_a_of_type_JavaLangString, 3);
      agxq.a(this.jdField_a_of_type_Agxq).removeMessages(9);
      agxq.a(this.jdField_a_of_type_Agxq).sendEmptyMessage(9);
      return;
      paramView = paramView.replace(" ", "_");
      break;
      bajr.a(agxq.a(this.jdField_a_of_type_Agxq), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      bajr.b(agxq.a(this.jdField_a_of_type_Agxq), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      bajr.a(agxq.a(this.jdField_a_of_type_Agxq), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      bajr.b(agxq.a(this.jdField_a_of_type_Agxq), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
      continue;
      paramView = new Intent(agxq.a(this.jdField_a_of_type_Agxq), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Auql.d);
      agxq.a(this.jdField_a_of_type_Agxq).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyc
 * JD-Core Version:    0.7.0.1
 */