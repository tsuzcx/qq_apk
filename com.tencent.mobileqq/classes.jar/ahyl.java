import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public class ahyl
  extends BaseAdapter
  implements View.OnClickListener
{
  public ahym a;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<ReadInJoySearchHistoryEntity> jdField_a_of_type_JavaUtilList;
  
  public ahyl(Context paramContext, List<ReadInJoySearchHistoryEntity> paramList, ahym paramahym)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    b(paramList);
    this.jdField_a_of_type_Ahym = paramahym;
  }
  
  private void b(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilList = null;
      return;
    }
    if (paramList.size() < 6)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList.subList(0, 5);
  }
  
  public void a(List<ReadInJoySearchHistoryEntity> paramList)
  {
    b(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    View localView;
    if (localObject == null)
    {
      localView = null;
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from((Context)localObject).inflate(2131559809, null);
      localObject = new ahyn(this);
      ((ahyn)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368087));
      ((ahyn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369552));
      ((ahyn)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364586));
      paramView.setTag(localObject);
      paramView.setOnClickListener(this);
      label120:
      ((ahyn)localObject).jdField_a_of_type_Int = paramInt;
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label203;
      }
      ((ahyn)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ((ahyn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((ahyn)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).keyWord);
    }
    for (;;)
    {
      localObject = paramView;
      localView = paramView;
      break;
      localObject = (ahyn)paramView.getTag();
      break label120;
      label203:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ahyn)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        ((ahyn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof ahyn))
    {
      localObject = (ahyn)paramView.getTag();
      if (((ahyn)localObject).jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label76;
      }
      if (this.jdField_a_of_type_Ahym != null)
      {
        localObject = (ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(((ahyn)localObject).jdField_a_of_type_Int);
        this.jdField_a_of_type_Ahym.a((ReadInJoySearchHistoryEntity)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label76:
      if ((((ahyn)localObject).jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_Ahym != null)) {
        this.jdField_a_of_type_Ahym.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyl
 * JD-Core Version:    0.7.0.1
 */