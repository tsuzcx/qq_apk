import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class afuk
  implements ViewPager.OnPageChangeListener
{
  afuk(afuj paramafuj) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = afuj.a(this.a).a(paramInt);
    if (localEmoticonFromGroupEntity != null)
    {
      afuj.a(this.a, localEmoticonFromGroupEntity);
      afuj.b(this.a, localEmoticonFromGroupEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuk
 * JD-Core Version:    0.7.0.1
 */