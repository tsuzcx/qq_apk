import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class agej
  extends BaseAdapter
{
  public int a;
  Context a;
  public View.OnClickListener a;
  public ArrayList<bhkn> a;
  public boolean a;
  public int b;
  
  public agej(Context paramContext)
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int - 1) / this.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = this.jdField_a_of_type_Int;
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      ((LinearLayout)localObject2).setOrientation(0);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
        }
        ((LinearLayout)localObject2).addView(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561007, null), (ViewGroup.LayoutParams)localObject3);
        i += 1;
        paramView = (View)localObject1;
      }
      paramView = (View)localObject2;
    }
    for (;;)
    {
      localObject2 = (ViewGroup)paramView;
      if (paramInt == 0) {
        ((ViewGroup)localObject2).setPadding(afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      int k;
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Int) {
            break label403;
          }
          k = j * paramInt + i;
          localObject3 = (ChangeVoiceView)((ViewGroup)localObject2).getChildAt(i);
          if (localObject3 != null) {
            break;
          }
          QLog.e("ChangeVoiceListAdapter", 1, "getView view == null,view=" + ((ViewGroup)localObject2).getChildAt(i));
          i += 1;
        }
        ((ViewGroup)localObject2).setPadding(afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      ((ChangeVoiceView)localObject3).b = this.b;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (k < this.jdField_a_of_type_JavaUtilArrayList.size())) {}
      for (localObject1 = (bhkn)this.jdField_a_of_type_JavaUtilArrayList.get(k);; localObject1 = null)
      {
        ((ChangeVoiceView)localObject3).a((bhkn)localObject1);
        if (this.jdField_a_of_type_Boolean) {
          ((ChangeVoiceView)localObject3).a();
        }
        if (localObject1 != null)
        {
          ((ChangeVoiceView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          break;
        }
        ((ChangeVoiceView)localObject3).setOnClickListener(null);
        break;
        label403:
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agej
 * JD-Core Version:    0.7.0.1
 */