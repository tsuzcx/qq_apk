import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;

public class acxg
  implements View.OnFocusChangeListener
{
  public acxg(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()))
    {
      acvc.b("GdtFormItemTextBoxView", "onFocusChange error");
      return;
    }
    if (paramBoolean)
    {
      paramView = new AdFormError(2, -1, this.a.a().title.text);
      paramView.index = GdtFormItemTextBoxView.a(this.a);
      GdtFormItemTextBoxView.a(this.a, paramView);
      return;
    }
    GdtFormItemTextBoxView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxg
 * JD-Core Version:    0.7.0.1
 */