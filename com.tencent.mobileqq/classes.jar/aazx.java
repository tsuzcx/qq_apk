import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class aazx
  implements abac
{
  public aazx(ArkAppCGI paramArkAppCGI) {}
  
  public void a(abad paramabad, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    paramabad = (abai)paramabad;
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      paramBoolean = ArkAppCGI.a(paramabad, paramArrayOfByte);
    }
    while ((paramBoolean) && (paramabad.jdField_a_of_type_Boolean))
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, more data, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramabad.d.size()), Long.valueOf(paramabad.jdField_c_of_type_Long), Integer.valueOf(paramabad.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramabad.jdField_b_of_type_Long) }));
      ArkAppCGI.a(this.a, paramabad);
      return;
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, request fail, gray-app-id=%d, app-id=%d", new Object[] { Long.valueOf(paramabad.jdField_c_of_type_Long), Long.valueOf(paramabad.jdField_b_of_type_Long) }));
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, done, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramabad.d.size()), Long.valueOf(paramabad.jdField_c_of_type_Long), Integer.valueOf(paramabad.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramabad.jdField_b_of_type_Long) }));
    int j = paramabad.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte = paramabad.jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramabad.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramabad.jdField_c_of_type_JavaUtilArrayList, paramabad.d);
      }
      i += 1;
    }
    paramabad.jdField_b_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazx
 * JD-Core Version:    0.7.0.1
 */