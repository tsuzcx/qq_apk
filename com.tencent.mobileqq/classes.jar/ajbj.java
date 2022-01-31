import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager.2;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ajbj
  implements bhqd
{
  public ajbj(AppletsFolderManager.2 param2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ajbg.a(this.a.this$0)) {
      return;
    }
    ajbg.a(this.a.this$0, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ajbg.a(this.a.this$0).dismiss();
      return;
      paramView = new ArrayList();
      amno localamno = new amno();
      localamno.a(Integer.valueOf(this.a.a).intValue());
      localamno.a(Integer.valueOf(this.a.b).intValue());
      localamno.b(0);
      paramView.add(localamno.a());
      ajbg.a(this.a.this$0).a(paramView);
      QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131700988), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbj
 * JD-Core Version:    0.7.0.1
 */