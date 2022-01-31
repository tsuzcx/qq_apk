package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.ah.f
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, com.tencent.mm.plugin.wenote.model.a.m> rFC = new HashMap();
  private yl bNQ = new yl();
  public boolean bTT = true;
  public long bTZ = -1L;
  private com.tencent.mm.plugin.fav.a.g kdn;
  public String rFA;
  public String rFB = "";
  private int rFD = 0;
  private int rFE = 0;
  public String rFF;
  public int rFG = 0;
  public long rFH = 0L;
  public String rFI;
  public String rFJ;
  public boolean rFK = false;
  
  public g()
  {
    this.rFl.clear();
    this.rFk = null;
    rFq = "";
    this.rFs = false;
    c.aRf();
    au.Dk().a(426, this);
  }
  
  private String Us(String paramString)
  {
    Object localObject = f.fu(this.bTZ);
    if (localObject == null) {
      return ((o)this.rFn.get(paramString)).kgC;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sXc.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xv localxv = (xv)((Iterator)localObject).next();
      if ((!bk.bl(localxv.sVI)) && (localxv.sVI.equals(paramString))) {
        return localxv.kgC;
      }
    }
    return ((o)this.rFn.get(paramString)).kgC;
  }
  
  public final void P(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.rFI);
      localIntent.putExtra("fav_note_link_sns_xml", this.rFJ);
    }
    localIntent.putExtra("edit_status", this.rFs);
    localIntent.putExtra("need_save", this.rFK);
    localIntent.putExtra("show_share", this.bTT);
    localIntent.putExtra("note_fav_localid", this.bTZ);
    localIntent.putExtra("note_link_sns_localid", this.rFA);
    localIntent.putExtra("fav_note_xml", this.rFB);
    localIntent.putExtra("fav_note_scroll_to_position", this.rFD);
    localIntent.putExtra("fav_note_scroll_to_offset", this.rFE);
    localIntent.putExtra("fav_note_link_source_info", this.rFF);
    localIntent.putExtra("note_fav_post_scene", this.rFG);
    localIntent.putExtra("key_detail_fav_scene", this.bNQ.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.bNQ.jYS);
    localIntent.putExtra("key_detail_fav_index", this.bNQ.index);
    localIntent.putExtra("key_detail_fav_query", this.bNQ.bVk);
    localIntent.putExtra("key_detail_fav_sessionid", this.bNQ.bIB);
    localIntent.putExtra("key_detail_fav_tags", this.bNQ.jYU);
    com.tencent.mm.br.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
  }
  
  public final void Up(String paramString)
  {
    this.rFB = paramString;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, yl paramyl, yj paramyj)
  {
    this.bTZ = paramLong;
    this.bTT = paramBoolean.booleanValue();
    this.rFD = paramInt1;
    this.rFE = paramInt2;
    this.bNQ = paramyl;
    this.kdn = f.fu(this.bTZ);
    if (this.kdn != null)
    {
      if (this.rFH <= 0L) {
        this.rFH = this.kdn.field_updateTime;
      }
      this.rFt = this.kdn.field_favProto;
      this.rFk = this.kdn;
    }
    if ((this.rFG == 0) && (this.rFt.sXa != null)) {
      this.rFG = this.rFt.sXa.bIl;
    }
    P(paramContext, 2);
    au.DS().O(new g.2(this, paramyj));
  }
  
  public final void a(xv paramxv, String paramString)
  {
    com.tencent.mm.plugin.wenote.model.a.m localm = this.rFj;
    gf localgf = new gf();
    localgf.bNF.type = 28;
    localgf.bNF.bIr = localm.khA.field_localId;
    localgf.bNF.bNH = paramxv;
    localgf.bNF.path = paramString;
    localgf.bNF.bNM = 18;
    a.udP.m(localgf);
  }
  
  public final void aZ(Context paramContext, String paramString)
  {
    u localu = (u)this.rFn.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.rFB);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", Us(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.bTZ);
    localIntent.putExtra("key_detail_fav_scene", this.bNQ.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.bNQ.jYS);
    localIntent.putExtra("key_detail_fav_index", this.bNQ.index);
    b.b(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
  }
  
  public final String b(xv paramxv)
  {
    return f.o(paramxv);
  }
  
  public final void ba(Context paramContext, String paramString)
  {
    paramString = (s)this.rFn.get(paramString);
    if (paramString == null)
    {
      h.bC(paramContext, ae.getContext().getString(R.l.favorite_record_loc_error));
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.lFn);
    localIntent.putExtra("Kwebmap_locaion", paramString.ekZ);
    if (paramString.rGV >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.rGV);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.bTZ);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
  }
  
  public final void bb(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.rFB);
    if (this.rFn.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.rFn.get(paramString)).kgC);
    }
    localIntent.putExtra("key_detail_info_id", this.bTZ);
    localIntent.putExtra("key_detail_fav_scene", this.bNQ.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.bNQ.jYS);
    localIntent.putExtra("key_detail_fav_index", this.bNQ.index);
    b.b(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
  }
  
  public final String c(xv paramxv)
  {
    return f.c(paramxv);
  }
  
  public final String chv()
  {
    return this.rFB;
  }
  
  public final void n(xv paramxv)
  {
    com.tencent.mm.plugin.wenote.model.a.m localm = this.rFj;
    gf localgf = new gf();
    localgf.bNF.type = 28;
    localgf.bNF.bIr = localm.khA.field_localId;
    localgf.bNF.bNH = paramxv;
    localgf.bNF.path = "";
    localgf.bNF.bNM = 18;
    a.udP.m(localgf);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (paramm.getType() == 426)
    {
      paramString = new gf();
      paramString.bNF.bJk = paramm;
      paramString.bNF.type = 31;
      a.udP.m(paramString);
      if ((!bk.bl(paramString.bNG.path)) && (paramInt2 == -435)) {
        y.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      au.Dk().b(426, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */