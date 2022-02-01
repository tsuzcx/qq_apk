import android.app.Dialog;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.39.1;
import com.tencent.mobileqq.widget.QQToast;

public class afvr
  extends anwt
{
  public afvr(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      bdll.b(this.a.app, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.a.a(paramLong2 + "");
      if (this.a.jdField_a_of_type_Afwg != null) {
        this.a.jdField_a_of_type_Afwg.a();
      }
      if (this.a.h)
      {
        this.a.b(paramLong2 + "");
        if (this.a.jdField_a_of_type_Afwi != null) {
          this.a.jdField_a_of_type_Afwi.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      QQToast.a(this.a, 1, this.a.getString(2131693183), 0).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.runOnUiThread(new TroopMemberListActivity.39.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvr
 * JD-Core Version:    0.7.0.1
 */