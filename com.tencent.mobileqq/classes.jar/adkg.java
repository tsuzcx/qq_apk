import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class adkg
  implements DialogInterface.OnClickListener
{
  public adkg(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcef.b(this.a.app, "dc00898", "", "", "0X800A0D9", "0X800A0D9", 0, 0, "", "", "", "");
    if (NetworkUtil.isNetSupport(this.a)) {
      FriendProfileMoreInfoActivity.b(this.a);
    }
    FriendProfileMoreInfoActivity.a(this.a, "https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkg
 * JD-Core Version:    0.7.0.1
 */