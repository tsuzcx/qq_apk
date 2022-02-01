import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView;

class akdi
  implements AdapterView.OnItemLongClickListener
{
  akdi(akda paramakda) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(akda.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Akcz)
    {
      this.a.jdField_a_of_type_Akcy = ((akcy)this.a.jdField_a_of_type_Akcz.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bhjq();
      paramAdapterView.a(2131365307, anvx.a(2131706135), 2130838982);
      paramAdapterView.a(2131367213, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhcw.a(paramView, paramAdapterView, akda.a(this.a), new akdj(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Akdk) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdi
 * JD-Core Version:    0.7.0.1
 */