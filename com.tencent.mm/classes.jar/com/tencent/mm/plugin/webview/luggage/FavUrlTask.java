package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ce;
import com.tencent.mm.h.a.ce.a;
import com.tencent.mm.h.a.ce.b;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.mr;
import com.tencent.mm.h.a.mr.b;
import com.tencent.mm.h.a.ra;
import com.tencent.mm.h.a.ra.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class FavUrlTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<FavUrlTask> CREATOR = new Parcelable.Creator() {};
  public int actionType;
  public boolean bFQ;
  public Bundle kke;
  public boolean rbu;
  public boolean rbv;
  public int ret;
  public int type;
  
  public FavUrlTask() {}
  
  private FavUrlTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    switch (this.actionType)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (this.kke == null);
      long l = this.kke.getLong("msg_id", -9223372036854775808L);
      Object localObject2 = this.kke.getString("sns_local_id");
      int i = this.kke.getInt("news_svr_id", 0);
      Object localObject3 = this.kke.getString("news_svr_tweetid");
      localObject1 = new cj();
      boolean bool;
      if (-9223372036854775808L != l)
      {
        ((cj)localObject1).bIw.bIA = this.kke.getInt("message_index", 0);
        bool = e.a((cj)localObject1, l);
        if (!bool) {
          break label498;
        }
        Object localObject4 = bk.pm(this.kke.getString("prePublishId"));
        localObject2 = u.ij((String)localObject4);
        localObject3 = u.Hc().v((String)localObject2, true);
        ((u.b)localObject3).h("sendAppMsgScene", Integer.valueOf(2));
        ((u.b)localObject3).h("preChatName", this.kke.getString("preChatName"));
        ((u.b)localObject3).h("preMsgIndex", Integer.valueOf(this.kke.getInt("preMsgIndex")));
        ((u.b)localObject3).h("prePublishId", localObject4);
        ((u.b)localObject3).h("preUsername", this.kke.getString("preUsername"));
        ((u.b)localObject3).h("getA8KeyScene", this.kke.getString("getA8KeyScene"));
        ((u.b)localObject3).h("referUrl", this.kke.getString("referUrl"));
        localObject4 = this.kke.getBundle("jsapiargs");
        if (localObject4 != null) {
          ((u.b)localObject3).h("adExtStr", ((Bundle)localObject4).getString("key_snsad_statextstr"));
        }
        ((cj)localObject1).bIw.bIB = ((String)localObject2);
        a.udP.m((b)localObject1);
      }
      for (;;)
      {
        this.ret = ((cj)localObject1).bIx.ret;
        return;
        if (!bk.bl((String)localObject2))
        {
          localObject3 = new ra();
          ((ra)localObject3).cak.can = ((String)localObject2);
          ((ra)localObject3).cak.cao = ((cj)localObject1);
          ((ra)localObject3).cak.url = this.kke.getString("rawUrl");
          a.udP.m((b)localObject3);
          bool = ((ra)localObject3).cal.bIe;
          break;
        }
        if (i != 0)
        {
          localObject2 = new mr();
          ((mr)localObject2).bWk.opType = 3;
          ((mr)localObject2).bWk.bWm = ((cj)localObject1);
          ((mr)localObject2).bWk.bWn = i;
          ((mr)localObject2).bWk.bWo = ((String)localObject3);
          a.udP.m((b)localObject2);
          bool = ((mr)localObject2).bWl.bIe;
          break;
        }
        this.rbu = true;
        return;
        if (((cj)localObject1).bIw.bIC == 0) {
          ((cj)localObject1).bIw.bIC = R.l.favorite_fail_nonsupport;
        }
        a.udP.m((b)localObject1);
      }
    case 2: 
      localObject1 = new gf();
      ((gf)localObject1).bNF.type = 35;
      a.udP.m((b)localObject1);
      return;
    case 3: 
      label498:
      this.rbv = d.SP("favorite");
      return;
    }
    Object localObject1 = new ce();
    ((ce)localObject1).bIp.bIr = this.kke.getLong("fav_local_id", -1L);
    a.udP.m((b)localObject1);
    y.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(((ce)localObject1).bIp.bIr), Boolean.valueOf(((ce)localObject1).bIq.bIe) });
    this.bFQ = ((ce)localObject1).bIq.bIe;
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.actionType = paramParcel.readInt();
    this.kke = paramParcel.readBundle();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.rbu = bool1;
      if (paramParcel.readByte() != 1) {
        break label85;
      }
      bool1 = true;
      label43:
      this.bFQ = bool1;
      this.ret = paramParcel.readInt();
      this.type = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label90;
      }
    }
    label85:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.rbv = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label43;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.actionType);
    paramParcel.writeBundle(this.kke);
    if (this.rbu)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.bFQ) {
        break label85;
      }
      paramInt = 1;
      label42:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.ret);
      paramParcel.writeInt(this.type);
      if (!this.rbv) {
        break label90;
      }
    }
    label85:
    label90:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.FavUrlTask
 * JD-Core Version:    0.7.0.1
 */