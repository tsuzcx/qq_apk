package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends d
  implements com.tencent.mm.am.h
{
  private static HashMap<com.tencent.mm.plugin.fav.a.g, m> XzS;
  private com.tencent.mm.plugin.fav.a.g AiB;
  public boolean XAa;
  public String XzQ;
  public String XzR;
  private int XzT;
  public String XzU;
  public int XzV;
  public long XzW;
  public String XzX;
  public String XzY;
  public byte[] XzZ;
  private arx hJc;
  private int hTB;
  public boolean hTH;
  public long hTN;
  
  static
  {
    AppMethodBeat.i(30327);
    XzS = new HashMap();
    AppMethodBeat.o(30327);
  }
  
  public g()
  {
    AppMethodBeat.i(30313);
    this.hTN = -1L;
    this.XzR = "";
    this.hTH = true;
    this.hTB = 0;
    this.XzT = 0;
    this.XzV = 0;
    this.XzW = 0L;
    this.hJc = new arx();
    this.XzZ = null;
    this.XAa = false;
    this.XzG.clear();
    this.XzF = null;
    xxE = "";
    this.XzL = false;
    e.dRF();
    bh.aZW().a(426, this);
    AppMethodBeat.o(30313);
  }
  
  private String bnE(String paramString)
  {
    AppMethodBeat.i(30325);
    Object localObject = f.to(this.hTN);
    if (localObject == null)
    {
      paramString = ((o)this.XzI.get(paramString)).hIQ;
      AppMethodBeat.o(30325);
      return paramString;
    }
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.vEn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      arf localarf = (arf)((Iterator)localObject).next();
      if ((!Util.isNullOrNil(localarf.ZzG)) && (localarf.ZzG.equals(paramString)))
      {
        paramString = localarf.hIQ;
        AppMethodBeat.o(30325);
        return paramString;
      }
    }
    paramString = ((o)this.XzI.get(paramString)).hIQ;
    AppMethodBeat.o(30325);
    return paramString;
  }
  
  public final String a(arf paramarf)
  {
    AppMethodBeat.i(30318);
    paramarf = f.a(paramarf);
    AppMethodBeat.o(30318);
    return paramarf;
  }
  
  public final void a(long paramLong, Context paramContext, Boolean paramBoolean, int paramInt1, int paramInt2, arx paramarx, final arv paramarv, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275155);
    this.hTN = paramLong;
    this.hTH = paramBoolean.booleanValue();
    this.hTB = paramInt1;
    this.XzT = paramInt2;
    this.hJc = paramarx;
    this.XzZ = paramArrayOfByte;
    iDW();
    if ((this.XzV == 0) && (this.XzM.ZBt != null)) {
      this.XzV = this.XzM.ZBt.sourceType;
    }
    bh(paramContext, 2);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30311);
        if (paramarv != null)
        {
          com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
          localg.field_localId = g.a(g.this);
          localg.field_favProto = paramarv;
          g.this.XzM = localg.field_favProto;
          g.this.XzF = localg;
          g.a(g.this, localg);
        }
        if (g.aRF().containsKey(g.b(g.this))) {
          g.this.XzE = ((m)g.aRF().get(g.b(g.this)));
        }
        for (;;)
        {
          g.this.mq(g.this.XzE.NBa);
          if (com.tencent.mm.plugin.wenote.model.nativenote.manager.k.iEm() != null) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k.iEq();
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
    AppMethodBeat.o(275155);
  }
  
  public final void a(arf paramarf, String paramString)
  {
    AppMethodBeat.i(30320);
    m localm = this.XzE;
    ht localht = new ht();
    localht.hIR.type = 28;
    localht.hIR.hDn = localm.xvD.field_localId;
    localht.hIR.hIT = paramarf;
    localht.hIR.path = paramString;
    localht.hIR.hIY = 18;
    localht.publish();
    AppMethodBeat.o(30320);
  }
  
  public final void bh(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30315);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", paramInt);
    if (paramInt == 4)
    {
      localIntent.putExtra("fav_note_thumbpath", this.XzX);
      localIntent.putExtra("fav_note_link_sns_xml", this.XzY);
    }
    localIntent.putExtra("edit_status", this.XzL);
    localIntent.putExtra("need_save", this.XAa);
    localIntent.putExtra("show_share", this.hTH);
    localIntent.putExtra("note_fav_localid", this.hTN);
    localIntent.putExtra("note_link_sns_localid", this.XzQ);
    localIntent.putExtra("fav_note_xml", this.XzR);
    localIntent.putExtra("fav_note_scroll_to_position", this.hTB);
    localIntent.putExtra("fav_note_scroll_to_offset", this.XzT);
    localIntent.putExtra("fav_note_link_source_info", this.XzU);
    localIntent.putExtra("note_fav_post_scene", this.XzV);
    localIntent.putExtra("key_detail_fav_scene", this.hJc.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.hJc.AcJ);
    localIntent.putExtra("key_detail_fav_index", this.hJc.index);
    localIntent.putExtra("key_detail_fav_query", this.hJc.query);
    localIntent.putExtra("key_detail_fav_sessionid", this.hJc.sessionId);
    localIntent.putExtra("key_detail_fav_tags", this.hJc.AcL);
    localIntent.putExtra("key_multi_task_common_info", this.XzZ);
    c.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30315);
  }
  
  public final void bnC(String paramString)
  {
    this.XzR = paramString;
  }
  
  public final void cu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30321);
    u localu = (u)this.XzI.get(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.XzR);
    if (localu != null) {
      localIntent.putExtra("key_detail_data_id", bnE(paramString));
    }
    localIntent.putExtra("key_detail_can_delete", false);
    localIntent.putExtra("key_detail_info_id", this.hTN);
    localIntent.putExtra("key_detail_fav_scene", this.hJc.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.hJc.AcJ);
    localIntent.putExtra("key_detail_fav_index", this.hJc.index);
    b.a(paramContext, ".ui.detail.FavoriteFileDetailUI", localIntent, 1);
    AppMethodBeat.o(30321);
  }
  
  public final void cv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30323);
    paramString = (com.tencent.mm.plugin.wenote.model.a.s)this.XzI.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.ui.base.k.cZ(paramContext, MMApplicationContext.getContext().getString(R.l.favorite_record_loc_error));
      AppMethodBeat.o(30323);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kwebmap_slat", paramString.lat);
    localIntent.putExtra("kwebmap_lng", paramString.lng);
    localIntent.putExtra("kPoiName", paramString.poiName);
    localIntent.putExtra("Kwebmap_locaion", paramString.oDI);
    if (paramString.XAR >= 0.0D) {
      localIntent.putExtra("kwebmap_scale", paramString.XAR);
    }
    localIntent.putExtra("kisUsername", "");
    localIntent.putExtra("kwebmap_from_to", true);
    localIntent.putExtra("KFavLocSigleView", true);
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kFavInfoLocalId", this.hTN);
    localIntent.putExtra("kFavCanDel", false);
    localIntent.putExtra("kFavCanRemark", false);
    c.b(paramContext, "location", ".ui.RedirectUI", localIntent, 1);
    AppMethodBeat.o(30323);
  }
  
  public final void cw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30322);
    Intent localIntent = new Intent();
    localIntent.putExtra("fav_open_from_wnnote", true);
    localIntent.putExtra("fav_note_xml", this.XzR);
    if (this.XzI.get(paramString) != null) {
      localIntent.putExtra("key_detail_data_id", ((o)this.XzI.get(paramString)).hIQ);
    }
    localIntent.putExtra("key_detail_info_id", this.hTN);
    localIntent.putExtra("key_detail_fav_scene", this.hJc.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.hJc.AcJ);
    localIntent.putExtra("key_detail_fav_index", this.hJc.index);
    b.a(paramContext, ".ui.FavImgGalleryUI", localIntent, 1);
    AppMethodBeat.o(30322);
  }
  
  public final String d(arf paramarf)
  {
    AppMethodBeat.i(30317);
    paramarf = f.b(paramarf);
    AppMethodBeat.o(30317);
    return paramarf;
  }
  
  public final String iDU()
  {
    return this.XzR;
  }
  
  public final void iDW()
  {
    AppMethodBeat.i(30316);
    this.AiB = f.to(this.hTN);
    if (this.AiB == null)
    {
      AppMethodBeat.o(30316);
      return;
    }
    if (this.XzW <= 0L) {
      this.XzW = this.AiB.field_updateTime;
    }
    this.XzM = this.AiB.field_favProto;
    this.XzF = this.AiB;
    AppMethodBeat.o(30316);
  }
  
  public final void iDX()
  {
    AppMethodBeat.i(275160);
    this.XzE = new m();
    this.XzE.xvD = this.AiB;
    this.XzE.hTN = this.hTN;
    this.XzE.dataType = 1;
    if ((this.AiB == null) || (this.AiB.field_favProto == null))
    {
      AppMethodBeat.o(275160);
      return;
    }
    this.XzE.XAG = this.XzW;
    this.XzE.NBa = this.AiB.field_favProto.vEn;
    XzS.put(this.AiB, this.XzE);
    AppMethodBeat.o(275160);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(30324);
    if (paramp.getType() == 426)
    {
      paramString = new ht();
      paramString.hIR.hEi = paramp;
      paramString.hIR.type = 31;
      paramString.publish();
      if ((!Util.isNullOrNil(paramString.hIS.path)) && (paramInt2 == -435)) {
        Log.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
      }
      bh.aZW().b(426, this);
      AppMethodBeat.o(30324);
      return;
    }
    AppMethodBeat.o(30324);
  }
  
  public final void p(arf paramarf)
  {
    AppMethodBeat.i(30319);
    m localm = this.XzE;
    ht localht = new ht();
    localht.hIR.type = 28;
    localht.hIR.hDn = localm.xvD.field_localId;
    localht.hIR.hIT = paramarf;
    localht.hIR.path = "";
    localht.hIR.hIY = 18;
    localht.publish();
    AppMethodBeat.o(30319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g
 * JD-Core Version:    0.7.0.1
 */