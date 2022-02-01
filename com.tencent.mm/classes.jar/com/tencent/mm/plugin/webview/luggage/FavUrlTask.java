package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.a;
import com.tencent.mm.g.a.cn.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pj.b;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.g.a.ur.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public boolean CkX;
  public boolean CkY;
  public int actionType;
  public Bundle dmf;
  public boolean result;
  public int ret;
  public int type;
  
  static
  {
    AppMethodBeat.i(78192);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(78192);
  }
  
  public FavUrlTask() {}
  
  private FavUrlTask(Parcel paramParcel)
  {
    AppMethodBeat.i(78191);
    e(paramParcel);
    AppMethodBeat.o(78191);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(78188);
    switch (this.actionType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78188);
      return;
      Object localObject2;
      int i;
      Object localObject3;
      boolean bool;
      if (this.dmf != null)
      {
        long l = this.dmf.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.dmf.getString("sns_local_id");
        i = this.dmf.getInt("news_svr_id", 0);
        localObject3 = this.dmf.getString("news_svr_tweetid");
        localObject1 = new cs();
        if (-9223372036854775808L == l) {
          break label367;
        }
        ((cs)localObject1).dck.dco = this.dmf.getInt("message_index", 0);
        bool = ((ad)g.ab(ad.class)).a((cs)localObject1, l);
        if (!bool) {
          break label527;
        }
        Object localObject4 = bs.nullAsNil(this.dmf.getString("prePublishId"));
        localObject2 = y.xJ((String)localObject4);
        localObject3 = y.ayq().F((String)localObject2, true);
        ((y.b)localObject3).l("sendAppMsgScene", Integer.valueOf(2));
        ((y.b)localObject3).l("preChatName", this.dmf.getString("preChatName"));
        ((y.b)localObject3).l("preMsgIndex", Integer.valueOf(this.dmf.getInt("preMsgIndex")));
        ((y.b)localObject3).l("prePublishId", localObject4);
        ((y.b)localObject3).l("preUsername", this.dmf.getString("preUsername"));
        ((y.b)localObject3).l("getA8KeyScene", this.dmf.getString("getA8KeyScene"));
        ((y.b)localObject3).l("referUrl", this.dmf.getString("referUrl"));
        localObject4 = this.dmf.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((y.b)localObject3).l("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cs)localObject1).dck.sessionId = ((String)localObject2);
        a.GpY.l((b)localObject1);
      }
      for (;;)
      {
        this.ret = ((cs)localObject1).dcl.ret;
        AppMethodBeat.o(78188);
        return;
        label367:
        if (!bs.isNullOrNil((String)localObject2))
        {
          localObject3 = new ur();
          ((ur)localObject3).dxn.dxq = ((String)localObject2);
          ((ur)localObject3).dxn.dxr = ((cs)localObject1);
          ((ur)localObject3).dxn.url = this.dmf.getString("rawUrl");
          a.GpY.l((b)localObject3);
          bool = ((ur)localObject3).dxo.dbS;
          break;
        }
        if (i != 0)
        {
          localObject2 = new pj();
          ((pj)localObject2).dsk.opType = 3;
          ((pj)localObject2).dsk.dsm = ((cs)localObject1);
          ((pj)localObject2).dsk.dsn = i;
          ((pj)localObject2).dsk.dso = ((String)localObject3);
          a.GpY.l((b)localObject2);
          bool = ((pj)localObject2).dsl.dbS;
          break;
        }
        this.CkX = true;
        AppMethodBeat.o(78188);
        return;
        label527:
        if (((cs)localObject1).dck.dcp == 0) {
          ((cs)localObject1).dck.dcp = 2131758893;
        }
        a.GpY.l((b)localObject1);
      }
      Object localObject1 = new gt();
      ((gt)localObject1).dhx.type = 35;
      a.GpY.l((b)localObject1);
      AppMethodBeat.o(78188);
      return;
      this.CkY = d.aCT("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new cn();
      ((cn)localObject1).dce.dcg = this.dmf.getLong("fav_local_id", -1L);
      a.GpY.l((b)localObject1);
      ac.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((cn)localObject1).dce.dcg), Boolean.valueOf(((cn)localObject1).dcf.dbS) });
      this.result = ((cn)localObject1).dcf.dbS;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.dmf = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.CkX = bool1;
      if (paramParcel.readByte() != 1) {
        break label97;
      }
      bool1 = true;
      label49:
      this.result = bool1;
      this.ret = paramParcel.readInt();
      this.type = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.CkY = bool1;
      AppMethodBeat.o(78189);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label49;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(78190);
    paramParcel.writeInt(this.actionType);
    paramParcel.writeBundle(this.dmf);
    if (this.CkX)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.result) {
        break label97;
      }
      paramInt = 1;
      label48:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.ret);
      paramParcel.writeInt(this.type);
      if (!this.CkY) {
        break label102;
      }
    }
    label97:
    label102:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(78190);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.FavUrlTask
 * JD-Core Version:    0.7.0.1
 */