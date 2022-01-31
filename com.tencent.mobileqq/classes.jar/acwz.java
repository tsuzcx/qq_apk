import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import java.util.List;

class acwz
  extends BaseAdapter
{
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private acwz(acwp paramacwp) {}
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
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
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @RequiresApi(api=16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_Acwp.a).inflate(2131559151, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131366798);
    URLDrawable localURLDrawable = URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(paramInt), null);
    localURLDrawable.setDecodeHandler(bavi.y);
    paramView.setImageDrawable(localURLDrawable);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwz
 * JD-Core Version:    0.7.0.1
 */