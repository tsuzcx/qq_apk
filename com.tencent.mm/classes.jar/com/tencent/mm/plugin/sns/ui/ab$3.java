package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.bo;

final class ab$3
  implements Runnable
{
  ab$3(ab paramab) {}
  
  public final void run()
  {
    AppMethodBeat.i(38327);
    Object localObject;
    String str2;
    if (3 == this.rIu.rHF.getType())
    {
      this.rIu.isPlaying = true;
      localObject = (WXMusicObject)this.rIu.rHF.mediaObject;
      if (bo.isNullOrNil(((WXMusicObject)localObject).musicUrl)) {
        break label248;
      }
      str1 = ((WXMusicObject)localObject).musicUrl;
      str2 = bo.bf(str1, "");
      if (bo.isNullOrNil(((WXMusicObject)localObject).musicDataUrl)) {
        break label256;
      }
    }
    label256:
    for (String str1 = ((WXMusicObject)localObject).musicDataUrl;; str1 = ((WXMusicObject)localObject).musicUrl)
    {
      str1 = bo.bf(str1, "");
      if (bo.isNullOrNil(this.rIu.cBO)) {
        this.rIu.cBO = System.currentTimeMillis();
      }
      localObject = new e();
      ((e)localObject).fKh = 1;
      ((e)localObject).fKj = this.rIu.cBO;
      ((e)localObject).fKk = 0.0F;
      ((e)localObject).fKn = "";
      ((e)localObject).fKt = null;
      ((e)localObject).fKi = 1;
      ((e)localObject).fKs = null;
      ((e)localObject).fKl = this.rIu.rHF.title;
      ((e)localObject).fKm = this.rIu.rHF.description;
      ((e)localObject).fKr = str2;
      ((e)localObject).fKq = str1;
      ((e)localObject).fKp = str1;
      ((e)localObject).fKz = "";
      ((e)localObject).fKu = ag.getAccPath();
      ((e)localObject).fKw = this.rIu.cwc;
      a.b((e)localObject);
      AppMethodBeat.o(38327);
      return;
      label248:
      str1 = ((WXMusicObject)localObject).musicLowBandUrl;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ab.3
 * JD-Core Version:    0.7.0.1
 */