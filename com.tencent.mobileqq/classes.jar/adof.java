import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Locale;

public class adof
  implements Runnable
{
  public adof(UnitedVerifyMsgEditFragment paramUnitedVerifyMsgEditFragment) {}
  
  public void run()
  {
    Object localObject1 = this.a.getArguments().getString("TROOP_UIN", "");
    TroopManager localTroopManager = (TroopManager)this.a.a.app.getManager(51);
    Object localObject2 = localTroopManager.a((String)localObject1);
    localObject1 = localTroopManager.c((String)localObject1, this.a.a.app.getAccount());
    if (localObject2 == null)
    {
      localObject2 = "";
      if (localObject1 != null) {
        break label150;
      }
      localObject1 = ContactUtils.a(this.a.a.app, this.a.a.app.getAccount());
      label97:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label252;
      }
    }
    label150:
    label252:
    for (localObject2 = String.format(Locale.getDefault(), "我是%s", new Object[] { localObject1 });; localObject2 = String.format(Locale.getDefault(), "我是来自群聊 %s 的%s", new Object[] { localObject2, localObject1 }))
    {
      this.a.a.runOnUiThread(new adog(this, (String)localObject2, (String)localObject1));
      return;
      localObject2 = ((TroopInfo)localObject2).getTroopName();
      break;
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopremark))
      {
        localObject1 = ((TroopMemberInfo)localObject1).troopremark;
        break label97;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick))
      {
        localObject1 = ((TroopMemberInfo)localObject1).troopnick;
        break label97;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark))
      {
        localObject1 = ((TroopMemberInfo)localObject1).autoremark;
        break label97;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick))
      {
        localObject1 = ((TroopMemberInfo)localObject1).friendnick;
        break label97;
      }
      localObject1 = ContactUtils.a(this.a.a.app, this.a.a.app.getAccount());
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adof
 * JD-Core Version:    0.7.0.1
 */