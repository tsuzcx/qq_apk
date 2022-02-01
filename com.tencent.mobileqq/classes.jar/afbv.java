import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class afbv
  extends BaseAdapter
{
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private afbv(afbj paramafbj) {}
  
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
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Afbj.a).inflate(2131559278, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131367269);
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(str, null);
        localURLDrawable.setDecodeHandler(bfol.z);
        localImageView.setImageDrawable(localURLDrawable);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 1, String.format("Url for friend gift:" + str, new Object[] { localException }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbv
 * JD-Core Version:    0.7.0.1
 */