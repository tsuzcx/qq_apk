package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.cy;
import com.tencent.mm.f.a.cy.a;
import com.tencent.mm.f.a.cy.b;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.rn;
import com.tencent.mm.f.a.rn.b;
import com.tencent.mm.f.a.xu;
import com.tencent.mm.f.a.xu.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public boolean PPe;
  public boolean PPf;
  public int actionType;
  public Bundle fKb;
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
    f(paramParcel);
    AppMethodBeat.o(78191);
  }
  
  public final void RW()
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
      if (this.fKb != null)
      {
        long l = this.fKb.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.fKb.getString("sns_local_id");
        i = this.fKb.getInt("news_svr_id", 0);
        localObject3 = this.fKb.getString("news_svr_tweetid");
        localObject1 = new dd();
        if (-9223372036854775808L == l) {
          break label367;
        }
        ((dd)localObject1).fyI.fyM = this.fKb.getInt("message_index", 0);
        bool = ((ae)h.ae(ae.class)).a((dd)localObject1, l);
        if (!bool) {
          break label527;
        }
        Object localObject4 = Util.nullAsNil(this.fKb.getString("prePublishId"));
        localObject2 = ad.Rp((String)localObject4);
        localObject3 = ad.beh().I((String)localObject2, true);
        ((ad.b)localObject3).k("sendAppMsgScene", Integer.valueOf(2));
        ((ad.b)localObject3).k("preChatName", this.fKb.getString("preChatName"));
        ((ad.b)localObject3).k("preMsgIndex", Integer.valueOf(this.fKb.getInt("preMsgIndex")));
        ((ad.b)localObject3).k("prePublishId", localObject4);
        ((ad.b)localObject3).k("preUsername", this.fKb.getString("preUsername"));
        ((ad.b)localObject3).k("getA8KeyScene", this.fKb.getString("getA8KeyScene"));
        ((ad.b)localObject3).k("referUrl", this.fKb.getString("referUrl"));
        localObject4 = this.fKb.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((ad.b)localObject3).k("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((dd)localObject1).fyI.sessionId = ((String)localObject2);
        EventCenter.instance.publish((IEvent)localObject1);
      }
      for (;;)
      {
        this.ret = ((dd)localObject1).fyJ.ret;
        AppMethodBeat.o(78188);
        return;
        label367:
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = new xu();
          ((xu)localObject3).fWG.fWJ = ((String)localObject2);
          ((xu)localObject3).fWG.fWK = ((dd)localObject1);
          ((xu)localObject3).fWG.url = this.fKb.getString("rawUrl");
          EventCenter.instance.publish((IEvent)localObject3);
          bool = ((xu)localObject3).fWH.fyl;
          break;
        }
        if (i != 0)
        {
          localObject2 = new rn();
          ((rn)localObject2).fQH.opType = 3;
          ((rn)localObject2).fQH.fQJ = ((dd)localObject1);
          ((rn)localObject2).fQH.fQK = i;
          ((rn)localObject2).fQH.fQL = ((String)localObject3);
          EventCenter.instance.publish((IEvent)localObject2);
          bool = ((rn)localObject2).fQI.fyl;
          break;
        }
        this.PPe = true;
        AppMethodBeat.o(78188);
        return;
        label527:
        if (((dd)localObject1).fyI.fyO == 0) {
          ((dd)localObject1).fyI.fyO = c.i.favorite_fail_nonsupport;
        }
        EventCenter.instance.publish((IEvent)localObject1);
      }
      Object localObject1 = new hi();
      ((hi)localObject1).fEb.type = 35;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(78188);
      return;
      this.PPf = c.blP("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new cy();
      ((cy)localObject1).fyC.fyE = this.fKb.getLong("fav_local_id", -1L);
      EventCenter.instance.publish((IEvent)localObject1);
      Log.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((cy)localObject1).fyC.fyE), Boolean.valueOf(((cy)localObject1).fyD.fyl) });
      this.result = ((cy)localObject1).fyD.fyl;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.fKb = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.PPe = bool1;
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
      this.PPf = bool1;
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
    paramParcel.writeBundle(this.fKb);
    if (this.PPe)
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
      if (!this.PPf) {
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