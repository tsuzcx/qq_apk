import com.tencent.qqprotect.qsec.ICloudAVEngine.DetectBundle;
import com.tencent.qqprotect.qsec.ICloudAVEngine.IAVEngineEventListener;
import com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle;
import com.tencent.qqprotect.qsec.QSecFramework;

public final class alxc
  implements ICloudAVEngine.IAVEngineEventListener
{
  private int a;
  
  public alxc(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, ICloudAVEngine.DetectBundle paramDetectBundle, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    int i = 0;
    if (this.jdField_a_of_type_Int != 0)
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4)) {
        break label41;
      }
      QSecFramework.a(5, this.jdField_a_of_type_Int, paramInt, 0, null, null, null, null);
    }
    label41:
    while (paramInt != 3) {
      return;
    }
    int j = paramResultBundle.jdField_a_of_type_Int;
    int k = paramResultBundle.b;
    int m = paramResultBundle.c;
    int n = paramResultBundle.d;
    paramDetectBundle = paramResultBundle.jdField_a_of_type_ArrayOfByte;
    int i1 = this.jdField_a_of_type_Int;
    if (paramResultBundle.jdField_a_of_type_Boolean) {
      i = 1;
    }
    QSecFramework.a(5, i1, paramInt, i, null, null, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), paramDetectBundle }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alxc
 * JD-Core Version:    0.7.0.1
 */