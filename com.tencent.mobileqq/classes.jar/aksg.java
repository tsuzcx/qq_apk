import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;

class aksg
  implements View.OnClickListener
{
  aksg(aksf paramaksf) {}
  
  public void onClick(View paramView)
  {
    if (aksf.a != null) {
      aksf.a(this.a).startActivity(aksf.a);
    }
    axqw.b(null, "CliOper", "", "", "0X8006B15", "0X8006B15", 0, 0, "", "", "", "");
    axqw.b(null, "dc00898", "", "", "0X8009AC8", "0X8009AC8", 0, 0, "", "", "", "");
    paramView = PreferenceManager.getDefaultSharedPreferences(aksf.a(this.a));
    int i = paramView.getInt("push_msg_notify_open", 0);
    paramView = paramView.edit();
    paramView.putInt("push_msg_notify_open", i + 1);
    paramView.commit();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksg
 * JD-Core Version:    0.7.0.1
 */