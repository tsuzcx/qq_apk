import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajej
  extends anyz
{
  public ajej(NotificationView paramNotificationView) {}
  
  protected void onGetSuspiciousSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    NotificationView.a(this.a);
  }
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "onGetSystemMsgFin.bengin");
    }
    NotificationView.b(this.a);
    if (((Activity)this.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    label253:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean1) {
          break label253;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NotificationView", 2, "onGetSystemMsgFin.success");
        }
        try
        {
          if ((this.a.jdField_a_of_type_JavaUtilList != null) && (paramList != null)) {
            this.a.jdField_a_of_type_JavaUtilList = TroopNotifyAndRecommendView.a(this.a.jdField_a_of_type_JavaUtilList, paramList);
          }
          if (this.a.jdField_a_of_type_Ajed != null)
          {
            this.a.jdField_a_of_type_Ajed.a(this.a.jdField_a_of_type_JavaUtilList);
            this.a.jdField_a_of_type_Ajed.a = bdzy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.a.jdField_a_of_type_Ajed.notifyDataSetChanged();
            if (this.a.b)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().c();
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bdzy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
              bdzy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
              NotificationView.a(this.a, false);
              this.a.i();
              return;
            }
          }
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
      NotificationView.a(this.a, true);
      return;
    } while ((!paramBoolean2) || (!this.a.d));
    paramList = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719153);
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramList, 0).b(this.a.a());
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing()))
    {
      this.a.jdField_a_of_type_Bisl.dismiss();
      paramString = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719155);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString1;
      if (paramBoolean) {
        break label151;
      }
      if (this.a.jdField_a_of_type_Bisl != null) {
        this.a.jdField_a_of_type_Bisl.dismiss();
      }
      paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718500);
      if (TextUtils.isEmpty(paramString3)) {
        break label564;
      }
    }
    for (;;)
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramString3, 0).b(this.a.a());
      bdzz.a(bdzy.a().a(str), paramInt3, paramString2, paramString4);
      paramString1 = bdzy.a().a(str);
      if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
      }
      return;
      str = bdzy.a().b();
      break;
      label151:
      if (this.a.jdField_a_of_type_Bisl != null) {
        this.a.jdField_a_of_type_Bisl.dismiss();
      }
      paramString3 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692568);
      if (paramInt1 == 1)
      {
        paramString1 = bdzy.a().a(str);
        if ((paramString1 != null) && (paramString1.msg.group_msg_type.get() == 82)) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, paramString1, 0).b(this.a.a());
        long l = bdzy.a().a();
        bdzz.a(bdzy.a().a(str), paramInt1, paramString2, paramInt2);
        paramString1 = bdzy.a().a(str);
        if (paramString1 != null)
        {
          paramInt2 = paramString1.msg.group_inviter_role.get();
          if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
          {
            paramString2 = "" + paramString1.msg.group_code.get();
            paramString3 = paramString1.msg.group_name.get();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(paramString2, paramString3);
          }
        }
        if (l != 0L) {}
        try
        {
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString1 != null)) {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, l, paramString1.toByteArray());
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("NotificationView", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        return;
        paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692562);
        continue;
        if (paramInt1 == 2)
        {
          paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692567);
        }
        else
        {
          paramString1 = paramString3;
          if (paramInt1 == 0)
          {
            paramString4 = bdzy.a().a(str);
            paramString1 = paramString3;
            if (paramString4 != null)
            {
              paramString1 = paramString3;
              if (paramString4.msg.group_msg_type.get() == 82) {
                paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692567);
              }
            }
          }
        }
      }
      label564:
      paramString3 = paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajej
 * JD-Core Version:    0.7.0.1
 */