import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aesi
  implements AdapterView.OnItemClickListener
{
  aesi(aesh paramaesh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = ((ShareActionSheetBuilder.ActionSheetItem)aesh.a(this.a)[0].get(paramInt)).action;
    aesh.a(this.a).dismiss();
    int i = 0;
    switch (j)
    {
    }
    for (;;)
    {
      if (i != 0) {
        azqs.b(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("IntimateInfoShareHelper", 2, "intimate shareAction: " + paramInt + "," + j);
      }
      this.a.a(j, aesh.a(this.a));
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
 * Qualified Name:     aesi
 * JD-Core Version:    0.7.0.1
 */