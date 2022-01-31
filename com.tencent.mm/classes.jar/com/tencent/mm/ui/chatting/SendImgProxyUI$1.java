package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

final class SendImgProxyUI$1
  implements Runnable
{
  SendImgProxyUI$1(SendImgProxyUI paramSendImgProxyUI, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
    SendImgProxyUI.a(this.vmR, this.vmR.getIntent());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(-1));
    au.DS().cre();
    y.i("MicroMsg.SendImgProxyUI", "test before finish");
    SendImgProxyUI.a(this.vmR).dismiss();
    this.vmR.setResult(-1, this.vmR.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
    SendImgProxyUI.ape();
    this.vmR.finish();
    if (aq.isWifi(this.vmR) == this.vmQ) {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSendPicMsgEnable, this.eub);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendImgProxyUI.1
 * JD-Core Version:    0.7.0.1
 */