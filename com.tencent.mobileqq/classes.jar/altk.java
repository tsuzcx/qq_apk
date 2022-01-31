import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

class altk
  implements View.OnClickListener
{
  altk(altj paramaltj) {}
  
  public void onClick(View paramView)
  {
    if ((altj.a(this.a) != null) && (altj.a(this.a).getVisibility() == 0) && (altj.a(this.a).hasFocus())) {
      return;
    }
    altj.a(this.a);
    paramView = new Intent(altj.a(this.a), AssistantSettingActivity.class);
    paramView.putExtra("jumpTo", "color_note_recently_viewed");
    paramView.putExtra("from", "color_note");
    List localList = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a();
    if ((localList.size() == 1) && (alsr.b((ColorNote)localList.get(0)))) {
      paramView.putExtra("do_not_open", true);
    }
    paramView.addFlags(268435456);
    altj.a(this.a).startActivity(paramView);
    awqx.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altk
 * JD-Core Version:    0.7.0.1
 */