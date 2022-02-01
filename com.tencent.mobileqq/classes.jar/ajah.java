import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class ajah
  implements DialogInterface.OnClickListener
{
  public ajah(SystemMsgListView paramSystemMsgListView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent(this.a.getContext(), BindNumberActivity.class);
      paramDialogInterface.putExtra("kSrouce", 17);
      this.a.a(paramDialogInterface, 230);
      bcst.b(this.a.a, "dc00898", "", "", "0X80077C9", "0X80077C9", 0, 0, "", "", "", "");
    }
    while (paramInt != 0) {
      return;
    }
    bcst.b(this.a.a, "dc00898", "", "", "0X80077CA", "0X80077CA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajah
 * JD-Core Version:    0.7.0.1
 */