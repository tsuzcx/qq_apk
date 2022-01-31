import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.widget.XEditTextEx;

class aghb
  implements anyb
{
  aghb(aggy paramaggy) {}
  
  public void a(anyc paramanyc)
  {
    int i;
    int j;
    if ((paramanyc instanceof aocr))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    aocp localaocp;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, ayla.c(((aocr)paramanyc).a));
      do
      {
        return;
      } while (!(paramanyc instanceof aocp));
      localaocp = (aocp)paramanyc;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localaocp.a;
      m = localaocp.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramanyc = ayla.c(m);; paramanyc = ayla.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramanyc);
      this.a.a.requestFocus();
      localaocp.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      anwm.a().a(k).a(m, 2);
      return;
    }
  }
  
  public void a(anyc paramanyc1, anyc paramanyc2, Drawable paramDrawable) {}
  
  public boolean a(anyc paramanyc)
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
        int j = TextUtils.getOffsetBefore(this.a.a.getText(), i);
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
  
  public void b(anyc paramanyc) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghb
 * JD-Core Version:    0.7.0.1
 */