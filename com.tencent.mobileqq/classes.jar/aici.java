import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class aici
  implements bhqq
{
  aici(aica paramaica) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Aiby.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (aicu)this.a.jdField_a_of_type_Aiby.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Aicu = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bdkz();
    paramAdapterView.a(2131364910, alpo.a(2131701653), 2130838668);
    paramAdapterView.a(2131366750, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdbk.a(paramView, paramAdapterView, aica.a(this.a), new aicj(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aici
 * JD-Core Version:    0.7.0.1
 */