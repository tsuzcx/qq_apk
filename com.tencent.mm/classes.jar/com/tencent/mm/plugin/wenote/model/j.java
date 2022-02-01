package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.and;
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
  private static HashMap<String, m> JHD;
  private com.tencent.mm.protocal.b.a.c BHZ;
  private Long JHB;
  private boolean JHC;
  private int JHd;
  private String JHe;
  private byte[] JHj;
  private and dLx;
  private int dUh;
  private boolean dUo;
  private String dVc;
  
  static
  {
    AppMethodBeat.i(30356);
    JHD = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.BHZ = null;
    this.dUh = 0;
    this.JHd = 0;
    this.JHC = false;
    this.dLx = new and();
    this.JHj = null;
    this.JGQ.clear();
    e.cVJ();
    AppMethodBeat.o(30344);
  }
  
  private static com.tencent.mm.protocal.b.a.c aKY(String paramString)
  {
    AppMethodBeat.i(30347);
    rc localrc = new rc();
    localrc.dXF.type = 0;
    localrc.dXF.dXH = paramString;
    EventCenter.instance.publish(localrc);
    paramString = localrc.dXG.dXP;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void ig(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.JGV);
    localIntent.putExtra("note_msgid", this.JHB);
    localIntent.putExtra("record_show_share", this.dUo);
    localIntent.putExtra("fav_note_xml", this.dVc);
    localIntent.putExtra("fav_note_out_of_date", this.JHC);
    localIntent.putExtra("fav_note_scroll_to_position", this.dUh);
    localIntent.putExtra("fav_note_scroll_to_offset", this.JHd);
    localIntent.putExtra("fav_note_scroll_to_offset", this.JHd);
    if (!Util.isNullOrNil(this.JHe)) {
      localIntent.putExtra("fav_note_link_source_info", this.JHe);
    }
    localIntent.putExtra("key_detail_fav_scene", this.dLx.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
    localIntent.putExtra("key_detail_fav_index", this.dLx.index);
    localIntent.putExtra("key_multi_task_common_info", this.JHj);
    com.tencent.mm.br.c.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(aml paramaml)
  {
    AppMethodBeat.i(30349);
    rc localrc = new rc();
    localrc.dXF.type = 1;
    localrc.dXF.dKT = paramaml;
    localrc.dXF.msgId = this.JHB.longValue();
    EventCenter.instance.publish(localrc);
    paramaml = localrc.dXG.thumbPath;
    AppMethodBeat.o(30349);
    return paramaml;
  }
  
  public final void a(aml paramaml, String paramString)
  {
    AppMethodBeat.i(30351);
    rc localrc = new rc();
    localrc.dXF.type = 8;
    localrc.dXF.dKT = paramaml;
    localrc.dXF.msgId = this.JHB.longValue();
    localrc.dXF.thumbPath = paramString;
    EventCenter.instance.publish(localrc);
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, and paramand, Bundle paramBundle)
  {
    AppMethodBeat.i(232132);
    this.dVc = paramString;
    this.JHB = paramLong;
    this.dUo = paramBoolean;
    this.dUh = paramInt1;
    this.JHd = paramInt2;
    this.dLx = paramand;
    if (paramBundle != null) {
      this.JHj = paramBundle.getByteArray("key_multi_task_common_info");
    }
    this.BHZ = aKY(paramString);
    if ((this.BHZ != null) && (this.BHZ.iAd != null) && (this.BHZ.iAd.size() > 1))
    {
      paramString = new rc();
      paramString.dXF.type = 9;
      paramString.dXF.dKT = ((aml)this.BHZ.iAd.get(0));
      paramString.dXF.msgId = this.JHB.longValue();
      EventCenter.instance.publish(paramString);
      this.JHC = paramString.dXG.dXQ;
    }
    if ((this.BHZ != null) && (this.BHZ.KBr != null)) {}
    for (this.JHe = (this.BHZ.KBr.LxT + ";" + this.BHZ.KBr.LxU + ";" + this.BHZ.rnM);; this.JHe = null)
    {
      ig(paramContext);
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.iq(j.this.JGO.BHs);
          if (k.gjR() != null) {
            k.gjV();
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
      AppMethodBeat.o(232132);
      return;
    }
  }
  
  public final void bX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.JHB);
    paramContext.putExtra("record_xml", this.dVc);
    paramContext.putExtra("record_data_id", ((o)this.JGS.get(paramString)).dLl);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void bY(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.JGS.get(paramString)).qPM;
    if (((aml)localObject).Lwh != null) {}
    for (localObject = ((aml)localObject).Lwh.LwO;; localObject = null)
    {
      if (localObject != null) {
        if (Util.isNullOrNil(((amn)localObject).LxA)) {
          break label99;
        }
      }
      label99:
      for (paramContext = aa.getDisplayName(((amn)localObject).LxA);; paramContext = aa.getDisplayName(((amn)localObject).dRL))
      {
        paramString = (s)this.JGS.get(paramString);
        if (paramString != null) {
          break;
        }
        h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131759293));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.kHV);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.iUO);
      if (paramString.JIb >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.JIb);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(30354);
      return;
    }
  }
  
  public final void bZ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.JHB);
    paramContext.putExtra("record_data_id", ((o)this.JGS.get(paramString)).dLl);
    paramContext.putExtra("record_xml", this.dVc);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final String d(aml paramaml)
  {
    AppMethodBeat.i(30348);
    rc localrc = new rc();
    localrc.dXF.type = 1;
    localrc.dXF.dKT = paramaml;
    localrc.dXF.msgId = this.JHB.longValue();
    EventCenter.instance.publish(localrc);
    paramaml = localrc.dXG.dataPath;
    AppMethodBeat.o(30348);
    return paramaml;
  }
  
  public final void p(aml paramaml)
  {
    AppMethodBeat.i(30350);
    rc localrc = new rc();
    localrc.dXF.type = 8;
    localrc.dXF.dKT = paramaml;
    localrc.dXF.msgId = this.JHB.longValue();
    localrc.dXF.thumbPath = "";
    EventCenter.instance.publish(localrc);
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */