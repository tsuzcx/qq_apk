import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class afui
  implements ViewPager.OnPageChangeListener
{
  afui(afuh paramafuh) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = afuh.a(this.a).a(paramInt);
    if (localEmoticonFromGroupEntity != null)
    {
      afuh.a(this.a, localEmoticonFromGroupEntity);
      afuh.b(this.a, localEmoticonFromGroupEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afui
 * JD-Core Version:    0.7.0.1
 */