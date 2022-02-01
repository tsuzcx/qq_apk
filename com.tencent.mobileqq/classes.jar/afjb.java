import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afjb
  extends amgy
{
  private List<afje> jdField_a_of_type_JavaUtilList;
  
  public afjb(List<afje> paramList)
  {
    super(paramList, paramList.app, paramList.b, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562855, paramViewGroup, false);
      paramView = new afjg(null);
      paramView.c = ((ImageView)localView.findViewById(2131369417));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380038));
      ((TextView)localView.findViewById(2131380172)).setText("");
      localView.setTag(paramView);
      localObject = (afje)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(((afje)localObject).e)) || (((afje)localObject).e.equals(((afje)localObject).b))) {
        break label231;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afje)localObject).b + "(" + ((afje)localObject).e + ")");
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((afje)localObject).jdField_a_of_type_JavaLangString;
      paramView.jdField_a_of_type_Afje = ((afje)localObject);
      paramView.c.setImageBitmap(a(1, ((afje)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (afjg)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label231:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afje)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjb
 * JD-Core Version:    0.7.0.1
 */