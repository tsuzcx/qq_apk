import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaji
  implements View.OnClickListener
{
  aaji(aaje paramaaje, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)aaiu.i(this.jdField_a_of_type_Aaje.a).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.content.get()));
      aaiu.a(this.jdField_a_of_type_Aaje.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaji
 * JD-Core Version:    0.7.0.1
 */