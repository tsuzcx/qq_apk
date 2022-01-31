package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;

final class ChatroomContactUI$7
  implements b.a
{
  ChatroomContactUI$7(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void TP()
  {
    y.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
    this.vKh.XM();
  }
  
  public final void Wl() {}
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt)
  {
    y.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this.vKh.mController.uMN, VoiceSearchResultUI.class);
      localIntent.putExtra("VoiceSearchResultUI_Resultlist", paramArrayOfString);
      localIntent.putExtra("VoiceSearchResultUI_VoiceId", paramLong);
      localIntent.putExtra("VoiceSearchResultUI_ShowType", paramInt);
      this.vKh.mController.uMN.startActivity(localIntent);
      return;
    }
    paramArrayOfString = new Intent(this.vKh.mController.uMN, VoiceSearchResultUI.class);
    paramArrayOfString.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
    paramArrayOfString.putExtra("VoiceSearchResultUI_Error", this.vKh.mController.uMN.getString(R.l.fmt_iap_err));
    paramArrayOfString.putExtra("VoiceSearchResultUI_VoiceId", paramLong);
    paramArrayOfString.putExtra("VoiceSearchResultUI_ShowType", paramInt);
    this.vKh.mController.uMN.startActivity(paramArrayOfString);
  }
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    y.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramString });
    paramString = ah.pl(paramString);
    ChatroomContactUI.a(this.vKh, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.7
 * JD-Core Version:    0.7.0.1
 */