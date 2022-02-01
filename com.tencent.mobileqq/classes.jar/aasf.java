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

public class aasf
  extends BaseAdapter
{
  private List<aasg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, aash> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aasg localaasg = (aasg)this.jdField_a_of_type_JavaUtilList.get(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localaasg.jdField_a_of_type_Boolean = bool;
        i += 1;
        break;
      }
    }
    notifyDataSetChanged();
  }
  
  public void a(List<aasg> paramList)
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
    aasg localaasg = (aasg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560585, paramViewGroup, false);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, DpUtil.dip2px(paramViewGroup.getContext(), 50.0F)));
      localObject = new aash();
      ((aash)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379697));
      ((aash)localObject).b = paramView.findViewById(2131380887);
      if ((localaasg != null) && (Build.VERSION.SDK_INT >= 4)) {
        paramView.setContentDescription(localaasg.jdField_a_of_type_JavaLangString);
      }
      ((aash)localObject).jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
    }
    label283:
    label293:
    label300:
    for (;;)
    {
      if ((localaasg != null) && (localObject != null) && (paramView != null))
      {
        ((aash)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localaasg.jdField_a_of_type_JavaLangString);
        TextView localTextView = ((aash)localObject).jdField_a_of_type_AndroidWidgetTextView;
        if (!localaasg.jdField_a_of_type_Boolean) {
          break label283;
        }
        i = Color.parseColor("#ffff5b84");
        label194:
        localTextView.setTextColor(i);
        localObject = ((aash)localObject).b;
        if (!localaasg.jdField_a_of_type_Boolean) {
          break label293;
        }
      }
      for (int i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        paramView.setSelected(localaasg.jdField_a_of_type_Boolean);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (aash)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          break label300;
        }
        paramView = ((aash)localObject).jdField_a_of_type_AndroidViewView;
        break;
        i = Color.parseColor("#ff878b99");
        break label194;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasf
 * JD-Core Version:    0.7.0.1
 */