import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class aamb
  implements aamg
{
  public aamb(ArkAppCGI paramArkAppCGI) {}
  
  public void a(aamh paramaamh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    paramaamh = (aamm)paramaamh;
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      paramBoolean = ArkAppCGI.a(paramaamh, paramArrayOfByte);
    }
    while ((paramBoolean) && (paramaamh.jdField_a_of_type_Boolean))
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, more data, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramaamh.d.size()), Long.valueOf(paramaamh.jdField_c_of_type_Long), Integer.valueOf(paramaamh.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramaamh.jdField_b_of_type_Long) }));
      ArkAppCGI.a(this.a, paramaamh);
      return;
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, request fail, gray-app-id=%d, app-id=%d", new Object[] { Long.valueOf(paramaamh.jdField_c_of_type_Long), Long.valueOf(paramaamh.jdField_b_of_type_Long) }));
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("_getContextActionAppList, done, gray-app=%d(%d), app=%d(%d)", new Object[] { Integer.valueOf(paramaamh.d.size()), Long.valueOf(paramaamh.jdField_c_of_type_Long), Integer.valueOf(paramaamh.jdField_c_of_type_JavaUtilArrayList.size()), Long.valueOf(paramaamh.jdField_b_of_type_Long) }));
    int j = paramaamh.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte = paramaamh.jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramaamh.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramaamh.jdField_c_of_type_JavaUtilArrayList, paramaamh.d);
      }
      i += 1;
    }
    paramaamh.jdField_b_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aamb
 * JD-Core Version:    0.7.0.1
 */