import Wallet.SkinInfo;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment;

public class albv
  implements alcr
{
  public albv(UsualHbFragment paramUsualHbFragment) {}
  
  public void a(alch paramalch)
  {
    if ((paramalch.a.skin_id == 0) || (paramalch.a.skin_id == -2))
    {
      paramalch = alcg.a(this.a.channel, this.a.a, this.a.mActivity.a(), paramalch.a.blessing);
      this.a.c.setHint(paramalch);
      return;
    }
    if (TextUtils.isEmpty(paramalch.a.blessing))
    {
      this.a.c.setHint(anzj.a(2131696147));
      return;
    }
    this.a.c.setHint(paramalch.a.blessing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albv
 * JD-Core Version:    0.7.0.1
 */