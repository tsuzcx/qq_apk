package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.al.f
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> EyU;
  public String EyS;
  public String EyT;
  private int EyV;
  public String EyW;
  public int EyX;
  public long EyY;
  public String EyZ;
  public String Eza;
  public boolean Ezb;
  private int dBm;
  public boolean dBt;
  public long dBy;
  private akf dtg;
  private com.tencent.mm.plugin.fav.a.g rxY;
  
  static
  {
    AppMethodBeat.i(30327);
    EyU = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.dBy = -1L;
    this.EyT = "";
    this.dBt = true;
    this.dBm = 0;
    this.EyV = 0;
    this.EyX = 0;
    this.EyY = 0L;
    this.dtg = new akf();
    this.Ezb = false;
    this.EyI.clear();
    this.EyH = null;
    ptg = "";
    this.EyN = false;
    e.cwe();
    ba.aiU().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String aKe(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.yE(this.dBy);
    if (localObject == null)
    {
      paramString = ((o)this.EyK.get(paramString)).dsU;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.nZa.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajn localajn = (ajn)((Iterator)localObject).next();
      if ((!bt.isNullOrNil(localajn.GhT)) && (localajn.GhT.equals(paramString)))
      {
        paramString = localajn.dsU;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.EyK.get(paramString)).dsU;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  private void eWL()
  {
    AppMethodBeat.i(30316);
    this.rxY = f.yE(this.dBy);
    if (this.rxY == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.EyY <= 0L) {
      this.EyY = this.rxY.field_updateTime;
    }
    this.EyO = this.rxY.field_favProto;
    this.EyH = this.rxY;
    AppMethodBeat.o(30316);
  }
  
  public final String a(ajn paramajn)
  {
    AppMethodBeat.i(30318);
    paramajn = f.a(paramajn);
    AppMethodBeat.o(30318);
    return paramajn;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, akf paramakf, final akd paramakd)
  {
    AppMethodBeat.i(30314);
    this.dBy = paramLong;
    this.dBt = paramBoolean.booleanValue();
    this.dBm = paramInt1;
    this.EyV = paramInt2;
    this.dtg = paramakf;
    eWL();
    if ((this.EyX == 0) && (this.EyO.Gjv != null)) {
      this.EyX = this.EyO.Gjv.sourceType;
    }
    an(paramContext, 2);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramakd != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramakd;
          g.this.EyO = localg.field_favProto;
          g.this.EyH = localg;
          g.a(g.this, localg);
        }
        if (g.acD().containsKey(g.b(g.this))) {
          g.this.EyG = ((m)g.acD().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.ha(g.this.EyG.xrx);
          if (k.eXa() != null) {
            k.eXe();
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
  
  public final void a(ajn paramajn, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.EyG;
    gw localgw = new gw();
    localgw.dsV.type = 28;
    localgw.dsV.dnC = localm.prW.field_localId;
    localgw.dsV.dsX = paramajn;
    localgw.dsV.path = paramString;
    localgw.dsV.dtc = 18;
    a.IbL.l(localgw);
    AppMethodBeat.o(30320);
  }
  
  public final void aKc(String paramString)
  {
    this.EyT = paramString;
  }
  
  public final void an(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.EyZ);
      localIntent.putExtra("fav_note_link_sns_xml", this.Eza);
    }
    localIntent.putExtra("edit_status", this.EyN);
    localIntent.putExtra("need_save", this.Ezb);
    localIntent.putExtra("show_share", this.dBt);
    localIntent.putExtra("note_fav_localid", this.dBy);
    localIntent.putExtra("note_link_sns_localid", this.EyS);
    localIntent.putExtra("fav_note_xml", this.EyT);
    localIntent.putExtra("fav_note_scroll_to_position", this.dBm);
    localIntent.putExtra("fav_note_scroll_to_offset", this.EyV);
    localIntent.putExtra("fav_note_link_source_info", this.EyW);
    localIntent.putExtra("note_fav_post_scene", this.EyX);
    localIntent.putExtra("key_detail_fav_scene", this.dtg.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dtg.ooi);
    localIntent.putExtra("key_detail_fav_index", this.dtg.index);
    localIntent.putExtra("key_detail_fav_query", this.dtg.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.dtg.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.dtg.rsG);
    com.tencent.mm.bs.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.EyK.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.EyT);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", aKe(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.dBy);
    localIntent.putExtra("key_detail_fav_scene", this.dtg.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dtg.ooi);
    localIntent.putExtra("key_detail_fav_index", this.dtg.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void bD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (s)this.EyK.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.h.cl(paramContext, aj.getContext().getString(2131758969));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.jDf);
    localIntent.putExtra("Kwebmap_locaion", paramString.hWY);
    if (paramString.EzS >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.EzS);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.dBy);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    com.tencent.mm.bs.d.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final void bE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.EyT);
    if (this.EyK.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.EyK.get(paramString)).dsU);
    }
    localIntent.putExtra("key_detail_info_id", this.dBy);
    localIntent.putExtra("key_detail_fav_scene", this.dtg.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dtg.ooi);
    localIntent.putExtra("key_detail_fav_index", this.dtg.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final String d(ajn paramajn)
  {
    AppMethodBeat.i(30317);
    paramajn = f.b(paramajn);
    AppMethodBeat.o(30317);
    return paramajn;
  }
  
  public final String eWJ()
  {
    return this.EyT;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30324);
    if (paramn.getType() == 426)
    {
      paramString = new gw();
      paramString.dsV.dor = paramn;
      paramString.dsV.type = 31;
      a.IbL.l(paramString);
      if ((!bt.isNullOrNil(paramString.dsW.path)) && (paramInt2 == -435)) {
        ad.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      ba.aiU().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(ajn paramajn)
  {
    AppMethodBeat.i(30319);
    m localm = this.EyG;
    gw localgw = new gw();
    localgw.dsV.type = 28;
    localgw.dsV.dnC = localm.prW.field_localId;
    localgw.dsV.dsX = paramajn;
    localgw.dsV.path = "";
    localgw.dsV.dtc = 18;
    a.IbL.l(localgw);
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */