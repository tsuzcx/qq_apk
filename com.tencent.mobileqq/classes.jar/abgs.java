import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class abgs
  implements DialogInterface.OnClickListener
{
  public abgs(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.b(this.a.app, "dc00898", "", "", "0X800A0D9", "0X800A0D9", 0, 0, "", "", "", "");
    if (bbfj.d(this.a)) {
      FriendProfileMoreInfoActivity.b(this.a);
    }
    FriendProfileMoreInfoActivity.a(this.a, "https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgs
 * JD-Core Version:    0.7.0.1
 */