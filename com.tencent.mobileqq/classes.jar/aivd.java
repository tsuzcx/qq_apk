import android.widget.EditText;

public class aivd
  extends aium
{
  public aivd(EditText paramEditText)
  {
    super(paramEditText);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 1;
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.startsWith("0"))
    {
      paramInt2 = bixy.a(paramCharSequence, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivd
 * JD-Core Version:    0.7.0.1
 */