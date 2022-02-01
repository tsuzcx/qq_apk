import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class akfg
  extends amoe
{
  public List<akfc> a;
  
  public akfg(List<akfc> paramList)
  {
    super(paramList.getActivity(), paramList.b, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
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
    if (ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))
    {
      akfc localakfc = (akfc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localakfc.m)) && (!TextUtils.isEmpty(localakfc.p)) && (!TextUtils.isEmpty(localakfc.g)) && (!localakfc.g.equals(localakfc.p))) {
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563043, paramViewGroup, false);
        paramView = new akfj((View)localObject1, false);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        localObject2 = (akfc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((akfj)localObject1).g.setTag(((akfc)localObject2).a);
        ((akfj)localObject1).b.setTag(((akfc)localObject2).a);
        ((akfj)localObject1).jdField_a_of_type_AndroidViewView.setTag(((akfc)localObject2).a);
        ((akfj)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        Bitmap localBitmap = a(1, ((akfc)localObject2).a);
        if (i != 1) {
          break label343;
        }
        bool = true;
        label152:
        localChatHistoryTroopMemberFragment.a((akfj)localObject1, (akfc)localObject2, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Akfe.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
            break label349;
          }
          ((akfj)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Akfs != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Akfs.a((akfj)localObject1, (akfc)localObject2);
        if (((akfj)localObject1).f.getVisibility() == 0)
        {
          i = VipUtils.d(2);
          ((akfj)localObject1).e.setMaxWidth(i);
          ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, ((akfj)localObject1).e, ((akfj)localObject1).d, ((akfc)localObject2).a, i);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563047, paramViewGroup, false);
      paramView = new akfj((View)localObject1, true);
      break;
      localObject1 = (akfj)paramView.getTag();
      break label59;
      label343:
      bool = false;
      break label152;
      label349:
      ((akfj)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfg
 * JD-Core Version:    0.7.0.1
 */