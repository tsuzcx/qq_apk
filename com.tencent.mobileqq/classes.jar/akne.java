import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akne
{
  private List<WeakReference<akni>> a = new ArrayList();
  
  public akni a()
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      akni localakni;
      try
      {
        i = this.a.size();
        localArrayList = new ArrayList();
        i -= 1;
        if (i < 0) {
          break label226;
        }
        WeakReference localWeakReference = (WeakReference)this.a.get(i);
        if (localWeakReference == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloViewWeakReference is null");
          }
        }
        else
        {
          localakni = (akni)localWeakReference.get();
          if (localakni == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localakni instanceof View)) && (((View)localakni).getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localakni);
        }
        Object localObject2 = localakni;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localakni;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localakni;; localObject2 = null)
        {
          return localObject2;
          label226:
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner not find");
          }
        }
      }
      i -= 1;
    }
  }
  
  public akni a(int paramInt)
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      akni localakni;
      try
      {
        i = this.a.size();
        localArrayList = new ArrayList();
        i -= 1;
        if (i < 0) {
          break label235;
        }
        WeakReference localWeakReference = (WeakReference)this.a.get(i);
        if (localWeakReference == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloViewWeakReference is null");
          }
        }
        else
        {
          localakni = (akni)localWeakReference.get();
          if (localakni == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localakni instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localakni).getGameId() == paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localakni);
        }
        Object localObject2 = localakni;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localakni;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localakni;; localObject2 = null)
        {
          return localObject2;
          label235:
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner not find");
          }
        }
      }
      i -= 1;
    }
  }
  
  public akni a(long paramLong)
  {
    ArrayList localArrayList;
    akni localakni;
    for (;;)
    {
      WeakReference localWeakReference;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label269;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloViewWeakReference is null");
          continue;
        }
        localakni = (akni)localWeakReference.get();
      }
      finally {}
      if (localakni == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localakni.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext getRuntimeState:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext find getRuntimeState:" + l);
          }
          localObject2 = localakni;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localakni;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localakni;; localObject2 = null)
    {
      return localObject2;
      label269:
      if (!localArrayList.isEmpty())
      {
        this.a.removeAll(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext not find");
      }
    }
  }
  
  public void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(akni paramakni)
  {
    if (paramakni == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramakni == localWeakReference.get()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "addRunner has add the same iRenderRunner:" + paramakni);
              break;
            }
          }
        }
      }
      finally {}
      this.a.add(new WeakReference(paramakni));
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "addRunner iRenderRunner:" + paramakni + ", size: " + this.a);
      }
    }
  }
  
  public void a(akni paramakni, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_JsRenderRunner", 2, "exeJsOnEngine, renderRunner:" + paramakni + ",jsStr:" + paramString);
    }
    if ((paramakni != null) && (!TextUtils.isEmpty(paramString))) {
      paramakni.exeJsOnEngine(paramString);
    }
  }
  
  public void a(ApolloCmdChannel paramApolloCmdChannel, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      WeakReference localWeakReference;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine cmd:" + paramString1 + ",respData:" + paramString2);
        }
        if (paramApolloCmdChannel == null) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label280;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloViewWeakReference is null");
          continue;
        }
        localakni = (akni)localWeakReference.get();
      }
      finally {}
      akni localakni;
      if (localakni == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localakni.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine getRuntimeState runtimeState:" + l);
        }
        if (paramLong == localakni.getRuntimeState())
        {
          localakni.runRenderTask(new ApolloRenderRunner.1(this, localakni, paramLong, paramApolloCmdChannel, paramInt, paramString1, paramString2));
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine getRenderRunner find runtimeState:" + l);
          }
          label280:
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "after mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("apollochannel_JsRenderRunner", 2, "lState != apolloSurfaceView.getRuntimeState(), renderThreadId:" + localakni.getRuntimeState());
        }
      }
    }
  }
  
  public akni b(long paramLong)
  {
    ArrayList localArrayList;
    akni localakni;
    for (;;)
    {
      WeakReference localWeakReference;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label269;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloViewWeakReference is null");
          continue;
        }
        localakni = (akni)localWeakReference.get();
      }
      finally {}
      if (localakni == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localakni.getRenderThreadId();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId getRenderThreadId:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId find getRenderThreadId:" + l);
          }
          localObject2 = localakni;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localakni;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localakni;; localObject2 = null)
    {
      return localObject2;
      label269:
      if (!localArrayList.isEmpty())
      {
        this.a.removeAll(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId not find");
      }
    }
  }
  
  public void b(akni paramakni)
  {
    if (paramakni == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramakni == localWeakReference.get()))
            {
              localIterator.remove();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner find it:" + paramakni);
              break;
            }
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner not find it:" + paramakni);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akne
 * JD-Core Version:    0.7.0.1
 */