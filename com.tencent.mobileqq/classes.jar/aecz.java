import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class aecz
  extends alyo
{
  public aecz(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getApplicationContext().getResources().getString(2131720208), 0).a();
      this.a.c.setVisibility(8);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getApplicationContext().getResources().getString(2131720205), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecz
 * JD-Core Version:    0.7.0.1
 */