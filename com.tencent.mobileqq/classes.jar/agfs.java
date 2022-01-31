import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class agfs
  implements bfpu
{
  agfs(agfk paramagfk) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Agbp.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (agep)this.a.jdField_a_of_type_Agbp.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Agep = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bbmf();
    paramAdapterView.a(2131364824, ajya.a(2131715192), 2130838597);
    paramAdapterView.a(2131366632, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView, paramAdapterView, agfk.a(this.a), new agft(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfs
 * JD-Core Version:    0.7.0.1
 */