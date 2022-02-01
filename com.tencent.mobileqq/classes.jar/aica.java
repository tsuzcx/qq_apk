import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class aica
  implements DialogInterface.OnClickListener
{
  aica(aibs paramaibs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747");
    this.a.mContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aica
 * JD-Core Version:    0.7.0.1
 */