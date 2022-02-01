import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class ajzf
  implements bkik
{
  ajzf(ajyx paramajyx) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Ajuv.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (ajyc)this.a.jdField_a_of_type_Ajuv.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Ajyc = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bguh();
    paramAdapterView.a(2131365147, anni.a(2131713857), 2130838920);
    paramAdapterView.a(2131367027, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bgkw.a(paramView, paramAdapterView, ajyx.a(this.a), new ajzg(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzf
 * JD-Core Version:    0.7.0.1
 */