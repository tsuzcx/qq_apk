import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class acdm
  extends alwx
{
  public acdm(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(String paramString)
  {
    if (AddRequestActivity.d(this.a))
    {
      paramString = this.a.getString(2131720551);
      QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      AddRequestActivity.a(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionError");
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.dismissDialog(2);
    }
    this.a.a(2130839405, this.a.getString(2131720087));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (!AddRequestActivity.b(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionFin");
      }
      return;
    }
    long l2 = bafi.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    structmsg.StructMsg localStructMsg;
    try
    {
      l1 = Long.parseLong(paramString1);
      localStructMsg = bafi.a().a(Long.valueOf(l1));
      if (!paramBoolean) {
        if (!TextUtils.isEmpty(paramString3))
        {
          QQToast.a(this.a, 1, paramString3, 0).b(this.a.getTitleBarHeight());
          if (bafk.a(localStructMsg, paramInt3, paramString2, paramString4)) {
            this.a.finish();
          }
          AddRequestActivity.a(this.a, false);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        l1 = l2;
        continue;
        paramString3 = this.a.getResources().getString(2131719755);
      }
      bafk.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((AddRequestActivity.c(this.a)) && (localStructMsg != null)) {
        localStructMsg.msg.friend_info.msg_blacklist.setHasFlag(false);
      }
      paramString2 = null;
      if (paramInt1 != 1) {
        break label257;
      }
    }
    this.a.setResult(-1);
    this.a.finish();
    paramString1 = this.a.getResources().getString(2131692878);
    label257:
    do
    {
      do
      {
        QQToast.a(this.a, 2, paramString1, 0).b(this.a.getTitleBarHeight());
        break;
        paramString1 = paramString2;
      } while (paramInt1 != 0);
      paramString1 = paramString2;
    } while (localStructMsg == null);
    paramString2 = this.a.getResources().getString(2131692866);
    paramString3 = new Bundle();
    paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
    paramString1 = this.a.b;
    if (TextUtils.isEmpty(this.a.b)) {
      paramString1 = this.a.jdField_a_of_type_JavaLangString;
    }
    paramString3.putString("base_nick", paramString1);
    paramString3.putInt("verfy_type", AddRequestActivity.b(this.a));
    paramString3.putString("verfy_msg", AddRequestActivity.a(this.a));
    if (AddRequestActivity.a(this.a) != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString3.putBoolean("isFromWzry", paramBoolean);
      AutoRemarkActivity.a(this.a, 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
      paramString1 = paramString2;
      break;
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.dismissDialog(2);
    }
    this.a.a(2130839405, this.a.getString(2131720072));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdm
 * JD-Core Version:    0.7.0.1
 */