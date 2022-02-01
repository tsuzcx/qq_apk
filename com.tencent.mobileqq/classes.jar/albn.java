import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;

class albn
  extends andd
{
  albn(albm paramalbm) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getFaceBitmap(113, paramString, false, 0);
    if (localBitmap != null) {
      albm.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albn
 * JD-Core Version:    0.7.0.1
 */