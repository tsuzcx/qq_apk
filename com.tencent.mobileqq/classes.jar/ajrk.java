import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.widget.BgTextSpan;
import java.util.List;
import java.util.Set;

public class ajrk
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  
  public ajrk(List paramList, Set paramSet)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public ParagraphInfo a(int paramInt)
  {
    return (ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969937, paramViewGroup, false);
    }
    Object localObject1 = (CheckBox)localView.findViewById(2131368495);
    paramView = (TextView)localView.findViewById(2131361932);
    ((CheckBox)localObject1).setChecked(this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)));
    Object localObject2 = a(paramInt);
    localObject1 = String.format("第%d段", new Object[] { Integer.valueOf(((ParagraphInfo)localObject2).pid + 1) });
    localObject2 = new SpannableString((String)localObject1 + ((ParagraphInfo)localObject2).content_html);
    ((SpannableString)localObject2).setSpan(new BgTextSpan(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getColor(2131494269), 17, 4, 3, 12, Color.parseColor("#777777"), (String)localObject1), 0, ((String)localObject1).length(), 33);
    paramView.setText((CharSequence)localObject2);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrk
 * JD-Core Version:    0.7.0.1
 */