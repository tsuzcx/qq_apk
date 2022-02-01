package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agq;
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
  private static HashMap<String, m> BDr;
  private int BCS;
  private String BCT;
  private Long BDp;
  private boolean BDq;
  private agq dkn;
  private int drO;
  private boolean drV;
  private String dsL;
  private c vbw;
  
  static
  {
    AppMethodBeat.i(30356);
    BDr = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.vbw = null;
    this.drO = 0;
    this.BCS = 0;
    this.BDq = false;
    this.dkn = new agq();
    this.BCF.clear();
    e.ciS();
    AppMethodBeat.o(30344);
  }
  
  private static c alt(String paramString)
  {
    AppMethodBeat.i(30347);
    pn localpn = new pn();
    localpn.dvb.type = 0;
    localpn.dvb.dvd = paramString;
    a.ESL.l(localpn);
    paramString = localpn.dvc.dvl;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void gQ(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.BCK);
    localIntent.putExtra("note_msgid", this.BDp);
    localIntent.putExtra("record_show_share", this.drV);
    localIntent.putExtra("fav_note_xml", this.dsL);
    localIntent.putExtra("fav_note_out_of_date", this.BDq);
    localIntent.putExtra("fav_note_scroll_to_position", this.drO);
    localIntent.putExtra("fav_note_scroll_to_offset", this.BCS);
    localIntent.putExtra("fav_note_scroll_to_offset", this.BCS);
    if (!bt.isNullOrNil(this.BCT)) {
      localIntent.putExtra("fav_note_link_source_info", this.BCT);
    }
    localIntent.putExtra("key_detail_fav_scene", this.dkn.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dkn.niJ);
    localIntent.putExtra("key_detail_fav_index", this.dkn.index);
    com.tencent.mm.bs.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(afy paramafy)
  {
    AppMethodBeat.i(30349);
    pn localpn = new pn();
    localpn.dvb.type = 1;
    localpn.dvb.djJ = paramafy;
    localpn.dvb.msgId = this.BDp.longValue();
    a.ESL.l(localpn);
    paramafy = localpn.dvc.thumbPath;
    AppMethodBeat.o(30349);
    return paramafy;
  }
  
  public final void a(afy paramafy, String paramString)
  {
    AppMethodBeat.i(30351);
    pn localpn = new pn();
    localpn.dvb.type = 8;
    localpn.dvb.djJ = paramafy;
    localpn.dvb.msgId = this.BDp.longValue();
    localpn.dvb.thumbPath = paramString;
    a.ESL.l(localpn);
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, agq paramagq)
  {
    AppMethodBeat.i(30345);
    this.dsL = paramString;
    this.BDp = paramLong;
    this.drV = paramBoolean;
    this.drO = paramInt1;
    this.BCS = paramInt2;
    this.dkn = paramagq;
    this.vbw = alt(paramString);
    if ((this.vbw != null) && (this.vbw.gKs != null) && (this.vbw.gKs.size() > 1))
    {
      paramString = new pn();
      paramString.dvb.type = 9;
      paramString.dvb.djJ = ((afy)this.vbw.gKs.get(0));
      paramString.dvb.msgId = this.BDp.longValue();
      a.ESL.l(paramString);
      this.BDq = paramString.dvc.dvn;
    }
    if ((this.vbw != null) && (this.vbw.Csh != null)) {}
    for (this.BCT = (this.vbw.Csh.Diw + ";" + this.vbw.Csh.Dix + ";" + this.vbw.oJi);; this.BCT = null)
    {
      gQ(paramContext);
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.gD(j.this.BCD.vaT);
          if (k.esO() != null) {
            k.esS();
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
  
  public final void bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.BDp);
    paramContext.putExtra("record_xml", this.dsL);
    paramContext.putExtra("record_data_id", ((o)this.BCH.get(paramString)).dkb);
    com.tencent.mm.bs.d.b(aj.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void by(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.BCH.get(paramString)).omH;
    if (((afy)localObject).DgT != null) {}
    for (localObject = ((afy)localObject).DgT.DhA;; localObject = null)
    {
      if (localObject != null) {
        if (bt.isNullOrNil(((aga)localObject).Did)) {
          break label99;
        }
      }
      label99:
      for (paramContext = v.sh(((aga)localObject).Did);; paramContext = v.sh(((aga)localObject).dpv))
      {
        paramString = (s)this.BCH.get(paramString);
        if (paramString != null) {
          break;
        }
        h.cf(aj.getContext(), aj.getContext().getString(2131758969));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.goQ);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.hdQ);
      if (paramString.BDP >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.BDP);
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
  
  public final void bz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.BDp);
    paramContext.putExtra("record_data_id", ((o)this.BCH.get(paramString)).dkb);
    paramContext.putExtra("record_xml", this.dsL);
    com.tencent.mm.bs.d.b(aj.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final String d(afy paramafy)
  {
    AppMethodBeat.i(30348);
    pn localpn = new pn();
    localpn.dvb.type = 1;
    localpn.dvb.djJ = paramafy;
    localpn.dvb.msgId = this.BDp.longValue();
    a.ESL.l(localpn);
    paramafy = localpn.dvc.dvm;
    AppMethodBeat.o(30348);
    return paramafy;
  }
  
  public final void p(afy paramafy)
  {
    AppMethodBeat.i(30350);
    pn localpn = new pn();
    localpn.dvb.type = 8;
    localpn.dvb.djJ = paramafy;
    localpn.dvb.msgId = this.BDp.longValue();
    localpn.dvb.thumbPath = "";
    a.ESL.l(localpn);
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */