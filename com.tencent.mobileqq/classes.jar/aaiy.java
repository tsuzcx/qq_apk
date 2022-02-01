import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.1;
import com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class aaiy
{
  public static void a(String paramString, ImageView paramImageView)
  {
    ThreadManager.post(new MergeBitmapBlurUtil.1(paramString, paramImageView), 5, null, false);
  }
  
  private static void b(Bitmap paramBitmap, ImageView paramImageView)
  {
    ThreadManager.getUIHandler().post(new MergeBitmapBlurUtil.2(paramBitmap, paramImageView));
  }
  
  private static void b(String paramString, Bitmap paramBitmap, ImageView paramImageView)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    if (paramBitmap != null)
    {
      localBitmap = bgmo.a(paramImageView.getContext(), paramBitmap, 0.25F, 20.0F);
      if (localBitmap != null)
      {
        localCanvas = new Canvas();
        if (!localBitmap.isMutable()) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = localBitmap;; localObject = localBitmap.copy(localBitmap.getConfig(), true))
    {
      localCanvas.setBitmap((Bitmap)localObject);
      localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
      localObject = zmg.a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramImageView.getWidth(), paramImageView.getHeight());
      paramBitmap = zkh.a(zkh.a(localBitmap, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), true), paramBitmap);
      b(paramBitmap, paramImageView);
      bglc.a(paramString, paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiy
 * JD-Core Version:    0.7.0.1
 */