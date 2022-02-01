package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.ak.f
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> ERq;
  public String ERo;
  public String ERp;
  private int ERr;
  public String ERs;
  public int ERt;
  public long ERu;
  public String ERv;
  public String ERw;
  public boolean ERx;
  public long dCD;
  private int dCr;
  public boolean dCy;
  private akp dum;
  private com.tencent.mm.plugin.fav.a.g rGj;
  
  static
  {
    AppMethodBeat.i(30327);
    ERq = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.dCD = -1L;
    this.ERp = "";
    this.dCy = true;
    this.dCr = 0;
    this.ERr = 0;
    this.ERt = 0;
    this.ERu = 0L;
    this.dum = new akp();
    this.ERx = false;
    this.ERe.clear();
    this.ERd = null;
    pzM = "";
    this.ERj = false;
    e.cxF();
    bc.ajj().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String aLA(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.zd(this.dCD);
    if (localObject == null)
    {
      paramString = ((o)this.ERg.get(paramString)).dua;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.oeJ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajx localajx = (ajx)((Iterator)localObject).next();
      if ((!bu.isNullOrNil(localajx.GAC)) && (localajx.GAC.equals(paramString)))
      {
        paramString = localajx.dua;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.ERg.get(paramString)).dua;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  private void fax()
  {
    AppMethodBeat.i(30316);
    this.rGj = f.zd(this.dCD);
    if (this.rGj == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.ERu <= 0L) {
      this.ERu = this.rGj.field_updateTime;
    }
    this.ERk = this.rGj.field_favProto;
    this.ERd = this.rGj;
    AppMethodBeat.o(30316);
  }
  
  public final String a(ajx paramajx)
  {
    AppMethodBeat.i(30318);
    paramajx = f.a(paramajx);
    AppMethodBeat.o(30318);
    return paramajx;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, akp paramakp, final akn paramakn)
  {
    AppMethodBeat.i(30314);
    this.dCD = paramLong;
    this.dCy = paramBoolean.booleanValue();
    this.dCr = paramInt1;
    this.ERr = paramInt2;
    this.dum = paramakp;
    fax();
    if ((this.ERt == 0) && (this.ERk.GCe != null)) {
      this.ERt = this.ERk.GCe.sourceType;
    }
    an(paramContext, 2);
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramakn != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramakn;
          g.this.ERk = localg.field_favProto;
          g.this.ERd = localg;
          g.a(g.this, localg);
        }
        if (g.acO().containsKey(g.b(g.this))) {
          g.this.ERc = ((m)g.acO().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.hk(g.this.ERc.xHu);
          if (k.faM() != null) {
            k.faQ();
          }
          AppMethodBeat.o(30311);
          return;
          g.c(g.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(30312);
        String str = super.toString() + "|dealWNoteInfo";
        AppMethodBeat.o(30312);
        return str;
      }
    });
    AppMethodBeat.o(30314);
  }
  
  public final void a(ajx paramajx, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.ERc;
    gx localgx = new gx();
    localgx.dub.type = 28;
    localgx.dub.doH = localm.pyC.field_localId;
    localgx.dub.dud = paramajx;
    localgx.dub.path = paramString;
    localgx.dub.dui = 18;
    a.IvT.l(localgx);
    AppMethodBeat.o(30320);
  }
  
  public final void aLy(String paramString)
  {
    this.ERp = paramString;
  }
  
  public final void an(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.ERv);
      localIntent.putExtra("fav_note_link_sns_xml", this.ERw);
    }
    localIntent.putExtra("edit_status", this.ERj);
    localIntent.putExtra("need_save", this.ERx);
    localIntent.putExtra("show_share", this.dCy);
    localIntent.putExtra("note_fav_localid", this.dCD);
    localIntent.putExtra("note_link_sns_localid", this.ERo);
    localIntent.putExtra("fav_note_xml", this.ERp);
    localIntent.putExtra("fav_note_scroll_to_position", this.dCr);
    localIntent.putExtra("fav_note_scroll_to_offset", this.ERr);
    localIntent.putExtra("fav_note_link_source_info", this.ERs);
    localIntent.putExtra("note_fav_post_scene", this.ERt);
    localIntent.putExtra("key_detail_fav_scene", this.dum.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dum.otZ);
    localIntent.putExtra("key_detail_fav_index", this.dum.index);
    localIntent.putExtra("key_detail_fav_query", this.dum.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.dum.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.dum.rAT);
    com.tencent.mm.br.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void bD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.ERg.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.ERp);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", aLA(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.dCD);
    localIntent.putExtra("key_detail_fav_scene", this.dum.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dum.otZ);
    localIntent.putExtra("key_detail_fav_index", this.dum.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void bE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (s)this.ERg.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.h.cm(paramContext, ak.getContext().getString(2131758969));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.jGd);
    localIntent.putExtra("Kwebmap_locaion", paramString.hZQ);
    if (paramString.ESo >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.ESo);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.dCD);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final void bF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.ERp);
    if (this.ERg.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.ERg.get(paramString)).dua);
    }
    localIntent.putExtra("key_detail_info_id", this.dCD);
    localIntent.putExtra("key_detail_fav_scene", this.dum.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dum.otZ);
    localIntent.putExtra("key_detail_fav_index", this.dum.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final String d(ajx paramajx)
  {
    AppMethodBeat.i(30317);
    paramajx = f.b(paramajx);
    AppMethodBeat.o(30317);
    return paramajx;
  }
  
  public final String fav()
  {
    return this.ERp;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30324);
    if (paramn.getType() == 426)
    {
      paramString = new gx();
      paramString.dub.dpw = paramn;
      paramString.dub.type = 31;
      a.IvT.l(paramString);
      if ((!bu.isNullOrNil(paramString.duc.path)) && (paramInt2 == -435)) {
        ae.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      bc.ajj().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(ajx paramajx)
  {
    AppMethodBeat.i(30319);
    m localm = this.ERc;
    gx localgx = new gx();
    localgx.dub.type = 28;
    localgx.dub.doH = localm.pyC.field_localId;
    localgx.dub.dud = paramajx;
    localgx.dub.path = "";
    localgx.dub.dui = 18;
    a.IvT.l(localgx);
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */