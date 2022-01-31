import com.tencent.mobileqq.surfaceviewaction.gl.Node;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.List;

public class aiqe
  implements Runnable
{
  public aiqe(SpriteGLView paramSpriteGLView) {}
  
  public void run()
  {
    this.a.o();
    int i = 0;
    while (i < SpriteGLView.a(this.a).size())
    {
      ((Node)SpriteGLView.a(this.a).get(i)).b();
      i += 1;
    }
    SpriteGLView.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqe
 * JD-Core Version:    0.7.0.1
 */