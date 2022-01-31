import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aent
  implements AdapterView.OnItemClickListener
{
  aent(aens paramaens) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = ((ShareActionSheetBuilder.ActionSheetItem)aens.a(this.a)[0].get(paramInt)).action;
    aens.a(this.a).dismiss();
    int i = 0;
    switch (j)
    {
    }
    for (;;)
    {
      if (i != 0) {
        azmj.b(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("IntimateInfoShareHelper", 2, "intimate shareAction: " + paramInt + "," + j);
      }
      this.a.a(j, aens.a(this.a));
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aent
 * JD-Core Version:    0.7.0.1
 */