import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class agfb
  implements bfpd
{
  agfb(aget paramaget) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(aget.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Ages)
    {
      this.a.jdField_a_of_type_Ager = ((ager)this.a.jdField_a_of_type_Ages.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bblr();
      paramAdapterView.a(2131364825, ajyc.a(2131706661), 2130838597);
      paramAdapterView.a(2131366632, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcc.a(paramView, paramAdapterView, aget.a(this.a), new agfc(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Agfd) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfb
 * JD-Core Version:    0.7.0.1
 */