import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.List;

public class ajls
  extends RecyclerView.Adapter<ajlu>
{
  private int jdField_a_of_type_Int;
  PaintDrawable jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ajls(QQAppInterface paramQQAppInterface, List<Object> paramList, PaintDrawable paramPaintDrawable, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable = paramPaintDrawable;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ajlu a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ajlu(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131559903, null));
  }
  
  public void a(ajlu paramajlu, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!(localObject instanceof ajbi)) {
        break label113;
      }
      localObject = (ajbi)localObject;
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((ajbi)localObject).a());
      paramajlu.a.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable != null)
      {
        if (paramInt != this.jdField_a_of_type_Int - 1) {
          break label190;
        }
        paramajlu.b.setVisibility(0);
        paramajlu.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramajlu, paramInt, getItemId(paramInt));
      return;
      label113:
      if ((localObject instanceof PhoneContact))
      {
        localObject = (PhoneContact)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, ((PhoneContact)localObject).unifiedCode);
        paramajlu.a.setImageDrawable((Drawable)localObject);
        break;
      }
      if (!(localObject instanceof ajbh)) {
        break;
      }
      localObject = (ajbh)localObject;
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, ((ajbh)localObject).a.unifiedCode);
      paramajlu.a.setImageDrawable((Drawable)localObject);
      break;
      label190:
      paramajlu.b.setVisibility(8);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int - 1);
        notifyItemRemoved(this.jdField_a_of_type_Int - 1);
      }
      this.jdField_a_of_type_JavaUtilList.add(0, paramObject);
      notifyItemInserted(0);
      if (this.jdField_a_of_type_JavaUtilList.size() == this.jdField_a_of_type_Int) {
        notifyItemChanged(this.jdField_a_of_type_Int - 1);
      }
    }
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramList.size() <= this.jdField_a_of_type_Int) {
        break label52;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, this.jdField_a_of_type_Int));
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label52:
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajls
 * JD-Core Version:    0.7.0.1
 */