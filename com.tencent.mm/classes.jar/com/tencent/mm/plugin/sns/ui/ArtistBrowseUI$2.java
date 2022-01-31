package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class ArtistBrowseUI$2
  implements r.a
{
  ArtistBrowseUI$2(ArtistBrowseUI paramArtistBrowseUI) {}
  
  public final void bHi()
  {
    Object localObject1 = this.oMQ.oVy.getCntMedia();
    if (localObject1 == null) {}
    do
    {
      return;
      y.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((awd)localObject1).lsK);
      localObject2 = b.jd(723);
      ((b)localObject2).ni(((awd)localObject1).kSC);
      ((b)localObject2).QX();
    } while (!e.bK(an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + i.l((awd)localObject1)));
    Object localObject2 = af.bDB();
    Object localObject3;
    String str;
    if ((((aw)localObject2).bDl() != null) && (!((aw)localObject2).bDl().equals("")))
    {
      localObject3 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + i.l((awd)localObject1);
      str = an.eJ(af.getAccSnsPath(), ((aw)localObject2).bDl());
      if (!e.bK((String)localObject3)) {
        break label408;
      }
      y.d("MicroMsg.UploadManager", "bg file is exist!'");
      e.nb(str);
      e.deleteFile(str + ((aw)localObject2).bDl() + "bg_");
      e.deleteFile(str + ((aw)localObject2).bDl() + "tbg_");
      e.r((String)localObject3, str + ((aw)localObject2).bDl() + "bg_");
    }
    for (;;)
    {
      localObject3 = af.bDJ();
      Object localObject4 = ((aw)localObject2).bDl();
      str = ((awd)localObject1).lsK;
      localObject4 = ((m)localObject3).OF((String)localObject4);
      ((l)localObject4).field_bgId = str;
      ((m)localObject3).c((l)localObject4);
      ((aw)localObject2).bEo();
      localObject2 = new ax(7);
      ((awd)localObject1).trV = 1;
      ((ax)localObject2).ouy.tNr.sPJ.add(localObject1);
      ((ax)localObject2).xT(2);
      ((ax)localObject2).commit();
      localObject1 = new Intent();
      ((Intent)localObject1).setClass(this.oMQ, SettingSnsBackgroundUI.class);
      ((Intent)localObject1).setFlags(536870912);
      ((Intent)localObject1).addFlags(67108864);
      this.oMQ.startActivity((Intent)localObject1);
      this.oMQ.finish();
      return;
      label408:
      e.deleteFile(str + ((aw)localObject2).bDl() + "bg_");
      e.deleteFile(str + ((aw)localObject2).bDl() + "tbg_");
      y.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI.2
 * JD-Core Version:    0.7.0.1
 */