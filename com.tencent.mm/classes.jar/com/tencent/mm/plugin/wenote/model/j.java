package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> CVx;
  private int CUY;
  private String CUZ;
  private Long CVv;
  private boolean CVw;
  private ahp dhI;
  private boolean dpG;
  private int dpz;
  private String dqv;
  private c wkk;
  
  static
  {
    AppMethodBeat.i(30356);
    CVx = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.wkk = null;
    this.dpz = 0;
    this.CUY = 0;
    this.CVw = false;
    this.dhI = new ahp();
    this.CUL.clear();
    e.cqz();
    AppMethodBeat.o(30344);
  }
  
  private static c aqs(String paramString)
  {
    AppMethodBeat.i(30347);
    pw localpw = new pw();
    localpw.dsN.type = 0;
    localpw.dsN.dsP = paramString;
    a.GpY.l(localpw);
    paramString = localpw.dsO.dsX;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void hb(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.CUQ);
    localIntent.putExtra("note_msgid", this.CVv);
    localIntent.putExtra("record_show_share", this.dpG);
    localIntent.putExtra("fav_note_xml", this.dqv);
    localIntent.putExtra("fav_note_out_of_date", this.CVw);
    localIntent.putExtra("fav_note_scroll_to_position", this.dpz);
    localIntent.putExtra("fav_note_scroll_to_offset", this.CUY);
    localIntent.putExtra("fav_note_scroll_to_offset", this.CUY);
    if (!bs.isNullOrNil(this.CUZ)) {
      localIntent.putExtra("fav_note_link_source_info", this.CUZ);
    }
    localIntent.putExtra("key_detail_fav_scene", this.dhI.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dhI.nLC);
    localIntent.putExtra("key_detail_fav_index", this.dhI.index);
    com.tencent.mm.br.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(agx paramagx)
  {
    AppMethodBeat.i(30349);
    pw localpw = new pw();
    localpw.dsN.type = 1;
    localpw.dsN.dhe = paramagx;
    localpw.dsN.msgId = this.CVv.longValue();
    a.GpY.l(localpw);
    paramagx = localpw.dsO.thumbPath;
    AppMethodBeat.o(30349);
    return paramagx;
  }
  
  public final void a(agx paramagx, String paramString)
  {
    AppMethodBeat.i(30351);
    pw localpw = new pw();
    localpw.dsN.type = 8;
    localpw.dsN.dhe = paramagx;
    localpw.dsN.msgId = this.CVv.longValue();
    localpw.dsN.thumbPath = paramString;
    a.GpY.l(localpw);
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, ahp paramahp)
  {
    AppMethodBeat.i(30345);
    this.dqv = paramString;
    this.CVv = paramLong;
    this.dpG = paramBoolean;
    this.dpz = paramInt1;
    this.CUY = paramInt2;
    this.dhI = paramahp;
    this.wkk = aqs(paramString);
    if ((this.wkk != null) && (this.wkk.hkS != null) && (this.wkk.hkS.size() > 1))
    {
      paramString = new pw();
      paramString.dsN.type = 9;
      paramString.dsN.dhe = ((agx)this.wkk.hkS.get(0));
      paramString.dsN.msgId = this.CVv.longValue();
      a.GpY.l(paramString);
      this.CVw = paramString.dsO.dsZ;
    }
    if ((this.wkk != null) && (this.wkk.DKz != null)) {}
    for (this.CUZ = (this.wkk.DKz.EBC + ";" + this.wkk.DKz.EBD + ";" + this.wkk.pmI);; this.CUZ = null)
    {
      hb(paramContext);
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.gO(j.this.CUJ.wjH);
          if (k.eIh() != null) {
            k.eIl();
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
  
  public final void bA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.CVv);
    paramContext.putExtra("record_data_id", ((o)this.CUN.get(paramString)).dhw);
    paramContext.putExtra("record_xml", this.dqv);
    com.tencent.mm.br.d.b(ai.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final void by(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.CVv);
    paramContext.putExtra("record_xml", this.dqv);
    paramContext.putExtra("record_data_id", ((o)this.CUN.get(paramString)).dhw);
    com.tencent.mm.br.d.b(ai.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void bz(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.CUN.get(paramString)).oQh;
    if (((agx)localObject).EzZ != null) {}
    for (localObject = ((agx)localObject).EzZ.EAG;; localObject = null)
    {
      if (localObject != null) {
        if (bs.isNullOrNil(((agz)localObject).EBj)) {
          break label99;
        }
      }
      label99:
      for (paramContext = v.wk(((agz)localObject).EBj);; paramContext = v.wk(((agz)localObject).dng))
      {
        paramString = (s)this.CUN.get(paramString);
        if (paramString != null) {
          break;
        }
        h.cg(ai.getContext(), ai.getContext().getString(2131758969));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.gPy);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.hEt);
      if (paramString.CVW >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.CVW);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.br.d.b(ai.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(30354);
      return;
    }
  }
  
  public final String d(agx paramagx)
  {
    AppMethodBeat.i(30348);
    pw localpw = new pw();
    localpw.dsN.type = 1;
    localpw.dsN.dhe = paramagx;
    localpw.dsN.msgId = this.CVv.longValue();
    a.GpY.l(localpw);
    paramagx = localpw.dsO.dsY;
    AppMethodBeat.o(30348);
    return paramagx;
  }
  
  public final void p(agx paramagx)
  {
    AppMethodBeat.i(30350);
    pw localpw = new pw();
    localpw.dsN.type = 8;
    localpw.dsN.dhe = paramagx;
    localpw.dsN.msgId = this.CVv.longValue();
    localpw.dsN.thumbPath = "";
    a.GpY.l(localpw);
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */