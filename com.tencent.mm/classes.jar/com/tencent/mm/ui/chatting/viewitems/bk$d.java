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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.message.e;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.aa.a.b;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class bk$d
  extends c.a
{
  private static Map<String, WeakReference<d>> aePO;
  private static SparseArray<String> aeWy;
  TextView Aoo;
  TextView Nnr;
  ImageView PQu;
  View TOU;
  ImageView aeNG;
  ImageView aeNh;
  ImageView aeNp;
  ImageView aeNq;
  ImageView aePK;
  ImageView aeRQ;
  TextView aeWl;
  MMPinProgressBtn aeWm;
  View aeWn;
  LinearLayout aeWo;
  ProgressBar aeWp;
  View aeWq;
  ProgressBar aeWr;
  RoundProgressBtn aeWs;
  TextView aeWt;
  WeImageView aeWu;
  View aeWv;
  RoundProgressBtn aeWw;
  View aeWx;
  
  static
  {
    AppMethodBeat.i(37464);
    aeWy = new SparseArray();
    aePO = new HashMap();
    AppMethodBeat.o(37464);
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(255412);
    f localf = ((com.tencent.mm.ui.chatting.component.api.d)parama.cm(com.tencent.mm.ui.chatting.component.api.d.class)).jrx();
    if ((localf != null) && (localf.XYe))
    {
      paramd.TOU.setBackgroundResource(R.g.fnv);
      paramd.Aoo.setTextColor(com.tencent.mm.cd.a.w(parama.aezO.getContext(), R.e.BW_0_Alpha_0_5));
    }
    for (;;)
    {
      paramd.TOU.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(37460);
          bk.d.this.TOU.getViewTreeObserver().removeOnPreDrawListener(this);
          if ((bk.d.this.TOU.getWidth() > bk.d.this.clickArea.getWidth()) && (!paramBoolean)) {}
          for (int i = 5;; i = 3)
          {
            bk.d.this.aeWo.setGravity(i);
            AppMethodBeat.o(37460);
            return true;
          }
        }
      });
      AppMethodBeat.o(255412);
      return;
      paramd.TOU.setBackgroundResource(R.g.fnu);
      paramd.Aoo.setTextColor(com.tencent.mm.cd.a.w(parama.aezO.getContext(), R.e.BW_0_Alpha_0_3));
    }
  }
  
  private static void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(255407);
    if (paramd.aeWv != null) {
      paramd.aeWv.setVisibility(paramInt);
    }
    if (paramd.aeWt != null) {
      paramd.aeWt.setVisibility(paramInt);
    }
    if (paramd.aeWu != null) {
      paramd.aeWu.setVisibility(paramInt);
    }
    if (paramd.aeWs != null) {
      paramd.aeWs.setVisibility(paramInt);
    }
    AppMethodBeat.o(255407);
  }
  
  public static void a(d paramd, cc paramcc, boolean paramBoolean, int paramInt1, com.tencent.mm.ui.chatting.d.a parama, int paramInt2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(255403);
    Object localObject1 = (String)aeWy.get(paramd.hashCode());
    if (localObject1 != null) {
      aePO.remove(localObject1);
    }
    aeWy.put(paramd.hashCode(), paramcc.field_imgPath);
    aePO.put(paramcc.field_imgPath, new WeakReference(paramd));
    Object localObject2 = ab.Qo(paramcc.field_imgPath);
    if (localObject2 == null) {
      localObject2 = new z();
    }
    for (;;)
    {
      Log.i("MicroMsg.VideoItemHoder", "alvinluo fillingVideo %s", new Object[] { ((z)localObject2).bOu() });
      v.bOh();
      Object localObject5 = aa.PY(paramcc.field_imgPath);
      Object localObject3 = null;
      Object localObject4;
      float f1;
      if (paramcc.dSI())
      {
        localObject4 = k.b.aP(paramcc.field_content, paramcc.field_reserved);
        localObject1 = com.tencent.mm.pluginsdk.model.y.bpF(((k.b)localObject4).thumburl);
        localObject3 = r.bKa();
        f1 = com.tencent.mm.cd.a.getDensity(parama.aezO.getContext());
        parama.aezO.getContext();
        localObject3 = ((j)localObject3).a((String)localObject1, f1, paramInt2);
        if ((localObject3 != null) || (localObject4 == null) || (paramcc == null))
        {
          localObject1 = (e)((k.b)localObject4).aK(e.class);
          if ((localObject1 == null) || (((e)localObject1).nQs == null)) {
            break label2829;
          }
          localObject1 = ((e)localObject1).nQs;
          ((z)localObject2).omT = ((com.tencent.mm.message.y)localObject1).videoDuration;
        }
      }
      for (;;)
      {
        paramd.TOU.setVisibility(0);
        an.a(parama.aezO.getContext(), (k.b)localObject4, paramd.aeNh, paramd.Aoo);
        a(parama, paramd, paramBoolean);
        paramd.aeRQ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        int j;
        int i;
        if (localObject3 == null)
        {
          j = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 85);
          i = com.tencent.mm.cd.a.br(parama.aezO.getContext(), R.f.ChatImgLimitWidth);
          if ((!paramcc.dSI()) || (localObject1 == null) || (((com.tencent.mm.message.y)localObject1).width <= 0) || (((com.tencent.mm.message.y)localObject1).height <= 0)) {
            break label2826;
          }
          if (((com.tencent.mm.message.y)localObject1).width >= ((com.tencent.mm.message.y)localObject1).height)
          {
            j = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), j.oHk);
            i = (int)(((com.tencent.mm.message.y)localObject1).height / ((com.tencent.mm.message.y)localObject1).width * j);
          }
        }
        label2816:
        label2821:
        label2826:
        for (;;)
        {
          label423:
          localObject1 = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(parama.aezO.getContext().getResources().getColor(R.e.grey_color_01), j, i), paramInt2, j, i);
          bh.bCz();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            paramd.aePK.setImageDrawable(com.tencent.mm.cd.a.m(parama.aezO.getContext(), R.k.video_no_sd_icon));
            paramd.aePK.setBackground(new BitmapDrawable((Bitmap)localObject1));
            label505:
            localObject1 = new FrameLayout.LayoutParams(j, i);
            paramd.aeRQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            if (paramd.aeWq != null) {
              paramd.aeWq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            label543:
            j = 6;
            if ((cn.bDu() - paramcc.getCreateTime() <= 432000000L) || (paramcc.field_status != 5)) {
              break label1780;
            }
            i = 1;
            label573:
            if (!paramBoolean) {
              break label1960;
            }
            paramd.Nnr.setText(Util.getSizeKB(((z)localObject2).osy));
            paramd.aeWl.setText(Util.formatSecToMin(((z)localObject2).omT));
            paramInt2 = ((z)localObject2).status;
            Log.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + paramInt2 + " info : " + ((z)localObject2).getFileName());
            if (paramInt2 != 199) {
              break label1786;
            }
            paramd.PQu.setImageDrawable(com.tencent.mm.cd.a.m(parama.aezO.getContext(), R.k.shortvideo_play_btn));
            label682:
            if ((paramInt2 != 112) && (paramInt2 != 122) && (paramInt2 != 120)) {
              break label1819;
            }
            paramd.aeNp.setVisibility(8);
            paramd.PQu.setVisibility(8);
            paramd.aeWm.setVisibility(0);
            paramd.aeWm.setProgress(ab.g((z)localObject2));
            Log.v("MicroMsg.VideoItemHoder", "status begin");
            paramd.aeWm.invalidate();
            label757:
            localObject1 = ae.pbN;
            localObject1 = ae.a.Qv(paramcc.field_reserved);
            if ((localObject1 == null) || (!((ae)localObject1).pbO)) {
              break label1941;
            }
            paramd.aeNq.setVisibility(8);
            paramd.aeNp.setVisibility(8);
            paramd.aeWm.setVisibility(8);
            localObject2 = paramd.PQu;
            if (!((ae)localObject1).pbU) {
              break label1935;
            }
            paramInt2 = 8;
            label829:
            ((ImageView)localObject2).setVisibility(paramInt2);
            if ((paramd.aeWr != null) && (((ae)localObject1).pbU)) {
              paramd.aeWr.setVisibility(0);
            }
            label859:
            localObject1 = com.tencent.mm.ui.chatting.gallery.d.aeAp;
            paramInt2 = j;
            if (com.tencent.mm.ui.chatting.gallery.d.Ai(paramcc.field_msgId) == null)
            {
              if (paramd.aeWw != null) {
                paramd.aeWw.setVisibility(8);
              }
              paramInt2 = j;
              if (paramd.aeWx != null)
              {
                paramd.aeWx.setVisibility(8);
                paramInt2 = j;
              }
            }
            label918:
            if ((ab.bOG()) && (paramd.aeWv != null))
            {
              localObject1 = paramd.aeWv;
              localObject2 = new bk.e(paramcc, parama.juG(), paramInt1, paramcc.field_talker);
              ((bk.e)localObject2).viewType = paramInt2;
              ((View)localObject1).setTag(localObject2);
              localObject2 = paramd.aeWv;
              if (i == 0) {
                break label2809;
              }
              localObject1 = null;
              label985:
              ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
              localObject1 = paramd.aeWv;
              if (i != 0) {
                break label2816;
              }
              paramBoolean = true;
              label1005:
              ((View)localObject1).setClickable(paramBoolean);
              localObject1 = paramd.aeWv;
              if (i != 0) {
                break label2821;
              }
            }
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            ((View)localObject1).setFocusable(paramBoolean);
            localObject1 = paramd.aeNq;
            localObject2 = new bk.e(paramcc, parama.juG(), paramInt1, paramcc.field_talker);
            ((bk.e)localObject2).viewType = 4;
            ((ImageView)localObject1).setTag(localObject2);
            paramd.aeNq.setOnClickListener(paramOnClickListener);
            localObject1 = paramd.aeNp;
            localObject2 = new bk.e(paramcc, parama.juG(), paramInt1, paramcc.field_talker);
            ((bk.e)localObject2).viewType = 3;
            ((ImageView)localObject1).setTag(localObject2);
            paramd.aeNp.setOnClickListener(paramOnClickListener);
            localObject1 = paramd.clickArea;
            paramcc = new bk.e(paramcc, parama.juG(), paramInt1, paramcc.field_talker);
            paramcc.viewType = 2;
            ((View)localObject1).setTag(paramcc);
            paramd.clickArea.setOnClickListener(paramOnClickListener);
            paramd.clickArea.setOnLongClickListener(paramOnLongClickListener);
            paramd.clickArea.setOnTouchListener(((m)parama.cm(m.class)).jqv());
            AppMethodBeat.o(255403);
            return;
            localObject5 = new WeakReference(parama);
            Object localObject6 = r.bKe();
            String str = ((k.b)localObject4).thumburl;
            com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
            locala.fullPath = ((String)localObject1);
            locala.oKp = true;
            ((com.tencent.mm.modelimage.loader.a)localObject6).a(str, locala.bKx(), new com.tencent.mm.modelimage.loader.b.d()
            {
              public final void onImageDownload(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(255025);
                if (paramAnonymousBoolean) {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(37458);
                      if ((bk.d.this.get() != null) && (((com.tencent.mm.ui.chatting.d.a)bk.d.this.get()).aezO.getContext() != null) && (!((com.tencent.mm.ui.chatting.d.a)bk.d.this.get()).aezO.getContext().isFinishing())) {
                        ((com.tencent.mm.ui.chatting.d.a)bk.d.this.get()).dcZ();
                      }
                      AppMethodBeat.o(37458);
                    }
                  });
                }
                AppMethodBeat.o(255025);
              }
            });
            break;
            paramd.TOU.setVisibility(8);
            if ((!Util.isNullOrNil(((z)localObject2).bOu())) || (!Util.isNullOrNil(((z)localObject2).pbo)))
            {
              localObject4 = ((z)localObject2).bOu();
              localObject1 = localObject4;
              if (Util.isNullOrNil((String)localObject4)) {
                localObject1 = com.tencent.mm.modelimage.a.NL(((z)localObject2).pbo);
              }
              if (Util.isNullOrNil((String)localObject1)) {
                break label1648;
              }
              localObject4 = k.b.M(38, (String)localObject1);
              if ((localObject4 == null) || (Util.isNullOrNil(((k.b)localObject4).appId))) {
                break label1648;
              }
              localObject6 = com.tencent.mm.pluginsdk.model.app.h.is(((k.b)localObject4).appId, ((k.b)localObject4).appVersion);
              if (localObject6 != null) {
                c.b(parama, (k.b)localObject4, paramcc);
              }
              if ((localObject6 != null) && (((g)localObject6).field_appName != null) && (((g)localObject6).field_appName.trim().length() > 0)) {
                break label1638;
              }
              localObject1 = ((k.b)localObject4).appName;
              label1433:
              if (c.iA((String)localObject1))
              {
                paramd.TOU.setVisibility(0);
                localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(parama.aezO.getContext(), (g)localObject6, (String)localObject1);
                paramd.Aoo.setText((CharSequence)localObject1);
                paramd.Aoo.setCompoundDrawables(null, null, null, null);
                c.a(parama, paramd.Aoo, ((k.b)localObject4).appId);
                c.a(parama, paramd.aeNh, ((k.b)localObject4).appId);
                a(parama, paramd, paramBoolean);
              }
            }
            for (;;)
            {
              f1 = bt.K(paramcc);
              if (f1 != 1.0F)
              {
                localObject1 = new ol();
                ((ol)localObject1).inO = paramcc.field_msgSvrId;
                ((ol)localObject1).iUM = paramcc.getType();
                ((ol)localObject1).jjm = bt.G(paramcc);
                ((ol)localObject1).ikE = 1L;
                ((ol)localObject1).bMH();
              }
              localObject1 = r.bKa();
              float f2 = com.tencent.mm.cd.a.getDensity(parama.aezO.getContext());
              parama.aezO.getContext();
              localObject4 = ((j)localObject1).a((String)localObject5, f1 * f2, paramInt2);
              localObject1 = localObject3;
              localObject3 = localObject4;
              break;
              label1638:
              localObject1 = ((g)localObject6).field_appName;
              break label1433;
              label1648:
              paramd.TOU.setVisibility(8);
            }
            j = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), j.oHk);
            i = (int)(((com.tencent.mm.message.y)localObject1).width / ((com.tencent.mm.message.y)localObject1).height * j);
            break label423;
            localObject1 = BitmapUtil.createMaskImage((Bitmap)localObject1, paramInt2, j, i);
            paramd.aePK.setImageBitmap((Bitmap)localObject1);
            break label505;
            paramd.aePK.setImageBitmap((Bitmap)localObject3);
            localObject1 = new FrameLayout.LayoutParams(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            paramd.aeRQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            if (paramd.aeWq == null) {
              break label543;
            }
            paramd.aeWq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            break label543;
            label1780:
            i = 0;
            break label573;
            label1786:
            paramd.PQu.setImageDrawable(com.tencent.mm.cd.a.m(parama.aezO.getContext(), R.k.shortvideo_play_btn));
            paramd.Nnr.setVisibility(8);
            break label682;
            label1819:
            if ((paramInt2 == 113) || (paramInt2 == 198) || (((z)localObject2).bOv()))
            {
              paramd.aeNp.setVisibility(0);
              paramd.aeNq.setVisibility(8);
              paramd.aeWm.setVisibility(8);
              paramd.PQu.setVisibility(0);
              Log.v("MicroMsg.VideoItemHoder", "status pause");
              break label757;
            }
            paramd.aeNq.setVisibility(8);
            paramd.aeNp.setVisibility(8);
            paramd.aeWm.setVisibility(8);
            paramd.PQu.setVisibility(0);
            Log.v("MicroMsg.VideoItemHoder", "status gone");
            break label757;
            label1935:
            paramInt2 = 0;
            break label829;
            label1941:
            if (paramd.aeWr == null) {
              break label859;
            }
            paramd.aeWr.setVisibility(8);
            break label859;
            label1960:
            paramd.Nnr.setText(Util.getSizeKB(((z)localObject2).osy));
            paramd.aeWl.setText(Util.formatSecToMin(((z)localObject2).omT));
            int k = ((z)localObject2).status;
            paramd.PQu.setImageDrawable(com.tencent.mm.cd.a.m(parama.aezO.getContext(), R.k.shortvideo_play_btn));
            if (paramd.aeWp != null) {
              paramd.aeWp.setVisibility(8);
            }
            if (paramd.aeWq != null) {
              paramd.aeWq.setVisibility(8);
            }
            Log.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(k) });
            if ((k == 104) || (k == 103))
            {
              if (com.tencent.mm.plugin.mmsight.c.aaW(((z)localObject2).pbc))
              {
                if (paramd.aeWp != null) {
                  paramd.aeWp.setVisibility(0);
                }
                if (paramd.aeWq != null) {
                  paramd.aeWq.setVisibility(0);
                }
                paramd.aeWl.setText(null);
                paramd.Nnr.setText(null);
                paramd.PQu.setImageDrawable(null);
                paramd.aeNq.setVisibility(8);
                paramd.aeNp.setVisibility(8);
                paramd.aeWm.setVisibility(8);
                a(paramd, 8);
              }
              for (;;)
              {
                Log.v("MicroMsg.VideoItemHoder", "status begin");
                paramInt2 = 6;
                break;
                if (paramd.aeWp != null) {
                  paramd.aeWp.setVisibility(8);
                }
                if (paramd.aeWq != null) {
                  paramd.aeWq.setVisibility(8);
                }
                paramd.aeNp.setVisibility(8);
                paramd.PQu.setVisibility(8);
                if (ab.bOG())
                {
                  paramd.aeWm.setVisibility(8);
                  a(paramd, 0);
                  if (paramd.aeWt != null) {
                    paramd.aeWt.setVisibility(8);
                  }
                  if (paramd.aeWu != null) {
                    paramd.aeWu.setImageResource(R.k.icons_filled_pause);
                  }
                  if (paramd.aeWs != null) {
                    paramd.aeWs.setHasPause(true);
                  }
                  if (paramd.aeWs != null) {
                    com.tencent.threadpool.h.ahAA.bm(new bk.d..ExternalSyntheticLambda1((z)localObject2, paramd));
                  }
                }
                else
                {
                  a(paramd, 8);
                  paramd.aeWm.setVisibility(0);
                  paramd.aeWm.setProgress(ab.i((z)localObject2));
                }
              }
            }
            if ((k == 105) || (paramcc.field_status == 5) || (k == 198) || (((z)localObject2).bOv()))
            {
              paramd.aeNq.setVisibility(8);
              paramd.aeWm.setVisibility(8);
              if (ab.bOG())
              {
                paramd.aeNp.setVisibility(8);
                paramd.PQu.setVisibility(8);
                j = 5;
                if (i != 0)
                {
                  a(paramd, 8);
                  paramd.PQu.setVisibility(0);
                  paramd.PQu.setImageResource(R.k.shortvideo_play_icon_err);
                  paramInt2 = j;
                }
              }
              for (;;)
              {
                Log.v("MicroMsg.VideoItemHoder", "status pause");
                break;
                a(paramd, 0);
                if (paramd.aeWu != null)
                {
                  paramd.aeWu.setImageResource(R.k.app_attach_file_arrow_up);
                  com.tencent.threadpool.h.ahAA.bm(new bk.d..ExternalSyntheticLambda0((z)localObject2, paramd));
                }
                if (paramd.aeWs != null) {
                  paramd.aeWs.setHasPause(false);
                }
                paramInt2 = j;
                if (k == 105)
                {
                  paramInt2 = j;
                  if (paramd.aeWt != null)
                  {
                    paramd.aeWt.setVisibility(8);
                    paramInt2 = j;
                    continue;
                    a(paramd, 8);
                    paramd.aeNp.setVisibility(0);
                    paramd.PQu.setVisibility(0);
                    paramInt2 = j;
                  }
                }
              }
            }
            if (k == 106)
            {
              if (!q.bpy(paramcc.field_imgPath))
              {
                ab.Qf(paramcc.field_imgPath);
                paramInt2 = j;
                break label918;
              }
              if (paramd.aeWp != null) {
                paramd.aeWp.setVisibility(0);
              }
              if (paramd.aeWq != null) {
                paramd.aeWq.setVisibility(0);
              }
              if (!ab.bOG()) {
                paramd.aeWl.setText(null);
              }
              paramd.Nnr.setText(null);
              paramd.PQu.setImageDrawable(null);
              paramd.aeNq.setVisibility(8);
              paramd.aeNp.setVisibility(8);
              paramd.aeWm.setVisibility(8);
              a(paramd, 8);
              paramInt2 = j;
              break label918;
            }
            a(paramd, 8);
            paramd.aeNq.setVisibility(8);
            paramd.aeNp.setVisibility(8);
            paramd.aeWm.setVisibility(8);
            paramd.PQu.setVisibility(0);
            Log.v("MicroMsg.VideoItemHoder", "status gone");
            paramInt2 = j;
            break label918;
            label2809:
            localObject1 = paramOnClickListener;
            break label985;
            paramBoolean = false;
            break label1005;
          }
        }
        label2829:
        localObject1 = null;
      }
    }
  }
  
  public static boolean b(final aa.a.a parama)
  {
    AppMethodBeat.i(37461);
    if (parama.pbA != aa.a.b.pbE)
    {
      AppMethodBeat.o(37461);
      return false;
    }
    Object localObject2 = parama.fileName;
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).contains("origin")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).indexOf("origin"));
      }
    }
    localObject1 = ab.Qo((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(37461);
      return false;
    }
    parama = com.tencent.mm.ui.chatting.gallery.d.aeAp;
    parama = com.tencent.mm.ui.chatting.gallery.d.Ai(((z)localObject1).pbc);
    localObject2 = ab.Qo(((z)localObject1).oYk);
    if ((((z)localObject1).status != 112) && (((z)localObject1).status != 104) && (((z)localObject1).status != 103) && (parama == null))
    {
      AppMethodBeat.o(37461);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37457);
        Object localObject = (WeakReference)bk.d.aCw().get(bk.d.this.getFileName());
        if (localObject == null)
        {
          Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[] { bk.d.this.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        localObject = (bk.d)((WeakReference)localObject).get();
        if (localObject == null)
        {
          Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[] { bk.d.this.getFileName() });
          AppMethodBeat.o(37457);
          return;
        }
        ((bk.d)localObject).aeNp.setVisibility(8);
        ((bk.d)localObject).PQu.setVisibility(8);
        ((bk.d)localObject).aeWm.setVisibility(0);
        int i = bk.d.this.status;
        Log.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
        if ((i == 112) || (i == 122) || (i == 120) || ((this.aeWz != null) && ((this.aeWz.status == 120) || (this.aeWz.status == 199)) && (parama != null)))
        {
          if (this.aeWz != null)
          {
            ((bk.d)localObject).PQu.setVisibility(0);
            ((bk.d)localObject).aeWm.setVisibility(8);
            if ((this.aeWz.status == 120) && (((bk.d)localObject).aeWw != null))
            {
              ((bk.d)localObject).aeWw.setVisibility(0);
              ((bk.d)localObject).aeWw.setProgress(ab.h(bk.d.this));
            }
            if (this.aeWz.status == 199)
            {
              com.tencent.mm.ui.chatting.gallery.d locald = com.tencent.mm.ui.chatting.gallery.d.aeAp;
              com.tencent.mm.ui.chatting.gallery.d.Aj(bk.d.this.pbc);
              if ((((bk.d)localObject).aeWw != null) && (((bk.d)localObject).aeWw.getVisibility() == 0))
              {
                ((bk.d)localObject).aeWw.setVisibility(8);
                if (((bk.d)localObject).aeWx != null)
                {
                  ((bk.d)localObject).aeWx.setVisibility(0);
                  ((bk.d)localObject).aeWx.postDelayed(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(255153);
                      this.aeWB.aeWx.setVisibility(8);
                      AppMethodBeat.o(255153);
                    }
                  }, 2000L);
                }
              }
              AppMethodBeat.o(37457);
            }
          }
          else
          {
            ((bk.d)localObject).aeWm.setProgress(ab.g(bk.d.this));
            AppMethodBeat.o(37457);
          }
        }
        else if (ab.bOG())
        {
          ((bk.d)localObject).aeWm.setVisibility(8);
          bk.d.a((bk.d)localObject);
          if ((i != 198) && (((bk.d)localObject).aeWt != null)) {
            ((bk.d)localObject).aeWt.setVisibility(8);
          }
          if (((bk.d)localObject).aeWs != null)
          {
            com.tencent.threadpool.h.ahAA.bm(new bk.d.1..ExternalSyntheticLambda0(bk.d.this, (bk.d)localObject));
            AppMethodBeat.o(37457);
          }
        }
        else
        {
          ((bk.d)localObject).aeWm.setProgress(ab.i(bk.d.this));
        }
        AppMethodBeat.o(37457);
      }
    });
    AppMethodBeat.o(37461);
    return true;
  }
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(37462);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aePK = ((ImageView)paramView.findViewById(R.h.fxz));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.Nnr = ((TextView)paramView.findViewById(R.h.fAd));
    this.aeWl = ((TextView)paramView.findViewById(R.h.fze));
    this.PQu = ((ImageView)paramView.findViewById(R.h.fAk));
    this.aeNp = ((ImageView)paramView.findViewById(R.h.fxD));
    this.aeNq = ((ImageView)paramView.findViewById(R.h.fAl));
    this.aeWm = ((MMPinProgressBtn)paramView.findViewById(R.h.fxH));
    this.aeWn = paramView.findViewById(R.h.fAt);
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.Aoo = ((TextView)paramView.findViewById(R.h.fAx));
    this.aeNh = ((ImageView)paramView.findViewById(R.h.fAw));
    this.TOU = paramView.findViewById(R.h.fAv);
    this.aeWo = ((LinearLayout)paramView.findViewById(R.h.gbu));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.aeRQ = ((ImageView)paramView.findViewById(R.h.fxB));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(R.h.chatting_status_tick);
      this.aeNG = ((ImageView)localObject1);
      if (paramBoolean) {
        break label461;
      }
      localObject1 = (ProgressBar)paramView.findViewById(R.h.fAu);
      label289:
      this.aeWp = ((ProgressBar)localObject1);
      if (paramBoolean) {
        break label466;
      }
      localObject1 = paramView.findViewById(R.h.gbq);
      label306:
      this.aeWq = ((View)localObject1);
      if (!paramBoolean) {
        break label471;
      }
      localObject1 = (ProgressBar)paramView.findViewById(R.h.fzO);
      label326:
      this.aeWr = ((ProgressBar)localObject1);
      if (paramBoolean) {
        break label476;
      }
      localObject1 = (RoundProgressBtn)paramView.findViewById(R.h.fzP);
      label346:
      this.aeWs = ((RoundProgressBtn)localObject1);
      if (paramBoolean) {
        break label481;
      }
      localObject1 = (WeImageView)paramView.findViewById(R.h.fzN);
      label366:
      this.aeWu = ((WeImageView)localObject1);
      if (paramBoolean) {
        break label486;
      }
      localObject1 = (TextView)paramView.findViewById(R.h.fzR);
      label386:
      this.aeWt = ((TextView)localObject1);
      if (paramBoolean) {
        break label491;
      }
      localObject1 = paramView.findViewById(R.h.fzQ);
      label403:
      this.aeWv = ((View)localObject1);
      if (!paramBoolean) {
        break label496;
      }
    }
    label461:
    label466:
    label471:
    label476:
    label481:
    label486:
    label491:
    label496:
    for (Object localObject1 = (RoundProgressBtn)paramView.findViewById(R.h.fzM);; localObject1 = null)
    {
      this.aeWw = ((RoundProgressBtn)localObject1);
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = paramView.findViewById(R.h.fzL);
      }
      this.aeWx = ((View)localObject1);
      AppMethodBeat.o(37462);
      return this;
      localObject1 = null;
      break;
      localObject1 = null;
      break label289;
      localObject1 = null;
      break label306;
      localObject1 = null;
      break label326;
      localObject1 = null;
      break label346;
      localObject1 = null;
      break label366;
      localObject1 = null;
      break label386;
      localObject1 = null;
      break label403;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk.d
 * JD-Core Version:    0.7.0.1
 */