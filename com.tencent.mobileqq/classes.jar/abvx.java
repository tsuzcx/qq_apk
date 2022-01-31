import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.QQMapActivity;

class abvx
  implements bfoq
{
  abvx(abvw paramabvw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_Bfol.dismiss();
      return;
      axqw.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
      xnq.a("share_success");
      this.a.a.u();
      continue;
      if (bgpd.a((float)this.a.a.jdField_a_of_type_Double, (float)this.a.a.b, this.a.a.l, this.a.a.i, null).c(this.a.a.getIntent().getStringExtra("uin")).b(this.a.a, this.a.a.getIntent().getStringExtra("uin"), 1, null))
      {
        paramInt = QQMapActivity.a(this.a.a).getDimensionPixelSize(2131298865);
        bcpw.a(this.a.a, 2, this.a.a.getString(2131692325), 1).b(paramInt);
        xnq.a("favorite_success");
      }
      bgpr.a(null, 65, 7);
      axqw.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvx
 * JD-Core Version:    0.7.0.1
 */