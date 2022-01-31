package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.ai.f
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, com.tencent.mm.plugin.wenote.model.a.m> vwl;
  public long cBE;
  public boolean cBz;
  private acs cvi;
  private com.tencent.mm.plugin.fav.a.g mxX;
  public String vwj;
  public String vwk;
  private int vwm;
  private int vwn;
  public String vwo;
  public int vwp;
  public long vwq;
  public String vwr;
  public String vws;
  public boolean vwt;
  
  static
  {
    AppMethodBeat.i(26634);
    vwl = new HashMap();
    AppMethodBeat.o(26634);
  }
  
  public g()
  {
    AppMethodBeat.i(26620);
    this.cBE = -1L;
    this.vwk = "";
    this.cBz = true;
    this.vwm = 0;
    this.vwn = 0;
    this.vwp = 0;
    this.vwq = 0L;
    this.cvi = new acs();
    this.vwt = false;
    this.vvU.clear();
    this.vvT = null;
    vvZ = "";
    this.vwb = false;
    com.tencent.mm.plugin.fav.ui.c.bxu();
    aw.Rc().a(426, this);
    AppMethodBeat.o(26620);
  }
  
  private String ajG(String paramString)
  {
    AppMethodBeat.i(26632);
    Object localObject = f.kY(this.cBE);
    if (localObject == null)
    {
      paramString = ((o)this.vvW.get(paramString)).mBq;
      AppMethodBeat.o(26632);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wVc.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject).next();
      if ((!bo.isNullOrNil(localaca.wTE)) && (localaca.wTE.equals(paramString)))
      {
        paramString = localaca.mBq;
        AppMethodBeat.o(26632);
        return paramString;
      }
    }
    paramString = ((o)this.vvW.get(paramString)).mBq;
    AppMethodBeat.o(26632);
    return paramString;
  }
  
  private void dhK()
  {
    AppMethodBeat.i(26623);
    this.mxX = f.kY(this.cBE);
    if (this.mxX == null)
    {
      AppMethodBeat.o(26623);
      return;
    }
    if (this.vwq <= 0L) {
      this.vwq = this.mxX.field_updateTime;
    }
    this.vwc = this.mxX.field_favProto;
    this.vvT = this.mxX;
    AppMethodBeat.o(26623);
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, acs paramacs, acq paramacq)
  {
    AppMethodBeat.i(26621);
    this.cBE = paramLong;
    this.cBz = paramBoolean.booleanValue();
    this.vwm = paramInt1;
    this.vwn = paramInt2;
    this.cvi = paramacs;
    dhK();
    if ((this.vwp == 0) && (this.vwc.wVa != null)) {
      this.vwp = this.vwc.wVa.cpG;
    }
    ae(paramContext, 2);
    com.tencent.mm.sdk.g.d.ysn.aj(new g.2(this, paramacq));
    AppMethodBeat.o(26621);
  }
  
  public final void a(aca paramaca, String paramString)
  {
    AppMethodBeat.i(26627);
    com.tencent.mm.plugin.wenote.model.a.m localm = this.vvS;
    gi localgi = new gi();
    localgi.cuX.type = 28;
    localgi.cuX.cpM = localm.mCk.field_localId;
    localgi.cuX.cuZ = paramaca;
    localgi.cuX.path = paramString;
    localgi.cuX.cve = 18;
    a.ymk.l(localgi);
    AppMethodBeat.o(26627);
  }
  
  public final void ae(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(26622);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.vwr);
      localIntent.putExtra("fav_note_link_sns_xml", this.vws);
    }
    localIntent.putExtra("edit_status", this.vwb);
    localIntent.putExtra("need_save", this.vwt);
    localIntent.putExtra("show_share", this.cBz);
    localIntent.putExtra("note_fav_localid", this.cBE);
    localIntent.putExtra("note_link_sns_localid", this.vwj);
    localIntent.putExtra("fav_note_xml", this.vwk);
    localIntent.putExtra("fav_note_scroll_to_position", this.vwm);
    localIntent.putExtra("fav_note_scroll_to_offset", this.vwn);
    localIntent.putExtra("fav_note_link_source_info", this.vwo);
    localIntent.putExtra("note_fav_post_scene", this.vwp);
    localIntent.putExtra("key_detail_fav_scene", this.cvi.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.cvi.kbN);
    localIntent.putExtra("key_detail_fav_index", this.cvi.index);
    localIntent.putExtra("key_detail_fav_query", this.cvi.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.cvi.cpW);
    localIntent.putExtra("key_detail_fav_tags", this.cvi.mtm);
    com.tencent.mm.bq.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(26622);
  }
  
  public final void ajD(String paramString)
  {
    this.vwk = paramString;
  }
  
  public final String b(aca paramaca)
  {
    AppMethodBeat.i(26624);
    paramaca = f.o(paramaca);
    AppMethodBeat.o(26624);
    return paramaca;
  }
  
  public final void bk(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26628);
    u localu = (u)this.vvW.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.vwk);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", ajG(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.cBE);
    localIntent.putExtra("key_detail_fav_scene", this.cvi.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.cvi.kbN);
    localIntent.putExtra("key_detail_fav_index", this.cvi.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(26628);
  }
  
  public final void bl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26630);
    paramString = (s)this.vvW.get(paramString);
    if (paramString == null)
    {
      h.bO(paramContext, ah.getContext().getString(2131299795));
      AppMethodBeat.o(26630);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.eSM);
    localIntent.putExtra("Kwebmap_locaion", paramString.fBq);
    if (paramString.scale >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.scale);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.cBE);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    com.tencent.mm.bq.d.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(26630);
  }
  
  public final void bm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26629);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.vwk);
    if (this.vvW.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.vvW.get(paramString)).mBq);
    }
    localIntent.putExtra("key_detail_info_id", this.cBE);
    localIntent.putExtra("key_detail_fav_scene", this.cvi.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.cvi.kbN);
    localIntent.putExtra("key_detail_fav_index", this.cvi.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(26629);
  }
  
  public final String c(aca paramaca)
  {
    AppMethodBeat.i(26625);
    paramaca = f.c(paramaca);
    AppMethodBeat.o(26625);
    return paramaca;
  }
  
  public final String dhI()
  {
    return this.vwk;
  }
  
  public final void n(aca paramaca)
  {
    AppMethodBeat.i(26626);
    com.tencent.mm.plugin.wenote.model.a.m localm = this.vvS;
    gi localgi = new gi();
    localgi.cuX.type = 28;
    localgi.cuX.cpM = localm.mCk.field_localId;
    localgi.cuX.cuZ = paramaca;
    localgi.cuX.path = "";
    localgi.cuX.cve = 18;
    a.ymk.l(localgi);
    AppMethodBeat.o(26626);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(26631);
    if (paramm.getType() == 426)
    {
      paramString = new gi();
      paramString.cuX.cqE = paramm;
      paramString.cuX.type = 31;
      a.ymk.l(paramString);
      if ((!bo.isNullOrNil(paramString.cuY.path)) && (paramInt2 == -435)) {
        ab.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      aw.Rc().b(426, this);
      AppMethodBeat.o(26631);
      return;
    }
    AppMethodBeat.o(26631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */