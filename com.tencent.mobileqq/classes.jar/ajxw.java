import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ajxw
  implements axrs
{
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaxsp instanceof axro));
      paramaxsp = (axro)paramaxsp;
      paramaxsp.jdField_a_of_type_Long += paramaxsq.c;
      paramaxsq.c = 0L;
      paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-";
      paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
      paramaxsq = paramaxsp.jdField_a_of_type_JavaLangString;
      if (paramaxsq.contains("range="))
      {
        String str = paramaxsq.substring(0, paramaxsq.lastIndexOf("range="));
        paramaxsp.jdField_a_of_type_JavaLangString = (str + "range=" + paramaxsp.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("MonitorSocketDownload", 2, "IBreakDownFix, " + paramaxsq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajxw
 * JD-Core Version:    0.7.0.1
 */