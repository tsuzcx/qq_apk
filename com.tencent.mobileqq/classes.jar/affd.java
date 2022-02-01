import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.20;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.RspBody;

public class affd
  extends ntf
{
  public affd(TroopMemberListActivity.20 param20) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = new oidb_cmd0x74f.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          if ((paramBundle.uint32_ret_code.get() == 0) && (paramBundle.bool_display_entrance.get()))
          {
            TroopMemberListActivity.a(this.a.this$0, paramBundle.range.get());
            TroopMemberListActivity.c(this.a.this$0);
            TroopMemberListActivity.a(this.a.this$0, paramBundle.uint64_next_pull_time.get());
            return;
          }
        }
        catch (Exception paramArrayOfByte) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberListActivityget_troop_member", 2, "initListView, get0x74f：failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affd
 * JD-Core Version:    0.7.0.1
 */