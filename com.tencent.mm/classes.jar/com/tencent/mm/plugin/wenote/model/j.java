package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> rGd = new HashMap();
  private yl bNQ = new yl();
  private boolean bTT;
  private String bUH;
  private com.tencent.mm.protocal.b.a.c ntV = null;
  private int rFD = 0;
  private int rFE = 0;
  private String rFF;
  private Long rGb;
  private boolean rGc = false;
  
  public j()
  {
    this.rFl.clear();
    com.tencent.mm.plugin.fav.ui.c.aRf();
  }
  
  public final void a(xv paramxv, String paramString)
  {
    nd localnd = new nd();
    localnd.bWJ.type = 8;
    localnd.bWJ.bNt = paramxv;
    localnd.bWJ.bIt = this.rGb.longValue();
    localnd.bWJ.thumbPath = paramString;
    a.udP.m(localnd);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, yl paramyl)
  {
    this.bUH = paramString;
    this.rGb = paramLong;
    this.bTT = paramBoolean;
    this.rFD = paramInt1;
    this.rFE = paramInt2;
    this.bNQ = paramyl;
    paramLong = new nd();
    paramLong.bWJ.type = 0;
    paramLong.bWJ.bWL = paramString;
    a.udP.m(paramLong);
    this.ntV = paramLong.bWK.bWT;
    if ((this.ntV != null) && (this.ntV.dTx != null) && (this.ntV.dTx.size() > 1))
    {
      paramString = new nd();
      paramString.bWJ.type = 9;
      paramString.bWJ.bNt = ((xv)this.ntV.dTx.get(0));
      paramString.bWJ.bIt = this.rGb.longValue();
      a.udP.m(paramString);
      this.rGc = paramString.bWK.bWU;
    }
    if ((this.ntV != null) && (this.ntV.sro != null)) {}
    for (this.rFF = (this.ntV.sro.sWT + ";" + this.ntV.sro.sWU + ";" + this.ntV.srp);; this.rFF = null)
    {
      paramString = new Intent();
      paramString.putExtra("note_open_from_scene", 1);
      paramString.putExtra("edit_status", this.rFs);
      paramString.putExtra("note_msgid", this.rGb);
      paramString.putExtra("record_show_share", this.bTT);
      paramString.putExtra("fav_note_xml", this.bUH);
      paramString.putExtra("fav_note_out_of_date", this.rGc);
      paramString.putExtra("fav_note_scroll_to_position", this.rFD);
      paramString.putExtra("fav_note_scroll_to_offset", this.rFE);
      paramString.putExtra("fav_note_scroll_to_offset", this.rFE);
      if (!bk.bl(this.rFF)) {
        paramString.putExtra("fav_note_link_source_info", this.rFF);
      }
      paramString.putExtra("key_detail_fav_scene", this.bNQ.scene);
      paramString.putExtra("key_detail_fav_sub_scene", this.bNQ.jYS);
      paramString.putExtra("key_detail_fav_index", this.bNQ.index);
      com.tencent.mm.br.d.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", paramString);
      au.DS().O(new j.1(this));
      return;
    }
  }
  
  public final void aZ(Context paramContext, String paramString)
  {
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.rGb);
    paramContext.putExtra("record_xml", this.bUH);
    paramContext.putExtra("record_data_id", ((o)this.rFn.get(paramString)).kgC);
    com.tencent.mm.br.d.b(ae.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
  }
  
  public final String b(xv paramxv)
  {
    nd localnd = new nd();
    localnd.bWJ.type = 1;
    localnd.bWJ.bNt = paramxv;
    localnd.bWJ.bIt = this.rGb.longValue();
    a.udP.m(localnd);
    return localnd.bWK.dataPath;
  }
  
  public final void ba(Context paramContext, String paramString)
  {
    paramContext = null;
    Object localObject = ((o)this.rFn.get(paramString)).rGH;
    if (((xv)localObject).sVA != null) {
      yc localyc = ((xv)localObject).sVA.sWf;
    }
    for (localObject = ((xv)localObject).sVA.sWd;; localObject = null)
    {
      if (localObject != null) {
        if (bk.bl(((xx)localObject).sWB)) {
          break label96;
        }
      }
      label96:
      for (paramContext = r.gV(((xx)localObject).sWB);; paramContext = r.gV(((xx)localObject).bRO))
      {
        paramString = (s)this.rFn.get(paramString);
        if (paramString != null) {
          break;
        }
        h.bC(ae.getContext(), ae.getContext().getString(R.l.favorite_record_loc_error));
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.lFn);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.ekZ);
      if (paramString.rGV >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.rGV);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.br.d.b(ae.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      return;
    }
  }
  
  public final void bb(Context paramContext, String paramString)
  {
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.rGb);
    paramContext.putExtra("record_data_id", ((o)this.rFn.get(paramString)).kgC);
    paramContext.putExtra("record_xml", this.bUH);
    com.tencent.mm.br.d.b(ae.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
  }
  
  public final String c(xv paramxv)
  {
    nd localnd = new nd();
    localnd.bWJ.type = 1;
    localnd.bWJ.bNt = paramxv;
    localnd.bWJ.bIt = this.rGb.longValue();
    a.udP.m(localnd);
    return localnd.bWK.thumbPath;
  }
  
  public final void n(xv paramxv)
  {
    nd localnd = new nd();
    localnd.bWJ.type = 8;
    localnd.bWJ.bNt = paramxv;
    localnd.bWJ.bIt = this.rGb.longValue();
    localnd.bWJ.thumbPath = "";
    a.udP.m(localnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */