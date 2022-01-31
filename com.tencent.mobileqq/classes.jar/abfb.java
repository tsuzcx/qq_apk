import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class abfb
  implements DialogInterface.OnClickListener
{
  public abfb(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.d == 1) {
      VipUtils.a(this.a, 1, bbac.a(3));
    }
    for (;;)
    {
      this.a.D();
      return;
      if (this.a.d == 2) {
        VipUtils.b(this.a, 1, bbac.a(6));
      } else if (this.a.d == 3) {
        VipUtils.a(this.a, true, 12, false, bbac.a(6));
      } else if (this.a.d == 4) {
        bbrk.a(this.a, bbac.a(6), "SVHHZLH", 0, false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfb
 * JD-Core Version:    0.7.0.1
 */