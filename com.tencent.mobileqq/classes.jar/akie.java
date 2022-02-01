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

class akie
  implements View.OnClickListener
{
  akie(akho paramakho, azvi paramazvi, azvn paramazvn, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Azvi.b("200001");
    Object localObject;
    if ((this.jdField_a_of_type_Azvn.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Azvn.d)))
    {
      localObject = this.jdField_a_of_type_Azvn.c;
      if (localObject == null)
      {
        localObject = "";
        switch (this.jdField_a_of_type_Azvn.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Akho.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Azvn.jdField_a_of_type_JavaLangString, 3);
      akho.a(this.jdField_a_of_type_Akho).removeMessages(9);
      akho.a(this.jdField_a_of_type_Akho).sendEmptyMessage(9);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = ((String)localObject).replace(" ", "_");
      break;
      VipUtils.a(akho.a(this.jdField_a_of_type_Akho), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(akho.a(this.jdField_a_of_type_Akho), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { localObject }));
      continue;
      VipUtils.a(akho.a(this.jdField_a_of_type_Akho), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(akho.a(this.jdField_a_of_type_Akho), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { localObject }));
      continue;
      localObject = new Intent(akho.a(this.jdField_a_of_type_Akho), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Azvn.d);
      akho.a(this.jdField_a_of_type_Akho).startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akie
 * JD-Core Version:    0.7.0.1
 */