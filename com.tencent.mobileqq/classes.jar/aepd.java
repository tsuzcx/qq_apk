import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class aepd
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<aepc> jdField_a_of_type_JavaUtilArrayList;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList<aepc> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
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
    paramViewGroup = BaseApplication.getContext();
    aepc localaepc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup).inflate(2131558798, null);
      paramViewGroup = new aepe();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367934));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131366463));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377567));
      paramView.setTag(paramViewGroup);
      localaepc = (aepc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaepc.jdField_a_of_type_JavaLangString);
      if (!localaepc.jdField_a_of_type_Boolean) {
        break label163;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = localaepc.jdField_a_of_type_Int;
      paramView.setContentDescription(localaepc.b);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (aepe)paramView.getTag();
      break;
      label163:
      paramViewGroup.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepd
 * JD-Core Version:    0.7.0.1
 */