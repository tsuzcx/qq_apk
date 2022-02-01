import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class alkq
  extends amwl
{
  alkq(alkj paramalkj) {}
  
  public void onAddFriendByContact(String paramString)
  {
    alkj.c(this.a);
  }
  
  protected void onDeleteAllSysMsg(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onDeleteAllSysMsg " + paramBoolean + " " + paramInt);
    }
    alkj.d(this.a);
    if (paramBoolean)
    {
      if (alkj.a(this.a) != null) {
        alkj.a(this.a).finish();
      }
      return;
    }
    QQToast.a(alkj.a(this.a), 2131698636, 0).a();
  }
  
  protected void onGetDelSystemMsgError()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgError");
    }
    alkj.d(this.a);
    String str = alkj.a(this.a).getResources().getString(2131718756);
    QQToast.a(alkj.a(this.a), 1, str, 0).b(alkj.b(this.a));
  }
  
  protected void onGetDelSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgFin|isSuccess : " + paramBoolean1 + ", bTimeOut : " + paramBoolean2);
    }
    alkj.d(this.a);
    if (paramBoolean1) {
      alkj.c(this.a);
    }
    while ((!paramBoolean2) || (!alkj.a(this.a))) {
      return;
    }
    String str = alkj.a(this.a).getResources().getString(2131718756);
    QQToast.a(alkj.a(this.a), 1, str, 0).b(alkj.b(this.a));
  }
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetSystemMsgFin|isSuccess : " + paramBoolean1 + ", bTimeOut : " + paramBoolean2);
    }
    if (alkj.a(this.a).isFinishing()) {
      return;
    }
    if (paramBoolean1) {
      alkj.c(this.a);
    }
    for (;;)
    {
      alkj.e(this.a);
      return;
      if ((paramBoolean2) && (alkj.a(this.a)))
      {
        paramList = alkj.a(this.a).getResources().getString(2131718763);
        QQToast.a(alkj.a(this.a), 1, paramList, 0).b(alkj.b(this.a));
      }
    }
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionError execute");
    }
    alkj.d(this.a);
    paramString = alkj.a(this.a).getResources().getString(2131718765);
    QQToast.a(alkj.a(this.a), 1, paramString, 0).b(alkj.b(this.a));
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin|isSuccess : " + paramBoolean + ",logStr : " + paramString1 + ",actionType : " + paramInt1 + ", msgDetail : " + paramString2 + ",resultCode : " + paramInt2 + ", respType : " + paramInt3 + "msgFail : " + paramString3 + "msgInvalidDecided : " + paramString4 + ",remarkRet : " + paramInt4);
    }
    alkj.d(this.a);
    this.a.notifyDataSetChanged();
    long l1 = bcsy.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      structmsg.StructMsg localStructMsg;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        localStructMsg = bcsy.a().a(Long.valueOf(l1));
        if (paramBoolean) {
          break label239;
        }
        if (TextUtils.isEmpty(paramString3)) {
          break label219;
        }
        QQToast.a(alkj.a(this.a), 1, paramString3, 0).b(alkj.b(this.a));
        bcta.a(localStructMsg, paramInt3, paramString2, paramString4);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label219:
      paramString3 = alkj.a(this.a).getResources().getString(2131718115);
      continue;
      label239:
      paramString1 = alkj.a(this.a).getResources().getString(2131692460);
      QQToast.a(alkj.a(this.a), 2, paramString1, 0).b(alkj.b(this.a));
      long l2 = bcsy.a().a();
      bcta.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((l2 != 0L) && (localStructMsg != null)) {}
      try
      {
        this.a.a.getMessageFacade().updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l2, localStructMsg.toByteArray());
        if ((paramInt1 != 0) || (localStructMsg == null)) {
          continue;
        }
        paramString3 = new Bundle();
        paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
        paramString2 = localStructMsg.msg.req_uin_nick.get();
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = String.valueOf(localStructMsg.req_uin.get());
        }
        paramString3.putString("base_nick", paramString1);
        paramString3.putInt("verfy_type", localStructMsg.msg.sub_type.get());
        paramString3.putString("verfy_msg", localStructMsg.msg.msg_additional.get());
        if (aigj.a(this.a.a, String.valueOf(localStructMsg.req_uin.get()), localStructMsg, false))
        {
          paramString4 = new String(localStructMsg.msg.bytes_game_nick.get().toByteArray());
          paramString2 = paramString1;
          if (!TextUtils.isEmpty(paramString4)) {
            paramString2 = KplRoleInfo.WZRYUIinfo.buildNickName(paramString1, paramString4);
          }
          paramString3.putString("base_nick", paramString2);
          paramString3.putBoolean("isFromWzry", true);
        }
        AutoRemarkActivity.a(alkj.a(this.a), 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkq
 * JD-Core Version:    0.7.0.1
 */