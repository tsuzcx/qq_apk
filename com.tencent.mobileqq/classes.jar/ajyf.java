import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajyf
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<ajyh> jdField_a_of_type_JavaUtilList;
  
  public ajyf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(List<ajyh> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new ajyi(this, null);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561986, null, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368504));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368503));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380255));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380256));
      localView.setTag(paramView);
      localObject = (ajyh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((ajyh)localObject).jdField_a_of_type_AndroidGraphicsBitmap);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((ajyh)localObject).b);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((ajyh)localObject).jdField_a_of_type_Int + anzj.a(2131703495));
      if (!((ajyh)localObject).jdField_a_of_type_Boolean) {
        break label224;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839205));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ajyi)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label224:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839207));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyf
 * JD-Core Version:    0.7.0.1
 */