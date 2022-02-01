package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.al.g
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> BCR;
  public String BCP;
  public String BCQ;
  private int BCS;
  public String BCT;
  public int BCU;
  public long BCV;
  public String BCW;
  public String BCX;
  public boolean BCY;
  private agq dkn;
  private int drO;
  public boolean drV;
  public long dsa;
  private com.tencent.mm.plugin.fav.a.g qfx;
  
  static
  {
    AppMethodBeat.i(30327);
    BCR = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.dsa = -1L;
    this.BCQ = "";
    this.drV = true;
    this.drO = 0;
    this.BCS = 0;
    this.BCU = 0;
    this.BCV = 0L;
    this.dkn = new agq();
    this.BCY = false;
    this.BCF.clear();
    this.BCE = null;
    olY = "";
    this.BCK = false;
    e.ciS();
    az.aeS().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String azn(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.rP(this.dsa);
    if (localObject == null)
    {
      paramString = ((o)this.BCH.get(paramString)).dkb;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.mVb.iterator();
    while (((Iterator)localObject).hasNext())
    {
      afy localafy = (afy)((Iterator)localObject).next();
      if ((!bt.isNullOrNil(localafy.Dhb)) && (localafy.Dhb.equals(paramString)))
      {
        paramString = localafy.dkb;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.BCH.get(paramString)).dkb;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  private void esz()
  {
    AppMethodBeat.i(30316);
    this.qfx = f.rP(this.dsa);
    if (this.qfx == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.BCV <= 0L) {
      this.BCV = this.qfx.field_updateTime;
    }
    this.BCL = this.qfx.field_favProto;
    this.BCE = this.qfx;
    AppMethodBeat.o(30316);
  }
  
  public final String a(afy paramafy)
  {
    AppMethodBeat.i(30318);
    paramafy = f.a(paramafy);
    AppMethodBeat.o(30318);
    return paramafy;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, agq paramagq, final ago paramago)
  {
    AppMethodBeat.i(30314);
    this.dsa = paramLong;
    this.drV = paramBoolean.booleanValue();
    this.drO = paramInt1;
    this.BCS = paramInt2;
    this.dkn = paramagq;
    esz();
    if ((this.BCU == 0) && (this.BCL.DiD != null)) {
      this.BCU = this.BCL.DiD.sourceType;
    }
    ae(paramContext, 2);
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramago != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramago;
          g.this.BCL = localg.field_favProto;
          g.this.BCE = localg;
          g.a(g.this, localg);
        }
        if (g.Zg().containsKey(g.b(g.this))) {
          g.this.BCD = ((m)g.Zg().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.gD(g.this.BCD.vaT);
          if (k.esO() != null) {
            k.esS();
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
  
  public final void a(afy paramafy, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.BCD;
    gs localgs = new gs();
    localgs.dkc.type = 28;
    localgs.dkc.deL = localm.okO.field_localId;
    localgs.dkc.dke = paramafy;
    localgs.dkc.path = paramString;
    localgs.dkc.dkj = 18;
    a.ESL.l(localgs);
    AppMethodBeat.o(30320);
  }
  
  public final void ae(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.BCW);
      localIntent.putExtra("fav_note_link_sns_xml", this.BCX);
    }
    localIntent.putExtra("edit_status", this.BCK);
    localIntent.putExtra("need_save", this.BCY);
    localIntent.putExtra("show_share", this.drV);
    localIntent.putExtra("note_fav_localid", this.dsa);
    localIntent.putExtra("note_link_sns_localid", this.BCP);
    localIntent.putExtra("fav_note_xml", this.BCQ);
    localIntent.putExtra("fav_note_scroll_to_position", this.drO);
    localIntent.putExtra("fav_note_scroll_to_offset", this.BCS);
    localIntent.putExtra("fav_note_link_source_info", this.BCT);
    localIntent.putExtra("note_fav_post_scene", this.BCU);
    localIntent.putExtra("key_detail_fav_scene", this.dkn.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dkn.niJ);
    localIntent.putExtra("key_detail_fav_index", this.dkn.index);
    localIntent.putExtra("key_detail_fav_query", this.dkn.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.dkn.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.dkn.pZZ);
    com.tencent.mm.bs.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void azl(String paramString)
  {
    this.BCQ = paramString;
  }
  
  public final void bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.BCH.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.BCQ);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", azn(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.dsa);
    localIntent.putExtra("key_detail_fav_scene", this.dkn.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dkn.niJ);
    localIntent.putExtra("key_detail_fav_index", this.dkn.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void by(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (s)this.BCH.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.h.cf(paramContext, aj.getContext().getString(2131758969));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.goQ);
    localIntent.putExtra("Kwebmap_locaion", paramString.hdQ);
    if (paramString.BDP >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.BDP);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.dsa);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    com.tencent.mm.bs.d.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final void bz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.BCQ);
    if (this.BCH.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.BCH.get(paramString)).dkb);
    }
    localIntent.putExtra("key_detail_info_id", this.dsa);
    localIntent.putExtra("key_detail_fav_scene", this.dkn.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dkn.niJ);
    localIntent.putExtra("key_detail_fav_index", this.dkn.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final String d(afy paramafy)
  {
    AppMethodBeat.i(30317);
    paramafy = f.b(paramafy);
    AppMethodBeat.o(30317);
    return paramafy;
  }
  
  public final String esx()
  {
    return this.BCQ;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30324);
    if (paramn.getType() == 426)
    {
      paramString = new gs();
      paramString.dkc.dfA = paramn;
      paramString.dkc.type = 31;
      a.ESL.l(paramString);
      if ((!bt.isNullOrNil(paramString.dkd.path)) && (paramInt2 == -435)) {
        ad.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      az.aeS().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(afy paramafy)
  {
    AppMethodBeat.i(30319);
    m localm = this.BCD;
    gs localgs = new gs();
    localgs.dkc.type = 28;
    localgs.dkc.deL = localm.okO.field_localId;
    localgs.dkc.dke = paramafy;
    localgs.dkc.path = "";
    localgs.dkc.dkj = 18;
    a.ESL.l(localgs);
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */