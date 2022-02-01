import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.widget.XEditTextEx;

class aklx
  implements asmr
{
  aklx(aklt paramaklt) {}
  
  public void a(asmu paramasmu)
  {
    int i;
    int j;
    if ((paramasmu instanceof assp))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    assj localassj;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, behh.b(((assp)paramasmu).a));
      do
      {
        return;
      } while (!(paramasmu instanceof assj));
      localassj = (assj)paramasmu;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localassj.a;
      m = localassj.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramasmu = behh.b(m);; paramasmu = behh.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramasmu);
      this.a.a.requestFocus();
      localassj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      asky.a().a(k).a(m, 2);
      return;
    }
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  public boolean a(asmu paramasmu)
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
  
  public void b(asmu paramasmu) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklx
 * JD-Core Version:    0.7.0.1
 */