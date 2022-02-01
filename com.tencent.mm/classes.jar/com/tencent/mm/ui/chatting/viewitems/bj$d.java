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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.a.c.d;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.x.a.b;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.model.o;
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

public final class bj$d
  extends c.a
{
  private static Map<String, WeakReference<d>> XfM;
  private static SparseArray<String> XlB;
  TextView HpD;
  ImageView JAL;
  View Nck;
  ImageView XdI;
  ImageView Xdj;
  ImageView Xdr;
  ImageView Xds;
  ImageView XfI;
  ImageView XhK;
  View XlA;
  TextView Xlv;
  MMPinProgressBtn Xlw;
  View Xlx;
  LinearLayout Xly;
  ProgressBar Xlz;
  TextView wRL;
  
  static
  {
    AppMethodBeat.i(37464);
    XlB = new SparseArray();
    XfM = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  public static void a(d paramd, ca paramca, final boolean paramBoolean, int paramInt1, com.tencent.mm.ui.chatting.e.a parama, int paramInt2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(270293);
    Object localObject1 = (String)XlB.get(paramd.hashCode());
    if (localObject1 != null) {
      XfM.remove(localObject1);
    }
    XlB.put(paramd.hashCode(), paramca.field_imgPath);
    XfM.put(paramca.field_imgPath, new WeakReference(paramd));
    Object localObject2 = com.tencent.mm.modelvideo.y.Yk(paramca.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new com.tencent.mm.modelvideo.w();
    }
    label1041:
    label1193:
    label1462:
    for (;;)
    {
      s.bqB();
      Object localObject4 = x.XU(paramca.field_imgPath);
      localObject1 = null;
      Object localObject3 = null;
      k.b localb;
      float f1;
      Object localObject5;
      label337:
      label360:
      int j;
      int i;
      if (paramca.dlS())
      {
        localb = k.b.aG(paramca.field_content, paramca.field_reserved);
        localObject1 = com.tencent.mm.pluginsdk.model.w.bpO(localb.thumburl);
        localObject4 = q.bmh();
        f1 = com.tencent.mm.ci.a.getDensity(parama.WQv.getContext());
        parama.WQv.getContext();
        localObject4 = ((i)localObject4).a((String)localObject1, f1, paramInt2);
        if ((localObject4 != null) || (localb == null) || (paramca == null))
        {
          localObject5 = (e)localb.ar(e.class);
          localObject1 = localObject3;
          if (localObject5 != null)
          {
            localObject1 = localObject3;
            if (((e)localObject5).llv != null)
            {
              localObject1 = ((e)localObject5).llv;
              ((com.tencent.mm.modelvideo.w)localObject2).lvw = ((com.tencent.mm.aj.y)localObject1).videoDuration;
            }
          }
          paramd.Nck.setVisibility(0);
          ao.a(parama.WQv.getContext(), localb, paramd.Xdj, paramd.wRL);
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.c)parama.bC(com.tencent.mm.ui.chatting.d.b.c.class)).hOH();
          if ((localObject3 == null) || (!((f)localObject3).RbZ)) {
            break label1041;
          }
          paramd.Nck.setBackgroundResource(R.g.dnj);
          paramd.wRL.setTextColor(com.tencent.mm.ci.a.w(parama.WQv.getContext(), R.e.BW_0_Alpha_0_5));
          paramd.Nck.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(37460);
              this.XlE.Nck.getViewTreeObserver().removeOnPreDrawListener(this);
              if ((this.XlE.Nck.getWidth() > this.XlE.clickArea.getWidth()) && (!paramBoolean)) {}
              for (int i = 5;; i = 3)
              {
                this.XlE.Xly.setGravity(i);
                AppMethodBeat.o(37460);
                return true;
              }
            }
          });
          localObject3 = localObject4;
          paramd.XhK.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          if (localObject3 != null) {
            break label1257;
          }
          j = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 85);
          i = com.tencent.mm.ci.a.aY(parama.WQv.getContext(), R.f.ChatImgLimitWidth);
          if ((!paramca.dlS()) || (localObject1 == null) || (((com.tencent.mm.aj.y)localObject1).width <= 0) || (((com.tencent.mm.aj.y)localObject1).height <= 0)) {
            break label1993;
          }
          if (((com.tencent.mm.aj.y)localObject1).width < ((com.tencent.mm.aj.y)localObject1).height) {
            break label1193;
          }
          j = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), i.lOA);
          i = (int)(((com.tencent.mm.aj.y)localObject1).height / ((com.tencent.mm.aj.y)localObject1).width * j);
        }
      }
      label571:
      label1346:
      label1993:
      for (;;)
      {
        label489:
        localObject1 = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(parama.WQv.getContext().getResources().getColor(R.e.grey_color_01), j, i), paramInt2, j, i);
        bh.beI();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramd.XfI.setImageDrawable(com.tencent.mm.ci.a.m(parama.WQv.getContext(), R.k.video_no_sd_icon));
          paramd.XfI.setBackground(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = new FrameLayout.LayoutParams(j, i);
          paramd.XhK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.XlA != null) {
            paramd.XlA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          label609:
          if (!paramBoolean) {
            break label1462;
          }
          paramd.HpD.setText(ae.getSizeKB(((com.tencent.mm.modelvideo.w)localObject2).lAW));
          paramd.Xlv.setText(ae.formatSecToMin(((com.tencent.mm.modelvideo.w)localObject2).lvw));
          paramInt2 = ((com.tencent.mm.modelvideo.w)localObject2).status;
          Log.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + paramInt2 + " info : " + ((com.tencent.mm.modelvideo.w)localObject2).getFileName());
          if (paramInt2 != 199) {
            break label1313;
          }
          paramd.JAL.setImageDrawable(com.tencent.mm.ci.a.m(parama.WQv.getContext(), R.k.shortvideo_play_btn));
          label718:
          if ((paramInt2 != 112) && (paramInt2 != 122) && (paramInt2 != 120)) {
            break label1346;
          }
          paramd.Xdr.setVisibility(8);
          paramd.JAL.setVisibility(8);
          paramd.Xlw.setVisibility(0);
          paramd.Xlw.setProgress(com.tencent.mm.modelvideo.y.g((com.tencent.mm.modelvideo.w)localObject2));
          Log.v("MicroMsg.VideoItemHoder", "status begin");
          paramd.Xlw.invalidate();
        }
        for (;;)
        {
          localObject1 = paramd.Xds;
          localObject2 = new bj.e(paramca, parama.hRi(), paramInt1, paramca.field_talker);
          ((bj.e)localObject2).viewType = 4;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.Xds.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.Xdr;
          localObject2 = new bj.e(paramca, parama.hRi(), paramInt1, paramca.field_talker);
          ((bj.e)localObject2).viewType = 3;
          ((ImageView)localObject1).setTag(localObject2);
          paramd.Xdr.setOnClickListener(paramOnClickListener);
          localObject1 = paramd.clickArea;
          paramca = new bj.e(paramca, parama.hRi(), paramInt1, paramca.field_talker);
          paramca.viewType = 2;
          ((View)localObject1).setTag(paramca);
          paramd.clickArea.setOnClickListener(paramOnClickListener);
          paramd.clickArea.setOnLongClickListener(paramOnLongClickListener);
          paramd.clickArea.setOnTouchListener(((k)parama.bC(k.class)).hNO());
          AppMethodBeat.o(270293);
          return;
          localObject5 = new WeakReference(parama);
          com.tencent.mm.ay.a.a locala = q.bml();
          String str = localb.thumburl;
          com.tencent.mm.ay.a.a.c.a locala1 = new com.tencent.mm.ay.a.a.c.a();
          locala1.fullPath = ((String)localObject1);
          locala1.lRD = true;
          locala.a(str, locala1.bmL(), new d()
          {
            public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
            {
              AppMethodBeat.i(279657);
              if (paramAnonymousBoolean) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(37458);
                    if ((bj.d.2.this.XlC.get() != null) && (((com.tencent.mm.ui.chatting.e.a)bj.d.2.this.XlC.get()).WQv.getContext() != null) && (!((com.tencent.mm.ui.chatting.e.a)bj.d.2.this.XlC.get()).WQv.getContext().isFinishing())) {
                      ((com.tencent.mm.ui.chatting.e.a)bj.d.2.this.XlC.get()).cAe();
                    }
                    AppMethodBeat.o(37458);
                  }
                });
              }
              AppMethodBeat.o(279657);
            }
          });
          break;
          paramd.Nck.setBackgroundResource(R.g.dni);
          paramd.wRL.setTextColor(com.tencent.mm.ci.a.w(parama.WQv.getContext(), R.e.BW_0_Alpha_0_3));
          break label337;
          paramd.Nck.setVisibility(8);
          f1 = bs.I(paramca);
          if (f1 != 1.0F)
          {
            localObject3 = new ll();
            ((ll)localObject3).ghT = paramca.field_msgSvrId;
            ((ll)localObject3).gKR = paramca.getType();
            ((ll)localObject3).gQQ = bs.E(paramca);
            ((ll)localObject3).gef = 1L;
            ((ll)localObject3).bpa();
          }
          localObject3 = q.bmh();
          float f2 = com.tencent.mm.ci.a.getDensity(parama.WQv.getContext());
          parama.WQv.getContext();
          localObject3 = ((i)localObject3).a((String)localObject4, f1 * f2, paramInt2);
          break label360;
          j = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), i.lOA);
          i = (int)(((com.tencent.mm.aj.y)localObject1).width / ((com.tencent.mm.aj.y)localObject1).height * j);
          break label489;
          localObject1 = BitmapUtil.createMaskImage((Bitmap)localObject1, paramInt2, j, i);
          paramd.XfI.setImageBitmap((Bitmap)localObject1);
          break label571;
          label1257:
          paramd.XfI.setImageBitmap((Bitmap)localObject3);
          localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          paramd.XhK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (paramd.XlA == null) {
            break label609;
          }
          paramd.XlA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label609;
          paramd.JAL.setImageDrawable(com.tencent.mm.ci.a.m(parama.WQv.getContext(), R.k.shortvideo_play_btn));
          paramd.HpD.setVisibility(8);
          break label718;
          if ((paramInt2 == 113) || (paramInt2 == 198) || (((com.tencent.mm.modelvideo.w)localObject2).bqQ()))
          {
            paramd.Xdr.setVisibility(0);
            paramd.Xds.setVisibility(8);
            paramd.Xlw.setVisibility(8);
            paramd.JAL.setVisibility(0);
            Log.v("MicroMsg.VideoItemHoder", "status pause");
          }
          else
          {
            paramd.Xds.setVisibility(8);
            paramd.Xdr.setVisibility(8);
            paramd.Xlw.setVisibility(8);
            paramd.JAL.setVisibility(0);
            Log.v("MicroMsg.VideoItemHoder", "status gone");
            continue;
            paramd.HpD.setText(ae.getSizeKB(((com.tencent.mm.modelvideo.w)localObject2).lAW));
            paramd.Xlv.setText(ae.formatSecToMin(((com.tencent.mm.modelvideo.w)localObject2).lvw));
            paramInt2 = ((com.tencent.mm.modelvideo.w)localObject2).status;
            paramd.JAL.setImageDrawable(com.tencent.mm.ci.a.m(parama.WQv.getContext(), R.k.shortvideo_play_btn));
            if (paramd.Xlz != null) {
              paramd.Xlz.setVisibility(8);
            }
            if (paramd.XlA != null) {
              paramd.XlA.setVisibility(8);
            }
            Log.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(paramInt2) });
            if ((paramInt2 == 104) || (paramInt2 == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.WU(((com.tencent.mm.modelvideo.w)localObject2).mhR))
              {
                if (paramd.Xlz != null) {
                  paramd.Xlz.setVisibility(0);
                }
                if (paramd.XlA != null) {
                  paramd.XlA.setVisibility(0);
                }
                paramd.Xlv.setText(null);
                paramd.HpD.setText(null);
                paramd.JAL.setImageDrawable(null);
                paramd.Xds.setVisibility(8);
                paramd.Xdr.setVisibility(8);
                paramd.Xlw.setVisibility(8);
              }
              for (;;)
              {
                Log.v("MicroMsg.VideoItemHoder", "status begin");
                break;
                if (paramd.Xlz != null) {
                  paramd.Xlz.setVisibility(8);
                }
                if (paramd.XlA != null) {
                  paramd.XlA.setVisibility(8);
                }
                paramd.Xdr.setVisibility(8);
                paramd.JAL.setVisibility(8);
                paramd.Xlw.setVisibility(0);
                paramd.Xlw.setProgress(com.tencent.mm.modelvideo.y.h((com.tencent.mm.modelvideo.w)localObject2));
              }
            }
            if ((paramInt2 == 105) || (paramInt2 == 198) || (((com.tencent.mm.modelvideo.w)localObject2).bqQ()))
            {
              paramd.Xdr.setVisibility(0);
              paramd.Xds.setVisibility(8);
              paramd.Xlw.setVisibility(8);
              paramd.JAL.setVisibility(0);
              Log.v("MicroMsg.VideoItemHoder", "status pause");
            }
            else if (paramInt2 == 106)
            {
              if (!o.bpH(paramca.field_imgPath))
              {
                com.tencent.mm.modelvideo.y.Yb(paramca.field_imgPath);
              }
              else
              {
                if (paramd.Xlz != null) {
                  paramd.Xlz.setVisibility(0);
                }
                if (paramd.XlA != null) {
                  paramd.XlA.setVisibility(0);
                }
                paramd.Xlv.setText(null);
                paramd.HpD.setText(null);
                paramd.JAL.setImageDrawable(null);
                paramd.Xds.setVisibility(8);
                paramd.Xdr.setVisibility(8);
                paramd.Xlw.setVisibility(8);
              }
            }
            else
            {
              paramd.Xds.setVisibility(8);
              paramd.Xdr.setVisibility(8);
              paramd.Xlw.setVisibility(8);
              paramd.JAL.setVisibility(0);
              Log.v("MicroMsg.VideoItemHoder", "status gone");
            }
          }
        }
      }
    }
  }
  
  public static boolean b(x.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.mik != x.a.b.mip)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    com.tencent.mm.modelvideo.w localw = com.tencent.mm.modelvideo.y.Yk(parama.fileName);
    if (localw == null)
    {
      Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(37461);
      return false;
    }
    if ((localw.status != 112) && (localw.status != 104) && (localw.status != 103))
    {
      AppMethodBeat.o(37461);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37457);
        Object localObject = (WeakReference)bj.d.avo().get(this.mgz.getFileName());
        if (localObject == null)
        {
          Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { this.mgz.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (bj.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { this.mgz.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((bj.d)localObject).Xdr.setVisibility(8);
        ((bj.d)localObject).JAL.setVisibility(8);
        ((bj.d)localObject).Xlw.setVisibility(0);
        int i = this.mgz.status;
        Log.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120))
        {
          ((bj.d)localObject).Xlw.setProgress(com.tencent.mm.modelvideo.y.g(this.mgz));
          AppMethodBeat.o(37457);
          return;
        }
        ((bj.d)localObject).Xlw.setProgress(com.tencent.mm.modelvideo.y.h(this.mgz));
        AppMethodBeat.o(37457);
      }
    });
    AppMethodBeat.o(37461);
    return true;
  }
  
  public final c.a J(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(37462);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.XfI = ((ImageView)paramView.findViewById(R.h.dxe));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.HpD = ((TextView)paramView.findViewById(R.h.dzj));
    this.Xlv = ((TextView)paramView.findViewById(R.h.dyu));
    this.JAL = ((ImageView)paramView.findViewById(R.h.dzq));
    this.Xdr = ((ImageView)paramView.findViewById(R.h.dxi));
    this.Xds = ((ImageView)paramView.findViewById(R.h.dzr));
    this.Xlw = ((MMPinProgressBtn)paramView.findViewById(R.h.dxm));
    this.Xlx = paramView.findViewById(R.h.dzz);
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.wRL = ((TextView)paramView.findViewById(R.h.dzD));
    this.Xdj = ((ImageView)paramView.findViewById(R.h.dzC));
    this.Nck = paramView.findViewById(R.h.dzB);
    this.Xly = ((LinearLayout)paramView.findViewById(R.h.dYG));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.XhK = ((ImageView)paramView.findViewById(R.h.dxg));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(R.h.chatting_status_tick);
      this.XdI = ((ImageView)localObject1);
      if (paramBoolean) {
        break label327;
      }
    }
    label327:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(R.h.dzA);; localObject1 = null)
    {
      this.Xlz = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(R.h.dYB);
      }
      this.XlA = ((View)localObject1);
      AppMethodBeat.o(37462);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.d
 * JD-Core Version:    0.7.0.1
 */