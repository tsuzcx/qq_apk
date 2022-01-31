import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class aklh
  implements akmd
{
  private int a;
  
  public aklh(int paramInt)
  {
    QLog.i("ApolloTextureView", 1, "[ApolloConfigChooser], multiValue:" + paramInt);
    this.a = paramInt;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int i = this.a;
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, new int[] { 12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12321, 8, 12326, 0, 12338, 1, 12337, i, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
    if (arrayOfInt[0] == 0)
    {
      QLog.e("ApolloTextureView", 1, "[ApolloConfigChooser], fail to set config");
      return null;
    }
    return arrayOfEGLConfig[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklh
 * JD-Core Version:    0.7.0.1
 */