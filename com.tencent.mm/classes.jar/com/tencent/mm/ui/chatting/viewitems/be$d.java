package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class be$d
  extends c.a
{
  private static Map<String, WeakReference<d>> PKm;
  private static SparseArray<String> PPz;
  TextView Bvi;
  ImageView EeS;
  View Gpy;
  ImageView PHO;
  ImageView PHW;
  ImageView PHX;
  ImageView PIn;
  ImageView PKi;
  ImageView PLQ;
  TextView PPt;
  MMPinProgressBtn PPu;
  View PPv;
  LinearLayout PPw;
  ProgressBar PPx;
  View PPy;
  TextView tln;
  
  static
  {
    AppMethodBeat.i(37464);
    PPz = new SparseArray();
    PKm = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  public static void a(d paramd, ca paramca, final boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37463);
    Object localObject1 = (String)PPz.get(paramd.hashCode());
    if (localObject1 != null) {
      PKm.remove(localObject1);
    }
    PPz.put(paramd.hashCode(), paramca.field_imgPath);
    PKm.put(paramca.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.QN(paramca.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new com.tencent.mm.modelvideo.s();
    }
    label1039:
    label1191:
    label1460:
    for (;;)
    {
      o.bhj();
      Object localObject4 = t.Qx(paramca.field_imgPath);
      localObject1 = null;
      Object localObject3 = null;
      k.b localb;
      float f1;
      Object localObject5;
      label335:
      label358:
      int j;
      int i;
      if (paramca.cWK())
      {
        localb = k.b.aD(paramca.field_content, paramca.field_reserved);
        localObject1 = com.tencent.mm.pluginsdk.model.s.bdu(localb.thumburl);
        localObject4 = q.bcR();
        f1 = com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext());
        parama.Pwc.getContext();
        localObject4 = ((i)localObject4).a((String)localObject1, f1, 2131231628);
        if ((localObject4 != null) || (localb == null) || (paramca == null))
        {
          localObject5 = (e)localb.as(e.class);
          localObject1 = localObject3;
          if (localObject5 != null)
          {
            localObject1 = localObject3;
            if (((e)localObject5).iwi != null)
            {
              localObject1 = ((e)localObject5).iwi;
              ((com.tencent.mm.modelvideo.s)localObject2).iFw = ((y)localObject1).videoDuration;
            }
          }
          paramd.Gpy.setVisibility(0);
          al.a(parama.Pwc.getContext(), localb, paramd.PHO, paramd.tln);
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.c)parama.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPr();
          if ((localObject3 == null) || (!((f)localObject3).Kbu)) {
            break label1039;
          }
          paramd.Gpy.setBackgroundResource(2131231788);
          paramd.tln.setTextColor(com.tencent.mm.cb.a.n(parama.Pwc.getContext(), 2131099665));
          paramd.Gpy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(37460);
              this.PPC.Gpy.getViewTreeObserver().removeOnPreDrawListener(this);
              if ((this.PPC.Gpy.getWidth() > this.PPC.clickArea.getWidth()) && (!paramBoolean)) {}
              for (int i = 5;; i = 3)
              {
                this.PPC.PPw.setGravity(i);
                AppMethodBeat.o(37460);
                return true;
              }
            }
          });
          localObject3 = localObject4;
          paramd.PLQ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          if (localObject3 != null) {
            break label1255;
          }
          j = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 85);
          i = com.tencent.mm.cb.a.aG(parama.Pwc.getContext(), 2131165216);
          if ((!paramca.cWK()) || (localObject1 == null) || (((y)localObject1).width <= 0) || (((y)localObject1).height <= 0)) {
            break label1991;
          }
          if (((y)localObject1).width < ((y)localObject1).height) {
            break label1191;
          }
          j = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), i.iYg);
          i = (int)(((y)localObject1).height / ((y)localObject1).width * j);
        }
      }
      label569:
      label1344:
      label1991:
      for (;;)
      {
        label487:
        localObject1 = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(parama.Pwc.getContext().getResources().getColor(2131100580), j, i), 2131231628, j, i);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramd.PKi.setImageDrawable(com.tencent.mm.cb.a.l(parama.Pwc.getContext(), 2131691699));
          paramd.PKi.setBackground(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = new FrameLayout.LayoutParams(j, i);
          paramd.PLQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.PPy != null) {
            paramd.PPy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          label607:
          if (!paramBoolean) {
            break label1460;
          }
          paramd.Bvi.setText(af.getSizeKB(((com.tencent.mm.modelvideo.s)localObject2).iKP));
          paramd.PPt.setText(af.formatSecToMin(((com.tencent.mm.modelvideo.s)localObject2).iFw));
          i = ((com.tencent.mm.modelvideo.s)localObject2).status;
          Log.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i + " info : " + ((com.tencent.mm.modelvideo.s)localObject2).getFileName());
          if (i != 199) {
            break label1311;
          }
          paramd.EeS.setImageDrawable(com.tencent.mm.cb.a.l(parama.Pwc.getContext(), 2131691480));
          label716:
          if ((i != 112) && (i != 122) && (i != 120)) {
            break label1344;
          }
          paramd.PHW.setVisibility(8);
          paramd.EeS.setVisibility(8);
          paramd.PPu.setVisibility(0);
          paramd.PPu.setProgress(u.g((com.tencent.mm.modelvideo.s)localObject2));
          Log.v("MicroMsg.VideoItemHoder", "status begin");
          paramd.PPu.invalidate();
        }
        for (;;)
        {
          localObject1 = paramd.PHX;
          localObject2 = new be.e(paramca, parama.gRM(), paramInt, paramca.field_talker);
          ((be.e)localObject2).qcr = 4;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.PHX.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.PHW;
          localObject2 = new be.e(paramca, parama.gRM(), paramInt, paramca.field_talker);
          ((be.e)localObject2).qcr = 3;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.PHW.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.clickArea;
          paramca = new be.e(paramca, parama.gRM(), paramInt, paramca.field_talker);
          paramca.qcr = 2;
          ((View)localObject1).setTag(paramca);
          paramd.clickArea.setOnClickListener(paramOnClickListener);
          paramd.clickArea.setOnLongClickListener(paramOnLongClickListener);
          paramd.clickArea.setOnTouchListener(((k)parama.bh(k.class)).gOC());
          AppMethodBeat.o(37463);
          return;
          localObject5 = new WeakReference(parama);
          com.tencent.mm.av.a.a locala = q.bcV();
          String str = localb.thumburl;
          com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
          locala1.fullPath = ((String)localObject1);
          locala1.jbf = true;
          locala.a(str, locala1.bdv(), new d()
          {
            public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
            {
              AppMethodBeat.i(233949);
              if (paramAnonymousBoolean) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(37458);
                    if ((be.d.2.this.PPA.get() != null) && (((com.tencent.mm.ui.chatting.e.a)be.d.2.this.PPA.get()).Pwc.getContext() != null) && (!((com.tencent.mm.ui.chatting.e.a)be.d.2.this.PPA.get()).Pwc.getContext().isFinishing())) {
                      ((com.tencent.mm.ui.chatting.e.a)be.d.2.this.PPA.get()).cmy();
                    }
                    AppMethodBeat.o(37458);
                  }
                });
              }
              AppMethodBeat.o(233949);
            }
          });
          break;
          paramd.Gpy.setBackgroundResource(2131231787);
          paramd.tln.setTextColor(com.tencent.mm.cb.a.n(parama.Pwc.getContext(), 2131099662));
          break label335;
          paramd.Gpy.setVisibility(8);
          f1 = br.G(paramca);
          if (f1 != 1.0F)
          {
            localObject3 = new jc();
            ((jc)localObject3).emN = paramca.field_msgSvrId;
            ((jc)localObject3).eLn = paramca.getType();
            ((jc)localObject3).eQu = br.C(paramca);
            ((jc)localObject3).ejA = 1L;
            ((jc)localObject3).bfK();
          }
          localObject3 = q.bcR();
          float f2 = com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext());
          parama.Pwc.getContext();
          localObject3 = ((i)localObject3).a((String)localObject4, f1 * f2, 2131231628);
          break label358;
          j = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), i.iYg);
          i = (int)(((y)localObject1).width / ((y)localObject1).height * j);
          break label487;
          localObject1 = BitmapUtil.createMaskImage((Bitmap)localObject1, 2131231628, j, i);
          paramd.PKi.setImageBitmap((Bitmap)localObject1);
          break label569;
          label1255:
          paramd.PKi.setImageBitmap((Bitmap)localObject3);
          localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          paramd.PLQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.PPy == null) {
            break label607;
          }
          paramd.PPy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label607;
          paramd.EeS.setImageDrawable(com.tencent.mm.cb.a.l(parama.Pwc.getContext(), 2131691480));
          paramd.Bvi.setVisibility(8);
          break label716;
          if ((i == 113) || (i == 198) || (((com.tencent.mm.modelvideo.s)localObject2).bhw()))
          {
            paramd.PHW.setVisibility(0);
            paramd.PHX.setVisibility(8);
            paramd.PPu.setVisibility(8);
            paramd.EeS.setVisibility(0);
            Log.v("MicroMsg.VideoItemHoder", "status pause");
          }
          else
          {
            paramd.PHX.setVisibility(8);
            paramd.PHW.setVisibility(8);
            paramd.PPu.setVisibility(8);
            paramd.EeS.setVisibility(0);
            Log.v("MicroMsg.VideoItemHoder", "status gone");
            continue;
            paramd.Bvi.setText(af.getSizeKB(((com.tencent.mm.modelvideo.s)localObject2).iKP));
            paramd.PPt.setText(af.formatSecToMin(((com.tencent.mm.modelvideo.s)localObject2).iFw));
            i = ((com.tencent.mm.modelvideo.s)localObject2).status;
            paramd.EeS.setImageDrawable(com.tencent.mm.cb.a.l(parama.Pwc.getContext(), 2131691480));
            if (paramd.PPx != null) {
              paramd.PPx.setVisibility(8);
            }
            if (paramd.PPy != null) {
              paramd.PPy.setVisibility(8);
            }
            Log.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(i) });
            if ((i == 104) || (i == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.QG(((com.tencent.mm.modelvideo.s)localObject2).jso))
              {
                if (paramd.PPx != null) {
                  paramd.PPx.setVisibility(0);
                }
                if (paramd.PPy != null) {
                  paramd.PPy.setVisibility(0);
                }
                paramd.PPt.setText(null);
                paramd.Bvi.setText(null);
                paramd.EeS.setImageDrawable(null);
                paramd.PHX.setVisibility(8);
                paramd.PHW.setVisibility(8);
                paramd.PPu.setVisibility(8);
              }
              for (;;)
              {
                Log.v("MicroMsg.VideoItemHoder", "status begin");
                break;
                if (paramd.PPx != null) {
                  paramd.PPx.setVisibility(8);
                }
                if (paramd.PPy != null) {
                  paramd.PPy.setVisibility(8);
                }
                paramd.PHW.setVisibility(8);
                paramd.EeS.setVisibility(8);
                paramd.PPu.setVisibility(0);
                paramd.PPu.setProgress(u.h((com.tencent.mm.modelvideo.s)localObject2));
              }
            }
            if ((i == 105) || (i == 198) || (((com.tencent.mm.modelvideo.s)localObject2).bhw()))
            {
              paramd.PHW.setVisibility(0);
              paramd.PHX.setVisibility(8);
              paramd.PPu.setVisibility(8);
              paramd.EeS.setVisibility(0);
              Log.v("MicroMsg.VideoItemHoder", "status pause");
            }
            else if (i == 106)
            {
              if (!m.bdr(paramca.field_imgPath))
              {
                u.QE(paramca.field_imgPath);
              }
              else
              {
                if (paramd.PPx != null) {
                  paramd.PPx.setVisibility(0);
                }
                if (paramd.PPy != null) {
                  paramd.PPy.setVisibility(0);
                }
                paramd.PPt.setText(null);
                paramd.Bvi.setText(null);
                paramd.EeS.setImageDrawable(null);
                paramd.PHX.setVisibility(8);
                paramd.PHW.setVisibility(8);
                paramd.PPu.setVisibility(8);
              }
            }
            else
            {
              paramd.PHX.setVisibility(8);
              paramd.PHW.setVisibility(8);
              paramd.PPu.setVisibility(8);
              paramd.EeS.setVisibility(0);
              Log.v("MicroMsg.VideoItemHoder", "status gone");
            }
          }
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.jsH != t.a.b.jsL)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    com.tencent.mm.modelvideo.s locals = u.QN(parama.fileName);
    if (locals == null)
    {
      Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(37461);
      return false;
    }
    if ((locals.status != 112) && (locals.status != 104) && (locals.status != 103))
    {
      AppMethodBeat.o(37461);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37457);
        Object localObject = (WeakReference)be.d.apb().get(this.jqW.getFileName());
        if (localObject == null)
        {
          Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.jqW.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (be.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.jqW.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((be.d)localObject).PHW.setVisibility(8);
        ((be.d)localObject).EeS.setVisibility(8);
        ((be.d)localObject).PPu.setVisibility(0);
        int i = this.jqW.status;
        Log.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((be.d)localObject).PPu.setProgress(u.g(this.jqW));
          AppMethodBeat.o(37457);
          return;
        }
        ((be.d)localObject).PPu.setProgress(u.h(this.jqW));
        AppMethodBeat.o(37457);
      }
    });
    AppMethodBeat.o(37461);
    return true;
  }
  
  public final c.a G(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(37462);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PKi = ((ImageView)paramView.findViewById(2131298417));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.Bvi = ((TextView)paramView.findViewById(2131298550));
    this.PPt = ((TextView)paramView.findViewById(2131298499));
    this.EeS = ((ImageView)paramView.findViewById(2131298555));
    this.PHW = ((ImageView)paramView.findViewById(2131298421));
    this.PHX = ((ImageView)paramView.findViewById(2131298557));
    this.PPu = ((MMPinProgressBtn)paramView.findViewById(2131298425));
    this.PPv = paramView.findViewById(2131298569);
    this.clickArea = paramView.findViewById(2131298411);
    this.tln = ((TextView)paramView.findViewById(2131298573));
    this.PHO = ((ImageView)paramView.findViewById(2131298572));
    this.Gpy = paramView.findViewById(2131298571);
    this.PPw = ((LinearLayout)paramView.findViewById(2131309739));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.PLQ = ((ImageView)paramView.findViewById(2131298419));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(2131298556);
      this.PIn = ((ImageView)localObject1);
      if (paramBoolean) {
        break label327;
      }
    }
    label327:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(2131298570);; localObject1 = null)
    {
      this.PPx = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(2131309621);
      }
      this.PPy = ((View)localObject1);
      AppMethodBeat.o(37462);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.d
 * JD-Core Version:    0.7.0.1
 */