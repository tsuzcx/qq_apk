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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import mqq.util.WeakReference;

public class afsu
  implements View.OnClickListener
{
  public afsu(BirthdayActivatePage paramBirthdayActivatePage) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    long[] arrayOfLong;
    Object localObject1;
    if ((BirthdayActivatePage.a(this.a) != null) && (BirthdayActivatePage.a(this.a).get() != null))
    {
      localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "SendBirthdayGift", "https://h5.qzone.qq.com/giftv2/detail?_wv=131075&_fv=0&_wwv=128&uin={uin}&clicktime={clicktime}&friends={uin_uin}&_proxy=1");
      arrayOfLong = this.a.a.a();
      String[] arrayOfString = this.a.a.a();
      if (arrayOfLong.length <= 0) {
        break label378;
      }
      localObject1 = "";
      int i = 0;
      while (i < arrayOfLong.length)
      {
        localObject1 = (String)localObject1 + arrayOfLong[i];
        localObject1 = (String)localObject1 + "_";
        String str = (String)localObject1 + arrayOfString[i];
        int j = i + 1;
        i = j;
        localObject1 = str;
        if (j < arrayOfLong.length)
        {
          localObject1 = str + "|";
          i = j;
        }
      }
      localObject1 = ((String)localObject2).replace("{uin_uin}", Uri.encode((String)localObject1)).replace("{clicktime}", String.valueOf(System.currentTimeMillis()));
      localObject2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("injectrecommend", true);
      ((Intent)localObject2).setData(Uri.parse((String)localObject1));
      ((ActivateFriendActivity)BirthdayActivatePage.a(this.a).get()).startActivityForResult((Intent)localObject2, 1000);
      bcst.b(((ActivateFriendActivity)BirthdayActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E08", "0X8004E08", 0, 0, String.valueOf(arrayOfLong.length), "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BirthdayActivatePage", 2, "friends length=" + arrayOfLong.length + " url = " + (String)localObject1);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label378:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsu
 * JD-Core Version:    0.7.0.1
 */