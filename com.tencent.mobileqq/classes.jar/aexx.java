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
import java.util.ArrayList;

public class aexx
  extends BaseAdapter
{
  public int a;
  Context a;
  public View.OnClickListener a;
  public ArrayList<bedl> a;
  public boolean a;
  public int b;
  
  public aexx(Context paramContext)
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
    Object localObject1;
    int i;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      ((LinearLayout)localObject1).setOrientation(0);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
        }
        ((LinearLayout)localObject1).addView(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560803, null), (ViewGroup.LayoutParams)localObject2);
        i += 1;
        paramView = paramViewGroup;
      }
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = (ViewGroup)paramView;
      if (paramInt == 0) {
        ((ViewGroup)localObject1).setPadding(aepi.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      int k;
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Int) {
            break label397;
          }
          k = j * paramInt + i;
          localObject2 = (ChangeVoiceView)((ViewGroup)localObject1).getChildAt(i);
          if (localObject2 != null) {
            break;
          }
          QLog.e("ChangeVoiceListAdapter", 1, "getView view == null,view=" + ((ViewGroup)localObject1).getChildAt(i));
          i += 1;
        }
        ((ViewGroup)localObject1).setPadding(aepi.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      ((ChangeVoiceView)localObject2).b = this.b;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (k < this.jdField_a_of_type_JavaUtilArrayList.size())) {}
      for (paramViewGroup = (bedl)this.jdField_a_of_type_JavaUtilArrayList.get(k);; paramViewGroup = null)
      {
        ((ChangeVoiceView)localObject2).a(paramViewGroup);
        if (this.jdField_a_of_type_Boolean) {
          ((ChangeVoiceView)localObject2).a();
        }
        if (paramViewGroup != null)
        {
          ((ChangeVoiceView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          break;
        }
        ((ChangeVoiceView)localObject2).setOnClickListener(null);
        break;
        label397:
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexx
 * JD-Core Version:    0.7.0.1
 */