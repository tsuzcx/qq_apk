import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akiy
  implements View.OnClickListener
{
  akiy(akho paramakho, axyc paramaxyc) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = axwc.a(akho.a(this.jdField_a_of_type_Akho).app, this.jdField_a_of_type_Axyc.a);
    akho.a(this.jdField_a_of_type_Akho).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akiy
 * JD-Core Version:    0.7.0.1
 */