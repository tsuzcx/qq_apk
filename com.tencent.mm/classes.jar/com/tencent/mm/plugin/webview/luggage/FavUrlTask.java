package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.cq.a;
import com.tencent.mm.g.a.cq.b;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.pt.b;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.b;
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
  public boolean DOc;
  public boolean DOd;
  public int actionType;
  public Bundle dxT;
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
  
  public final void aOA()
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
      if (this.dxT != null)
      {
        long l = this.dxT.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.dxT.getString("sns_local_id");
        i = this.dxT.getInt("news_svr_id", 0);
        localObject3 = this.dxT.getString("news_svr_tweetid");
        localObject1 = new cv();
        if (-9223372036854775808L == l) {
          break label367;
        }
        ((cv)localObject1).dnG.dnK = this.dxT.getInt("message_index", 0);
        bool = ((com.tencent.mm.plugin.fav.a.ad)g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a((cv)localObject1, l);
        if (!bool) {
          break label527;
        }
        Object localObject4 = bt.nullAsNil(this.dxT.getString("prePublishId"));
        localObject2 = y.AH((String)localObject4);
        localObject3 = y.aBq().F((String)localObject2, true);
        ((y.b)localObject3).k("sendAppMsgScene", Integer.valueOf(2));
        ((y.b)localObject3).k("preChatName", this.dxT.getString("preChatName"));
        ((y.b)localObject3).k("preMsgIndex", Integer.valueOf(this.dxT.getInt("preMsgIndex")));
        ((y.b)localObject3).k("prePublishId", localObject4);
        ((y.b)localObject3).k("preUsername", this.dxT.getString("preUsername"));
        ((y.b)localObject3).k("getA8KeyScene", this.dxT.getString("getA8KeyScene"));
        ((y.b)localObject3).k("referUrl", this.dxT.getString("referUrl"));
        localObject4 = this.dxT.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((y.b)localObject3).k("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cv)localObject1).dnG.sessionId = ((String)localObject2);
        a.IbL.l((b)localObject1);
      }
      for (;;)
      {
        this.ret = ((cv)localObject1).dnH.ret;
        AppMethodBeat.o(78188);
        return;
        label367:
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject3 = new vk();
          ((vk)localObject3).dJz.dJC = ((String)localObject2);
          ((vk)localObject3).dJz.dJD = ((cv)localObject1);
          ((vk)localObject3).dJz.url = this.dxT.getString("rawUrl");
          a.IbL.l((b)localObject3);
          bool = ((vk)localObject3).dJA.dno;
          break;
        }
        if (i != 0)
        {
          localObject2 = new pt();
          ((pt)localObject2).dEe.opType = 3;
          ((pt)localObject2).dEe.dEg = ((cv)localObject1);
          ((pt)localObject2).dEe.dEh = i;
          ((pt)localObject2).dEe.dEi = ((String)localObject3);
          a.IbL.l((b)localObject2);
          bool = ((pt)localObject2).dEf.dno;
          break;
        }
        this.DOc = true;
        AppMethodBeat.o(78188);
        return;
        label527:
        if (((cv)localObject1).dnG.dnL == 0) {
          ((cv)localObject1).dnG.dnL = 2131758893;
        }
        a.IbL.l((b)localObject1);
      }
      Object localObject1 = new gw();
      ((gw)localObject1).dsV.type = 35;
      a.IbL.l((b)localObject1);
      AppMethodBeat.o(78188);
      return;
      this.DOd = d.aIu("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new cq();
      ((cq)localObject1).dnA.dnC = this.dxT.getLong("fav_local_id", -1L);
      a.IbL.l((b)localObject1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((cq)localObject1).dnA.dnC), Boolean.valueOf(((cq)localObject1).dnB.dno) });
      this.result = ((cq)localObject1).dnB.dno;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.dxT = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.DOc = bool1;
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
      this.DOd = bool1;
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
    paramParcel.writeBundle(this.dxT);
    if (this.DOc)
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
      if (!this.DOd) {
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