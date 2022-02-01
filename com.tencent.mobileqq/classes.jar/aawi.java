import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aawi
  extends BaseAdapter
{
  private List<aawj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, aawk> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aawj localaawj = (aawj)this.jdField_a_of_type_JavaUtilList.get(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localaawj.jdField_a_of_type_Boolean = bool;
        i += 1;
        break;
      }
    }
    notifyDataSetChanged();
  }
  
  public void a(List<aawj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aawj localaawj = (aawj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560600, paramViewGroup, false);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, DpUtil.dip2px(paramViewGroup.getContext(), 50.0F)));
      localObject = new aawk();
      ((aawk)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379875));
      ((aawk)localObject).b = paramView.findViewById(2131381067);
      if ((localaawj != null) && (Build.VERSION.SDK_INT >= 4)) {
        paramView.setContentDescription(localaawj.jdField_a_of_type_JavaLangString);
      }
      ((aawk)localObject).jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
    }
    label283:
    label293:
    label300:
    for (;;)
    {
      if ((localaawj != null) && (localObject != null) && (paramView != null))
      {
        ((aawk)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localaawj.jdField_a_of_type_JavaLangString);
        TextView localTextView = ((aawk)localObject).jdField_a_of_type_AndroidWidgetTextView;
        if (!localaawj.jdField_a_of_type_Boolean) {
          break label283;
        }
        i = Color.parseColor("#ffff5b84");
        label194:
        localTextView.setTextColor(i);
        localObject = ((aawk)localObject).b;
        if (!localaawj.jdField_a_of_type_Boolean) {
          break label293;
        }
      }
      for (int i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        paramView.setSelected(localaawj.jdField_a_of_type_Boolean);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (aawk)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          break label300;
        }
        paramView = ((aawk)localObject).jdField_a_of_type_AndroidViewView;
        break;
        i = Color.parseColor("#ff878b99");
        break label194;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawi
 * JD-Core Version:    0.7.0.1
 */