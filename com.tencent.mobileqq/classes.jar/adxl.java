import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

public final class adxl
  implements DialogInterface.OnClickListener
{
  public adxl(int paramInt, String paramString, Context paramContext, hiboom_auth.TTipsInfo paramTTipsInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 1: 
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, -1L, null, false, -1);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_TencentHiboomHiboomauthHiboom_auth$TTipsInfo.str_vip_type.get();
    String str1 = this.jdField_a_of_type_TencentHiboomHiboomauthHiboom_auth$TTipsInfo.str_month.get();
    String str2 = this.jdField_a_of_type_TencentHiboomHiboomauthHiboom_auth$TTipsInfo.str_aid.get();
    if (((String)localObject).startsWith("!")) {
      localObject = ((String)localObject).substring(1, ((String)localObject).length());
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (str1.startsWith("!")) {
        str1 = str1.substring(1, str1.length());
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        VasH5PayUtil.a(this.jdField_a_of_type_AndroidContentContext, str2, (String)localObject, Integer.parseInt(str1), bool2, bool1);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break;
        }
        localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
        if ((((FragmentActivity)localObject).getChatFragment() == null) || (((FragmentActivity)localObject).getChatFragment().a() == null)) {
          break;
        }
        ((HiBoomManager)((FragmentActivity)localObject).getChatFragment().a().a.getManager(218)).b.set(false);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */