package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class ArtistBrowseUI$2
  implements r.a
{
  ArtistBrowseUI$2(ArtistBrowseUI paramArtistBrowseUI) {}
  
  public final void ctm()
  {
    AppMethodBeat.i(38096);
    Object localObject1 = this.rEB.rNT.getCntMedia();
    if (localObject1 == null)
    {
      AppMethodBeat.o(38096);
      return;
    }
    ab.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((bcs)localObject1).Id);
    Object localObject2 = b.lV(723);
    ((b)localObject2).uv(((bcs)localObject1).Url);
    ((b)localObject2).ake();
    if (!e.cN(ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id) + i.l((bcs)localObject1)))
    {
      AppMethodBeat.o(38096);
      return;
    }
    localObject2 = ag.cpb();
    Object localObject3;
    String str;
    if ((((ax)localObject2).coK() != null) && (!((ax)localObject2).coK().equals("")))
    {
      localObject3 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id) + i.l((bcs)localObject1);
      str = ao.gl(ag.getAccSnsPath(), ((ax)localObject2).coK());
      if (!e.cN((String)localObject3)) {
        break label429;
      }
      ab.d("MicroMsg.UploadManager", "bg file is exist!'");
      e.um(str);
      e.deleteFile(str + ((ax)localObject2).coK() + "bg_");
      e.deleteFile(str + ((ax)localObject2).coK() + "tbg_");
      e.C((String)localObject3, str + ((ax)localObject2).coK() + "bg_");
    }
    for (;;)
    {
      localObject3 = ag.cpj();
      Object localObject4 = ((ax)localObject2).coK();
      str = ((bcs)localObject1).Id;
      localObject4 = ((m)localObject3).abz((String)localObject4);
      ((l)localObject4).field_bgId = str;
      ((m)localObject3).c((l)localObject4);
      ((ax)localObject2).cpN();
      localObject2 = new ay(7);
      ((bcs)localObject1).xrY = 1;
      ((ay)localObject2).rjr.xTS.wOa.add(localObject1);
      ((ay)localObject2).DT(2);
      ((ay)localObject2).commit();
      localObject1 = new Intent();
      ((Intent)localObject1).setClass(this.rEB, SettingSnsBackgroundUI.class);
      ((Intent)localObject1).setFlags(536870912);
      ((Intent)localObject1).addFlags(67108864);
      this.rEB.startActivity((Intent)localObject1);
      this.rEB.finish();
      AppMethodBeat.o(38096);
      return;
      label429:
      e.deleteFile(str + ((ax)localObject2).coK() + "bg_");
      e.deleteFile(str + ((ax)localObject2).coK() + "tbg_");
      ab.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI.2
 * JD-Core Version:    0.7.0.1
 */