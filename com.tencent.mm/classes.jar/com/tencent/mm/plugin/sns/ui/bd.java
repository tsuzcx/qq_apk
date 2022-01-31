package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;

public final class bd
{
  Context context;
  int cpt;
  long jfp;
  af rFN;
  public View.OnClickListener rUE;
  public View.OnClickListener scA;
  public View.OnClickListener scB;
  public View.OnClickListener scC;
  public View.OnClickListener scD;
  public View.OnClickListener scE;
  public View.OnClickListener scF;
  public View.OnClickListener scG;
  public View.OnClickListener scH;
  public View.OnClickListener scI;
  public View.OnClickListener scJ;
  bd.a scv;
  public View.OnClickListener scw;
  public View.OnClickListener scx;
  public View.OnClickListener scy;
  public View.OnClickListener scz;
  p tipDialog;
  
  public bd(Context paramContext, bd.a parama, int paramInt, af paramaf)
  {
    AppMethodBeat.i(39879);
    this.cpt = 0;
    this.jfp = 0L;
    this.rUE = new bd.1(this);
    this.scw = new bd.8(this);
    this.scx = new bd.9(this);
    this.scy = new bd.10(this);
    this.scz = new bd.11(this);
    this.scA = new bd.12(this);
    this.scB = new bd.13(this);
    this.scC = new bd.14(this);
    this.scD = new bd.15(this);
    this.scE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39863);
        boolean bool = paramAnonymousView.getTag() instanceof q;
        ab.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(bool)));
        if (!bool)
        {
          AppMethodBeat.o(39863);
          return;
        }
        q localq = (q)paramAnonymousView.getTag();
        TimeLineObject localTimeLineObject = localq.rGk;
        String str;
        if (!bd.YC(localTimeLineObject.Id)) {
          if ((!com.tencent.mm.r.a.bO(bd.this.context)) && (!com.tencent.mm.r.a.bM(bd.this.context)))
          {
            h.qsU.kvStat(10090, "1,0");
            if (localTimeLineObject.xTS.wOa.size() > 0)
            {
              bcs localbcs = (bcs)localTimeLineObject.xTS.wOa.get(0);
              if (bd.this.cpt != 0) {
                break label261;
              }
              paramAnonymousView = com.tencent.mm.modelsns.b.lV(738);
              com.tencent.mm.modelsns.b localb = paramAnonymousView.uv(localTimeLineObject.Id).uv(localTimeLineObject.jJA);
              if (localTimeLineObject.xTR != null) {
                break label271;
              }
              str = "";
              label179:
              localb.uv(str).uv(localbcs.Title).uv(localbcs.Desc).uv("");
              paramAnonymousView.ake();
            }
            if (!localq.rGl) {
              break label283;
            }
            com.tencent.mm.aw.a.a(g.a(ag.getAccPath(), localTimeLineObject, 9));
          }
        }
        for (;;)
        {
          if (bd.this.scv != null) {
            bd.this.scv.cva();
          }
          AppMethodBeat.o(39863);
          return;
          label261:
          paramAnonymousView = com.tencent.mm.modelsns.b.lW(738);
          break;
          label271:
          str = localTimeLineObject.xTR.Id;
          break label179;
          label283:
          com.tencent.mm.aw.a.b(g.a(ag.getAccPath(), localTimeLineObject, 1));
          continue;
          h.qsU.kvStat(10231, "1");
          com.tencent.mm.aw.a.aiu();
        }
      }
    };
    this.scF = new bd.3(this);
    this.scG = new bd.4(this);
    this.scH = new bd.5(this);
    this.scI = new bd.6(this);
    this.scJ = new bd.7(this);
    this.context = paramContext;
    this.scv = parama;
    this.cpt = paramInt;
    this.rFN = paramaf;
    AppMethodBeat.o(39879);
  }
  
  protected static boolean YC(String paramString)
  {
    AppMethodBeat.i(39880);
    Object localObject = new kh();
    ((kh)localObject).czU.action = -2;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((kh)localObject).czV.czW;
    if ((localObject != null) && (com.tencent.mm.aw.a.d((e)localObject)) && (paramString.equals(((e)localObject).fKj)) && (com.tencent.mm.aw.a.aiw()))
    {
      AppMethodBeat.o(39880);
      return true;
    }
    AppMethodBeat.o(39880);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */