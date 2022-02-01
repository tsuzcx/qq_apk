import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class aier
  extends apas
{
  boolean jdField_a_of_type_Boolean;
  
  aier(aido paramaido) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Aido.tag, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      olh.a(this.jdField_a_of_type_Aido.app, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_Aido.sessionInfo.curFriendUin, "", "", "", false);
      paramObject = (aoan)this.jdField_a_of_type_Aido.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (paramObject == null) {
        break label262;
      }
      paramObject = paramObject.a(this.jdField_a_of_type_Aido.sessionInfo.curFriendUin);
      if (paramObject == null) {
        break label246;
      }
      if (this.jdField_a_of_type_Aido.a == null) {
        this.jdField_a_of_type_Aido.a = ((PublicAccountHandler)this.jdField_a_of_type_Aido.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      this.jdField_a_of_type_Aido.a.a(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aido.b = true;
      this.jdField_a_of_type_Aido.g = true;
      this.jdField_a_of_type_Aido.c();
      if (this.jdField_a_of_type_Aido.v)
      {
        paramObject = (PlusPanel)aido.a(this.jdField_a_of_type_Aido).a(8);
        if (paramObject != null) {
          paramObject.a();
        }
      }
      this.jdField_a_of_type_Aido.updateSession(this.jdField_a_of_type_Aido.mActivity.getIntent());
      return;
      label246:
      this.jdField_a_of_type_Aido.a();
      this.jdField_a_of_type_Boolean = false;
      continue;
      label262:
      this.jdField_a_of_type_Aido.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Aido.b(2131694983);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aido.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aier
 * JD-Core Version:    0.7.0.1
 */