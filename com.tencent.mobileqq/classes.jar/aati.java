import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager.GreetingCardItem;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.qphone.base.util.QLog;

public class aati
  implements NonMainAppHeadLoader.FaceObserver
{
  public aati(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    QLog.d("ARGreetingCardListManager", 2, String.format("onFaceUpdate uin=%s headPath=%s", new Object[] { paramString1, paramString2 }));
    paramString2 = this.a.a(ARGreetingCardListManager.e(this.a));
    if (paramString2 != null)
    {
      paramString2 = String.valueOf(paramString2.a);
      if ((paramString2 != null) && (paramString2.equals(paramString1))) {
        ARGreetingCardListManager.a(this.a).setImageDrawable(new BitmapDrawable(paramBitmap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aati
 * JD-Core Version:    0.7.0.1
 */