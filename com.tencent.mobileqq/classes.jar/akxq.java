import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qidian.QidianProfileCardActivity;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class akxq
  implements Runnable
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public akxq(QidianProfileCardActivity paramQidianProfileCardActivity, URLDrawable paramURLDrawable, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQidianProfileCardActivity);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    localQidianProfileCardActivity = (QidianProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQidianProfileCardActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        str1 = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
        if (str1 == null) {
          continue;
        }
        ImageUtil.a(localQidianProfileCardActivity, str1);
        str1 = localQidianProfileCardActivity.getString(2131434565) + " " + str1;
      }
      catch (IOException localIOException)
      {
        String str1;
        String str2 = localQidianProfileCardActivity.getString(2131434566);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        String str3 = localQidianProfileCardActivity.getString(2131434566);
        continue;
      }
      localQidianProfileCardActivity.runOnUiThread(new akxr(this, localQidianProfileCardActivity, str1));
      return;
      str1 = localQidianProfileCardActivity.getString(2131434566);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akxq
 * JD-Core Version:    0.7.0.1
 */