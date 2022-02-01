package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.an.i
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> QGu;
  public String QGA;
  public byte[] QGB;
  public boolean QGC;
  public String QGs;
  public String QGt;
  private int QGv;
  public String QGw;
  public int QGx;
  public long QGy;
  public String QGz;
  private aoe fEm;
  private int fNJ;
  public boolean fNQ;
  public long fNV;
  private com.tencent.mm.plugin.fav.a.g wMe;
  
  static
  {
    AppMethodBeat.i(30327);
    QGu = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.fNV = -1L;
    this.QGt = "";
    this.fNQ = true;
    this.fNJ = 0;
    this.QGv = 0;
    this.QGx = 0;
    this.QGy = 0L;
    this.fEm = new aoe();
    this.QGB = null;
    this.QGC = false;
    this.QGi.clear();
    this.QGh = null;
    urh = "";
    this.QGn = false;
    e.dkP();
    bh.aGY().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String bnQ(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.Po(this.fNV);
    if (localObject == null)
    {
      paramString = ((o)this.QGk.get(paramString)).fEa;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.syG.iterator();
    while (((Iterator)localObject).hasNext())
    {
      anm localanm = (anm)((Iterator)localObject).next();
      if ((!Util.isNullOrNil(localanm.SyO)) && (localanm.SyO.equals(paramString)))
      {
        paramString = localanm.fEa;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.QGk.get(paramString)).fEa;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  public final String a(anm paramanm)
  {
    AppMethodBeat.i(30318);
    paramanm = f.a(paramanm);
    AppMethodBeat.o(30318);
    return paramanm;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, aoe paramaoe, final aoc paramaoc, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(263614);
    this.fNV = paramLong;
    this.fNQ = paramBoolean.booleanValue();
    this.fNJ = paramInt1;
    this.QGv = paramInt2;
    this.fEm = paramaoe;
    this.QGB = paramArrayOfByte;
    hdp();
    if ((this.QGx == 0) && (this.QGo.SAB != null)) {
      this.QGx = this.QGo.SAB.sourceType;
    }
    aO(paramContext, 2);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramaoc != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramaoc;
          g.this.QGo = localg.field_favProto;
          g.this.QGh = localg;
          g.a(g.this, localg);
        }
        if (g.axf().containsKey(g.b(g.this))) {
          g.this.QGg = ((m)g.axf().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.jh(g.this.QGg.HDy);
          if (k.hdF() != null) {
            k.hdJ();
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
    AppMethodBeat.o(263614);
  }
  
  public final void a(anm paramanm, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.QGg;
    hi localhi = new hi();
    localhi.fEb.type = 28;
    localhi.fEb.fyE = localm.upg.field_localId;
    localhi.fEb.fEd = paramanm;
    localhi.fEb.path = paramString;
    localhi.fEb.fEi = 18;
    EventCenter.instance.publish(localhi);
    AppMethodBeat.o(30320);
  }
  
  public final void aO(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.QGz);
      localIntent.putExtra("fav_note_link_sns_xml", this.QGA);
    }
    localIntent.putExtra("edit_status", this.QGn);
    localIntent.putExtra("need_save", this.QGC);
    localIntent.putExtra("show_share", this.fNQ);
    localIntent.putExtra("note_fav_localid", this.fNV);
    localIntent.putExtra("note_link_sns_localid", this.QGs);
    localIntent.putExtra("fav_note_xml", this.QGt);
    localIntent.putExtra("fav_note_scroll_to_position", this.fNJ);
    localIntent.putExtra("fav_note_scroll_to_offset", this.QGv);
    localIntent.putExtra("fav_note_link_source_info", this.QGw);
    localIntent.putExtra("note_fav_post_scene", this.QGx);
    localIntent.putExtra("key_detail_fav_scene", this.fEm.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.fEm.wGA);
    localIntent.putExtra("key_detail_fav_index", this.fEm.index);
    localIntent.putExtra("key_detail_fav_query", this.fEm.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.fEm.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.fEm.wGC);
    localIntent.putExtra("key_multi_task_common_info", this.QGB);
    c.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void bnO(String paramString)
  {
    this.QGt = paramString;
  }
  
  public final void cj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.QGk.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.QGt);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", bnQ(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.fNV);
    localIntent.putExtra("key_detail_fav_scene", this.fEm.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.fEm.wGA);
    localIntent.putExtra("key_detail_fav_index", this.fEm.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void ck(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (s)this.QGk.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.h.cO(paramContext, MMApplicationContext.getContext().getString(R.l.favorite_record_loc_error));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.poiName);
    localIntent.putExtra("Kwebmap_locaion", paramString.lLg);
    if (paramString.QHt >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.QHt);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.fNV);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    c.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final void cl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.QGt);
    if (this.QGk.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.QGk.get(paramString)).fEa);
    }
    localIntent.putExtra("key_detail_info_id", this.fNV);
    localIntent.putExtra("key_detail_fav_scene", this.fEm.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.fEm.wGA);
    localIntent.putExtra("key_detail_fav_index", this.fEm.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final String d(anm paramanm)
  {
    AppMethodBeat.i(30317);
    paramanm = f.b(paramanm);
    AppMethodBeat.o(30317);
    return paramanm;
  }
  
  public final String hdn()
  {
    return this.QGt;
  }
  
  public final void hdp()
  {
    AppMethodBeat.i(30316);
    this.wMe = f.Po(this.fNV);
    if (this.wMe == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.QGy <= 0L) {
      this.QGy = this.wMe.field_updateTime;
    }
    this.QGo = this.wMe.field_favProto;
    this.QGh = this.wMe;
    AppMethodBeat.o(30316);
  }
  
  public final void hdq()
  {
    AppMethodBeat.i(263618);
    this.QGg = new m();
    this.QGg.upg = this.wMe;
    this.QGg.fNV = this.fNV;
    this.QGg.dataType = 1;
    if ((this.wMe == null) || (this.wMe.field_favProto == null))
    {
      AppMethodBeat.o(263618);
      return;
    }
    this.QGg.QHi = this.QGy;
    this.QGg.HDy = this.wMe.field_favProto.syG;
    QGu.put(this.wMe, this.QGg);
    AppMethodBeat.o(263618);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30324);
    if (paramq.getType() == 426)
    {
      paramString = new hi();
      paramString.fEb.fzz = paramq;
      paramString.fEb.type = 31;
      EventCenter.instance.publish(paramString);
      if ((!Util.isNullOrNil(paramString.fEc.path)) && (paramInt2 == -435)) {
        Log.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      bh.aGY().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(anm paramanm)
  {
    AppMethodBeat.i(30319);
    m localm = this.QGg;
    hi localhi = new hi();
    localhi.fEb.type = 28;
    localhi.fEb.fyE = localm.upg.field_localId;
    localhi.fEb.fEd = paramanm;
    localhi.fEb.path = "";
    localhi.fEb.fEi = 18;
    EventCenter.instance.publish(localhi);
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */