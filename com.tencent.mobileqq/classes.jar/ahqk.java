import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.BaseActivity;
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
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ahqk
  extends alwx
{
  public ahqk(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  protected void a(String paramString)
  {
    if ((TroopSuspiciousFragment.a(this.a) != null) && (TroopSuspiciousFragment.a(this.a).isShowing()))
    {
      TroopSuspiciousFragment.a(this.a).dismiss();
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720551);
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin");
    }
    long l1 = bafj.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        if (paramBoolean) {
          break label176;
        }
        if (TroopSuspiciousFragment.a(this.a) != null) {
          TroopSuspiciousFragment.a(this.a).dismiss();
        }
        paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719755);
        if (TextUtils.isEmpty(paramString3)) {
          break label590;
        }
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString3, 0).b(this.a.a());
        bafk.a(bafj.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4);
        paramString1 = bafj.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
          TroopSuspiciousFragment.e(this.a);
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label176:
      if (TroopSuspiciousFragment.a(this.a) != null) {
        TroopSuspiciousFragment.a(this.a).dismiss();
      }
      paramString3 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692878);
      if (paramInt1 == 1)
      {
        paramString1 = bafj.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg.group_msg_type.get() == 82)) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, paramString1, 0).b(this.a.a());
        l2 = bafj.a().a();
        bafk.a(bafj.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
        paramString1 = bafj.a().a(Long.valueOf(l1));
        if (paramString1 != null)
        {
          paramInt2 = paramString1.msg.group_inviter_role.get();
          if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
          {
            paramString2 = "" + paramString1.msg.group_code.get();
            paramString3 = paramString1.msg.group_name.get();
            TroopSuspiciousFragment.a(this.a).a().c(paramString2, paramString3);
          }
        }
        if (l2 != 0L) {}
        try
        {
          if ((TroopSuspiciousFragment.a(this.a) != null) && (paramString1 != null)) {
            TroopSuspiciousFragment.a(this.a).a().a(alof.O, 0, l2, paramString1.toByteArray());
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
        TroopSuspiciousFragment.e(this.a);
        return;
        paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692866);
        continue;
        if (paramInt1 == 2)
        {
          paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692876);
        }
        else
        {
          paramString1 = paramString3;
          if (paramInt1 == 0)
          {
            paramString4 = bafj.a().a(Long.valueOf(l1));
            paramString1 = paramString3;
            if (paramString4 != null)
            {
              paramString1 = paramString3;
              if (paramString4.msg.group_msg_type.get() == 82) {
                paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692876);
              }
            }
          }
        }
      }
      label590:
      paramString3 = paramString1;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onGetSuspiciousSystemMsgFin.bengin");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    for (;;)
    {
      return;
      TroopSuspiciousFragment.d(this.a);
      if ((!paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_Boolean))
      {
        String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720546);
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, str, 0).b(this.a.a());
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopSuspiciousFragment", 2, "onGetSuspiciousSystemMsgFin.success");
      }
      try
      {
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (paramList.size() > 0))
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          this.a.jdField_a_of_type_JavaUtilList = TroopNotifyAndRecommendView.a(this.a.jdField_a_of_type_JavaUtilList, paramList);
        }
        bafj.a().b(TroopSuspiciousFragment.a(this.a), 0);
        if (TroopSuspiciousFragment.a(this.a) != null)
        {
          TroopSuspiciousFragment.a(this.a).a();
          TroopSuspiciousFragment.a(this.a).a(this.a.jdField_a_of_type_JavaUtilList);
          TroopSuspiciousFragment.a(this.a).notifyDataSetChanged();
          TroopSuspiciousFragment.a(this.a).a().a().a(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqk
 * JD-Core Version:    0.7.0.1
 */