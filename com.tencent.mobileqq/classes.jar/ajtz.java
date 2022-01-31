import NearbyGroup.GroupLabel;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import java.util.ArrayList;

public class ajtz
  implements Runnable
{
  public ajtz(TroopLabelLayout paramTroopLabelLayout) {}
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
          break label235;
        }
        return;
        GroupLabel localGroupLabel;
        Object localObject2;
        if (j < this.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localGroupLabel = (GroupLabel)this.a.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (j == 0)
          {
            i = 0;
            break label242;
          }
          localObject2 = (GroupLabel)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)((GroupLabel)localObject2).type) <= TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)localGroupLabel.type))
          {
            i = j;
            break label242;
          }
        }
        else
        {
          localGroupLabel = (GroupLabel)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          i = k;
          if (i < this.a.getChildCount())
          {
            localObject2 = this.a.getChildAt(i);
            if (!(localObject2 instanceof TextView)) {
              break label249;
            }
            localObject2 = (TextView)localObject2;
            if (!((TextView)localObject2).getText().toString().equals(localGroupLabel.strWording)) {
              break label249;
            }
            ((TextView)localObject2).setVisibility(8);
            this.a.requestLayout();
            break label249;
          }
          return;
        }
      }
      break label242;
      label235:
      int j = 0;
      int i = 0;
      continue;
      label242:
      j += 1;
      continue;
      label249:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtz
 * JD-Core Version:    0.7.0.1
 */