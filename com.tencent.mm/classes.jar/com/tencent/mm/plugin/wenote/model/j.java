package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> Ezu;
  private int EyV;
  private String EyW;
  private Long Ezs;
  private boolean Ezt;
  private int dBm;
  private boolean dBt;
  private String dCi;
  private akf dtg;
  private c xsb;
  
  static
  {
    AppMethodBeat.i(30356);
    Ezu = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.xsb = null;
    this.dBm = 0;
    this.EyV = 0;
    this.Ezt = false;
    this.dtg = new akf();
    this.EyI.clear();
    e.cwe();
    AppMethodBeat.o(30344);
  }
  
  private static c avr(String paramString)
  {
    AppMethodBeat.i(30347);
    qh localqh = new qh();
    localqh.dEN.type = 0;
    localqh.dEN.dEP = paramString;
    a.IbL.l(localqh);
    paramString = localqh.dEO.dEY;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void hg(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.EyN);
    localIntent.putExtra("note_msgid", this.Ezs);
    localIntent.putExtra("record_show_share", this.dBt);
    localIntent.putExtra("fav_note_xml", this.dCi);
    localIntent.putExtra("fav_note_out_of_date", this.Ezt);
    localIntent.putExtra("fav_note_scroll_to_position", this.dBm);
    localIntent.putExtra("fav_note_scroll_to_offset", this.EyV);
    localIntent.putExtra("fav_note_scroll_to_offset", this.EyV);
    if (!bt.isNullOrNil(this.EyW)) {
      localIntent.putExtra("fav_note_link_source_info", this.EyW);
    }
    localIntent.putExtra("key_detail_fav_scene", this.dtg.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dtg.ooi);
    localIntent.putExtra("key_detail_fav_index", this.dtg.index);
    com.tencent.mm.bs.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(ajn paramajn)
  {
    AppMethodBeat.i(30349);
    qh localqh = new qh();
    localqh.dEN.type = 1;
    localqh.dEN.dsC = paramajn;
    localqh.dEN.msgId = this.Ezs.longValue();
    a.IbL.l(localqh);
    paramajn = localqh.dEO.thumbPath;
    AppMethodBeat.o(30349);
    return paramajn;
  }
  
  public final void a(ajn paramajn, String paramString)
  {
    AppMethodBeat.i(30351);
    qh localqh = new qh();
    localqh.dEN.type = 8;
    localqh.dEN.dsC = paramajn;
    localqh.dEN.msgId = this.Ezs.longValue();
    localqh.dEN.thumbPath = paramString;
    a.IbL.l(localqh);
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, akf paramakf)
  {
    AppMethodBeat.i(30345);
    this.dCi = paramString;
    this.Ezs = paramLong;
    this.dBt = paramBoolean;
    this.dBm = paramInt1;
    this.EyV = paramInt2;
    this.dtg = paramakf;
    this.xsb = avr(paramString);
    if ((this.xsb != null) && (this.xsb.hDb != null) && (this.xsb.hDb.size() > 1))
    {
      paramString = new qh();
      paramString.dEN.type = 9;
      paramString.dEN.dsC = ((ajn)this.xsb.hDb.get(0));
      paramString.dEN.msgId = this.Ezs.longValue();
      a.IbL.l(paramString);
      this.Ezt = paramString.dEO.dFa;
    }
    if ((this.xsb != null) && (this.xsb.FpF != null)) {}
    for (this.EyW = (this.xsb.FpF.Gjo + ";" + this.xsb.FpF.Gjp + ";" + this.xsb.pQi);; this.EyW = null)
    {
      hg(paramContext);
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.ha(j.this.EyG.xrx);
          if (k.eXa() != null) {
            k.eXe();
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
  
  public final void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.Ezs);
    paramContext.putExtra("record_xml", this.dCi);
    paramContext.putExtra("record_data_id", ((o)this.EyK.get(paramString)).dsU);
    com.tencent.mm.bs.d.b(aj.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void bD(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.EyK.get(paramString)).ptR;
    if (((ajn)localObject).GhL != null) {}
    for (localObject = ((ajn)localObject).GhL.Gis;; localObject = null)
    {
      if (localObject != null) {
        if (bt.isNullOrNil(((ajp)localObject).GiV)) {
          break label99;
        }
      }
      label99:
      for (paramContext = v.zf(((ajp)localObject).GiV);; paramContext = v.zf(((ajp)localObject).dyU))
      {
        paramString = (s)this.EyK.get(paramString);
        if (paramString != null) {
          break;
        }
        h.cl(aj.getContext(), aj.getContext().getString(2131758969));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.jDf);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.hWY);
      if (paramString.EzS >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.EzS);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.bs.d.b(aj.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(30354);
      return;
    }
  }
  
  public final void bE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.Ezs);
    paramContext.putExtra("record_data_id", ((o)this.EyK.get(paramString)).dsU);
    paramContext.putExtra("record_xml", this.dCi);
    com.tencent.mm.bs.d.b(aj.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final String d(ajn paramajn)
  {
    AppMethodBeat.i(30348);
    qh localqh = new qh();
    localqh.dEN.type = 1;
    localqh.dEN.dsC = paramajn;
    localqh.dEN.msgId = this.Ezs.longValue();
    a.IbL.l(localqh);
    paramajn = localqh.dEO.dEZ;
    AppMethodBeat.o(30348);
    return paramajn;
  }
  
  public final void p(ajn paramajn)
  {
    AppMethodBeat.i(30350);
    qh localqh = new qh();
    localqh.dEN.type = 8;
    localqh.dEN.dsC = paramajn;
    localqh.dEN.msgId = this.Ezs.longValue();
    localqh.dEN.thumbPath = "";
    a.IbL.l(localqh);
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */