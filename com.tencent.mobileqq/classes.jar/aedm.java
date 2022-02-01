import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class aedm
  extends Editable.Factory
{
  public aedm(EditInfoActivity paramEditInfoActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bdod)) {
      return (Editable)paramCharSequence;
    }
    return new bdod(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedm
 * JD-Core Version:    0.7.0.1
 */