import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import java.util.LinkedList;

class aild
  implements Runnable
{
  aild(ailc paramailc) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      synchronized (this.a.a)
      {
        Texture[] arrayOfTexture = FrameSprite.a(this.a.a);
        if ((arrayOfTexture == null) || (FrameSprite.a(this.a.a))) {
          return;
        }
        FrameSprite.a(this.a.a, new Texture[FrameSprite.a(this.a.a).length / 2]);
        j = 0;
        int i = 0;
        if (j < FrameSprite.a(this.a.a).length)
        {
          if (j % 2 == 0)
          {
            FrameSprite localFrameSprite2 = this.a.a;
            int k = i + 1;
            FrameSprite.a(localFrameSprite2, i, arrayOfTexture[j]);
            i = k;
          }
          else
          {
            FrameSprite.a(this.a.a).remove(arrayOfTexture[j]);
            arrayOfTexture[j].c();
          }
        }
        else {
          return;
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aild
 * JD-Core Version:    0.7.0.1
 */