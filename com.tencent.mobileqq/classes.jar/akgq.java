import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasResourceCheckUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public final class akgq
  extends DownloadListener
{
  public akgq(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    paramDownloadTask = new File(VasResourceCheckUtil.jdField_a_of_type_JavaLangString);
    if (paramDownloadTask.exists())
    {
      paramDownloadTask = FileUtils.a(paramDownloadTask, -1);
      if (!TextUtils.isEmpty(paramDownloadTask)) {}
      try
      {
        paramDownloadTask = Base64.decode(paramDownloadTask, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        paramDownloadTask = new JSONObject(new String(localCipher.doFinal(paramDownloadTask)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + paramDownloadTask.toString());
        }
        VasResourceCheckUtil.a(this.a);
        VasResourceCheckUtil.jdField_a_of_type_AndroidOsHandler.sendMessage(VasResourceCheckUtil.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception paramDownloadTask)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + paramDownloadTask.getMessage());
        VasResourceCheckUtil.jdField_a_of_type_AndroidOsHandler.sendMessage(VasResourceCheckUtil.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    VasResourceCheckUtil.jdField_a_of_type_AndroidOsHandler.sendMessage(VasResourceCheckUtil.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akgq
 * JD-Core Version:    0.7.0.1
 */