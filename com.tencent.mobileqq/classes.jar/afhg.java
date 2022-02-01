import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.widget.QQToast;

class afhg
  implements bliz
{
  afhg(afhf paramafhf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_Blir.dismiss();
      return;
      bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
      abhr.a("share_success");
      this.a.a.u();
      continue;
      if (bmko.a((float)this.a.a.jdField_a_of_type_Double, (float)this.a.a.b, this.a.a.l, this.a.a.i, null).c(this.a.a.getIntent().getStringExtra("uin")).b(this.a.a, this.a.a.getIntent().getStringExtra("uin"), 1, null))
      {
        paramInt = QQMapActivity.a(this.a.a).getDimensionPixelSize(2131299011);
        QQToast.a(this.a.a, 2, this.a.a.getString(2131691991), 1).b(paramInt);
        abhr.a("favorite_success");
      }
      bmky.a(null, 65, 7);
      bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhg
 * JD-Core Version:    0.7.0.1
 */