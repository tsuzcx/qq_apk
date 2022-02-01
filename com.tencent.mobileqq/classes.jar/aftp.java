import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aftp
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<ahvd> jdField_a_of_type_JavaUtilArrayList;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList<ahvd> paramArrayList)
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
    Object localObject1 = BaseApplication.getContext();
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131558903, null);
      paramView = new aftq();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368525));
      paramView.b = ((ImageView)((View)localObject1).findViewById(2131366927));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378673));
      ((View)localObject1).setTag(paramView);
      localObject2 = (ahvd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ahvd)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((ahvd)localObject2).jdField_a_of_type_JavaLangString);
      if (!((ahvd)localObject2).jdField_a_of_type_Boolean) {
        break label195;
      }
      paramView.b.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_Int = ((ahvd)localObject2).jdField_a_of_type_Int;
      ((View)localObject1).setContentDescription(((ahvd)localObject2).b);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (aftq)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label195:
      paramView.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftp
 * JD-Core Version:    0.7.0.1
 */