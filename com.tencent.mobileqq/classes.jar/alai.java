import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class alai
{
  public static alac a(alae paramalae, alag paramalag, GLSurfaceView paramGLSurfaceView)
  {
    if (paramalag == null) {
      return null;
    }
    switch (paramalag.a)
    {
    default: 
      return null;
    case 0: 
      paramalae = new alar(paramalae, (alas)paramalag);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramalag.toString());
      return paramalae;
    case 2: 
    case 3: 
      paramalae = new alaz(paramalae, (albb)paramalag);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramalag.toString());
      return paramalae;
    case 4: 
      paramalae = new albc(paramalae, (albe)paramalag);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramalag.toString());
      return paramalae;
    case 5: 
      paramalae = new alay(paramalae, (alax)paramalag);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramalag.toString());
      return paramalae;
    case 100: 
      paramalae = new alav(paramalae, (alaw)paramalag, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramalag.toString());
      return paramalae;
    }
    return new alal(paramalae, (alan)paramalag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alai
 * JD-Core Version:    0.7.0.1
 */