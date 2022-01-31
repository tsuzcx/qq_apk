import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;

class agyh
  implements View.OnClickListener
{
  agyh(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c != null) && ("1600000104".equals(this.a.c.trim())))
    {
      if (this.a.jdField_b_of_type_Long == 77313L) {
        this.a.jdField_b_of_type_Boolean = true;
      }
      this.a.c();
    }
    do
    {
      return;
      paramView = new Intent(agxq.a(this.a), QRLoginMgrActivity.class);
      paramView.putExtra("loginInfo", this.a.jdField_b_of_type_JavaLangString);
      paramView.putExtra("appType", this.a.jdField_b_of_type_Int);
      paramView.putExtra("subappid", this.a.a);
      paramView.putExtra("clientType", this.a.jdField_b_of_type_Long);
      agxq.a(this.a).startActivity(paramView);
      awqx.a(agxq.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 10, 0, "", "", "", "");
    } while (this.a.jdField_b_of_type_Long != 77313L);
    awqx.b(agxq.a(this.a).app, "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyh
 * JD-Core Version:    0.7.0.1
 */