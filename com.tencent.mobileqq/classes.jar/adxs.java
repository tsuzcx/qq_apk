import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;

public class adxs
  extends PagerAdapter
{
  public adxs(RichTextPanel paramRichTextPanel) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView(RichTextPanel.a(this.a)[paramInt]);
  }
  
  public int getCount()
  {
    return RichTextPanel.a().length;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTextPanel", 2, "instantiateItem position = " + paramInt);
    }
    ViewParent localViewParent = RichTextPanel.a(this.a).getParent();
    if (localViewParent != null) {
      ((ViewGroup)localViewParent).removeView(RichTextPanel.a(this.a)[paramInt]);
    }
    paramViewGroup.addView(RichTextPanel.a(this.a)[paramInt]);
    return RichTextPanel.a(this.a)[paramInt];
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxs
 * JD-Core Version:    0.7.0.1
 */