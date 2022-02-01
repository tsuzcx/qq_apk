import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.TabAdapter.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public abstract class abei<T>
  extends BaseAdapter
{
  protected Context a;
  public TabLayout a;
  protected List<T> a;
  
  public abei(Context paramContext, List<T> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected abstract int a();
  
  protected abstract void a(abej paramabej, T paramT, int paramInt);
  
  public void a(TabLayout paramTabLayout)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = paramTabLayout;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
    Object localObject1 = null;
    Object localObject2;
    if (paramInt < getCount() - 1)
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt);
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(a(), paramViewGroup, false);
        paramView.post(new TabLayout.TabAdapter.1(this, paramInt, paramView));
      }
      localObject2 = new abej(paramView, null);
      paramView.setTranslationX(0.0F);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        localObject1 = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
      a((abej)localObject2, localObject1, paramInt);
      localObject1 = paramView;
      localObject2 = localObject1;
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560208, paramViewGroup, false);
      paramView = (View)localObject1;
      localObject2 = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abei
 * JD-Core Version:    0.7.0.1
 */