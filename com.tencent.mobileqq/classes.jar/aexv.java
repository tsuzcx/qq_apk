import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aexv
  extends RecyclerView.Adapter<aext>
{
  private int jdField_a_of_type_Int;
  List<aexu> jdField_a_of_type_JavaUtilList;
  
  public aexv(List<aexu> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = bdfk.c();
  }
  
  private void a(int paramInt)
  {
    aexu localaexu = a(paramInt);
    if (localaexu != null) {
      if (localaexu.jdField_a_of_type_Boolean) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      if (a(localaexu, paramInt, bool)) {
        aexr.a(this.jdField_a_of_type_Aexr).c(localaexu.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public aext a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = aexr.a(this.jdField_a_of_type_Aexr).getLayoutInflater().inflate(2131562873, paramViewGroup, false);
    return new aext(this.jdField_a_of_type_Aexr, paramViewGroup);
  }
  
  public aexu a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (aexu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(aext paramaext, int paramInt)
  {
    aexu localaexu = a(paramInt);
    if (localaexu == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaext, paramInt, getItemId(paramInt));
      return;
    }
    if (localaexu.jdField_a_of_type_Boolean)
    {
      paramaext.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramaext.jdField_a_of_type_ComTencentImageURLImageView, new aexw(this));
      label54:
      aexr.a(this.jdField_a_of_type_Aexr, paramaext.jdField_a_of_type_ComTencentImageURLImageView, localaexu);
      if (!localaexu.b) {
        break label142;
      }
      paramaext.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramaext.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramaext.itemView.setOnClickListener(new aexy(this, paramInt));
      break;
      paramaext.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramaext.jdField_a_of_type_ComTencentImageURLImageView, new aexx(this));
      break label54;
      label142:
      paramaext.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramaext.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public void a(List<aexu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(aexu paramaexu, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramaexu.jdField_a_of_type_Boolean = paramBoolean;
    if (paramaexu.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramaexu = a(this.jdField_a_of_type_Int);
      if (paramaexu != null)
      {
        paramaexu.jdField_a_of_type_Boolean = false;
        paramaexu.b = false;
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexv
 * JD-Core Version:    0.7.0.1
 */