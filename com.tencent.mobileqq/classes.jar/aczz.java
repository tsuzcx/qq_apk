import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import com.tencent.mobileqq.widget.QQViewPager;

public class aczz
  extends PagerAdapter
{
  public aczz(FlashChatPanel paramFlashChatPanel) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ((QQViewPager)paramViewGroup).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    FlashChatTextEffectView localFlashChatTextEffectView;
    if (paramInt == 0) {
      localFlashChatTextEffectView = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[0];
    }
    for (;;)
    {
      if (localFlashChatTextEffectView != null)
      {
        ViewParent localViewParent = this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localFlashChatTextEffectView);
        }
        paramViewGroup.addView(localFlashChatTextEffectView);
        localFlashChatTextEffectView.requestLayout();
      }
      return localFlashChatTextEffectView;
      if (paramInt == 1) {
        localFlashChatTextEffectView = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[1];
      } else {
        localFlashChatTextEffectView = null;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aczz
 * JD-Core Version:    0.7.0.1
 */