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

public class aivu
{
  private List<WeakReference<aivy>> a = new ArrayList();
  
  public aivy a()
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      aivy localaivy;
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
          localaivy = (aivy)localWeakReference.get();
          if (localaivy == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localaivy instanceof View)) && (((View)localaivy).getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localaivy);
        }
        Object localObject2 = localaivy;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localaivy;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localaivy;; localObject2 = null)
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
  
  public aivy a(int paramInt)
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      aivy localaivy;
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
          localaivy = (aivy)localWeakReference.get();
          if (localaivy == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localaivy instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localaivy).getGameId() == paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localaivy);
        }
        Object localObject2 = localaivy;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localaivy;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localaivy;; localObject2 = null)
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
  
  public aivy a(long paramLong)
  {
    ArrayList localArrayList;
    aivy localaivy;
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
        localaivy = (aivy)localWeakReference.get();
      }
      finally {}
      if (localaivy == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localaivy.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext getRuntimeState:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext find getRuntimeState:" + l);
          }
          localObject2 = localaivy;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localaivy;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localaivy;; localObject2 = null)
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
  
  public void a(aivy paramaivy)
  {
    if (paramaivy == null) {}
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
            if ((localWeakReference != null) && (paramaivy == localWeakReference.get()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "addRunner has add the same iRenderRunner:" + paramaivy);
              break;
            }
          }
        }
      }
      finally {}
      this.a.add(new WeakReference(paramaivy));
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "addRunner iRenderRunner:" + paramaivy + ", size: " + this.a);
      }
    }
  }
  
  public void a(aivy paramaivy, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_JsRenderRunner", 2, "exeJsOnEngine, renderRunner:" + paramaivy + ",jsStr:" + paramString);
    }
    if ((paramaivy != null) && (!TextUtils.isEmpty(paramString))) {
      paramaivy.exeJsOnEngine(paramString);
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
        localaivy = (aivy)localWeakReference.get();
      }
      finally {}
      aivy localaivy;
      if (localaivy == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localaivy.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine getRuntimeState runtimeState:" + l);
        }
        if (paramLong == localaivy.getRuntimeState())
        {
          localaivy.runRenderTask(new ApolloRenderRunner.1(this, localaivy, paramLong, paramApolloCmdChannel, paramInt, paramString1, paramString2));
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
          QLog.d("apollochannel_JsRenderRunner", 2, "lState != apolloSurfaceView.getRuntimeState(), renderThreadId:" + localaivy.getRuntimeState());
        }
      }
    }
  }
  
  public aivy b(long paramLong)
  {
    ArrayList localArrayList;
    aivy localaivy;
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
        localaivy = (aivy)localWeakReference.get();
      }
      finally {}
      if (localaivy == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localaivy.getRenderThreadId();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId getRenderThreadId:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId find getRenderThreadId:" + l);
          }
          localObject2 = localaivy;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localaivy;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localaivy;; localObject2 = null)
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
  
  public void b(aivy paramaivy)
  {
    if (paramaivy == null) {}
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
            if ((localWeakReference != null) && (paramaivy == localWeakReference.get()))
            {
              localIterator.remove();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner find it:" + paramaivy);
              break;
            }
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner not find it:" + paramaivy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivu
 * JD-Core Version:    0.7.0.1
 */