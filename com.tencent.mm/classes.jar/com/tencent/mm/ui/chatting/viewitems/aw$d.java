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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.y;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class aw$d
  extends c.a
{
  private static Map<String, WeakReference<d>> GLj;
  private static SparseArray<String> GPO;
  ImageView GIJ;
  ImageView GIR;
  ImageView GIS;
  ImageView GJi;
  ImageView GLf;
  ImageView GMy;
  TextView GPI;
  MMPinProgressBtn GPJ;
  View GPK;
  LinearLayout GPL;
  ProgressBar GPM;
  View GPN;
  TextView qkL;
  TextView uOJ;
  ImageView xbT;
  View yRS;
  
  static
  {
    AppMethodBeat.i(37464);
    GPO = new SparseArray();
    GLj = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  public static void a(d paramd, bl parambl, final boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37463);
    Object localObject1 = (String)GPO.get(paramd.hashCode());
    if (localObject1 != null) {
      GLj.remove(localObject1);
    }
    GPO.put(paramd.hashCode(), parambl.field_imgPath);
    GLj.put(parambl.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.Ae(parambl.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new s();
    }
    label326:
    label345:
    label474:
    label1372:
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aCI();
      Object localObject3 = t.zR(parambl.field_imgPath);
      localObject1 = null;
      com.tencent.mm.pluginsdk.ui.e locale = null;
      k.b localb;
      Object localObject4;
      int j;
      int i;
      if (parambl.cjN())
      {
        localb = k.b.ar(parambl.field_content, parambl.field_reserved);
        localObject1 = r.aAK(localb.thumburl);
        localObject3 = com.tencent.mm.aw.o.ayF().a((String)localObject1, com.tencent.mm.cd.a.getDensity(parama.GzJ.getContext()), parama.GzJ.getContext(), 2131231564);
        if ((localObject3 != null) || (localb == null) || (parambl == null))
        {
          localObject4 = (com.tencent.mm.ai.e)localb.ao(com.tencent.mm.ai.e.class);
          localObject1 = locale;
          if (localObject4 != null)
          {
            localObject1 = locale;
            if (((com.tencent.mm.ai.e)localObject4).gGE != null)
            {
              localObject1 = ((com.tencent.mm.ai.e)localObject4).gGE;
              ((s)localObject2).gOY = ((y)localObject1).videoDuration;
            }
          }
          paramd.yRS.setVisibility(0);
          ad.a(parama.GzJ.getContext(), localb, paramd.GIJ, paramd.qkL);
          locale = ((com.tencent.mm.ui.chatting.c.b.c)parama.be(com.tencent.mm.ui.chatting.c.b.c.class)).eXd();
          if ((locale == null) || (!locale.BUM)) {
            break label1026;
          }
          paramd.yRS.setBackgroundResource(2131231717);
          paramd.qkL.setTextColor(com.tencent.mm.cd.a.n(parama.GzJ.getContext(), 2131099662));
          paramd.yRS.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(37460);
              this.GPR.yRS.getViewTreeObserver().removeOnPreDrawListener(this);
              if ((this.GPR.yRS.getWidth() > this.GPR.naN.getWidth()) && (!paramBoolean)) {}
              for (int i = 5;; i = 3)
              {
                this.GPR.GPL.setGravity(i);
                AppMethodBeat.o(37460);
                return true;
              }
            }
          });
          paramd.GMy.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          if (localObject3 != null) {
            break label1167;
          }
          j = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 85);
          i = com.tencent.mm.cd.a.ao(parama.GzJ.getContext(), 2131165213);
          if ((!parambl.cjN()) || (localObject1 == null) || (((y)localObject1).width <= 0) || (((y)localObject1).height <= 0)) {
            break label1903;
          }
          if (((y)localObject1).width < ((y)localObject1).height) {
            break label1103;
          }
          j = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), g.hhe);
          i = (int)(((y)localObject1).height / ((y)localObject1).width * j);
        }
      }
      label1256:
      label1903:
      for (;;)
      {
        localObject1 = f.b(f.aG(parama.GzJ.getContext().getResources().getColor(2131100478), j, i), 2131231564, j, i);
        az.arV();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramd.GLf.setImageDrawable(com.tencent.mm.cd.a.l(parama.GzJ.getContext(), 2131691365));
          paramd.GLf.setBackground(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = new FrameLayout.LayoutParams(j, i);
          paramd.GMy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.GPN != null) {
            paramd.GPN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!paramBoolean) {
            break label1372;
          }
          paramd.uOJ.setText(ae.mK(((s)localObject2).gTY));
          paramd.GPI.setText(ae.pL(((s)localObject2).gOY));
          i = ((s)localObject2).status;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i + " info : " + ((s)localObject2).getFileName());
          if (i != 199) {
            break label1223;
          }
          paramd.xbT.setImageDrawable(com.tencent.mm.cd.a.l(parama.GzJ.getContext(), 2131231268));
          if ((i != 112) && (i != 122) && (i != 120)) {
            break label1256;
          }
          paramd.GIR.setVisibility(8);
          paramd.xbT.setVisibility(8);
          paramd.GPJ.setVisibility(0);
          paramd.GPJ.setProgress(u.g((s)localObject2));
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "status begin");
          paramd.GPJ.invalidate();
        }
        for (;;)
        {
          localObject1 = paramd.GIS;
          localObject2 = new aw.e(parambl, parama.eZb(), paramInt, parambl.field_talker);
          ((aw.e)localObject2).nBH = 4;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.GIS.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.GIR;
          localObject2 = new aw.e(parambl, parama.eZb(), paramInt, parambl.field_talker);
          ((aw.e)localObject2).nBH = 3;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.GIR.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.naN;
          parambl = new aw.e(parambl, parama.eZb(), paramInt, parambl.field_talker);
          parambl.nBH = 2;
          ((View)localObject1).setTag(parambl);
          paramd.naN.setOnClickListener(paramOnClickListener);
          paramd.naN.setOnLongClickListener(paramOnLongClickListener);
          paramd.naN.setOnTouchListener(((i)parama.be(i.class)).eWp());
          AppMethodBeat.o(37463);
          return;
          localObject4 = new WeakReference(parama);
          com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.o.ayJ();
          String str = localb.thumburl;
          com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
          locala1.gjt = ((String)localObject1);
          locala1.hjU = true;
          locala.a(str, locala1.azc(), new d()
          {
            public final void en(boolean paramAnonymousVarArgs)
            {
              AppMethodBeat.i(37459);
              if (paramAnonymousVarArgs) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(37458);
                    if ((aw.d.2.this.GPP.get() != null) && (((com.tencent.mm.ui.chatting.d.a)aw.d.2.this.GPP.get()).GzJ.getContext() != null) && (!((com.tencent.mm.ui.chatting.d.a)aw.d.2.this.GPP.get()).GzJ.getContext().isFinishing())) {
                      ((com.tencent.mm.ui.chatting.d.a)aw.d.2.this.GPP.get()).bCM();
                    }
                    AppMethodBeat.o(37458);
                  }
                });
              }
              AppMethodBeat.o(37459);
            }
          });
          break;
          paramd.yRS.setBackgroundResource(2131231716);
          paramd.qkL.setTextColor(com.tencent.mm.cd.a.n(parama.GzJ.getContext(), 2131099660));
          break label326;
          paramd.yRS.setVisibility(8);
          localObject3 = com.tencent.mm.aw.o.ayF().a((String)localObject3, com.tencent.mm.cd.a.getDensity(parama.GzJ.getContext()), parama.GzJ.getContext(), 2131231564);
          break label345;
          j = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), g.hhe);
          i = (int)(((y)localObject1).width / ((y)localObject1).height * j);
          break label474;
          localObject1 = f.b((Bitmap)localObject1, 2131231564, j, i);
          paramd.GLf.setImageBitmap((Bitmap)localObject1);
          break label556;
          paramd.GLf.setImageBitmap((Bitmap)localObject3);
          localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          paramd.GMy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.GPN == null) {
            break label594;
          }
          paramd.GPN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label594;
          paramd.xbT.setImageDrawable(com.tencent.mm.cd.a.l(parama.GzJ.getContext(), 2131231268));
          paramd.uOJ.setVisibility(8);
          break label703;
          if ((i == 113) || (i == 198) || (((s)localObject2).aCU()))
          {
            paramd.GIR.setVisibility(0);
            paramd.GIS.setVisibility(8);
            paramd.GPJ.setVisibility(8);
            paramd.xbT.setVisibility(0);
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "status pause");
          }
          else
          {
            paramd.GIS.setVisibility(8);
            paramd.GIR.setVisibility(8);
            paramd.GPJ.setVisibility(8);
            paramd.xbT.setVisibility(0);
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "status gone");
            continue;
            paramd.uOJ.setText(ae.mK(((s)localObject2).gTY));
            paramd.GPI.setText(ae.pL(((s)localObject2).gOY));
            i = ((s)localObject2).status;
            paramd.xbT.setImageDrawable(com.tencent.mm.cd.a.l(parama.GzJ.getContext(), 2131231268));
            if (paramd.GPM != null) {
              paramd.GPM.setVisibility(8);
            }
            if (paramd.GPN != null) {
              paramd.GPN.setVisibility(8);
            }
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(i) });
            if ((i == 104) || (i == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.GM(((s)localObject2).hAi))
              {
                if (paramd.GPM != null) {
                  paramd.GPM.setVisibility(0);
                }
                if (paramd.GPN != null) {
                  paramd.GPN.setVisibility(0);
                }
                paramd.GPI.setText(null);
                paramd.uOJ.setText(null);
                paramd.xbT.setImageDrawable(null);
                paramd.GIS.setVisibility(8);
                paramd.GIR.setVisibility(8);
                paramd.GPJ.setVisibility(8);
              }
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "status begin");
                break;
                if (paramd.GPM != null) {
                  paramd.GPM.setVisibility(8);
                }
                if (paramd.GPN != null) {
                  paramd.GPN.setVisibility(8);
                }
                paramd.GIR.setVisibility(8);
                paramd.xbT.setVisibility(8);
                paramd.GPJ.setVisibility(0);
                paramd.GPJ.setProgress(u.h((s)localObject2));
              }
            }
            if ((i == 105) || (i == 198) || (((s)localObject2).aCU()))
            {
              paramd.GIR.setVisibility(0);
              paramd.GIS.setVisibility(8);
              paramd.GPJ.setVisibility(8);
              paramd.xbT.setVisibility(0);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "status pause");
            }
            else if (i == 106)
            {
              if (!l.aAH(parambl.field_imgPath))
              {
                u.zV(parambl.field_imgPath);
              }
              else
              {
                if (paramd.GPM != null) {
                  paramd.GPM.setVisibility(0);
                }
                if (paramd.GPN != null) {
                  paramd.GPN.setVisibility(0);
                }
                paramd.GPI.setText(null);
                paramd.uOJ.setText(null);
                paramd.xbT.setImageDrawable(null);
                paramd.GIS.setVisibility(8);
                paramd.GIR.setVisibility(8);
                paramd.GPJ.setVisibility(8);
              }
            }
            else
            {
              paramd.GIS.setVisibility(8);
              paramd.GIR.setVisibility(8);
              paramd.GPJ.setVisibility(8);
              paramd.xbT.setVisibility(0);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.VideoItemHoder", "status gone");
            }
          }
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.hAB != t.a.b.hAF)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    s locals = u.Ae(parama.fileName);
    if (locals == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
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
        Object localObject = (WeakReference)aw.d.GLj.get(this.GDv.getFileName());
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.GDv.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (aw.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.GDv.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((aw.d)localObject).GIR.setVisibility(8);
        ((aw.d)localObject).xbT.setVisibility(8);
        ((aw.d)localObject).GPJ.setVisibility(0);
        int i = this.GDv.status;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((aw.d)localObject).GPJ.setProgress(u.g(this.GDv));
          AppMethodBeat.o(37457);
          return;
        }
        ((aw.d)localObject).GPJ.setProgress(u.h(this.GDv));
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
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.GLf = ((ImageView)paramView.findViewById(2131298074));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.uOJ = ((TextView)paramView.findViewById(2131298171));
    this.GPI = ((TextView)paramView.findViewById(2131298138));
    this.xbT = ((ImageView)paramView.findViewById(2131298175));
    this.GIR = ((ImageView)paramView.findViewById(2131298078));
    this.GIS = ((ImageView)paramView.findViewById(2131298177));
    this.GPJ = ((MMPinProgressBtn)paramView.findViewById(2131298082));
    this.GPK = paramView.findViewById(2131298188);
    this.naN = paramView.findViewById(2131298069);
    this.qkL = ((TextView)paramView.findViewById(2131298192));
    this.GIJ = ((ImageView)paramView.findViewById(2131298191));
    this.yRS = paramView.findViewById(2131298190);
    this.GPL = ((LinearLayout)paramView.findViewById(2131306320));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.GMy = ((ImageView)paramView.findViewById(2131298076));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(2131298176);
      this.GJi = ((ImageView)localObject1);
      if (paramBoolean) {
        break label327;
      }
    }
    label327:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(2131298189);; localObject1 = null)
    {
      this.GPM = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(2131306222);
      }
      this.GPN = ((View)localObject1);
      AppMethodBeat.o(37462);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.d
 * JD-Core Version:    0.7.0.1
 */