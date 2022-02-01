import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qphone.base.util.QLog;

public class alzg
  implements apsw
{
  public alzg(SessionClearFragment paramSessionClearFragment) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SessionClearFragment", 4, "mHeaderLoaderForUser onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
    SessionClearFragment.a(this.a).a(paramString1, paramBitmap, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzg
 * JD-Core Version:    0.7.0.1
 */