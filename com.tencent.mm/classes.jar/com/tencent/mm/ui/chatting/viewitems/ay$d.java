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
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.y;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ay$d
  extends c.a
{
  private static SparseArray<String> KCJ;
  private static Map<String, WeakReference<d>> KxW;
  View BOR;
  TextView KCD;
  MMPinProgressBtn KCE;
  View KCF;
  LinearLayout KCG;
  ProgressBar KCH;
  View KCI;
  ImageView KvF;
  ImageView KvG;
  ImageView KvW;
  ImageView Kvx;
  ImageView KxS;
  ImageView Kzq;
  TextView rLB;
  TextView xvf;
  ImageView zWJ;
  
  static
  {
    AppMethodBeat.i(37464);
    KCJ = new SparseArray();
    KxW = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  public static void a(d paramd, bv parambv, final boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37463);
    Object localObject1 = (String)KCJ.get(paramd.hashCode());
    if (localObject1 != null) {
      KxW.remove(localObject1);
    }
    KCJ.put(paramd.hashCode(), parambv.field_imgPath);
    KxW.put(parambv.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.Ia(parambv.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new s();
    }
    label326:
    label345:
    label474:
    label1372:
    for (;;)
    {
      o.aNh();
      Object localObject3 = t.HK(parambv.field_imgPath);
      localObject1 = null;
      f localf = null;
      k.b localb;
      Object localObject4;
      int j;
      int i;
      if (parambv.cyH())
      {
        localb = k.b.aB(parambv.field_content, parambv.field_reserved);
        localObject1 = r.aMY(localb.thumburl);
        localObject3 = q.aIX().a((String)localObject1, com.tencent.mm.cb.a.getDensity(parama.Kkd.getContext()), parama.Kkd.getContext(), 2131231564);
        if ((localObject3 != null) || (localb == null) || (parambv == null))
        {
          localObject4 = (e)localb.ao(e.class);
          localObject1 = localf;
          if (localObject4 != null)
          {
            localObject1 = localf;
            if (((e)localObject4).hCc != null)
            {
              localObject1 = ((e)localObject4).hCc;
              ((s)localObject2).hKI = ((y)localObject1).videoDuration;
            }
          }
          paramd.BOR.setVisibility(0);
          af.a(parama.Kkd.getContext(), localb, paramd.Kvx, paramd.rLB);
          localf = ((com.tencent.mm.ui.chatting.d.b.c)parama.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fHl();
          if ((localf == null) || (!localf.FkC)) {
            break label1026;
          }
          paramd.BOR.setBackgroundResource(2131231717);
          paramd.rLB.setTextColor(com.tencent.mm.cb.a.n(parama.Kkd.getContext(), 2131099662));
          paramd.BOR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(37460);
              this.KCM.BOR.getViewTreeObserver().removeOnPreDrawListener(this);
              if ((this.KCM.BOR.getWidth() > this.KCM.olI.getWidth()) && (!paramBoolean)) {}
              for (int i = 5;; i = 3)
              {
                this.KCM.KCG.setGravity(i);
                AppMethodBeat.o(37460);
                return true;
              }
            }
          });
          paramd.Kzq.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          if (localObject3 != null) {
            break label1167;
          }
          j = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), 85);
          i = com.tencent.mm.cb.a.ax(parama.Kkd.getContext(), 2131165213);
          if ((!parambv.cyH()) || (localObject1 == null) || (((y)localObject1).width <= 0) || (((y)localObject1).height <= 0)) {
            break label1903;
          }
          if (((y)localObject1).width < ((y)localObject1).height) {
            break label1103;
          }
          j = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), i.idi);
          i = (int)(((y)localObject1).height / ((y)localObject1).width * j);
        }
      }
      label1256:
      label1903:
      for (;;)
      {
        localObject1 = h.b(h.aK(parama.Kkd.getContext().getResources().getColor(2131100478), j, i), 2131231564, j, i);
        bc.aCg();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramd.KxS.setImageDrawable(com.tencent.mm.cb.a.l(parama.Kkd.getContext(), 2131691365));
          paramd.KxS.setBackground(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = new FrameLayout.LayoutParams(j, i);
          paramd.Kzq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.KCI != null) {
            paramd.KCI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!paramBoolean) {
            break label1372;
          }
          paramd.xvf.setText(com.tencent.mm.platformtools.af.sL(((s)localObject2).hPI));
          paramd.KCD.setText(com.tencent.mm.platformtools.af.rb(((s)localObject2).hKI));
          i = ((s)localObject2).status;
          ae.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i + " info : " + ((s)localObject2).getFileName());
          if (i != 199) {
            break label1223;
          }
          paramd.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(parama.Kkd.getContext(), 2131691166));
          if ((i != 112) && (i != 122) && (i != 120)) {
            break label1256;
          }
          paramd.KvF.setVisibility(8);
          paramd.zWJ.setVisibility(8);
          paramd.KCE.setVisibility(0);
          paramd.KCE.setProgress(u.g((s)localObject2));
          ae.v("MicroMsg.VideoItemHoder", "status begin");
          paramd.KCE.invalidate();
        }
        for (;;)
        {
          localObject1 = paramd.KvG;
          localObject2 = new ay.e(parambv, parama.fJC(), paramInt, parambv.field_talker);
          ((ay.e)localObject2).oOD = 4;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.KvG.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.KvF;
          localObject2 = new ay.e(parambv, parama.fJC(), paramInt, parambv.field_talker);
          ((ay.e)localObject2).oOD = 3;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.KvF.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.olI;
          parambv = new ay.e(parambv, parama.fJC(), paramInt, parambv.field_talker);
          parambv.oOD = 2;
          ((View)localObject1).setTag(parambv);
          paramd.olI.setOnClickListener(paramOnClickListener);
          paramd.olI.setOnLongClickListener(paramOnLongClickListener);
          paramd.olI.setOnTouchListener(((k)parama.bh(k.class)).fGw());
          AppMethodBeat.o(37463);
          return;
          localObject4 = new WeakReference(parama);
          com.tencent.mm.av.a.a locala = q.aJb();
          String str = localb.thumburl;
          com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
          locala1.hgD = ((String)localObject1);
          locala1.igk = true;
          locala.a(str, locala1.aJu(), new d()
          {
            public final void eM(boolean paramAnonymousVarArgs)
            {
              AppMethodBeat.i(37459);
              if (paramAnonymousVarArgs) {
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(37458);
                    if ((ay.d.2.this.KCK.get() != null) && (((com.tencent.mm.ui.chatting.e.a)ay.d.2.this.KCK.get()).Kkd.getContext() != null) && (!((com.tencent.mm.ui.chatting.e.a)ay.d.2.this.KCK.get()).Kkd.getContext().isFinishing())) {
                      ((com.tencent.mm.ui.chatting.e.a)ay.d.2.this.KCK.get()).bPl();
                    }
                    AppMethodBeat.o(37458);
                  }
                });
              }
              AppMethodBeat.o(37459);
            }
          });
          break;
          paramd.BOR.setBackgroundResource(2131231716);
          paramd.rLB.setTextColor(com.tencent.mm.cb.a.n(parama.Kkd.getContext(), 2131099660));
          break label326;
          paramd.BOR.setVisibility(8);
          localObject3 = q.aIX().a((String)localObject3, com.tencent.mm.cb.a.getDensity(parama.Kkd.getContext()), parama.Kkd.getContext(), 2131231564);
          break label345;
          j = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), i.idi);
          i = (int)(((y)localObject1).width / ((y)localObject1).height * j);
          break label474;
          localObject1 = h.b((Bitmap)localObject1, 2131231564, j, i);
          paramd.KxS.setImageBitmap((Bitmap)localObject1);
          break label556;
          paramd.KxS.setImageBitmap((Bitmap)localObject3);
          localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          paramd.Kzq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.KCI == null) {
            break label594;
          }
          paramd.KCI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label594;
          paramd.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(parama.Kkd.getContext(), 2131691166));
          paramd.xvf.setVisibility(8);
          break label703;
          if ((i == 113) || (i == 198) || (((s)localObject2).aNu()))
          {
            paramd.KvF.setVisibility(0);
            paramd.KvG.setVisibility(8);
            paramd.KCE.setVisibility(8);
            paramd.zWJ.setVisibility(0);
            ae.v("MicroMsg.VideoItemHoder", "status pause");
          }
          else
          {
            paramd.KvG.setVisibility(8);
            paramd.KvF.setVisibility(8);
            paramd.KCE.setVisibility(8);
            paramd.zWJ.setVisibility(0);
            ae.v("MicroMsg.VideoItemHoder", "status gone");
            continue;
            paramd.xvf.setText(com.tencent.mm.platformtools.af.sL(((s)localObject2).hPI));
            paramd.KCD.setText(com.tencent.mm.platformtools.af.rb(((s)localObject2).hKI));
            i = ((s)localObject2).status;
            paramd.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(parama.Kkd.getContext(), 2131691166));
            if (paramd.KCH != null) {
              paramd.KCH.setVisibility(8);
            }
            if (paramd.KCI != null) {
              paramd.KCI.setVisibility(8);
            }
            ae.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(i) });
            if ((i == 104) || (i == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.KF(((s)localObject2).iwZ))
              {
                if (paramd.KCH != null) {
                  paramd.KCH.setVisibility(0);
                }
                if (paramd.KCI != null) {
                  paramd.KCI.setVisibility(0);
                }
                paramd.KCD.setText(null);
                paramd.xvf.setText(null);
                paramd.zWJ.setImageDrawable(null);
                paramd.KvG.setVisibility(8);
                paramd.KvF.setVisibility(8);
                paramd.KCE.setVisibility(8);
              }
              for (;;)
              {
                ae.v("MicroMsg.VideoItemHoder", "status begin");
                break;
                if (paramd.KCH != null) {
                  paramd.KCH.setVisibility(8);
                }
                if (paramd.KCI != null) {
                  paramd.KCI.setVisibility(8);
                }
                paramd.KvF.setVisibility(8);
                paramd.zWJ.setVisibility(8);
                paramd.KCE.setVisibility(0);
                paramd.KCE.setProgress(u.h((s)localObject2));
              }
            }
            if ((i == 105) || (i == 198) || (((s)localObject2).aNu()))
            {
              paramd.KvF.setVisibility(0);
              paramd.KvG.setVisibility(8);
              paramd.KCE.setVisibility(8);
              paramd.zWJ.setVisibility(0);
              ae.v("MicroMsg.VideoItemHoder", "status pause");
            }
            else if (i == 106)
            {
              if (!l.aMV(parambv.field_imgPath))
              {
                u.HR(parambv.field_imgPath);
              }
              else
              {
                if (paramd.KCH != null) {
                  paramd.KCH.setVisibility(0);
                }
                if (paramd.KCI != null) {
                  paramd.KCI.setVisibility(0);
                }
                paramd.KCD.setText(null);
                paramd.xvf.setText(null);
                paramd.zWJ.setImageDrawable(null);
                paramd.KvG.setVisibility(8);
                paramd.KvF.setVisibility(8);
                paramd.KCE.setVisibility(8);
              }
            }
            else
            {
              paramd.KvG.setVisibility(8);
              paramd.KvF.setVisibility(8);
              paramd.KCE.setVisibility(8);
              paramd.zWJ.setVisibility(0);
              ae.v("MicroMsg.VideoItemHoder", "status gone");
            }
          }
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.ixs != t.a.b.ixw)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    s locals = u.Ia(parama.fileName);
    if (locals == null)
    {
      ae.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(37461);
      return false;
    }
    if ((locals.status != 112) && (locals.status != 104) && (locals.status != 103))
    {
      AppMethodBeat.o(37461);
      return false;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37457);
        Object localObject = (WeakReference)ay.d.KxW.get(this.ivJ.getFileName());
        if (localObject == null)
        {
          ae.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.ivJ.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (ay.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          ae.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.ivJ.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((ay.d)localObject).KvF.setVisibility(8);
        ((ay.d)localObject).zWJ.setVisibility(8);
        ((ay.d)localObject).KCE.setVisibility(0);
        int i = this.ivJ.status;
        ae.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((ay.d)localObject).KCE.setProgress(u.g(this.ivJ));
          AppMethodBeat.o(37457);
          return;
        }
        ((ay.d)localObject).KCE.setProgress(u.h(this.ivJ));
        AppMethodBeat.o(37457);
      }
    });
    AppMethodBeat.o(37461);
    return true;
  }
  
  public final c.a E(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(37462);
    super.gs(paramView);
    this.fVV = ((TextView)paramView.findViewById(2131298178));
    this.KxS = ((ImageView)paramView.findViewById(2131298074));
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.xvf = ((TextView)paramView.findViewById(2131298171));
    this.KCD = ((TextView)paramView.findViewById(2131298138));
    this.zWJ = ((ImageView)paramView.findViewById(2131298175));
    this.KvF = ((ImageView)paramView.findViewById(2131298078));
    this.KvG = ((ImageView)paramView.findViewById(2131298177));
    this.KCE = ((MMPinProgressBtn)paramView.findViewById(2131298082));
    this.KCF = paramView.findViewById(2131298188);
    this.olI = paramView.findViewById(2131298069);
    this.rLB = ((TextView)paramView.findViewById(2131298192));
    this.Kvx = ((ImageView)paramView.findViewById(2131298191));
    this.BOR = paramView.findViewById(2131298190);
    this.KCG = ((LinearLayout)paramView.findViewById(2131306320));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.Kzq = ((ImageView)paramView.findViewById(2131298076));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(2131298176);
      this.KvW = ((ImageView)localObject1);
      if (paramBoolean) {
        break label327;
      }
    }
    label327:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(2131298189);; localObject1 = null)
    {
      this.KCH = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(2131306222);
      }
      this.KCI = ((View)localObject1);
      AppMethodBeat.o(37462);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.d
 * JD-Core Version:    0.7.0.1
 */