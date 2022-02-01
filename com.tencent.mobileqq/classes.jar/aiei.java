import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aiei
{
  private static int a;
  public ConcurrentHashMap<Long, aiel> a;
  
  static
  {
    jdField_a_of_type_Int = 900000;
  }
  
  private aiei()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final aiei a()
  {
    return aiek.a();
  }
  
  public aiel a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (aiel)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" LongVideoUrlCacheManager", 2, "LongVideoUrlCacheManager,clearCache");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), new aiel(this, paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiei
 * JD-Core Version:    0.7.0.1
 */