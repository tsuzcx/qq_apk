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

class alkm
  implements View.OnClickListener
{
  alkm(aljw paramaljw, bbav parambbav, bbba parambbba, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbav.b("200001");
    Object localObject;
    if ((this.jdField_a_of_type_Bbba.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bbba.d)))
    {
      localObject = this.jdField_a_of_type_Bbba.c;
      if (localObject == null)
      {
        localObject = "";
        switch (this.jdField_a_of_type_Bbba.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aljw.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Bbba.jdField_a_of_type_JavaLangString, 3);
      aljw.a(this.jdField_a_of_type_Aljw).removeMessages(9);
      aljw.a(this.jdField_a_of_type_Aljw).sendEmptyMessage(9);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = ((String)localObject).replace(" ", "_");
      break;
      VipUtils.a(aljw.a(this.jdField_a_of_type_Aljw), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(aljw.a(this.jdField_a_of_type_Aljw), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { localObject }));
      continue;
      VipUtils.a(aljw.a(this.jdField_a_of_type_Aljw), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { localObject }));
      continue;
      VipUtils.b(aljw.a(this.jdField_a_of_type_Aljw), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { localObject }));
      continue;
      localObject = new Intent(aljw.a(this.jdField_a_of_type_Aljw), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Bbba.d);
      aljw.a(this.jdField_a_of_type_Aljw).startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkm
 * JD-Core Version:    0.7.0.1
 */