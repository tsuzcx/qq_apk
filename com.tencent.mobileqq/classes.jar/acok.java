import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;

public class acok
  implements QueryCallback
{
  public acok(PicEmoticonInfo paramPicEmoticonInfo, String paramString) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acok
 * JD-Core Version:    0.7.0.1
 */