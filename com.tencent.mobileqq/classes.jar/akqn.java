import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.apollo.GLTextureView;

public class akqn
  implements View.OnLayoutChangeListener
{
  public akqn(GLTextureView paramGLTextureView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.surfaceChanged(this.a.getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqn
 * JD-Core Version:    0.7.0.1
 */