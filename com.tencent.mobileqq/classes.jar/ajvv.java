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

public class ajvv
  extends amgy
{
  public List<ajvr> a;
  
  public ajvv(List<ajvr> paramList)
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
      ajvr localajvr = (ajvr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localajvr.m)) && (!TextUtils.isEmpty(localajvr.p)) && (!TextUtils.isEmpty(localajvr.g)) && (!localajvr.g.equals(localajvr.p))) {
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562998, paramViewGroup, false);
        paramView = new ajvy((View)localObject1, false);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        localObject2 = (ajvr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((ajvy)localObject1).g.setTag(((ajvr)localObject2).a);
        ((ajvy)localObject1).b.setTag(((ajvr)localObject2).a);
        ((ajvy)localObject1).jdField_a_of_type_AndroidViewView.setTag(((ajvr)localObject2).a);
        ((ajvy)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        Bitmap localBitmap = a(1, ((ajvr)localObject2).a);
        if (i != 1) {
          break label343;
        }
        bool = true;
        label152:
        localChatHistoryTroopMemberFragment.a((ajvy)localObject1, (ajvr)localObject2, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Ajvt.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
            break label349;
          }
          ((ajvy)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Ajwh != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Ajwh.a((ajvy)localObject1, (ajvr)localObject2);
        if (((ajvy)localObject1).f.getVisibility() == 0)
        {
          i = VipUtils.d(2);
          ((ajvy)localObject1).e.setMaxWidth(i);
          ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, ((ajvy)localObject1).e, ((ajvy)localObject1).d, ((ajvr)localObject2).a, i);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563002, paramViewGroup, false);
      paramView = new ajvy((View)localObject1, true);
      break;
      localObject1 = (ajvy)paramView.getTag();
      break label59;
      label343:
      bool = false;
      break label152;
      label349:
      ((ajvy)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvv
 * JD-Core Version:    0.7.0.1
 */