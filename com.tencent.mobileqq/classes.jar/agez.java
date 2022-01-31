import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class agez
  implements bfpu
{
  agez(ager paramager) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ager.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Ageq)
    {
      this.a.jdField_a_of_type_Agep = ((agep)this.a.jdField_a_of_type_Ageq.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bbmf();
      paramAdapterView.a(2131364824, ajya.a(2131706672), 2130838597);
      paramAdapterView.a(2131366632, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView, paramAdapterView, ager.a(this.a), new agfa(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Agfb) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agez
 * JD-Core Version:    0.7.0.1
 */