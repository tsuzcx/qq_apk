import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class akjv
  implements bljn
{
  akjv(akjn paramakjn) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(akjn.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Akjm)
    {
      this.a.jdField_a_of_type_Akjl = ((akjl)this.a.jdField_a_of_type_Akjm.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bhuk();
      paramAdapterView.a(2131365191, anzj.a(2131705554), 2130838930);
      paramAdapterView.a(2131367078, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhkx.a(paramView, paramAdapterView, akjn.a(this.a), new akjw(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Akjx) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjv
 * JD-Core Version:    0.7.0.1
 */