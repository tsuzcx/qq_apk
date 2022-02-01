import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afny
  implements View.OnClickListener
{
  afny(afnv paramafnv, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!afnr.a(this.jdField_a_of_type_Afnv.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = bdgb.a(this.jdField_a_of_type_Afnv.a(this.jdField_a_of_type_Int).jdField_a_of_type_Int);
      if (!behm.a(afnr.a(this.jdField_a_of_type_Afnv.a), str, new afnz(this))) {
        afnv.a(this.jdField_a_of_type_Afnv, this.jdField_a_of_type_Int);
      }
      bmzn.a().a(str, "4", "platform898", "4", "1", 102, 1, System.currentTimeMillis());
      bdll.b(afnr.a(this.jdField_a_of_type_Afnv.a).app, "dc00898", "", "", "qq_vip", "0X800B15C", Integer.decode(str).intValue(), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afny
 * JD-Core Version:    0.7.0.1
 */