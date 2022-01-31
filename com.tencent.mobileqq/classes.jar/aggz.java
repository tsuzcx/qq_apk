import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.widget.XEditTextEx;

class aggz
  implements anyg
{
  aggz(aggw paramaggw) {}
  
  public void a(anyh paramanyh)
  {
    int i;
    int j;
    if ((paramanyh instanceof aocw))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    aocu localaocu;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, aylc.c(((aocw)paramanyh).a));
      do
      {
        return;
      } while (!(paramanyh instanceof aocu));
      localaocu = (aocu)paramanyh;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localaocu.a;
      m = localaocu.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramanyh = aylc.c(m);; paramanyh = aylc.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramanyh);
      this.a.a.requestFocus();
      localaocu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      anwr.a().a(k).a(m, 2);
      return;
    }
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  public boolean a(anyh paramanyh)
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
  
  public void b(anyh paramanyh) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggz
 * JD-Core Version:    0.7.0.1
 */