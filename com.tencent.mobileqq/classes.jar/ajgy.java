import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class ajgy
  implements AdapterView.OnItemLongClickListener
{
  ajgy(ajgq paramajgq) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Ajgo.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (ajhk)this.a.jdField_a_of_type_Ajgo.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Ajhk = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bgaz();
    paramAdapterView.a(2131365216, amtj.a(2131700431), 2130838962);
    paramAdapterView.a(2131367094, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bfue.a(paramView, paramAdapterView, ajgq.a(this.a), new ajgz(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgy
 * JD-Core Version:    0.7.0.1
 */