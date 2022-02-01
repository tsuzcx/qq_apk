import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afwi
  extends amoe
{
  public List<afwe> a;
  
  public afwi(List<afwe> paramList)
  {
    super(paramList, paramList.app, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))
    {
      afwe localafwe = (afwe)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localafwe.m)) && (!TextUtils.isEmpty(localafwe.p)) && (!TextUtils.isEmpty(localafwe.g)) && (!localafwe.g.equals(localafwe.p))) {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    Object localObject2;
    label59:
    boolean bool;
    if (paramView == null) {
      if (i == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563043, paramViewGroup, false);
        paramView = new afwl((View)localObject1, false);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        localObject2 = (afwe)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((afwl)localObject1).g.setTag(((afwe)localObject2).a);
        ((afwl)localObject1).b.setTag(((afwe)localObject2).a);
        ((afwl)localObject1).jdField_a_of_type_AndroidViewView.setTag(((afwe)localObject2).a);
        ((afwl)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
        Bitmap localBitmap = a(1, ((afwe)localObject2).a);
        if (i != 1) {
          break label343;
        }
        bool = true;
        label152:
        localTroopMemberListActivity.a((afwl)localObject1, (afwe)localObject2, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Afwg.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
            break label349;
          }
          ((afwl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Bbbn != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Bbbn.a((afwl)localObject1, (afwe)localObject2);
        if (((afwl)localObject1).f.getVisibility() == 0)
        {
          i = VipUtils.d(2);
          ((afwl)localObject1).e.setMaxWidth(i);
          TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, ((afwl)localObject1).e, ((afwl)localObject1).d, ((afwe)localObject2).a, i);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563047, paramViewGroup, false);
      paramView = new afwl((View)localObject1, true);
      break;
      localObject1 = (afwl)paramView.getTag();
      break label59;
      label343:
      bool = false;
      break label152;
      label349:
      ((afwl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwi
 * JD-Core Version:    0.7.0.1
 */