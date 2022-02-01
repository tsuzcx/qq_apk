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

public class aloq
  implements bgoj, INetInfoHandler
{
  private bgoi jdField_a_of_type_Bgoi;
  private LinkedList<bgoe> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public aloq(AppRuntime paramAppRuntime, bgoi parambgoi)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    bgoi localbgoi = parambgoi;
    if (parambgoi == null) {
      localbgoi = new bgoi();
    }
    this.jdField_a_of_type_Bgoi = localbgoi;
    if (this.jdField_a_of_type_Bgoi.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private bgoe a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bgoe localbgoe = (bgoe)localIterator.next();
          if (!localbgoe.a())
          {
            localbgoe.a();
            return localbgoe;
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
        localObject = (bgoe)paramString.next();
        ((bgoe)localObject).a(true);
        ((bgoe)localObject).i();
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
        bgoe localbgoe = (bgoe)((Iterator)localObject).next();
        if (paramString.equals(localbgoe.jdField_a_of_type_JavaLangString))
        {
          if (!localbgoe.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbgoe);
          }
          else
          {
            localbgoe.a(true);
            localbgoe.i();
          }
        }
        else if ((localbgoe.b()) && (!localbgoe.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbgoe);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public bgoe a(String paramString)
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
          bgoe localbgoe = (bgoe)localIterator.next();
          if (paramString.equals(localbgoe.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task find =" + localbgoe);
            }
            return localbgoe;
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
          bgoe localbgoe2 = (bgoe)localIterator.next();
          if (localbgoe2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbgoe2.a()) && (l > localbgoe2.c + localbgoe2.d))
          {
            bool = true;
            if ((!localbgoe2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloQueue_Downloader", 2, "remove task[" + localbgoe2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbgoe2.b() + ", timeOut=" + bool);
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
        bgoe localbgoe1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbgoe1 = a();
          if (localbgoe1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloQueue_Downloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new ApolloQueueDownloader.1(this, localbgoe1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(bgoe parambgoe)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambgoe != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambgoe)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloQueue_Downloader", 2, "removeTask | task=" + parambgoe);
        }
        parambgoe.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambgoe);
      }
      return;
    }
    finally {}
  }
  
  public void a(bgoe parambgoe, bgod arg2, Bundle paramBundle)
  {
    if ((!bgog.a(parambgoe)) || (a(parambgoe.jdField_a_of_type_JavaLangString) == parambgoe)) {}
    bgoe localbgoe;
    do
    {
      return;
      localbgoe = a(parambgoe.jdField_a_of_type_JavaLangString);
      if (localbgoe == null) {
        break;
      }
    } while ((localbgoe == null) || (!localbgoe.s));
    parambgoe.a(???);
    parambgoe.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambgoe.jdField_a_of_type_Bgof.a < 0L)) {
      parambgoe.jdField_a_of_type_Bgof.a = ???.getLongAccountUin();
    }
    localbgoe.a(parambgoe);
    return;
    parambgoe.a(???);
    parambgoe.a(paramBundle);
    parambgoe.g = 3;
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambgoe.jdField_a_of_type_Bgof.a < 0L)) {
      parambgoe.jdField_a_of_type_Bgof.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambgoe.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambgoe.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambgoe.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambgoe);
            if ((parambgoe.jdField_a_of_type_JavaUtilList != null) && (parambgoe.jdField_a_of_type_JavaUtilList.size() != 0)) {
              break label328;
            }
            ??? = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, new Object[] { "startDownload | task=" + parambgoe.jdField_a_of_type_JavaLangString, ", url:", ??? });
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambgoe);
        }
      }
      if ((parambgoe.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle)))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
        continue;
        label328:
        ??? = (String)parambgoe.jdField_a_of_type_JavaUtilList.get(0);
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
          bgoe localbgoe = (bgoe)localIterator.next();
          if (localbgoe.a() == 2) {
            localbgoe.h();
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
          bgoe localbgoe = (bgoe)localIterator.next();
          if (localbgoe.a() == 2) {
            localbgoe.f();
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
          bgoe localbgoe = (bgoe)localIterator.next();
          if (localbgoe.a() == 2) {
            localbgoe.g();
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
          bgoe localbgoe = (bgoe)localIterator.next();
          localStringBuilder.append("key=").append(localbgoe.jdField_a_of_type_JavaLangString);
          if ((localbgoe.jdField_a_of_type_JavaUtilList != null) && (localbgoe.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbgoe.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbgoe.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloq
 * JD-Core Version:    0.7.0.1
 */