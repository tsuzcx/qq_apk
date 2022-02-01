import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class ajfn
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  Map<Class, ajib> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public ajfn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private <T extends ajib> T a(Class<T> paramClass)
  {
    Object localObject1 = (ajib)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localObject1 == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        ajib localajib = (ajib)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
        localObject1 = localajib;
        if (localajib == null)
        {
          localObject1 = b(paramClass);
          if (localObject1 != null)
          {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Controller name:" + paramClass.getSimpleName() + " is not null");
            this.jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
          }
        }
        else
        {
          return localObject1;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Controller name:" + paramClass.getSimpleName() + " is null");
      }
    }
    return localObject1;
  }
  
  private void a(Exception paramException)
  {
    if ((paramException instanceof NoSuchMethodException))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController getDeclaredConstructor throw NoSuchMethodException e:" + paramException.getMessage());
      return;
    }
    if ((paramException instanceof SecurityException))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController getDeclaredConstructor or setAccessible throw SecurityException e:" + paramException.getMessage());
      return;
    }
    if (((paramException instanceof IllegalAccessException)) || ((paramException instanceof IllegalArgumentException)) || ((paramException instanceof InstantiationException)) || ((paramException instanceof InvocationTargetException)))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController newInstance throw Exception e:" + paramException.getMessage() + "Exception name:" + paramException.getClass().getSimpleName());
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "genController throw other Exception e:" + paramException.getMessage() + "Exception name:" + paramException.getClass().getSimpleName());
  }
  
  private ajib b(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[] { QQAppInterface.class });
      paramClass.setAccessible(true);
      paramClass = (ajib)paramClass.newInstance(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
      a(paramClass);
    }
    return null;
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      ajib localajib = (ajib)localIterator.next();
      if (localajib != null) {
        localajib.b();
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      ajib localajib = (ajib)localIterator.next();
      if (localajib != null) {
        localajib.a();
      }
    }
  }
  
  public ajgq a(Long paramLong)
  {
    return ((ajic)a(ajic.class)).a(paramLong);
  }
  
  public ajhx a(int paramInt)
  {
    return ((ajid)a(ajid.class)).a(paramInt);
  }
  
  public List<MessageRecord> a()
  {
    return ((ajih)a(ajih.class)).a();
  }
  
  public List<MessageRecord> a(int paramInt)
  {
    return ((ajih)a(ajih.class)).a(paramInt);
  }
  
  public List<MessageRecord> a(ThreadExcutor.IThreadListener paramIThreadListener)
  {
    return ((ajih)a(ajih.class)).a(paramIThreadListener);
  }
  
  public List<Long> a(String paramString)
  {
    return ((ajic)a(ajic.class)).a(paramString);
  }
  
  public List<Long> a(List<oidb_0x5eb.UdcUinData> paramList)
  {
    return ((ajic)a(ajic.class)).a(paramList);
  }
  
  public void a()
  {
    ((ajic)a(ajic.class)).c();
  }
  
  public void a(int paramInt)
  {
    ((ajij)a(ajij.class)).a(paramInt);
  }
  
  public void a(long paramLong, int paramInt)
  {
    ((ajic)a(ajic.class)).a(paramLong, paramInt);
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    ((ajih)a(ajih.class)).a(paramLong, paramString, paramInt, paramBoolean);
  }
  
  public void a(ajfo paramajfo)
  {
    ((ajij)a(ajij.class)).a(paramajfo);
  }
  
  public void a(aqxv paramaqxv)
  {
    ((ajij)a(ajij.class)).b(paramaqxv);
  }
  
  public void a(Long paramLong)
  {
    ((ajic)a(ajic.class)).a(paramLong, 0, "OidbSvc.0x5eb_troopnotifycation");
  }
  
  public void a(List<Long> paramList)
  {
    ((ajic)a(ajic.class)).a("OidbSvc.0x5eb_troopnotifycation", paramList);
  }
  
  public void a(List<MessageRecord> paramList, int paramInt)
  {
    ((ajih)a(ajih.class)).a(paramList, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    ((ajih)a(ajih.class)).a(paramBoolean);
  }
  
  public boolean a()
  {
    return ((ajih)a(ajih.class)).a();
  }
  
  public void b()
  {
    c();
  }
  
  public void b(ajfo paramajfo)
  {
    ((ajij)a(ajij.class)).b(paramajfo);
  }
  
  public void b(Long paramLong)
  {
    ((ajic)a(ajic.class)).a(paramLong, 0, "OidbSvc.0x668");
  }
  
  public void b(List<Long> paramList)
  {
    ((ajic)a(ajic.class)).a("OidbSvc.0x668", paramList);
  }
  
  public void c(List<Long> paramList)
  {
    ((ajic)a(ajic.class)).a(paramList, "OidbSvc.0x5eb_troopnotifycation");
  }
  
  public void d(List<Long> paramList)
  {
    ((ajic)a(ajic.class)).a(paramList, "OidbSvc.0x668");
  }
  
  public void onDestroy()
  {
    d();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfn
 * JD-Core Version:    0.7.0.1
 */