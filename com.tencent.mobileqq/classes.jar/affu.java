import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.lang.ref.WeakReference;
import java.util.List;

public class affu
  extends BaseAdapter
  implements View.OnClickListener
{
  public affv a;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<ReadInJoySearchHistoryEntity> jdField_a_of_type_JavaUtilList;
  
  public affu(Context paramContext, List<ReadInJoySearchHistoryEntity> paramList, affv paramaffv)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    b(paramList);
    this.jdField_a_of_type_Affv = paramaffv;
  }
  
  private void b(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilList = null;
      return;
    }
    if (paramList.size() < 6)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList.subList(0, 5);
  }
  
  public void a(List<ReadInJoySearchHistoryEntity> paramList)
  {
    b(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    View localView;
    if (paramViewGroup == null) {
      localView = null;
    }
    do
    {
      return localView;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup).inflate(2131559612, null);
        paramViewGroup = new affw(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367534));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368842));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364240));
        paramView.setTag(paramViewGroup);
        paramView.setOnClickListener(this);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).keyWord);
        return paramView;
        paramViewGroup = (affw)paramView.getTag();
      }
      localView = paramView;
    } while (paramInt != this.jdField_a_of_type_JavaUtilList.size());
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof affw))
    {
      paramView = (affw)paramView.getTag();
      if (paramView.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label69;
      }
      if (this.jdField_a_of_type_Affv != null)
      {
        paramView = (ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramView.jdField_a_of_type_Int);
        this.jdField_a_of_type_Affv.a(paramView);
      }
    }
    label69:
    while ((paramView.jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_Affv == null)) {
      return;
    }
    this.jdField_a_of_type_Affv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affu
 * JD-Core Version:    0.7.0.1
 */