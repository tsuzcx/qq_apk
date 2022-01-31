import android.util.SparseArray;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class afkh
  extends ajxj
{
  afkh(afkg paramafkg) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt);
    }
    if (paramBoolean)
    {
      bcql.a(afkg.a(this.a), ajya.a(2131707491), 0).a();
      afkg.a(this.a, paramLong);
      this.a.d();
      return;
    }
    bcql.a(afkg.a(this.a), ajya.a(2131707512), 0).a();
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
        afkg.a(this.a).put(paramInt, paramArrayOfByte);
      }
      if (paramArrayList != null) {
        afkg.a(this.a, afkg.a(this.a) + paramArrayList.size());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkh
 * JD-Core Version:    0.7.0.1
 */