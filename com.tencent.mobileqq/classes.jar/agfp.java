import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader.IPreDownloadStrategy;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams.Params;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class agfp
  implements PTTPreDownloader.IPreDownloadStrategy, Runnable
{
  private agfq jdField_a_of_type_Agfq = new agfq(1);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private agfq b = new agfq(3);
  private agfq c = new agfq(2);
  
  public agfp(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private long a(MessageForPtt paramMessageForPtt)
  {
    long l2 = 4096L;
    long l1 = paramMessageForPtt.fileSize;
    if (l1 <= 0L)
    {
      if (paramMessageForPtt.voiceType == 1) {
        if (paramMessageForPtt.voiceLength <= 0) {
          l1 = 10240L;
        }
      }
      do
      {
        do
        {
          return l1;
          return paramMessageForPtt.voiceLength * 1200;
          l1 = l2;
        } while (paramMessageForPtt.voiceType != 0);
        l1 = l2;
      } while (paramMessageForPtt.voiceLength <= 0);
      return paramMessageForPtt.voiceLength * 700;
    }
    return l1;
  }
  
  private void a(agfq paramagfq)
  {
    long l2;
    if (paramagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int == -2147483648)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PTTPreDownloader", 4, "initStrategyInfoIfNeccessary");
      }
      Date localDate = new Date();
      Object localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      PreDownloadParams.Params localParams1 = PreDownloadParams.a((QQAppInterface)localObject1, paramagfq.jdField_a_of_type_Int);
      paramagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int = localParams1.jdField_a_of_type_Int;
      int i;
      if (paramagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int > 0)
      {
        PreDownloadParams.Params localParams2 = new PreDownloadParams.Params();
        localObject1 = PreDownloadParams.a((QQAppInterface)localObject1, paramagfq.jdField_a_of_type_Int, localParams2);
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd").format(localDate);
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "PreTime:" + (String)localObject1 + " curTime:" + (String)localObject2);
        }
        if (((String)localObject2).equals(localObject1))
        {
          i = 0;
          while (i <= 5)
          {
            paramagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams2.jdField_a_of_type_ArrayOfInt[i];
            i += 1;
          }
        }
        i = 0;
        int j = 0;
        if (localParams2.jdField_a_of_type_Int > -1)
        {
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localParams2.jdField_a_of_type_Int);
          i = j;
          while (i <= 5)
          {
            ((StringBuilder)localObject2).append('#').append(i).append('_').append(localParams2.jdField_a_of_type_ArrayOfInt[i]);
            i += 1;
          }
          ((HashMap)localObject1).put("RemainCfg", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "PttPreDownloadDailyRemain", true, 0L, 0L, (HashMap)localObject1, "");
          i = 0;
        }
        while (i <= 5)
        {
          paramagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams1.jdField_a_of_type_ArrayOfInt[i];
          i += 1;
        }
      }
      b(paramagfq);
      if (!this.jdField_a_of_type_Boolean)
      {
        l1 = localDate.getTime();
        i = localDate.getHours();
        localDate.setHours(0);
        localDate.setMinutes(0);
        localDate.setSeconds(0);
        l2 = localDate.getTime();
        if (i >= 0) {
          break label494;
        }
      }
    }
    label494:
    for (long l1 = 0L - (l1 - l2);; l1 = 86400000L - (l1 - l2))
    {
      if (QLog.isDevelopLevel())
      {
        l2 = l1 / 1000L;
        QLog.d("PTTPreDownloader", 4, "Next reset time offset:" + l2 / 60L + ":" + l2 % 60L);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, l1);
      return;
    }
  }
  
  private void b(agfq paramagfq)
  {
    paramagfq = paramagfq.jdField_a_of_type_Int + ":" + paramagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params;
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, paramagfq);
    }
  }
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "save");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      if (this.jdField_a_of_type_Agfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != -2147483648)
      {
        PreDownloadParams.a(localQQAppInterface, this.jdField_a_of_type_Agfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.jdField_a_of_type_Agfq.jdField_a_of_type_Int);
        b(this.jdField_a_of_type_Agfq);
        localHashMap.put("C2CDownload", String.valueOf(this.jdField_a_of_type_Agfq.b));
        localHashMap.put("C2CView", String.valueOf(this.jdField_a_of_type_Agfq.d));
        localHashMap.put("C2CCancel", String.valueOf(this.jdField_a_of_type_Agfq.e));
        localHashMap.put("C2CEscape", String.valueOf(this.jdField_a_of_type_Agfq.c));
      }
      if (this.b.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != -2147483648)
      {
        PreDownloadParams.a(localQQAppInterface, this.b.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.b.jdField_a_of_type_Int);
        b(this.b);
        b(this.jdField_a_of_type_Agfq);
        localHashMap.put("GroupDownload", String.valueOf(this.b.b));
        localHashMap.put("GroupView", String.valueOf(this.b.d));
        localHashMap.put("GroupCancel", String.valueOf(this.b.e));
        localHashMap.put("GroupEscape", String.valueOf(this.b.c));
      }
      if (this.c.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int != -2147483648)
      {
        PreDownloadParams.a(localQQAppInterface, this.c.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params, this.c.jdField_a_of_type_Int);
        b(this.c);
        localHashMap.put("DiscussDownload", String.valueOf(this.c.b));
        localHashMap.put("DiscussView", String.valueOf(this.c.d));
        localHashMap.put("DiscussCancel", String.valueOf(this.c.e));
        localHashMap.put("DiscussEscape", String.valueOf(this.c.c));
      }
    } while (localHashMap.size() <= 0);
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "PttPreDownloadPV", true, 0L, 0L, localHashMap, "");
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "onDestroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramMessageForPtt.istroop == 0) {}
    label393:
    for (agfq localagfq = this.jdField_a_of_type_Agfq;; localagfq = null)
    {
      long l2;
      int i;
      if (localagfq != null)
      {
        l2 = 0L;
        i = NetworkCenter.a().a();
      }
      for (;;)
      {
        long l3;
        try
        {
          a(localagfq);
          if (localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int <= 0)
          {
            l1 = l2;
            bool1 = bool3;
            bool2 = bool1;
            if (QLog.isDevelopLevel())
            {
              QLog.d("PTTPreDownloader", 4, "canDownload:" + bool1 + " sesion:" + localagfq.jdField_a_of_type_Int + " net:" + i + " " + l1 + " - " + paramMessageForPtt.estimatedSize + " = " + localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] + ", pttSize:" + paramMessageForPtt.fileSize);
              bool2 = bool1;
            }
            return bool2;
            if (paramMessageForPtt.istroop == 1)
            {
              localagfq = this.b;
              break;
            }
            if (paramMessageForPtt.istroop != 3000) {
              break label393;
            }
            localagfq = this.c;
            break;
          }
          l3 = paramMessageForPtt.msgRecTime - paramMessageForPtt.msgTime;
          bool1 = bool3;
          l1 = l2;
          if (l3 < -10000L) {
            continue;
          }
          bool1 = bool3;
          l1 = l2;
          if (l3 > localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_Int * 24 * 60 * 60 * 100) {
            continue;
          }
          l3 = a(paramMessageForPtt);
          if (l3 > localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i])
          {
            localagfq.c += 1;
            bool1 = bool3;
            l1 = l2;
            continue;
          }
          localagfq.b += 1;
        }
        finally {}
        paramMessageForPtt.estimatedSize = l3;
        long l1 = localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
        int[] arrayOfInt = localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt;
        arrayOfInt[i] = ((int)(arrayOfInt[i] - l3));
        boolean bool1 = true;
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 2) {
      return true;
    }
    if (paramMessageForPtt.istroop == 0) {}
    label389:
    for (agfq localagfq = this.jdField_a_of_type_Agfq;; localagfq = null)
    {
      boolean bool1 = bool2;
      int i;
      if (localagfq != null)
      {
        if ((paramMessageForPtt.extFlag & 1L) <= 0L) {
          break label289;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label336;
        }
        i = NetworkCenter.a().a();
      }
      for (;;)
      {
        try
        {
          a(localagfq);
          long l1 = localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
          long l2 = paramMessageForPtt.fileSize + l1;
          PreDownloadParams.Params localParams = PreDownloadParams.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localagfq.jdField_a_of_type_Int);
          if (l2 > localParams.jdField_a_of_type_ArrayOfInt[i])
          {
            localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = localParams.jdField_a_of_type_ArrayOfInt[i];
            if (paramInt != 1) {
              break label316;
            }
            localagfq.d += 1;
            if (QLog.isDevelopLevel()) {
              QLog.d("PTTPreDownloader", 4, "consume sesion:" + localagfq.jdField_a_of_type_Int + " netType:" + i + ", " + l1 + " + " + paramMessageForPtt.fileSize + " = " + localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i]);
            }
            bool1 = true;
            return bool1;
            if (paramMessageForPtt.istroop == 1)
            {
              localagfq = this.b;
              break;
            }
            if (paramMessageForPtt.istroop != 3000) {
              break label389;
            }
            localagfq = this.c;
            break;
            label289:
            i = 0;
            break label45;
          }
          localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] = ((int)l2);
          continue;
          if (paramInt != 3) {
            continue;
          }
        }
        finally {}
        label316:
        localagfq.e += 1;
        continue;
        label336:
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("PTTPreDownloader", 4, "consume sesion:" + localagfq.jdField_a_of_type_Int + " not preDownload");
          bool1 = bool2;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Agfq = new agfq(1);
    this.b = new agfq(3);
    this.c = new agfq(2);
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (paramMessageForPtt.estimatedSize <= 0L) {
      return false;
    }
    agfq localagfq = null;
    int i;
    if (paramMessageForPtt.istroop == 0)
    {
      localagfq = this.jdField_a_of_type_Agfq;
      if (localagfq == null) {
        break label266;
      }
      i = NetworkCenter.a().a();
    }
    for (;;)
    {
      try
      {
        long l1 = localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i];
        localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] += (int)(paramMessageForPtt.estimatedSize - paramMessageForPtt.fileSize);
        long l2 = paramMessageForPtt.estimatedSize;
        paramMessageForPtt.estimatedSize = 0L;
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("PTTPreDownloader", 4, "fixEstimatedSize sesion:" + localagfq.jdField_a_of_type_Int + " net:" + i + ", " + l1 + " + " + l2 + " - " + paramMessageForPtt.fileSize + " = " + localagfq.jdField_a_of_type_ComTencentMobileqqPttPreopPreDownloadParams$Params.jdField_a_of_type_ArrayOfInt[i] + ", PttSize:" + paramMessageForPtt.fileSize);
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      if (paramMessageForPtt.istroop == 1)
      {
        localagfq = this.b;
        break;
      }
      if (paramMessageForPtt.istroop != 3000) {
        break;
      }
      localagfq = this.c;
      break;
      label266:
      boolean bool1 = false;
    }
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "reset");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agfp
 * JD-Core Version:    0.7.0.1
 */