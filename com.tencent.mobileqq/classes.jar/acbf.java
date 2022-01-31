import android.os.Handler;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.6.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class acbf
  implements INetEventHandler
{
  acbf(acaz paramacaz) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Toast.makeText(BaseApplicationImpl.getApplication(), this.a.a.getString(2131694619), 1).show();
      SendMultiPictureHelper.6.1 local1 = new SendMultiPictureHelper.6.1(this);
      new Handler().postDelayed(local1, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbf
 * JD-Core Version:    0.7.0.1
 */