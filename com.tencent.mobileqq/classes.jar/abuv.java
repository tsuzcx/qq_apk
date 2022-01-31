import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public class abuv
  implements bfpc
{
  public abuv(QQLSActivity paramQQLSActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (RecentBaseData)QQLSActivity.a(this.a).getItem(paramInt);
    paramLong = paramAdapterView.getAdapter().getItemId(paramInt);
    if ((paramLong == QQLSActivity.a(this.a)) && (Math.abs(QQLSActivity.b(this.a) - System.currentTimeMillis()) < 300L))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "mRecentList is double click");
      }
      QQLSActivity.a(this.a, -1L);
      QQLSActivity.b(this.a, 0L);
      QQLSActivity.a(this.a, paramView);
      QQLSActivity.a(this.a, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQLSActivity", 2, "mRecentList  click once");
    }
    QQLSActivity.a(this.a, paramLong);
    QQLSActivity.b(this.a, System.currentTimeMillis());
    if (QQLSActivity.a(this.a)) {
      QQLSActivity.a(this.a).setText(2131699094);
    }
    for (;;)
    {
      paramAdapterView = QQLSActivity.a(this.a).obtainMessage(6);
      QQLSActivity.a(this.a).sendMessageDelayed(paramAdapterView, 500L);
      return;
      QQLSActivity.a(this.a).setText(2131699093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abuv
 * JD-Core Version:    0.7.0.1
 */