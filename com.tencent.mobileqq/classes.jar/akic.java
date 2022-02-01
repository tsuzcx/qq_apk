import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akic
  implements View.OnClickListener
{
  akic(akho paramakho, axyc paramaxyc) {}
  
  public void onClick(View paramView)
  {
    if (akho.a(this.jdField_a_of_type_Akho).app.getExtOnlineStatus() > 40001L) {
      axwc.a(akho.a(this.jdField_a_of_type_Akho).app, 40001L, false, "br_close");
    }
    for (;;)
    {
      axvz.a("0X800AF9F", (int)this.jdField_a_of_type_Axyc.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Akho.a(30, 0);
      this.jdField_a_of_type_Akho.a(30, null);
      axwc.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akic
 * JD-Core Version:    0.7.0.1
 */