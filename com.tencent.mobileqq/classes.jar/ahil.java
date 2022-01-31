import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class ahil
  extends Handler
{
  ahil(ahik paramahik, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    Object localObject4 = (Object[])???.obj;
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "reportThread. handleMessage msg.arg1=" + ???.arg1);
    }
    Object localObject5;
    ReportInfo localReportInfo;
    long l;
    switch (???.arg1)
    {
    default: 
      return;
    case 1: 
      synchronized (ahik.a())
      {
        ReportHeader localReportHeader = (ReportHeader)localObject4[1];
        if ((ReportInfo)ahik.a(this.a).get(Long.valueOf(localReportHeader.seqno)) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "start report. seqno=" + localReportHeader.seqno + " is exist ignore...");
          }
          return;
        }
      }
      localObject5 = (ReportItem)localObject4[2];
      localObject4 = (String)localObject4[0];
      localReportInfo = new ReportInfo();
      localReportInfo.header = localObject1;
      localReportInfo.body = new ReportBody();
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localReportInfo.header.sKey = ((String)localObject4);
        localReportInfo.body.sKey = ((String)localObject4);
      }
      localReportInfo.body.reportItems = new ArrayList(16);
      localReportInfo.body.startTime = localObject1.startTime;
      if (localObject5 != null)
      {
        localReportInfo.body.reportItems.add(localObject5);
        ((ReportItem)localObject5).seqno = localObject1.seqno;
        ahik.a(this.a).add(localObject5);
      }
      ahik.a(this.a).put(Long.valueOf(localObject1.seqno), localReportInfo);
      ahik.b(this.a).add(localObject1);
      ahik.a().notify();
      return;
    case 2: 
      for (;;)
      {
        synchronized (ahik.a())
        {
          l = ((Long)localObject4[0]).longValue();
          ??? = (ReportItem)localObject4[2];
          localObject5 = (ReportInfo)ahik.a(this.a).get(Long.valueOf(l));
          if (localObject5 != null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder().append("addReportItem. seqno=").append(l).append(" is illegal, step:");
            if (??? != null)
            {
              ??? = ???.step;
              QLog.d("VACDReport", 2, ???);
            }
          }
          else
          {
            return;
          }
        }
        ??? = ".";
      }
      if ((((ReportInfo)localObject5).header == null) || (((ReportInfo)localObject5).body == null))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("addReportItem. seqno=").append(l).append(" is illegal, step:");
          if (??? == null) {
            break label1584;
          }
          ??? = ???.step;
          QLog.d("VACDReport", 2, ???);
        }
      }
      else
      {
        if (((ReportInfo)localObject5).body.reportItems == null) {
          ((ReportInfo)localObject5).body.reportItems = new ArrayList();
        }
        ((ReportInfo)localObject5).body.reportItems.add(???);
        localObject4 = (String)localObject4[1];
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          ((ReportInfo)localObject5).header.sKey = ((String)localObject4);
          ((ReportInfo)localObject5).body.sKey = ((String)localObject4);
        }
        ???.seqno = ((ReportInfo)localObject5).header.seqno;
        ahik.a(this.a).add(???);
        ahik.a().notify();
        return;
      }
      break;
    case 3: 
      for (;;)
      {
        synchronized (ahik.a())
        {
          l = ((Long)localObject4[0]).longValue();
          ??? = (ReportItem)localObject4[1];
          localObject4 = (ReportInfo)ahik.a(this.a).get(Long.valueOf(l));
          if (localObject4 != null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder().append("end report. seqno=").append(l).append(" is illegal, step:");
            if (??? != null)
            {
              ??? = ???.step;
              QLog.d("VACDReport", 2, ???);
            }
          }
          else
          {
            return;
          }
        }
        ??? = ".";
      }
      if ((((ReportInfo)localObject4).header == null) || (((ReportInfo)localObject4).body == null))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("end report. seqno=").append(l).append(" is illegal, step:");
          if (??? == null) {
            break label1590;
          }
          ??? = ???.step;
          QLog.d("VACDReport", 2, ???);
        }
      }
      else
      {
        if (((ReportInfo)localObject4).body.reportItems == null) {
          ((ReportInfo)localObject4).body.reportItems = new ArrayList();
        }
        ((ReportInfo)localObject4).body.reportItems.add(???);
        ???.seqno = ((ReportInfo)localObject4).header.seqno;
        ???.isNormalEnd = true;
        ahik.a(this.a).add(???);
        ahik.b(this.a, 5);
        localObject4 = ahik.b(this.a).obtainMessage();
        if (localObject4 != null)
        {
          ((Message)localObject4).arg1 = 5;
          ((Message)localObject4).obj = new Object[] { Long.valueOf(l), ??? };
          ahik.b(this.a).sendMessageDelayed((Message)localObject4, 10000L);
        }
        return;
      }
      break;
    case 5: 
      for (;;)
      {
        label848:
        synchronized (ahik.a())
        {
          l = ((Long)localObject4[0]).longValue();
          ??? = (ReportItem)localObject4[1];
          localObject4 = (ReportInfo)ahik.a(this.a).get(Long.valueOf(l));
          if (localObject4 != null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder().append("send report. seqno=").append(l).append(" is illegal, step:");
            if (??? != null)
            {
              ??? = ???.step;
              QLog.d("VACDReport", 2, ???);
            }
          }
          else
          {
            return;
          }
        }
        ??? = ".";
      }
      if ((((ReportInfo)localObject4).header == null) || (((ReportInfo)localObject4).body == null)) {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("send report. seqno=").append(l).append(" is illegal, step:");
          if (??? == null) {
            break label1596;
          }
        }
      }
      break;
    }
    label1584:
    label1590:
    label1596:
    for (??? = ???.step;; ??? = ".")
    {
      QLog.d("VACDReport", 2, ???);
      return;
      if (((ReportInfo)localObject4).body.reportItems == null) {
        ((ReportInfo)localObject4).body.reportItems = new ArrayList();
      }
      ((ReportInfo)localObject4).header.totalTime = Math.abs(???.createTime - ((ReportInfo)localObject4).header.createTime);
      ((ReportInfo)localObject4).body.totalTime = ((ReportInfo)localObject4).header.totalTime;
      ahik.a(this.a, 0);
      return;
      synchronized (ahik.a())
      {
        ??? = (ReportHeader)localObject4[1];
        if ((ReportInfo)ahik.a(this.a).get(Long.valueOf(((ReportHeader)???).seqno)) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "single report seqno=" + ((ReportHeader)???).seqno + " is exist ignore...");
          }
          return;
        }
      }
      localObject5 = (ReportItem)localObject4[2];
      localObject4 = (String)localObject4[0];
      localReportInfo = new ReportInfo();
      localReportInfo.header = localObject3;
      localReportInfo.header.sKey = ((String)localObject4);
      localReportInfo.header.totalTime = 0L;
      localReportInfo.body = new ReportBody();
      localReportInfo.body.reportItems = new ArrayList(16);
      localReportInfo.body.sKey = ((String)localObject4);
      localReportInfo.body.startTime = localObject3.startTime;
      localReportInfo.body.totalTime = localReportInfo.header.totalTime;
      ((ReportItem)localObject5).seqno = localReportInfo.header.seqno;
      ((ReportItem)localObject5).isNormalEnd = true;
      localReportInfo.body.reportItems.add(localObject5);
      ahik.a(this.a).put(Long.valueOf(localObject3.seqno), localReportInfo);
      ahik.b(this.a).add(localObject3);
      ahik.a(this.a).add(localObject5);
      ahik.a(this.a, 1);
      return;
      ??? = ".";
      break;
      ??? = ".";
      break label848;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahil
 * JD-Core Version:    0.7.0.1
 */