import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;

public class akix
  implements akig
{
  public akix(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    PhoneLaunchActivity.a(this.a).setEnabled(true);
    if ((!paramBoolean) && (paramContext != null))
    {
      Intent localIntent = new Intent(paramContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", 2);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akix
 * JD-Core Version:    0.7.0.1
 */