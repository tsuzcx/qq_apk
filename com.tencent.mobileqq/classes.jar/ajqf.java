import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;

public class ajqf
  implements DialogInterface.OnClickListener
{
  public ajqf(ReciteFragment paramReciteFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReciteFragment.a(this.a, false);
    ReciteFragment.d(this.a);
    paramDialogInterface = ReciteFragment.a(this.a);
    String str1;
    String str2;
    if (paramDialogInterface != null)
    {
      str1 = ReciteFragment.a(this.a).f;
      str2 = TroopReportor.a(paramDialogInterface, ReciteFragment.a(this.a).f, paramDialogInterface.getCurrentAccountUin());
      if (ReciteFragment.a(this.a) == null) {
        break label108;
      }
    }
    label108:
    for (paramDialogInterface = ReciteFragment.a(this.a).title;; paramDialogInterface = "")
    {
      TroopReportor.a("Grp_edu", "Grp_recite", "Out_Recite_Clk", 0, 0, new String[] { str1, str2, paramDialogInterface });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqf
 * JD-Core Version:    0.7.0.1
 */