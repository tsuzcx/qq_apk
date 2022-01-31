import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidResp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class adxb
  implements BusinessObserver
{
  public adxb(Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "onReceive get_openid:" + paramBoolean);
    }
    if (this.a.isFinishing()) {
      return;
    }
    int[] arrayOfInt;
    int i;
    if (paramBoolean)
    {
      Object localObject = paramBundle.getByteArray("data");
      if (localObject != null)
      {
        paramBundle = new GetOpenidProto.GetOpenidResp();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
          if (paramBundle.retcode.get() != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UiApiPlugin", 2, "get_openid retcode:" + paramBundle.retcode.get());
            }
            this.a.setResult(-1, new Intent().putExtra("ret", 2).putExtra("errMsg", "server error, unexpected retcode"));
            this.a.finish();
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          this.a.setResult(-1, new Intent().putExtra("ret", 2).putExtra("errMsg", "server error, unexpected pbdata"));
          this.a.finish();
          return;
        }
        int j = paramBundle.list.size();
        localObject = new String[j];
        arrayOfInt = new int[j];
        i = 0;
        if (i < j)
        {
          GetOpenidProto.GetOpenidEntry localGetOpenidEntry = (GetOpenidProto.GetOpenidEntry)paramBundle.list.get(i);
          localObject[i] = localGetOpenidEntry.openid.get();
          paramInt = localGetOpenidEntry.type.get();
          if (paramInt != 0) {
            break label358;
          }
          paramInt = 1;
          break label343;
        }
        this.a.setResult(-1, new Intent().putExtra("ret", 0).putExtra("openids", (String[])localObject).putExtra("types", arrayOfInt));
        this.a.finish();
        return;
      }
    }
    this.a.setResult(-1, new Intent().putExtra("ret", 2));
    this.a.finish();
    return;
    for (;;)
    {
      label343:
      arrayOfInt[i] = paramInt;
      i += 1;
      break;
      label358:
      if (paramInt == 1) {
        paramInt = 4;
      } else if (paramInt == 2) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxb
 * JD-Core Version:    0.7.0.1
 */