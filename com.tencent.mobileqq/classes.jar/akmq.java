import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akmq
  extends biht
{
  public akmq(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambihu.a() + ",errCode=" + parambihu.jdField_a_of_type_Int);
    }
    int i = parambihu.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambihu.jdField_a_of_type_JavaLangString;
      if (!bhkt.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambihu.jdField_a_of_type_Int != 0) || (parambihu.f != 200)) {
        break label237;
      }
      str = bhkt.b + "/icon.zip";
      localFile = new File(bhkt.c);
      if (bihw.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambihu.f + ", url: " + parambihu.jdField_a_of_type_JavaLangString);
      }
      bhmi.a(bhkt.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambihu.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.c(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambihu.f + ", url: " + parambihu.jdField_a_of_type_JavaLangString);
      }
      bhmi.a(bhkt.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambihu.jdField_a_of_type_JavaLangString + ",errCode:" + parambihu.jdField_a_of_type_Int + ",httpCode:" + parambihu.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmq
 * JD-Core Version:    0.7.0.1
 */