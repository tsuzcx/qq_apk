import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class ahjx
  extends anxq
{
  boolean jdField_a_of_type_Boolean;
  
  ahjx(ahiu paramahiu) {}
  
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
        QLog.d(this.jdField_a_of_type_Ahiu.tag, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      odq.a(this.jdField_a_of_type_Ahiu.app, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_Ahiu.sessionInfo.curFriendUin, "", "", "", false);
      paramObject = (amxz)this.jdField_a_of_type_Ahiu.app.getManager(56);
      if (paramObject == null) {
        break label260;
      }
      paramObject = paramObject.a(this.jdField_a_of_type_Ahiu.sessionInfo.curFriendUin);
      if (paramObject == null) {
        break label244;
      }
      if (this.jdField_a_of_type_Ahiu.a == null) {
        this.jdField_a_of_type_Ahiu.a = ((PublicAccountHandler)this.jdField_a_of_type_Ahiu.app.getBusinessHandler(11));
      }
      this.jdField_a_of_type_Ahiu.a.a(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahiu.b = true;
      this.jdField_a_of_type_Ahiu.g = true;
      this.jdField_a_of_type_Ahiu.c();
      if (this.jdField_a_of_type_Ahiu.v)
      {
        paramObject = (PlusPanel)ahiu.a(this.jdField_a_of_type_Ahiu).a(8);
        if (paramObject != null) {
          paramObject.c();
        }
      }
      this.jdField_a_of_type_Ahiu.updateSession(this.jdField_a_of_type_Ahiu.mActivity.getIntent());
      return;
      label244:
      this.jdField_a_of_type_Ahiu.a();
      this.jdField_a_of_type_Boolean = false;
      continue;
      label260:
      this.jdField_a_of_type_Ahiu.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Ahiu.b(2131694775);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Ahiu.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjx
 * JD-Core Version:    0.7.0.1
 */