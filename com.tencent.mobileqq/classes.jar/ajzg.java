import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.icebreaking.AIOIceBreakView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;

public class ajzg
  implements View.OnClickListener
{
  public ajzg(AIOIceBreakView paramAIOIceBreakView) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    QLog.i("IceBreak.HotPic", 2, "onClick.");
    URLImageView localURLImageView = (URLImageView)((CustomImgView)paramView).a;
    paramView = (aelm)paramView.getTag();
    if ((localURLImageView.getDrawable() instanceof URLDrawable))
    {
      if (((URLDrawable)localURLImageView.getDrawable()).getStatus() == 1) {
        AIOIceBreakView.a(this.a, paramView);
      }
    }
    else if (AIOIceBreakView.a(this.a).a.a != 1044) {
      if (AIOIceBreakView.a(this.a).a.a != 0) {
        break label167;
      }
    }
    for (;;)
    {
      awqx.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800A4CB", "0X800A4CB", i, 0, "", "", "", "");
      if (AIOIceBreakView.a(this.a) != null) {
        AIOIceBreakView.a(this.a).a(localURLImageView);
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("IceBreak.HotPic", 2, "onClick:URLDrawable status != successed");
      break;
      label167:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzg
 * JD-Core Version:    0.7.0.1
 */