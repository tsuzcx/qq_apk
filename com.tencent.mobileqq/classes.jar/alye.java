import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class alye
{
  private int jdField_a_of_type_Int = -1;
  private CopyOnWriteArrayList<alyd> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public alyd a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      localObject = null;
    }
    alyd localalyd;
    do
    {
      return localObject;
      localalyd = b(paramInt);
      localObject = localalyd;
    } while (localalyd != null);
    Object localObject = new alyd(paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localObject);
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "[add] size of cycles:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    return localObject;
  }
  
  public alyd a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      alyd localalyd = (alyd)localIterator.next();
      if ((localalyd != null) && (localalyd.a() == paramInt1) && (localalyd.jdField_a_of_type_Int == paramInt2)) {
        return localalyd;
      }
    }
    return null;
  }
  
  public List<alyd> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      alyd localalyd = (alyd)localIterator.next();
      if (localalyd != null) {
        localalyd.a();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    if ((alvx.a(paramInt)) || (alvx.b(paramInt))) {}
    alyd localalyd;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null);
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 1)
      {
        QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "curGame:" + paramInt);
        this.jdField_a_of_type_Int = paramInt;
        return;
      }
      localalyd = b(paramInt);
    } while ((localalyd == null) || (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localalyd)));
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localalyd);
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "curGame:" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    int i = 0;
    Object localObject2 = b(paramInt1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramInt2 == 1)
      {
        localObject2 = a(paramInt1);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (paramStartCheckParam != null)
          {
            ((alyd)localObject2).jdField_a_of_type_Int = paramInt3;
            if (BaseActivity.sTopActivity == null) {
              break label133;
            }
            ((alyd)localObject2).a(BaseActivity.sTopActivity, paramStartCheckParam);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, "[handleActLifeCycle] rebuild game");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    if (paramInt2 == 1) {
      if (localObject1 != null)
      {
        if (localObject1.jdField_a_of_type_Int != 0) {
          break label144;
        }
        localObject1.jdField_a_of_type_Int = paramInt3;
        localObject2 = localObject1;
        label125:
        ((alyd)localObject2).a(paramInt1, paramInt2);
      }
    }
    label133:
    label144:
    do
    {
      do
      {
        return;
        QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "[handleActLifeCycle] context is null");
        break;
        localObject2 = localObject1;
        if (localObject1.jdField_a_of_type_Int == paramInt3) {
          break label125;
        }
        localObject1.a(paramInt1, 5);
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
        }
        QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "handleActLifeCycle remove last same gameId activity");
        localObject2 = new alyd(paramInt1);
        ((alyd)localObject2).jdField_a_of_type_Int = paramInt3;
        if ((BaseActivity.sTopActivity != null) && (paramStartCheckParam != null)) {
          ((alyd)localObject2).a(BaseActivity.sTopActivity, paramStartCheckParam);
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localObject2);
        QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "handleActLifeCycle [add] size of cycles:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        break label125;
        if (paramInt2 == 5)
        {
          paramStartCheckParam = a(paramInt1, paramInt3);
          if (paramStartCheckParam == null)
          {
            QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "findLifeCycleByActivityId not found ON_DESTROY");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, "findLifeCycleByActivityId found ON_DESTROY lifeCycle:" + paramStartCheckParam);
          }
          paramStartCheckParam.a(paramInt1, paramInt2);
          paramInt1 = i;
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
          {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramStartCheckParam);
            paramInt1 = i;
          }
          for (;;)
          {
            if (paramInt1 < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
            {
              paramStartCheckParam = (alyd)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt1);
              if ((!alvx.a(paramStartCheckParam.a())) && (!alvx.b(paramStartCheckParam.a())))
              {
                paramStartCheckParam.b();
                this.jdField_a_of_type_Int = paramStartCheckParam.a();
              }
            }
            else
            {
              QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "[remove], size of cycles:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
              return;
            }
            paramInt1 += 1;
          }
        }
      } while (localObject1 == null);
      localObject1.a(paramInt1, paramInt2);
    } while (paramInt2 != 2);
    a(paramInt1);
  }
  
  public alyd b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      alyd localalyd = (alyd)localIterator.next();
      if ((localalyd != null) && (localalyd.a() == paramInt)) {
        return localalyd;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alye
 * JD-Core Version:    0.7.0.1
 */