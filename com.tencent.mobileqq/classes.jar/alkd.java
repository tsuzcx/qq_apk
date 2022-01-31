import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class alkd
  implements axrt
{
  alkd(alkc paramalkc) {}
  
  public void onResp(axsq arg1)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onResp reqUrl: resp is null: ");
      if (??? == null)
      {
        bool = true;
        QLog.i("Q.dynamicAvatar", 2, bool);
      }
    }
    else
    {
      if (??? != null) {
        break label51;
      }
    }
    label51:
    do
    {
      return;
      bool = false;
      break;
      localObject1 = ((axro)???.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString;
      int i = ???.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.c + ",errDesc:" + ???.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (alkc.a(this.a))
        {
          if (alkc.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = alkc.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (alke)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((alke)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      alkc.a(this.a).remove(localObject2);
    } while ((!badq.g(BaseApplicationImpl.getContext())) || (badq.h(BaseApplicationImpl.getContext())));
    alkc.a(this.a);
  }
  
  public void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    if ((!alkc.a(this.a).isEmpty()) && ((??? instanceof axro))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((axro)???).jdField_a_of_type_JavaLangString;
      synchronized (alkc.a(this.a))
      {
        if (!alkc.a(this.a).isEmpty())
        {
          Iterator localIterator = alkc.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((alke)localWeakReference.get()).a(str, i);
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkd
 * JD-Core Version:    0.7.0.1
 */