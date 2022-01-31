import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class acto
{
  public static void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    localIntent.setData(Uri.parse("mqqapi://qzone/to_friend_feeds"));
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if ((!"msg_tab_camera".equals(paramString)) || (paramIntent == null)) {
      return;
    }
    bizm.a(paramFragmentActivity, paramQQAppInterface, paramIntent, 20005, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acto
 * JD-Core Version:    0.7.0.1
 */