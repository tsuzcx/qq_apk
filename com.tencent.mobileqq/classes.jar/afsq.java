import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class afsq
  implements behi
{
  afsq(afsj paramafsj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Afpq.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (afss)this.a.jdField_a_of_type_Afpq.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.a.jdField_a_of_type_Int + ",needSearchInCloud:" + this.a.b);
    }
    try
    {
      paramAdapterView = ayjf.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgData);
      if (paramAdapterView == null) {
        break label214;
      }
      paramAdapterView = (TroopLinkElement)paramAdapterView;
    }
    catch (Exception paramAdapterView)
    {
      for (;;)
      {
        paramAdapterView = null;
        continue;
        paramAdapterView = null;
      }
    }
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.url);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsq
 * JD-Core Version:    0.7.0.1
 */