import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class alow
  extends alnt
{
  private int jdField_a_of_type_Int = 2131562822;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    if (paramView == null)
    {
      paramViewGroup = new alox();
      paramView = a(paramContext, this.jdField_a_of_type_Int, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376354));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376342));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376352));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131376341));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369423));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131380170));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)paramView.findViewById(2131379776));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363840));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)paramView.findViewById(2131363302));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131363309));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setSupportMaskView(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      paramViewGroup.b.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewGroup);
      paramView.setTag(paramViewGroup);
      paramOnLongClickListener = (RecentItemRecommendTroopData)paramObject;
      paramViewGroup.a(paramOnLongClickListener, paramalno);
      a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.b.setTag(-1, Integer.valueOf(paramInt));
      paramalno = null;
      paramObject = paramalno;
      if (paramOnLongClickListener.mUser != null)
      {
        paramObject = paramalno;
        if ((paramOnLongClickListener.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
          paramObject = (RecentRecommendTroopItem)paramOnLongClickListener.mUser.extraInfo;
        }
      }
      if (paramObject != null) {
        break label437;
      }
      paramalno = "";
      label358:
      if (paramObject != null) {
        break label445;
      }
    }
    label437:
    label445:
    for (paramObject = "";; paramObject = paramObject.recomAlgol)
    {
      bdll.b(null, "dc00899", "Grp_recom", "", "msg_tab", "exp_grp", 0, 0, paramalno, paramObject, "", "");
      if (aobl.e)
      {
        bdll.b(null, "dc00899", "Grp_recom", "", "msg_tab", "exp", 0, 0, "", "", "", "");
        aobl.e = false;
      }
      return paramView;
      paramViewGroup = (alox)paramView.getTag();
      break;
      paramalno = paramObject.uin;
      break label358;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alow
 * JD-Core Version:    0.7.0.1
 */