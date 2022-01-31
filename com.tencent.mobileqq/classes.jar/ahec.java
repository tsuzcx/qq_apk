import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ahec
  implements ahbr
{
  ahec(ahea paramahea, boolean paramBoolean, ahed paramahed) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = agxa.a("", "key_draw_hb_last_succ_model", "");
      if (!TextUtils.isEmpty(str)) {
        ahea.a(this.jdField_a_of_type_Ahea, str, this.jdField_a_of_type_Ahed, false);
      }
    }
    while (this.jdField_a_of_type_Ahed == null) {
      return;
    }
    this.jdField_a_of_type_Ahed.a(false);
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
        ahea.a(this.jdField_a_of_type_Ahea, new ahdt(str1, str2));
        if (this.jdField_a_of_type_Ahed != null) {
          this.jdField_a_of_type_Ahed.a(true);
        }
        agxa.a("", "key_draw_hb_last_succ_model", paramPathResult.url);
        ahea.a(this.jdField_a_of_type_Ahea, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahec
 * JD-Core Version:    0.7.0.1
 */