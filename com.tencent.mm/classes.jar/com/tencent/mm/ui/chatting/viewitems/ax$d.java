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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.y;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.g;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ax$d
  extends c.a
{
  private static Map<String, WeakReference<d>> Ilg;
  private static SparseArray<String> IpQ;
  View AfH;
  ImageView IiG;
  ImageView IiO;
  ImageView IiP;
  ImageView Ijf;
  ImageView Ilc;
  ImageView ImA;
  TextView IpK;
  MMPinProgressBtn IpL;
  View IpM;
  LinearLayout IpN;
  ProgressBar IpO;
  View IpP;
  TextView qTn;
  TextView vXz;
  ImageView yoI;
  
  static
  {
    AppMethodBeat.i(37464);
    IpQ = new SparseArray();
    Ilg = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  public static void a(d paramd, bo parambo, final boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37463);
    Object localObject1 = (String)IpQ.get(paramd.hashCode());
    if (localObject1 != null) {
      Ilg.remove(localObject1);
    }
    IpQ.put(paramd.hashCode(), parambo.field_imgPath);
    Ilg.put(parambo.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.Ej(parambo.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new s();
    }
    label326:
    label345:
    label474:
    label1372:
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aJy();
      Object localObject3 = t.DW(parambo.field_imgPath);
      localObject1 = null;
      com.tencent.mm.pluginsdk.ui.e locale = null;
      k.b localb;
      Object localObject4;
      int j;
      int i;
      if (parambo.cru())
      {
        localb = k.b.az(parambo.field_content, parambo.field_reserved);
        localObject1 = r.aGc(localb.thumburl);
        localObject3 = com.tencent.mm.av.o.aFx().a((String)localObject1, com.tencent.mm.cc.a.getDensity(parama.HZF.getContext()), parama.HZF.getContext(), 2131231564);
        if ((localObject3 != null) || (localb == null) || (parambo == null))
        {
          localObject4 = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
          localObject1 = locale;
          if (localObject4 != null)
          {
            localObject1 = locale;
            if (((com.tencent.mm.ah.e)localObject4).hhf != null)
            {
              localObject1 = ((com.tencent.mm.ah.e)localObject4).hhf;
              ((s)localObject2).hpy = ((y)localObject1).videoDuration;
            }
          }
          paramd.AfH.setVisibility(0);
          ae.a(parama.HZF.getContext(), localb, paramd.IiG, paramd.qTn);
          locale = ((com.tencent.mm.ui.chatting.c.b.c)parama.bf(com.tencent.mm.ui.chatting.c.b.c.class)).fmP();
          if ((locale == null) || (!locale.Dnc)) {
            break label1026;
          }
          paramd.AfH.setBackgroundResource(2131231717);
          paramd.qTn.setTextColor(com.tencent.mm.cc.a.n(parama.HZF.getContext(), 2131099662));
          paramd.AfH.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(37460);
              this.IpT.AfH.getViewTreeObserver().removeOnPreDrawListener(this);
              if ((this.IpT.AfH.getWidth() > this.IpT.nDl.getWidth()) && (!paramBoolean)) {}
              for (int i = 5;; i = 3)
              {
                this.IpT.IpN.setGravity(i);
                AppMethodBeat.o(37460);
                return true;
              }
            }
          });
          paramd.ImA.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          if (localObject3 != null) {
            break label1167;
          }
          j = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 85);
          i = com.tencent.mm.cc.a.au(parama.HZF.getContext(), 2131165213);
          if ((!parambo.cru()) || (localObject1 == null) || (((y)localObject1).width <= 0) || (((y)localObject1).height <= 0)) {
            break label1903;
          }
          if (((y)localObject1).width < ((y)localObject1).height) {
            break label1103;
          }
          j = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), g.hHH);
          i = (int)(((y)localObject1).height / ((y)localObject1).width * j);
        }
      }
      label1256:
      label1903:
      for (;;)
      {
        localObject1 = f.b(f.aH(parama.HZF.getContext().getResources().getColor(2131100478), j, i), 2131231564, j, i);
        az.ayM();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramd.Ilc.setImageDrawable(com.tencent.mm.cc.a.l(parama.HZF.getContext(), 2131691365));
          paramd.Ilc.setBackground(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = new FrameLayout.LayoutParams(j, i);
          paramd.ImA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.IpP != null) {
            paramd.IpP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!paramBoolean) {
            break label1372;
          }
          paramd.vXz.setText(com.tencent.mm.platformtools.ae.qz(((s)localObject2).hux));
          paramd.IpK.setText(com.tencent.mm.platformtools.ae.qy(((s)localObject2).hpy));
          i = ((s)localObject2).status;
          ac.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i + " info : " + ((s)localObject2).getFileName());
          if (i != 199) {
            break label1223;
          }
          paramd.yoI.setImageDrawable(com.tencent.mm.cc.a.l(parama.HZF.getContext(), 2131231268));
          if ((i != 112) && (i != 122) && (i != 120)) {
            break label1256;
          }
          paramd.IiO.setVisibility(8);
          paramd.yoI.setVisibility(8);
          paramd.IpL.setVisibility(0);
          paramd.IpL.setProgress(u.g((s)localObject2));
          ac.v("MicroMsg.VideoItemHoder", "status begin");
          paramd.IpL.invalidate();
        }
        for (;;)
        {
          localObject1 = paramd.IiP;
          localObject2 = new ax.e(parambo, parama.foQ(), paramInt, parambo.field_talker);
          ((ax.e)localObject2).oeH = 4;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.IiP.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.IiO;
          localObject2 = new ax.e(parambo, parama.foQ(), paramInt, parambo.field_talker);
          ((ax.e)localObject2).oeH = 3;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.IiO.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.nDl;
          parambo = new ax.e(parambo, parama.foQ(), paramInt, parambo.field_talker);
          parambo.oeH = 2;
          ((View)localObject1).setTag(parambo);
          paramd.nDl.setOnClickListener(paramOnClickListener);
          paramd.nDl.setOnLongClickListener(paramOnLongClickListener);
          paramd.nDl.setOnTouchListener(((i)parama.bf(i.class)).fmb());
          AppMethodBeat.o(37463);
          return;
          localObject4 = new WeakReference(parama);
          com.tencent.mm.av.a.a locala = com.tencent.mm.av.o.aFB();
          String str = localb.thumburl;
          com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
          locala1.gKe = ((String)localObject1);
          locala1.hKx = true;
          locala.a(str, locala1.aFT(), new d()
          {
            public final void eI(boolean paramAnonymousVarArgs)
            {
              AppMethodBeat.i(37459);
              if (paramAnonymousVarArgs) {
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(37458);
                    if ((ax.d.2.this.IpR.get() != null) && (((com.tencent.mm.ui.chatting.d.a)ax.d.2.this.IpR.get()).HZF.getContext() != null) && (!((com.tencent.mm.ui.chatting.d.a)ax.d.2.this.IpR.get()).HZF.getContext().isFinishing())) {
                      ((com.tencent.mm.ui.chatting.d.a)ax.d.2.this.IpR.get()).bJU();
                    }
                    AppMethodBeat.o(37458);
                  }
                });
              }
              AppMethodBeat.o(37459);
            }
          });
          break;
          paramd.AfH.setBackgroundResource(2131231716);
          paramd.qTn.setTextColor(com.tencent.mm.cc.a.n(parama.HZF.getContext(), 2131099660));
          break label326;
          paramd.AfH.setVisibility(8);
          localObject3 = com.tencent.mm.av.o.aFx().a((String)localObject3, com.tencent.mm.cc.a.getDensity(parama.HZF.getContext()), parama.HZF.getContext(), 2131231564);
          break label345;
          j = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), g.hHH);
          i = (int)(((y)localObject1).width / ((y)localObject1).height * j);
          break label474;
          localObject1 = f.b((Bitmap)localObject1, 2131231564, j, i);
          paramd.Ilc.setImageBitmap((Bitmap)localObject1);
          break label556;
          paramd.Ilc.setImageBitmap((Bitmap)localObject3);
          localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          paramd.ImA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.IpP == null) {
            break label594;
          }
          paramd.IpP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label594;
          paramd.yoI.setImageDrawable(com.tencent.mm.cc.a.l(parama.HZF.getContext(), 2131231268));
          paramd.vXz.setVisibility(8);
          break label703;
          if ((i == 113) || (i == 198) || (((s)localObject2).aJL()))
          {
            paramd.IiO.setVisibility(0);
            paramd.IiP.setVisibility(8);
            paramd.IpL.setVisibility(8);
            paramd.yoI.setVisibility(0);
            ac.v("MicroMsg.VideoItemHoder", "status pause");
          }
          else
          {
            paramd.IiP.setVisibility(8);
            paramd.IiO.setVisibility(8);
            paramd.IpL.setVisibility(8);
            paramd.yoI.setVisibility(0);
            ac.v("MicroMsg.VideoItemHoder", "status gone");
            continue;
            paramd.vXz.setText(com.tencent.mm.platformtools.ae.qz(((s)localObject2).hux));
            paramd.IpK.setText(com.tencent.mm.platformtools.ae.qy(((s)localObject2).hpy));
            i = ((s)localObject2).status;
            paramd.yoI.setImageDrawable(com.tencent.mm.cc.a.l(parama.HZF.getContext(), 2131231268));
            if (paramd.IpO != null) {
              paramd.IpO.setVisibility(8);
            }
            if (paramd.IpP != null) {
              paramd.IpP.setVisibility(8);
            }
            ac.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(i) });
            if ((i == 104) || (i == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.II(((s)localObject2).iaJ))
              {
                if (paramd.IpO != null) {
                  paramd.IpO.setVisibility(0);
                }
                if (paramd.IpP != null) {
                  paramd.IpP.setVisibility(0);
                }
                paramd.IpK.setText(null);
                paramd.vXz.setText(null);
                paramd.yoI.setImageDrawable(null);
                paramd.IiP.setVisibility(8);
                paramd.IiO.setVisibility(8);
                paramd.IpL.setVisibility(8);
              }
              for (;;)
              {
                ac.v("MicroMsg.VideoItemHoder", "status begin");
                break;
                if (paramd.IpO != null) {
                  paramd.IpO.setVisibility(8);
                }
                if (paramd.IpP != null) {
                  paramd.IpP.setVisibility(8);
                }
                paramd.IiO.setVisibility(8);
                paramd.yoI.setVisibility(8);
                paramd.IpL.setVisibility(0);
                paramd.IpL.setProgress(u.h((s)localObject2));
              }
            }
            if ((i == 105) || (i == 198) || (((s)localObject2).aJL()))
            {
              paramd.IiO.setVisibility(0);
              paramd.IiP.setVisibility(8);
              paramd.IpL.setVisibility(8);
              paramd.yoI.setVisibility(0);
              ac.v("MicroMsg.VideoItemHoder", "status pause");
            }
            else if (i == 106)
            {
              if (!l.aFZ(parambo.field_imgPath))
              {
                u.Ea(parambo.field_imgPath);
              }
              else
              {
                if (paramd.IpO != null) {
                  paramd.IpO.setVisibility(0);
                }
                if (paramd.IpP != null) {
                  paramd.IpP.setVisibility(0);
                }
                paramd.IpK.setText(null);
                paramd.vXz.setText(null);
                paramd.yoI.setImageDrawable(null);
                paramd.IiP.setVisibility(8);
                paramd.IiO.setVisibility(8);
                paramd.IpL.setVisibility(8);
              }
            }
            else
            {
              paramd.IiP.setVisibility(8);
              paramd.IiO.setVisibility(8);
              paramd.IpL.setVisibility(8);
              paramd.yoI.setVisibility(0);
              ac.v("MicroMsg.VideoItemHoder", "status gone");
            }
          }
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.ibc != t.a.b.ibg)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    s locals = u.Ej(parama.fileName);
    if (locals == null)
    {
      ac.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(37461);
      return false;
    }
    if ((locals.status != 112) && (locals.status != 104) && (locals.status != 103))
    {
      AppMethodBeat.o(37461);
      return false;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37457);
        Object localObject = (WeakReference)ax.d.Ilg.get(this.Ids.getFileName());
        if (localObject == null)
        {
          ac.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.Ids.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (ax.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          ac.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.Ids.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((ax.d)localObject).IiO.setVisibility(8);
        ((ax.d)localObject).yoI.setVisibility(8);
        ((ax.d)localObject).IpL.setVisibility(0);
        int i = this.Ids.status;
        ac.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((ax.d)localObject).IpL.setProgress(u.g(this.Ids));
          AppMethodBeat.o(37457);
          return;
        }
        ((ax.d)localObject).IpL.setProgress(u.h(this.Ids));
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
    super.fX(paramView);
    this.fAz = ((TextView)paramView.findViewById(2131298178));
    this.Ilc = ((ImageView)paramView.findViewById(2131298074));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.vXz = ((TextView)paramView.findViewById(2131298171));
    this.IpK = ((TextView)paramView.findViewById(2131298138));
    this.yoI = ((ImageView)paramView.findViewById(2131298175));
    this.IiO = ((ImageView)paramView.findViewById(2131298078));
    this.IiP = ((ImageView)paramView.findViewById(2131298177));
    this.IpL = ((MMPinProgressBtn)paramView.findViewById(2131298082));
    this.IpM = paramView.findViewById(2131298188);
    this.nDl = paramView.findViewById(2131298069);
    this.qTn = ((TextView)paramView.findViewById(2131298192));
    this.IiG = ((ImageView)paramView.findViewById(2131298191));
    this.AfH = paramView.findViewById(2131298190);
    this.IpN = ((LinearLayout)paramView.findViewById(2131306320));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.ImA = ((ImageView)paramView.findViewById(2131298076));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(2131298176);
      this.Ijf = ((ImageView)localObject1);
      if (paramBoolean) {
        break label327;
      }
    }
    label327:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(2131298189);; localObject1 = null)
    {
      this.IpO = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(2131306222);
      }
      this.IpP = ((View)localObject1);
      AppMethodBeat.o(37462);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.d
 * JD-Core Version:    0.7.0.1
 */