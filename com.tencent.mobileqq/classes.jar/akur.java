import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class akur
  implements akse
{
  akur(akuo paramakuo, akus paramakus) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_Akus != null) {
      this.jdField_a_of_type_Akus.a(false);
    }
  }
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      try
      {
        String str = new File(paramPathResult.folderPath, "quickDraw.tflite").toString();
        paramPathResult = new File(paramPathResult.folderPath, "classes.txt").toString();
        if ((!new File(str).exists()) || (!new File(paramPathResult).exists()))
        {
          QLog.e("DrawClassifier", 1, "init fail file not exist");
          a();
          return;
        }
        akuo.a(this.jdField_a_of_type_Akuo, new akuh(str, paramPathResult));
        if (this.jdField_a_of_type_Akus != null) {
          this.jdField_a_of_type_Akus.a(true);
        }
        akuo.a(this.jdField_a_of_type_Akuo, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akur
 * JD-Core Version:    0.7.0.1
 */