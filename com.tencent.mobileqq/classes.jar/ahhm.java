import android.util.SparseArray;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ahhm
  extends alox
{
  ahhm(ahhl paramahhl) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt);
    }
    if (paramBoolean)
    {
      QQToast.a(ahhl.a(this.a), alpo.a(2131707863), 0).a();
      ahhl.a(this.a, paramLong);
      this.a.d();
      return;
    }
    QQToast.a(ahhl.a(this.a), alpo.a(2131707884), 0).a();
  }
  
  public void onSuspiciousDel(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousDel " + paramBoolean + " " + paramInt + " " + paramLong);
    }
    if (paramBoolean) {
      this.a.d();
    }
  }
  
  public void onSuspiciousGetList(boolean paramBoolean, int paramInt, ArrayList<SysSuspiciousMsg> paramArrayList, byte[] paramArrayOfByte, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousGetList " + paramBoolean + " " + paramInt + " " + paramObject);
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Integer))
      {
        paramInt = ((Integer)paramObject).intValue();
        ahhl.a(this.a).put(paramInt, paramArrayOfByte);
      }
      if (paramArrayList != null) {
        ahhl.a(this.a, ahhl.a(this.a) + paramArrayList.size());
      }
      this.a.d();
    }
  }
  
  public void onSuspiciousSendReadReport(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousSendReadReport " + paramBoolean + " " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhm
 * JD-Core Version:    0.7.0.1
 */