import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class aklx
{
  public static aklr a(aklt paramaklt, aklv paramaklv, GLSurfaceView paramGLSurfaceView)
  {
    if (paramaklv == null) {
      return null;
    }
    switch (paramaklv.a)
    {
    default: 
      return null;
    case 0: 
      paramaklt = new akmg(paramaklt, (akmh)paramaklv);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramaklv.toString());
      return paramaklt;
    case 2: 
    case 3: 
      paramaklt = new akmo(paramaklt, (akmq)paramaklv);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramaklv.toString());
      return paramaklt;
    case 4: 
      paramaklt = new akmr(paramaklt, (akmt)paramaklv);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramaklv.toString());
      return paramaklt;
    case 5: 
      paramaklt = new akmn(paramaklt, (akmm)paramaklv);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramaklv.toString());
      return paramaklt;
    case 100: 
      paramaklt = new akmk(paramaklt, (akml)paramaklv, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramaklv.toString());
      return paramaklt;
    }
    return new akma(paramaklt, (akmc)paramaklv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aklx
 * JD-Core Version:    0.7.0.1
 */