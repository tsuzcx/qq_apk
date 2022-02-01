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
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.y;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ay$d
  extends c.a
{
  private static Map<String, WeakReference<d>> KbE;
  private static SparseArray<String> Kgq;
  View Bxt;
  ImageView JZD;
  ImageView JZe;
  ImageView JZm;
  ImageView JZn;
  ImageView KbA;
  ImageView KcY;
  TextView Kgk;
  MMPinProgressBtn Kgl;
  View Kgm;
  LinearLayout Kgn;
  ProgressBar Kgo;
  View Kgp;
  TextView rDq;
  TextView xfn;
  ImageView zFD;
  
  static
  {
    AppMethodBeat.i(37464);
    Kgq = new SparseArray();
    KbE = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  public static void a(d paramd, bu parambu, final boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37463);
    Object localObject1 = (String)Kgq.get(paramd.hashCode());
    if (localObject1 != null) {
      KbE.remove(localObject1);
    }
    Kgq.put(paramd.hashCode(), parambu.field_imgPath);
    KbE.put(parambu.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.Hy(parambu.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new s();
    }
    label326:
    label345:
    label474:
    label1372:
    for (;;)
    {
      o.aMJ();
      Object localObject3 = t.Hi(parambu.field_imgPath);
      localObject1 = null;
      f localf = null;
      k.b localb;
      Object localObject4;
      int j;
      int i;
      if (parambu.cxg())
      {
        localb = k.b.aA(parambu.field_content, parambu.field_reserved);
        localObject1 = r.aLC(localb.thumburl);
        localObject3 = q.aIF().a((String)localObject1, com.tencent.mm.cc.a.getDensity(parama.JOR.getContext()), parama.JOR.getContext(), 2131231564);
        if ((localObject3 != null) || (localb == null) || (parambu == null))
        {
          localObject4 = (e)localb.ao(e.class);
          localObject1 = localf;
          if (localObject4 != null)
          {
            localObject1 = localf;
            if (((e)localObject4).hzo != null)
            {
              localObject1 = ((e)localObject4).hzo;
              ((s)localObject2).hHQ = ((y)localObject1).videoDuration;
            }
          }
          paramd.Bxt.setVisibility(0);
          af.a(parama.JOR.getContext(), localb, paramd.JZe, paramd.rDq);
          localf = ((com.tencent.mm.ui.chatting.d.b.c)parama.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fDj();
          if ((localf == null) || (!localf.ESh)) {
            break label1026;
          }
          paramd.Bxt.setBackgroundResource(2131231717);
          paramd.rDq.setTextColor(com.tencent.mm.cc.a.n(parama.JOR.getContext(), 2131099662));
          paramd.Bxt.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(37460);
              this.Kgt.Bxt.getViewTreeObserver().removeOnPreDrawListener(this);
              if ((this.Kgt.Bxt.getWidth() > this.Kgt.ofK.getWidth()) && (!paramBoolean)) {}
              for (int i = 5;; i = 3)
              {
                this.Kgt.Kgn.setGravity(i);
                AppMethodBeat.o(37460);
                return true;
              }
            }
          });
          paramd.KcY.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          if (localObject3 != null) {
            break label1167;
          }
          j = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), 85);
          i = com.tencent.mm.cc.a.ax(parama.JOR.getContext(), 2131165213);
          if ((!parambu.cxg()) || (localObject1 == null) || (((y)localObject1).width <= 0) || (((y)localObject1).height <= 0)) {
            break label1903;
          }
          if (((y)localObject1).width < ((y)localObject1).height) {
            break label1103;
          }
          j = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), i.iaq);
          i = (int)(((y)localObject1).height / ((y)localObject1).width * j);
        }
      }
      label1256:
      label1903:
      for (;;)
      {
        localObject1 = g.b(g.aJ(parama.JOR.getContext().getResources().getColor(2131100478), j, i), 2131231564, j, i);
        ba.aBQ();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramd.KbA.setImageDrawable(com.tencent.mm.cc.a.l(parama.JOR.getContext(), 2131691365));
          paramd.KbA.setBackground(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = new FrameLayout.LayoutParams(j, i);
          paramd.KcY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.Kgp != null) {
            paramd.Kgp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!paramBoolean) {
            break label1372;
          }
          paramd.xfn.setText(com.tencent.mm.platformtools.af.sy(((s)localObject2).hMP));
          paramd.Kgk.setText(com.tencent.mm.platformtools.af.qY(((s)localObject2).hHQ));
          i = ((s)localObject2).status;
          ad.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i + " info : " + ((s)localObject2).getFileName());
          if (i != 199) {
            break label1223;
          }
          paramd.zFD.setImageDrawable(com.tencent.mm.cc.a.l(parama.JOR.getContext(), 2131691166));
          if ((i != 112) && (i != 122) && (i != 120)) {
            break label1256;
          }
          paramd.JZm.setVisibility(8);
          paramd.zFD.setVisibility(8);
          paramd.Kgl.setVisibility(0);
          paramd.Kgl.setProgress(u.g((s)localObject2));
          ad.v("MicroMsg.VideoItemHoder", "status begin");
          paramd.Kgl.invalidate();
        }
        for (;;)
        {
          localObject1 = paramd.JZn;
          localObject2 = new ay.e(parambu, parama.fFv(), paramInt, parambu.field_talker);
          ((ay.e)localObject2).oIb = 4;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.JZn.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.JZm;
          localObject2 = new ay.e(parambu, parama.fFv(), paramInt, parambu.field_talker);
          ((ay.e)localObject2).oIb = 3;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.JZm.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.ofK;
          parambu = new ay.e(parambu, parama.fFv(), paramInt, parambu.field_talker);
          parambu.oIb = 2;
          ((View)localObject1).setTag(parambu);
          paramd.ofK.setOnClickListener(paramOnClickListener);
          paramd.ofK.setOnLongClickListener(paramOnLongClickListener);
          paramd.ofK.setOnTouchListener(((k)parama.bh(k.class)).fCu());
          AppMethodBeat.o(37463);
          return;
          localObject4 = new WeakReference(parama);
          com.tencent.mm.aw.a.a locala = q.aIJ();
          String str = localb.thumburl;
          com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
          locala1.hdP = ((String)localObject1);
          locala1.idr = true;
          locala.a(str, locala1.aJc(), new d()
          {
            public final void eK(boolean paramAnonymousVarArgs)
            {
              AppMethodBeat.i(37459);
              if (paramAnonymousVarArgs) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(37458);
                    if ((ay.d.2.this.Kgr.get() != null) && (((com.tencent.mm.ui.chatting.e.a)ay.d.2.this.Kgr.get()).JOR.getContext() != null) && (!((com.tencent.mm.ui.chatting.e.a)ay.d.2.this.Kgr.get()).JOR.getContext().isFinishing())) {
                      ((com.tencent.mm.ui.chatting.e.a)ay.d.2.this.Kgr.get()).bOo();
                    }
                    AppMethodBeat.o(37458);
                  }
                });
              }
              AppMethodBeat.o(37459);
            }
          });
          break;
          paramd.Bxt.setBackgroundResource(2131231716);
          paramd.rDq.setTextColor(com.tencent.mm.cc.a.n(parama.JOR.getContext(), 2131099660));
          break label326;
          paramd.Bxt.setVisibility(8);
          localObject3 = q.aIF().a((String)localObject3, com.tencent.mm.cc.a.getDensity(parama.JOR.getContext()), parama.JOR.getContext(), 2131231564);
          break label345;
          j = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), i.iaq);
          i = (int)(((y)localObject1).width / ((y)localObject1).height * j);
          break label474;
          localObject1 = g.b((Bitmap)localObject1, 2131231564, j, i);
          paramd.KbA.setImageBitmap((Bitmap)localObject1);
          break label556;
          paramd.KbA.setImageBitmap((Bitmap)localObject3);
          localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          paramd.KcY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.Kgp == null) {
            break label594;
          }
          paramd.Kgp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label594;
          paramd.zFD.setImageDrawable(com.tencent.mm.cc.a.l(parama.JOR.getContext(), 2131691166));
          paramd.xfn.setVisibility(8);
          break label703;
          if ((i == 113) || (i == 198) || (((s)localObject2).aMW()))
          {
            paramd.JZm.setVisibility(0);
            paramd.JZn.setVisibility(8);
            paramd.Kgl.setVisibility(8);
            paramd.zFD.setVisibility(0);
            ad.v("MicroMsg.VideoItemHoder", "status pause");
          }
          else
          {
            paramd.JZn.setVisibility(8);
            paramd.JZm.setVisibility(8);
            paramd.Kgl.setVisibility(8);
            paramd.zFD.setVisibility(0);
            ad.v("MicroMsg.VideoItemHoder", "status gone");
            continue;
            paramd.xfn.setText(com.tencent.mm.platformtools.af.sy(((s)localObject2).hMP));
            paramd.Kgk.setText(com.tencent.mm.platformtools.af.qY(((s)localObject2).hHQ));
            i = ((s)localObject2).status;
            paramd.zFD.setImageDrawable(com.tencent.mm.cc.a.l(parama.JOR.getContext(), 2131691166));
            if (paramd.Kgo != null) {
              paramd.Kgo.setVisibility(8);
            }
            if (paramd.Kgp != null) {
              paramd.Kgp.setVisibility(8);
            }
            ad.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(i) });
            if ((i == 104) || (i == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.Kf(((s)localObject2).iuf))
              {
                if (paramd.Kgo != null) {
                  paramd.Kgo.setVisibility(0);
                }
                if (paramd.Kgp != null) {
                  paramd.Kgp.setVisibility(0);
                }
                paramd.Kgk.setText(null);
                paramd.xfn.setText(null);
                paramd.zFD.setImageDrawable(null);
                paramd.JZn.setVisibility(8);
                paramd.JZm.setVisibility(8);
                paramd.Kgl.setVisibility(8);
              }
              for (;;)
              {
                ad.v("MicroMsg.VideoItemHoder", "status begin");
                break;
                if (paramd.Kgo != null) {
                  paramd.Kgo.setVisibility(8);
                }
                if (paramd.Kgp != null) {
                  paramd.Kgp.setVisibility(8);
                }
                paramd.JZm.setVisibility(8);
                paramd.zFD.setVisibility(8);
                paramd.Kgl.setVisibility(0);
                paramd.Kgl.setProgress(u.h((s)localObject2));
              }
            }
            if ((i == 105) || (i == 198) || (((s)localObject2).aMW()))
            {
              paramd.JZm.setVisibility(0);
              paramd.JZn.setVisibility(8);
              paramd.Kgl.setVisibility(8);
              paramd.zFD.setVisibility(0);
              ad.v("MicroMsg.VideoItemHoder", "status pause");
            }
            else if (i == 106)
            {
              if (!l.aLz(parambu.field_imgPath))
              {
                u.Hp(parambu.field_imgPath);
              }
              else
              {
                if (paramd.Kgo != null) {
                  paramd.Kgo.setVisibility(0);
                }
                if (paramd.Kgp != null) {
                  paramd.Kgp.setVisibility(0);
                }
                paramd.Kgk.setText(null);
                paramd.xfn.setText(null);
                paramd.zFD.setImageDrawable(null);
                paramd.JZn.setVisibility(8);
                paramd.JZm.setVisibility(8);
                paramd.Kgl.setVisibility(8);
              }
            }
            else
            {
              paramd.JZn.setVisibility(8);
              paramd.JZm.setVisibility(8);
              paramd.Kgl.setVisibility(8);
              paramd.zFD.setVisibility(0);
              ad.v("MicroMsg.VideoItemHoder", "status gone");
            }
          }
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.iuy != t.a.b.iuC)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    s locals = u.Hy(parama.fileName);
    if (locals == null)
    {
      ad.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(37461);
      return false;
    }
    if ((locals.status != 112) && (locals.status != 104) && (locals.status != 103))
    {
      AppMethodBeat.o(37461);
      return false;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37457);
        Object localObject = (WeakReference)ay.d.KbE.get(this.isP.getFileName());
        if (localObject == null)
        {
          ad.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.isP.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (ay.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          ad.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.isP.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((ay.d)localObject).JZm.setVisibility(8);
        ((ay.d)localObject).zFD.setVisibility(8);
        ((ay.d)localObject).Kgl.setVisibility(0);
        int i = this.isP.status;
        ad.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((ay.d)localObject).Kgl.setProgress(u.g(this.isP));
          AppMethodBeat.o(37457);
          return;
        }
        ((ay.d)localObject).Kgl.setProgress(u.h(this.isP));
        AppMethodBeat.o(37457);
      }
    });
    AppMethodBeat.o(37461);
    return true;
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(37462);
    super.gn(paramView);
    this.fTP = ((TextView)paramView.findViewById(2131298178));
    this.KbA = ((ImageView)paramView.findViewById(2131298074));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.xfn = ((TextView)paramView.findViewById(2131298171));
    this.Kgk = ((TextView)paramView.findViewById(2131298138));
    this.zFD = ((ImageView)paramView.findViewById(2131298175));
    this.JZm = ((ImageView)paramView.findViewById(2131298078));
    this.JZn = ((ImageView)paramView.findViewById(2131298177));
    this.Kgl = ((MMPinProgressBtn)paramView.findViewById(2131298082));
    this.Kgm = paramView.findViewById(2131298188);
    this.ofK = paramView.findViewById(2131298069);
    this.rDq = ((TextView)paramView.findViewById(2131298192));
    this.JZe = ((ImageView)paramView.findViewById(2131298191));
    this.Bxt = paramView.findViewById(2131298190);
    this.Kgn = ((LinearLayout)paramView.findViewById(2131306320));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.KcY = ((ImageView)paramView.findViewById(2131298076));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(2131298176);
      this.JZD = ((ImageView)localObject1);
      if (paramBoolean) {
        break label327;
      }
    }
    label327:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(2131298189);; localObject1 = null)
    {
      this.Kgo = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(2131306222);
      }
      this.Kgp = ((View)localObject1);
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