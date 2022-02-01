import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;

public class ajnj
  implements ajms
{
  public ajnj(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnj
 * JD-Core Version:    0.7.0.1
 */