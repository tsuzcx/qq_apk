import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.text.QQTextBuilder;

public class adwe
  extends Editable.Factory
{
  public adwe(EditInfoActivity paramEditInfoActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwe
 * JD-Core Version:    0.7.0.1
 */