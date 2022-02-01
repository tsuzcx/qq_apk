import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView;

class ajhu
  implements AdapterView.OnItemLongClickListener
{
  ajhu(ajhm paramajhm) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ajhm.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Ajhl)
    {
      this.a.jdField_a_of_type_Ajhk = ((ajhk)this.a.jdField_a_of_type_Ajhl.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bgaz();
      paramAdapterView.a(2131365216, amtj.a(2131705784), 2130838962);
      paramAdapterView.a(2131367094, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bfue.a(paramView, paramAdapterView, ajhm.a(this.a), new ajhv(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Ajhw) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhu
 * JD-Core Version:    0.7.0.1
 */