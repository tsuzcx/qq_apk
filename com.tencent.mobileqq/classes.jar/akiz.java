import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class akiz
  implements bljn
{
  akiz(akir paramakir) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Akip.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (akjl)this.a.jdField_a_of_type_Akip.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Akjl = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bhuk();
    paramAdapterView.a(2131365191, anzj.a(2131700196), 2130838930);
    paramAdapterView.a(2131367078, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhkx.a(paramView, paramAdapterView, akir.a(this.a), new akja(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akiz
 * JD-Core Version:    0.7.0.1
 */