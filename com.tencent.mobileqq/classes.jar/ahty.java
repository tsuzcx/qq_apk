import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ahty
{
  private static int a;
  public ConcurrentHashMap<Long, ahub> a;
  
  static
  {
    jdField_a_of_type_Int = 900000;
  }
  
  private ahty()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final ahty a()
  {
    return ahua.a();
  }
  
  public ahub a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (ahub)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
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
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), new ahub(this, paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahty
 * JD-Core Version:    0.7.0.1
 */