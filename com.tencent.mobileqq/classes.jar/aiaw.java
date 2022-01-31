import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.SplashActivity;

class aiaw
  implements DialogInterface.OnClickListener
{
  aiaw(aiak paramaiak) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    if (this.a.a.getIntent().getExtras() != null) {
      paramDialogInterface.putExtras(this.a.a.getIntent().getExtras());
    }
    paramDialogInterface.addFlags(268435456);
    paramDialogInterface.addFlags(67108864);
    this.a.a.startActivity(paramDialogInterface);
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaw
 * JD-Core Version:    0.7.0.1
 */