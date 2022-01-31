import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aiyg
  implements aivw
{
  aiyg(aiye paramaiye, boolean paramBoolean, aiyh paramaiyh) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = aiqz.a("", "key_draw_hb_last_succ_model", "");
      if (!TextUtils.isEmpty(str)) {
        aiye.a(this.jdField_a_of_type_Aiye, str, this.jdField_a_of_type_Aiyh, false);
      }
    }
    while (this.jdField_a_of_type_Aiyh == null) {
      return;
    }
    this.jdField_a_of_type_Aiyh.a(false);
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
        aiye.a(this.jdField_a_of_type_Aiye, new aixx(str1, str2));
        if (this.jdField_a_of_type_Aiyh != null) {
          this.jdField_a_of_type_Aiyh.a(true);
        }
        aiqz.a("", "key_draw_hb_last_succ_model", paramPathResult.url);
        aiye.a(this.jdField_a_of_type_Aiye, true);
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
 * Qualified Name:     aiyg
 * JD-Core Version:    0.7.0.1
 */