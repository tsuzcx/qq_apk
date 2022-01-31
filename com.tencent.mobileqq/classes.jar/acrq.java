import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.util.WeakReference;

public class acrq
  implements View.OnClickListener
{
  public acrq(BirthdayActivatePage paramBirthdayActivatePage) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    long[] arrayOfLong;
    if ((BirthdayActivatePage.a(this.a) != null) && (BirthdayActivatePage.a(this.a).get() != null))
    {
      localObject = QzoneConfig.getInstance().getConfig("H5Url", "SendBirthdayGift", "https://h5.qzone.qq.com/giftv2/detail?_wv=131075&_fv=0&_wwv=128&uin={uin}&clicktime={clicktime}&friends={uin_uin}&_proxy=1");
      arrayOfLong = this.a.a.a();
      String[] arrayOfString = this.a.a.a();
      if (arrayOfLong.length <= 0) {
        break label358;
      }
      paramView = "";
      int i = 0;
      while (i < arrayOfLong.length)
      {
        paramView = paramView + arrayOfLong[i];
        paramView = paramView + "_";
        String str = paramView + arrayOfString[i];
        int j = i + 1;
        i = j;
        paramView = str;
        if (j < arrayOfLong.length)
        {
          paramView = str + "|";
          i = j;
        }
      }
      paramView = ((String)localObject).replace("{uin_uin}", Uri.encode(paramView)).replace("{clicktime}", String.valueOf(System.currentTimeMillis()));
      localObject = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("injectrecommend", true);
      ((Intent)localObject).setData(Uri.parse(paramView));
      ((ActivateFriendActivity)BirthdayActivatePage.a(this.a).get()).startActivityForResult((Intent)localObject, 1000);
      axqw.b(((ActivateFriendActivity)BirthdayActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E08", "0X8004E08", 0, 0, String.valueOf(arrayOfLong.length), "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BirthdayActivatePage", 2, "friends length=" + arrayOfLong.length + " url = " + paramView);
      }
      return;
      label358:
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acrq
 * JD-Core Version:    0.7.0.1
 */