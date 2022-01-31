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

public class ahoz
  extends ahnw
{
  private int jdField_a_of_type_Int = 2131562328;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    if (paramView == null)
    {
      paramViewGroup = new ahpa();
      paramView = a(paramContext, this.jdField_a_of_type_Int, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374969));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374957));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374967));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131374956));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368718));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378405));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)paramView.findViewById(2131378125));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363569));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)paramView.findViewById(2131363053));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131363060));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setSupportMaskView(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      paramViewGroup.b.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewGroup);
      paramView.setTag(paramViewGroup);
      paramOnLongClickListener = (RecentItemRecommendTroopData)paramObject;
      paramViewGroup.a(paramOnLongClickListener, paramahnr);
      a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.b.setTag(-1, Integer.valueOf(paramInt));
      paramahnr = null;
      paramObject = paramahnr;
      if (paramOnLongClickListener.mUser != null)
      {
        paramObject = paramahnr;
        if ((paramOnLongClickListener.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
          paramObject = (RecentRecommendTroopItem)paramOnLongClickListener.mUser.extraInfo;
        }
      }
      if (paramObject != null) {
        break label437;
      }
      paramahnr = "";
      label358:
      if (paramObject != null) {
        break label445;
      }
    }
    label437:
    label445:
    for (paramObject = "";; paramObject = paramObject.recomAlgol)
    {
      axqy.b(null, "dc00899", "Grp_recom", "", "msg_tab", "exp_grp", 0, 0, paramahnr, paramObject, "", "");
      if (akaa.e)
      {
        axqy.b(null, "dc00899", "Grp_recom", "", "msg_tab", "exp", 0, 0, "", "", "", "");
        akaa.e = false;
      }
      return paramView;
      paramViewGroup = (ahpa)paramView.getTag();
      break;
      paramahnr = paramObject.uin;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahoz
 * JD-Core Version:    0.7.0.1
 */