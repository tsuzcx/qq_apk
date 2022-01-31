import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomUtils;

public final class aepf
  implements DialogInterface.OnClickListener
{
  public aepf(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GameRoomUtils.a(this.a, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepf
 * JD-Core Version:    0.7.0.1
 */