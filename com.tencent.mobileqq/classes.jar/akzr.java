import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akzr
  implements View.OnClickListener
{
  akzr(akyh paramakyh, aysb paramaysb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = ayqb.a(akyh.a(this.jdField_a_of_type_Akyh).app, this.jdField_a_of_type_Aysb.a);
    akyh.a(this.jdField_a_of_type_Akyh).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzr
 * JD-Core Version:    0.7.0.1
 */