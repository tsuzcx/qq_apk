import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class aats
  implements Runnable
{
  public aats(String paramString, ArkAppCenter.OnGetAppIcon paramOnGetAppIcon) {}
  
  public void run()
  {
    synchronized ()
    {
      aauc localaauc2 = (aauc)ArkAppCenter.a().get(this.jdField_a_of_type_JavaLangString);
      if (localaauc2 != null) {
        localaauc2.jdField_a_of_type_Int += 1;
      }
      if (localaauc2 != null)
      {
        ArkAppCenter.a().postToMainThread(new aatt(this, localaauc2));
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
          localaauc1 = new aauc(null);
          localaauc1.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          ArkAppCenter.a().put(this.jdField_a_of_type_JavaLangString, localaauc1);
          ArkAppCenter.a().postToMainThread(new aatu(this, localaauc1));
        }
      }
      aauc localaauc1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aats
 * JD-Core Version:    0.7.0.1
 */