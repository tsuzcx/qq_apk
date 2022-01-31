import android.text.Spannable;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import java.util.Comparator;

public final class ajmk
  implements Comparator
{
  public ajmk(Spannable paramSpannable) {}
  
  public int a(AtTroopMemberSpan paramAtTroopMemberSpan1, AtTroopMemberSpan paramAtTroopMemberSpan2)
  {
    int i = 0;
    int j = this.a.getSpanStart(paramAtTroopMemberSpan1);
    int k = this.a.getSpanStart(paramAtTroopMemberSpan2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmk
 * JD-Core Version:    0.7.0.1
 */