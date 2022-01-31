import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class alaj
{
  public static alad a(alaf paramalaf, alah paramalah, GLSurfaceView paramGLSurfaceView)
  {
    if (paramalah == null) {
      return null;
    }
    switch (paramalah.a)
    {
    default: 
      return null;
    case 0: 
      paramalaf = new alas(paramalaf, (alat)paramalah);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramalah.toString());
      return paramalaf;
    case 2: 
    case 3: 
      paramalaf = new alba(paramalaf, (albc)paramalah);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramalah.toString());
      return paramalaf;
    case 4: 
      paramalaf = new albd(paramalaf, (albf)paramalah);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramalah.toString());
      return paramalaf;
    case 5: 
      paramalaf = new alaz(paramalaf, (alay)paramalah);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramalah.toString());
      return paramalaf;
    case 100: 
      paramalaf = new alaw(paramalaf, (alax)paramalah, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramalah.toString());
      return paramalaf;
    }
    return new alam(paramalaf, (alao)paramalah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alaj
 * JD-Core Version:    0.7.0.1
 */