import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aijm
  implements DialogInterface.OnClickListener
{
  public aijm(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setResult(-1, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aijm
 * JD-Core Version:    0.7.0.1
 */