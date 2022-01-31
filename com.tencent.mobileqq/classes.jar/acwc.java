import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class acwc
  implements DialogInterface.OnClickListener
{
  public acwc(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.d == 1) {
      VipUtils.a(this.a, 1, bcyw.a(3));
    }
    for (;;)
    {
      this.a.C();
      return;
      if (this.a.d == 2) {
        VipUtils.b(this.a, 1, bcyw.a(6));
      } else if (this.a.d == 3) {
        VipUtils.a(this.a, true, 12, false, bcyw.a(6));
      } else if (this.a.d == 4) {
        bdqe.a(this.a, bcyw.a(6), "SVHHZLH", 0, false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwc
 * JD-Core Version:    0.7.0.1
 */