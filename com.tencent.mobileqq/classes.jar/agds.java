import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkElement;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class agds
  implements bfpt
{
  agds(agdl paramagdl) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Agdk.getCount() <= 0) || (paramInt <= 0)) {
      return;
    }
    paramAdapterView = this.a.jdField_a_of_type_Agdk.a(paramInt - 1);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.url);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    QLog.e("LinkMessageSearchDialog", 2, "link element is null pos:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agds
 * JD-Core Version:    0.7.0.1
 */