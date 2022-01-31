import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class adar
  implements DialogInterface.OnClickListener
{
  public adar(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.d == 1) {
      VipUtils.a(this.a, 1, bddf.a(3));
    }
    for (;;)
    {
      this.a.C();
      return;
      if (this.a.d == 2) {
        VipUtils.b(this.a, 1, bddf.a(6));
      } else if (this.a.d == 3) {
        VipUtils.a(this.a, true, 12, false, bddf.a(6));
      } else if (this.a.d == 4) {
        bdun.a(this.a, bddf.a(6), "SVHHZLH", 0, false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adar
 * JD-Core Version:    0.7.0.1
 */