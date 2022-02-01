import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.FontSettingActivity.AioListAdapter.1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class aenp
  extends BaseAdapter
{
  public aenp(FontSettingActivity paramFontSettingActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.a.jdField_a_of_type_Aenr.a(paramInt, getCount(), (ChatMessage)this.a.jdField_a_of_type_JavaUtilList.get(paramInt), paramView, paramViewGroup, null);
    ahtx localahtx = (ahtx)localView.getTag();
    localahtx.d.setOnClickListener(null);
    if ((localahtx.d instanceof AnimationTextView)) {
      ((AnimationTextView)localahtx.d).onDoubleClick = null;
    }
    if ((FontSettingActivity.a(this.a)) && (paramInt == this.a.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.a();
    }
    if ((this.a.c) && (paramInt == this.a.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      this.a.c = false;
      FontSettingActivity.a(this.a).postDelayed(new FontSettingActivity.AioListAdapter.1(this), 100L);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenp
 * JD-Core Version:    0.7.0.1
 */