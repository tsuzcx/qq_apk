import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;

class akwr
  extends AbsPreDownloadTask
{
  akwr(akwp paramakwp, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, bhyn parambhyn, DownloadParam paramDownloadParam)
  {
    super(paramQQAppInterface, paramString);
  }
  
  public void realCancel() {}
  
  public void realStart()
  {
    akwp.a(this.jdField_a_of_type_Akwp, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bhyn, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwr
 * JD-Core Version:    0.7.0.1
 */