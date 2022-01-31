import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.List;

public class adtr
  extends RecyclerView.Adapter<adtp>
{
  private int jdField_a_of_type_Int;
  List<adtq> jdField_a_of_type_JavaUtilList;
  
  public adtr(List<adtq> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = azib.c();
  }
  
  private void a(int paramInt)
  {
    adtq localadtq = a(paramInt);
    if (!localadtq.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (a(localadtq, paramInt, bool)) {
        adto.a(this.jdField_a_of_type_Adto).a(localadtq.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public adtp a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = adto.a(this.jdField_a_of_type_Adto).getLayoutInflater().inflate(2131562633, paramViewGroup, false);
    return new adtp(this.jdField_a_of_type_Adto, paramViewGroup);
  }
  
  public adtq a(int paramInt)
  {
    return (adtq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(adtp paramadtp, int paramInt)
  {
    adtq localadtq = a(paramInt);
    if (localadtq.jdField_a_of_type_Boolean)
    {
      paramadtp.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramadtp.jdField_a_of_type_ComTencentImageURLImageView, new adts(this));
      paramadtp.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(azhw.c[paramInt]);
      adto.a(this.jdField_a_of_type_Adto, paramadtp.jdField_a_of_type_ComTencentImageURLImageView, localadtq);
      if (!localadtq.b) {
        break label134;
      }
      paramadtp.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramadtp.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramadtp.itemView.setOnClickListener(new adtu(this, paramInt));
      return;
      paramadtp.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramadtp.jdField_a_of_type_ComTencentImageURLImageView, new adtt(this));
      break;
      label134:
      paramadtp.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramadtp.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public boolean a(adtq paramadtq, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramadtq.jdField_a_of_type_Boolean = paramBoolean;
    if (paramadtq.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramadtq = a(this.jdField_a_of_type_Int);
      paramadtq.jdField_a_of_type_Boolean = false;
      paramadtq.b = false;
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtr
 * JD-Core Version:    0.7.0.1
 */