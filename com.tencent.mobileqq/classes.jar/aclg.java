import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public final class aclg
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, start");
    }
    String str = EmojiStickerManager.a();
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, rootPath = " + str);
    }
    Object localObject = new File(str);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).list();
      if ((localObject == null) || (localObject.length <= 1)) {
        break label113;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, list.length =  " + localObject.length);
      }
    }
    return;
    label113:
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, need to extract  ");
    }
    localObject = str + "emojiStickerGuideZip_v2" + ".zip";
    try
    {
      FileUtils.a((String)localObject, str, false);
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e("EmojiStickerManager", 1, "extractStickerMaterial uncompressZip error = " + localIOException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("EmojiStickerManager", 1, "extractStickerMaterial uncompressZip error = " + localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aclg
 * JD-Core Version:    0.7.0.1
 */