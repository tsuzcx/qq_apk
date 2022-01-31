import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class aftc
  implements behj
{
  aftc(afsu paramafsu) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(afsu.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Afst)
    {
      this.a.jdField_a_of_type_Afss = ((afss)this.a.jdField_a_of_type_Afst.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bakh();
      paramAdapterView.a(2131299262, ajjy.a(2131640876), 2130838590);
      paramAdapterView.a(2131301021, this.a.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = baay.a(paramView, paramAdapterView, afsu.a(this.a), new aftd(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Afte) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftc
 * JD-Core Version:    0.7.0.1
 */