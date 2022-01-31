import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class ajqk
  implements EmoticonCallback
{
  public ajqk(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    int i;
    int j;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.c(((SystemEmoticonInfo)paramEmoticonInfo).a));
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo));
      paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = paramEmoticonInfo.a;
      m = paramEmoticonInfo.b;
    } while ((i < 0) || (j < 0) || (j < i) || ((k == 2) && (m == -1)));
    if (k == 1) {}
    for (paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.c(m);; paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramEmoticonInfo);
      this.a.a.requestFocus();
      return;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void b()
  {
    if (this.a.a.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.a.a.getText();
        int i = this.a.a.getSelectionStart();
        int j = android.text.TextUtils.getOffsetBefore(this.a.a.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqk
 * JD-Core Version:    0.7.0.1
 */