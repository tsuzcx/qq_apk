import android.text.Editable;
import com.tencent.open.agent.SendStoryActivity.CustomLengthInputFilter;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class akmy
  implements Comparator
{
  public akmy(SendStoryActivity.CustomLengthInputFilter paramCustomLengthInputFilter, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend2) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akmy
 * JD-Core Version:    0.7.0.1
 */