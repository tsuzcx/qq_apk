import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akii
  implements View.OnClickListener
{
  akii(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c != null) && ("1600000104".equals(this.a.c.trim())))
    {
      if (this.a.jdField_b_of_type_Long == 77313L) {
        this.a.jdField_b_of_type_Boolean = true;
      }
      this.a.d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(akho.a(this.a), QRLoginMgrActivity.class);
      localIntent.putExtra("loginInfo", this.a.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("appType", this.a.jdField_b_of_type_Int);
      localIntent.putExtra("subappid", this.a.a);
      localIntent.putExtra("clientType", this.a.jdField_b_of_type_Long);
      akho.a(this.a).startActivity(localIntent);
      bcef.a(akho.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 10, 0, "", "", "", "");
      if (this.a.jdField_b_of_type_Long == 77313L) {
        bcef.b(akho.a(this.a).app, "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akii
 * JD-Core Version:    0.7.0.1
 */