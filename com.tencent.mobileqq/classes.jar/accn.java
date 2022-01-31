import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.List;

public class accn
  extends RecyclerView.Adapter<accl>
{
  private int jdField_a_of_type_Int;
  List<accm> jdField_a_of_type_JavaUtilList;
  
  public accn(List<accm> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = axmt.c();
  }
  
  private void a(int paramInt)
  {
    accm localaccm = a(paramInt);
    if (!localaccm.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (a(localaccm, paramInt, bool)) {
        acck.a(this.jdField_a_of_type_Acck).a(localaccm.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public accl a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = acck.a(this.jdField_a_of_type_Acck).getLayoutInflater().inflate(2131562430, paramViewGroup, false);
    return new accl(this.jdField_a_of_type_Acck, paramViewGroup);
  }
  
  public accm a(int paramInt)
  {
    return (accm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(accl paramaccl, int paramInt)
  {
    accm localaccm = a(paramInt);
    if (localaccm.jdField_a_of_type_Boolean)
    {
      paramaccl.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramaccl.jdField_a_of_type_ComTencentImageURLImageView, new acco(this));
      paramaccl.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(axmo.c[paramInt]);
      acck.a(this.jdField_a_of_type_Acck, paramaccl.jdField_a_of_type_ComTencentImageURLImageView, localaccm);
      if (!localaccm.b) {
        break label134;
      }
      paramaccl.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramaccl.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramaccl.itemView.setOnClickListener(new accq(this, paramInt));
      return;
      paramaccl.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramaccl.jdField_a_of_type_ComTencentImageURLImageView, new accp(this));
      break;
      label134:
      paramaccl.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramaccl.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public boolean a(accm paramaccm, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramaccm.jdField_a_of_type_Boolean = paramBoolean;
    if (paramaccm.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramaccm = a(this.jdField_a_of_type_Int);
      paramaccm.jdField_a_of_type_Boolean = false;
      paramaccm.b = false;
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     accn
 * JD-Core Version:    0.7.0.1
 */