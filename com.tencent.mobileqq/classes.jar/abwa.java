import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;

public class abwa
  extends EmotionJsonDownloadListener
{
  public abwa(EmojiManager paramEmojiManager, String paramString, Object paramObject) {}
  
  public void a(EmoticonPackage arg1, int paramInt, Bundle paramBundle)
  {
    if (???.epId.equals(this.jdField_a_of_type_JavaLangString)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwa
 * JD-Core Version:    0.7.0.1
 */