import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aajf
  implements View.OnClickListener
{
  aajf(aaje paramaaje, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)aaiu.c(this.jdField_a_of_type_Aaje.a).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.content.get()));
      aaiu.a(this.jdField_a_of_type_Aaje.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajf
 * JD-Core Version:    0.7.0.1
 */