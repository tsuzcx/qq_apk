import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.List;

public class abjq
  extends PinnedDividerListView.DividerAdapter
{
  private abjq(CountrySelectActivity paramCountrySelectActivity) {}
  
  public int a()
  {
    return 2130969165;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView;
    Object localObject = getItem(paramInt);
    if ((localObject instanceof abjr)) {
      paramView.setText(((abjr)localObject).jdField_a_of_type_JavaLangString);
    }
    while (!(localObject instanceof BaseAddress)) {
      return;
    }
    paramView.setText(((BaseAddress)localObject).pinyinFirst);
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof abjr)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label281;
      }
      paramView = this.a.getLayoutInflater().inflate(a(), null);
    }
    label270:
    label281:
    for (;;)
    {
      ((TextView)paramView).setText(((abjr)getItem(paramInt)).jdField_a_of_type_JavaLangString);
      return paramView;
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2130969166, null);
        paramView = new abjs(null);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365454));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365455));
        paramViewGroup.findViewById(2131365408).setVisibility(8);
        paramViewGroup.setTag(paramView);
        paramViewGroup.setOnClickListener(this.a);
      }
      abjs localabjs = (abjs)paramViewGroup.getTag();
      BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
      localabjs.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseAddress.name);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_JavaLangString.equals(localBaseAddress.code))) {
        localabjs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        localabjs.jdField_a_of_type_JavaLangString = localBaseAddress.code;
        paramView = paramViewGroup;
        if (!CountrySelectActivity.jdField_a_of_type_Boolean) {
          break;
        }
        if (localabjs.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label270;
        }
        paramViewGroup.setContentDescription(localBaseAddress.name + "已选中");
        return paramViewGroup;
        localabjs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramViewGroup.setContentDescription(localBaseAddress.name);
      return paramViewGroup;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abjq
 * JD-Core Version:    0.7.0.1
 */