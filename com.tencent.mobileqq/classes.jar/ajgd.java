import com.tencent.mobileqq.troop.widget.TroopPickerViewHelper;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout.WheelPickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

public class ajgd
  implements WheelPickerLayout.WheelPickListener
{
  public ajgd(TroopPickerViewHelper paramTroopPickerViewHelper) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (TroopPickerViewHelper.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (TroopPickerViewHelper.a(this.a) == null) {
        break label288;
      }
      paramInt1 = TroopPickerViewHelper.a(this.a).a(TroopPickerViewHelper.a(this.a), paramInt2);
      int i = TroopPickerViewHelper.a(this.a).a(TroopPickerViewHelper.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      TroopPickerViewHelper.a(this.a).setSelection(1, paramInt2);
      TroopPickerViewHelper.a(this.a).a(1);
      TroopPickerViewHelper.a(this.a).setSelection(2, paramInt1);
      TroopPickerViewHelper.a(this.a).a(2);
      label212:
      do
      {
        TroopPickerViewHelper.a(this.a, TroopPickerViewHelper.a(this.a).a(new int[] { TroopPickerViewHelper.a(this.a).a(0), TroopPickerViewHelper.a(this.a).a(1), TroopPickerViewHelper.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(TroopPickerViewHelper.a(this.a).a(TroopPickerViewHelper.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (TroopPickerViewHelper.a(this.a) != null) {}
      for (paramInt1 = TroopPickerViewHelper.a(this.a).a(TroopPickerViewHelper.a(this.a), TroopPickerViewHelper.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        TroopPickerViewHelper.a(this.a).setSelection(2, paramInt1);
        TroopPickerViewHelper.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajgd
 * JD-Core Version:    0.7.0.1
 */