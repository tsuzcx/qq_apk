import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgGroupElement;
import com.tencent.mobileqq.structmsg.StructMsgGroupItemElement;
import java.util.List;

public class aiih
  implements View.OnClickListener
{
  public aiih(StructMsgGroupElement paramStructMsgGroupElement) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = Integer.parseInt(String.valueOf(paramView.getTag()));
        i = 0;
        if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramView = (View)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (paramView == null) {
          break label156;
        }
        if (i != j)
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)this.a.jdField_a_of_type_JavaUtilList.get(i);
          if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgGroupItemElement))) {
            ((StructMsgGroupItemElement)localAbsStructMsgElement).a();
          } else {
            paramView.setVisibility(8);
          }
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView = (AbsStructMsgElement)this.a.jdField_a_of_type_JavaUtilList.get(i);
      if ((paramView != null) && ((paramView instanceof StructMsgGroupItemElement))) {
        ((StructMsgGroupItemElement)paramView).b();
      }
      label156:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiih
 * JD-Core Version:    0.7.0.1
 */