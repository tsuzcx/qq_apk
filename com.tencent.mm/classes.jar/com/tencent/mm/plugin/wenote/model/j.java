package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> ERQ;
  private Long ERO;
  private boolean ERP;
  private int ERr;
  private String ERs;
  private int dCr;
  private boolean dCy;
  private String dDn;
  private akp dum;
  private c xHY;
  
  static
  {
    AppMethodBeat.i(30356);
    ERQ = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.xHY = null;
    this.dCr = 0;
    this.ERr = 0;
    this.ERP = false;
    this.dum = new akp();
    this.ERe.clear();
    e.cxF();
    AppMethodBeat.o(30344);
  }
  
  private static c awG(String paramString)
  {
    AppMethodBeat.i(30347);
    qi localqi = new qi();
    localqi.dFS.type = 0;
    localqi.dFS.dFU = paramString;
    a.IvT.l(localqi);
    paramString = localqi.dFT.dGd;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void hm(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.ERj);
    localIntent.putExtra("note_msgid", this.ERO);
    localIntent.putExtra("record_show_share", this.dCy);
    localIntent.putExtra("fav_note_xml", this.dDn);
    localIntent.putExtra("fav_note_out_of_date", this.ERP);
    localIntent.putExtra("fav_note_scroll_to_position", this.dCr);
    localIntent.putExtra("fav_note_scroll_to_offset", this.ERr);
    localIntent.putExtra("fav_note_scroll_to_offset", this.ERr);
    if (!bu.isNullOrNil(this.ERs)) {
      localIntent.putExtra("fav_note_link_source_info", this.ERs);
    }
    localIntent.putExtra("key_detail_fav_scene", this.dum.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dum.otZ);
    localIntent.putExtra("key_detail_fav_index", this.dum.index);
    com.tencent.mm.br.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(ajx paramajx)
  {
    AppMethodBeat.i(30349);
    qi localqi = new qi();
    localqi.dFS.type = 1;
    localqi.dFS.dtI = paramajx;
    localqi.dFS.msgId = this.ERO.longValue();
    a.IvT.l(localqi);
    paramajx = localqi.dFT.thumbPath;
    AppMethodBeat.o(30349);
    return paramajx;
  }
  
  public final void a(ajx paramajx, String paramString)
  {
    AppMethodBeat.i(30351);
    qi localqi = new qi();
    localqi.dFS.type = 8;
    localqi.dFS.dtI = paramajx;
    localqi.dFS.msgId = this.ERO.longValue();
    localqi.dFS.thumbPath = paramString;
    a.IvT.l(localqi);
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, akp paramakp)
  {
    AppMethodBeat.i(30345);
    this.dDn = paramString;
    this.ERO = paramLong;
    this.dCy = paramBoolean;
    this.dCr = paramInt1;
    this.ERr = paramInt2;
    this.dum = paramakp;
    this.xHY = awG(paramString);
    if ((this.xHY != null) && (this.xHY.hFT != null) && (this.xHY.hFT.size() > 1))
    {
      paramString = new qi();
      paramString.dFS.type = 9;
      paramString.dFS.dtI = ((ajx)this.xHY.hFT.get(0));
      paramString.dFS.msgId = this.ERO.longValue();
      a.IvT.l(paramString);
      this.ERP = paramString.dFT.dGf;
    }
    if ((this.xHY != null) && (this.xHY.FId != null)) {}
    for (this.ERs = (this.xHY.FId.GBX + ";" + this.xHY.FId.GBY + ";" + this.xHY.pWN);; this.ERs = null)
    {
      hm(paramContext);
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.hk(j.this.ERc.xHu);
          if (k.faM() != null) {
            k.faQ();
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
      AppMethodBeat.o(30345);
      return;
    }
  }
  
  public final void bD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.ERO);
    paramContext.putExtra("record_xml", this.dDn);
    paramContext.putExtra("record_data_id", ((o)this.ERg.get(paramString)).dua);
    com.tencent.mm.br.d.b(ak.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void bE(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.ERg.get(paramString)).pAv;
    if (((ajx)localObject).GAu != null) {}
    for (localObject = ((ajx)localObject).GAu.GBb;; localObject = null)
    {
      if (localObject != null) {
        if (bu.isNullOrNil(((ajz)localObject).GBE)) {
          break label99;
        }
      }
      label99:
      for (paramContext = w.zP(((ajz)localObject).GBE);; paramContext = w.zP(((ajz)localObject).dzZ))
      {
        paramString = (s)this.ERg.get(paramString);
        if (paramString != null) {
          break;
        }
        h.cm(ak.getContext(), ak.getContext().getString(2131758969));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.jGd);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.hZQ);
      if (paramString.ESo >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.ESo);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.br.d.b(ak.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(30354);
      return;
    }
  }
  
  public final void bF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.ERO);
    paramContext.putExtra("record_data_id", ((o)this.ERg.get(paramString)).dua);
    paramContext.putExtra("record_xml", this.dDn);
    com.tencent.mm.br.d.b(ak.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final String d(ajx paramajx)
  {
    AppMethodBeat.i(30348);
    qi localqi = new qi();
    localqi.dFS.type = 1;
    localqi.dFS.dtI = paramajx;
    localqi.dFS.msgId = this.ERO.longValue();
    a.IvT.l(localqi);
    paramajx = localqi.dFT.dGe;
    AppMethodBeat.o(30348);
    return paramajx;
  }
  
  public final void p(ajx paramajx)
  {
    AppMethodBeat.i(30350);
    qi localqi = new qi();
    localqi.dFS.type = 8;
    localqi.dFS.dtI = paramajx;
    localqi.dFS.msgId = this.ERO.longValue();
    localqi.dFS.thumbPath = "";
    a.IvT.l(localqi);
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */