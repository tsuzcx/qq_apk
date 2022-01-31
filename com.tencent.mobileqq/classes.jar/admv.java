import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class admv
  extends ProtoUtils.AppProtocolObserver
{
  public admv(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      NearbySPUtil.b(this.a.getCurrentAccountUin(), false);
    }
    for (boolean bool1 = false;; bool1 = NearbySPUtil.b(this.a.getCurrentAccountUin()))
    {
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("param_reason", String.valueOf(paramInt));
      paramBundle = StatisticCollector.a(BaseApplicationImpl.getContext());
      String str = this.a.getCurrentAccountUin();
      if (paramInt == 0) {
        bool2 = true;
      }
      paramBundle.a(str, "oidb_0x91f", bool2, 0L, 0L, paramArrayOfByte, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "oidb_0x91f| visible:" + bool1 + "replyCode:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admv
 * JD-Core Version:    0.7.0.1
 */