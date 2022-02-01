package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
  extends d
{
  private static HashMap<String, m> XAt;
  private com.tencent.mm.protocal.b.a.c NBI;
  private Long XAr;
  private boolean XAs;
  private int XzT;
  private String XzU;
  private byte[] XzZ;
  private arx hJc;
  private int hTB;
  private boolean hTH;
  private String hUx;
  
  static
  {
    AppMethodBeat.i(30356);
    XAt = new HashMap();
    AppMethodBeat.o(30356);
  }
  
  public j()
  {
    AppMethodBeat.i(30344);
    this.NBI = null;
    this.hTB = 0;
    this.XzT = 0;
    this.XAs = false;
    this.hJc = new arx();
    this.XzZ = null;
    this.XzG.clear();
    e.dRF();
    AppMethodBeat.o(30344);
  }
  
  private static com.tencent.mm.protocal.b.a.c aSH(String paramString)
  {
    AppMethodBeat.i(30347);
    tr localtr = new tr();
    localtr.hXt.type = 0;
    localtr.hXt.hXv = paramString;
    localtr.publish();
    paramString = localtr.hXu.hXD;
    AppMethodBeat.o(30347);
    return paramString;
  }
  
  private void lh(Context paramContext)
  {
    AppMethodBeat.i(30346);
    Intent localIntent = new Intent();
    localIntent.putExtra("note_open_from_scene", 1);
    localIntent.putExtra("edit_status", this.XzL);
    localIntent.putExtra("note_msgid", this.XAr);
    localIntent.putExtra("Retr_Security_Msg_Id", this.XAr);
    localIntent.putExtra("record_show_share", this.hTH);
    localIntent.putExtra("fav_note_xml", this.hUx);
    localIntent.putExtra("fav_note_out_of_date", this.XAs);
    localIntent.putExtra("fav_note_scroll_to_position", this.hTB);
    localIntent.putExtra("fav_note_scroll_to_offset", this.XzT);
    localIntent.putExtra("fav_note_scroll_to_offset", this.XzT);
    if (!Util.isNullOrNil(this.XzU)) {
      localIntent.putExtra("fav_note_link_source_info", this.XzU);
    }
    localIntent.putExtra("key_detail_fav_scene", this.hJc.scene);
    localIntent.putExtra("key_detail_fav_sub_scene", this.hJc.AcJ);
    localIntent.putExtra("key_detail_fav_index", this.hJc.index);
    localIntent.putExtra("key_multi_task_common_info", this.XzZ);
    com.tencent.mm.br.c.b(paramContext, "wenote", ".ui.nativenote.NoteEditorUI", localIntent);
    AppMethodBeat.o(30346);
  }
  
  public final String a(arf paramarf)
  {
    AppMethodBeat.i(30349);
    tr localtr = new tr();
    localtr.hXt.type = 1;
    localtr.hXt.hIy = paramarf;
    localtr.hXt.msgId = this.XAr.longValue();
    localtr.publish();
    paramarf = localtr.hXu.thumbPath;
    AppMethodBeat.o(30349);
    return paramarf;
  }
  
  public final void a(arf paramarf, String paramString)
  {
    AppMethodBeat.i(30351);
    tr localtr = new tr();
    localtr.hXt.type = 8;
    localtr.hXt.hIy = paramarf;
    localtr.hXt.msgId = this.XAr.longValue();
    localtr.hXt.thumbPath = paramString;
    localtr.publish();
    AppMethodBeat.o(30351);
  }
  
  public final void a(String paramString, Long paramLong, boolean paramBoolean, Context paramContext, int paramInt1, int paramInt2, arx paramarx, Bundle paramBundle)
  {
    AppMethodBeat.i(275158);
    Log.i("MicroMsg.WNNoteMsgProcess", "setupWNNoteData noteXmlStr:%s msgid:%s", new Object[] { paramString, paramLong });
    this.hUx = paramString;
    this.XAr = paramLong;
    this.hTH = paramBoolean;
    this.hTB = paramInt1;
    this.XzT = paramInt2;
    this.hJc = paramarx;
    if (paramBundle != null) {
      this.XzZ = paramBundle.getByteArray("key_multi_task_common_info");
    }
    this.NBI = aSH(paramString);
    if ((this.NBI != null) && (this.NBI.nUC != null) && (this.NBI.nUC.size() > 1))
    {
      paramString = new tr();
      paramString.hXt.type = 9;
      paramString.hXt.hIy = ((arf)this.NBI.nUC.get(0));
      paramString.hXt.msgId = this.XAr.longValue();
      paramString.publish();
      this.XAs = paramString.hXu.hXE;
    }
    if ((this.NBI != null) && (this.NBI.YzK != null)) {}
    for (this.XzU = (this.NBI.YzK.ZBm + ";" + this.NBI.YzK.ZBn + ";" + this.NBI.ygh);; this.XzU = null)
    {
      lh(paramContext);
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30342);
          j.a(j.this);
          j.this.mq(j.this.XzE.NBa);
          if (com.tencent.mm.plugin.wenote.model.nativenote.manager.k.iEm() != null) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k.iEq();
          }
          AppMethodBeat.o(30342);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(30343);
          String str = super.toString() + "|dealWNoteInfo";
          AppMethodBeat.o(30343);
          return str;
        }
      });
      AppMethodBeat.o(275158);
      return;
    }
  }
  
  public final void cu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30352);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.XAr);
    paramContext.putExtra("record_xml", this.hUx);
    paramContext.putExtra("record_data_id", ((o)this.XzI.get(paramString)).hIQ);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgFileUI", paramContext);
    AppMethodBeat.o(30352);
  }
  
  public final void cv(Context paramContext, String paramString)
  {
    paramContext = null;
    AppMethodBeat.i(30354);
    Object localObject = ((o)this.XzI.get(paramString)).xyn;
    if (((arf)localObject).Zzy != null) {}
    for (localObject = ((arf)localObject).Zzy.ZAf;; localObject = null)
    {
      if (localObject != null) {
        if (Util.isNullOrNil(((arh)localObject).ZAT)) {
          break label99;
        }
      }
      label99:
      for (paramContext = aa.getDisplayName(((arh)localObject).ZAT);; paramContext = aa.getDisplayName(((arh)localObject).hQQ))
      {
        paramString = (s)this.XzI.get(paramString);
        if (paramString != null) {
          break;
        }
        com.tencent.mm.ui.base.k.cZ(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_record_loc_error));
        AppMethodBeat.o(30354);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("map_view_type", 2);
      ((Intent)localObject).putExtra("kwebmap_slat", paramString.lat);
      ((Intent)localObject).putExtra("kwebmap_lng", paramString.lng);
      ((Intent)localObject).putExtra("kPoiName", paramString.poiName);
      ((Intent)localObject).putExtra("Kwebmap_locaion", paramString.oDI);
      if (paramString.XAR >= 0.0D) {
        ((Intent)localObject).putExtra("kwebmap_scale", paramString.XAR);
      }
      ((Intent)localObject).putExtra("kisUsername", paramContext);
      ((Intent)localObject).putExtra("kwebmap_from_to", true);
      ((Intent)localObject).putExtra("KFavLocSigleView", true);
      ((Intent)localObject).putExtra("kFavCanDel", false);
      ((Intent)localObject).putExtra("kFavCanRemark", false);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "location", ".ui.RedirectUI", (Intent)localObject);
      AppMethodBeat.o(30354);
      return;
    }
  }
  
  public final void cw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30353);
    paramContext = new Intent();
    paramContext.putExtra("message_id", this.XAr);
    paramContext.putExtra("record_data_id", ((o)this.XzI.get(paramString)).hIQ);
    paramContext.putExtra("record_xml", this.hUx);
    paramContext.putExtra("from_scene", 1);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgImageUI", paramContext);
    AppMethodBeat.o(30353);
  }
  
  public final String d(arf paramarf)
  {
    AppMethodBeat.i(30348);
    tr localtr = new tr();
    localtr.hXt.type = 1;
    localtr.hXt.hIy = paramarf;
    localtr.hXt.msgId = this.XAr.longValue();
    localtr.publish();
    paramarf = localtr.hXu.dataPath;
    AppMethodBeat.o(30348);
    return paramarf;
  }
  
  public final void p(arf paramarf)
  {
    AppMethodBeat.i(30350);
    tr localtr = new tr();
    localtr.hXt.type = 8;
    localtr.hXt.hIy = paramarf;
    localtr.hXt.msgId = this.XAr.longValue();
    localtr.hXt.thumbPath = "";
    localtr.publish();
    AppMethodBeat.o(30350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j
 * JD-Core Version:    0.7.0.1
 */