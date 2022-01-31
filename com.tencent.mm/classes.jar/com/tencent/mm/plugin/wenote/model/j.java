package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> vwM;
  private boolean cBz;
  private String cCm;
  private acs cvi;
  private com.tencent.mm.protocal.b.a.c pZC;
  private Long vwK;
  private boolean vwL;
  private int vwm;
  private int vwn;
  private String vwo;
  
  static
  {
    AppMethodBeat.i(26663);
    vwM = new HashMap();
    AppMethodBeat.o(26663);
  }
  
  public j()
  {
    AppMethodBeat.i(26651);
    this.pZC = null;
    this.vwm = 0;
    this.vwn = 0;
    this.vwL = false;
    this.cvi = new acs();
    this.vvU.clear();
    com.tencent.mm.plugin.fav.ui.c.bxu();
    AppMethodBeat.o(26651);
  }
  
  private static com.tencent.mm.protocal.b.a.c XS(String paramString)
  {
    AppMethodBeat.i(26654);
    oa localoa = new oa();
    localoa.cEz.type = 0;
    localoa.cEz.cEB = paramString;
    a.ymk.l(localoa);
    paramString = localoa.cEA.cEK;
    AppMethodBeat.o(26654);
    return paramString;
  }
  
  private void fE(Context paramContext)
  {
    AppMethodBeat.i(26653);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.vwb);
    localIntent.putExtra("note_msgid", this.vwK);
    localIntent.putExtra("record_show_share", this.cBz);
    localIntent.putExtra("fav_note_xml", this.cCm);
    localIntent.putExtra("fav_note_out_of_date", this.vwL);
    localIntent.putExtra("fav_note_scroll_to_position", this.vwm);
    localIntent.putExtra("fav_note_scroll_to_offset", this.vwn);
    localIntent.putExtra("fav_note_scroll_to_offset", this.vwn);
    if (!bo.isNullOrNil(this.vwo)) {
      localIntent.putExtra("fav_note_link_source_info", this.vwo);
    }
    localIntent.putExtra("key_detail_fav_scene", this.cvi.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.cvi.kbN);
    localIntent.putExtra("key_detail_fav_index", this.cvi.index);
    com.tencent.mm.bq.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(26653);
  }
  
  public final void a(aca paramaca, String paramString)
  {
    AppMethodBeat.i(26658);
    oa localoa = new oa();
    localoa.cEz.type = 8;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = this.vwK.longValue();
    localoa.cEz.thumbPath = paramString;
    a.ymk.l(localoa);
    AppMethodBeat.o(26658);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, acs paramacs)
  {
    AppMethodBeat.i(26652);
    this.cCm = paramString;
    this.vwK = paramLong;
    this.cBz = paramBoolean;
    this.vwm = paramInt1;
    this.vwn = paramInt2;
    this.cvi = paramacs;
    this.pZC = XS(paramString);
    if ((this.pZC != null) && (this.pZC.fjy != null) && (this.pZC.fjy.size() > 1))
    {
      paramString = new oa();
      paramString.cEz.type = 9;
      paramString.cEz.cuL = ((aca)this.pZC.fjy.get(0));
      paramString.cEz.cpO = this.vwK.longValue();
      a.ymk.l(paramString);
      this.vwL = paramString.cEA.cEL;
    }
    if ((this.pZC != null) && (this.pZC.wjV != null)) {}
    for (this.vwo = (this.pZC.wjV.wUT + ";" + this.pZC.wjV.wUU + ";" + this.pZC.lsP);; this.vwo = null)
    {
      fE(paramContext);
      aw.RO().ac(new j.1(this));
      AppMethodBeat.o(26652);
      return;
    }
  }
  
  public final String b(aca paramaca)
  {
    AppMethodBeat.i(26655);
    oa localoa = new oa();
    localoa.cEz.type = 1;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = this.vwK.longValue();
    a.ymk.l(localoa);
    paramaca = localoa.cEA.dataPath;
    AppMethodBeat.o(26655);
    return paramaca;
  }
  
  public final void bk(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26659);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.vwK);
    paramContext.putExtra("record_xml", this.cCm);
    paramContext.putExtra("record_data_id", ((o)this.vvW.get(paramString)).mBq);
    com.tencent.mm.bq.d.b(ah.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(26659);
  }
  
  public final void bl(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(26661);
    Object localObject = ((o)this.vvW.get(paramString)).vxq;
    if (((aca)localObject).wTw != null) {}
    for (localObject = ((aca)localObject).wTw.wUb;; localObject = null)
    {
      if (localObject != null) {
        if (bo.isNullOrNil(((acc)localObject).wUA)) {
          break label99;
        }
      }
      label99:
      for (paramContext = com.tencent.mm.model.s.nE(((acc)localObject).wUA);; paramContext = com.tencent.mm.model.s.nE(((acc)localObject).czp))
      {
        paramString = (com.tencent.mm.plugin.wenote.model.a.s)this.vvW.get(paramString);
        if (paramString != null) {
          break;
        }
        h.bO(ah.getContext(), ah.getContext().getString(2131299795));
        AppMethodBeat.o(26661);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.eSM);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.fBq);
      if (paramString.scale >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.scale);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.bq.d.b(ah.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(26661);
      return;
    }
  }
  
  public final void bm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26660);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.vwK);
    paramContext.putExtra("record_data_id", ((o)this.vvW.get(paramString)).mBq);
    paramContext.putExtra("record_xml", this.cCm);
    com.tencent.mm.bq.d.b(ah.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(26660);
  }
  
  public final String c(aca paramaca)
  {
    AppMethodBeat.i(26656);
    oa localoa = new oa();
    localoa.cEz.type = 1;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = this.vwK.longValue();
    a.ymk.l(localoa);
    paramaca = localoa.cEA.thumbPath;
    AppMethodBeat.o(26656);
    return paramaca;
  }
  
  public final void n(aca paramaca)
  {
    AppMethodBeat.i(26657);
    oa localoa = new oa();
    localoa.cEz.type = 8;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = this.vwK.longValue();
    localoa.cEz.thumbPath = "";
    a.ymk.l(localoa);
    AppMethodBeat.o(26657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */