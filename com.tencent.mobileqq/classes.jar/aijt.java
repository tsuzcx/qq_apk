import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.widget.XEditTextEx;

class aijt
  implements apuc
{
  aijt(aijq paramaijq) {}
  
  public void a(apuf paramapuf)
  {
    int i;
    int j;
    if ((paramapuf instanceof apzf))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    apza localapza;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, banh.c(((apzf)paramapuf).a));
      do
      {
        return;
      } while (!(paramapuf instanceof apza));
      localapza = (apza)paramapuf;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localapza.a;
      m = localapza.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramapuf = banh.c(m);; paramapuf = banh.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramapuf);
      this.a.a.requestFocus();
      localapza.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      apsj.a().a(k).a(m, 2);
      return;
    }
  }
  
  public void a(apuf paramapuf1, apuf paramapuf2, Drawable paramDrawable) {}
  
  public boolean a(apuf paramapuf)
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
  
  public void b(apuf paramapuf) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijt
 * JD-Core Version:    0.7.0.1
 */