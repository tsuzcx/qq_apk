import android.content.Context;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;

public class acjs
  implements AdProgressDialogAdapter
{
  private biau a;
  
  public void dismiss()
  {
    if ((this.a != null) && (this.a.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  public void show(Context paramContext, int paramInt)
  {
    if ((this.a == null) && (paramContext != null) && (paramContext.getResources() != null)) {
      this.a = new biau(paramContext, paramInt);
    }
    if (this.a != null) {
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjs
 * JD-Core Version:    0.7.0.1
 */