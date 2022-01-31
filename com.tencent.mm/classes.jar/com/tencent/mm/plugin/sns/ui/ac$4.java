package com.tencent.mm.plugin.sns.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class ac$4
  implements Runnable
{
  ac$4(ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(38341);
    ac localac = this.rIQ;
    long l = System.currentTimeMillis();
    ay localay;
    Object localObject2;
    Object localObject1;
    int i;
    if ((!TextUtils.isEmpty(localac.nKP)) && (!TextUtils.isEmpty(localac.fgM)))
    {
      localay = localac.rIM;
      String str5 = localac.videoPath;
      localObject2 = localac.thumbPath;
      localObject1 = localac.desc;
      String str1 = localac.cqq;
      String str2 = localac.nKP;
      String str3 = localac.fgM;
      String str4 = ag.getAccSnsTmpPath() + g.w(str5.getBytes());
      ay.aaV(str4);
      e.C(str5, str4);
      str5 = ag.getAccSnsTmpPath() + g.w(((String)localObject2).getBytes());
      e.C((String)localObject2, str5);
      localObject2 = ay.c("", str4, str5, str1, str2, str3);
      if (localObject2 == null)
      {
        ab.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        i = 0;
        if (i != 0) {
          break label485;
        }
        ab.i("MicroMsg.SightWidget", "commitInThread videopath " + e.avI(localac.videoPath) + " thumb: " + e.avI(localac.thumbPath) + ",cdnUrl " + localac.nKP + "cdnThubmUrl " + localac.fgM);
        al.d(new ac.7(localac));
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.SightWidget", "removeRunnable showProgress");
      al.ae(this.rIQ.rIP);
      if (this.rIQ.rIM != null) {
        break label510;
      }
      AppMethodBeat.o(38341);
      return;
      ((bcs)localObject2).Desc = ((String)localObject1);
      if (bo.isNullOrNil(((bcs)localObject2).Title)) {
        ((bcs)localObject2).Title = ((String)localObject1);
      }
      localay.rjr.xTS.wOa.add(localObject2);
      localObject1 = new bam();
      ((bam)localObject1).xpE = ((bcs)localObject2).cIp;
      localay.rjs.xsq.add(localObject1);
      i = 1;
      break;
      if (!localac.rIM.t(localac.videoPath, localac.thumbPath, localac.desc, localac.cqq))
      {
        ab.i("MicroMsg.SightWidget", "commitInThread videopath " + e.avI(localac.videoPath) + " thumb: " + e.avI(localac.thumbPath));
        al.d(new ac.8(localac));
      }
      else
      {
        label485:
        ab.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    label510:
    al.d(this.rIQ.rIO);
    AppMethodBeat.o(38341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.4
 * JD-Core Version:    0.7.0.1
 */