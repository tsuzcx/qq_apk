import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class aclq
  extends bajm
{
  public aclq(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        new structmsg.StructMsg().mergeFrom(paramBundle);
        TroopRequestActivity.a(this.a, 1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.TroopRequestActivity", 2, "structMsg merge error");
        }
        this.a.i();
        bcql.a(this.a, this.a.getString(2131697634), 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    this.a.i();
    bcql.a(this.a, this.a.getString(2131697634), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclq
 * JD-Core Version:    0.7.0.1
 */