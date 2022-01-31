import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mobileqq.shortvideo.filter.QQMovieFilter;
import java.lang.ref.WeakReference;

public class aibk
  implements SurfaceTexture.OnFrameAvailableListener
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aibk(QQMovieFilter paramQQMovieFilter)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQMovieFilter);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QQMovieFilter localQQMovieFilter = (QQMovieFilter)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQMovieFilter != null) {
        localQQMovieFilter.a(paramSurfaceTexture);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aibk
 * JD-Core Version:    0.7.0.1
 */