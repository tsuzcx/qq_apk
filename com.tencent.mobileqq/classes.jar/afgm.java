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

public class afgm
  extends amgy
{
  public List<afgi> a;
  
  public afgm(List<afgi> paramList)
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
      afgi localafgi = (afgi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localafgi.m)) && (!TextUtils.isEmpty(localafgi.p)) && (!TextUtils.isEmpty(localafgi.g)) && (!localafgi.g.equals(localafgi.p))) {
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562998, paramViewGroup, false);
        paramView = new afgp((View)localObject1, false);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        localObject2 = (afgi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((afgp)localObject1).g.setTag(((afgi)localObject2).a);
        ((afgp)localObject1).b.setTag(((afgi)localObject2).a);
        ((afgp)localObject1).jdField_a_of_type_AndroidViewView.setTag(((afgi)localObject2).a);
        ((afgp)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
        Bitmap localBitmap = a(1, ((afgi)localObject2).a);
        if (i != 1) {
          break label343;
        }
        bool = true;
        label152:
        localTroopMemberListActivity.a((afgp)localObject1, (afgi)localObject2, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Afgk.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
            break label349;
          }
          ((afgp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Bbcg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Bbcg.a((afgp)localObject1, (afgi)localObject2);
        if (((afgp)localObject1).f.getVisibility() == 0)
        {
          i = VipUtils.d(2);
          ((afgp)localObject1).e.setMaxWidth(i);
          TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, ((afgp)localObject1).e, ((afgp)localObject1).d, ((afgi)localObject2).a, i);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563002, paramViewGroup, false);
      paramView = new afgp((View)localObject1, true);
      break;
      localObject1 = (afgp)paramView.getTag();
      break label59;
      label343:
      bool = false;
      break label152;
      label349:
      ((afgp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgm
 * JD-Core Version:    0.7.0.1
 */