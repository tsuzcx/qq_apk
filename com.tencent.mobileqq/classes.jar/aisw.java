import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QzoneTextBuilder;

public final class aisw
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QzoneTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QzoneTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisw
 * JD-Core Version:    0.7.0.1
 */