import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;

public class aavn
  extends ajxj
{
  public aavn(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    int j = -10000;
    if ((!paramString.equals(ContactSyncJumpActivity.a(this.a))) && (!paramString.equals(ContactSyncJumpActivity.b(this.a) + ContactSyncJumpActivity.c(this.a)))) {}
    label103:
    int i;
    label132:
    label161:
    label189:
    label216:
    label358:
    label364:
    label372:
    label380:
    do
    {
      return;
      boolean bool;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onGetOnlineInfo | isSuccess = ").append(paramBoolean);
        localObject = paramString.append(" | resp = ");
        if (paramGetOnlineInfoResp == null) {
          break label358;
        }
        bool = true;
        ((StringBuilder)localObject).append(bool);
        localObject = paramString.append(" | resp.result = ");
        if (paramGetOnlineInfoResp == null) {
          break label364;
        }
        i = paramGetOnlineInfoResp.result;
        ((StringBuilder)localObject).append(i);
        localObject = paramString.append(" | resp.errorCode = ");
        if (paramGetOnlineInfoResp == null) {
          break label372;
        }
        i = paramGetOnlineInfoResp.errorCode;
        ((StringBuilder)localObject).append(i);
        localObject = paramString.append(" | resp.iTermType = ");
        if (paramGetOnlineInfoResp == null) {
          break label380;
        }
        paramLong = paramGetOnlineInfoResp.iTermType;
        ((StringBuilder)localObject).append(paramLong);
        localObject = paramString.append(" | resp.status = ");
        if (paramGetOnlineInfoResp == null) {
          break label387;
        }
        paramLong = paramGetOnlineInfoResp.dwStatus;
        ((StringBuilder)localObject).append(paramLong);
        localObject = paramString.append(" | resp.ability = ");
        if (paramGetOnlineInfoResp == null) {
          break label394;
        }
      }
      for (paramLong = paramGetOnlineInfoResp.uAbiFlag;; paramLong = -10000L)
      {
        ((StringBuilder)localObject).append(paramLong);
        localObject = paramString.append(" | resp.network = ");
        i = j;
        if (paramGetOnlineInfoResp != null) {
          i = paramGetOnlineInfoResp.eNetworkType;
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("ContactSync.JumpActivity", 2, paramString.toString());
        if ((paramBoolean) && (paramGetOnlineInfoResp != null)) {
          break label401;
        }
        if ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (this.a.jdField_a_of_type_Int != 2)) {
          break;
        }
        paramString = (TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131365181);
        paramString.setText(2131698727);
        paramString.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
        bool = false;
        break label103;
        i = -10000;
        break label132;
        i = -10000;
        break label161;
        paramLong = -10000L;
        break label189;
        paramLong = -10000L;
        break label216;
      }
      if (paramGetOnlineInfoResp.result == 1)
      {
        if ((paramGetOnlineInfoResp.errorCode == 60001) || (paramGetOnlineInfoResp.errorCode == -5535))
        {
          paramString = String.format(this.a.getResources().getString(2131698717), new Object[] { ContactSyncJumpActivity.d(this.a) });
          ContactSyncJumpActivity.a(this.a).a(ContactSyncJumpActivity.e(this.a));
          ContactSyncJumpActivity.a(this.a, 1, paramString);
          return;
        }
        this.a.finish();
        return;
      }
    } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) && (this.a.jdField_a_of_type_Int != 2));
    label387:
    label394:
    label401:
    paramString = "";
    String str1 = ContactSyncJumpActivity.a(this.a).a(paramGetOnlineInfoResp);
    String str2 = ContactSyncJumpActivity.a(this.a).b(paramGetOnlineInfoResp);
    if (!TextUtils.isEmpty(str1)) {
      paramString = str1;
    }
    Object localObject = paramString;
    if (!TextUtils.isEmpty(str1))
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(str2))
      {
        paramString = paramString + "\n";
        localObject = paramString + str2;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
      label642:
      if (i != 0) {
        break label760;
      }
    }
    label760:
    for (paramString = this.a.getResources().getString(2131698727);; paramString = (String)localObject)
    {
      localObject = (TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131365181);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((i == 0) || ((paramGetOnlineInfoResp.eNetworkType != 4) && (paramGetOnlineInfoResp.eNetworkType != 1))) {
        break;
      }
      paramString = new Message();
      paramString.what = 1000;
      paramString.arg1 = 4;
      ContactSyncJumpActivity.a(this.a).sendMessage(paramString);
      return;
      i = 0;
      break label642;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aavn
 * JD-Core Version:    0.7.0.1
 */