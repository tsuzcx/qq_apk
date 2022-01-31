import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class akku
  extends akks
{
  public akku(QQAppInterface paramQQAppInterface, akkr paramakkr)
  {
    super(paramQQAppInterface, paramakkr, AppletsAccountInfo.class);
  }
  
  public AppletsAccountInfo a(String paramString)
  {
    return (AppletsAccountInfo)a(paramString);
  }
  
  protected String a(aukm paramaukm)
  {
    return ((AppletsAccountInfo)paramaukm).uin;
  }
  
  public void a(AppletsAccountInfo paramAppletsAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletAccountCache", 2, "saveAppletsAccount AppletsAccount = " + paramAppletsAccountInfo);
    }
    a(paramAppletsAccountInfo);
    this.jdField_a_of_type_Akkr.c();
  }
  
  protected void b() {}
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = ((aukn)localObject).a(AppletsAccountInfo.class);
    ((aukn)localObject).a();
    if (localList != null)
    {
      d();
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(localAppletsAccountInfo.uin), localAppletsAccountInfo);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("doInit size = ");
      if (localList != null) {
        break label118;
      }
    }
    label118:
    for (int i = 0;; i = localList.size())
    {
      QLog.d("AppletAccountCache", 2, i);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akku
 * JD-Core Version:    0.7.0.1
 */