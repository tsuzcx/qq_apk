package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

final class SendImgProxyUI$1
  implements Runnable
{
  SendImgProxyUI$1(SendImgProxyUI paramSendImgProxyUI, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(31003);
    ab.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
    SendImgProxyUI.a(this.zCn, this.zCn.getIntent());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(-1));
    aw.RO().dtd();
    ab.i("MicroMsg.SendImgProxyUI", "test before finish");
    SendImgProxyUI.a(this.zCn).dismiss();
    this.zCn.setResult(-1, this.zCn.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
    SendImgProxyUI.aMp();
    this.zCn.finish();
    if (at.isWifi(this.zCn) == this.zCm) {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendPicMsgEnable, this.fJO);
    }
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendImgProxyUI.1
 * JD-Core Version:    0.7.0.1
 */