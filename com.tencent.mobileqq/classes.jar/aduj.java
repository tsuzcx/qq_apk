import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.ChatBackgroundManager.BgThemeColorExtractListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class aduj
  implements Runnable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ChatBackgroundManager.BgThemeColorExtractListener jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager$BgThemeColorExtractListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public aduj(ChatBackgroundManager paramChatBackgroundManager, String paramString, Bitmap paramBitmap, boolean paramBoolean, ChatBackgroundManager.BgThemeColorExtractListener paramBgThemeColorExtractListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager$BgThemeColorExtractListener = paramBgThemeColorExtractListener;
  }
  
  public void run()
  {
    Vector localVector;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localVector = this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      if ((localVector != null) && (!localVector.isEmpty())) {
        if (this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString) != null)
        {
          ((Vector)this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString)).addAll(localVector);
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable success.");
          }
          label97:
          if (this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager$BgThemeColorExtractListener != null)
          {
            localVector = (Vector)this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString);
            if ((localVector == null) || (localVector.isEmpty())) {
              break label225;
            }
          }
        }
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new aduk(this, bool, localVector));
      return;
      this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_a_of_type_JavaLangString, localVector);
      break;
      this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaLangString);
      break;
      this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaLangString);
      if (!QLog.isDevelopLevel()) {
        break label97;
      }
      QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable failed.");
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aduj
 * JD-Core Version:    0.7.0.1
 */