import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class ajym
  implements bkik
{
  ajym(ajye paramajye) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ajye.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Ajyd)
    {
      this.a.jdField_a_of_type_Ajyc = ((ajyc)this.a.jdField_a_of_type_Ajyd.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bguh();
      paramAdapterView.a(2131365147, anni.a(2131705447), 2130838920);
      paramAdapterView.a(2131367027, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bgkw.a(paramView, paramAdapterView, ajye.a(this.a), new ajyn(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Ajyo) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajym
 * JD-Core Version:    0.7.0.1
 */