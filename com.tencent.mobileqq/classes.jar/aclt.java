import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class aclt
  extends akgz
{
  public aclt(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      bcpw.a(this.a.getApplicationContext(), 2, this.a.getApplicationContext().getResources().getString(2131719664), 0).a();
      this.a.c.setVisibility(8);
      return;
    }
    bcpw.a(this.a.getApplicationContext(), 1, this.a.getApplicationContext().getResources().getString(2131719661), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclt
 * JD-Core Version:    0.7.0.1
 */