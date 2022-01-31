import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class aelu
  implements Runnable
{
  public aelu(PngFrameManager paramPngFrameManager, String paramString, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if (FileUtils.a(this.jdField_a_of_type_JavaLangString))
    {
      ??? = PngGifEngine.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangObject = ???;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        }
        return;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.eId;
    ??? = new DownloadTask(EmoticonUtils.j.replace("[eIdSub]", ((String)???).substring(0, 2)).replace("[eId]", (CharSequence)???).replace("[width]", "200").replace("[height]", "200"), new File(this.jdField_a_of_type_JavaLangString));
    ((DownloadTask)???).l = true;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)???, new aelv(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelu
 * JD-Core Version:    0.7.0.1
 */