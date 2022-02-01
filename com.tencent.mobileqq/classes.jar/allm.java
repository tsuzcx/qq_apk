import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDecoder;

class allm
  extends andd
{
  allm(alll paramalll) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getBitmapFromCache(113, paramString);
    if (localBitmap != null) {
      this.a.a(paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allm
 * JD-Core Version:    0.7.0.1
 */