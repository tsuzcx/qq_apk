import com.tencent.qqprotect.qsec.CloudAVEngineImpl;
import com.tencent.qqprotect.qsec.ICloudAVEngine.ApkDetectBundle;
import com.tencent.qqprotect.qsec.ICloudAVEngine.DetectBundle;
import com.tencent.qqprotect.qsec.QSecFramework.IGoingUpHandler;

public final class alhn
  implements QSecFramework.IGoingUpHandler
{
  private alhn(CloudAVEngineImpl paramCloudAVEngineImpl) {}
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramInt1 == 2) {}
    try
    {
      this.a.flushRequest();
      return 0;
    }
    catch (Exception paramObject1)
    {
      label57:
      paramObject1.printStackTrace();
      return -1;
    }
    if ((paramObject1 != null) && (paramObject2 != null) && (paramArrayOfObject1 != null))
    {
      if (paramArrayOfObject1.length >= 6) {
        break label236;
      }
      break label233;
      if (paramInt2 != 0)
      {
        paramArrayOfObject2 = new alhm(paramInt2);
        break label246;
        if (((Integer)paramObject1).intValue() == 0) {
          break label262;
        }
      }
    }
    label262:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (((Integer)paramObject2).intValue() == 1) {
        paramObject1 = new ICloudAVEngine.ApkDetectBundle((String)paramArrayOfObject1[2]);
      }
      for (;;)
      {
        return this.a.cloudDetect(paramObject1, bool1, bool2, paramArrayOfObject2);
        paramObject1 = new ICloudAVEngine.DetectBundle();
        paramObject1.jdField_a_of_type_Int = ((Integer)paramObject2).intValue();
        paramObject1.b = ((Integer)paramArrayOfObject1[0]).intValue();
        paramObject1.jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject1[1]);
        paramObject1.c = ((String)paramArrayOfObject1[2]);
        paramObject1.d = ((String)paramArrayOfObject1[3]);
        paramObject1.e = ((String)paramArrayOfObject1[4]);
        paramObject1.jdField_a_of_type_ArrayOfByte = ((byte[])paramArrayOfObject1[5]);
      }
      paramArrayOfObject2 = null;
      break label246;
      label233:
      return 13;
      label236:
      if (paramArrayOfObject1[0] != null) {
        break;
      }
      return 13;
      label246:
      if (paramInt3 != 0)
      {
        bool1 = true;
        break label57;
      }
      boolean bool1 = false;
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhn
 * JD-Core Version:    0.7.0.1
 */