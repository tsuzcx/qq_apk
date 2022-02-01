import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajoj
  implements View.OnClickListener
{
  ajoj(ajoi paramajoi) {}
  
  public void onClick(View paramView)
  {
    if (ajoi.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(null, "dc00898", "", "", "0X800B41B", "0X800B41B", 0, 0, "", "", null, null);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_tab_mode", 2);
      localIntent.setClass(ajoi.a(this.a), TroopActivity.class);
      localIntent.putExtra("key_from", 2);
      if (bdzy.a().a(ajoi.a(this.a)) > 0) {
        bdla.b(null, "dc00898", "", "", "0X800B52B", "0X800B52B", 0, 0, "", "", null, null);
      }
      if (ajgr.a())
      {
        ajgr.a(false);
        ajgr.a();
        localIntent.putExtra("show_type", true);
        bdla.b(null, "dc00898", "", "", "0X800B52F", "0X800B52F", 0, 0, "", "", null, null);
      }
      ajoi.a(this.a).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoj
 * JD-Core Version:    0.7.0.1
 */