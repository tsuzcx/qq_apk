import android.util.SparseArray;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ahmb
  extends altm
{
  ahmb(ahma paramahma) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt);
    }
    if (paramBoolean)
    {
      QQToast.a(ahma.a(this.a), alud.a(2131707875), 0).a();
      ahma.a(this.a, paramLong);
      this.a.d();
      return;
    }
    QQToast.a(ahma.a(this.a), alud.a(2131707896), 0).a();
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
        ahma.a(this.a).put(paramInt, paramArrayOfByte);
      }
      if (paramArrayList != null) {
        ahma.a(this.a, ahma.a(this.a) + paramArrayList.size());
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
 * Qualified Name:     ahmb
 * JD-Core Version:    0.7.0.1
 */