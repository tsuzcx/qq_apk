import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class aame
  implements aamg
{
  public aame(ArkAppCGI paramArkAppCGI) {}
  
  public void a(aamh paramaamh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((!paramBoolean) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("getPredownloadAppList: fail, url=%s", new Object[] { paramaamh.jdField_a_of_type_JavaLangString }));
    }
    for (;;)
    {
      int i = 0;
      while (i < paramaamh.b.size())
      {
        paramArrayOfByte = paramaamh.jdField_a_of_type_JavaUtilArrayList.get(i);
        ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramaamh.b.get(i);
        if (localArkAppCGICallback != null) {
          localArkAppCGICallback.a(paramBoolean, localArrayList1, localArrayList2, paramArrayOfByte);
        }
        i += 1;
      }
      ArkAppCGI.a(this.a, paramArrayOfByte, localArrayList1, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aame
 * JD-Core Version:    0.7.0.1
 */