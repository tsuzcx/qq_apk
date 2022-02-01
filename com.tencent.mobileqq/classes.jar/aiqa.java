import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import mqq.app.AppRuntime;

class aiqa
  implements DialogInterface.OnClickListener
{
  aiqa(aipz paramaipz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.getActivity() != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication.getRuntime().getApplication(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://h5.qianbao.qq.com/auth?_wv=1027&_wvx=10&_wwv=4");
      this.a.a.getActivity().startActivity(localIntent);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqa
 * JD-Core Version:    0.7.0.1
 */