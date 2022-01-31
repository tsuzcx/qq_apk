package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.a;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.nn.b;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR;
  public int actionType;
  public boolean cmX;
  public Bundle mEJ;
  public int ret;
  public int type;
  public boolean uRc;
  public boolean uRd;
  
  static
  {
    AppMethodBeat.i(5978);
    CREATOR = new FavUrlTask.1();
    AppMethodBeat.o(5978);
  }
  
  public FavUrlTask() {}
  
  private FavUrlTask(Parcel paramParcel)
  {
    AppMethodBeat.i(5977);
    f(paramParcel);
    AppMethodBeat.o(5977);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(5974);
    switch (this.actionType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5974);
      return;
      Object localObject2;
      int i;
      Object localObject3;
      boolean bool;
      if (this.mEJ != null)
      {
        long l = this.mEJ.getLong("msg_id", -9223372036854775808L);
        localObject2 = this.mEJ.getString("sns_local_id");
        i = this.mEJ.getInt("news_svr_id", 0);
        localObject3 = this.mEJ.getString("news_svr_tweetid");
        localObject1 = new cm();
        if (-9223372036854775808L == l) {
          break label369;
        }
        ((cm)localObject1).cpR.cpV = this.mEJ.getInt("message_index", 0);
        bool = ((ad)g.E(ad.class)).a((cm)localObject1, l);
        if (!bool) {
          break label530;
        }
        Object localObject4 = bo.nullAsNil(this.mEJ.getString("prePublishId"));
        localObject2 = v.oQ((String)localObject4);
        localObject3 = v.aae().z((String)localObject2, true);
        ((v.b)localObject3).i("sendAppMsgScene", Integer.valueOf(2));
        ((v.b)localObject3).i("preChatName", this.mEJ.getString("preChatName"));
        ((v.b)localObject3).i("preMsgIndex", Integer.valueOf(this.mEJ.getInt("preMsgIndex")));
        ((v.b)localObject3).i("prePublishId", localObject4);
        ((v.b)localObject3).i("preUsername", this.mEJ.getString("preUsername"));
        ((v.b)localObject3).i("getA8KeyScene", this.mEJ.getString("getA8KeyScene"));
        ((v.b)localObject3).i("referUrl", this.mEJ.getString("referUrl"));
        localObject4 = this.mEJ.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((v.b)localObject3).i("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cm)localObject1).cpR.cpW = ((String)localObject2);
        a.ymk.l((b)localObject1);
      }
      for (;;)
      {
        this.ret = ((cm)localObject1).cpS.ret;
        AppMethodBeat.o(5974);
        return;
        label369:
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject3 = new sm();
          ((sm)localObject3).cIK.cIN = ((String)localObject2);
          ((sm)localObject3).cIK.cIO = ((cm)localObject1);
          ((sm)localObject3).cIK.url = this.mEJ.getString("rawUrl");
          a.ymk.l((b)localObject3);
          bool = ((sm)localObject3).cIL.cpz;
          break;
        }
        if (i != 0)
        {
          localObject2 = new nn();
          ((nn)localObject2).cDX.opType = 3;
          ((nn)localObject2).cDX.cDZ = ((cm)localObject1);
          ((nn)localObject2).cDX.cEa = i;
          ((nn)localObject2).cDX.cEb = ((String)localObject3);
          a.ymk.l((b)localObject2);
          bool = ((nn)localObject2).cDY.cpz;
          break;
        }
        this.uRc = true;
        AppMethodBeat.o(5974);
        return;
        label530:
        if (((cm)localObject1).cpR.cpX == 0) {
          ((cm)localObject1).cpR.cpX = 2131299721;
        }
        a.ymk.l((b)localObject1);
      }
      Object localObject1 = new gi();
      ((gi)localObject1).cuX.type = 35;
      a.ymk.l((b)localObject1);
      AppMethodBeat.o(5974);
      return;
      this.uRd = d.ahR("favorite");
      AppMethodBeat.o(5974);
      return;
      localObject1 = new ch();
      ((ch)localObject1).cpK.cpM = this.mEJ.getLong("fav_local_id", -1L);
      a.ymk.l((b)localObject1);
      ab.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((ch)localObject1).cpK.cpM), Boolean.valueOf(((ch)localObject1).cpL.cpz) });
      this.cmX = ((ch)localObject1).cpL.cpz;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(5975);
    this.actionType = paramParcel.readInt();
    this.mEJ = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.uRc = bool1;
      if (paramParcel.readByte() != 1) {
        break label97;
      }
      bool1 = true;
      label49:
      this.cmX = bool1;
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
      this.uRd = bool1;
      AppMethodBeat.o(5975);
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
    AppMethodBeat.i(5976);
    paramParcel.writeInt(this.actionType);
    paramParcel.writeBundle(this.mEJ);
    if (this.uRc)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.cmX) {
        break label97;
      }
      paramInt = 1;
      label48:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.ret);
      paramParcel.writeInt(this.type);
      if (!this.uRd) {
        break label102;
      }
    }
    label97:
    label102:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(5976);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.FavUrlTask
 * JD-Core Version:    0.7.0.1
 */