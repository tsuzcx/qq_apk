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

public class aegn
  extends RecyclerView.Adapter<aegl>
{
  private int jdField_a_of_type_Int;
  List<aegm> jdField_a_of_type_JavaUtilList;
  
  public aegn(List<aegm> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = bbyp.c();
  }
  
  private void a(int paramInt)
  {
    aegm localaegm = a(paramInt);
    if (localaegm != null) {
      if (localaegm.jdField_a_of_type_Boolean) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      if (a(localaegm, paramInt, bool)) {
        aegj.a(this.jdField_a_of_type_Aegj).c(localaegm.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public aegl a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = aegj.a(this.jdField_a_of_type_Aegj).getLayoutInflater().inflate(2131562802, paramViewGroup, false);
    return new aegl(this.jdField_a_of_type_Aegj, paramViewGroup);
  }
  
  public aegm a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (aegm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(aegl paramaegl, int paramInt)
  {
    aegm localaegm = a(paramInt);
    if (localaegm == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaegl, paramInt, getItemId(paramInt));
      return;
    }
    if (localaegm.jdField_a_of_type_Boolean)
    {
      paramaegl.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramaegl.jdField_a_of_type_ComTencentImageURLImageView, new aego(this));
      label54:
      aegj.a(this.jdField_a_of_type_Aegj, paramaegl.jdField_a_of_type_ComTencentImageURLImageView, localaegm);
      if (!localaegm.b) {
        break label142;
      }
      paramaegl.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramaegl.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramaegl.itemView.setOnClickListener(new aegq(this, paramInt));
      break;
      paramaegl.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramaegl.jdField_a_of_type_ComTencentImageURLImageView, new aegp(this));
      break label54;
      label142:
      paramaegl.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramaegl.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public void a(List<aegm> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(aegm paramaegm, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramaegm.jdField_a_of_type_Boolean = paramBoolean;
    if (paramaegm.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramaegm = a(this.jdField_a_of_type_Int);
      if (paramaegm != null)
      {
        paramaegm.jdField_a_of_type_Boolean = false;
        paramaegm.b = false;
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
 * Qualified Name:     aegn
 * JD-Core Version:    0.7.0.1
 */