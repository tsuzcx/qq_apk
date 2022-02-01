package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.di;
import com.tencent.mm.autogen.a.di.a;
import com.tencent.mm.autogen.a.di.b;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.tc;
import com.tencent.mm.autogen.a.tc.b;
import com.tencent.mm.autogen.a.zn;
import com.tencent.mm.autogen.a.zn.b;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public boolean WFx;
  public boolean WFy;
  public int actionType;
  public Bundle hPH;
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
    h(paramParcel);
    AppMethodBeat.o(78191);
  }
  
  public final void asn()
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
      if (this.hPH != null)
      {
        long l = this.hPH.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.hPH.getString("sns_local_id");
        i = this.hPH.getInt("news_svr_id", 0);
        localObject3 = this.hPH.getString("news_svr_tweetid");
        localObject1 = new dn();
        if (-9223372036854775808L == l) {
          break label364;
        }
        ((dn)localObject1).hDr.hDv = this.hPH.getInt("message_index", 0);
        bool = ((af)h.ax(af.class)).a((dn)localObject1, l);
        if (!bool) {
          break label518;
        }
        Object localObject4 = Util.nullAsNil(this.hPH.getString("prePublishId"));
        localObject2 = ad.Jo((String)localObject4);
        localObject3 = ad.bCb().M((String)localObject2, true);
        ((ad.b)localObject3).q("sendAppMsgScene", Integer.valueOf(2));
        ((ad.b)localObject3).q("preChatName", this.hPH.getString("preChatName"));
        ((ad.b)localObject3).q("preMsgIndex", Integer.valueOf(this.hPH.getInt("preMsgIndex")));
        ((ad.b)localObject3).q("prePublishId", localObject4);
        ((ad.b)localObject3).q("preUsername", this.hPH.getString("preUsername"));
        ((ad.b)localObject3).q("getA8KeyScene", this.hPH.getString("getA8KeyScene"));
        ((ad.b)localObject3).q("referUrl", this.hPH.getString("referUrl"));
        localObject4 = this.hPH.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((ad.b)localObject3).q("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((dn)localObject1).hDr.sessionId = ((String)localObject2);
        ((dn)localObject1).publish();
      }
      for (;;)
      {
        this.ret = ((dn)localObject1).hDs.ret;
        AppMethodBeat.o(78188);
        return;
        label364:
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = new zn();
          ((zn)localObject3).icF.icI = ((String)localObject2);
          ((zn)localObject3).icF.icJ = ((dn)localObject1);
          ((zn)localObject3).icF.url = this.hPH.getString("rawUrl");
          ((zn)localObject3).publish();
          bool = ((zn)localObject3).icG.hCQ;
          break;
        }
        if (i != 0)
        {
          localObject2 = new tc();
          ((tc)localObject2).hWE.opType = 3;
          ((tc)localObject2).hWE.hWG = ((dn)localObject1);
          ((tc)localObject2).hWE.hWH = i;
          ((tc)localObject2).hWE.hWI = ((String)localObject3);
          ((tc)localObject2).publish();
          bool = ((tc)localObject2).hWF.hCQ;
          break;
        }
        this.WFx = true;
        AppMethodBeat.o(78188);
        return;
        label518:
        if (((dn)localObject1).hDr.hDx == 0) {
          ((dn)localObject1).hDr.hDx = c.i.favorite_fail_nonsupport;
        }
        ((dn)localObject1).publish();
      }
      Object localObject1 = new ht();
      ((ht)localObject1).hIR.type = 35;
      ((ht)localObject1).publish();
      AppMethodBeat.o(78188);
      return;
      this.WFy = c.blq("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new di();
      ((di)localObject1).hDl.hDn = this.hPH.getLong("fav_local_id", -1L);
      ((di)localObject1).publish();
      Log.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((di)localObject1).hDl.hDn), Boolean.valueOf(((di)localObject1).hDm.hCQ) });
      this.result = ((di)localObject1).hDm.hCQ;
    }
  }
  
  public final void h(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.hPH = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.WFx = bool1;
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
      this.WFy = bool1;
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
    paramParcel.writeBundle(this.hPH);
    if (this.WFx)
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
      if (!this.WFy) {
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