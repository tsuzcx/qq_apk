import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;

public class aeus
  implements IphonePickerView.PickerViewAdapter
{
  public aeus(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return 4;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    int i = 3;
    if (paramInt2 < 0) {}
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      if (paramInt1 > 3) {
        paramInt1 = i;
      }
      for (;;)
      {
        switch (paramInt1)
        {
        default: 
          return "";
        case 0: 
          return "保密";
        case 1: 
          return "单身";
        case 2: 
          return "恋爱中";
        }
        return "已婚";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeus
 * JD-Core Version:    0.7.0.1
 */