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

public class afer
  extends RecyclerView.Adapter<afep>
{
  private int jdField_a_of_type_Int;
  List<afeq> jdField_a_of_type_JavaUtilList;
  
  public afer(List<afeq> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = bcnj.c();
  }
  
  private void a(int paramInt)
  {
    afeq localafeq = a(paramInt);
    if (localafeq != null) {
      if (localafeq.jdField_a_of_type_Boolean) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      if (a(localafeq, paramInt, bool)) {
        afen.a(this.jdField_a_of_type_Afen).a(localafeq.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public afep a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = afen.a(this.jdField_a_of_type_Afen).getLayoutInflater().inflate(2131562889, paramViewGroup, false);
    return new afep(this.jdField_a_of_type_Afen, paramViewGroup);
  }
  
  public afeq a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (afeq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(afep paramafep, int paramInt)
  {
    afeq localafeq = a(paramInt);
    if (localafeq == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramafep, paramInt, getItemId(paramInt));
      return;
    }
    if (localafeq.jdField_a_of_type_Boolean)
    {
      paramafep.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramafep.jdField_a_of_type_ComTencentImageURLImageView, new afes(this));
      label54:
      afen.a(this.jdField_a_of_type_Afen, paramafep.jdField_a_of_type_ComTencentImageURLImageView, localafeq);
      if (!localafeq.b) {
        break label142;
      }
      paramafep.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramafep.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramafep.itemView.setOnClickListener(new afeu(this, paramInt));
      break;
      paramafep.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramafep.jdField_a_of_type_ComTencentImageURLImageView, new afet(this));
      break label54;
      label142:
      paramafep.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramafep.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public void a(List<afeq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(afeq paramafeq, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramafeq.jdField_a_of_type_Boolean = paramBoolean;
    if (paramafeq.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramafeq = a(this.jdField_a_of_type_Int);
      if (paramafeq != null)
      {
        paramafeq.jdField_a_of_type_Boolean = false;
        paramafeq.b = false;
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
 * Qualified Name:     afer
 * JD-Core Version:    0.7.0.1
 */