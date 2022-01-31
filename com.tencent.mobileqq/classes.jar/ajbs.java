import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopSearchResultDialog;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.SearchResult;
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.List;

public class ajbs
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList;
  
  public ajbs(NewTroopSearchResultDialog paramNewTroopSearchResultDialog, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    TroopSearchLogic.SearchResult localSearchResult;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog.getContext()).inflate(2130969881, null);
      paramViewGroup = new ajbt(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362754));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364975));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363201));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365554);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog);
      paramView.setTag(paramViewGroup);
      localSearchResult = (TroopSearchLogic.SearchResult)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localSearchResult.a.getTroopName());
      if (localSearchResult.a.lastMsgTime == 0L) {
        break label267;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText("最近活跃：" + TimeManager.a().a(localSearchResult.a.troopuin, localSearchResult.a.lastMsgTime));
      label188:
      if (!localSearchResult.a.hasSetTroopHead()) {
        break label350;
      }
    }
    label267:
    label350:
    for (paramInt = 4;; paramInt = 113)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog.a, paramInt, localSearchResult.a.troopuin, 3, FaceDrawable.a(4, 3), FaceDrawable.a(4, 3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      paramViewGroup.jdField_a_of_type_JavaLangString = localSearchResult.a.troopuin;
      return paramView;
      paramViewGroup = (ajbt)paramView.getTag();
      break;
      if (localSearchResult.a.troopCreateTime != 0L)
      {
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.b.setText("建群时间：" + TimeManager.a().a(localSearchResult.a.troopuin, localSearchResult.a.troopCreateTime));
        break label188;
      }
      paramViewGroup.b.setVisibility(8);
      break label188;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbs
 * JD-Core Version:    0.7.0.1
 */