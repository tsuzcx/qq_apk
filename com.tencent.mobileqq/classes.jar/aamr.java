import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class aamr
  implements Runnable
{
  public aamr(String paramString, ArkAppCenter.OnGetAppIcon paramOnGetAppIcon) {}
  
  public void run()
  {
    synchronized ()
    {
      aanb localaanb2 = (aanb)ArkAppCenter.a().get(this.jdField_a_of_type_JavaLangString);
      if (localaanb2 != null) {
        localaanb2.jdField_a_of_type_Int += 1;
      }
      if (localaanb2 != null)
      {
        ArkAppCenter.a().postToMainThread(new aams(this, localaanb2));
        return;
      }
    }
    ark.Application localApplication = ark.Application.Create(this.jdField_a_of_type_JavaLangString);
    if (localApplication == null) {
      ??? = null;
    }
    for (;;)
    {
      if (localApplication != null) {
        localApplication.Release();
      }
      if (??? == null) {
        break;
      }
      ((Bitmap)???).recycle();
      return;
      int i = localApplication.GetIconWidth();
      int j = localApplication.GetIconHeight();
      if ((i <= 0) || (j <= 0))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ArkApp", 1, "getAppIcon.getSize.error!!");
          ??? = null;
        }
      }
      else {
        try
        {
          localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ??? = localBitmap;
          if (localBitmap == null) {
            continue;
          }
          if (!localApplication.CopyIconToBitmap(localBitmap))
          {
            ??? = localBitmap;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ArkApp", 1, "getAppIcon.copyToBitmap fail!!");
            ??? = localBitmap;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Bitmap localBitmap;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ArkApp", 1, "getAppIcon.createBitmap fail!!");
            }
            localBitmap = null;
          }
          localaanb1 = new aanb(null);
          localaanb1.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          ArkAppCenter.a().put(this.jdField_a_of_type_JavaLangString, localaanb1);
          ArkAppCenter.a().postToMainThread(new aamt(this, localaanb1));
        }
      }
      aanb localaanb1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aamr
 * JD-Core Version:    0.7.0.1
 */