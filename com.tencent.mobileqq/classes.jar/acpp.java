import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class acpp
  implements DialogInterface.OnClickListener
{
  public acpp(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.l();
    this.a.a(auvf.g, this.a.a, false);
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, naj.a(), "2", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acpp
 * JD-Core Version:    0.7.0.1
 */