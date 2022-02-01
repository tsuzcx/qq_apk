import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aldv
  implements View.OnClickListener
{
  aldv(aldh paramaldh, azeo paramazeo) {}
  
  public void onClick(View paramView)
  {
    if (aldh.a(this.jdField_a_of_type_Aldh).app.getExtOnlineStatus() > 40001L) {
      azco.a(aldh.a(this.jdField_a_of_type_Aldh).app, 40001L, false, "br_close");
    }
    for (;;)
    {
      azcl.a("0X800AF9F", (int)this.jdField_a_of_type_Azeo.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Aldh.a(30, 0);
      this.jdField_a_of_type_Aldh.a(30, null);
      azco.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldv
 * JD-Core Version:    0.7.0.1
 */