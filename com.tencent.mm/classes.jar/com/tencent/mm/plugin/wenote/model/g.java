package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.ak.i
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> JHc;
  public String JHa;
  public String JHb;
  private int JHd;
  public String JHe;
  public int JHf;
  public long JHg;
  public String JHh;
  public String JHi;
  public byte[] JHj;
  public boolean JHk;
  private and dLx;
  private int dUh;
  public boolean dUo;
  public long dUt;
  private com.tencent.mm.plugin.fav.a.g tfP;
  
  static
  {
    AppMethodBeat.i(30327);
    JHc = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.dUt = -1L;
    this.JHb = "";
    this.dUo = true;
    this.dUh = 0;
    this.JHd = 0;
    this.JHf = 0;
    this.JHg = 0L;
    this.dLx = new and();
    this.JHj = null;
    this.JHk = false;
    this.JGQ.clear();
    this.JGP = null;
    qPd = "";
    this.JGV = false;
    e.cVJ();
    bg.azz().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String bbQ(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.HT(this.dUt);
    if (localObject == null)
    {
      paramString = ((o)this.JGS.get(paramString)).dLl;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.ppH.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aml localaml = (aml)((Iterator)localObject).next();
      if ((!Util.isNullOrNil(localaml.Lwp)) && (localaml.Lwp.equals(paramString)))
      {
        paramString = localaml.dLl;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.JGS.get(paramString)).dLl;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  private void gjC()
  {
    AppMethodBeat.i(30316);
    this.tfP = f.HT(this.dUt);
    if (this.tfP == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.JHg <= 0L) {
      this.JHg = this.tfP.field_updateTime;
    }
    this.JGW = this.tfP.field_favProto;
    this.JGP = this.tfP;
    AppMethodBeat.o(30316);
  }
  
  public final String a(aml paramaml)
  {
    AppMethodBeat.i(30318);
    paramaml = f.a(paramaml);
    AppMethodBeat.o(30318);
    return paramaml;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, and paramand, final anb paramanb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232131);
    this.dUt = paramLong;
    this.dUo = paramBoolean.booleanValue();
    this.dUh = paramInt1;
    this.JHd = paramInt2;
    this.dLx = paramand;
    this.JHj = paramArrayOfByte;
    gjC();
    if ((this.JHf == 0) && (this.JGW.Lya != null)) {
      this.JHf = this.JGW.Lya.sourceType;
    }
    aw(paramContext, 2);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramanb != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramanb;
          g.this.JGW = localg.field_favProto;
          g.this.JGP = localg;
          g.a(g.this, localg);
        }
        if (g.aqM().containsKey(g.b(g.this))) {
          g.this.JGO = ((m)g.aqM().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.iq(g.this.JGO.BHs);
          if (k.gjR() != null) {
            k.gjV();
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
    AppMethodBeat.o(232131);
  }
  
  public final void a(aml paramaml, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.JGO;
    hb localhb = new hb();
    localhb.dLm.type = 28;
    localhb.dLm.dFW = localm.qNT.field_localId;
    localhb.dLm.dLo = paramaml;
    localhb.dLm.path = paramString;
    localhb.dLm.dLt = 18;
    EventCenter.instance.publish(localhb);
    AppMethodBeat.o(30320);
  }
  
  public final void aw(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.JHh);
      localIntent.putExtra("fav_note_link_sns_xml", this.JHi);
    }
    localIntent.putExtra("edit_status", this.JGV);
    localIntent.putExtra("need_save", this.JHk);
    localIntent.putExtra("show_share", this.dUo);
    localIntent.putExtra("note_fav_localid", this.dUt);
    localIntent.putExtra("note_link_sns_localid", this.JHa);
    localIntent.putExtra("fav_note_xml", this.JHb);
    localIntent.putExtra("fav_note_scroll_to_position", this.dUh);
    localIntent.putExtra("fav_note_scroll_to_offset", this.JHd);
    localIntent.putExtra("fav_note_link_source_info", this.JHe);
    localIntent.putExtra("note_fav_post_scene", this.JHf);
    localIntent.putExtra("key_detail_fav_scene", this.dLx.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
    localIntent.putExtra("key_detail_fav_index", this.dLx.index);
    localIntent.putExtra("key_detail_fav_query", this.dLx.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.dLx.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.dLx.tay);
    localIntent.putExtra("key_multi_task_common_info", this.JHj);
    c.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void bX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.JGS.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.JHb);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", bbQ(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.dUt);
    localIntent.putExtra("key_detail_fav_scene", this.dLx.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
    localIntent.putExtra("key_detail_fav_index", this.dLx.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void bY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (s)this.JGS.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.h.cD(paramContext, MMApplicationContext.getContext().getString(2131759293));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.kHV);
    localIntent.putExtra("Kwebmap_locaion", paramString.iUO);
    if (paramString.JIb >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.JIb);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.dUt);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    c.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final void bZ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.JHb);
    if (this.JGS.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.JGS.get(paramString)).dLl);
    }
    localIntent.putExtra("key_detail_info_id", this.dUt);
    localIntent.putExtra("key_detail_fav_scene", this.dLx.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dLx.pHw);
    localIntent.putExtra("key_detail_fav_index", this.dLx.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final void bbO(String paramString)
  {
    this.JHb = paramString;
  }
  
  public final String d(aml paramaml)
  {
    AppMethodBeat.i(30317);
    paramaml = f.b(paramaml);
    AppMethodBeat.o(30317);
    return paramaml;
  }
  
  public final String gjA()
  {
    return this.JHb;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30324);
    if (paramq.getType() == 426)
    {
      paramString = new hb();
      paramString.dLm.dGJ = paramq;
      paramString.dLm.type = 31;
      EventCenter.instance.publish(paramString);
      if ((!Util.isNullOrNil(paramString.dLn.path)) && (paramInt2 == -435)) {
        Log.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      bg.azz().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(aml paramaml)
  {
    AppMethodBeat.i(30319);
    m localm = this.JGO;
    hb localhb = new hb();
    localhb.dLm.type = 28;
    localhb.dLm.dFW = localm.qNT.field_localId;
    localhb.dLm.dLo = paramaml;
    localhb.dLm.path = "";
    localhb.dLm.dLt = 18;
    EventCenter.instance.publish(localhb);
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */