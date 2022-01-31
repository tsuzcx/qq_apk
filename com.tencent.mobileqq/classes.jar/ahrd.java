import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.List;

public class ahrd
  extends RecyclerView.Adapter<ahrf>
{
  private int jdField_a_of_type_Int;
  PaintDrawable jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ahrd(QQAppInterface paramQQAppInterface, List<Object> paramList, PaintDrawable paramPaintDrawable, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable = paramPaintDrawable;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ahrf a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahrf(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131559714, null));
  }
  
  public void a(ahrf paramahrf, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!(localObject instanceof avui)) {
        break label100;
      }
      localObject = (avui)localObject;
      localObject = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((avui)localObject).a());
      paramahrf.a.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable != null)
      {
        if (paramInt != this.jdField_a_of_type_Int - 1) {
          break;
        }
        paramahrf.b.setVisibility(0);
        paramahrf.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable);
      }
      return;
      label100:
      if ((localObject instanceof PhoneContact))
      {
        localObject = (PhoneContact)localObject;
        localObject = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, ((PhoneContact)localObject).unifiedCode);
        paramahrf.a.setImageDrawable((Drawable)localObject);
      }
      else if ((localObject instanceof avuh))
      {
        localObject = (avuh)localObject;
        localObject = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, ((avuh)localObject).a.unifiedCode);
        paramahrf.a.setImageDrawable((Drawable)localObject);
      }
    }
    paramahrf.b.setVisibility(8);
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
 * Qualified Name:     ahrd
 * JD-Core Version:    0.7.0.1
 */