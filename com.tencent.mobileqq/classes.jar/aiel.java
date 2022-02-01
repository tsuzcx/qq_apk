import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public class aiel
{
  public int a;
  public long a;
  public MessageForShortVideo a;
  String jdField_a_of_type_JavaLangString;
  public String[] a;
  
  public aiel(aiei paramaiei, String[] paramArrayOfString, long paramLong, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(" LongVideoUrlCacheManager", 2, "UrlsCacheBean, now=  " + l1 + ", mGetTime" + this.jdField_a_of_type_Long + " diff=" + l2 + " urlTimeValidDiff=" + aiei.a());
    }
    return l2 < aiei.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiel
 * JD-Core Version:    0.7.0.1
 */