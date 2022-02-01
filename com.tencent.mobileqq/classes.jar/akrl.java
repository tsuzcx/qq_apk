import android.widget.EditText;

public class akrl
  extends akqs
{
  public akrl(EditText paramEditText)
  {
    super(paramEditText);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 1;
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.startsWith("0"))
    {
      paramInt2 = blqo.a(paramCharSequence, 1);
      if (paramInt2 != 0) {
        break label53;
      }
    }
    for (;;)
    {
      paramCharSequence = String.valueOf(paramInt1);
      this.a.setText(paramCharSequence);
      this.a.setSelection(paramCharSequence.length());
      return;
      label53:
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrl
 * JD-Core Version:    0.7.0.1
 */