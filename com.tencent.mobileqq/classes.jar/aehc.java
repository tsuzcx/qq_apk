import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class aehc
  implements DialogInterface.OnClickListener
{
  public aehc(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n();
    if (!TextUtils.isEmpty(this.a.a())) {}
    for (paramDialogInterface = "1";; paramDialogInterface = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, ndd.a(), paramDialogInterface, "0");
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehc
 * JD-Core Version:    0.7.0.1
 */