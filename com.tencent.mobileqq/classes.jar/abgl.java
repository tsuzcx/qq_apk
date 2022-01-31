import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abgl
  implements NonMainAppHeadLoader.FaceObserver
{
  public abgl(ARGridMapViewDialog paramARGridMapViewDialog) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.equals(paramString1, ARGridMapViewDialog.a(this.a))) && (paramBitmap != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapBaseDialog", 2, "ARMapPOIDialog onFaceUpdate uin:" + paramString1);
      }
      if (this.a.c == 2) {
        ThreadManager.getUIHandler().post(new abgm(this, paramBitmap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgl
 * JD-Core Version:    0.7.0.1
 */