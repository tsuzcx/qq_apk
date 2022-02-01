import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class ajnd
  implements ViewPager.OnPageChangeListener
{
  ajnd(ajnc paramajnc) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = ajnc.a(this.a).a(paramInt);
    if (localEmoticonFromGroupEntity != null)
    {
      ajnc.a(this.a, localEmoticonFromGroupEntity);
      ajnc.b(this.a, localEmoticonFromGroupEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnd
 * JD-Core Version:    0.7.0.1
 */