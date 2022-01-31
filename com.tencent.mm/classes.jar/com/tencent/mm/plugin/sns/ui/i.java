package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  public static List<k> rFu;
  Context context;
  String dZZ;
  public ListView list;
  ClipboardManager mAZ;
  c rFA;
  c rFB;
  View.OnLongClickListener rFC;
  public com.tencent.mm.plugin.sns.a.b.g rFk;
  public com.tencent.mm.plugin.sns.model.av rFl;
  boolean rFm;
  boolean rFn;
  SnsCommentFooter rFo;
  bf rFp;
  an rFq;
  private boolean rFr;
  String rFs;
  private boolean rFt;
  be rFv;
  b rFw;
  com.tencent.mm.plugin.sns.g.b rFx;
  public com.tencent.mm.plugin.sns.ui.d.b rFy;
  com.tencent.mm.ui.base.p rFz;
  public av rkX;
  FrameLayout rkt;
  
  static
  {
    AppMethodBeat.i(38193);
    rFu = new LinkedList();
    AppMethodBeat.o(38193);
  }
  
  public i(Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(38188);
    this.rFn = false;
    this.rFr = false;
    this.rFs = "";
    this.rFt = false;
    this.rFz = null;
    this.rFA = new i.2(this);
    this.rFB = new i.3(this);
    this.rFC = new i.6(this);
    this.context = paramContext;
    this.dZZ = com.tencent.mm.model.r.Zn();
    this.rFl = new com.tencent.mm.plugin.sns.model.av();
    this.rFl.rhS = new com.tencent.mm.plugin.sns.i.b(paramInt1, paramString1, paramInt2, paramString2);
    this.rFy = new i.1(this, (Activity)paramContext, this.rFl);
    this.rFy.bKw();
    com.tencent.mm.sdk.b.a.ymk.c(this.rFA);
    com.tencent.mm.sdk.b.a.ymk.c(this.rFB);
    AppMethodBeat.o(38188);
  }
  
  static int du(String paramString, int paramInt)
  {
    AppMethodBeat.i(38192);
    Iterator localIterator = rFu.iterator();
    k localk;
    do
    {
      i = paramInt;
      if (!localIterator.hasNext()) {
        break;
      }
      localk = (k)localIterator.next();
    } while (!bo.isEqual(localk.key, paramString));
    int i = localk.bsY;
    AppMethodBeat.o(38192);
    return i;
  }
  
  final void c(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(38191);
    int i = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
    if (paramBaseViewHolder.she != null)
    {
      i += paramBaseViewHolder.shg.getHeight() - paramBaseViewHolder.she.getBottom();
      ab.i("MicroMsg.BaseTimeLine", "comment item bottom = " + paramBaseViewHolder.she.getBottom());
    }
    for (;;)
    {
      this.rFp.position = paramBaseViewHolder.position;
      this.rFp.scQ = (paramBaseViewHolder.ngZ.getHeight() - i);
      paramBaseViewHolder.she = null;
      this.rFp.scR = paramBaseViewHolder.ngZ.getTop();
      this.rFp.rOD = this.list.getBottom();
      ab.e("MicroMsg.BaseTimeLine", "originalTop:" + this.rFp.scR);
      if ((!(this.context instanceof MMActivity)) || (((MMActivity)this.context).keyboardState() == 1)) {
        break;
      }
      this.rFm = true;
      AppMethodBeat.o(38191);
      return;
      i = 0;
    }
    this.rFp.cwJ();
    AppMethodBeat.o(38191);
  }
  
  final void ctq()
  {
    AppMethodBeat.i(38189);
    if (this.rFr)
    {
      AppMethodBeat.o(38189);
      return;
    }
    this.rFr = true;
    this.rFo.setAfterEditAction(this.rFp.scV);
    this.rFo.setOnCommentSendImp(new i.4(this));
    SnsCommentFooter localSnsCommentFooter = this.rFo;
    i.5 local5 = new i.5(this);
    if (localSnsCommentFooter.oxm != null) {
      localSnsCommentFooter.oxm.setBackListener(local5);
    }
    AppMethodBeat.o(38189);
  }
  
  final void ctr()
  {
    AppMethodBeat.i(38190);
    if (!this.rFr)
    {
      AppMethodBeat.o(38190);
      return;
    }
    if (this.rFo.getVisibility() != 8) {
      this.rFo.setVisibility(8);
    }
    av localav = this.rkX;
    if (localav.rWS != null) {
      localav.rWS.setVisibility(8);
    }
    localav.rWS = null;
    AppMethodBeat.o(38190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i
 * JD-Core Version:    0.7.0.1
 */