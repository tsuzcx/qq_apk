import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class abyv
  implements AbsListView.OnScrollListener
{
  abyv(abyu paramabyu) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      if (this.a.jdField_a_of_type_Abyt.jdField_a_of_type_Int == 1) {
        EmotionPanelViewPagerAdapter.a(this.a.jdField_a_of_type_Abyt.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter, this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_a_of_type_Abyt.jdField_a_of_type_ComTencentWidgetListView);
      }
      return;
    }
    URLDrawable.pause();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abyv
 * JD-Core Version:    0.7.0.1
 */