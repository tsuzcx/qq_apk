import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;

public class ajlz
  implements ajms
{
  public ajlz(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = "permission_denied_by_user";; paramContext = "permission_denied")
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("bind_mobile", this.a.a());
      localIntent.putExtra("check_permission_result", paramContext);
      localIntent.putExtra("kSrouce", BindVerifyActivity.a(this.a));
      this.a.setResult(-1, localIntent);
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlz
 * JD-Core Version:    0.7.0.1
 */