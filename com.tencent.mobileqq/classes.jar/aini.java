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

public class aini<T>
  extends antc<T>
  implements View.OnClickListener
{
  private DragSortListView a;
  
  public aini(Context paramContext, List<T> paramList, DragSortListView paramDragSortListView)
  {
    super(paramContext, paramList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = paramDragSortListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560785, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.findViewById(2131375996).setVisibility(8);
    paramView = (TextView)paramViewGroup.findViewById(2131367204);
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView.setText(localGroups.group_name);
    ViewCompat.setImportantForAccessibility(paramViewGroup.findViewById(2131367208), 1);
    paramViewGroup.setContentDescription(localGroups.group_name + ajyc.a(2131705338));
    if ((bfni.n()) && (AppSetting.d)) {
      paramViewGroup.setOnClickListener(this);
    }
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if (AppSetting.d) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aini
 * JD-Core Version:    0.7.0.1
 */