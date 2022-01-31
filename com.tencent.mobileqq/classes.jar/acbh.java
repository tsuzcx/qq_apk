import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class acbh
  extends ajsp
{
  public acbh(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      bbmy.a(this.a.getApplicationContext(), 2, this.a.getApplicationContext().getResources().getString(2131653780), 0).a();
      this.a.c.setVisibility(8);
      return;
    }
    bbmy.a(this.a.getApplicationContext(), 1, this.a.getApplicationContext().getResources().getString(2131653777), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbh
 * JD-Core Version:    0.7.0.1
 */