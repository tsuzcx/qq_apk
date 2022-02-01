package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.ak.g
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> CUX;
  public String CUV;
  public String CUW;
  private int CUY;
  public String CUZ;
  public int CVa;
  public long CVb;
  public String CVc;
  public String CVd;
  public boolean CVe;
  private ahp dhI;
  public boolean dpG;
  public long dpL;
  private int dpz;
  private com.tencent.mm.plugin.fav.a.g qNZ;
  
  static
  {
    AppMethodBeat.i(30327);
    CUX = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.dpL = -1L;
    this.CUW = "";
    this.dpG = true;
    this.dpz = 0;
    this.CUY = 0;
    this.CVa = 0;
    this.CVb = 0L;
    this.dhI = new ahp();
    this.CVe = false;
    this.CUL.clear();
    this.CUK = null;
    oPy = "";
    this.CUQ = false;
    e.cqz();
    az.agi().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String aEE(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.ws(this.dpL);
    if (localObject == null)
    {
      paramString = ((o)this.CUN.get(paramString)).dhw;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.nxC.iterator();
    while (((Iterator)localObject).hasNext())
    {
      agx localagx = (agx)((Iterator)localObject).next();
      if ((!bs.isNullOrNil(localagx.EAh)) && (localagx.EAh.equals(paramString)))
      {
        paramString = localagx.dhw;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.CUN.get(paramString)).dhw;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  private void eHS()
  {
    AppMethodBeat.i(30316);
    this.qNZ = f.ws(this.dpL);
    if (this.qNZ == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.CVb <= 0L) {
      this.CVb = this.qNZ.field_updateTime;
    }
    this.CUR = this.qNZ.field_favProto;
    this.CUK = this.qNZ;
    AppMethodBeat.o(30316);
  }
  
  public final String a(agx paramagx)
  {
    AppMethodBeat.i(30318);
    paramagx = f.a(paramagx);
    AppMethodBeat.o(30318);
    return paramagx;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, ahp paramahp, final ahn paramahn)
  {
    AppMethodBeat.i(30314);
    this.dpL = paramLong;
    this.dpG = paramBoolean.booleanValue();
    this.dpz = paramInt1;
    this.CUY = paramInt2;
    this.dhI = paramahp;
    eHS();
    if ((this.CVa == 0) && (this.CUR.EBJ != null)) {
      this.CVa = this.CUR.EBJ.sourceType;
    }
    ak(paramContext, 2);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramahn != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramahn;
          g.this.CUR = localg.field_favProto;
          g.this.CUK = localg;
          g.a(g.this, localg);
        }
        if (g.aab().containsKey(g.b(g.this))) {
          g.this.CUJ = ((m)g.aab().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.gO(g.this.CUJ.wjH);
          if (k.eIh() != null) {
            k.eIl();
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
  
  public final void a(agx paramagx, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.CUJ;
    gt localgt = new gt();
    localgt.dhx.type = 28;
    localgt.dhx.dcg = localm.oOo.field_localId;
    localgt.dhx.dhz = paramagx;
    localgt.dhx.path = paramString;
    localgt.dhx.dhE = 18;
    a.GpY.l(localgt);
    AppMethodBeat.o(30320);
  }
  
  public final void aEC(String paramString)
  {
    this.CUW = paramString;
  }
  
  public final void ak(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.CVc);
      localIntent.putExtra("fav_note_link_sns_xml", this.CVd);
    }
    localIntent.putExtra("edit_status", this.CUQ);
    localIntent.putExtra("need_save", this.CVe);
    localIntent.putExtra("show_share", this.dpG);
    localIntent.putExtra("note_fav_localid", this.dpL);
    localIntent.putExtra("note_link_sns_localid", this.CUV);
    localIntent.putExtra("fav_note_xml", this.CUW);
    localIntent.putExtra("fav_note_scroll_to_position", this.dpz);
    localIntent.putExtra("fav_note_scroll_to_offset", this.CUY);
    localIntent.putExtra("fav_note_link_source_info", this.CUZ);
    localIntent.putExtra("note_fav_post_scene", this.CVa);
    localIntent.putExtra("key_detail_fav_scene", this.dhI.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dhI.nLC);
    localIntent.putExtra("key_detail_fav_index", this.dhI.index);
    localIntent.putExtra("key_detail_fav_query", this.dhI.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.dhI.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.dhI.qIF);
    com.tencent.mm.br.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void bA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.CUW);
    if (this.CUN.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.CUN.get(paramString)).dhw);
    }
    localIntent.putExtra("key_detail_info_id", this.dpL);
    localIntent.putExtra("key_detail_fav_scene", this.dhI.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dhI.nLC);
    localIntent.putExtra("key_detail_fav_index", this.dhI.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final void by(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.CUN.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.CUW);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", aEE(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.dpL);
    localIntent.putExtra("key_detail_fav_scene", this.dhI.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.dhI.nLC);
    localIntent.putExtra("key_detail_fav_index", this.dhI.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void bz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (s)this.CUN.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.h.cg(paramContext, ai.getContext().getString(2131758969));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.gPy);
    localIntent.putExtra("Kwebmap_locaion", paramString.hEt);
    if (paramString.CVW >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.CVW);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.dpL);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final String d(agx paramagx)
  {
    AppMethodBeat.i(30317);
    paramagx = f.b(paramagx);
    AppMethodBeat.o(30317);
    return paramagx;
  }
  
  public final String eHQ()
  {
    return this.CUW;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30324);
    if (paramn.getType() == 426)
    {
      paramString = new gt();
      paramString.dhx.dcV = paramn;
      paramString.dhx.type = 31;
      a.GpY.l(paramString);
      if ((!bs.isNullOrNil(paramString.dhy.path)) && (paramInt2 == -435)) {
        ac.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      az.agi().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(agx paramagx)
  {
    AppMethodBeat.i(30319);
    m localm = this.CUJ;
    gt localgt = new gt();
    localgt.dhx.type = 28;
    localgt.dhx.dcg = localm.oOo.field_localId;
    localgt.dhx.dhz = paramagx;
    localgt.dhx.path = "";
    localgt.dhx.dhE = 18;
    a.GpY.l(localgt);
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */