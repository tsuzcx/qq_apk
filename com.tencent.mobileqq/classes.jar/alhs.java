import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import VACDReport.ReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.2;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.4;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class alhs
  implements Manager
{
  private static boolean jdField_a_of_type_Boolean;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  public final long a;
  private alhr jdField_a_of_type_Alhr = new alhr(BaseApplicationImpl.getApplication());
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ArrayList<ReportHeader> jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
  private Map<Long, ReportInfo> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap(8));
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new alhu(this);
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private ArrayList<ReportItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList(8);
  private Map<Long, Long> jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap(8));
  private boolean jdField_b_of_type_Boolean;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private HandlerThread jdField_c_of_type_AndroidOsHandlerThread;
  
  public alhs()
  {
    this.jdField_a_of_type_Long = 3600000L;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      new alhs().a(true);
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "writeCacheToDB, from=" + paramInt + ", headerSize=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ", itemSize=" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_Alhr.c(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_Alhr.b(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void a(List<ReportInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new StringBuffer();
        i = 0;
        if (i < paramList.size())
        {
          this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(((ReportInfo)paramList.get(i)).header.seqno), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          ((StringBuffer)localObject).append(((ReportInfo)paramList.get(i)).header.seqno);
          if (i < paramList.size() - 1) {
            ((StringBuffer)localObject).append('|');
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "sendReports, sendingSize=" + this.jdField_b_of_type_JavaUtilMap.size() + ", seqnoList=" + ((StringBuffer)localObject).toString());
          }
          localObject = new ReportReq();
          ((ReportReq)localObject).reports = new ArrayList(paramList);
          paramList = BaseApplicationImpl.getApplication().getRuntime();
          NewIntent localNewIntent = new NewIntent(paramList.getApplication(), alhv.class);
          localNewIntent.putExtra("req", (Serializable)localObject);
          localNewIntent.putExtra("cmd_type", 1);
          localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
          paramList.startServlet(localNewIntent);
          return;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 174	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   4: putfield 246	alhs:jdField_b_of_type_Long	J
    //   7: aload_0
    //   8: getfield 248	alhs:jdField_b_of_type_Boolean	Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: getstatic 28	alhs:jdField_b_of_type_ArrayOfByte	[B
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +28 -> 52
    //   27: ldc 98
    //   29: iconst_2
    //   30: new 100	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   37: ldc 250
    //   39: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_1
    //   43: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 248	alhs:jdField_b_of_type_Boolean	Z
    //   57: iconst_1
    //   58: putstatic 86	alhs:jdField_a_of_type_Boolean	Z
    //   61: new 255	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr$1
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 256	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr$1:<init>	(Lalhs;)V
    //   69: bipush 10
    //   71: aconst_null
    //   72: iconst_0
    //   73: invokestatic 262	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   76: iload_1
    //   77: ifne +11 -> 88
    //   80: aload_0
    //   81: invokespecial 264	alhs:d	()V
    //   84: aload_0
    //   85: invokespecial 266	alhs:c	()V
    //   88: aload_0
    //   89: iload_1
    //   90: invokespecial 268	alhs:b	(Z)V
    //   93: aload_2
    //   94: monitorexit
    //   95: return
    //   96: astore_3
    //   97: aload_2
    //   98: monitorexit
    //   99: aload_3
    //   100: athrow
    //   101: astore_3
    //   102: ldc 98
    //   104: iconst_1
    //   105: ldc_w 270
    //   108: aload_3
    //   109: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_0
    //   113: invokevirtual 277	alhs:onDestroy	()V
    //   116: goto -23 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	alhs
    //   0	119	1	paramBoolean	boolean
    //   96	4	3	localObject	Object
    //   101	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	52	96	finally
    //   52	76	96	finally
    //   80	88	96	finally
    //   88	93	96	finally
    //   93	95	96	finally
    //   97	99	96	finally
    //   102	116	96	finally
    //   21	52	101	java/lang/Throwable
    //   52	76	101	java/lang/Throwable
    //   80	88	101	java/lang/Throwable
    //   88	93	101	java/lang/Throwable
  }
  
  private boolean a(List<ReportInfo> paramList)
  {
    Object localObject;
    ReportInfo localReportInfo;
    ArrayList localArrayList;
    int i;
    label253:
    do
    {
      try
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break;
        }
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localReportInfo = (ReportInfo)localIterator.next();
          if ((localReportInfo != null) && (localReportInfo.body != null) && (localReportInfo.body.reportItems != null) && (!localReportInfo.body.reportItems.isEmpty()) && (localReportInfo.header != null) && (localReportInfo.header.totalTime >= 0L))
          {
            long l = localReportInfo.header.seqno;
            if (this.jdField_b_of_type_JavaUtilMap.containsKey(Long.valueOf(l)))
            {
              if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(l))).longValue()) > 35000L) {
                this.jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(l));
              }
            }
            else
            {
              if (paramList.size() > 10L) {
                return true;
              }
              paramList.add(localReportInfo);
              Collections.sort(localReportInfo.body.reportItems);
              localArrayList = localReportInfo.body.reportItems;
              localObject = null;
              i = 0;
              if (i >= localArrayList.size()) {
                break label316;
              }
              ReportItem localReportItem = (ReportItem)localArrayList.get(i);
              if (i == 0) {
                localReportItem.costTime = 0L;
              } else {
                localReportItem.costTime = (localReportItem.createTime - ((ReportItem)localObject).createTime);
              }
            }
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return false;
      if ((localObject != null) && (((ReportItem)localObject).result != 0)) {
        localReportInfo.header.result = ((ReportItem)localObject).result;
      }
    } while (localReportInfo.header.result != -1);
    label316:
    int j = 0;
    int k = localArrayList.size() - 2;
    for (;;)
    {
      boolean bool;
      if (k >= 0)
      {
        localObject = (ReportItem)localArrayList.get(k);
        if (localObject == null) {
          break label652;
        }
        i = j;
        if (!TextUtils.isEmpty(((ReportItem)localObject).step))
        {
          i = j;
          if (((ReportItem)localObject).step.equals("qpay_gate.cgi.end"))
          {
            bool = TextUtils.isEmpty(((ReportItem)localObject).params);
            i = j;
            if (bool) {}
          }
        }
        try
        {
          int m = ((ReportItem)localObject).params.indexOf("&cardtype=");
          i = j;
          if (m != -1)
          {
            i = "&cardtype=".length() + m;
            i = Integer.valueOf(((ReportItem)localObject).params.substring(i, i + 1)).intValue();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
        }
        j = i;
        if (((ReportItem)localObject).result == 0) {
          break label652;
        }
        j = i;
        if (((ReportItem)localObject).result == -1) {
          break label652;
        }
        localReportInfo.header.result = ((ReportItem)localObject).result;
        bool = false;
      }
      for (;;)
      {
        if ((bool) && (i > 0)) {
          localReportInfo.header.result = (i + 668900);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VACDReport", 2, "handleUserGiveUp seqno=" + localReportInfo.header.seqno + ",result:" + localReportInfo.header.result + ",isUserGiveUp" + bool);
        break;
        bool = true;
        i = j;
      }
      return false;
      i += 1;
      localObject = localException;
      break label253;
      label652:
      k -= 1;
    }
  }
  
  private void b()
  {
    a(false);
  }
  
  private void b(int paramInt)
  {
    a(paramInt);
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      boolean bool;
      do
      {
        ArrayList localArrayList = new ArrayList();
        bool = a(localArrayList);
        a(localArrayList);
      } while (bool);
    }
  }
  
  private void b(List<ReportHeader> paramList)
  {
    ThreadManager.post(new VACDReportMgr.6(this, paramList), 10, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    Handler localHandler;
    VACDReportMgr.2 local2;
    if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "TimeOutThread start. isOnlyCheckTimeoutOnQQStart=" + paramBoolean);
      }
      this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("QWalletReport_Check");
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      localHandler = this.jdField_b_of_type_AndroidOsHandler;
      local2 = new VACDReportMgr.2(this, paramBoolean);
      if (!paramBoolean) {
        break label113;
      }
    }
    label113:
    for (long l = 5000L;; l = 0L)
    {
      localHandler.postDelayed(local2, l);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_AndroidOsHandlerThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "ReportThread start.");
      }
      this.jdField_c_of_type_AndroidOsHandlerThread = new HandlerThread("QWalletReport_Report");
      this.jdField_c_of_type_AndroidOsHandlerThread.start();
      this.jdField_c_of_type_AndroidOsHandler = new alht(this, this.jdField_c_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "WriteDBThread start.");
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QWalletReport_WriteDB");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VACDReportMgr.4(this, new byte[0]), 2000L);
    }
  }
  
  public void a(long paramLong, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "endReport seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 3;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(long paramLong, String paramString, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "addReportItem seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 2;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "startReport header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          return;
          if (paramReportHeader.seqno > 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VACDReport", 2, "startReport header seqno=" + paramReportHeader.seqno + " is illegal!");
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 1;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramReportHeader.seqno > 0L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "singleReport header seqno=" + paramReportHeader.seqno + " is illegal!");
          return;
          if (paramReportItem != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("VACDReport", 2, "singleReport:item is null return");
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 4;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void onDestroy()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "VACDReportMgr destroy@" + hashCode());
      }
      this.jdField_b_of_type_Boolean = false;
      jdField_a_of_type_ArrayOfByte.notifyAll();
      if (this.jdField_c_of_type_AndroidOsHandler != null) {
        this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_c_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_c_of_type_AndroidOsHandlerThread.quit();
        this.jdField_c_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_b_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_b_of_type_AndroidOsHandlerThread.quit();
        this.jdField_b_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.clear();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhs
 * JD-Core Version:    0.7.0.1
 */