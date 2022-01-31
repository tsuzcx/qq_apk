import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment.ContentViewHolder;
import java.util.ArrayList;
import java.util.List;

public class aisd
  extends PagerAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public aisd(HomeworkGuideFragment paramHomeworkGuideFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return HomeworkGuideFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969895, paramViewGroup, false);
    HomeworkGuideFragment.ContentViewHolder localContentViewHolder = new HomeworkGuideFragment.ContentViewHolder(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment);
    localContentViewHolder.a(paramInt, localView);
    localView.setTag(localContentViewHolder);
    HomeworkGuideFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment).add(localContentViewHolder);
    paramViewGroup.addView(localView, 0);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aisd
 * JD-Core Version:    0.7.0.1
 */