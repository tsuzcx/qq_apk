import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aght
  extends bbwf
{
  public aght(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambbwg.a() + ",errCode=" + parambbwg.jdField_a_of_type_Int);
    }
    int i = parambbwg.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambbwg.jdField_a_of_type_JavaLangString;
      if (!bbby.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambbwg.jdField_a_of_type_Int != 0) || (parambbwg.f != 200)) {
        break label237;
      }
      str = bbby.b + "/icon.zip";
      localFile = new File(bbby.c);
      if (bbwi.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambbwg.f + ", url: " + parambbwg.jdField_a_of_type_JavaLangString);
      }
      bbdj.a(bbby.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambbwg.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambbwg.f + ", url: " + parambbwg.jdField_a_of_type_JavaLangString);
      }
      bbdj.a(bbby.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambbwg.jdField_a_of_type_JavaLangString + ",errCode:" + parambbwg.jdField_a_of_type_Int + ",httpCode:" + parambbwg.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aght
 * JD-Core Version:    0.7.0.1
 */