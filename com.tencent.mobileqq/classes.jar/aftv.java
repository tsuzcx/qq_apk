import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class aftv
  implements behj
{
  aftv(aftn paramaftn) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Afpr.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (afss)this.a.jdField_a_of_type_Afpr.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Afss = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bakh();
    paramAdapterView.a(2131299262, ajjy.a(2131649391), 2130838590);
    paramAdapterView.a(2131301021, this.a.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = baay.a(paramView, paramAdapterView, aftn.a(this.a), new aftw(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftv
 * JD-Core Version:    0.7.0.1
 */