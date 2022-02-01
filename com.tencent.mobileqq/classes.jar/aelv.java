import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PCActiveNoticeActiviy;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class aelv
  implements DialogInterface.OnClickListener
{
  public aelv(PCActiveNoticeActiviy paramPCActiveNoticeActiviy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingCloneUtil.writeValue(this.a, PCActiveNoticeActiviy.a(this.a), null, "pcactive_notice_key", false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelv
 * JD-Core Version:    0.7.0.1
 */