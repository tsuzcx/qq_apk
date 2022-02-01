import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akyv
  implements View.OnClickListener
{
  akyv(akyh paramakyh, aysb paramaysb) {}
  
  public void onClick(View paramView)
  {
    if (akyh.a(this.jdField_a_of_type_Akyh).app.getExtOnlineStatus() > 40001L) {
      ayqb.a(akyh.a(this.jdField_a_of_type_Akyh).app, 40001L, false, "br_close");
    }
    for (;;)
    {
      aypy.a("0X800AF9F", (int)this.jdField_a_of_type_Aysb.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Akyh.a(28, 0);
      this.jdField_a_of_type_Akyh.a(28, null);
      ayqb.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyv
 * JD-Core Version:    0.7.0.1
 */