import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class acna
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<acmz> jdField_a_of_type_JavaUtilArrayList;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList<acmz> paramArrayList)
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
    acmz localacmz;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup).inflate(2131493206, null);
      paramViewGroup = new acnb();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302182));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131300748));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311234));
      paramView.setTag(paramViewGroup);
      localacmz = (acmz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localacmz.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacmz.jdField_a_of_type_JavaLangString);
      if (!localacmz.jdField_a_of_type_Boolean) {
        break label163;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = localacmz.jdField_a_of_type_Int;
      paramView.setContentDescription(localacmz.b);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (acnb)paramView.getTag();
      break;
      label163:
      paramViewGroup.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acna
 * JD-Core Version:    0.7.0.1
 */