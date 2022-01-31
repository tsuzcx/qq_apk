import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.qphone.base.util.QLog;

public class afji
  extends ajxl
{
  public afji(AddRequestSuspiciousMsgFragment paramAddRequestSuspiciousMsgFragment) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt + " " + paramLong);
    }
    if ((AddRequestSuspiciousMsgFragment.a(this.a) != null) && (AddRequestSuspiciousMsgFragment.a(this.a).uin == paramLong))
    {
      AddRequestSuspiciousMsgFragment.a(this.a);
      if (paramBoolean)
      {
        bcpw.a(this.a.getActivity(), ajyc.a(2131699866), 0).a();
        AddRequestSuspiciousMsgFragment.b(this.a);
        this.a.getActivity().finish();
      }
    }
    else
    {
      return;
    }
    bcpw.a(this.a.getActivity(), ajyc.a(2131699867), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afji
 * JD-Core Version:    0.7.0.1
 */