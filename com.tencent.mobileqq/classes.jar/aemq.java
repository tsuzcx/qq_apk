import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class aemq
  extends Editable.Factory
{
  public aemq(EditInfoActivity paramEditInfoActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof begz)) {
      return (Editable)paramCharSequence;
    }
    return new begz(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemq
 * JD-Core Version:    0.7.0.1
 */