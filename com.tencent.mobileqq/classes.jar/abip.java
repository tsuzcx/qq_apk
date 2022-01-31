import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.qphone.base.util.QLog;

public class abip
  implements NonMainAppHeadLoader.FaceObserver
{
  public abip(ARMapActivity paramARMapActivity) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramBitmap != null) && (paramString1.equals(this.a.h)) && (this.a.j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "onFaceUpdate uin:" + paramString1 + " path=" + paramString2);
      }
      this.a.j = false;
      ThreadManager.post(new abiq(this, paramBitmap), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abip
 * JD-Core Version:    0.7.0.1
 */