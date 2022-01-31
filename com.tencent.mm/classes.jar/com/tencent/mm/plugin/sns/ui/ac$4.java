package com.tencent.mm.plugin.sns.ui;

import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class ac$4
  implements Runnable
{
  ac$4(ac paramac) {}
  
  public final void run()
  {
    ac localac = this.oRe;
    long l = System.currentTimeMillis();
    ax localax;
    Object localObject2;
    Object localObject1;
    int i;
    if ((!TextUtils.isEmpty(localac.lnw)) && (!TextUtils.isEmpty(localac.dQL)))
    {
      localax = localac.oRa;
      String str5 = localac.videoPath;
      localObject2 = localac.thumbPath;
      localObject1 = localac.desc;
      String str1 = localac.bIW;
      String str2 = localac.lnw;
      String str3 = localac.dQL;
      String str4 = af.getAccSnsTmpPath() + g.o(str5.getBytes());
      ax.Ob(str4);
      e.r(str5, str4);
      str5 = af.getAccSnsTmpPath() + g.o(((String)localObject2).getBytes());
      e.r((String)localObject2, str5);
      localObject2 = ax.c("", str4, str5, str1, str2, str3);
      if (localObject2 == null)
      {
        y.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        i = 0;
        if (i != 0) {
          break label475;
        }
        y.i("MicroMsg.SightWidget", "commitInThread videopath " + e.aeQ(localac.videoPath) + " thumb: " + e.aeQ(localac.thumbPath) + ",cdnUrl " + localac.lnw + "cdnThubmUrl " + localac.dQL);
        ai.d(new ac.7(localac));
      }
    }
    for (;;)
    {
      y.i("MicroMsg.SightWidget", "removeRunnable showProgress");
      ai.S(this.oRe.oRd);
      if (this.oRe.oRa != null) {
        break label500;
      }
      return;
      ((awd)localObject2).kRN = ((String)localObject1);
      if (bk.bl(((awd)localObject2).bGw)) {
        ((awd)localObject2).bGw = ((String)localObject1);
      }
      localax.ouy.tNr.sPJ.add(localObject2);
      localObject1 = new auf();
      ((auf)localObject1).tpH = ((awd)localObject2).onc;
      localax.ouz.tsn.add(localObject1);
      i = 1;
      break;
      if (!localac.oRa.q(localac.videoPath, localac.thumbPath, localac.desc, localac.bIW))
      {
        y.i("MicroMsg.SightWidget", "commitInThread videopath " + e.aeQ(localac.videoPath) + " thumb: " + e.aeQ(localac.thumbPath));
        ai.d(new ac.8(localac));
      }
      else
      {
        label475:
        y.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    label500:
    ai.d(this.oRe.oRc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.4
 * JD-Core Version:    0.7.0.1
 */