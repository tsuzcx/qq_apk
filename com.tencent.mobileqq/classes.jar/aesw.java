import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aesw
  extends BaseAdapter
{
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private aesw(aesk paramaesk) {}
  
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_Aesk.a).inflate(2131559193, null);
    }
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131366927);
    paramView = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramView, null);
      localURLDrawable.setDecodeHandler(bcyz.y);
      localImageView.setImageDrawable(localURLDrawable);
      return paramViewGroup;
    }
    catch (Exception localException)
    {
      QLog.e("intimate_relationship", 1, String.format("Url for friend gift:" + paramView, new Object[] { localException }));
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */