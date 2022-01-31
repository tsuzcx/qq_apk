import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import java.util.List;

public class afoy
  extends aiab
{
  public List<afou> a;
  
  public afoy(List<afou> paramList)
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
      afou localafou = (afou)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localafou.m)) && (!TextUtils.isEmpty(localafou.p)) && (!TextUtils.isEmpty(localafou.g)) && (!localafou.g.equals(localafou.p))) {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject;
    label54:
    boolean bool;
    if (paramView == null) {
      if (i == 0)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496951, paramViewGroup, false);
        paramView = new afpb(paramViewGroup, false);
        paramViewGroup.setTag(paramView);
        localObject = paramView;
        paramView = paramViewGroup;
        paramViewGroup = (ViewGroup)localObject;
        localObject = (afou)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup.g.setTag(((afou)localObject).a);
        paramViewGroup.b.setTag(((afou)localObject).a);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((afou)localObject).a);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        Bitmap localBitmap = a(1, ((afou)localObject).a);
        if (i != 1) {
          break label307;
        }
        bool = true;
        label143:
        localChatHistoryTroopMemberFragment.a(paramViewGroup, (afou)localObject, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Afow.jdField_a_of_type_JavaUtilList.contains(localObject)) {
            break label313;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Afph != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Afph.a(paramViewGroup, (afou)localObject);
        if (paramViewGroup.f.getVisibility() == 0)
        {
          paramInt = bajr.d(2);
          paramViewGroup.e.setMaxWidth(paramInt);
          ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, paramViewGroup.e, paramViewGroup.d, ((afou)localObject).a, paramInt);
        }
      }
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496955, paramViewGroup, false);
      paramView = new afpb(paramViewGroup, true);
      break;
      paramViewGroup = (afpb)paramView.getTag();
      break label54;
      label307:
      bool = false;
      break label143;
      label313:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afoy
 * JD-Core Version:    0.7.0.1
 */