import android.os.Handler;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.RspBody;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.arcard.ARCardObserver;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class aafv
  extends ARCardObserver
{
  public aafv(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void a(int paramInt, ARRelationShipListPb.RspBody paramRspBody)
  {
    boolean bool = false;
    ARGreetingCardListManager.a(this.a, false);
    if (paramInt == 0)
    {
      try
      {
        if ((ARGreetingCardListManager.b(this.a) == 0) && (ARGreetingCardListManager.c(this.a) == 0))
        {
          ARGreetingCardListManager.a(this.a, paramRspBody.uint32_total_send_count.get());
          ARGreetingCardListManager.b(this.a, paramRspBody.uint32_total_recv_count.get());
        }
        ARGreetingCardListManager.a(this.a, paramRspBody.bytes_rsp_page_cookies.get().toByteArray());
        ARGreetingCardListManager localARGreetingCardListManager = this.a;
        if (paramRspBody.uint32_is_end.get() == 1) {
          bool = true;
        }
        ARGreetingCardListManager.b(localARGreetingCardListManager, bool);
        QLog.d("ARGreetingCardListManager", 2, String.format("onGetARRelationShipList mTotalSendCount=%s mTotalReceiveCount=%s mRequestEnd=%s", new Object[] { Integer.valueOf(ARGreetingCardListManager.b(this.a)), Integer.valueOf(ARGreetingCardListManager.c(this.a)), Boolean.valueOf(ARGreetingCardListManager.b(this.a)) }));
        ARGreetingCardListManager.a(this.a, paramRspBody.rpt_send_recv_share_list);
      }
      catch (Exception paramRspBody)
      {
        for (;;)
        {
          QLog.d("ARGreetingCardListManager", 1, "onGetARRelationShipList fail.", paramRspBody);
        }
      }
      if ((ARGreetingCardListManager.a(this.a) != null) && (ARGreetingCardListManager.a(this.a) != null) && (ARGreetingCardListManager.a(this.a).isResume()))
      {
        ARGreetingCardListManager.a(this.a).a(ARGreetingCardListManager.a(this.a));
        ARGreetingCardListManager.a(this.a).a.sendEmptyMessage(307);
      }
    }
    do
    {
      do
      {
        return;
        QLog.e("ARGreetingCardListManager", 1, String.format("onGetARRelationShipList fail! retCode=0x%X", new Object[] { Integer.valueOf(paramInt) }));
      } while ((ARGreetingCardListManager.a(this.a) == null) || (ARGreetingCardListManager.a(this.a) == null) || (!ARGreetingCardListManager.a(this.a).isResume()));
      if (ARGreetingCardListManager.d(this.a) == 0)
      {
        ARGreetingCardListManager.a(this.a).a(false, ARGreetingCardListManager.a(this.a));
        return;
      }
    } while (ARGreetingCardListManager.d(this.a) != 1);
    ARGreetingCardListManager.a(this.a).c(false, ARGreetingCardListManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafv
 * JD-Core Version:    0.7.0.1
 */