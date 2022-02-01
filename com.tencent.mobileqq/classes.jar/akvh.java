import Wallet.SkinInfo;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment;

public class akvh
  implements akwd
{
  public akvh(UsualHbFragment paramUsualHbFragment) {}
  
  public void a(akvt paramakvt)
  {
    if ((paramakvt.a.skin_id == 0) || (paramakvt.a.skin_id == -2))
    {
      paramakvt = akvs.a(this.a.channel, this.a.a, this.a.mActivity.a(), paramakvt.a.blessing);
      this.a.c.setHint(paramakvt);
      return;
    }
    if (TextUtils.isEmpty(paramakvt.a.blessing))
    {
      this.a.c.setHint(anvx.a(2131696541));
      return;
    }
    this.a.c.setHint(paramakvt.a.blessing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvh
 * JD-Core Version:    0.7.0.1
 */