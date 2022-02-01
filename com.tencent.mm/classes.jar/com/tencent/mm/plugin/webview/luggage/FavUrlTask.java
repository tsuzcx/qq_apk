package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cu.a;
import com.tencent.mm.g.a.cu.b;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qn.b;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.g.a.wo.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public boolean ISL;
  public boolean ISM;
  public int actionType;
  public Bundle dQL;
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
  
  public final void bjj()
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
      if (this.dQL != null)
      {
        long l = this.dQL.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.dQL.getString("sns_local_id");
        i = this.dQL.getInt("news_svr_id", 0);
        localObject3 = this.dQL.getString("news_svr_tweetid");
        localObject1 = new cz();
        if (-9223372036854775808L == l) {
          break label367;
        }
        ((cz)localObject1).dFZ.dGd = this.dQL.getInt("message_index", 0);
        bool = ((com.tencent.mm.plugin.fav.a.ad)g.af(com.tencent.mm.plugin.fav.a.ad.class)).a((cz)localObject1, l);
        if (!bool) {
          break label527;
        }
        Object localObject4 = Util.nullAsNil(this.dQL.getString("prePublishId"));
        localObject2 = com.tencent.mm.model.ad.JX((String)localObject4);
        localObject3 = com.tencent.mm.model.ad.aVe().G((String)localObject2, true);
        ((ad.b)localObject3).l("sendAppMsgScene", Integer.valueOf(2));
        ((ad.b)localObject3).l("preChatName", this.dQL.getString("preChatName"));
        ((ad.b)localObject3).l("preMsgIndex", Integer.valueOf(this.dQL.getInt("preMsgIndex")));
        ((ad.b)localObject3).l("prePublishId", localObject4);
        ((ad.b)localObject3).l("preUsername", this.dQL.getString("preUsername"));
        ((ad.b)localObject3).l("getA8KeyScene", this.dQL.getString("getA8KeyScene"));
        ((ad.b)localObject3).l("referUrl", this.dQL.getString("referUrl"));
        localObject4 = this.dQL.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((ad.b)localObject3).l("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cz)localObject1).dFZ.sessionId = ((String)localObject2);
        EventCenter.instance.publish((IEvent)localObject1);
      }
      for (;;)
      {
        this.ret = ((cz)localObject1).dGa.ret;
        AppMethodBeat.o(78188);
        return;
        label367:
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = new wo();
          ((wo)localObject3).ecC.ecF = ((String)localObject2);
          ((wo)localObject3).ecC.ecG = ((cz)localObject1);
          ((wo)localObject3).ecC.url = this.dQL.getString("rawUrl");
          EventCenter.instance.publish((IEvent)localObject3);
          bool = ((wo)localObject3).ecD.dFE;
          break;
        }
        if (i != 0)
        {
          localObject2 = new qn();
          ((qn)localObject2).dWV.opType = 3;
          ((qn)localObject2).dWV.dWX = ((cz)localObject1);
          ((qn)localObject2).dWV.dWY = i;
          ((qn)localObject2).dWV.dWZ = ((String)localObject3);
          EventCenter.instance.publish((IEvent)localObject2);
          bool = ((qn)localObject2).dWW.dFE;
          break;
        }
        this.ISL = true;
        AppMethodBeat.o(78188);
        return;
        label527:
        if (((cz)localObject1).dFZ.dGe == 0) {
          ((cz)localObject1).dFZ.dGe = 2131759217;
        }
        EventCenter.instance.publish((IEvent)localObject1);
      }
      Object localObject1 = new hb();
      ((hb)localObject1).dLm.type = 35;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(78188);
      return;
      this.ISM = c.aZU("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new cu();
      ((cu)localObject1).dFU.dFW = this.dQL.getLong("fav_local_id", -1L);
      EventCenter.instance.publish((IEvent)localObject1);
      Log.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((cu)localObject1).dFU.dFW), Boolean.valueOf(((cu)localObject1).dFV.dFE) });
      this.result = ((cu)localObject1).dFV.dFE;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.dQL = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.ISL = bool1;
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
      this.ISM = bool1;
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
    paramParcel.writeBundle(this.dQL);
    if (this.ISL)
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
      if (!this.ISM) {
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