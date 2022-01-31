import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class aefn
  implements DialogInterface.OnClickListener
{
  aefn(aefe paramaefe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a(), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747");
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefn
 * JD-Core Version:    0.7.0.1
 */