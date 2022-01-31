import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ajwo
  extends ajwi
{
  public ajwo(QQAppInterface paramQQAppInterface, ajwh paramajwh)
  {
    super(paramQQAppInterface, paramajwh, TroopStatisticsInfo.class);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    long l = System.currentTimeMillis();
    if (l - atps.a(atqg.b, 0L) > 604800000L) {}
    for (;;)
    {
      try
      {
        atps.a(atqg.b, l);
        paramQQAppInterface.a(TroopStatisticsInfo.class);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.TroopStatisticsCache", 2, "doInit record time over 7 days, drop table");
        }
        return;
        paramajwh = paramQQAppInterface.a(TroopStatisticsInfo.class);
        if (paramajwh != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          localObject = paramajwh.iterator();
          if (((Iterator)localObject).hasNext())
          {
            TroopStatisticsInfo localTroopStatisticsInfo = (TroopStatisticsInfo)((Iterator)localObject).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localTroopStatisticsInfo), localTroopStatisticsInfo);
            continue;
          }
        }
      }
      catch (Exception paramajwh)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.db.Cache.TroopStatisticsCache", 2, paramajwh.getMessage());
        }
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject = new StringBuilder().append("doInit size = ");
        if (paramajwh == null)
        {
          i = 0;
          QLog.d("Q.db.Cache.TroopStatisticsCache", 2, i);
          continue;
        }
      }
      finally
      {
        paramQQAppInterface.a();
      }
      int i = paramajwh.size();
    }
  }
  
  public TroopStatisticsInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (paramString == null)) {
      return null;
    }
    return (TroopStatisticsInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(atmo paramatmo)
  {
    return ((TroopStatisticsInfo)paramatmo).troopUin;
  }
  
  protected void a() {}
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwo
 * JD-Core Version:    0.7.0.1
 */