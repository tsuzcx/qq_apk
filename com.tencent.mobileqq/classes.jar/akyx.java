import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class akyx
  implements View.OnClickListener
{
  akyx(akyh paramakyh, baif parambaif, baik parambaik, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Baif.b("200001");
    Object localObject;
    if ((this.jdField_a_of_type_Baik.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Baik.d)))
    {
      localObject = this.jdField_a_of_type_Baik.c;
      if (localObject == null)
      {
        localObject = "";
        switch (this.jdField_a_of_type_Baik.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Akyh.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Baik.jdField_a_of_type_JavaLangString, 3);
      akyh.a(this.jdField_a_of_type_Akyh).removeMessages(9);
      akyh.a(this.jdField_a_of_type_Akyh).sendEmptyMessage(9);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = ((String)localObject).replace(" ", "_");
      break;
      VipUtils.a(akyh.a(this.jdField_a_of_type_Akyh), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(akyh.a(this.jdField_a_of_type_Akyh), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { localObject }));
      continue;
      VipUtils.a(akyh.a(this.jdField_a_of_type_Akyh), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(akyh.a(this.jdField_a_of_type_Akyh), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { localObject }));
      continue;
      localObject = new Intent(akyh.a(this.jdField_a_of_type_Akyh), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Baik.d);
      akyh.a(this.jdField_a_of_type_Akyh).startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyx
 * JD-Core Version:    0.7.0.1
 */