import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class akko
  implements bljn
{
  akko(akkg paramakkg) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Akge.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (akjl)this.a.jdField_a_of_type_Akge.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Akjl = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bhuk();
    paramAdapterView.a(2131365191, anzj.a(2131713966), 2130838930);
    paramAdapterView.a(2131367078, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhkx.a(paramView, paramAdapterView, akkg.a(this.a), new akkp(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akko
 * JD-Core Version:    0.7.0.1
 */