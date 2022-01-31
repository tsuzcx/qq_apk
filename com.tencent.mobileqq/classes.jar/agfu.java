import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class agfu
  implements bfpd
{
  agfu(agfm paramagfm) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Agbr.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (ager)this.a.jdField_a_of_type_Agbr.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Ager = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bblr();
    paramAdapterView.a(2131364825, ajyc.a(2131715181), 2130838597);
    paramAdapterView.a(2131366632, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcc.a(paramView, paramAdapterView, agfm.a(this.a), new agfv(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfu
 * JD-Core Version:    0.7.0.1
 */