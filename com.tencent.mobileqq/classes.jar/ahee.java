import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ahee
  implements ahbt
{
  ahee(ahec paramahec, boolean paramBoolean, ahef paramahef) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = agxc.a("", "key_draw_hb_last_succ_model", "");
      if (!TextUtils.isEmpty(str)) {
        ahec.a(this.jdField_a_of_type_Ahec, str, this.jdField_a_of_type_Ahef, false);
      }
    }
    while (this.jdField_a_of_type_Ahef == null) {
      return;
    }
    this.jdField_a_of_type_Ahef.a(false);
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
        ahec.a(this.jdField_a_of_type_Ahec, new ahdv(str1, str2));
        if (this.jdField_a_of_type_Ahef != null) {
          this.jdField_a_of_type_Ahef.a(true);
        }
        agxc.a("", "key_draw_hb_last_succ_model", paramPathResult.url);
        ahec.a(this.jdField_a_of_type_Ahec, true);
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
 * Qualified Name:     ahee
 * JD-Core Version:    0.7.0.1
 */