import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;

public class afil
  implements IphonePickerView.PickerViewAdapter
{
  public afil(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return 2;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 1) {}
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      return "男";
    }
    return "女";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afil
 * JD-Core Version:    0.7.0.1
 */