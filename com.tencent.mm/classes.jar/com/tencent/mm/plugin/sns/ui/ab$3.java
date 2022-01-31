package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.av.a;
import com.tencent.mm.av.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bk;

final class ab$3
  implements Runnable
{
  ab$3(ab paramab) {}
  
  public final void run()
  {
    Object localObject;
    String str2;
    if (3 == this.oQI.oPT.getType())
    {
      this.oQI.isPlaying = true;
      localObject = (WXMusicObject)this.oQI.oPT.mediaObject;
      if (bk.bl(((WXMusicObject)localObject).musicUrl)) {
        break label238;
      }
      str1 = ((WXMusicObject)localObject).musicUrl;
      str2 = bk.aM(str1, "");
      if (bk.bl(((WXMusicObject)localObject).musicDataUrl)) {
        break label246;
      }
    }
    label238:
    label246:
    for (String str1 = ((WXMusicObject)localObject).musicDataUrl;; str1 = ((WXMusicObject)localObject).musicUrl)
    {
      str1 = bk.aM(str1, "");
      if (bk.bl(this.oQI.bUi)) {
        this.oQI.bUi = System.currentTimeMillis();
      }
      localObject = new e();
      ((e)localObject).euv = 1;
      ((e)localObject).eux = this.oQI.bUi;
      ((e)localObject).euy = 0.0F;
      ((e)localObject).euB = "";
      ((e)localObject).euH = null;
      ((e)localObject).euw = 1;
      ((e)localObject).euG = null;
      ((e)localObject).euz = this.oQI.oPT.title;
      ((e)localObject).euA = this.oQI.oPT.description;
      ((e)localObject).euF = str2;
      ((e)localObject).euE = str1;
      ((e)localObject).euD = str1;
      ((e)localObject).euN = "";
      ((e)localObject).euI = af.FU();
      ((e)localObject).euK = this.oQI.bOL;
      a.b((e)localObject);
      return;
      str1 = ((WXMusicObject)localObject).musicLowBandUrl;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ab.3
 * JD-Core Version:    0.7.0.1
 */