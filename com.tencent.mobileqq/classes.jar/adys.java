import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class adys
  implements View.OnClickListener
{
  public adys(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    azqs.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 4, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "bell", "click", "", 1, 0, 0, "", "", "");
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", bdtg.a("specialCareRingUrl").replace("[uid]", "").replace("[lType]", "1"));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adys
 * JD-Core Version:    0.7.0.1
 */