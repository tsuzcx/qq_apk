import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.NearbyPeopleCard.HiWanItem;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import java.util.ArrayList;
import java.util.List;

public class aewe
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aewe(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NearbyPeopleCard.HiWanItem localHiWanItem = (NearbyPeopleCard.HiWanItem)getItem(paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970426, paramViewGroup, false);
      paramView = new aewf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131366351));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363185));
      paramView.b = ((TextView)localView.findViewById(2131370563));
      paramView.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard$HiWanItem = localHiWanItem;
      localView.setTag(paramView);
    }
    paramView = (aewf)localView.getTag();
    paramViewGroup = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.getResources().getColor(2131493212));
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(localHiWanItem.icon, URLDrawable.URLDrawableOptions.obtain());
      if (localURLDrawable.getStatus() != 1) {
        localURLDrawable.restartDownload();
      }
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewGroup);
        continue;
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    if (localHiWanItem.status == 1)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.b.setText(localHiWanItem.title);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewe
 * JD-Core Version:    0.7.0.1
 */