package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.a;
import com.tencent.mm.g.a.cn.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.pa.b;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.uh.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bt;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public boolean ASK;
  public boolean ASL;
  public int actionType;
  public Bundle dow;
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
  
  public final void aEz()
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
      if (this.dow != null)
      {
        long l = this.dow.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.dow.getString("sns_local_id");
        i = this.dow.getInt("news_svr_id", 0);
        localObject3 = this.dow.getString("news_svr_tweetid");
        localObject1 = new cs();
        if (-9223372036854775808L == l) {
          break label367;
        }
        ((cs)localObject1).deQ.deU = this.dow.getInt("message_index", 0);
        bool = ((com.tencent.mm.plugin.fav.a.ad)g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a((cs)localObject1, l);
        if (!bool) {
          break label527;
        }
        Object localObject4 = bt.nullAsNil(this.dow.getString("prePublishId"));
        localObject2 = y.tD((String)localObject4);
        localObject3 = y.arz().E((String)localObject2, true);
        ((y.b)localObject3).m("sendAppMsgScene", Integer.valueOf(2));
        ((y.b)localObject3).m("preChatName", this.dow.getString("preChatName"));
        ((y.b)localObject3).m("preMsgIndex", Integer.valueOf(this.dow.getInt("preMsgIndex")));
        ((y.b)localObject3).m("prePublishId", localObject4);
        ((y.b)localObject3).m("preUsername", this.dow.getString("preUsername"));
        ((y.b)localObject3).m("getA8KeyScene", this.dow.getString("getA8KeyScene"));
        ((y.b)localObject3).m("referUrl", this.dow.getString("referUrl"));
        localObject4 = this.dow.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((y.b)localObject3).m("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cs)localObject1).deQ.sessionId = ((String)localObject2);
        a.ESL.l((b)localObject1);
      }
      for (;;)
      {
        this.ret = ((cs)localObject1).deR.ret;
        AppMethodBeat.o(78188);
        return;
        label367:
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject3 = new uh();
          ((uh)localObject3).dzB.dzE = ((String)localObject2);
          ((uh)localObject3).dzB.dzF = ((cs)localObject1);
          ((uh)localObject3).dzB.url = this.dow.getString("rawUrl");
          a.ESL.l((b)localObject3);
          bool = ((uh)localObject3).dzC.dew;
          break;
        }
        if (i != 0)
        {
          localObject2 = new pa();
          ((pa)localObject2).duz.opType = 3;
          ((pa)localObject2).duz.duB = ((cs)localObject1);
          ((pa)localObject2).duz.duC = i;
          ((pa)localObject2).duz.duD = ((String)localObject3);
          a.ESL.l((b)localObject2);
          bool = ((pa)localObject2).duA.dew;
          break;
        }
        this.ASK = true;
        AppMethodBeat.o(78188);
        return;
        label527:
        if (((cs)localObject1).deQ.deV == 0) {
          ((cs)localObject1).deQ.deV = 2131758893;
        }
        a.ESL.l((b)localObject1);
      }
      Object localObject1 = new gs();
      ((gs)localObject1).dkc.type = 35;
      a.ESL.l((b)localObject1);
      AppMethodBeat.o(78188);
      return;
      this.ASL = d.axB("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new cn();
      ((cn)localObject1).deJ.deL = this.dow.getLong("fav_local_id", -1L);
      a.ESL.l((b)localObject1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((cn)localObject1).deJ.deL), Boolean.valueOf(((cn)localObject1).deK.dew) });
      this.result = ((cn)localObject1).deK.dew;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.dow = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.ASK = bool1;
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
      this.ASL = bool1;
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
    paramParcel.writeBundle(this.dow);
    if (this.ASK)
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
      if (!this.ASL) {
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