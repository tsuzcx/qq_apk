import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloQueueDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class aige
  implements batr, INetInfoHandler
{
  private batq jdField_a_of_type_Batq;
  private LinkedList<batm> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public aige(AppRuntime paramAppRuntime, batq parambatq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    batq localbatq = parambatq;
    if (parambatq == null) {
      localbatq = new batq();
    }
    this.jdField_a_of_type_Batq = localbatq;
    if (this.jdField_a_of_type_Batq.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private batm a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          batm localbatm = (batm)localIterator.next();
          if (!localbatm.a())
          {
            localbatm.a();
            return localbatm;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    Object localObject;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label115;
      }
      if (!paramBoolean) {
        break label119;
      }
      paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (paramString.hasNext())
      {
        localObject = (batm)paramString.next();
        ((batm)localObject).a(true);
        ((batm)localObject).i();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    for (;;)
    {
      label115:
      return 0;
      label119:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext())
      {
        batm localbatm = (batm)((Iterator)localObject).next();
        if (paramString.equals(localbatm.jdField_a_of_type_JavaLangString))
        {
          if (!localbatm.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbatm);
          }
          else
          {
            localbatm.a(true);
            localbatm.i();
          }
        }
        else if ((localbatm.b()) && (!localbatm.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbatm);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public batm a(String paramString)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          batm localbatm = (batm)localIterator.next();
          if (paramString.equals(localbatm.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task find =" + localbatm);
            }
            return localbatm;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          if (!localIterator.hasNext()) {
            break label185;
          }
          batm localbatm2 = (batm)localIterator.next();
          if (localbatm2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbatm2.a()) && (l > localbatm2.c + localbatm2.d))
          {
            bool = true;
            if ((!localbatm2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloQueue_Downloader", 2, "remove task[" + localbatm2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbatm2.b() + ", timeOut=" + bool);
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label185:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 3 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      for (;;)
      {
        batm localbatm1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbatm1 = a();
          if (localbatm1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloQueue_Downloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new ApolloQueueDownloader.1(this, localbatm1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(batm parambatm)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambatm != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambatm)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloQueue_Downloader", 2, "removeTask | task=" + parambatm);
        }
        parambatm.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambatm);
      }
      return;
    }
    finally {}
  }
  
  public void a(batm parambatm, batl arg2, Bundle paramBundle)
  {
    if ((!bato.a(parambatm)) || (a(parambatm.jdField_a_of_type_JavaLangString) == parambatm)) {}
    batm localbatm;
    do
    {
      return;
      localbatm = a(parambatm.jdField_a_of_type_JavaLangString);
      if (localbatm == null) {
        break;
      }
    } while ((localbatm == null) || (!localbatm.s));
    parambatm.a(???);
    parambatm.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambatm.jdField_a_of_type_Batn.a < 0L)) {
      parambatm.jdField_a_of_type_Batn.a = ???.getLongAccountUin();
    }
    localbatm.a(parambatm);
    return;
    parambatm.a(???);
    parambatm.a(paramBundle);
    parambatm.g = 3;
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambatm.jdField_a_of_type_Batn.a < 0L)) {
      parambatm.jdField_a_of_type_Batn.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambatm.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambatm.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambatm.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambatm);
            if ((parambatm.jdField_a_of_type_JavaUtilList != null) && (parambatm.jdField_a_of_type_JavaUtilList.size() != 0)) {
              break label328;
            }
            ??? = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, new Object[] { "startDownload | task=" + parambatm.jdField_a_of_type_JavaLangString, ", url:", ??? });
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambatm);
        }
      }
      if ((parambatm.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle)))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
        continue;
        label328:
        ??? = (String)parambatm.jdField_a_of_type_JavaUtilList.get(0);
      }
    }
  }
  
  public void b()
  {
    a(true, null);
  }
  
  public void onNetMobile2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          batm localbatm = (batm)localIterator.next();
          if (localbatm.a() == 2) {
            localbatm.h();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          batm localbatm = (batm)localIterator.next();
          if (localbatm.a() == 2) {
            localbatm.f();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          batm localbatm = (batm)localIterator.next();
          if (localbatm.a() == 2) {
            localbatm.g();
          }
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (localIterator.hasNext())
        {
          batm localbatm = (batm)localIterator.next();
          localStringBuilder.append("key=").append(localbatm.jdField_a_of_type_JavaLangString);
          if ((localbatm.jdField_a_of_type_JavaUtilList != null) && (localbatm.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbatm.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbatm.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aige
 * JD-Core Version:    0.7.0.1
 */