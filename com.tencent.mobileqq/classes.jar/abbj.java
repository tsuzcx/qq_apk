import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapTracer.TraceResultListener;

class abbj
  implements ARMapTracer.TraceResultListener
{
  abbj(abbi paramabbi) {}
  
  public boolean a(int paramInt)
  {
    ARGLSurfaceView localARGLSurfaceView = this.a.a.a;
    if (localARGLSurfaceView != null) {
      localARGLSurfaceView.runOnGlThread(new abbk(this, localARGLSurfaceView, paramInt));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbj
 * JD-Core Version:    0.7.0.1
 */