import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.List;

public class adyg
  extends RecyclerView.Adapter<adye>
{
  private int jdField_a_of_type_Int;
  List<adyf> jdField_a_of_type_JavaUtilList;
  
  public adyg(List<adyf> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = azmk.c();
  }
  
  private void a(int paramInt)
  {
    adyf localadyf = a(paramInt);
    if (!localadyf.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (a(localadyf, paramInt, bool)) {
        adyd.a(this.jdField_a_of_type_Adyd).a(localadyf.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public adye a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = adyd.a(this.jdField_a_of_type_Adyd).getLayoutInflater().inflate(2131562651, paramViewGroup, false);
    return new adye(this.jdField_a_of_type_Adyd, paramViewGroup);
  }
  
  public adyf a(int paramInt)
  {
    return (adyf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(adye paramadye, int paramInt)
  {
    adyf localadyf = a(paramInt);
    if (localadyf.jdField_a_of_type_Boolean)
    {
      paramadye.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramadye.jdField_a_of_type_ComTencentImageURLImageView, new adyh(this));
      paramadye.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(azmf.c[paramInt]);
      adyd.a(this.jdField_a_of_type_Adyd, paramadye.jdField_a_of_type_ComTencentImageURLImageView, localadyf);
      if (!localadyf.b) {
        break label134;
      }
      paramadye.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramadye.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramadye.itemView.setOnClickListener(new adyj(this, paramInt));
      return;
      paramadye.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramadye.jdField_a_of_type_ComTencentImageURLImageView, new adyi(this));
      break;
      label134:
      paramadye.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramadye.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public boolean a(adyf paramadyf, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramadyf.jdField_a_of_type_Boolean = paramBoolean;
    if (paramadyf.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramadyf = a(this.jdField_a_of_type_Int);
      paramadyf.jdField_a_of_type_Boolean = false;
      paramadyf.b = false;
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyg
 * JD-Core Version:    0.7.0.1
 */