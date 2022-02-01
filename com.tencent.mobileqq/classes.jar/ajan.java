import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
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

public class ajan
  extends anqd
{
  public ajan(SystemMsgListView paramSystemMsgListView) {}
  
  protected void a(String paramString)
  {
    if (this.a.jdField_a_of_type_Aixx.a())
    {
      paramString = SystemMsgListView.a(this.a).getResources().getString(2131718381);
      QQToast.a(SystemMsgListView.a(this.a), 1, paramString, 0).b(this.a.a());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionError");
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = bdgm.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      structmsg.StructMsg localStructMsg;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
        localStructMsg = bdgm.a().a(Long.valueOf(l1));
        if (this.a.jdField_a_of_type_Aixx.a()) {
          break label90;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin");
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label90:
      if (!paramBoolean)
      {
        if (!TextUtils.isEmpty(paramString3)) {}
        for (;;)
        {
          QQToast.a(SystemMsgListView.a(this.a), 1, paramString3, 0).b(this.a.a());
          bdgo.a(localStructMsg, paramInt3, paramString2, paramString4);
          return;
          paramString3 = SystemMsgListView.a(this.a).getResources().getString(2131717746);
        }
      }
      paramString1 = SystemMsgListView.a(this.a).getResources().getString(2131692406);
      QQToast.a(SystemMsgListView.a(this.a), 2, paramString1, 0).b(this.a.a());
      long l2 = bdgm.a().a();
      bdgo.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((l2 != 0L) && (localStructMsg != null)) {}
      try
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0, l2, localStructMsg.toByteArray());
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
        if (ajas.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localStructMsg.req_uin.get()), localStructMsg, false))
        {
          paramString4 = new String(localStructMsg.msg.bytes_game_nick.get().toByteArray());
          paramString2 = paramString1;
          if (!TextUtils.isEmpty(paramString4)) {
            paramString2 = KplRoleInfo.WZRYUIinfo.buildNickName(paramString1, paramString4);
          }
          paramString3.putString("base_nick", paramString2);
          paramString3.putBoolean("isFromWzry", true);
        }
        AutoRemarkActivity.a(this.a.jdField_a_of_type_Aixx.getActivity(), 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.bengin");
    }
    this.a.k();
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.success");
      }
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
    }
    while (!paramBoolean2) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1016);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.bengin");
    }
    if (((Activity)SystemMsgListView.a(this.a)).isFinishing()) {}
    while (!paramBoolean1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.success");
    }
    try
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      this.a.i();
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    if (SystemMsgListView.a(this.a) != null) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgError");
    }
    this.a.k();
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajan
 * JD-Core Version:    0.7.0.1
 */