import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.3.1;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afci
  extends ajmm
{
  public afci(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void a(String paramString)
  {
    if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing()))
    {
      this.a.jdField_a_of_type_Bbms.dismiss();
      paramString = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131654104);
      bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = axcz.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        if (paramBoolean) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Bbms != null) {
          this.a.jdField_a_of_type_Bbms.dismiss();
        }
        paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131653422);
        if (TextUtils.isEmpty(paramString3)) {
          break label590;
        }
        bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramString3, 0).b(this.a.a());
        axda.a(axcz.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4);
        paramString1 = axcz.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label169:
      if (this.a.jdField_a_of_type_Bbms != null) {
        this.a.jdField_a_of_type_Bbms.dismiss();
      }
      paramString3 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131627155);
      if (paramInt1 == 1)
      {
        paramString1 = axcz.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg.group_msg_type.get() == 82)) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 2, paramString1, 0).b(this.a.a());
        l2 = axcz.a().a();
        axda.a(axcz.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
        paramString1 = axcz.a().a(Long.valueOf(l1));
        if (paramString1 != null)
        {
          paramInt2 = paramString1.msg.group_inviter_role.get();
          if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
          {
            paramString2 = "" + paramString1.msg.group_code.get();
            paramString3 = paramString1.msg.group_name.get();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString2, paramString3);
          }
        }
        if (l2 != 0L) {}
        try
        {
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString1 != null)) {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajed.N, 0, l2, paramString1.toByteArray());
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("TroopNotifyAndRecommendView", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        return;
        paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131627143);
        continue;
        if (paramInt1 == 2)
        {
          paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131627153);
        }
        else
        {
          paramString1 = paramString3;
          if (paramInt1 == 0)
          {
            paramString4 = axcz.a().a(Long.valueOf(l1));
            paramString1 = paramString3;
            if (paramString4 != null)
            {
              paramString1 = paramString3;
              if (paramString4.msg.group_msg_type.get() == 82) {
                paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131627153);
              }
            }
          }
        }
      }
      label590:
      paramString3 = paramString1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.bengin");
    }
    TroopNotifyAndRecommendView.b(this.a);
    if (((Activity)this.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    for (;;)
    {
      return;
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
        }
        try
        {
          if ((this.a.jdField_a_of_type_JavaUtilList != null) && (paramList != null)) {
            this.a.jdField_a_of_type_JavaUtilList = TroopNotifyAndRecommendView.a(this.a.jdField_a_of_type_JavaUtilList, paramList);
          }
          if ((this.a.jdField_a_of_type_Afbk != null) && (this.a.jdField_a_of_type_Afaw != null))
          {
            this.a.jdField_a_of_type_Afaw.a(new TroopNotifyAndRecommendView.3.1(this));
            return;
          }
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    TroopNotifyAndRecommendView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afci
 * JD-Core Version:    0.7.0.1
 */