import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter;

public class acfs
  extends EmoticonPackageDownloadListener
{
  public acfs(EmotionNeedDownloadAdapter paramEmotionNeedDownloadAdapter) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    this.a.b(paramEmoticonPackage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    this.a.a(paramEmoticonPackage, paramInt);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.a.a(paramEmoticonPackage);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.a.a(paramEmoticonPackage, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfs
 * JD-Core Version:    0.7.0.1
 */