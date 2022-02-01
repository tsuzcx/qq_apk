import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class akcm
  implements AdapterView.OnItemLongClickListener
{
  akcm(akce paramakce) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Akcc.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (akcy)this.a.jdField_a_of_type_Akcc.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Akcy = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bhjq();
    paramAdapterView.a(2131365307, anvx.a(2131700782), 2130838982);
    paramAdapterView.a(2131367213, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhcw.a(paramView, paramAdapterView, akce.a(this.a), new akcn(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcm
 * JD-Core Version:    0.7.0.1
 */