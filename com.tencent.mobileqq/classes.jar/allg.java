import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class allg
  implements View.OnClickListener
{
  allg(aljw paramaljw, azku paramazku) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = aziu.a(aljw.a(this.jdField_a_of_type_Aljw).app, this.jdField_a_of_type_Azku.a);
    aljw.a(this.jdField_a_of_type_Aljw).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allg
 * JD-Core Version:    0.7.0.1
 */