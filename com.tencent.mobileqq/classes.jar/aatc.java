import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class aatc
  implements aath
{
  public aatc(ArkAppCGI paramArkAppCGI) {}
  
  public void a(aati paramaati, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    paramaati = (aatn)paramaati;
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      paramBoolean = ArkAppCGI.a(paramaati, paramArrayOfByte);
    }
    while ((paramBoolean) && (paramaati.jdField_a_of_type_Boolean))
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, more data, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramaati.d.size()), Long.valueOf(paramaati.jdField_c_of_type_Long), Integer.valueOf(paramaati.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramaati.jdField_b_of_type_Long) }));
      ArkAppCGI.a(this.a, paramaati);
      return;
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, request fail, gray-app-id=%d, app-id=%d", new Object[] { Long.valueOf(paramaati.jdField_c_of_type_Long), Long.valueOf(paramaati.jdField_b_of_type_Long) }));
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, done, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramaati.d.size()), Long.valueOf(paramaati.jdField_c_of_type_Long), Integer.valueOf(paramaati.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramaati.jdField_b_of_type_Long) }));
    int j = paramaati.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte = paramaati.jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramaati.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramaati.jdField_c_of_type_JavaUtilArrayList, paramaati.d);
      }
      i += 1;
    }
    paramaati.jdField_b_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatc
 * JD-Core Version:    0.7.0.1
 */