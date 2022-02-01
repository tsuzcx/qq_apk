package com.tencent.mm.plugin.sns.ui;

import android.graphics.Point;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.k.g.a;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements q.a
{
  private ad KCC = null;
  
  public l(ad paramad)
  {
    this.KCC = paramad;
  }
  
  public final void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.KCC.fTn() != null) {
      this.KCC.fTn().fQe();
    }
    if (this.KCC.fTo() != null) {
      this.KCC.fTo().fQe();
    }
    if (this.KCC.fTp() != null) {
      this.KCC.fTp().fTI();
    }
    Object localObject1;
    Object localObject2;
    int n;
    int m;
    int i2;
    int i1;
    int i3;
    View localView;
    Object localObject3;
    int k;
    int j;
    if (this.KCC.fTq() != null)
    {
      this.KCC.fTq().fYj();
      this.KCC.fTq().AJP = true;
      localObject1 = this.KCC.fTq();
      if ((((bx)localObject1).KdE) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((bx)localObject1).KdB != null)
      {
        if ((((bx)localObject1).KdB.getTag() instanceof bx.a))
        {
          ((bx)localObject1).gD(((bx.a)((bx)localObject1).KdB.getTag()).GiP);
          AppMethodBeat.o(97845);
          return;
        }
        ((bx)localObject1).fYj();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((Util.isNullOrNil(paramObject.JVu.Uls)) || (paramObject.JVu.Uls.get(0) == null) || (Util.isNullOrNil(((eju)paramObject.JVu.Uls.get(0)).Md5)))
      {
        Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((bx)localObject1).KdB = new AbsoluteLayout(((bx)localObject1).mContext);
      ((bx)localObject1).KdB.setId(i.f.address);
      ((bx)localObject1).KdB.setOnClickListener(new bx.1((bx)localObject1));
      ((bx)localObject1).KdA.addView(((bx)localObject1).KdB);
      n = aw.fromDPToPix(((bx)localObject1).mContext, 28);
      m = aw.fromDPToPix(((bx)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(((bx)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(((bx)localObject1).mContext, 160.0F);
      i = ax.au(((bx)localObject1).mContext).y;
      i3 = ax.au(((bx)localObject1).mContext).x;
      localView = com.tencent.mm.ui.ad.kS(((bx)localObject1).mContext).inflate(i.g.sns_emoji_info_content, null);
      localView.setOnClickListener(((bx)localObject1).Kdz.Lpv);
      localView.setTag(paramObject);
      localObject3 = bj.hyV().VFH.bxK(((eju)paramObject.JVu.Uls.get(0)).Md5);
      if (localObject3 == null)
      {
        Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(i.f.sns_emoji_info_view)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = h.jp(((bx)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((bx)localObject1).AJP)
      {
        i = a.fromDPToPix(((bx)localObject1).mContext, 2);
        ((bx)localObject1).INC = 0;
      }
      if (((SnsCommentPreloadTextView)localObject2).getLineCount() <= 1) {
        break label950;
      }
      k = (int)((SnsCommentPreloadTextView)localObject2).getTvLayout().getLineWidth(((SnsCommentPreloadTextView)localObject2).getLineCount() - 1);
      int i4 = localObject3[0];
      int i5 = n / 2;
      int i6 = i2 / 2;
      j = ((SnsCommentPreloadTextView)localObject2).getHeight() - n;
      k = k + i4 - i5 - i6;
      if (localObject3[1] >= ax.getStatusBarHeight(((bx)localObject1).mContext) + i1 + ax.ew(((bx)localObject1).mContext)) {
        break label977;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bx)localObject1).INC - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((bx)localObject1).INC = com.tencent.mm.ui.ar.kI(((bx)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new bx.a((bx)localObject1, localView);
      ((bx)localObject1).KdB.setTag(localObject3);
      ((bx)localObject1).KdB.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((bx)localObject1).KdE = true;
      new MMHandler().post(new bx.2((bx)localObject1, paramView, localView));
      paramView = g.Kia;
      long l = y.aYS(paramObject.KCE);
      paramObject = String.valueOf(paramObject.JVu.Uln);
      localObject1 = t.Qu(l);
      paramView = (g.a)paramView.Kin.get(localObject1);
      if ((paramView != null) && (!paramView.KiY.contains(paramObject))) {
        paramView.KiY.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label950:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label977:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bx)localObject1).INC - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */