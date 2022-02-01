import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afps
  extends amck
{
  private List<afpv> jdField_a_of_type_JavaUtilList;
  
  public afps(List<afpv> paramList)
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562871, paramViewGroup, false);
      paramView = new afpx(null);
      paramView.c = ((ImageView)localView.findViewById(2131369143));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379779));
      ((TextView)localView.findViewById(2131379915)).setText("");
      localView.setTag(paramView);
      localObject = (afpv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(((afpv)localObject).e)) || (((afpv)localObject).e.equals(((afpv)localObject).b))) {
        break label231;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afpv)localObject).b + "(" + ((afpv)localObject).e + ")");
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((afpv)localObject).jdField_a_of_type_JavaLangString;
      paramView.jdField_a_of_type_Afpv = ((afpv)localObject);
      paramView.c.setImageBitmap(a(1, ((afpv)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (afpx)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label231:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afpv)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afps
 * JD-Core Version:    0.7.0.1
 */