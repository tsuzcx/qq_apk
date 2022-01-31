import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import java.util.List;

public class akjg<T>
  extends apoy<T>
  implements View.OnClickListener
{
  private DragSortListView a;
  
  public akjg(Context paramContext, List<T> paramList, DragSortListView paramDragSortListView)
  {
    super(paramContext, paramList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = paramDragSortListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560985, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.findViewById(2131376551).setVisibility(8);
    paramView = (TextView)paramViewGroup.findViewById(2131367344);
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView.setText(localGroups.group_name);
    ViewCompat.setImportantForAccessibility(paramViewGroup.findViewById(2131367348), 1);
    paramViewGroup.setContentDescription(localGroups.group_name + alud.a(2131705733));
    if ((bhtb.m()) && (AppSetting.c)) {
      paramViewGroup.setOnClickListener(this);
    }
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if (AppSetting.c) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjg
 * JD-Core Version:    0.7.0.1
 */