import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aler
  implements View.OnClickListener
{
  aler(aldh paramaldh, azeo paramazeo) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = azco.a(aldh.a(this.jdField_a_of_type_Aldh).app, this.jdField_a_of_type_Azeo.a);
    aldh.a(this.jdField_a_of_type_Aldh).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aler
 * JD-Core Version:    0.7.0.1
 */