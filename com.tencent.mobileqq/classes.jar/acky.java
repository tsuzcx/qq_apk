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
import java.util.List;

public class acky
  extends aims
{
  public List<acku> a;
  
  public acky(List<acku> paramList)
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
      acku localacku = (acku)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localacku.m)) && (!TextUtils.isEmpty(localacku.p)) && (!TextUtils.isEmpty(localacku.g)) && (!localacku.g.equals(localacku.p))) {
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
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562550, paramViewGroup, false);
        paramView = new aclb(paramViewGroup, false);
        paramViewGroup.setTag(paramView);
        localObject = paramView;
        paramView = paramViewGroup;
        paramViewGroup = (ViewGroup)localObject;
        localObject = (acku)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup.g.setTag(((acku)localObject).a);
        paramViewGroup.b.setTag(((acku)localObject).a);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((acku)localObject).a);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
        Bitmap localBitmap = a(1, ((acku)localObject).a);
        if (i != 1) {
          break label307;
        }
        bool = true;
        label143:
        localTroopMemberListActivity.a(paramViewGroup, (acku)localObject, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Ackw.jdField_a_of_type_JavaUtilList.contains(localObject)) {
            break label313;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Ajry != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Ajry.a(paramViewGroup, (acku)localObject);
        if (paramViewGroup.f.getVisibility() == 0)
        {
          paramInt = VipUtils.d(2);
          paramViewGroup.e.setMaxWidth(paramInt);
          TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, paramViewGroup.e, paramViewGroup.d, ((acku)localObject).a, paramInt);
        }
      }
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562554, paramViewGroup, false);
      paramView = new aclb(paramViewGroup, true);
      break;
      paramViewGroup = (aclb)paramView.getTag();
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
 * Qualified Name:     acky
 * JD-Core Version:    0.7.0.1
 */