import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class ahjl
  extends anxq
{
  ahjl(ahiu paramahiu, String paramString) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Ahiu.tag, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      ahiu.a(this.jdField_a_of_type_Ahiu, ahiu.a(this.jdField_a_of_type_Ahiu));
      odq.a(this.jdField_a_of_type_Ahiu.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_Ahiu.app, this.jdField_a_of_type_JavaLangString);
      ((bfas)this.jdField_a_of_type_Ahiu.app.getManager(132)).a(this.jdField_a_of_type_Ahiu.sessionInfo.curFriendUin);
      ahiu.b(this.jdField_a_of_type_Ahiu, false);
      if ((this.jdField_a_of_type_Ahiu.sessionInfo != null) && (this.jdField_a_of_type_Ahiu.sessionInfo.curFriendUin.equals(paramObject.appid.get() + ""))) {
        this.jdField_a_of_type_Ahiu.finish(1);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ahiu.updateSession(this.jdField_a_of_type_Ahiu.mActivity.getIntent());
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Ahiu.b(2131694775);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    ahiu.c(this.jdField_a_of_type_Ahiu);
    if (ahiu.d(this.jdField_a_of_type_Ahiu) == 0) {
      this.jdField_a_of_type_Ahiu.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjl
 * JD-Core Version:    0.7.0.1
 */