import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afyw
  extends amoe
{
  private List<afyz> jdField_a_of_type_JavaUtilList;
  
  public afyw(List<afyz> paramList)
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562905, paramViewGroup, false);
      paramView = new afzb(null);
      paramView.c = ((ImageView)localView.findViewById(2131369234));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379958));
      ((TextView)localView.findViewById(2131380098)).setText("");
      localView.setTag(paramView);
      localObject = (afyz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(((afyz)localObject).e)) || (((afyz)localObject).e.equals(((afyz)localObject).b))) {
        break label231;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afyz)localObject).b + "(" + ((afyz)localObject).e + ")");
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((afyz)localObject).jdField_a_of_type_JavaLangString;
      paramView.jdField_a_of_type_Afyz = ((afyz)localObject);
      paramView.c.setImageBitmap(a(1, ((afyz)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (afzb)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label231:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afyz)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyw
 * JD-Core Version:    0.7.0.1
 */