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

public class afnv
  extends RecyclerView.Adapter<afnt>
{
  private int jdField_a_of_type_Int;
  List<afnu> jdField_a_of_type_JavaUtilList;
  
  public afnv(List<afnu> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = bdgb.c();
  }
  
  private void a(int paramInt)
  {
    afnu localafnu = a(paramInt);
    if (localafnu != null) {
      if (localafnu.jdField_a_of_type_Boolean) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      if (a(localafnu, paramInt, bool)) {
        afnr.a(this.jdField_a_of_type_Afnr).a(localafnu.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public afnt a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = afnr.a(this.jdField_a_of_type_Afnr).getLayoutInflater().inflate(2131562923, paramViewGroup, false);
    return new afnt(this.jdField_a_of_type_Afnr, paramViewGroup);
  }
  
  public afnu a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (afnu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(afnt paramafnt, int paramInt)
  {
    afnu localafnu = a(paramInt);
    if (localafnu == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramafnt, paramInt, getItemId(paramInt));
      return;
    }
    if (localafnu.jdField_a_of_type_Boolean)
    {
      paramafnt.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramafnt.jdField_a_of_type_ComTencentImageURLImageView, new afnw(this));
      label54:
      afnr.a(this.jdField_a_of_type_Afnr, paramafnt.jdField_a_of_type_ComTencentImageURLImageView, localafnu);
      if (!localafnu.b) {
        break label142;
      }
      paramafnt.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramafnt.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramafnt.itemView.setOnClickListener(new afny(this, paramInt));
      break;
      paramafnt.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramafnt.jdField_a_of_type_ComTencentImageURLImageView, new afnx(this));
      break label54;
      label142:
      paramafnt.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramafnt.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public void a(List<afnu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(afnu paramafnu, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramafnu.jdField_a_of_type_Boolean = paramBoolean;
    if (paramafnu.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramafnu = a(this.jdField_a_of_type_Int);
      if (paramafnu != null)
      {
        paramafnu.jdField_a_of_type_Boolean = false;
        paramafnu.b = false;
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
 * Qualified Name:     afnv
 * JD-Core Version:    0.7.0.1
 */