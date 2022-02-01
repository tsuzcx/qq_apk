package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cr.a;
import com.tencent.mm.g.a.cr.b;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.b;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vo.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public boolean Egc;
  public boolean Egd;
  public int actionType;
  public Bundle dyY;
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
  
  public final void aOX()
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
      if (this.dyY != null)
      {
        long l = this.dyY.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.dyY.getString("sns_local_id");
        i = this.dyY.getInt("news_svr_id", 0);
        localObject3 = this.dyY.getString("news_svr_tweetid");
        localObject1 = new cw();
        if (-9223372036854775808L == l) {
          break label367;
        }
        ((cw)localObject1).doL.doP = this.dyY.getInt("message_index", 0);
        bool = ((ad)g.ab(ad.class)).a((cw)localObject1, l);
        if (!bool) {
          break label527;
        }
        Object localObject4 = bu.nullAsNil(this.dyY.getString("prePublishId"));
        localObject2 = z.Br((String)localObject4);
        localObject3 = z.aBG().F((String)localObject2, true);
        ((z.b)localObject3).k("sendAppMsgScene", Integer.valueOf(2));
        ((z.b)localObject3).k("preChatName", this.dyY.getString("preChatName"));
        ((z.b)localObject3).k("preMsgIndex", Integer.valueOf(this.dyY.getInt("preMsgIndex")));
        ((z.b)localObject3).k("prePublishId", localObject4);
        ((z.b)localObject3).k("preUsername", this.dyY.getString("preUsername"));
        ((z.b)localObject3).k("getA8KeyScene", this.dyY.getString("getA8KeyScene"));
        ((z.b)localObject3).k("referUrl", this.dyY.getString("referUrl"));
        localObject4 = this.dyY.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((z.b)localObject3).k("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cw)localObject1).doL.sessionId = ((String)localObject2);
        a.IvT.l((b)localObject1);
      }
      for (;;)
      {
        this.ret = ((cw)localObject1).doM.ret;
        AppMethodBeat.o(78188);
        return;
        label367:
        if (!bu.isNullOrNil((String)localObject2))
        {
          localObject3 = new vo();
          ((vo)localObject3).dKN.dKQ = ((String)localObject2);
          ((vo)localObject3).dKN.dKR = ((cw)localObject1);
          ((vo)localObject3).dKN.url = this.dyY.getString("rawUrl");
          a.IvT.l((b)localObject3);
          bool = ((vo)localObject3).dKO.doq;
          break;
        }
        if (i != 0)
        {
          localObject2 = new pu();
          ((pu)localObject2).dFj.opType = 3;
          ((pu)localObject2).dFj.dFl = ((cw)localObject1);
          ((pu)localObject2).dFj.dFm = i;
          ((pu)localObject2).dFj.dFn = ((String)localObject3);
          a.IvT.l((b)localObject2);
          bool = ((pu)localObject2).dFk.doq;
          break;
        }
        this.Egc = true;
        AppMethodBeat.o(78188);
        return;
        label527:
        if (((cw)localObject1).doL.doQ == 0) {
          ((cw)localObject1).doL.doQ = 2131758893;
        }
        a.IvT.l((b)localObject1);
      }
      Object localObject1 = new gx();
      ((gx)localObject1).dub.type = 35;
      a.IvT.l((b)localObject1);
      AppMethodBeat.o(78188);
      return;
      this.Egd = d.aJN("favorite");
      AppMethodBeat.o(78188);
      return;
      localObject1 = new cr();
      ((cr)localObject1).doF.doH = this.dyY.getLong("fav_local_id", -1L);
      a.IvT.l((b)localObject1);
      ae.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((cr)localObject1).doF.doH), Boolean.valueOf(((cr)localObject1).doG.doq) });
      this.result = ((cr)localObject1).doG.doq;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78189);
    this.actionType = paramParcel.readInt();
    this.dyY = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.Egc = bool1;
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
      this.Egd = bool1;
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
    paramParcel.writeBundle(this.dyY);
    if (this.Egc)
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
      if (!this.Egd) {
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