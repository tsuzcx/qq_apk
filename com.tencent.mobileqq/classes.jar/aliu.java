import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class aliu
  implements aysb
{
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    while (!(paramaysy instanceof ayrx)) {
      return;
    }
    ayrx localayrx = (ayrx)paramaysy;
    localayrx.jdField_a_of_type_Long += paramaysz.c;
    paramaysz.c = 0L;
    paramaysz = "bytes=" + localayrx.jdField_a_of_type_Long + "-";
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
    paramaysz = localayrx.jdField_a_of_type_JavaLangString;
    if (paramaysz.contains("range="))
    {
      paramaysz = paramaysz.substring(0, paramaysz.lastIndexOf("range="));
      localayrx.jdField_a_of_type_JavaLangString = (paramaysz + "range=" + localayrx.jdField_a_of_type_Long);
    }
    QLog.i("AREngine_ARResourceDownload", 1, "IBreakDownFix. url = " + ((ayrx)paramaysy).jdField_a_of_type_JavaLangString + ", offset=" + localayrx.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aliu
 * JD-Core Version:    0.7.0.1
 */