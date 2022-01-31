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
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ak$d
  extends c.a
{
  private static Map<String, WeakReference<d>> vCU = new HashMap();
  private static SparseArray<String> vGm = new SparseArray();
  TextView nhj;
  ImageView oGT;
  ImageView vBN;
  ImageView vBw;
  ImageView vBx;
  TextView vBz;
  ImageView vCQ;
  ImageView vEZ;
  TextView vGh;
  MMPinProgressBtn vGi;
  View vGj;
  ProgressBar vGk;
  View vGl;
  
  public static void a(d paramd, bi parambi, boolean paramBoolean, int paramInt1, com.tencent.mm.ui.chatting.c.a parama, int paramInt2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    Object localObject1 = (String)vGm.get(paramd.hashCode());
    if (localObject1 != null) {
      vCU.remove(localObject1);
    }
    vGm.put(paramd.hashCode(), parambi.field_imgPath);
    vCU.put(parambi.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.oe(parambi.field_imgPath);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new s();
    }
    com.tencent.mm.modelvideo.o.Sr();
    localObject2 = t.nT(parambi.field_imgPath);
    localObject2 = com.tencent.mm.as.o.OJ().a((String)localObject2, com.tencent.mm.cb.a.getDensity(parama.vtz.getContext()), parama.vtz.getContext(), paramInt2);
    paramd.vEZ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
    int i;
    int j;
    if (localObject2 == null)
    {
      i = com.tencent.mm.cb.a.fromDPToPix(parama.vtz.getContext(), 85);
      j = com.tencent.mm.cb.a.aa(parama.vtz.getContext(), R.f.ChatImgLimitWidth);
      localObject2 = com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(parama.vtz.getContext().getResources().getColor(R.e.grey_color_01), i, j), paramInt2, i, j);
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramd.vCQ.setImageDrawable(com.tencent.mm.cb.a.g(parama.vtz.getContext(), R.k.video_no_sd_icon));
        paramd.vCQ.setBackground(new BitmapDrawable((Bitmap)localObject2));
        localObject2 = new FrameLayout.LayoutParams(i, j);
        paramd.vEZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (paramd.vGl != null) {
          paramd.vGl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        label309:
        if (!paramBoolean) {
          break label897;
        }
        paramd.nhj.setText(ah.cm(((s)localObject1).ebK));
        paramd.vGh.setText(ah.jL(((s)localObject1).eHH));
        paramInt2 = ((s)localObject1).status;
        y.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + paramInt2 + " info : " + ((s)localObject1).getFileName());
        if (paramInt2 != 199) {
          break label748;
        }
        paramd.oGT.setImageDrawable(com.tencent.mm.cb.a.g(parama.vtz.getContext(), R.k.shortvideo_play_btn));
        label418:
        if ((paramInt2 != 112) && (paramInt2 != 122) && (paramInt2 != 120)) {
          break label781;
        }
        paramd.vBw.setVisibility(8);
        paramd.oGT.setVisibility(8);
        paramd.vGi.setVisibility(0);
        paramd.vGi.setProgress(u.g((s)localObject1));
        y.v("MicroMsg.VideoItemHoder", "status begin");
        paramd.vGi.invalidate();
      }
    }
    label897:
    for (;;)
    {
      localObject1 = paramd.vBx;
      localObject2 = new ak.e(parambi, parama.cFE(), paramInt1, parambi.field_talker);
      ((ak.e)localObject2).ivk = 4;
      ((ImageView)localObject1).setTag(localObject2);
      paramd.vBx.setOnClickListener(paramOnClickListener);
      localObject1 = paramd.vBw;
      localObject2 = new ak.e(parambi, parama.cFE(), paramInt1, parambi.field_talker);
      ((ak.e)localObject2).ivk = 3;
      ((ImageView)localObject1).setTag(localObject2);
      paramd.vBw.setOnClickListener(paramOnClickListener);
      localObject1 = paramd.igg;
      parambi = new ak.e(parambi, parama.cFE(), paramInt1, parambi.field_talker);
      parambi.ivk = 2;
      ((View)localObject1).setTag(parambi);
      paramd.igg.setOnClickListener(paramOnClickListener);
      paramd.igg.setOnLongClickListener(paramOnLongClickListener);
      paramd.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      return;
      localObject2 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject2, paramInt2, i, j);
      paramd.vCQ.setImageBitmap((Bitmap)localObject2);
      break;
      paramd.vCQ.setImageBitmap((Bitmap)localObject2);
      localObject2 = new FrameLayout.LayoutParams(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      paramd.vEZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (paramd.vGl == null) {
        break label309;
      }
      paramd.vGl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label309;
      label748:
      paramd.oGT.setImageDrawable(com.tencent.mm.cb.a.g(parama.vtz.getContext(), R.k.shortvideo_play_btn));
      paramd.nhj.setVisibility(8);
      break label418;
      label781:
      if ((paramInt2 == 113) || (paramInt2 == 198) || (((s)localObject1).SE()))
      {
        paramd.vBw.setVisibility(0);
        paramd.vBx.setVisibility(8);
        paramd.vGi.setVisibility(8);
        paramd.oGT.setVisibility(0);
        y.v("MicroMsg.VideoItemHoder", "status pause");
      }
      else
      {
        paramd.vBx.setVisibility(8);
        paramd.vBw.setVisibility(8);
        paramd.vGi.setVisibility(8);
        paramd.oGT.setVisibility(0);
        y.v("MicroMsg.VideoItemHoder", "status gone");
        continue;
        paramd.nhj.setText(ah.cm(((s)localObject1).ebK));
        paramd.vGh.setText(ah.jL(((s)localObject1).eHH));
        paramInt2 = ((s)localObject1).status;
        paramd.oGT.setImageDrawable(com.tencent.mm.cb.a.g(parama.vtz.getContext(), R.k.shortvideo_play_btn));
        if (paramd.vGk != null) {
          paramd.vGk.setVisibility(8);
        }
        if (paramd.vGl != null) {
          paramd.vGl.setVisibility(8);
        }
        y.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(paramInt2) });
        if ((paramInt2 == 104) || (paramInt2 == 103))
        {
          if (com.tencent.mm.plugin.mmsight.c.tT(((s)localObject1).eHI))
          {
            if (paramd.vGk != null) {
              paramd.vGk.setVisibility(0);
            }
            if (paramd.vGl != null) {
              paramd.vGl.setVisibility(0);
            }
            paramd.vGh.setText(null);
            paramd.nhj.setText(null);
            paramd.oGT.setImageDrawable(null);
            paramd.vBx.setVisibility(8);
            paramd.vBw.setVisibility(8);
            paramd.vGi.setVisibility(8);
          }
          for (;;)
          {
            y.v("MicroMsg.VideoItemHoder", "status begin");
            break;
            if (paramd.vGk != null) {
              paramd.vGk.setVisibility(8);
            }
            if (paramd.vGl != null) {
              paramd.vGl.setVisibility(8);
            }
            paramd.vBw.setVisibility(8);
            paramd.oGT.setVisibility(8);
            paramd.vGi.setVisibility(0);
            paramd.vGi.setProgress(u.h((s)localObject1));
          }
        }
        if ((paramInt2 == 105) || (paramInt2 == 198) || (((s)localObject1).SE()))
        {
          paramd.vBw.setVisibility(0);
          paramd.vBx.setVisibility(8);
          paramd.vGi.setVisibility(8);
          paramd.oGT.setVisibility(0);
          y.v("MicroMsg.VideoItemHoder", "status pause");
        }
        else if (paramInt2 == 106)
        {
          if (!j.VM(parambi.field_imgPath))
          {
            u.nX(parambi.field_imgPath);
          }
          else
          {
            if (paramd.vGk != null) {
              paramd.vGk.setVisibility(0);
            }
            if (paramd.vGl != null) {
              paramd.vGl.setVisibility(0);
            }
            paramd.vGh.setText(null);
            paramd.nhj.setText(null);
            paramd.oGT.setImageDrawable(null);
            paramd.vBx.setVisibility(8);
            paramd.vBw.setVisibility(8);
            paramd.vGi.setVisibility(8);
          }
        }
        else
        {
          paramd.vBx.setVisibility(8);
          paramd.vBw.setVisibility(8);
          paramd.vGi.setVisibility(8);
          paramd.oGT.setVisibility(0);
          y.v("MicroMsg.VideoItemHoder", "status gone");
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    if (parama.eHX != t.a.b.eIb) {}
    s locals;
    do
    {
      return false;
      locals = u.oe(parama.fileName);
      if (locals == null)
      {
        y.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
        return false;
      }
    } while ((locals.status != 112) && (locals.status != 104) && (locals.status != 103));
    ai.d(new ak.d.1(locals));
    return true;
  }
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vCQ = ((ImageView)paramView.findViewById(R.h.chatting_content_iv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.nhj = ((TextView)paramView.findViewById(R.h.chatting_size_iv));
    this.vGh = ((TextView)paramView.findViewById(R.h.chatting_length_iv));
    this.oGT = ((ImageView)paramView.findViewById(R.h.chatting_status_btn));
    this.vBw = ((ImageView)paramView.findViewById(R.h.chatting_continue_btn));
    this.vBx = ((ImageView)paramView.findViewById(R.h.chatting_stop_btn));
    this.vGi = ((MMPinProgressBtn)paramView.findViewById(R.h.chatting_download_progress));
    this.vGj = paramView.findViewById(R.h.chatting_video_data_area);
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.vEZ = ((ImageView)paramView.findViewById(R.h.chatting_content_mask_iv));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(R.h.chatting_status_tick);
      this.vBN = ((ImageView)localObject1);
      if (paramBoolean) {
        break label276;
      }
    }
    label276:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(R.h.chatting_video_pb);; localObject1 = null)
    {
      this.vGk = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(R.h.uploading_view);
      }
      this.vGl = ((View)localObject1);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.d
 * JD-Core Version:    0.7.0.1
 */