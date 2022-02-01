package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> QGV;
  private com.tencent.mm.protocal.b.a.c HEg;
  private byte[] QGB;
  private Long QGT;
  private boolean QGU;
  private int QGv;
  private String QGw;
  private aoe fEm;
  private int fNJ;
  private boolean fNQ;
  private String fOE;
  
  static
  {
    AppMethodBeat.i(30356);
    QGV = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.HEg = null;
    this.fNJ = 0;
    this.QGv = 0;
    this.QGU = false;
    this.fEm = new aoe();
    this.QGB = null;
    this.QGi.clear();
    e.dkP();
    AppMethodBeat.o(30344);
  }
  
  private static com.tencent.mm.protocal.b.a.c aVz(String paramString)
  {
    AppMethodBeat.i(30347);
    sc localsc = new sc();
    localsc.fRw.type = 0;
    localsc.fRw.fRy = paramString;
    EventCenter.instance.publish(localsc);
    paramString = localsc.fRx.fRG;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void jj(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.QGn);
    localIntent.putExtra("note_msgid", this.QGT);
    localIntent.putExtra("record_show_share", this.fNQ);
    localIntent.putExtra("fav_note_xml", this.fOE);
    localIntent.putExtra("fav_note_out_of_date", this.QGU);
    localIntent.putExtra("fav_note_scroll_to_position", this.fNJ);
    localIntent.putExtra("fav_note_scroll_to_offset", this.QGv);
    localIntent.putExtra("fav_note_scroll_to_offset", this.QGv);
    if (!Util.isNullOrNil(this.QGw)) {
      localIntent.putExtra("fav_note_link_source_info", this.QGw);
    }
    localIntent.putExtra("key_detail_fav_scene", this.fEm.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.fEm.wGA);
    localIntent.putExtra("key_detail_fav_index", this.fEm.index);
    localIntent.putExtra("key_multi_task_common_info", this.QGB);
    com.tencent.mm.by.c.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(anm paramanm)
  {
    AppMethodBeat.i(30349);
    sc localsc = new sc();
    localsc.fRw.type = 1;
    localsc.fRw.fDI = paramanm;
    localsc.fRw.msgId = this.QGT.longValue();
    EventCenter.instance.publish(localsc);
    paramanm = localsc.fRx.thumbPath;
    AppMethodBeat.o(30349);
    return paramanm;
  }
  
  public final void a(anm paramanm, String paramString)
  {
    AppMethodBeat.i(30351);
    sc localsc = new sc();
    localsc.fRw.type = 8;
    localsc.fRw.fDI = paramanm;
    localsc.fRw.msgId = this.QGT.longValue();
    localsc.fRw.thumbPath = paramString;
    EventCenter.instance.publish(localsc);
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, aoe paramaoe, Bundle paramBundle)
  {
    AppMethodBeat.i(287613);
    this.fOE = paramString;
    this.QGT = paramLong;
    this.fNQ = paramBoolean;
    this.fNJ = paramInt1;
    this.QGv = paramInt2;
    this.fEm = paramaoe;
    if (paramBundle != null) {
      this.QGB = paramBundle.getByteArray("key_multi_task_common_info");
    }
    this.HEg = aVz(paramString);
    if ((this.HEg != null) && (this.HEg.lpz != null) && (this.HEg.lpz.size() > 1))
    {
      paramString = new sc();
      paramString.fRw.type = 9;
      paramString.fRw.fDI = ((anm)this.HEg.lpz.get(0));
      paramString.fRw.msgId = this.QGT.longValue();
      EventCenter.instance.publish(paramString);
      this.QGU = paramString.fRx.fRH;
    }
    if ((this.HEg != null) && (this.HEg.RDh != null)) {}
    for (this.QGw = (this.HEg.RDh.SAu + ";" + this.HEg.RDh.SAv + ";" + this.HEg.uTt);; this.QGw = null)
    {
      jj(paramContext);
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.jh(j.this.QGg.HDy);
          if (k.hdF() != null) {
            k.hdJ();
          }
          AppMethodBeat.o(30342);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(30343);
          String str = super.toString() + "|dealWNoteInfo";
          AppMethodBeat.o(30343);
          return str;
        }
      });
      AppMethodBeat.o(287613);
      return;
    }
  }
  
  public final void cj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.QGT);
    paramContext.putExtra("record_xml", this.fOE);
    paramContext.putExtra("record_data_id", ((o)this.QGk.get(paramString)).fEa);
    com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void ck(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.QGk.get(paramString)).urS;
    if (((anm)localObject).SyG != null) {}
    for (localObject = ((anm)localObject).SyG.Szn;; localObject = null)
    {
      if (localObject != null) {
        if (Util.isNullOrNil(((ano)localObject).SAb)) {
          break label99;
        }
      }
      label99:
      for (paramContext = aa.PJ(((ano)localObject).SAb);; paramContext = aa.PJ(((ano)localObject).fLi))
      {
        paramString = (s)this.QGk.get(paramString);
        if (paramString != null) {
          break;
        }
        h.cO(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_record_loc_error));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.poiName);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.lLg);
      if (paramString.QHt >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.QHt);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(30354);
      return;
    }
  }
  
  public final void cl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.QGT);
    paramContext.putExtra("record_data_id", ((o)this.QGk.get(paramString)).fEa);
    paramContext.putExtra("record_xml", this.fOE);
    com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final String d(anm paramanm)
  {
    AppMethodBeat.i(30348);
    sc localsc = new sc();
    localsc.fRw.type = 1;
    localsc.fRw.fDI = paramanm;
    localsc.fRw.msgId = this.QGT.longValue();
    EventCenter.instance.publish(localsc);
    paramanm = localsc.fRx.dataPath;
    AppMethodBeat.o(30348);
    return paramanm;
  }
  
  public final void p(anm paramanm)
  {
    AppMethodBeat.i(30350);
    sc localsc = new sc();
    localsc.fRw.type = 8;
    localsc.fRw.fDI = paramanm;
    localsc.fRw.msgId = this.QGT.longValue();
    localsc.fRw.thumbPath = "";
    EventCenter.instance.publish(localsc);
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */