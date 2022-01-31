import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.List;

public class accj
  extends RecyclerView.Adapter<acch>
{
  private int jdField_a_of_type_Int;
  List<acci> jdField_a_of_type_JavaUtilList;
  
  public accj(List<acci> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = axmv.c();
  }
  
  private void a(int paramInt)
  {
    acci localacci = a(paramInt);
    if (!localacci.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (a(localacci, paramInt, bool)) {
        accg.a(this.jdField_a_of_type_Accg).a(localacci.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public acch a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = accg.a(this.jdField_a_of_type_Accg).getLayoutInflater().inflate(2131562429, paramViewGroup, false);
    return new acch(this.jdField_a_of_type_Accg, paramViewGroup);
  }
  
  public acci a(int paramInt)
  {
    return (acci)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(acch paramacch, int paramInt)
  {
    acci localacci = a(paramInt);
    if (localacci.jdField_a_of_type_Boolean)
    {
      paramacch.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramacch.jdField_a_of_type_ComTencentImageURLImageView, new acck(this));
      paramacch.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(axmq.c[paramInt]);
      accg.a(this.jdField_a_of_type_Accg, paramacch.jdField_a_of_type_ComTencentImageURLImageView, localacci);
      if (!localacci.b) {
        break label134;
      }
      paramacch.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramacch.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramacch.itemView.setOnClickListener(new accm(this, paramInt));
      return;
      paramacch.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramacch.jdField_a_of_type_ComTencentImageURLImageView, new accl(this));
      break;
      label134:
      paramacch.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramacch.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public boolean a(acci paramacci, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramacci.jdField_a_of_type_Boolean = paramBoolean;
    if (paramacci.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramacci = a(this.jdField_a_of_type_Int);
      paramacci.jdField_a_of_type_Boolean = false;
      paramacci.b = false;
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     accj
 * JD-Core Version:    0.7.0.1
 */