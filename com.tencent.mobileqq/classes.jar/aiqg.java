import android.content.Context;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class aiqg
  extends VideoSprite
{
  public aiqg(SpriteVideoView paramSpriteVideoView, SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramContext, paramBoolean);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.a == 0) {
      this.a.a = paramInt2;
    }
    super.a(paramInt1, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqg
 * JD-Core Version:    0.7.0.1
 */