import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;

class aksh
  implements View.OnClickListener
{
  aksh(aksf paramaksf) {}
  
  public void onClick(View paramView)
  {
    axqw.b(null, "CliOper", "", "", "0X8006B16", "0X8006B16", 0, 0, "", "", "", "");
    axqw.b(null, "dc00898", "", "", "0X8009AC9", "0X8009AC9", 0, 0, "", "", "", "");
    paramView = PreferenceManager.getDefaultSharedPreferences(aksf.a(this.a));
    int i = paramView.getInt("push_msg_notify_cancle", 0);
    paramView = paramView.edit();
    paramView.putInt("push_msg_notify_cancle", i + 1);
    paramView.commit();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksh
 * JD-Core Version:    0.7.0.1
 */