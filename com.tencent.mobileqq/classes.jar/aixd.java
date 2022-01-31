import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.transfile.VasExtensionDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aixd
  implements Runnable
{
  public aixd(VasExtensionDownloader paramVasExtensionDownloader, FavoriteEmoticonInfo paramFavoriteEmoticonInfo) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof AppInterface)) {}
    CustomEmotionData localCustomEmotionData;
    do
    {
      return;
      localObject = (FavroamingDBManager)((AppInterface)localObject).getManager(148);
      localCustomEmotionData = ((FavroamingDBManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.e);
    } while ((localCustomEmotionData == null) || (!new File(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.d).exists()));
    if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
      localCustomEmotionData.RomaingType = "isUpdate";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasExtensionDownloader", 2, "update CustomEmotionData romaing type  isUpdate, path: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.d);
      }
      if ((TextUtils.isEmpty(localCustomEmotionData.md5)) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath));
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "update CustomEmotionData md5 , path: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.d);
        }
      }
      if ("needDel".equals(localCustomEmotionData.RomaingType)) {
        break;
      }
      ((FavroamingDBManager)localObject).b(localCustomEmotionData);
      return;
      if ("overflow".equals(localCustomEmotionData.RomaingType)) {
        localCustomEmotionData.RomaingType = "overflow_downloaded";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixd
 * JD-Core Version:    0.7.0.1
 */