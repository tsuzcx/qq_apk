import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.widget.XEditTextEx;

class afvc
  implements anhs
{
  afvc(afuz paramafuz) {}
  
  public void a(anht paramanht)
  {
    int i;
    int j;
    if ((paramanht instanceof anmh))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    anmf localanmf;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, axku.c(((anmh)paramanht).a));
      do
      {
        return;
      } while (!(paramanht instanceof anmf));
      localanmf = (anmf)paramanht;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localanmf.a;
      m = localanmf.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramanht = axku.c(m);; paramanht = axku.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramanht);
      this.a.a.requestFocus();
      localanmf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      angd.a().a(k).a(m, 2);
      return;
    }
  }
  
  public void a(anht paramanht1, anht paramanht2, Drawable paramDrawable) {}
  
  public boolean a(anht paramanht)
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
  
  public void b(anht paramanht) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvc
 * JD-Core Version:    0.7.0.1
 */