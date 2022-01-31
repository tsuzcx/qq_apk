import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import com.tencent.qphone.base.util.QLog;

public class ahsr
  extends ahsm
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 300000L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 1800000L;
  private long c = 3600000L;
  private long d = 300000L;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  
  public ahsr(BatteryStatsImpl paramBatteryStatsImpl, String paramString)
  {
    super(paramBatteryStatsImpl, paramString);
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 3))
    {
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue() * 60 * 1000L);
      this.jdField_b_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][1]).intValue() * 60 * 1000L);
      this.c = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][2]).intValue() * 60 * 1000L);
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 2) && (this.jdField_a_of_type_Array2dOfJavaLangString[1].length >= 1))
    {
      this.d = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][0]).intValue() * 60 * 1000L);
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][1]).intValue();
    }
  }
  
  public void a()
  {
    super.a();
    if (BatteryStatsImpl.a()) {}
    try
    {
      this.jdField_b_of_type_Int = BaseApplicationImpl.getApplication().getPackageManager().getApplicationInfo("com.tencent.mobileqq", 128).uid;
      if (this.jdField_b_of_type_Int != 0)
      {
        this.e = TrafficStats.getUidRxBytes(this.jdField_b_of_type_Int);
        this.f = TrafficStats.getUidTxBytes(this.jdField_b_of_type_Int);
        this.g = TrafficStats.getTotalRxBytes();
        this.h = TrafficStats.getTotalTxBytes();
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_Long);
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.jdField_b_of_type_Long));
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_b_of_type_Long);
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.c));
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.c);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BatteryStats", 1, "", localThrowable);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if ((BatteryStatsImpl.a()) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Int > 0))
    {
      this.m = System.currentTimeMillis();
      this.i = TrafficStats.getUidRxBytes(this.jdField_b_of_type_Int);
      this.j = TrafficStats.getUidTxBytes(this.jdField_b_of_type_Int);
      this.k = TrafficStats.getTotalRxBytes();
      this.l = TrafficStats.getTotalTxBytes();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, this.d);
    }
  }
  
  public void c()
  {
    super.c();
    if (BatteryStatsImpl.a()) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return false;
    }
    long l1;
    long l2;
    long l3;
    long l4;
    int n;
    if (paramMessage.what == 0)
    {
      l1 = TrafficStats.getUidRxBytes(this.jdField_b_of_type_Int) - this.e;
      l2 = TrafficStats.getUidTxBytes(this.jdField_b_of_type_Int) - this.f;
      l3 = TrafficStats.getTotalRxBytes() - this.g;
      l4 = TrafficStats.getTotalTxBytes() - this.h;
      n = (int)(((Long)paramMessage.obj).longValue() / 1000L);
      paramMessage = new StringBuilder(50);
      paramMessage.append("on startup ").append(n);
      paramMessage.append("secs, network:");
      paramMessage.append(l1 / 1000L).append("/").append(l3 / 1000L).append("|");
      paramMessage.append(l2 / 1000L).append("/").append(l4 / 1000L);
      BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, paramMessage.toString());
      BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "nt|fg|", String.valueOf(n), "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
      if (n == 1800) {
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "fg30Trf", "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
      }
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 3)
      {
        this.jdField_a_of_type_Int -= 1;
        if (System.currentTimeMillis() - this.m < this.d + 2000L)
        {
          l1 = TrafficStats.getUidRxBytes(this.jdField_b_of_type_Int) - this.i;
          l2 = TrafficStats.getUidTxBytes(this.jdField_b_of_type_Int) - this.j;
          l3 = TrafficStats.getTotalRxBytes() - this.k;
          l4 = TrafficStats.getTotalTxBytes() - this.l;
          n = (int)(this.d / 1000L);
          paramMessage = new StringBuilder(50);
          paramMessage.append("onBG").append(n).append("secs, network:");
          paramMessage.append(l1 / 1000L).append("/").append(l3 / 1000L).append("|");
          paramMessage.append(l2 / 1000L).append("/").append(l4 / 1000L);
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, paramMessage.toString());
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "nt|bg|", String.valueOf(n), "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
          if (n == 300) {
            BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "bg5Trf", "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahsr
 * JD-Core Version:    0.7.0.1
 */