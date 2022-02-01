import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class ajxq
  implements bkik
{
  ajxq(ajxi paramajxi) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Ajxg.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (ajyc)this.a.jdField_a_of_type_Ajxg.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Ajyc = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bguh();
    paramAdapterView.a(2131365147, anni.a(2131700089), 2130838920);
    paramAdapterView.a(2131367027, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bgkw.a(paramView, paramAdapterView, ajxi.a(this.a), new ajxr(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxq
 * JD-Core Version:    0.7.0.1
 */