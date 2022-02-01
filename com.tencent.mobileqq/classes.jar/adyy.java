import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.AppRuntime;

class adyy
  implements DialogInterface.OnClickListener
{
  adyy(adyx paramadyx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.a() != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication.getRuntime().getApplication(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://h5.qianbao.qq.com/auth?_wv=1027&_wvx=10&_wwv=4");
      this.a.a.a().startActivity(localIntent);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyy
 * JD-Core Version:    0.7.0.1
 */