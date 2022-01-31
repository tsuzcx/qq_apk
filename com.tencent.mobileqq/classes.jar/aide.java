import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class aide
  implements bhqq
{
  aide(aicw paramaicw) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(aicw.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Aicv)
    {
      this.a.jdField_a_of_type_Aicu = ((aicu)this.a.jdField_a_of_type_Aicv.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bdkz();
      paramAdapterView.a(2131364910, alpo.a(2131707044), 2130838668);
      paramAdapterView.a(2131366750, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdbk.a(paramView, paramAdapterView, aicw.a(this.a), new aidf(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Aidg) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aide
 * JD-Core Version:    0.7.0.1
 */