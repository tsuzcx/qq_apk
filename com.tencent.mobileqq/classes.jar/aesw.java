import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.HashMap;

public class aesw
  implements DialogInterface.OnClickListener
{
  public aesw(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.l();
    if (VipUtils.b(this.a.app))
    {
      if (this.a.jdField_a_of_type_Long != 0L) {
        break label144;
      }
      paramDialogInterface = (String)this.a.jdField_a_of_type_JavaUtilHashMap.get(this.a.d);
      if (!TextUtils.isEmpty(paramDialogInterface)) {
        this.a.a(this.a.d, paramDialogInterface, false);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_Long != 0L) && (this.a.jdField_a_of_type_Long != 160L)) {
        break label222;
      }
    }
    label144:
    label222:
    for (paramDialogInterface = "3";; paramDialogInterface = "4")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "0");
      return;
      this.a.a(this.a.d, false);
      break;
      if (((this.a.jdField_a_of_type_Long != 160L) && (this.a.jdField_a_of_type_Long != 1600L)) || (TextUtils.isEmpty(this.a.b))) {
        break;
      }
      paramDialogInterface = aymh.a(this.a, aymn.n, this.a.jdField_a_of_type_Long);
      this.a.a(paramDialogInterface, this.a.b, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */