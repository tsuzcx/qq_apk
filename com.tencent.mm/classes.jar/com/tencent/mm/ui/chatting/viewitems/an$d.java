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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.t.a.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class an$d
  extends c.a
{
  private static Map<String, WeakReference<d>> zTX;
  private static SparseArray<String> zXH;
  TextView pMw;
  ImageView rwJ;
  ImageView zRV;
  ImageView zRW;
  TextView zRY;
  ImageView zSm;
  ImageView zTT;
  ImageView zUt;
  TextView zXC;
  MMPinProgressBtn zXD;
  View zXE;
  ProgressBar zXF;
  View zXG;
  
  static
  {
    AppMethodBeat.i(33354);
    zXH = new SparseArray();
    zTX = new HashMap();
    AppMethodBeat.o(33354);
  }
  
  public static void a(d paramd, bi parambi, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(33353);
    Object localObject1 = (String)zXH.get(paramd.hashCode());
    if (localObject1 != null) {
      zTX.remove(localObject1);
    }
    zXH.put(paramd.hashCode(), parambi.field_imgPath);
    zTX.put(parambi.field_imgPath, new WeakReference(paramd));
    Object localObject2 = u.vr(parambi.field_imgPath);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new s();
    }
    com.tencent.mm.modelvideo.o.alE();
    localObject2 = t.vg(parambi.field_imgPath);
    localObject2 = com.tencent.mm.at.o.ahC().a((String)localObject2, com.tencent.mm.cb.a.getDensity(parama.zJz.getContext()), parama.zJz.getContext(), 2130838228);
    paramd.zUt.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
    int i;
    int j;
    if (localObject2 == null)
    {
      i = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), 85);
      j = com.tencent.mm.cb.a.ao(parama.zJz.getContext(), 2131427520);
      localObject2 = d.a(d.au(parama.zJz.getContext().getResources().getColor(2131690155), i, j), 2130838228, i, j);
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramd.zTT.setImageDrawable(com.tencent.mm.cb.a.k(parama.zJz.getContext(), 2131232157));
        paramd.zTT.setBackground(new BitmapDrawable((Bitmap)localObject2));
        localObject2 = new FrameLayout.LayoutParams(i, j);
        paramd.zUt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (paramd.zXG != null) {
          paramd.zXG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        label311:
        if (!paramBoolean) {
          break label904;
        }
        paramd.pMw.setText(ah.hk(((s)localObject1).fsd));
        paramd.zXC.setText(ah.mH(((s)localObject1).fXx));
        i = ((s)localObject1).status;
        ab.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i + " info : " + ((s)localObject1).getFileName());
        if (i != 199) {
          break label755;
        }
        paramd.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(parama.zJz.getContext(), 2131231980));
        label420:
        if ((i != 112) && (i != 122) && (i != 120)) {
          break label788;
        }
        paramd.zRV.setVisibility(8);
        paramd.rwJ.setVisibility(8);
        paramd.zXD.setVisibility(0);
        paramd.zXD.setProgress(u.g((s)localObject1));
        ab.v("MicroMsg.VideoItemHoder", "status begin");
        paramd.zXD.invalidate();
      }
    }
    label904:
    for (;;)
    {
      localObject1 = paramd.zRW;
      localObject2 = new an.e(parambi, parama.dJG(), paramInt, parambi.field_talker);
      ((an.e)localObject2).kwo = 4;
      ((ImageView)localObject1).setTag(localObject2);
      paramd.zRW.setOnClickListener(paramOnClickListener);
      localObject1 = paramd.zRV;
      localObject2 = new an.e(parambi, parama.dJG(), paramInt, parambi.field_talker);
      ((an.e)localObject2).kwo = 3;
      ((ImageView)localObject1).setTag(localObject2);
      paramd.zRV.setOnClickListener(paramOnClickListener);
      localObject1 = paramd.jYu;
      parambi = new an.e(parambi, parama.dJG(), paramInt, parambi.field_talker);
      parambi.kwo = 2;
      ((View)localObject1).setTag(parambi);
      paramd.jYu.setOnClickListener(paramOnClickListener);
      paramd.jYu.setOnLongClickListener(paramOnLongClickListener);
      paramd.jYu.setOnTouchListener(((h)parama.ay(h.class)).dHi());
      AppMethodBeat.o(33353);
      return;
      localObject2 = d.a((Bitmap)localObject2, 2130838228, i, j);
      paramd.zTT.setImageBitmap((Bitmap)localObject2);
      break;
      paramd.zTT.setImageBitmap((Bitmap)localObject2);
      localObject2 = new FrameLayout.LayoutParams(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      paramd.zUt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (paramd.zXG == null) {
        break label311;
      }
      paramd.zXG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label311;
      label755:
      paramd.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(parama.zJz.getContext(), 2131231980));
      paramd.pMw.setVisibility(8);
      break label420;
      label788:
      if ((i == 113) || (i == 198) || (((s)localObject1).alQ()))
      {
        paramd.zRV.setVisibility(0);
        paramd.zRW.setVisibility(8);
        paramd.zXD.setVisibility(8);
        paramd.rwJ.setVisibility(0);
        ab.v("MicroMsg.VideoItemHoder", "status pause");
      }
      else
      {
        paramd.zRW.setVisibility(8);
        paramd.zRV.setVisibility(8);
        paramd.zXD.setVisibility(8);
        paramd.rwJ.setVisibility(0);
        ab.v("MicroMsg.VideoItemHoder", "status gone");
        continue;
        paramd.pMw.setText(ah.hk(((s)localObject1).fsd));
        paramd.zXC.setText(ah.mH(((s)localObject1).fXx));
        i = ((s)localObject1).status;
        paramd.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(parama.zJz.getContext(), 2131231980));
        if (paramd.zXF != null) {
          paramd.zXF.setVisibility(8);
        }
        if (paramd.zXG != null) {
          paramd.zXG.setVisibility(8);
        }
        ab.v("MicroMsg.VideoItemHoder", "video status %d", new Object[] { Integer.valueOf(i) });
        if ((i == 104) || (i == 103))
        {
          if (com.tencent.mm.plugin.mmsight.c.zm(((s)localObject1).fXy))
          {
            if (paramd.zXF != null) {
              paramd.zXF.setVisibility(0);
            }
            if (paramd.zXG != null) {
              paramd.zXG.setVisibility(0);
            }
            paramd.zXC.setText(null);
            paramd.pMw.setText(null);
            paramd.rwJ.setImageDrawable(null);
            paramd.zRW.setVisibility(8);
            paramd.zRV.setVisibility(8);
            paramd.zXD.setVisibility(8);
          }
          for (;;)
          {
            ab.v("MicroMsg.VideoItemHoder", "status begin");
            break;
            if (paramd.zXF != null) {
              paramd.zXF.setVisibility(8);
            }
            if (paramd.zXG != null) {
              paramd.zXG.setVisibility(8);
            }
            paramd.zRV.setVisibility(8);
            paramd.rwJ.setVisibility(8);
            paramd.zXD.setVisibility(0);
            paramd.zXD.setProgress(u.h((s)localObject1));
          }
        }
        if ((i == 105) || (i == 198) || (((s)localObject1).alQ()))
        {
          paramd.zRV.setVisibility(0);
          paramd.zRW.setVisibility(8);
          paramd.zXD.setVisibility(8);
          paramd.rwJ.setVisibility(0);
          ab.v("MicroMsg.VideoItemHoder", "status pause");
        }
        else if (i == 106)
        {
          if (!j.alk(parambi.field_imgPath))
          {
            u.vk(parambi.field_imgPath);
          }
          else
          {
            if (paramd.zXF != null) {
              paramd.zXF.setVisibility(0);
            }
            if (paramd.zXG != null) {
              paramd.zXG.setVisibility(0);
            }
            paramd.zXC.setText(null);
            paramd.pMw.setText(null);
            paramd.rwJ.setImageDrawable(null);
            paramd.zRW.setVisibility(8);
            paramd.zRV.setVisibility(8);
            paramd.zXD.setVisibility(8);
          }
        }
        else
        {
          paramd.zRW.setVisibility(8);
          paramd.zRV.setVisibility(8);
          paramd.zXD.setVisibility(8);
          paramd.rwJ.setVisibility(0);
          ab.v("MicroMsg.VideoItemHoder", "status gone");
        }
      }
    }
  }
  
  public static boolean b(t.a.a parama)
  {
    AppMethodBeat.i(33351);
    if (parama.fXN != t.a.b.fXR)
    {
      AppMethodBeat.o(33351);
      return false;
    }
    s locals = u.vr(parama.fileName);
    if (locals == null)
    {
      ab.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[] { parama.fileName });
      AppMethodBeat.o(33351);
      return false;
    }
    if ((locals.status != 112) && (locals.status != 104) && (locals.status != 103))
    {
      AppMethodBeat.o(33351);
      return false;
    }
    al.d(new an.d.1(locals));
    AppMethodBeat.o(33351);
    return true;
  }
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(33352);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zTT = ((ImageView)paramView.findViewById(2131822642));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.pMw = ((TextView)paramView.findViewById(2131822644));
    this.zXC = ((TextView)paramView.findViewById(2131822688));
    this.rwJ = ((ImageView)paramView.findViewById(2131822645));
    this.zRV = ((ImageView)paramView.findViewById(2131822620));
    this.zRW = ((ImageView)paramView.findViewById(2131822619));
    this.zXD = ((MMPinProgressBtn)paramView.findViewById(2131822643));
    this.zXE = paramView.findViewById(2131822687);
    this.jYu = paramView.findViewById(2131822580);
    this.zRY = ((TextView)paramView.findViewById(2131822518));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.zUt = ((ImageView)paramView.findViewById(2131822646));
    if (!paramBoolean)
    {
      localObject1 = (ImageView)paramView.findViewById(2131822729);
      this.zSm = ((ImageView)localObject1);
      if (paramBoolean) {
        break label288;
      }
    }
    label288:
    for (Object localObject1 = (ProgressBar)paramView.findViewById(2131822737);; localObject1 = null)
    {
      this.zXF = ((ProgressBar)localObject1);
      localObject1 = localObject2;
      if (!paramBoolean) {
        localObject1 = paramView.findViewById(2131822682);
      }
      this.zXG = ((View)localObject1);
      AppMethodBeat.o(33352);
      return this;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.d
 * JD-Core Version:    0.7.0.1
 */