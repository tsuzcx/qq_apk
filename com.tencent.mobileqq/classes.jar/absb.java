import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.List;

public class absb
  extends RecyclerView.Adapter<abrz>
{
  private int jdField_a_of_type_Int;
  List<absa> jdField_a_of_type_JavaUtilList;
  
  public absb(List<absa> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = awnu.c();
  }
  
  private void a(int paramInt)
  {
    absa localabsa = a(paramInt);
    if (!localabsa.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (a(localabsa, paramInt, bool)) {
        abry.a(this.jdField_a_of_type_Abry).a(localabsa.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public abrz a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = abry.a(this.jdField_a_of_type_Abry).getLayoutInflater().inflate(2131496830, paramViewGroup, false);
    return new abrz(this.jdField_a_of_type_Abry, paramViewGroup);
  }
  
  public absa a(int paramInt)
  {
    return (absa)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(abrz paramabrz, int paramInt)
  {
    absa localabsa = a(paramInt);
    if (localabsa.jdField_a_of_type_Boolean)
    {
      paramabrz.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramabrz.jdField_a_of_type_ComTencentImageURLImageView, new absc(this));
      paramabrz.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(awnp.c[paramInt]);
      abry.a(this.jdField_a_of_type_Abry, paramabrz.jdField_a_of_type_ComTencentImageURLImageView, localabsa);
      if (!localabsa.b) {
        break label134;
      }
      paramabrz.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramabrz.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramabrz.itemView.setOnClickListener(new abse(this, paramInt));
      return;
      paramabrz.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramabrz.jdField_a_of_type_ComTencentImageURLImageView, new absd(this));
      break;
      label134:
      paramabrz.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramabrz.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public boolean a(absa paramabsa, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramabsa.jdField_a_of_type_Boolean = paramBoolean;
    if (paramabsa.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramabsa = a(this.jdField_a_of_type_Int);
      paramabsa.jdField_a_of_type_Boolean = false;
      paramabsa.b = false;
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     absb
 * JD-Core Version:    0.7.0.1
 */