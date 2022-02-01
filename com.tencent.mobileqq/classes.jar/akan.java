import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.widget.XEditTextEx;

class akan
  implements arxd
{
  akan(akaj paramakaj) {}
  
  public void a(arxg paramarxg)
  {
    int i;
    int j;
    if ((paramarxg instanceof asdb))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    ascv localascv;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, bdol.b(((asdb)paramarxg).a));
      do
      {
        return;
      } while (!(paramarxg instanceof ascv));
      localascv = (ascv)paramarxg;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localascv.a;
      m = localascv.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramarxg = bdol.b(m);; paramarxg = bdol.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramarxg);
      this.a.a.requestFocus();
      localascv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      arvk.a().a(k).a(m, 2);
      return;
    }
  }
  
  public void a(arxg paramarxg1, arxg paramarxg2, Drawable paramDrawable) {}
  
  public boolean a(arxg paramarxg)
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
  
  public void b(arxg paramarxg) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akan
 * JD-Core Version:    0.7.0.1
 */