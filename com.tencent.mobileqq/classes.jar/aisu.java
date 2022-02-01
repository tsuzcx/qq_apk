import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aisu
  implements View.OnClickListener
{
  aisu(aist paramaist) {}
  
  public void onClick(View paramView)
  {
    if (aist.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(null, "dc00898", "", "", "0X800B41B", "0X800B41B", 0, 0, "", "", null, null);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_tab_mode", 2);
      localIntent.setClass(aist.a(this.a), TroopActivity.class);
      localIntent.putExtra("key_from", 2);
      if (bcsz.a().a(aist.a(this.a)) > 0) {
        bcef.b(null, "dc00898", "", "", "0X800B52B", "0X800B52B", 0, 0, "", "", null, null);
      }
      if (ailu.a())
      {
        ailu.a(false);
        ailu.a();
        localIntent.putExtra("show_type", true);
        bcef.b(null, "dc00898", "", "", "0X800B52F", "0X800B52F", 0, 0, "", "", null, null);
      }
      aist.a(this.a).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisu
 * JD-Core Version:    0.7.0.1
 */