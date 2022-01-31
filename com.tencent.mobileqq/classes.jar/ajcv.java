import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ajcv
  implements ajal
{
  ajcv(ajct paramajct, boolean paramBoolean, ajcw paramajcw) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = aivo.a("", "key_draw_hb_last_succ_model", "");
      if (!TextUtils.isEmpty(str)) {
        ajct.a(this.jdField_a_of_type_Ajct, str, this.jdField_a_of_type_Ajcw, false);
      }
    }
    while (this.jdField_a_of_type_Ajcw == null) {
      return;
    }
    this.jdField_a_of_type_Ajcw.a(false);
  }
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      try
      {
        String str1 = new File(paramPathResult.folderPath, "quickDraw.tflite").toString();
        String str2 = new File(paramPathResult.folderPath, "classes.txt").toString();
        if ((!new File(str1).exists()) || (!new File(str2).exists()))
        {
          QLog.e("DrawClassifier", 1, "init fail file not exist");
          a();
          return;
        }
        ajct.a(this.jdField_a_of_type_Ajct, new ajcm(str1, str2));
        if (this.jdField_a_of_type_Ajcw != null) {
          this.jdField_a_of_type_Ajcw.a(true);
        }
        aivo.a("", "key_draw_hb_last_succ_model", paramPathResult.url);
        ajct.a(this.jdField_a_of_type_Ajct, true);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("DrawClassifier", 2, "init success");
        return;
      }
      catch (Throwable paramPathResult)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "init recog fail:" + paramPathResult);
        }
        paramPathResult.printStackTrace();
        a();
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "init download fail");
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcv
 * JD-Core Version:    0.7.0.1
 */